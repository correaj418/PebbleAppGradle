package com.getpebble.android.h;

import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.framework.timeline.e;
import com.google.a.b.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class x {

    public static abstract class a<T> {
        private final ContentResolver a;
        private final int b;

        protected abstract String a(Collection<T> collection);

        protected abstract void a(ContentResolver contentResolver, String[] strArr, String str);

        protected a(ContentResolver contentResolver) {
            this(contentResolver, 800);
        }

        protected a(ContentResolver contentResolver, int i) {
            this.a = contentResolver;
            this.b = i;
        }

        public void a(List<T> list) {
            for (Collection collection : aw.a((List) list, this.b)) {
                String a = a(collection);
                a(this.a, x.a(collection), a);
            }
        }
    }

    public static String a(String str, List<List<String>> list) {
        return a(str, a((List) list));
    }

    static String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.insert(stringBuilder.length() - 2, str2, 0, str2.length());
        return stringBuilder.toString();
    }

    static String a(List<List<String>> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List list2 : list) {
            stringBuilder.append(", UNIQUE(");
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                stringBuilder.append(it.next());
                if (it.hasNext()) {
                    stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
                }
            }
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }

    public static String b(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next()).append(" = ?");
            if (it.hasNext()) {
                stringBuilder.append(" AND ");
            }
        }
        return stringBuilder.toString();
    }

    public static String a(String str, com.getpebble.android.common.model.ai.a aVar, String str2) {
        return a(str, aVar) + " DEFAULT '" + str2 + "'";
    }

    public static String a(String str, com.getpebble.android.common.model.ai.a aVar) {
        return "ALTER TABLE " + str + " ADD COLUMN " + aVar.b() + " " + aVar.g();
    }

    public static String b(String str, String str2) {
        return "UPDATE " + str + " SET " + str2 + " = NULL";
    }

    public static String a(String str, String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : strArr) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            }
            stringBuilder.append(str2 + " = NULL ");
        }
        return "UPDATE " + str + " SET " + stringBuilder.toString();
    }

    public static String a(String str) {
        return "DELETE FROM " + str;
    }

    public static String a(String str, Set<com.getpebble.android.common.model.ai.a> set) {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        stringBuilder.append(str);
        stringBuilder.append(" (");
        for (com.getpebble.android.common.model.ai.a aVar : set) {
            stringBuilder.append(aVar.b());
            stringBuilder.append(" ");
            stringBuilder.append(aVar.g());
            if (aVar.c()) {
                stringBuilder.append(" UNIQUE");
            }
            if (aVar.b().equalsIgnoreCase(ai.COLUMN_ID)) {
                stringBuilder.append(" PRIMARY KEY AUTOINCREMENT ");
            }
            if (aVar.f() != null) {
                stringBuilder.append(" DEFAULT " + aVar.f());
            }
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, Set<com.getpebble.android.common.model.ai.a> set) {
        boolean z;
        String str2 = "table_backup";
        String a = a(str2, (Set) set);
        String a2 = a(str, (Set) set);
        String a3 = a((Set) set);
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(a);
            sQLiteDatabase.execSQL("INSERT INTO " + str2 + " SELECT " + a3 + " FROM " + str);
            sQLiteDatabase.execSQL("DROP TABLE " + str);
            sQLiteDatabase.execSQL(a2);
            sQLiteDatabase.execSQL("INSERT INTO " + str + " SELECT " + a3 + " FROM " + str2);
            sQLiteDatabase.execSQL("DROP TABLE " + str2);
            sQLiteDatabase.setTransactionSuccessful();
            z = true;
        } catch (Throwable e) {
            f.a("SQLUtil", "error", e);
            z = false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
        return z;
    }

    public static String a(ai aiVar) {
        return a(aiVar.getColumnSet());
    }

    private static String a(Set<com.getpebble.android.common.model.ai.a> set) {
        StringBuilder stringBuilder = new StringBuilder();
        for (com.getpebble.android.common.model.ai.a aVar : set) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(aVar.b());
        }
        return stringBuilder.toString();
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, ai aiVar, boolean z) {
        boolean z2;
        String str = "temp_" + aiVar.getTableName();
        StringBuilder stringBuilder = new StringBuilder();
        for (com.getpebble.android.common.model.ai.a aVar : aiVar.getColumnSet()) {
            if (!z || !aVar.a()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(aVar.b());
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + aiVar.getTableName() + " RENAME TO " + str);
            sQLiteDatabase.execSQL(aiVar.getCreateTableCommand());
            sQLiteDatabase.execSQL("INSERT INTO " + aiVar.getTableName() + "(" + stringBuilder2 + ") SELECT " + stringBuilder2 + " FROM " + str);
            sQLiteDatabase.execSQL("DROP TABLE " + str);
            sQLiteDatabase.setTransactionSuccessful();
            z2 = true;
        } catch (Throwable e) {
            f.a("SQLUtil", "error", e);
            z2 = false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
        return z2;
    }

    public static Uri a(Uri uri, int i) {
        return uri.buildUpon().appendQueryParameter("insert-with-on-conflict", String.valueOf(i)).build();
    }

    public static Uri a(Uri uri, String str) {
        return uri.buildUpon().appendQueryParameter("increment-column", str).build();
    }

    public static String a(int i) {
        StringBuilder stringBuilder = new StringBuilder(" IN (");
        Object obj = 1;
        for (int i2 = 0; i2 < i; i2++) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            }
            stringBuilder.append("?");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String[] a(Collection collection) {
        List arrayList = new ArrayList();
        for (Object next : collection) {
            if (next != null) {
                arrayList.add(next.toString());
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static <T> String a(Iterable<T> iterable, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (obj == null) {
                stringBuilder.append(" SELECT ");
            }
            stringBuilder.append("'").append(next).append("'");
            if (obj != null) {
                stringBuilder.append(" AS ").append(str);
                obj = null;
            }
            if (it.hasNext()) {
                stringBuilder.append(" UNION ALL");
            }
        }
        return stringBuilder.toString();
    }
}
