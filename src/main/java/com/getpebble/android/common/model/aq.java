package com.getpebble.android.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.PhoneLookup;
import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.h.v;
import com.getpebble.android.h.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class aq extends ai {
    public static final Uri a = b.a("phone_numbers");
    public static final Uri b = Uri.withAppendedPath(a, "phone_number");
    static final String[] c = new String[]{"type", "display_name", "lookup"};

    public static class a {
        public final s.b a;
        public final UUID b;
        public final int c;
        public final String d;
        public final Integer e;
        public final Long f;

        public a(s.b bVar, String str, int i, Integer num, Long l) {
            this.b = UUID.randomUUID();
            this.a = bVar;
            this.d = str;
            this.c = i;
            this.e = num;
            this.f = l;
        }

        a(Cursor cursor) {
            Integer num;
            Long l = null;
            this.b = UUID.fromString(cursor.getString(cursor.getColumnIndex("phone_uuid")));
            this.a = s.a(com.getpebble.android.common.a.K().getContentResolver(), UUID.fromString(cursor.getString(cursor.getColumnIndex("contact_uuid"))));
            this.d = cursor.getString(cursor.getColumnIndex(an.NUMBER));
            this.c = cursor.getInt(cursor.getColumnIndex("type"));
            if (cursor.isNull(cursor.getColumnIndex("fave_order"))) {
                num = null;
            } else {
                num = Integer.valueOf(cursor.getInt(cursor.getColumnIndex("fave_order")));
            }
            this.e = num;
            if (!cursor.isNull(cursor.getColumnIndex("last_messaged_timestamp"))) {
                l = Long.valueOf(cursor.getLong(cursor.getColumnIndex("last_messaged_timestamp")));
            }
            this.f = l;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
            r4 = this;
            r0 = 1;
            r1 = 0;
            if (r4 != r5) goto L_0x0005;
        L_0x0004:
            return r0;
        L_0x0005:
            if (r5 == 0) goto L_0x0011;
        L_0x0007:
            r2 = r4.getClass();
            r3 = r5.getClass();
            if (r2 == r3) goto L_0x0013;
        L_0x0011:
            r0 = r1;
            goto L_0x0004;
        L_0x0013:
            r5 = (com.getpebble.android.common.model.aq.a) r5;
            r2 = r4.c;
            r3 = r5.c;
            if (r2 != r3) goto L_0x003f;
        L_0x001b:
            r2 = r4.e;
            if (r2 != 0) goto L_0x0041;
        L_0x001f:
            r2 = r5.e;
            if (r2 != 0) goto L_0x003f;
        L_0x0023:
            r2 = r4.f;
            if (r2 != 0) goto L_0x004c;
        L_0x0027:
            r2 = r5.f;
            if (r2 != 0) goto L_0x003f;
        L_0x002b:
            r2 = r4.a;
            r3 = r5.a;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x003f;
        L_0x0035:
            r2 = r4.d;
            r3 = r5.d;
            r2 = r2.equals(r3);
            if (r2 != 0) goto L_0x0004;
        L_0x003f:
            r0 = r1;
            goto L_0x0004;
        L_0x0041:
            r2 = r4.e;
            r3 = r5.e;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x003f;
        L_0x004b:
            goto L_0x0023;
        L_0x004c:
            r2 = r4.f;
            r3 = r5.f;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x003f;
        L_0x0056:
            goto L_0x002b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.common.model.aq.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode;
            int i = 0;
            int hashCode2 = ((((((this.b.hashCode() * 31) + this.a.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
            if (this.e != null) {
                hashCode = this.e.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode = (hashCode + hashCode2) * 31;
            if (this.f != null) {
                i = this.f.hashCode();
            }
            return hashCode + i;
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues(8);
            contentValues.put("phone_uuid", this.b.toString());
            contentValues.put("contact_uuid", this.a.c.toString());
            contentValues.put(an.NUMBER, this.d);
            contentValues.put("type", Integer.valueOf(this.c));
            contentValues.put("fave_order", this.e);
            contentValues.put("last_messaged_timestamp", this.f);
            return contentValues;
        }

        public String toString() {
            return "Record{uuid=" + this.b + ", contact=" + this.a + ", number=" + this.d + ", type=" + this.c + ", order=" + this.e + ", lastMessageTimestamp=" + this.f;
        }

        String[] b() {
            return new String[]{this.b.toString()};
        }
    }

    static void b(android.content.ContentResolver r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:31:0x00ad in {6, 20, 22, 24, 27, 30, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = 1;
        r1 = 0;
        r2 = 0;
        r0 = "type = ?";
        r4 = new java.lang.String[r3];
        r0 = -1;
        r0 = java.lang.String.valueOf(r0);
        r4[r1] = r0;
        r0 = 3;
        r6 = new java.lang.String[r0];
        r0 = "type";
        r6[r1] = r0;
        r0 = "display_name";
        r6[r3] = r0;
        r0 = 2;
        r1 = "lookup";
        r6[r0] = r1;
        r1 = a;
        r3 = "type = ?";
        r0 = r9;
        r5 = r2;
        r7 = r0.query(r1, r2, r3, r4, r5);
        if (r7 != 0) goto L_0x007b;
    L_0x002a:
        r0 = "PhoneNumberDataModel";
        r1 = "handleContactChange() cursor is null";
        com.getpebble.android.common.b.a.f.f(r0, r1);
    L_0x0031:
        return;
    L_0x0032:
        r0 = r1.moveToFirst();	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        if (r0 == 0) goto L_0x0078;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
    L_0x0038:
        r0 = "PhoneNumberDataModel";	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = "handleContactChange: previously Unknown contact has been added to Android Contacts";	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        com.getpebble.android.common.b.a.f.c(r0, r2);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r0 = r8.a();	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = "type";	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = r1.getColumnIndex(r2);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = r1.getInt(r2);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r3 = "type";	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r0.put(r3, r2);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        a(r9, r8, r0);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r0 = "display_name";	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r0 = r1.getColumnIndex(r0);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r0 = r1.getString(r0);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = "lookup";	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = r1.getColumnIndex(r2);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = r1.getString(r2);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r3 = r8.a;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r3 = r3.c;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r4 = r8.a;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r4 = r4.f;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        com.getpebble.android.common.model.s.b(r9, r3, r2, r0, r4);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
    L_0x0078:
        r1.close();
    L_0x007b:
        r0 = r7.moveToNext();	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        if (r0 == 0) goto L_0x00b7;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
    L_0x0081:
        r8 = new com.getpebble.android.common.model.aq$a;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r8.<init>(r7);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r1 = r8.d;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r1 = android.net.Uri.encode(r1);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r1 = android.net.Uri.withAppendedPath(r0, r1);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r3 = 0;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r4 = 0;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r5 = 0;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r0 = r9;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r2 = r6;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        if (r1 != 0) goto L_0x0032;
    L_0x009d:
        r7.close();
        goto L_0x0031;
    L_0x00a1:
        r0 = move-exception;
        r2 = "PhoneNumberDataModel";	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r3 = "handleContactChange";	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        com.getpebble.android.common.b.a.f.b(r2, r3, r0);	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        r1.close();
        goto L_0x007b;
    L_0x00ad:
        r0 = move-exception;
        r7.close();
        throw r0;
    L_0x00b2:
        r0 = move-exception;
        r1.close();	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
        throw r0;	 Catch:{ IllegalStateException -> 0x00a1, all -> 0x00b2, all -> 0x00ad }
    L_0x00b7:
        r7.close();
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.common.model.aq.b(android.content.ContentResolver):void");
    }

    public aq() {
        super("phone_numbers");
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "phone_uuid");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "contact_uuid"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "type"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, an.NUMBER));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "fave_order"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.TIMESTAMP, "last_messaged_timestamp"));
    }

    static boolean a(ContentResolver contentResolver, a aVar, ContentValues contentValues) {
        f.d("PhoneNumberDataModel", "updateRecord: contentValues=" + com.getpebble.android.common.b.b.a.a((Object) contentValues));
        return contentResolver.update(a, contentValues, "phone_uuid = ?", aVar.b()) > 0;
    }

    static a a(ContentResolver contentResolver, a aVar) {
        if (TextUtils.isEmpty(aVar.d)) {
            f.b("PhoneNumberDataModel", "insertRecordIfApplicable() phoneNumber is null");
            return null;
        }
        a a = a(contentResolver, aVar.d);
        if (a != null) {
            f.b("PhoneNumberDataModel", "insertRecordIfApplicable: the phone number for this contact is already in the db");
            return a;
        }
        f.d("PhoneNumberDataModel", "insertRecordIfApplicable: insert record = " + com.getpebble.android.common.b.b.a.a((Object) aVar));
        contentResolver.insert(a, aVar.a());
        return aVar;
    }

    static a a(ContentResolver contentResolver, String str) {
        a aVar = null;
        if (TextUtils.isEmpty(str)) {
            f.b("PhoneNumberDataModel", "lookupLocalRecordByPhoneNumber() phoneNumber is null");
        } else {
            Cursor query = contentResolver.query(a(str), null, null, null, null);
            if (query == null) {
                f.f("PhoneNumberDataModel", "lookupLocalRecordByPhoneNumber() cursor is null");
            } else {
                try {
                    if (query.moveToFirst()) {
                        aVar = new a(query);
                    }
                    query.close();
                } catch (Throwable th) {
                    query.close();
                }
            }
        }
        return aVar;
    }

    public static void a(s.b bVar, String str, int i, int i2) {
        ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
        a a = a(contentResolver, new a(bVar, str, i, Integer.valueOf(i2), null));
        ContentValues a2 = a.a();
        a2.put("fave_order", Integer.valueOf(i2));
        a2.put("type", Integer.valueOf(i));
        a(contentResolver, a, a2);
    }

    public static void a(ContentResolver contentResolver, UUID uuid) {
        String str = "contact_uuid = ?";
        contentResolver.delete(a, "contact_uuid = ?", new String[]{uuid.toString()});
    }

    public static int b(ContentResolver contentResolver, String str) {
        if (!TextUtils.isEmpty(str)) {
            return contentResolver.delete(a(str), null, null);
        }
        f.b("PhoneNumberDataModel", "deleteRecordsForPhone() phoneNumber is null");
        return 0;
    }

    private static Uri a(String str) {
        return Uri.withAppendedPath(b, Uri.encode(str));
    }

    public static boolean b(ContentResolver contentResolver, a aVar) {
        f.d("PhoneNumberDataModel", "removeFave: " + com.getpebble.android.common.b.b.a.a((Object) aVar));
        ContentValues contentValues = new ContentValues(1);
        contentValues.putNull("fave_order");
        if (contentResolver.update(a, contentValues, "phone_uuid = ?", aVar.b()) > 0) {
            return true;
        }
        return false;
    }

    public static void a(ContentResolver contentResolver, List<a> list) {
        Throwable e;
        f.d("PhoneNumberDataModel", "handleFaveReorder()");
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            a aVar = (a) list.get(i);
            if (aVar.e.intValue() != i) {
                arrayList.add(ContentProviderOperation.newUpdate(a).withSelection("phone_uuid = ?", aVar.b()).withValues(aVar.a()).withValue("fave_order", Integer.valueOf(i)).build());
            }
        }
        if (!arrayList.isEmpty()) {
            try {
                contentResolver.applyBatch("com.getpebble.android.basalt.internal.provider", arrayList);
            } catch (RemoteException e2) {
                e = e2;
                f.b("PhoneNumberDataModel", "handleFaveReorder() Error doing batch update", e);
            } catch (OperationApplicationException e3) {
                e = e3;
                f.b("PhoneNumberDataModel", "handleFaveReorder() Error doing batch update", e);
            }
        }
    }

    public static CursorLoader a(Context context) {
        String str = "fave_order IS NOT NULL";
        str = "fave_order ASC LIMIT 5";
        return new CursorLoader(context, a, null, "fave_order IS NOT NULL", null, "fave_order ASC LIMIT 5");
    }

    public static List<a> a(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, null, "fave_order IS NOT NULL OR last_messaged_timestamp IS NOT NULL", null, "CASE WHEN fave_order IS NULL THEN 1 ELSE 0 END, fave_order ASC, last_messaged_timestamp DESC LIMIT 10");
        if (query == null) {
            return new ArrayList();
        }
        try {
            List<a> a = a(query);
            return a;
        } finally {
            query.close();
        }
    }

    public static List<a> b(ContentResolver contentResolver, UUID uuid) {
        String[] strArr = new String[]{uuid.toString()};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, null, "contact_uuid = ? AND (fave_order IS NOT NULL OR last_messaged_timestamp IS NOT NULL)", strArr, "phone_uuid");
        if (query == null) {
            f.f("PhoneNumberDataModel", "getRecordsForContact() cursor is null");
            return new ArrayList();
        }
        try {
            List<a> a = a(query);
            return a;
        } finally {
            query.close();
        }
    }

    public static List<a> a(Cursor cursor) {
        List<a> arrayList = new ArrayList(cursor.getCount());
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            arrayList.add(new a(cursor));
        }
        return arrayList;
    }

    public static CursorLoader b(Context context) {
        String[] strArr = new String[]{an.NUMBER};
        return new CursorLoader(context, a, strArr, "fave_order IS NOT NULL", null, null);
    }

    public static Set<String> b(Cursor cursor) {
        Set<String> hashSet = new HashSet();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            hashSet.add(cursor.getString(cursor.getColumnIndex(an.NUMBER)));
        }
        return hashSet;
    }

    public static List<a> a(ContentResolver contentResolver, s.b bVar) {
        String[] strArr = new String[]{bVar.c.toString()};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, null, "contact_uuid = ?", strArr, null);
        if (query == null) {
            return new ArrayList();
        }
        try {
            List<a> a = a(query);
            return a;
        } finally {
            query.close();
        }
    }

    public static void a(ContentResolver contentResolver, String str, long j) {
        if (TextUtils.isEmpty(str)) {
            f.b("PhoneNumberDataModel", "setRecentRecord() phoneNumber is null");
            return;
        }
        a a = a(contentResolver, str);
        if (a != null && (a.f == null || a.f.longValue() < j)) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("last_messaged_timestamp", Long.valueOf(j));
            a(contentResolver, a, contentValues);
        } else if (a == null) {
            if (v.a(com.getpebble.android.h.v.a.CONTACTS)) {
                b(contentResolver, str, j);
            } else {
                v.a("PhoneNumberDataModel", com.getpebble.android.h.v.a.CONTACTS, "setRecentRecord");
                return;
            }
        }
        s.a(contentResolver, 10);
        at.a();
    }

    static a b(ContentResolver contentResolver, String str, long j) {
        a aVar = null;
        if (TextUtils.isEmpty(str)) {
            f.b("PhoneNumberDataModel", "insertNewRecord() phoneNumber is null");
        } else {
            a aVar2;
            Cursor query = contentResolver.query(Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), c, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("lookup"));
                        String string2 = query.getString(query.getColumnIndex("display_name"));
                        String str2 = str;
                        aVar2 = new a(s.a(contentResolver, UUID.randomUUID(), string, string2, 0), str2, query.getInt(query.getColumnIndex("type")), null, Long.valueOf(j));
                        aVar = a(contentResolver, aVar2);
                        if (query != null) {
                            query.close();
                        }
                    }
                } catch (Throwable e) {
                    f.a("PhoneNumberDataModel", "insertNewRecord: Error inserting", e);
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            s.b b = s.b.b();
            aVar2 = new a(s.a(contentResolver, b.c, b.d, b.e, b.f), str, -1, null, Long.valueOf(j));
            aVar = a(contentResolver, aVar2);
            if (query != null) {
                query.close();
            }
        }
        return aVar;
    }

    public static void a(ContentResolver contentResolver, s.b bVar, long j) {
        String[] strArr = new String[]{"data1", "data2"};
        String[] strArr2 = new String[]{String.valueOf(bVar.d)};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(Phone.CONTENT_URI, strArr, "lookup = ?", strArr2, null);
        if (query == null) {
            f.b("PhoneNumberDataModel", "findAndInsertRecordsForContact() phone cursor is null");
            return;
        }
        try {
            TreeSet treeSet = new TreeSet(new w());
            while (query.moveToNext()) {
                Object string = query.getString(query.getColumnIndex("data1"));
                if (!TextUtils.isEmpty(string) && treeSet.add(string)) {
                    a aVar = new a(bVar, string, query.getInt(query.getColumnIndex("data2")), null, Long.valueOf(j));
                    f.d("PhoneNumberDataModel", "findAndInsertRecordsForContact() inserting: " + com.getpebble.android.common.b.b.a.a((Object) aVar));
                    a(contentResolver, aVar);
                }
            }
        } finally {
            query.close();
        }
    }
}
