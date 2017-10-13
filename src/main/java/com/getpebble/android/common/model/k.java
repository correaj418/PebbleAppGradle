package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.p;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class k extends ai {
    protected static final String[] a = new String[]{"record_hashcode", "pebble_sync_hashcode", "setting_key", "setting_value"};
    protected static final String[] b = new String[]{"setting_key", "setting_value"};

    public static abstract class b<T extends j> implements com.getpebble.android.common.model.ai.b, com.getpebble.android.framework.g.e.b {
        public final Integer a;
        public final Integer b;
        public final T c;

        protected abstract Uri f();

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a != null) {
                if (!this.a.equals(bVar.a)) {
                    return false;
                }
            } else if (bVar.a != null) {
                return false;
            }
            if (this.b != null) {
                if (!this.b.equals(bVar.b)) {
                    return false;
                }
            } else if (bVar.b != null) {
                return false;
            }
            if (this.c != null) {
                z = this.c.equals(bVar.c);
            } else if (bVar.c != null) {
                z = false;
            }
            return z;
        }

        public b(T t) {
            this.b = null;
            this.c = t;
            this.a = Integer.valueOf(hashCode());
        }

        public b(Cursor cursor, Class<T> cls) {
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
            j jVar = (j) p.a(cursor.getString(cursor.getColumnIndex("setting_value")), (Class) cls);
            this.a = num;
            this.b = num2;
            this.c = jVar;
        }

        boolean a(ContentResolver contentResolver) {
            ContentValues contentValues = new ContentValues(1);
            String valueOf = (this.a == null ? 1 : 0) != 0 ? "removed" : String.valueOf(this.a);
            if (b(null)) {
                valueOf = "removed";
            }
            contentValues.put("pebble_sync_hashcode", valueOf);
            valueOf = "setting_key = ?";
            if (contentResolver.update(f(), contentValues, "setting_key = ?", new String[]{this.c.getKey()}) > 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        protected ContentValues b() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("record_hashcode", this.a);
            contentValues.put("pebble_sync_hashcode", this.b);
            contentValues.put("setting_key", this.c.getKey());
            contentValues.put("setting_value", this.c.toJson());
            return contentValues;
        }

        public boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (!z) {
                return false;
            }
            if (a(contentResolver)) {
                return true;
            }
            f.d("BlobDbDataModel.Record", "sync not successful, failed to mark record up to date for " + f() + " " + this.c.getKey());
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
    }

    public interface a<T extends com.getpebble.android.framework.g.e.b> {
        Uri a();

        T a(Cursor cursor);
    }

    public k(String str) {
        super(str, false, false);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "record_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "pebble_sync_hashcode"));
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "setting_key");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "setting_value"));
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pebble_sync_hashcode", "removed");
        return contentResolver.update(uri, contentValues, null, null);
    }

    public static Set<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver, a aVar) {
        String str = "record_hashcode != pebble_sync_hashcode";
        return b(contentResolver, aVar, "record_hashcode != pebble_sync_hashcode", new String[0]);
    }

    protected static Set<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver, a aVar, String str, String[] strArr) {
        return b(contentResolver, aVar, "record_hashcode != pebble_sync_hashcode AND " + str, strArr);
    }

    private static Set<com.getpebble.android.framework.g.e.b> b(ContentResolver contentResolver, a aVar, String str, String[] strArr) {
        Cursor query = contentResolver.query(aVar.a(), null, str, strArr, null);
        if (query == null) {
            return Collections.EMPTY_SET;
        }
        try {
            Set<com.getpebble.android.framework.g.e.b> hashSet = new HashSet(query.getCount());
            while (query.moveToNext()) {
                com.getpebble.android.framework.g.e.b a = aVar.a(query);
                if (a != null && (a.a(null) || a.b(null))) {
                    hashSet.add(a);
                }
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    protected static ContentValues a(b bVar) {
        ContentValues a = bVar.a();
        a.put("pebble_sync_hashcode", "removed");
        return a;
    }

    protected static boolean a(ContentResolver contentResolver, b bVar) {
        return contentResolver.insert(bVar.f(), a(bVar)) != null;
    }

    protected static boolean a(ContentResolver contentResolver, b bVar, String str, String[] strArr) {
        ContentValues a = bVar.a();
        a.remove("pebble_sync_hashcode");
        return contentResolver.update(bVar.f(), a, str, strArr) != -1;
    }

    public static boolean b(ContentResolver contentResolver, b bVar) {
        String str = "setting_key = ?";
        String[] strArr = new String[]{bVar.c.getKey()};
        Cursor query = contentResolver.query(bVar.f(), null, "setting_key = ?", strArr, null);
        if (query == null) {
            return false;
        }
        try {
            boolean a;
            if (query.moveToFirst()) {
                a = a(contentResolver, bVar, "setting_key = ?", strArr);
            } else {
                a = a(contentResolver, bVar);
            }
            query.close();
            return a;
        } catch (Throwable th) {
            query.close();
        }
    }
}
