package com.getpebble.jskit.android.impl.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.getpebble.jskit.android.a.a;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class c extends SQLiteOpenHelper implements a {
    private final SQLiteDatabase a = getWritableDatabase();

    public c(Context context) {
        super(context, "local_storage_db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_storage_table (`app_id` VARCHAR,  `key` VARCHAR,  `value` VARCHAR,  `_id` INTEGER PRIMARY KEY AUTOINCREMENT , UNIQUE(app_id, key) ON CONFLICT REPLACE );");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new UnsupportedOperationException(String.format("Failed to upgrade database from %d to %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public void a(String str, Set<Entry<String, String>> set) {
        a.a(2, null, "LocalStorageModel", "writeAll: appId = " + str);
        this.a.beginTransaction();
        try {
            for (Entry entry : set) {
                a(str, (String) entry.getKey(), (String) entry.getValue());
            }
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(String str, String str2, String str3) {
        a.a(2, null, "LocalStorageModel", "write: appId = ", str, ", key = ", str2, ", value = ", str3);
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("app_id", str);
        contentValues.put("key", str2);
        contentValues.put("value", str3);
        this.a.insertWithOnConflict("app_storage_table", null, contentValues, 5);
    }

    public String a(String str, String str2) {
        a.a(2, null, "LocalStorageModel", "read: appId = ", str, ", key = ", str2);
        String[] strArr = new String[]{"key", "value"};
        String[] strArr2 = new String[]{str, str2};
        Cursor query = this.a.query("app_storage_table", strArr, "app_id = ? AND key = ?", strArr2, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            String string;
            if (query.moveToFirst()) {
                string = query.getString(query.getColumnIndex("value"));
            } else {
                string = null;
            }
            query.close();
            a.a(2, null, "LocalStorageModel", "read: value = ", string);
            return string;
        } catch (Throwable th) {
            query.close();
        }
    }

    public void b(String str, String str2) {
        String[] strArr = new String[]{str, str2};
        int delete = this.a.delete("app_storage_table", "app_id = ? AND key = ?", strArr);
        a.a(2, null, "LocalStorageModel", "remove: key = ", str2, ", rows = ", Integer.valueOf(delete));
    }

    public String a(String str) {
        String[] strArr = new String[]{"key", "value"};
        String[] strArr2 = new String[]{str};
        Cursor query = this.a.query("app_storage_table", strArr, "app_id = ?", strArr2, null, null, "key ASC");
        JSONObject jSONObject = new JSONObject();
        if (query == null) {
            return jSONObject.toString();
        }
        while (query.moveToNext()) {
            try {
                jSONObject.put(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex("value")));
            } catch (JSONException e) {
                a.a(6, null, "LocalStorageModel", "readAll: Error copying localstorage values for " + str, e);
            } catch (Throwable th) {
                query.close();
            }
        }
        query.close();
        a.a(2, null, "LocalStorageModel", "readAll: appId = ", str, ", value = ", jSONObject);
        return jSONObject.toString();
    }

    public void b(String str) {
        String[] strArr = new String[]{str};
        int delete = this.a.delete("app_storage_table", "app_id = ?", strArr);
        a.a(2, null, "LocalStorageModel", "removeAll: appId = ", str, ", rows = ", Integer.valueOf(delete));
    }
}
