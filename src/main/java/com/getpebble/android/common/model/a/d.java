package com.getpebble.android.common.model.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.health.d.e;
import com.getpebble.android.h.g;
import com.getpebble.android.h.x;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class d extends ai {
    public static final String a = b.CURRENT.tableName;
    public static final Uri b = com.getpebble.android.common.b.b.b.a(a);

    public enum a {
        VERSION("version"),
        ACTIVITY_TYPE("activity_type"),
        UTC_TO_LOCAL_SECS("utc_to_local"),
        START_UTC_SECS("start_utc_secs"),
        ELAPSED_SEC("elapsed_sec"),
        DEVICE_SERIAL("device_serial"),
        STEPS("steps"),
        ACTIVE_KCAL("active_kcal"),
        RESTING_KCAL("resting_kcal"),
        DISTANCE_METRES("distance");
        
        private final String name;

        private a(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public enum b {
        ONE(4, "activity_session", new String[]{" CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_time_type_activity_session ON activity_session(device_serial, start_utc_secs, activity_type);"}, new com.getpebble.android.common.model.ai.a[]{new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.VERSION.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.ACTIVITY_TYPE.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.UTC_TO_LOCAL_SECS.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.START_UTC_SECS.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.ELAPSED_SEC.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, a.DEVICE_SERIAL.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.STEPS.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.ACTIVE_KCAL.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.RESTING_KCAL.name), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.DISTANCE_METRES.name)}),
        TWO(16, "activity_sessions", new String[]{" CREATE UNIQUE INDEX IF NOT EXISTS  `activity_sessions_uniq` ON `activity_sessions` (watch_id, type, start_utc_secs);", " CREATE INDEX IF NOT EXISTS  `activity_sessions_start_local_secs` ON `activity_sessions` (start_local_secs);", " CREATE INDEX IF NOT EXISTS  `activity_sessions_end_local_secs` ON `activity_sessions` (end_local_secs);"}, new com.getpebble.android.common.model.ai.a[]{new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "watch_id", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "type", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "start_utc_secs", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "end_utc_secs", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "utc_to_local_secs", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "start_local_secs", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "end_local_secs", true, null), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "step_count", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "distance_mm", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "resting_gcal", true, "0"), new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "active_gcal", true, "0")});
        
        public static final b CURRENT = null;
        final com.getpebble.android.common.model.ai.a[] columns;
        public final int healthDbVersion;
        final String[] indices;
        public final String tableName;

        static {
            CURRENT = TWO;
        }

        private b(int i, String str, String[] strArr, com.getpebble.android.common.model.ai.a[] aVarArr) {
            this.healthDbVersion = i;
            this.tableName = str;
            this.indices = strArr;
            this.columns = aVarArr;
        }

        public static b from(int i) {
            b bVar = ONE;
            b[] values = values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                b bVar2 = values[i2];
                if (bVar2.healthDbVersion > i || bVar2.healthDbVersion <= bVar.healthDbVersion) {
                    bVar2 = bVar;
                }
                i2++;
                bVar = bVar2;
            }
            return bVar;
        }
    }

    public d(int i) {
        int i2 = 0;
        super(b.from(i).tableName, false, true);
        com.getpebble.android.common.model.ai.a[] aVarArr = b.from(i).columns;
        int length = aVarArr.length;
        while (i2 < length) {
            addColumn(aVarArr[i2]);
            i2++;
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i) {
        for (String execSQL : b.from(i).indices) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        b from = b.from(3);
        sQLiteDatabase.execSQL(x.a(from.tableName, new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.STEPS.name)));
        sQLiteDatabase.execSQL(x.a(from.tableName, new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.ACTIVE_KCAL.name)));
        sQLiteDatabase.execSQL(x.a(from.tableName, new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.RESTING_KCAL.name)));
        sQLiteDatabase.execSQL(x.a(from.tableName, new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, a.DISTANCE_METRES.name)));
    }

    public static boolean a(ContentResolver contentResolver, com.getpebble.android.framework.health.d.a aVar) {
        return contentResolver.insert(x.a(b, 4), aVar.d()) != null;
    }

    public static void a(ContentResolver contentResolver, long j) {
        contentResolver.delete(b, "start_utc_secs < ? ", new String[]{String.valueOf(((long) (((int) j) / 1000)) - TimeUnit.DAYS.toSeconds(365))});
    }

    public static List<com.getpebble.android.framework.health.d.a> a(ContentResolver contentResolver, g gVar, g gVar2, Set<com.getpebble.android.framework.health.d.a.a> set) {
        String str = "end_local_secs >= " + gVar.a() + " AND " + "end_local_secs" + " < " + gVar2.a() + " AND " + "type" + " IN (" + a((Iterable) set) + ")";
        f.e("ActivitySessionModel", "SELECT * FROM activity_sessions WHERE " + str);
        String str2 = "start_utc_secs ASC";
        Cursor query = contentResolver.query(b, null, str, null, "start_utc_secs ASC");
        List<com.getpebble.android.framework.health.d.a> linkedList = new LinkedList();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    linkedList.add(a(query));
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            f.e("ActivitySessionModel", ".. size = " + linkedList.size());
        } else if (query != null) {
            query.close();
        }
        return linkedList;
    }

    public static List<e> a(ContentResolver contentResolver, int i, int i2) {
        Throwable th;
        String str = "_id > " + i;
        String str2 = "_id LIMIT " + i2;
        List<e> linkedList = new LinkedList();
        Cursor query;
        try {
            query = contentResolver.query(b, null, str, null, str2);
            while (query.moveToNext()) {
                try {
                    linkedList.add(new e(a(query), query.getInt(query.getColumnIndex(ai.COLUMN_ID))));
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

    private static <T extends com.getpebble.android.framework.health.d.a.a> String a(Iterable<T> iterable) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (T t : iterable) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            }
            stringBuilder.append(t.num);
        }
        return stringBuilder.toString();
    }

    public static boolean a(ContentResolver contentResolver, Set<com.getpebble.android.framework.health.d.a.a> set) {
        Cursor query;
        Throwable th;
        String str = "type IN (" + a((Iterable) set) + ")";
        try {
            ContentResolver contentResolver2 = contentResolver;
            query = contentResolver2.query(b, new String[]{"1"}, str, null, "1 LIMIT 1");
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

    public static com.getpebble.android.framework.health.d.a a(Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndex("watch_id"));
        int i2 = cursor.getInt(cursor.getColumnIndex("type"));
        int i3 = cursor.getInt(cursor.getColumnIndex("utc_to_local_secs"));
        long j = cursor.getLong(cursor.getColumnIndex("start_utc_secs"));
        long j2 = cursor.getLong(cursor.getColumnIndex("end_utc_secs"));
        long j3 = cursor.getLong(cursor.getColumnIndex("start_local_secs"));
        long j4 = cursor.getLong(cursor.getColumnIndex("end_local_secs"));
        int i4 = cursor.getInt(cursor.getColumnIndex("step_count"));
        int i5 = cursor.getInt(cursor.getColumnIndex("active_gcal"));
        int i6 = cursor.getInt(cursor.getColumnIndex("resting_gcal"));
        int i7 = cursor.getInt(cursor.getColumnIndex("distance_mm"));
        com.getpebble.android.framework.health.d.a.a from = com.getpebble.android.framework.health.d.a.a.from(i2);
        if (com.getpebble.android.framework.health.d.a.a.Unknown.equals(from)) {
            f.f("ActivitySessionModel", "PBL-36372 Failed to create ActivitySessionRecord due to unknown ActivityType: " + i2);
        }
        return new com.getpebble.android.framework.health.d.a(i, from, i3, j, j2, j3, j4, i4, (long) i5, (long) i6, (long) i7);
    }

    public static String a() {
        return "DELETE FROM activity_session WHERE rowid IN (SELECT a.rowid FROM activity_session a WHERE exists (SELECT b.rowid FROM activity_session b WHERE a.start_utc_secs = b.start_utc_secs AND a.rowid > b.rowid AND a.device_serial = b.device_serial AND a.activity_type = b.activity_type ));";
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        b from = b.from(15);
        b from2 = b.from(16);
        sQLiteDatabase.execSQL(new d(16).getCreateTableCommand());
        a(sQLiteDatabase, 16);
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT DISTINCT " + a.DEVICE_SERIAL.name + " AS " + ak.SERIAL_NUMBER + " FROM " + from.tableName, null);
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex(ak.SERIAL_NUMBER));
                if (string == null) {
                    f.b("ActivitySessionModel", "perform_v15_migration: found ActivitySession entries with NULL serial");
                } else {
                    f.d("ActivitySessionModel", "perform_v15_migration: watch with serial " + string + " added to HealthWatchModel with ID " + t.a(sQLiteDatabase, string));
                }
            }
            sQLiteDatabase.execSQL("INSERT INTO " + from2.tableName + "(" + "watch_id" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "type" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "start_utc_secs" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "end_utc_secs" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "utc_to_local_secs" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "start_local_secs" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "end_local_secs" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "step_count" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "distance_mm" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "resting_gcal" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "active_gcal" + ") SELECT (SELECT _id FROM " + "watches" + " WHERE " + ak.SERIAL_NUMBER + " = " + a.DEVICE_SERIAL + ") AS " + "watch_id" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + a.ACTIVITY_TYPE + " AS " + "type" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + a.START_UTC_SECS + " AS " + "start_utc_secs" + ", (" + a.START_UTC_SECS + " + " + a.ELAPSED_SEC + ") AS " + "end_utc_secs" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + a.UTC_TO_LOCAL_SECS + " AS " + "utc_to_local_secs" + ", (" + a.START_UTC_SECS + " + " + a.UTC_TO_LOCAL_SECS + ") AS " + "start_local_secs" + ", (" + a.START_UTC_SECS + " + " + a.UTC_TO_LOCAL_SECS + " + " + a.ELAPSED_SEC + ") AS " + "end_local_secs" + ", IFNULL(" + a.STEPS + ", 0) AS " + "step_count" + ", IFNULL(" + a.DISTANCE_METRES + " * 1000, 0) AS " + "distance_mm" + ", IFNULL(" + a.RESTING_KCAL + " * 1000, 0) AS " + "resting_gcal" + ", IFNULL(" + a.ACTIVE_KCAL + " * 1000, 0) AS " + "active_gcal" + " FROM " + from.tableName);
            sQLiteDatabase.execSQL("DROP TABLE " + from.tableName);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
