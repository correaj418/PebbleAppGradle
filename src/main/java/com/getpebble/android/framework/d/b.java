package com.getpebble.android.framework.d;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.pebblekit.a;
import java.util.ArrayList;
import java.util.List;

public class b extends SQLiteOpenHelper {
    private final SQLiteDatabase a;
    private final a b;

    public b(Context context, a aVar) {
        super(context, "data_logging", null, 2);
        if (aVar == null) {
            throw new IllegalArgumentException("pebbleKit cannot be null");
        }
        this.a = getWritableDatabase();
        this.b = aVar;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session (`session_id` INTEGER,  `uuid` VARCHAR,  `timestamp` TIMESTAMP,  `app_log_tag` INTEGER,  `data_type` INTEGER,  `item_size` INTEGER,  `local_session_uuid` VARCHAR PRIMARY KEY,  `is_finished` INTEGER,  `next_data_id_sequence` INTEGER  ); ");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS item ( `local_session_uuid` VARCHAR,  `data_id` INTEGER,  `data_object` BLOB,   PRIMARY KEY(local_session_uuid, data_id) ); ");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS session");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS item");
        onCreate(sQLiteDatabase);
    }

    List<d> a() {
        List arrayList = new ArrayList();
        Cursor query = this.a.query("session", null, null, null, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    d dVar = new d(query, this, this.b);
                    f.d("DataloggingDb", "loading session from database: " + dVar + " numItems = " + a(dVar).size());
                    arrayList.add(dVar);
                } finally {
                    query.close();
                }
            }
        }
        return arrayList;
    }

    List<c> a(d dVar) {
        List arrayList = new ArrayList();
        String str = "data_id ASC";
        Cursor query = this.a.query("item", null, "local_session_uuid = ?", new String[]{dVar.e().toString()}, null, null, "data_id ASC");
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    c cVar = new c(query, dVar, this, this.b);
                    if (cVar != null) {
                        arrayList.add(cVar);
                    }
                } finally {
                    query.close();
                }
            }
        }
        return arrayList;
    }

    c a(d dVar, int i) {
        c cVar = null;
        Cursor query = this.a.query("item", null, "local_session_uuid = ? AND data_id = ?", new String[]{dVar.e().toString(), String.valueOf(i)}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    cVar = new c(query, dVar, this, this.b);
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return cVar;
    }

    void b(d dVar) {
        this.a.insertOrThrow("session", null, dVar.d());
    }

    void c(d dVar) {
        this.a.update("session", dVar.d(), "local_session_uuid = ?", new String[]{dVar.e().toString()});
    }

    void a(c cVar) {
        this.a.insertOrThrow("item", null, cVar.f());
    }

    void b(c cVar) {
        this.a.delete("item", "local_session_uuid = ? AND data_id = ?", new String[]{cVar.c().e().toString(), String.valueOf(cVar.d())});
    }

    void d(d dVar) {
        this.a.delete("session", "local_session_uuid = ?", new String[]{dVar.e().toString()});
    }

    void b() {
        this.a.beginTransaction();
    }

    void c() {
        this.a.setTransactionSuccessful();
    }

    void d() {
        this.a.endTransaction();
    }
}
