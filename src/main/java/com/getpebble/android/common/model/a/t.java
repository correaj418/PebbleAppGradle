package com.getpebble.android.common.model.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.ai.a;
import com.getpebble.android.common.model.ak;

public class t extends ai {
    public static final Uri a = b.a("watches");

    public t(int i) {
        super("watches", false, true);
        addColumn(new a(a.a.INTEGER, ak.SERIAL_NUMBER));
    }

    public static int a(ContentResolver contentResolver, String str) {
        Throwable th;
        String str2 = "serial_number = ?";
        Cursor query;
        try {
            query = contentResolver.query(a, new String[]{ai.COLUMN_ID}, "serial_number = ?", new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex(ai.COLUMN_ID));
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(ak.SERIAL_NUMBER, str);
            Uri insert = contentResolver.insert(a, contentValues);
            if (insert != null) {
                return (int) ContentUris.parseId(insert);
            }
            throw new IllegalStateException("Failed to create new record for watch " + str);
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static int a(SQLiteDatabase sQLiteDatabase, String str) {
        Throwable th;
        if (str == null) {
            throw new IllegalArgumentException("null serial");
        }
        String str2 = "serial_number = ?";
        Cursor query;
        try {
            query = sQLiteDatabase.query("watches", new String[]{ai.COLUMN_ID}, "serial_number = ?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex(ai.COLUMN_ID));
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(ak.SERIAL_NUMBER, str);
            long insert = sQLiteDatabase.insert("watches", null, contentValues);
            if (insert != -1) {
                return (int) insert;
            }
            throw new IllegalStateException("Failed to create new record for watch " + str);
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static String a() {
        return "CREATE UNIQUE INDEX `watches_serial_number` ON `watches` (`serial_number`);";
    }
}
