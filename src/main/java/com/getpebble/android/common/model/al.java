package com.getpebble.android.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ai.a;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.h.i;
import com.getpebble.android.h.x;
import java.io.PrintStream;
import java.util.List;

public class al extends ai {
    public static final Uri a = b.a("manifests");
    private static final String[] b = new String[]{"normal_timestamp", "recovery_timestamp", "migration_timestamp"};

    public al() {
        super("manifests");
        a aVar = new a(a.a.INTEGER, ak.HW_PLATFORM);
        aVar.a(true);
        addColumn(aVar);
        addColumn(new a(a.a.STRING, "normal_url"));
        addColumn(new a(a.a.INTEGER, "normal_timestamp"));
        addColumn(new a(a.a.STRING, "normal_notes"));
        addColumn(new a(a.a.STRING, "normal_version"));
        addColumn(new a(a.a.STRING, "normal_SHA256"));
        addColumn(new a(a.a.STRING, "recovery_url"));
        addColumn(new a(a.a.INTEGER, "recovery_timestamp"));
        addColumn(new a(a.a.STRING, "recovery_notes"));
        addColumn(new a(a.a.STRING, "recovery_version"));
        addColumn(new a(a.a.STRING, "recovery_SHA256"));
        addColumn(new a(a.a.STRING, "migration_url"));
        addColumn(new a(a.a.INTEGER, "migration_timestamp"));
        addColumn(new a(a.a.STRING, "migration_notes"));
        addColumn(new a(a.a.STRING, "migration_version"));
        addColumn(new a(a.a.STRING, "migration_SHA256"));
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a("manifests", new a(a.a.STRING, "migration_url")));
        sQLiteDatabase.execSQL(x.a("manifests", new a(a.a.INTEGER, "migration_timestamp")));
        sQLiteDatabase.execSQL(x.a("manifests", new a(a.a.STRING, "migration_notes")));
        sQLiteDatabase.execSQL(x.a("manifests", new a(a.a.STRING, "migration_version")));
        sQLiteDatabase.execSQL(x.a("manifests", new a(a.a.STRING, "migration_SHA256")));
    }

    public static Cursor a(ContentResolver contentResolver, String[] strArr) {
        return contentResolver.query(a, strArr, null, null, null);
    }

    public static ContentProviderOperation a(List<String> list) {
        return ContentProviderOperation.newDelete(a).withSelection("_id IN (" + TextUtils.join(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR, list) + ")", null).build();
    }

    public static ContentProviderOperation a(ContentValues contentValues) {
        return ContentProviderOperation.newInsert(a).withValues(contentValues).build();
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream) {
        ContentResolver contentResolver2 = contentResolver;
        PrintStream printStream2 = printStream;
        i.a(contentResolver2, printStream2, a, "hw_platform ASC", new String[0], b);
    }
}
