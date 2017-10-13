package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.h.i;
import java.io.PrintStream;

public class as extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("preferences");

    public static class a {
        public final String a;
        public final b b;
        public final String c;

        public a(String str, b bVar, String str2) {
            this.a = str;
            this.b = bVar;
            this.c = str2;
        }

        public String toString() {
            return "Preference{key='" + this.a + '\'' + ", type=" + this.b + ", value='" + this.c + '\'' + '}';
        }
    }

    public enum b {
        UNKNOWN(0),
        STRING(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5),
        STRING_SET(6);
        
        private final int mValue;

        private b(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public static b from(int i) {
            for (b bVar : values()) {
                if (bVar.getValue() == i) {
                    return bVar;
                }
            }
            return UNKNOWN;
        }
    }

    public as() {
        super("preferences");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "name"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "key"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "type"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "value"));
    }

    public String getCreateTableCommand() {
        StringBuilder stringBuilder = new StringBuilder(super.getCreateTableCommand());
        CharSequence charSequence = ", UNIQUE(" + "name" + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "key" + ")";
        stringBuilder.insert(stringBuilder.length() - 2, charSequence, 0, charSequence.length());
        return stringBuilder.toString();
    }

    public static String a(ContentResolver contentResolver, String str, String str2, b bVar) {
        String str3 = null;
        String str4 = "key = ? AND name = ?";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, new String[]{"type", "value"}, "key = ? AND name = ?", new String[]{str2, str}, str3);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    if (b.from(query.getInt(query.getColumnIndex("type"))).getValue() != bVar.getValue()) {
                        f.b("PreferenceModel", String.format("Unexpected type <%s> for key <%s> type <%s>", new Object[]{b.from(query.getInt(query.getColumnIndex("type"))).toString(), str2, bVar.toString()}));
                        query.close();
                    } else {
                        str3 = query.getString(query.getColumnIndex("value"));
                        query.close();
                    }
                }
            } finally {
                query.close();
            }
        }
        return str3;
    }

    public static boolean a(ContentResolver contentResolver, String str, a aVar) {
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("name", str);
        contentValues.put("key", aVar.a);
        contentValues.put("type", Integer.valueOf(aVar.b.getValue()));
        contentValues.put("value", aVar.c);
        if (a(contentResolver, str, aVar.a)) {
            String str2 = "key = ? AND name = ?";
            try {
                contentResolver.update(a, contentValues, "key = ? AND name = ?", new String[]{aVar.a, str});
                return true;
            } catch (Throwable e) {
                f.d("PreferenceModel", "Failed to update data", e);
                return false;
            }
        }
        try {
            contentResolver.insert(a, contentValues);
            return true;
        } catch (Throwable e2) {
            f.d("PreferenceModel", "Failed to insert data; updating", e2);
            return false;
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, String str2) {
        String str3 = "key = ? AND name = ?";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, new String[]{"value"}, "key = ? AND name = ?", new String[]{str2, str}, null);
        if (query == null) {
            return false;
        }
        try {
            boolean moveToFirst = query.moveToFirst();
            return moveToFirst;
        } finally {
            query.close();
        }
    }

    public static ContentValues a(Cursor cursor) {
        ContentValues contentValues = new ContentValues(1);
        b from = b.from(cursor.getInt(cursor.getColumnIndex("type")));
        String string = cursor.getString(cursor.getColumnIndex("key"));
        String string2 = cursor.getString(cursor.getColumnIndex("value"));
        switch (from) {
            case STRING:
            case STRING_SET:
                contentValues.put(string, string2);
                break;
            case INT:
                try {
                    contentValues.put(string, Integer.valueOf(string2));
                    break;
                } catch (Throwable e) {
                    f.d("PreferenceModel", "NumberFormatException", e);
                    break;
                }
            case LONG:
                try {
                    contentValues.put(string, Long.valueOf(string2));
                    break;
                } catch (Throwable e2) {
                    f.d("PreferenceModel", "NumberFormatException", e2);
                    break;
                }
            case FLOAT:
                try {
                    contentValues.put(string, Float.valueOf(string2));
                    break;
                } catch (Throwable e22) {
                    f.d("PreferenceModel", "NumberFormatException", e22);
                    break;
                }
            case BOOLEAN:
                try {
                    contentValues.put(string, Boolean.valueOf(string2));
                    break;
                } catch (Throwable e222) {
                    f.d("PreferenceModel", "NumberFormatException", e222);
                    break;
                }
            default:
                f.d("PreferenceModel", "Unknown key: " + string);
                break;
        }
        return contentValues;
    }

    public static boolean b(ContentResolver contentResolver, String str, String str2) {
        String str3 = "name = ? AND key = ?";
        if (contentResolver.delete(a, "name = ? AND key = ?", new String[]{str, str2}) > 0) {
            return true;
        }
        return false;
    }

    public static void a(ContentResolver contentResolver, String str) {
        String str2 = "name = ?";
        int delete = contentResolver.delete(a, "name = ?", new String[]{str});
        f.d("PreferenceModel", String.format("Removed %d rows from file %s", new Object[]{Integer.valueOf(delete), str}));
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream) {
        Cursor query = contentResolver.query(a, null, null, null, "name ASC");
        try {
            i.a(query, printStream);
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }
}
