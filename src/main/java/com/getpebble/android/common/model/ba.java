package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.model.a.w;
import com.getpebble.android.h.p;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ba extends k {
    public static final Uri c = com.getpebble.android.common.b.b.b.a("watch_settings");
    private static final Map<String, Class<? extends j>> d = new HashMap();
    private static b e = new b();

    public static class a extends com.getpebble.android.common.model.k.b {
        public a(j jVar) {
            super(jVar);
        }

        public a(Cursor cursor, Class<? extends j> cls) {
            super(cursor, cls);
        }

        private static a b(Cursor cursor) {
            Class cls = (Class) ba.d.get(cursor.getString(cursor.getColumnIndex("setting_key")));
            if (cls == null) {
                return null;
            }
            return new a(cursor, cls);
        }

        public com.getpebble.android.framework.l.b.j.b e() {
            return com.getpebble.android.framework.l.b.j.b.PREFERENCES;
        }

        protected Uri f() {
            return ba.c;
        }

        public ContentValues a() {
            return b();
        }
    }

    public static class b implements com.getpebble.android.common.model.k.a {
        public com.getpebble.android.framework.g.e.b a(Cursor cursor) {
            return a.b(cursor);
        }

        public Uri a() {
            return ba.c;
        }
    }

    static {
        d.put(ap.BLOB_DB_KEY, ap.class);
        d.put(ao.BLOB_DB_KEY, ao.class);
        d.put("unitsDistance", com.getpebble.android.framework.health.b.class);
        d.put("heartRatePreferences", w.class);
    }

    public ba() {
        super("watch_settings");
    }

    public static void a(j jVar, ContentResolver contentResolver) {
        k.b(contentResolver, new a(jVar));
    }

    public static <T extends j> T a(String str, T t, ContentResolver contentResolver) {
        Class cls = (Class) d.get(str);
        if (cls == null) {
            throw new IllegalArgumentException("Unknown key: " + str);
        }
        String a = a(str, contentResolver);
        return a != null ? (j) p.a(a, cls) : t;
    }

    private static String a(String str, ContentResolver contentResolver) {
        String str2 = null;
        String str3 = "setting_key = ?";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(c, b, "setting_key = ?", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str2 = query.getString(query.getColumnIndex("setting_value"));
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return str2;
    }

    public static Set<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver) {
        return k.a(contentResolver, e);
    }
}
