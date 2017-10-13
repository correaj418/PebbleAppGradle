package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.framework.g.e;
import com.getpebble.android.framework.l.b.j;
import com.getpebble.android.h.p;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class az extends ai {
    public static final Uri a = b.a("watch_apps_data");
    public static final String[] b = new String[]{"record_hashcode", "pebble_sync_hashcode", "key", "value"};
    private static final String[] c = new String[]{"key", "value"};
    private static final Map<String, Class<? extends ay>> d = new HashMap();

    public static class a implements ai.b, e.b {
        public final Integer a;
        public final Integer b;
        public final ay c;

        public a(ay ayVar) {
            this.b = null;
            this.c = ayVar;
            this.a = Integer.valueOf(hashCode());
        }

        public a(Integer num, Integer num2, ay ayVar) {
            this.a = num;
            this.b = num2;
            this.c = ayVar;
        }

        private static a b(Cursor cursor) {
            Integer num;
            Integer num2 = null;
            String string = cursor.getString(cursor.getColumnIndex("record_hashcode"));
            if (string == null || string.equals("removed")) {
                num = null;
            } else {
                num = Integer.decode(string);
            }
            string = cursor.getString(cursor.getColumnIndex("pebble_sync_hashcode"));
            if (!(string == null || string.equals("removed"))) {
                num2 = Integer.decode(string);
            }
            return new a(num, num2, (ay) p.a(cursor.getString(cursor.getColumnIndex("value")), (Class) az.d.get(cursor.getString(cursor.getColumnIndex("key")))));
        }

        private boolean a(ContentResolver contentResolver, a aVar) {
            ContentValues contentValues = new ContentValues(1);
            String valueOf = (aVar.a == null ? 1 : 0) != 0 ? "removed" : String.valueOf(aVar.a);
            if (b(null)) {
                valueOf = "removed";
            }
            contentValues.put("pebble_sync_hashcode", valueOf);
            valueOf = "key = ?";
            if (contentResolver.update(az.a, contentValues, "key = ?", new String[]{aVar.c.getKey()}) > 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues(az.b.length);
            contentValues.put("record_hashcode", this.a);
            contentValues.put("pebble_sync_hashcode", this.b);
            contentValues.put("key", this.c.getKey());
            contentValues.put("value", this.c.toJson());
            return contentValues;
        }

        public boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (!z) {
                return false;
            }
            if (a(contentResolver, this)) {
                return true;
            }
            f.d("WatchAppsDataModel", "sync not successful, failed to mark record up to date");
            return false;
        }

        public boolean a(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return (this.a == null || this.a.equals(this.b)) ? false : true;
        }

        public boolean b(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return this.b != null && this.a == null;
        }

        public byte[] c() {
            return this.c.getKey().getBytes();
        }

        public byte[] a(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar, z zVar) {
            return this.c.toBytes();
        }

        public Integer d() {
            return this.a;
        }

        public j.b e() {
            return j.b.WATCH_APPS_DATA;
        }
    }

    static {
        d.put("sendTextApp", at.class);
        d.put("weatherApp", bb.class);
        d.put("remindersApp", com.getpebble.android.framework.n.a.class);
    }

    public az() {
        super("watch_apps_data");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "record_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "pebble_sync_hashcode"));
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "key");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "value"));
    }

    public static void a(ay ayVar, ContentResolver contentResolver) {
        a(contentResolver, new a(ayVar));
    }

    public static <T extends ay> T a(String str, T t, ContentResolver contentResolver) {
        Class cls = (Class) d.get(str);
        if (cls == null) {
            throw new IllegalArgumentException("Unknown key: " + str);
        }
        String b = b(str, contentResolver);
        return b != null ? (ay) p.a(b, cls) : t;
    }

    public static <T extends ay> T a(String str, ContentResolver contentResolver) {
        return a(str, null, contentResolver);
    }

    private static String b(String str, ContentResolver contentResolver) {
        String str2 = null;
        String str3 = "key = ?";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, c, "key = ?", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str2 = query.getString(query.getColumnIndex("value"));
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return str2;
    }

    private static boolean a(ContentResolver contentResolver, a aVar) {
        String str = "key = ?";
        String[] strArr = new String[]{aVar.c.getKey()};
        Cursor query = contentResolver.query(a, b, "key = ?", strArr, null);
        if (query == null) {
            return false;
        }
        try {
            if (query.moveToFirst()) {
                boolean a = a(contentResolver, aVar, "key = ?", strArr);
                return a;
            }
            query.close();
            return b(contentResolver, aVar);
        } finally {
            query.close();
        }
    }

    private static boolean a(ContentResolver contentResolver, a aVar, String str, String[] strArr) {
        ContentValues a = aVar.a();
        a.remove("pebble_sync_hashcode");
        return contentResolver.update(a, a, str, strArr) != -1;
    }

    private static boolean b(ContentResolver contentResolver, a aVar) {
        ContentValues a = aVar.a();
        a.put("pebble_sync_hashcode", "removed");
        return contentResolver.insert(a, a) != null;
    }

    public static int a(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pebble_sync_hashcode", "removed");
        return contentResolver.update(a, contentValues, null, null);
    }

    public static Set<e.b> b(ContentResolver contentResolver) {
        String str = "record_hashcode != pebble_sync_hashcode";
        Set<e.b> set = a;
        Cursor query = contentResolver.query(set, b, "record_hashcode != pebble_sync_hashcode", new String[0], null);
        if (query == null) {
            return Collections.EMPTY_SET;
        }
        try {
            set = new HashSet(query.getCount());
            while (query.moveToNext()) {
                a a = a.b(query);
                if (a != null && (a.a(null) || a.b(null))) {
                    set.add(a);
                }
            }
            f.e("WatchAppsDataModel", "getDirtyRecords: dirtyRecords = " + (set == null ? 0 : set.size()));
            return set;
        } finally {
            query.close();
        }
    }
}
