package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract.Calendars;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.h.i;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class o extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("calendars");
    private static final String[] b = new String[]{ai.COLUMN_ID, "name", "account_name", "calendar_displayName", "calendar_color", "visible", "calendar_access_level"};
    private static final String[] c = new String[]{ai.COLUMN_ID, "name", "account_name", "calendar_displayName", "calendar_color", "visible", "calendar_access_level", "selected"};

    public static class a {
        public final long a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final boolean f;
        public final int g;
        public boolean h;

        public a(long j, String str, String str2, String str3, int i, boolean z, boolean z2, int i2) {
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
            this.f = z;
            this.h = z2;
            this.g = i2;
        }

        public String toString() {
            return "Calendar: calendarId = " + this.a + " name = " + this.b + " accountName = " + this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.e != aVar.e) {
                return false;
            }
            if (this.a != aVar.a) {
                return false;
            }
            if (this.f != aVar.f) {
                return false;
            }
            if (this.c == null ? aVar.c != null : !this.c.equals(aVar.c)) {
                return false;
            }
            if (this.d == null ? aVar.d != null : !this.d.equals(aVar.d)) {
                return false;
            }
            if (this.b == null ? aVar.b != null : !this.b.equals(aVar.b)) {
                return false;
            }
            if (this.g != aVar.g) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            int i = 0;
            int hashCode2 = ((this.b != null ? this.b.hashCode() : 0) + (((int) (this.a ^ (this.a >>> 32))) * 31)) * 31;
            if (this.c != null) {
                hashCode = this.c.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.d != null) {
                hashCode = this.d.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode = (((hashCode + hashCode2) * 31) + this.e) * 31;
            if (this.f) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.g;
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ai.COLUMN_ID, Long.valueOf(this.a));
            contentValues.put("name", this.b);
            contentValues.put("account_name", this.c);
            contentValues.put("calendar_displayName", this.d);
            contentValues.put("calendar_color", Integer.valueOf(this.e));
            contentValues.put("visible", Boolean.valueOf(this.f));
            contentValues.put("calendar_access_level", Integer.valueOf(this.g));
            contentValues.put("selected", Boolean.valueOf(this.h));
            return contentValues;
        }
    }

    public enum b {
        SYSTEM,
        LOCAL
    }

    public o() {
        super("calendars");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "name"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "account_name"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "calendar_displayName"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "calendar_color"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "visible"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "calendar_access_level"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "selected"));
    }

    public static a a(Cursor cursor, b bVar) {
        boolean z;
        boolean z2 = true;
        int i = cursor.getInt(cursor.getColumnIndex(ai.COLUMN_ID));
        String string = cursor.getString(cursor.getColumnIndex("name"));
        String string2 = cursor.getString(cursor.getColumnIndex("account_name"));
        String string3 = cursor.getString(cursor.getColumnIndex("calendar_displayName"));
        int i2 = cursor.getInt(cursor.getColumnIndex("calendar_color"));
        boolean z3 = cursor.getInt(cursor.getColumnIndex("visible")) > 0;
        int i3 = cursor.getInt(cursor.getColumnIndex("calendar_access_level"));
        if (bVar.equals(b.LOCAL)) {
            if (cursor.getInt(cursor.getColumnIndex("selected")) <= 0) {
                z2 = false;
            }
            z = z2;
        } else {
            z = true;
        }
        return new a((long) i, string, string2, string3, i2, z3, z, i3);
    }

    public static Map<Long, a> a(ContentResolver contentResolver) {
        Cursor query;
        Map<Long, a> hashMap = new HashMap();
        try {
            String str = "sync_events = 1";
            query = contentResolver.query(Calendars.CONTENT_URI, b, "sync_events = 1", null, null);
        } catch (Throwable e) {
            f.d("CalendarModel", "Failed to fetch content from system database. (" + Calendars.CONTENT_URI.getPath() + ")", e);
            au.a(com.getpebble.android.common.model.au.a.SYSTEM_DB_NOT_FOUND, contentResolver);
            query = null;
        } catch (Throwable e2) {
            f.a("CalendarModel", "Something went wrong when trying to access the system database (" + Calendars.CONTENT_URI.getPath() + ")", e2);
            query = null;
        }
        if (query == null) {
            return hashMap;
        }
        while (query.moveToNext()) {
            try {
                a a = a(query, b.SYSTEM);
                hashMap.put(Long.valueOf(a.a), a);
            } finally {
                query.close();
            }
        }
        return hashMap;
    }

    public static Map<Long, a> b(ContentResolver contentResolver) {
        Map<Long, a> hashMap = new HashMap();
        Cursor query = contentResolver.query(a, c, null, null, null);
        if (query == null) {
            return hashMap;
        }
        while (query.moveToNext()) {
            try {
                a a = a(query, b.LOCAL);
                hashMap.put(Long.valueOf(a.a), a);
            } finally {
                query.close();
            }
        }
        return hashMap;
    }

    public static void a(ContentResolver contentResolver, a aVar) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot insert record with null content resolver");
        }
        f.d("CalendarModel", "Inserting calendar");
        contentResolver.insert(a, aVar.a());
    }

    public static void b(ContentResolver contentResolver, a aVar) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot update record with null content resolver");
        }
        f.d("CalendarModel", "Updating calendar");
        contentResolver.update(a, aVar.a(), "_id = ?", new String[]{aVar.a + ""});
    }

    public static void c(ContentResolver contentResolver, a aVar) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot delete record with null content resolver");
        }
        f.d("CalendarModel", "Deleting record from local database.");
        contentResolver.delete(a, "_id = ?", new String[]{aVar.a + ""});
    }

    public static boolean a(ContentResolver contentResolver, boolean z) {
        int i;
        String str = "selected = ?";
        String[] strArr = new String[1];
        strArr[0] = z ? "0" : "1";
        ContentValues contentValues = new ContentValues();
        String str2 = "selected";
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        if (contentResolver.update(a, contentValues, str, strArr) > 0) {
            return true;
        }
        return false;
    }

    public static boolean a(ContentResolver contentResolver, String str) {
        if (str == null) {
            f.c("CalendarModel", "isFromNewAccount: accountName is null");
            return false;
        }
        String[] strArr = new String[]{ai.COLUMN_ID};
        String[] strArr2 = new String[]{str};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, strArr, "name = ?", strArr2, null);
        if (query == null) {
            f.a("CalendarModel", "Null cursor from isFromNewAccount()");
            return false;
        }
        try {
            boolean z;
            if (query.moveToFirst()) {
                z = false;
            } else {
                z = true;
            }
            query.close();
            return z;
        } catch (Throwable th) {
            query.close();
        }
    }

    public static CursorLoader a(Context context) {
        return new CursorLoader(context, a, c, null, null, "account_name ASC, calendar_displayName ASC");
    }

    public static HashMap<Long, a> c(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, c, "selected = ?", new String[]{"1"}, null);
        HashMap<Long, a> hashMap = new HashMap();
        while (query.moveToNext()) {
            try {
                a a = a(query, b.LOCAL);
                if (!hashMap.containsKey(Long.valueOf(a.a))) {
                    hashMap.put(Long.valueOf(a.a), a);
                }
            } finally {
                query.close();
            }
        }
        return hashMap;
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream) {
        i.a(contentResolver, printStream, a, "name ASC");
    }

    public static void a(a aVar) {
        c y = PebbleApplication.y();
        f.c("CalendarModel", "Making " + aVar.toString() + " the new default calendar for Reminders.");
        y.b(com.getpebble.android.common.b.b.c.a.REMINDERS_DEFAULT_CALENDAR, aVar.a);
    }

    public static long a() {
        return PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.REMINDERS_DEFAULT_CALENDAR, -1);
    }
}
