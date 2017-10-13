package com.getpebble.android.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.b.am;
import com.getpebble.android.h.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class s extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("contacts");

    public static class a extends ContentObserver {
        public static Uri a = Contacts.CONTENT_URI;
        private static final long b = TimeUnit.MINUTES.toMillis(1);
        private final Handler c;
        private boolean d = false;
        private final Runnable e = new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void run() {
                f.d("ContactsDataModel", "mOnChangeRunnable()");
                this.a.d = false;
                ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
                Cursor query = contentResolver.query(s.a, null, null, null, null);
                if (query == null) {
                    f.f("ContactsDataModel", "ContentObserver: onChange() table cursor is null");
                    return;
                }
                while (query.moveToNext()) {
                    b a = b.a(query);
                    if (a.d != null) {
                        Cursor query2;
                        try {
                            query2 = contentResolver.query(Uri.withAppendedPath(Contacts.CONTENT_LOOKUP_URI, a.d), null, null, null, null);
                            if (query2 == null) {
                                continue;
                            } else if (query2.moveToFirst()) {
                                String string = query2.getString(query2.getColumnIndex("display_name"));
                                if (!com.getpebble.android.common.b.b.a.a(a.e, string)) {
                                    s.b(contentResolver, a.c, a.d, string, a.f);
                                }
                                query2.close();
                            } else {
                                query2.close();
                            }
                        } catch (Throwable e) {
                            f.f("ContactsDataModel", "Error querying contacts from ContentObserver callback", e);
                        } catch (Throwable th) {
                            query.close();
                        }
                    }
                }
                query.close();
                aq.b(contentResolver);
            }
        };

        public a(Handler handler) {
            super(handler);
            this.c = handler;
        }

        public boolean deliverSelfNotifications() {
            return false;
        }

        public void onChange(boolean z) {
            onChange(z, null);
        }

        public void onChange(boolean z, Uri uri) {
            f.d("ContactsDataModel", "ContentObserver: onChange() uri = " + uri);
            if (!v.a(com.getpebble.android.h.v.a.CONTACTS)) {
                v.a("ContactsDataModel", com.getpebble.android.h.v.a.CONTACTS, "ContentObserver: onChange()");
            } else if (!this.d) {
                this.d = true;
                this.c.postDelayed(this.e, b);
            }
        }
    }

    public static class b implements com.getpebble.android.common.model.ai.b, com.getpebble.android.framework.g.e.b {
        public final Integer a;
        public final Integer b;
        public final UUID c;
        public final String d;
        public final String e;
        public final int f;

        public b(UUID uuid, String str, String str2, int i) {
            this.c = uuid;
            this.d = str;
            this.e = str2;
            this.f = i;
            this.b = null;
            this.a = Integer.valueOf(hashCode());
        }

        b(Cursor cursor, boolean z) {
            Integer valueOf;
            this.c = UUID.fromString(cursor.getString(cursor.getColumnIndex("contact_uuid")));
            this.d = cursor.getString(cursor.getColumnIndex("lookup"));
            this.e = cursor.getString(cursor.getColumnIndex("display_name"));
            this.f = cursor.getInt(cursor.getColumnIndex("flags"));
            this.b = a(cursor, "pebble_sync_hashcode");
            if (z) {
                valueOf = Integer.valueOf(hashCode());
            } else {
                valueOf = a(cursor, "record_hashcode");
            }
            this.a = valueOf;
        }

        static b a(Cursor cursor) {
            return new b(cursor, false);
        }

        static b b() {
            return new b(UUID.randomUUID(), null, s.a(), 0);
        }

        private static Integer a(Cursor cursor, String str) {
            String string = cursor.getString(cursor.getColumnIndex(str));
            return (string == null || string.equals("removed")) ? null : Integer.decode(string);
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues(6);
            if (TextUtils.isEmpty(this.d)) {
                contentValues.putNull("lookup");
            } else {
                contentValues.put("lookup", this.d);
            }
            contentValues.put("display_name", this.e);
            contentValues.put("flags", Integer.valueOf(this.f));
            contentValues.put("contact_uuid", this.c.toString());
            if (this.a == null) {
                contentValues.put("record_hashcode", "removed");
            } else {
                contentValues.put("record_hashcode", this.a);
            }
            if (this.b == null) {
                contentValues.put("pebble_sync_hashcode", "removed");
            } else {
                contentValues.put("pebble_sync_hashcode", this.b);
            }
            return contentValues;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.d != null ? this.d.hashCode() : 0) + (this.c.hashCode() * 31)) * 31;
            if (this.e != null) {
                i = this.e.hashCode();
            }
            hashCode = ((hashCode + i) * 31) + this.f;
            Context K = com.getpebble.android.common.a.K();
            if (K == null) {
                return hashCode;
            }
            i = hashCode;
            for (com.getpebble.android.common.model.aq.a aVar : aq.b(K.getContentResolver(), this.c)) {
                i = aVar.d.hashCode() + (i * 31);
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.c.equals(bVar.c) && TextUtils.equals(this.d, bVar.d) && this.f == bVar.f) {
                return com.getpebble.android.common.b.b.a.a(this.e, bVar.e);
            }
            return false;
        }

        public String toString() {
            return "Record{uuid='" + this.c + '\'' + ", lookup='" + this.d + '\'' + ", name='" + this.e + '\'' + ", flags=" + Integer.toHexString(this.f) + ", recordHashcode=" + this.a + ", pebbleSyncHashcode=" + this.b + "}";
        }

        public boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (!z) {
                return false;
            }
            String str = "contact_uuid = ?";
            String[] strArr = new String[]{this.c.toString()};
            if (b(aVar)) {
                aq.a(contentResolver, this.c);
                if (contentResolver.delete(s.a, "contact_uuid = ?", strArr) <= 0) {
                    return false;
                }
                return true;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("pebble_sync_hashcode", this.a);
            if (contentResolver.update(s.a, contentValues, "contact_uuid = ?", strArr) <= 0) {
                return false;
            }
            return true;
        }

        public boolean a(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return (this.a == null || this.a.equals(this.b)) ? false : true;
        }

        public boolean b(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return this.a == null && this.b != null;
        }

        public byte[] c() {
            return com.getpebble.android.bluetooth.b.b.a(this.c);
        }

        public Integer d() {
            return this.a;
        }

        public byte[] a(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar, z zVar) {
            return am.a(this).a();
        }

        public com.getpebble.android.framework.l.b.j.b e() {
            return com.getpebble.android.framework.l.b.j.b.CONTACTS;
        }
    }

    public s() {
        super("contacts");
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "contact_uuid");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "lookup"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "display_name"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "flags"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "record_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "pebble_sync_hashcode"));
    }

    static String a() {
        return com.getpebble.android.common.a.K().getResources().getString(R.string.unknown_contact);
    }

    public static void a(String str, String str2, int i, String str3, int i2) {
        aq.a(a(com.getpebble.android.common.a.K().getContentResolver(), UUID.randomUUID(), str, str2, 0), str3, i, i2);
    }

    public static b a(ContentResolver contentResolver, String str) {
        return a(contentResolver, "lookup" + (TextUtils.isEmpty(str) ? " is NULL" : " = ?"), TextUtils.isEmpty(str) ? null : new String[]{str});
    }

    public static b a(ContentResolver contentResolver, UUID uuid) {
        String str = "contact_uuid = ?";
        return a(contentResolver, "contact_uuid = ?", new String[]{uuid.toString()});
    }

    public static b a(ContentResolver contentResolver, String str, String[] strArr) {
        b bVar = null;
        Cursor query = contentResolver.query(a, null, str, strArr, null);
        if (query == null) {
            f.f("ContactsDataModel", "getLocalRecord: cursor is null");
        } else {
            try {
                if (query.moveToFirst()) {
                    bVar = b.a(query);
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return bVar;
    }

    public static b a(ContentResolver contentResolver, UUID uuid, String str, String str2, int i) {
        b a = a(contentResolver, str);
        if (a == null) {
            Object bVar = new b(uuid, str, str2, i);
            f.d("ContactsDataModel", "insertRecordIfApplicable: record=" + com.getpebble.android.common.b.b.a.a(bVar));
            contentResolver.insert(a, bVar.a());
            return bVar;
        }
        f.b("ContactsDataModel", "insertRecordIfApplicable: contact is already added");
        return a;
    }

    public static void b(ContentResolver contentResolver, UUID uuid, String str, String str2, int i) {
        Object a = new b(uuid, str, str2, i).a();
        f.d("ContactsDataModel", "updateRecord: values=" + com.getpebble.android.common.b.b.a.a(a));
        contentResolver.update(a, a, "contact_uuid = ?", new String[]{uuid.toString()});
    }

    public static Set<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver) {
        Cursor query = contentResolver.query(a, null, null, null, null);
        if (query == null) {
            f.f("ContactsDataModel", "getDirtyRecords() cursor is null");
            return Collections.emptySet();
        }
        try {
            Set<com.getpebble.android.framework.g.e.b> hashSet = new HashSet(query.getCount());
            while (query.moveToNext()) {
                b bVar = new b(query, true);
                if (bVar.a(null) || bVar.b(null)) {
                    hashSet.add(bVar);
                }
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    public static int b(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pebble_sync_hashcode", "removed");
        return contentResolver.update(a, contentValues, null, null);
    }

    public static void a(ContentResolver contentResolver, int i) {
        Throwable e;
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, new String[]{"contact_uuid"}, "record_hashcode!=?", new String[]{"removed"}, null);
        if (query == null) {
            f.f("ContactsDataModel", "purgeUnusedContacts cursor is null");
            return;
        }
        Set<UUID> hashSet = new HashSet();
        try {
            if (query.getCount() <= i) {
                f.d("ContactsDataModel", "purgeUnusedContacts count is not at max, count=" + query.getCount());
                return;
            }
            while (query.moveToNext()) {
                hashSet.add(UUID.fromString(query.getString(query.getColumnIndex("contact_uuid"))));
            }
            query.close();
            for (com.getpebble.android.common.model.aq.a aVar : aq.a(contentResolver)) {
                hashSet.remove(aVar.a.c);
            }
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("record_hashcode", "removed");
            ArrayList arrayList = new ArrayList();
            f.d("ContactsDataModel", "purgeUnusedContacts purging: " + hashSet);
            for (UUID uuid : hashSet) {
                arrayList.add(ContentProviderOperation.newUpdate(a).withSelection("contact_uuid = ?", new String[]{uuid.toString()}).withValues(contentValues).withExpectedCount(1).build());
            }
            try {
                contentResolver.applyBatch("com.getpebble.android.basalt.internal.provider", arrayList);
            } catch (OperationApplicationException e2) {
                e = e2;
                f.d("ContactsDataModel", "purgeUnusedContacts() error marking records for removal", e);
            } catch (RemoteException e3) {
                e = e3;
                f.d("ContactsDataModel", "purgeUnusedContacts() error marking records for removal", e);
            }
        } finally {
            query.close();
        }
    }

    public static void c(ContentResolver contentResolver) {
        if (v.a(com.getpebble.android.h.v.a.CONTACTS)) {
            String str = "has_phone_number = 1 AND last_time_contacted != 0";
            str = "last_time_contacted DESC LIMIT 10";
            ContentResolver contentResolver2 = contentResolver;
            Cursor query = contentResolver2.query(Contacts.CONTENT_URI, new String[]{"lookup", "display_name", "last_time_contacted"}, "has_phone_number = 1 AND last_time_contacted != 0", null, "last_time_contacted DESC LIMIT 10");
            if (query == null) {
                f.b("ContactsDataModel", "initializeContacts() contacts cursor is null");
                return;
            }
            while (query.moveToNext()) {
                try {
                    str = query.getString(query.getColumnIndex("display_name"));
                    String string = query.getString(query.getColumnIndex("lookup"));
                    aq.a(contentResolver, a(contentResolver, UUID.randomUUID(), string, str, 0), query.getLong(query.getColumnIndex("last_time_contacted")));
                } finally {
                    query.close();
                }
            }
            at.a();
            return;
        }
        v.a("ContactsDataModel", com.getpebble.android.h.v.a.CONTACTS, "initializeContacts");
    }
}
