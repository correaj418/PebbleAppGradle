package com.getpebble.android.common.model.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.h.g;
import com.getpebble.android.h.k;
import com.getpebble.android.h.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class o extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("minute_samples");

    public static abstract class e {
        public abstract int a();

        public abstract int b();

        public abstract int c();

        public abstract int d();

        public abstract int e();

        public abstract int f();

        public abstract int g();

        public abstract int h();

        public abstract boolean i();

        public abstract int j();

        public abstract int k();

        public abstract int l();

        public abstract Integer m();

        public abstract Integer n();

        public abstract Short o();

        public abstract int p();

        public abstract int q();

        public static e b(Cursor cursor) {
            return b.a(cursor);
        }
    }

    public static abstract class a {
        public abstract int a();

        public abstract int b();

        public abstract int c();

        public abstract int d();

        public abstract int e();

        public static a a(int i, int i2, int i3, int i4, int i5) {
            return new e(i, i2, i3, i4, i5);
        }
    }

    public static abstract class b {
        public abstract int a();

        public abstract int b();

        public abstract int c();

        static b a(int[] iArr) {
            if (iArr.length >= 4) {
                return new f(iArr[1], iArr[2], iArr[3]);
            }
            throw new IllegalArgumentException("expected 4 zones, got " + iArr.length);
        }

        static b d() {
            return a(new int[4]);
        }
    }

    public static abstract class c {
        public abstract e a();

        public abstract int b();

        public static c a(e eVar, int i) {
            return new g(eVar, i);
        }
    }

    public enum d {
        DEVICE_SERIAL("watch_serial"),
        STEP_COUNT("step_count"),
        TIME_UTC_SECONDS("date"),
        ORIENTATION("orientation"),
        VMC("vmc"),
        LIGHT("light"),
        IS_PLUGGED_IN("plugged_in"),
        DISTANCE_CM("distance"),
        RESTING_CALORIES("calories"),
        IS_ACTIVE("time_active"),
        ACTIVE_CALORIES("active_calories"),
        TIME_LOCAL_OFFSET_SECONDS("utc_to_local"),
        HEART_RATE_BPM("heart_rate"),
        HEART_RATE_WEIGHT("qualityWeight");
        
        public final String name;

        private d(String str) {
            this.name = str;
        }
    }

    public enum f {
        ONE(1, "short_term_step_session", new String[]{" CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_time_short_term_steps ON steps(watch_serial, date);"}, new com.getpebble.android.common.model.ai.a[]{new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, d.DEVICE_SERIAL.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.STEP_COUNT.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.TIMESTAMP, d.TIME_UTC_SECONDS.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.ORIENTATION.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.VMC.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.LIGHT.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.IS_PLUGGED_IN.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.DISTANCE_CM.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.RESTING_CALORIES.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.IS_ACTIVE.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.ACTIVE_CALORIES.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.TIME_LOCAL_OFFSET_SECONDS.name)}),
        TWO(7, "steps", new String[]{" CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_time_short_term_steps ON steps(watch_serial, date);"}, ONE.columns),
        THREE(13, "health_minute_samples", new String[]{" CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_time_health_minute_samples ON health_minute_samples(watch_serial, date);"}, (com.getpebble.android.common.model.ai.a[]) com.getpebble.android.h.b.a(TWO.columns, new com.getpebble.android.common.model.ai.a[]{new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.HEART_RATE_BPM.name)})),
        FOUR(14, "health_minute_samples", new String[]{" CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_time_health_minute_samples ON health_minute_samples(watch_serial, date);"}, (com.getpebble.android.common.model.ai.a[]) com.getpebble.android.h.b.a(THREE.columns, new com.getpebble.android.common.model.ai.a[]{new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.HEART_RATE_WEIGHT.name)})),
        FIVE(16, "minute_samples", new String[]{" CREATE UNIQUE INDEX IF NOT EXISTS `minute_samples_uniq` ON `minute_samples` (`watch_id`, `date_utc_secs`);", " CREATE INDEX IF NOT EXISTS `minute_samples_date_local_secs` ON `minute_samples` (`date_local_secs`);"}, new com.getpebble.android.common.model.ai.a[]{new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "watch_id", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "date_utc_secs", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "utc_to_local", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "date_local_secs", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "plugged_in", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "vmc", false, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "light", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "orientation", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "step_count", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "distance_mm", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "resting_gcal", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "active_gcal", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "active_minutes", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "heart_rate_bpm", false, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "heart_rate_weight", false, null)}),
        SIX(17, "minute_samples", FIVE.indices, (com.getpebble.android.common.model.ai.a[]) com.getpebble.android.h.b.a(FIVE.columns, new com.getpebble.android.common.model.ai.a[]{new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "heart_rate_zone", false, null)}));
        
        public static final f CURRENT = null;
        final com.getpebble.android.common.model.ai.a[] columns;
        public final int healthDbVersion;
        final String[] indices;
        public final String tableName;

        static {
            CURRENT = FIVE;
        }

        private f(int i, String str, String[] strArr, com.getpebble.android.common.model.ai.a[] aVarArr) {
            this.healthDbVersion = i;
            this.tableName = str;
            this.indices = strArr;
            this.columns = aVarArr;
        }

        public static f from(int i) {
            f fVar = ONE;
            f[] values = values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                f fVar2 = values[i2];
                if (fVar2.healthDbVersion > i || fVar2.healthDbVersion <= fVar.healthDbVersion) {
                    fVar2 = fVar;
                }
                i2++;
                fVar = fVar2;
            }
            return fVar;
        }
    }

    public o(int i) {
        int i2 = 0;
        super(a(i), false, b(i));
        com.getpebble.android.common.model.ai.a[] aVarArr = f.from(i).columns;
        int length = aVarArr.length;
        while (i2 < length) {
            addColumn(aVarArr[i2]);
            i2++;
        }
    }

    private static String a(int i) {
        return f.from(i).tableName;
    }

    private static boolean b(int i) {
        if (i < 7) {
            return false;
        }
        return true;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("delete from " + f.from(1).tableName);
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a(f.from(2).tableName, new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "device_serial")));
    }

    public static void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("drop table " + f.from(6).tableName);
        sQLiteDatabase.execSQL(new o(7).getCreateTableCommand());
    }

    public static void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(a());
        a(sQLiteDatabase, 8);
    }

    public static void e(SQLiteDatabase sQLiteDatabase) {
        x.a(sQLiteDatabase, new o(9), true);
    }

    public static void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, 10);
    }

    public static void g(SQLiteDatabase sQLiteDatabase) {
        f from = f.from(12);
        f from2 = f.from(13);
        sQLiteDatabase.execSQL(new o(13).getCreateTableCommand());
        a(sQLiteDatabase, 13);
        String a = x.a(new o(from.healthDbVersion));
        sQLiteDatabase.execSQL("INSERT INTO " + from2.tableName + " ( " + a + ") SELECT " + a + " FROM " + from.tableName);
        sQLiteDatabase.execSQL("DROP TABLE " + from.tableName);
    }

    public static void h(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a(f.from(14).tableName, new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, d.HEART_RATE_WEIGHT.name)));
    }

    public static void a(SQLiteDatabase sQLiteDatabase, n nVar) {
        Throwable th;
        f from = f.from(16);
        f from2 = f.from(15);
        o oVar = new o(16);
        com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: migration starting at " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        HashMap hashMap = new HashMap();
        Cursor cursor = null;
        try {
            int a;
            int intValue;
            cursor = sQLiteDatabase.rawQuery("SELECT DISTINCT " + d.DEVICE_SERIAL.name + " AS " + ak.SERIAL_NUMBER + " FROM " + from2.tableName + " UNION SELECT DISTINCT " + "device_serial" + " AS " + ak.SERIAL_NUMBER + " FROM " + "health_aggregate_samples", null);
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex(ak.SERIAL_NUMBER));
                if (string == null) {
                    com.getpebble.android.common.b.a.f.b("HealthMinuteLevelSampleModel", "perform_v15_migration: found MLS entries with NULL serial");
                } else {
                    a = t.a(sQLiteDatabase, string);
                    hashMap.put(string, Integer.valueOf(a));
                    com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: watch with serial " + string + " added to HealthWatchModel with ID " + a);
                }
            }
            sQLiteDatabase.execSQL(oVar.getCreateTableCommand());
            for (String execSQL : from.indices) {
                sQLiteDatabase.execSQL(execSQL);
            }
            String str = d.TIME_UTC_SECONDS.name;
            try {
                cursor = sQLiteDatabase.query(from2.tableName, new String[]{str, d.RESTING_CALORIES.name}, null, null, null, null, str + " ASC", "1");
                try {
                    Integer valueOf;
                    Integer num;
                    if (cursor.moveToNext()) {
                        Integer valueOf2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndex(str)));
                        valueOf = Integer.valueOf(cursor.getInt(cursor.getColumnIndex(r13)));
                        num = valueOf2;
                    } else {
                        valueOf = Integer.valueOf(0);
                        num = null;
                    }
                    com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: oldest MLS record is for timestamp " + num);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (num != null) {
                        intValue = (int) (((long) num.intValue()) - TimeUnit.MINUTES.toSeconds(14));
                    } else {
                        intValue = Integer.MAX_VALUE;
                    }
                    com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: timestamp upper limit of aggregated records to copy: " + intValue);
                    long j = 0;
                    try {
                        cursor = sQLiteDatabase.query("health_aggregate_samples", null, "start_time < " + intValue, null, null, null, "start_time ASC");
                        int i = 0;
                        while (cursor.moveToNext()) {
                            try {
                                com.getpebble.android.common.model.a.l.a a2 = l.a(cursor);
                                if (a2.d != null) {
                                    a = (int) Math.max(0, ((long) valueOf.intValue()) * TimeUnit.SECONDS.toMinutes(a2.b));
                                    int max = Math.max(0, a2.g - a);
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("watch_id", (Integer) hashMap.get(a2.d));
                                    contentValues.put("utc_to_local", Integer.valueOf(a2.e));
                                    contentValues.put("date_utc_secs", Long.valueOf(a2.c));
                                    contentValues.put("date_local_secs", Long.valueOf(a2.c + ((long) a2.e)));
                                    contentValues.put("plugged_in", Integer.valueOf(0));
                                    contentValues.putNull("vmc");
                                    contentValues.put("light", Integer.valueOf(150));
                                    contentValues.put("orientation", Integer.valueOf(100));
                                    contentValues.put("step_count", Integer.valueOf(a2.a));
                                    contentValues.put("distance_mm", Long.valueOf(k.METRES.toMillimetres((long) a2.f)));
                                    contentValues.put("resting_gcal", Integer.valueOf(a));
                                    contentValues.put("active_gcal", Integer.valueOf(max));
                                    contentValues.put("active_minutes", Integer.valueOf(a2.h));
                                    contentValues.put("heart_rate_bpm", a2.i);
                                    contentValues.put("heart_rate_weight", a2.j);
                                    j = sQLiteDatabase.insert(from.tableName, null, contentValues);
                                    i++;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: migrated " + i + " aggregate records");
                        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                        sQLiteDatabase2.execSQL("INSERT INTO " + from.tableName + " (" + String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", new Object[]{"watch_id", "step_count", "date_utc_secs", "utc_to_local", "date_local_secs", "orientation", "vmc", "light", "plugged_in", "distance_mm", "resting_gcal", "active_gcal", "active_minutes", "heart_rate_bpm", "heart_rate_weight"}) + ") SELECT " + ("(SELECT _id FROM watches WHERE serial_number = " + d.DEVICE_SERIAL.name + ") AS " + "watch_id" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.STEP_COUNT.name + " AS " + "step_count" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.TIME_UTC_SECONDS.name + " AS " + "date_utc_secs" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.TIME_LOCAL_OFFSET_SECONDS.name + " AS " + "utc_to_local" + ", (" + d.TIME_UTC_SECONDS.name + " + " + d.TIME_LOCAL_OFFSET_SECONDS.name + ") AS " + "date_local_secs" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.ORIENTATION.name + " AS " + "orientation" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.VMC.name + " AS " + "vmc" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.LIGHT.name + " AS " + "light" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.IS_PLUGGED_IN.name + " AS " + "plugged_in" + ", (" + d.DISTANCE_CM.name + " * 10) AS " + "distance_mm" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.RESTING_CALORIES.name + " AS " + "resting_gcal" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.ACTIVE_CALORIES.name + " AS " + "active_gcal" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.IS_ACTIVE.name + " AS " + "active_minutes" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.HEART_RATE_BPM.name + " AS " + "heart_rate_bpm" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.HEART_RATE_WEIGHT.name + " AS " + "heart_rate_weight") + " FROM " + from2.tableName);
                        sQLiteDatabase.execSQL("DROP TABLE " + f.from(from2.healthDbVersion).tableName);
                        try {
                            long toSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - com.getpebble.android.core.sync.b.a;
                            com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: upper timestamp bound for MLS record to mark as last synced: " + toSeconds);
                            cursor = sQLiteDatabase.query(from.tableName, new String[]{ai.COLUMN_ID}, "date_utc_secs < " + toSeconds, null, null, null, "date_utc_secs DESC", "1");
                            try {
                                long j2;
                                if (cursor.moveToNext()) {
                                    j2 = (long) cursor.getInt(cursor.getColumnIndex(ai.COLUMN_ID));
                                } else {
                                    com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: no records older than " + toSeconds);
                                    j2 = 0;
                                }
                                com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: fake last synced record ID: " + j2);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                long max2 = Math.max(j2, j);
                                com.getpebble.android.common.b.a.f.d("HealthMinuteLevelSampleModel", "perform_v15_migration: setting last synced MLS row ID to " + max2);
                                nVar.a(max2);
                            } catch (Throwable th3) {
                                th = th3;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cursor = null;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static void i(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a(f.from(17).tableName, new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "heart_rate_zone", false, null)));
    }

    public static boolean a(ContentResolver contentResolver) {
        Throwable th;
        Cursor query;
        try {
            ContentResolver contentResolver2 = contentResolver;
            query = contentResolver2.query(a, new String[]{"1"}, null, null, "1 LIMIT 1");
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return false;
            }
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query == null) {
                    return moveToFirst;
                }
                query.close();
                return moveToFirst;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static e b(ContentResolver contentResolver) {
        Throwable th;
        Cursor cursor = null;
        String str = "heart_rate_bpm IS NOT NULL";
        str = "date_utc_secs DESC LIMIT 1";
        try {
            Cursor query = contentResolver.query(a, null, "heart_rate_bpm IS NOT NULL", null, "date_utc_secs DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        e b = e.b(query);
                        if (query == null) {
                            return b;
                        }
                        query.close();
                        return b;
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

    public static List<c> a(ContentResolver contentResolver, int i, int i2) {
        Throwable th;
        String str = "_id > " + i;
        String str2 = "_id LIMIT " + i2;
        List<c> linkedList = new LinkedList();
        Cursor query;
        try {
            query = contentResolver.query(a, null, str, null, str2);
            while (query.moveToNext()) {
                try {
                    linkedList.add(c.a(e.b(query), query.getInt(query.getColumnIndex(ai.COLUMN_ID))));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
            return linkedList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static List<e> a(ContentResolver contentResolver, g gVar, g gVar2) {
        return a(contentResolver, gVar, gVar2, true);
    }

    public static List<e> b(ContentResolver contentResolver, g gVar, g gVar2) {
        return a(contentResolver, gVar, gVar2, false);
    }

    private static List<e> a(ContentResolver contentResolver, g gVar, g gVar2, boolean z) {
        Cursor query;
        Throwable th;
        List<e> linkedList = new LinkedList();
        String str = z ? " AND heart_rate_bpm IS NOT NULL" : "";
        String format = String.format(Locale.getDefault(), "%s >= %d AND %s < %d%s", new Object[]{"date_local_secs", Long.valueOf(gVar.a()), "date_local_secs", Long.valueOf(gVar2.a()), str});
        str = "date_local_secs ASC";
        try {
            query = contentResolver.query(a, null, format, null, "date_local_secs ASC");
            if (query == null) {
                try {
                    com.getpebble.android.common.b.a.f.a("HealthMinuteLevelSampleModel", "loadRecords: null cursor (" + gVar.a() + "," + gVar2.a() + ")");
                    if (query != null) {
                        query.close();
                    }
                    return linkedList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                while (query.moveToNext()) {
                    linkedList.add(e.b(query));
                }
                if (query != null) {
                    query.close();
                }
                return linkedList;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static b c(ContentResolver contentResolver, g gVar, g gVar2) {
        Throwable th;
        String[] strArr = new String[]{"SUM(active_minutes)", "heart_rate_zone"};
        String str = a(gVar, gVar2) + ") GROUP BY (heart_rate_zone";
        Cursor query;
        try {
            b d;
            query = contentResolver.query(a, strArr, str, null, null);
            if (query == null) {
                try {
                    com.getpebble.android.common.b.a.f.a("HealthMinuteLevelSampleModel", "loadCardiacSummary: cursor is null");
                    d = b.d();
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else if (query.getCount() == 0) {
                com.getpebble.android.common.b.a.f.a("HealthMinuteLevelSampleModel", "loadCardiacSummary: no data returned");
                d = b.d();
                if (query != null) {
                    query.close();
                }
            } else {
                int[] iArr = new int[4];
                while (query.moveToNext()) {
                    int i = query.getInt(0);
                    int i2 = query.getInt(1);
                    if (i2 >= iArr.length) {
                        com.getpebble.android.common.b.a.f.a("HealthMinuteLevelSampleModel", "loadCardiacSummary: found zone " + i2 + " but only expected " + iArr.length + " zones.");
                    } else {
                        iArr[i2] = i;
                    }
                }
                d = b.a(iArr);
                if (query != null) {
                    query.close();
                }
            }
            return d;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static a d(ContentResolver contentResolver, g gVar, g gVar2) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(a, new String[]{"SUM(step_count)", "SUM(resting_gcal)", "SUM(active_gcal)", "SUM(distance_mm)", "SUM(active_minutes)"}, a(gVar, gVar2), null, null);
            if (query == null) {
                try {
                    com.getpebble.android.common.b.a.f.a("HealthMinuteLevelSampleModel", "loadActivitySummary: cursor is null");
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else if (query.moveToNext()) {
                a a = a.a(query.getInt(0), query.getInt(1), query.getInt(2), query.getInt(3), query.getInt(4));
                if (query == null) {
                    return a;
                }
                query.close();
                return a;
            } else {
                com.getpebble.android.common.b.a.f.a("HealthMinuteLevelSampleModel", "loadActivitySummary: no data returned");
                if (query != null) {
                    query.close();
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static String a(g gVar, g gVar2) {
        return String.format(Locale.getDefault(), "%s >= %d AND %s < %d", new Object[]{"date_local_secs", Long.valueOf(gVar.a()), "date_local_secs", Long.valueOf(gVar2.a())});
    }

    public static void a(ContentResolver contentResolver, long j) {
        contentResolver.delete(a, "date_utc_secs < ? ", new String[]{String.valueOf((int) (TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.DAYS.toSeconds(365)))});
    }

    public static void a(ContentResolver contentResolver, com.getpebble.android.framework.health.d.c cVar) {
        if (cVar == null) {
            com.getpebble.android.common.b.a.f.f("HealthMinuteLevelSampleModel", "insert(): record is null!");
            return;
        }
        int i;
        com.getpebble.android.framework.health.d.c.b[] c = cVar.c();
        int a = t.a(contentResolver, ak.retrieveLastConnectedDeviceSerial());
        ContentValues[] contentValuesArr = new ContentValues[c.length];
        int i2 = (int) cVar.a().b;
        for (i = 0; i < c.length; i++) {
            int i3;
            contentValuesArr[i] = new ContentValues();
            com.getpebble.android.framework.health.d.c.b bVar = c[i];
            contentValuesArr[i].put("watch_id", Integer.valueOf(a));
            contentValuesArr[i].put("step_count", Integer.valueOf(bVar.a));
            contentValuesArr[i].put("date_utc_secs", Integer.valueOf(i2));
            contentValuesArr[i].put("orientation", Integer.valueOf(bVar.b));
            contentValuesArr[i].put("vmc", Integer.valueOf(bVar.c));
            contentValuesArr[i].put("light", Integer.valueOf(bVar.d));
            contentValuesArr[i].put("plugged_in", Boolean.valueOf(bVar.a()));
            contentValuesArr[i].put("distance_mm", Long.valueOf(k.CENTIMETRES.toMillimetres((long) bVar.h)));
            contentValuesArr[i].put("resting_gcal", Integer.valueOf(bVar.f));
            contentValuesArr[i].put("active_gcal", Integer.valueOf(bVar.g));
            contentValuesArr[i].put("utc_to_local", Integer.valueOf(cVar.a().c));
            contentValuesArr[i].put("heart_rate_bpm", bVar.i > 0 ? Integer.valueOf(bVar.i) : null);
            contentValuesArr[i].put("heart_rate_weight", bVar.j);
            contentValuesArr[i].put("date_local_secs", Integer.valueOf(cVar.a().c + i2));
            ContentValues contentValues = contentValuesArr[i];
            String str = "active_minutes";
            if (bVar.b()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            contentValues.put(str, Integer.valueOf(i3));
            contentValuesArr[i].put("heart_rate_zone", bVar.k);
            i2 = (int) (((long) i2) + TimeUnit.MINUTES.toSeconds(1));
        }
        i = contentResolver.bulkInsert(x.a(a, 4), contentValuesArr);
        if (i != contentValuesArr.length) {
            com.getpebble.android.common.b.a.f.b("HealthMinuteLevelSampleModel", "insert: number of inserted samples is not accurate, expected " + contentValuesArr.length + " and got " + i);
        }
    }

    public static String a() {
        return "DELETE FROM steps WHERE rowid IN (SELECT a.rowid FROM steps a WHERE exists (SELECT b.rowid FROM steps b WHERE a.date = b.date AND a.rowid > b.rowid AND a.watch_serial = b.watch_serial ) );";
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i) {
        for (String execSQL : f.from(i).indices) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }
}
