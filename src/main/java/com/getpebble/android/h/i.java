package com.getpebble.android.h;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.getpebble.android.common.model.an;
import com.google.b.f;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class i {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);

    public interface a<T> {
        void a(T t, Cursor cursor);
    }

    public static void a(Cursor cursor, PrintStream printStream) {
        a(cursor, printStream, new String[0], new String[0]);
    }

    public static void a(Cursor cursor, PrintStream printStream, String[] strArr, String[] strArr2) {
        printStream.println(">>>>> Dumping cursor " + cursor);
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                b(cursor, printStream, strArr, strArr2);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
    }

    public static void b(Cursor cursor, PrintStream printStream, String[] strArr, String[] strArr2) {
        SortedMap treeMap = new TreeMap();
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            String columnName = cursor.getColumnName(i);
            Object obj = null;
            try {
                for (String equals : strArr2) {
                    if (equals.equals(columnName)) {
                        long j = cursor.getLong(i);
                        obj = j + " / " + a.format(new Date(j));
                        break;
                    }
                }
                if (obj == null) {
                    obj = cursor.getString(i);
                }
                for (String equals2 : strArr) {
                    if (equals2.equals(columnName)) {
                        obj = com.getpebble.android.common.b.b.a.a(obj);
                        break;
                    }
                }
            } catch (SQLiteException e) {
                obj = "<unprintable>";
            }
            treeMap.put(columnName, obj);
        }
        printStream.println("" + cursor.getPosition() + " {");
        for (Entry entry : treeMap.entrySet()) {
            printStream.println("   " + ((String) entry.getKey()) + '=' + ((String) entry.getValue()));
        }
        printStream.println("}");
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream, Uri uri, String str) {
        a(contentResolver, printStream, uri, str, new String[0], new String[0]);
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream, Uri uri, String str, String[] strArr, String[] strArr2) {
        Cursor query = contentResolver.query(uri, null, null, null, str);
        try {
            a(query, printStream, strArr, strArr2);
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public static void b(ContentResolver contentResolver, PrintStream printStream, Uri uri, String str) {
        Cursor query = contentResolver.query(uri, null, null, null, str);
        printStream.println("[");
        Object obj = 1;
        f fVar = new f();
        while (query.moveToNext()) {
            try {
                com.getpebble.android.common.model.an.a a = com.getpebble.android.notifications.b.f.a(an.getRecordFromCursor(query));
                a.populateHumanReadableTimestamp();
                String b = fVar.b(a, com.getpebble.android.common.model.an.a.class);
                if (obj != null) {
                    obj = null;
                } else {
                    printStream.print(",");
                }
                printStream.println(b);
            } finally {
                query.close();
            }
        }
        printStream.print("]");
    }

    public static <T> void a(ContentResolver contentResolver, T t, a<T> aVar, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Throwable th;
        Cursor query;
        try {
            query = contentResolver.query(uri, strArr, str, strArr2, str2);
            while (query.moveToNext()) {
                try {
                    aVar.a(t, query);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
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
}
