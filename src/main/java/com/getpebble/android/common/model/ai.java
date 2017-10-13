package com.getpebble.android.common.model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.getpebble.android.h.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ai {
    public static final String COLUMN_DATE_CREATED = "_date_created";
    public static final String COLUMN_DATE_UPDATED = "_date_updated";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IS_DIRTY = "_is_dirty";
    public static final String COLUMN_NEEDS_ADD = "_needs_add";
    public static final String COLUMN_NEEDS_DELETE = "_needs_delete";
    private final Map<a, a> mColumnMap;
    private String mTableName;

    public interface b {
        ContentValues a();
    }

    public static class a {
        private a a;
        private String b;
        private boolean c;
        private boolean d;
        private String e;

        public enum a {
            INTEGER("INTEGER"),
            STRING("VARCHAR"),
            TIMESTAMP("TIMESTAMP"),
            REAL("REAL"),
            BLOB("BLOB");
            
            private final String mSqlType;

            private a(String str) {
                this.mSqlType = str;
            }

            public String getSqlType() {
                return this.mSqlType;
            }
        }

        public boolean a() {
            return b().equalsIgnoreCase(ai.COLUMN_ID);
        }

        public a(a aVar, String str) {
            this(aVar, str, false, null);
        }

        public a(a aVar, String str, boolean z, String str2) {
            this.a = null;
            this.b = null;
            this.c = false;
            this.d = false;
            this.e = null;
            if (aVar == null || str == null) {
                throw new IllegalArgumentException("'type' and 'name' must not be null!");
            }
            this.a = aVar;
            this.b = str;
            this.d = z;
            this.e = str2;
        }

        public String b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public a a(boolean z) {
            this.c = z;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a d() {
            this.d = true;
            return this;
        }

        public boolean e() {
            return this.d;
        }

        public String f() {
            return this.e;
        }

        public String g() {
            return this.a.getSqlType();
        }
    }

    public ai(String str) {
        this(str, true, true);
    }

    public ai(String str, boolean z, boolean z2) {
        this.mColumnMap = new HashMap();
        this.mTableName = null;
        if (str == null) {
            throw new IllegalArgumentException("'tableName' cannot be null!");
        }
        this.mTableName = str;
        if (z2) {
            addColumn(new a(a.INTEGER, COLUMN_ID));
        }
        if (z) {
            addColumn(new a(a.INTEGER, COLUMN_IS_DIRTY));
            a aVar = new a(a.TIMESTAMP, COLUMN_DATE_CREATED);
            aVar.a("CURRENT_TIMESTAMP");
            addColumn(aVar);
            aVar = new a(a.TIMESTAMP, COLUMN_DATE_UPDATED);
            aVar.a("CURRENT_TIMESTAMP");
            addColumn(aVar);
            aVar = new a(a.INTEGER, COLUMN_NEEDS_ADD);
            aVar.a("0");
            addColumn(aVar);
            aVar = new a(a.INTEGER, COLUMN_NEEDS_DELETE);
            aVar.a("0");
            addColumn(aVar);
        }
    }

    public String getTableName() {
        return this.mTableName;
    }

    public String getCreateTableCommand() {
        return getCreateTableCommand(getTableName());
    }

    public String getCreateTableCommand(String str) {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        stringBuilder.append(str);
        stringBuilder.append(" (");
        for (a aVar : this.mColumnMap.keySet()) {
            stringBuilder.append(aVar.b());
            stringBuilder.append(" ");
            stringBuilder.append(aVar.g());
            if (aVar.e()) {
                stringBuilder.append(" NOT NULL");
            }
            if (aVar.c()) {
                stringBuilder.append(" UNIQUE");
            }
            if (aVar.a()) {
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

    public ai addColumn(a aVar) {
        this.mColumnMap.put(aVar, null);
        return this;
    }

    public ai removeColumn(a aVar) {
        this.mColumnMap.remove(aVar);
        return this;
    }

    public Set<a> getColumnSet() {
        return this.mColumnMap.keySet();
    }

    public void updateLocalizedInfos() {
    }

    public static void dropDefaultColumns(SQLiteDatabase sQLiteDatabase, String str, ai aiVar) {
        if (!x.a(sQLiteDatabase, str, aiVar.getColumnSet())) {
            throw new IllegalStateException("Error dropping columns!");
        }
    }
}
