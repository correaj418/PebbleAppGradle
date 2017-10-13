package com.getpebble.android.common.model.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.common.model.k;
import com.getpebble.android.common.model.u;
import com.google.b.a.c;

@Deprecated
public class s extends k {
    @Deprecated
    public static final Uri c = com.getpebble.android.common.b.b.b.a("health_typical_stats");

    @Deprecated
    public static class a extends q {
        @c(a = "data")
        public Integer[] a;

        @Deprecated
        public byte[] toBytes() {
            throw new IllegalStateException();
        }
    }

    @Deprecated
    public static final class b extends com.getpebble.android.common.model.k.b<a> {
        protected b(Cursor cursor) {
            super(cursor, a.class);
        }

        protected Uri f() {
            throw new IllegalStateException();
        }

        public com.getpebble.android.framework.l.b.j.b e() {
            throw new IllegalStateException();
        }

        public ContentValues a() {
            throw new IllegalStateException();
        }
    }

    @Deprecated
    public s() {
        super("health_typical_stats");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "activity_type"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "day_of_week"));
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor query;
        try {
            query = sQLiteDatabase.query("health_typical_stats", null, null, null, null, null, null);
            while (query != null) {
                try {
                    if (!query.moveToNext()) {
                        break;
                    }
                    int i = query.getInt(query.getColumnIndex("day_of_week"));
                    if (query.getInt(query.getColumnIndex("activity_type")) == 0) {
                        String str = "health_stats";
                        sQLiteDatabase.insert(str, null, k.a(new r.c(new y(u.from(i), ((a) new b(query).c).a))));
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
            sQLiteDatabase.execSQL("drop table health_typical_stats");
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
