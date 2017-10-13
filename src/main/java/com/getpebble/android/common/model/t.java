package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ai.a;

public class t extends ai {
    public static final Uri a = b.a("pebble_table_sync");

    public t() {
        super("pebble_table_sync");
        a aVar = new a(a.a.STRING, "data_table");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new a(a.a.TIMESTAMP, "last_sync_time"));
    }

    public static Cursor a(ContentResolver contentResolver, String str) {
        if (str == null) {
            throw new IllegalArgumentException("Table name cannot be null");
        }
        return contentResolver.query(a, null, "data_table = ?", new String[]{str}, null);
    }

    public static void a(ContentResolver contentResolver, String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data_table", str);
        contentValues.put("last_sync_time", Long.valueOf(j));
        Cursor a = a(contentResolver, str);
        if (a.moveToFirst()) {
            a.close();
            contentResolver.update(a, contentValues, "data_table = ?", new String[]{str});
            f.d("DatabaseSyncModel", "Table synced: updated row = " + contentValues);
            return;
        }
        a.close();
        contentResolver.insert(a, contentValues);
        f.d("DatabaseSyncModel", "Table synced: inserted row = " + contentValues);
    }

    public static long b(ContentResolver contentResolver, String str) {
        Cursor a = a(contentResolver, str);
        if (a.moveToFirst()) {
            long j = a.getLong(a.getColumnIndex("last_sync_time"));
            a.close();
            return j;
        }
        a.close();
        return 0;
    }
}
