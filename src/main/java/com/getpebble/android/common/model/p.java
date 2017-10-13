package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.b.al;
import com.getpebble.android.framework.timeline.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class p extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("canned_responses");
    public static final String[] b = new String[]{"responses_map", an.SOURCE, "pebble_sync_hashcode"};

    public static class a implements com.getpebble.android.framework.g.e.b {
        public final HashMap<Integer, CharSequence> a;
        public final b b;
        protected Integer c;

        public a(b bVar, HashMap<Integer, CharSequence> hashMap, int i) {
            this.b = bVar;
            this.a = hashMap;
            this.c = Integer.valueOf(i);
        }

        public a(b bVar, HashMap<Integer, CharSequence> hashMap) {
            this.b = bVar;
            this.a = hashMap;
            this.c = Integer.valueOf(0);
        }

        public static a a(Cursor cursor) {
            return new a(b.from(cursor.getInt(cursor.getColumnIndex(an.SOURCE))), (HashMap) com.getpebble.android.h.p.a(cursor.getString(cursor.getColumnIndex("responses_map")), new com.google.b.c.a<Map<Integer, String>>() {
            }.getType()), Integer.valueOf(cursor.getInt(cursor.getColumnIndex("pebble_sync_hashcode"))).intValue());
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues(3);
            contentValues.put(an.SOURCE, Integer.valueOf(this.b.id));
            contentValues.put("responses_map", com.getpebble.android.h.p.a(this.a));
            contentValues.put("pebble_sync_hashcode", this.c);
            return contentValues;
        }

        private boolean a(a aVar, ContentResolver contentResolver) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("pebble_sync_hashcode", Integer.valueOf(aVar.hashCode()));
            String[] strArr = new String[]{String.valueOf(aVar.b.id)};
            if (contentResolver.update(p.a, contentValues, "source = ? ", strArr) > 0) {
                return true;
            }
            return false;
        }

        public boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (z && a(this, contentResolver)) {
                f.e("CannedResponsesModel", "onPebbleSync: canned responses records successfully sync'd to Pebble");
                return true;
            }
            f.e("CannedResponsesModel", "onPebbleSync: canned responses records failed to sync to Pebble.");
            return false;
        }

        public boolean a(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return true;
        }

        public boolean b(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return false;
        }

        public byte[] c() {
            return this.b.blobDbKey;
        }

        public Integer d() {
            return Integer.valueOf(hashCode());
        }

        public byte[] a(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar, z zVar) {
            try {
                return new al(this, h.getMapper(com.getpebble.android.common.a.K(), vVar, zVar), aVar).a();
            } catch (Throwable e) {
                throw new IllegalArgumentException(e);
            }
        }

        public com.getpebble.android.framework.l.b.j.b e() {
            return com.getpebble.android.framework.l.b.j.b.NOTIF_PREF;
        }

        public int hashCode() {
            int hashCode;
            int i = 0;
            if (this.a != null) {
                hashCode = this.a.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode *= 31;
            if (this.b != null) {
                i = this.b.hashCode();
            }
            return hashCode + i;
        }
    }

    public enum b {
        Unknown(-1, "", -1),
        IncomingCall(0, "com.pebble.android.phone", R.array.default_incoming_call_canned_responses),
        SendText(1, "com.pebble.sendText", R.array.default_sms_canned_responses);
        
        public final byte[] blobDbKey;
        public final int defaultsArrayId;
        public final int id;

        private b(int i, String str, int i2) {
            this.id = i;
            this.blobDbKey = str.getBytes();
            this.defaultsArrayId = i2;
        }

        static b from(int i) {
            for (b bVar : values()) {
                if (bVar.id == i) {
                    return bVar;
                }
            }
            return Unknown;
        }
    }

    public p() {
        super("canned_responses");
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, an.SOURCE);
        aVar.a(true);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "responses_map"));
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "pebble_sync_hashcode"));
    }

    public static boolean a(a aVar, ContentResolver contentResolver) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot insert record with null content resolver");
        } else if (a(aVar.b, contentResolver) != null) {
            ContentValues a = aVar.a();
            a.remove(an.SOURCE);
            String[] strArr = new String[]{String.valueOf(aVar.b.id)};
            if (contentResolver.update(a, a, "source = ? ", strArr) > 0) {
                return true;
            }
            return false;
        } else {
            f.d("CannedResponsesModel", "Insert record: " + aVar.a.values());
            if (contentResolver.insert(a, aVar.a()) == null) {
                return false;
            }
            return true;
        }
    }

    private static List<a> c(ContentResolver contentResolver) {
        List<a> arrayList = new ArrayList();
        Cursor query = contentResolver.query(a, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(a.a(query));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public static Set<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver) {
        Set<com.getpebble.android.framework.g.e.b> hashSet = new HashSet();
        for (a aVar : c(contentResolver)) {
            if (aVar.hashCode() != aVar.c.intValue()) {
                f.d("CannedResponsesModel", "getDirtyCannedResponseRecords(): adding canned responses from source: " + aVar.b.name());
                hashSet.add(aVar);
            }
        }
        return hashSet;
    }

    public static void a(Resources resources, SQLiteDatabase sQLiteDatabase) {
        for (b bVar : b.values()) {
            if (bVar != b.Unknown) {
                sQLiteDatabase.insert("canned_responses", null, new a(bVar, a(bVar, resources)).a());
            }
        }
    }

    static HashMap<Integer, CharSequence> a(b bVar, Resources resources) {
        HashMap<Integer, CharSequence> hashMap = new HashMap();
        String[] stringArray = resources.getStringArray(bVar.defaultsArrayId);
        for (int i = 0; i < stringArray.length; i++) {
            hashMap.put(Integer.valueOf(i), stringArray[i]);
        }
        return hashMap;
    }

    public static a a(b bVar, ContentResolver contentResolver) {
        a aVar = null;
        String[] strArr = new String[]{String.valueOf(bVar.id)};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, null, "source = ? ", strArr, null);
        try {
            if (query.moveToFirst()) {
                aVar = a.a(query);
            }
            query.close();
            return aVar;
        } catch (Throwable th) {
            query.close();
        }
    }

    public static void b(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pebble_sync_hashcode", Integer.valueOf(0));
        contentResolver.update(a, contentValues, null, null);
    }
}
