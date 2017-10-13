package com.getpebble.android.common.model.a;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.common.b.b.b;

public class m {
    public static final Uri a = b.a("health_current_stats");

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("drop table if exists health_current_stats");
    }
}
