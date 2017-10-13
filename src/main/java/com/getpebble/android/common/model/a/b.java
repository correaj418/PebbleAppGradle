package com.getpebble.android.common.model.a;

import android.database.Cursor;
import com.getpebble.android.common.model.ai;

abstract class b extends a {
    b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, int i9, int i10, int i11, Integer num, Integer num2, Short sh, int i12, int i13) {
        super(i, i2, i3, i4, i5, i6, i7, i8, z, i9, i10, i11, num, num2, sh, i12, i13);
    }

    static h a(Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndexOrThrow(ai.COLUMN_ID));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("watch_id"));
        int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("step_count"));
        int i4 = cursor.getInt(cursor.getColumnIndexOrThrow("date_utc_secs"));
        int i5 = cursor.getInt(cursor.getColumnIndexOrThrow("utc_to_local"));
        int i6 = cursor.getInt(cursor.getColumnIndexOrThrow("orientation"));
        int i7 = cursor.getInt(cursor.getColumnIndexOrThrow("vmc"));
        int i8 = cursor.getInt(cursor.getColumnIndexOrThrow("light"));
        boolean z = cursor.getInt(cursor.getColumnIndexOrThrow("plugged_in")) == 1;
        int i9 = cursor.getInt(cursor.getColumnIndexOrThrow("distance_mm"));
        int i10 = cursor.getInt(cursor.getColumnIndexOrThrow("resting_gcal"));
        int i11 = cursor.getInt(cursor.getColumnIndexOrThrow("active_gcal"));
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("heart_rate_bpm");
        Integer valueOf = cursor.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursor.getInt(columnIndexOrThrow));
        columnIndexOrThrow = cursor.getColumnIndexOrThrow("heart_rate_weight");
        Integer valueOf2 = cursor.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursor.getInt(columnIndexOrThrow));
        columnIndexOrThrow = cursor.getColumnIndexOrThrow("heart_rate_zone");
        return new h(i, i2, i3, i4, i5, i6, i7, i8, z, i9, i10, i11, valueOf, valueOf2, cursor.isNull(columnIndexOrThrow) ? null : Short.valueOf(cursor.getShort(columnIndexOrThrow)), cursor.getInt(cursor.getColumnIndexOrThrow("date_local_secs")), cursor.getInt(cursor.getColumnIndexOrThrow("active_minutes")));
    }
}
