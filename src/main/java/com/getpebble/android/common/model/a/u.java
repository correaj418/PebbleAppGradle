package com.getpebble.android.common.model.a;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.ai.a;

@Deprecated
public class u extends ai {
    @Deprecated
    public static final Uri a = b.a("heart_rates");

    @Deprecated
    public u() {
        super("heart_rates", false, true);
        addColumn(new a(a.a.INTEGER, "device_serial").d());
        addColumn(new a(a.a.INTEGER, "date").d());
        addColumn(new a(a.a.INTEGER, "utc_to_local").d());
        addColumn(new a(a.a.INTEGER, "beats_per_minute").d());
    }

    @Deprecated
    public static String a() {
        return " CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_time_heart_rate ON heart_rates(device_serial, date);";
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE heart_rates");
    }
}
