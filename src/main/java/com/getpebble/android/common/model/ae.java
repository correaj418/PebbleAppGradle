package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;

public class ae extends ai {
    public static final Uri a = b.a("mobile_alerts");
    private static final String[] b = new String[]{ai.COLUMN_ID, "time_updated", "alert_type", "alert_priority"};

    public static class a {
        public final long a;
        public final a b;

        public a(long j, a aVar) {
            this.a = j;
            this.b = aVar;
        }
    }

    public ae() {
        super("mobile_alerts");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.TIMESTAMP, "time_updated"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "alert_type"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "alert_priority"));
    }

    public static CursorLoader a(Context context) {
        return new CursorLoader(context, a, b, null, null, "alert_priority ASC");
    }

    private static long c(a aVar, ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, new String[]{ai.COLUMN_ID}, "alert_type = ? ", new String[]{String.valueOf(aVar.id)}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    long j = (long) query.getInt(query.getColumnIndex(ai.COLUMN_ID));
                    return j;
                }
                query.close();
            } finally {
                query.close();
            }
        }
        return -1;
    }

    public static void a(a aVar, ContentResolver contentResolver) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot insert record with null content resolver");
        }
        long c = c(aVar.b, contentResolver);
        f.d("MobileAlertModel", "Inserting mobile alert record: " + aVar);
        ContentValues contentValues = new ContentValues(b.length);
        contentValues.put("time_updated", Long.valueOf(aVar.a));
        contentValues.put("alert_type", Integer.valueOf(aVar.b.id));
        contentValues.put("alert_priority", Integer.valueOf(aVar.b.priority));
        if (c > 0) {
            contentResolver.update(a, contentValues, "_id = ?", new String[]{String.valueOf(c)});
            return;
        }
        contentResolver.insert(a, contentValues);
    }

    public static a a(Cursor cursor) {
        return new a(cursor.getLong(cursor.getColumnIndex("time_updated")), a.from(cursor.getInt(cursor.getColumnIndex("alert_type"))));
    }

    public static void a(a aVar, ContentResolver contentResolver) {
        contentResolver.delete(a, "alert_type = ?", new String[]{String.valueOf(aVar.id)});
    }

    public static int a(ContentResolver contentResolver) {
        Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(a, b, null, null, null);
        if (query == null) {
            return 0;
        }
        try {
            int count = query.getCount();
            return count;
        } finally {
            query.close();
        }
    }

    public static boolean b(a aVar, ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, new String[]{ai.COLUMN_ID}, "alert_type = ? ", new String[]{String.valueOf(aVar.id)}, null);
        if (query == null) {
            return false;
        }
        try {
            if (query.getCount() > 0) {
                return true;
            }
            query.close();
            return false;
        } finally {
            query.close();
        }
    }
}
