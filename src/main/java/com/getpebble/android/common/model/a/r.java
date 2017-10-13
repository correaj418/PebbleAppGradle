package com.getpebble.android.common.model.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.k;
import com.getpebble.android.common.model.v;
import com.getpebble.android.h.x;
import com.google.a.b.ad;
import com.google.a.b.am;
import java.util.Set;

public final class r extends k {
    public static final Uri c = com.getpebble.android.common.b.b.b.a("health_stats");

    public static class a<T extends q> {
        private final Class<T> a;

        public a(Class<T> cls) {
            this.a = cls;
        }

        public T a(Cursor cursor) {
            return (q) new c(cursor, this.a).c;
        }
    }

    public static final class b<T extends q> {
        private final Uri a;
        private final a<T> b;

        public b(Uri uri, a<T> aVar) {
            this.a = uri;
            this.b = aVar;
        }

        public T a(ContentResolver contentResolver, p pVar) {
            Throwable th;
            Cursor cursor = null;
            try {
                Cursor query = contentResolver.query(this.a, null, x.b(ad.a((Object) "setting_key")), new String[]{String.valueOf(pVar.blobDbKey)}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            T a = this.b.a(query);
                            if (query == null) {
                                return a;
                            }
                            query.close();
                            return a;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public static final class c<T extends q> extends com.getpebble.android.common.model.k.b<T> {
        private final String d;

        protected c(T t) {
            super(t);
            this.d = t.getClass().getName();
        }

        protected c(Cursor cursor, Class<T> cls) {
            super(cursor, cls);
            this.d = cursor.getString(cursor.getColumnIndex("entry_class"));
        }

        protected Uri f() {
            return r.c;
        }

        public com.getpebble.android.framework.l.b.j.b e() {
            return com.getpebble.android.framework.l.b.j.b.HEALTH_STATS;
        }

        public ContentValues a() {
            ContentValues b = b();
            b.put("entry_class", this.d);
            return b;
        }
    }

    public static class d<T extends q> implements com.getpebble.android.common.model.k.a<c> {
        private final Class<T> a;

        public /* synthetic */ com.getpebble.android.framework.g.e.b a(Cursor cursor) {
            return b(cursor);
        }

        public d(Class<T> cls) {
            this.a = cls;
        }

        public c<T> b(Cursor cursor) {
            return new c(cursor, this.a);
        }

        public c a(T t) {
            return new c(t);
        }

        public Uri a() {
            return r.c;
        }
    }

    public enum e {
        ONE(15, "health_stats", new v("4.2.0", 0), new com.getpebble.android.common.model.ai.a[]{new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "entry_class")});
        
        public static final e CURRENT = null;
        final com.getpebble.android.common.model.ai.a[] columns;
        public final int healthDbVersion;
        public final v minimumFwVersionRequired;
        public final String tableName;

        static {
            CURRENT = ONE;
        }

        private e(int i, String str, v vVar, com.getpebble.android.common.model.ai.a[] aVarArr) {
            this.healthDbVersion = i;
            this.tableName = str;
            this.minimumFwVersionRequired = vVar;
            this.columns = aVarArr;
        }

        public static e from(int i) {
            e eVar = ONE;
            e[] values = values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                e eVar2 = values[i2];
                if (eVar2.healthDbVersion > i || eVar2.healthDbVersion <= eVar.healthDbVersion) {
                    eVar2 = eVar;
                }
                i2++;
                eVar = eVar2;
            }
            return eVar;
        }

        public boolean isFirmwareVersionSupported(v vVar) {
            return this.minimumFwVersionRequired.compareTo(vVar) < 1;
        }
    }

    public r(int i) {
        super("health_stats");
        for (com.getpebble.android.common.model.ai.a addColumn : e.from(i).columns) {
            addColumn(addColumn);
        }
    }

    public static <T extends q> b<T> a(Class<T> cls) {
        return new b(c, new a(cls));
    }

    public static <T extends q> Set<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver, Class<T> cls, com.getpebble.android.common.model.ak.a aVar) {
        if (e.CURRENT.isFirmwareVersionSupported(aVar.getFwVersion())) {
            String[] strArr = new String[]{cls.getName()};
            return k.a(contentResolver, new d(cls), "entry_class = ?", strArr);
        }
        f.c("HealthStatsModel", "getDirtyRecords: unsupported FW version (" + aVar.getFwVersion() + ")");
        return am.h();
    }
}
