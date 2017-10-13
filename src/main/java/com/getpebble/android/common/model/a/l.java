package com.getpebble.android.common.model.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.h.x;
import java.util.concurrent.TimeUnit;

@Deprecated
public class l extends ai {
    public static final Uri a = b.a("health_aggregate_samples");
    private static final long b = TimeUnit.HOURS.toSeconds(1);

    @Deprecated
    public static class a {
        public final int a;
        public final long b;
        public final long c;
        public final String d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final Integer i;
        public final Integer j;

        public a(int i, long j, long j2, String str, int i2, int i3, int i4, int i5, Integer num, Integer num2) {
            this.a = i;
            this.b = j;
            this.c = j2;
            this.d = str;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = num;
            this.j = num2;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a != aVar.a || this.b != aVar.b || this.c != aVar.c || this.e != aVar.e || this.f != aVar.f || this.g != aVar.g || this.h != aVar.h) {
                return false;
            }
            if (this.d != null) {
                if (!this.d.equals(aVar.d)) {
                    return false;
                }
            } else if (aVar.d != null) {
                return false;
            }
            if (this.i != null) {
                if (!this.i.equals(aVar.i)) {
                    return false;
                }
            } else if (aVar.i != null) {
                return false;
            }
            if (this.j != null) {
                z = this.j.equals(aVar.j);
            } else if (aVar.j != null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            int hashCode;
            int i = 0;
            int hashCode2 = ((((((((((this.d != null ? this.d.hashCode() : 0) + (((((this.a * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + ((int) (this.c ^ (this.c >>> 32)))) * 31)) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
            if (this.i != null) {
                hashCode = this.i.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode = (hashCode + hashCode2) * 31;
            if (this.j != null) {
                i = this.j.hashCode();
            }
            return hashCode + i;
        }
    }

    @Deprecated
    public l(int i) {
        super(i >= 13 ? "health_aggregate_samples" : "step_session", false, false);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "steps"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "duration"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "start_time"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "device_serial"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "utc_to_local"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "distance"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "calories"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "minutes_active"));
        if (i >= 13) {
            addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "heart_rate_bpm"));
        }
        if (i >= 14) {
            addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "heart_rate_weight"));
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a("health_aggregate_samples", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "heart_rate_weight")));
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE health_aggregate_samples");
    }

    @Deprecated
    public static a a(Cursor cursor) {
        Integer valueOf;
        Integer num = null;
        int i = cursor.getInt(cursor.getColumnIndex("steps"));
        long j = cursor.getLong(cursor.getColumnIndex("duration"));
        long j2 = cursor.getLong(cursor.getColumnIndex("start_time"));
        String string = cursor.getString(cursor.getColumnIndex("device_serial"));
        int i2 = cursor.getInt(cursor.getColumnIndex("utc_to_local"));
        int i3 = cursor.getInt(cursor.getColumnIndex("distance"));
        int i4 = cursor.getInt(cursor.getColumnIndex("calories"));
        int i5 = cursor.getInt(cursor.getColumnIndex("minutes_active"));
        int columnIndex = cursor.getColumnIndex("heart_rate_bpm");
        if (columnIndex >= 0) {
            valueOf = cursor.isNull(columnIndex) ? null : Integer.valueOf(cursor.getInt(columnIndex));
        } else {
            valueOf = null;
        }
        columnIndex = cursor.getColumnIndex("heart_rate_weight");
        if (columnIndex >= 0 && !cursor.isNull(columnIndex)) {
            num = Integer.valueOf(cursor.getInt(columnIndex));
        }
        return new a(i, j, j2, string, i2, i3, i4, i5, valueOf, num);
    }

    public static void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a("step_session", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "utc_to_local")));
        sQLiteDatabase.execSQL(x.a("step_session", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "distance")));
        sQLiteDatabase.execSQL(x.a("step_session", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "calories")));
        sQLiteDatabase.execSQL(x.a("step_session", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "minutes_active")));
        sQLiteDatabase.execSQL("update step_session set duration = duration / 1000");
        ai.dropDefaultColumns(sQLiteDatabase, "step_session", new l(6));
    }

    public static void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(a());
        sQLiteDatabase.execSQL(a(8));
    }

    public static void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(new l(13).getCreateTableCommand());
        sQLiteDatabase.execSQL(a(13));
        String a = x.a(new l(12));
        try {
            sQLiteDatabase.execSQL("INSERT INTO health_aggregate_samples ( " + a + ") SELECT " + a + " FROM " + "step_session");
        } catch (Throwable e) {
            if (e.getMessage().contains("2067")) {
                f.b("HealthAggregateSampleModel", "perform_v12_migration: got a 2067 code, attempting to dedupe and save the user's data.", e);
                sQLiteDatabase.execSQL(a());
                try {
                    sQLiteDatabase.execSQL("INSERT INTO health_aggregate_samples ( " + a + ") SELECT " + a + " FROM " + "step_session");
                    com.getpebble.android.common.a.b(new Throwable("PBL-42369 Successfully fixed user's data issue.", e));
                } catch (Throwable e2) {
                    com.getpebble.android.common.a.b(new Throwable("PBL-42369 Failed to fix user's data issue. Dropping user's data to prevent crash loop.", e2));
                }
            } else {
                f.a("HealthAggregateSampleModel", "perform_v12_migration: got a non-2067 exception, dropping user's data to prevent crash loop.", e2);
                com.getpebble.android.common.a.b(new Throwable("PBL-42369 Received a weird exception in the migration path", e2));
            }
        }
        sQLiteDatabase.execSQL("DROP TABLE step_session");
    }

    public static String a() {
        return "DELETE FROM step_session WHERE rowid IN (SELECT a.rowid FROM step_session a WHERE exists (SELECT b.rowid FROM step_session b WHERE a.start_time = b.start_time AND a.rowid > b.rowid AND a.device_serial = b.device_serial ) );";
    }

    public static String a(int i) {
        if (i >= 13) {
            return " CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_time_health_aggregate_samples ON health_aggregate_samples(device_serial, start_time);";
        }
        return " CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_time_step_session ON step_session(device_serial, start_time);";
    }
}
