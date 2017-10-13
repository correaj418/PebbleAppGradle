package com.getpebble.android.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.OperationApplicationException;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class af extends ai {
    private static final Uri a = com.getpebble.android.common.b.b.b.a("android_apps");
    private static final String[] b = new String[]{ai.COLUMN_ID, "package_name", "app_name", "app_version", "chosen", "allowed", "notification_count", "last_notified_time", "is_system_app", "muted_on", "is_sms_app"};

    public enum a {
        NEVER(0, R.id.mute_reset_pref, R.string.muted_never, new Integer[0]),
        WEEKENDS(1, R.id.mute_weekends, R.string.muted_on_weekends, Integer.valueOf(7), Integer.valueOf(1)),
        WEEKDAYS(2, R.id.mute_weekdays, R.string.muted_on_weekdays, Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6));
        
        public List<Integer> daysOfWeekMuted;
        private final int id;
        private final int menuResourceId;
        private final int stringResourceId;

        private a(int i, int i2, int i3, Integer... numArr) {
            this.daysOfWeekMuted = new ArrayList();
            this.id = i;
            this.stringResourceId = i3;
            this.menuResourceId = i2;
            if (numArr != null && numArr.length > 0) {
                this.daysOfWeekMuted = Arrays.asList(numArr);
            }
        }

        public boolean contains(int i) {
            return this.daysOfWeekMuted.contains(Integer.valueOf(i));
        }

        public int getId() {
            return this.id;
        }

        public int getMenuResId() {
            return this.menuResourceId;
        }

        public String getString() {
            return com.getpebble.android.common.a.K().getString(this.stringResourceId);
        }

        public static a from(int i) {
            for (a aVar : values()) {
                if (aVar.id == i) {
                    return aVar;
                }
            }
            return NEVER;
        }

        public static a fromMenu(int i) {
            for (a aVar : values()) {
                if (aVar.menuResourceId == i) {
                    return aVar;
                }
            }
            return NEVER;
        }
    }

    public static class b {
        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public final boolean e;
        public final int f;
        public final long g;
        public final boolean h;
        public final a i;
        public final boolean j;

        public b(String str, String str2, String str3, boolean z, boolean z2, int i, long j, boolean z3, a aVar, boolean z4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = z2;
            this.f = i;
            this.g = j;
            this.h = z3;
            this.i = aVar;
            this.j = z4;
        }

        public String toString() {
            return "AndroidAppRecord{packageName=" + this.a + ", appName='" + this.b + '\'' + ", appVersion=" + this.c + ", chosen='" + this.d + '\'' + ", allowed='" + this.e + '\'' + ", notificationCount='" + this.f + '\'' + ", lastNotifiedTimeMillis='" + this.g + '\'' + ", isSystemApp='" + this.h + '\'' + ", mutedOn ='" + this.i.name() + '\'' + ", isSmsApp ='" + this.j + '\'' + '}';
        }

        public a a() {
            return this.i;
        }
    }

    public af() {
        super("android_apps");
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "package_name");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "app_name"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "app_version"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "chosen"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "allowed"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "notification_count"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.TIMESTAMP, "last_notified_time"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_system_app"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "muted_on"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_sms_app"));
    }

    public static ContentValues a(b bVar) {
        int i;
        int i2 = 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put("package_name", bVar.a);
        contentValues.put("app_name", bVar.b);
        contentValues.put("app_version", bVar.c);
        contentValues.put("chosen", Integer.valueOf(bVar.d ? 1 : 0));
        String str = "allowed";
        if (bVar.e) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        contentValues.put("notification_count", Integer.valueOf(bVar.f));
        contentValues.put("last_notified_time", Long.valueOf(bVar.g));
        str = "is_system_app";
        if (bVar.h) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        contentValues.put("muted_on", Integer.valueOf(bVar.i.getId()));
        String str2 = "is_sms_app";
        if (!bVar.j) {
            i2 = 0;
        }
        contentValues.put(str2, Integer.valueOf(i2));
        return contentValues;
    }

    public static b a(Cursor cursor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        String string = cursor.getString(cursor.getColumnIndex("package_name"));
        String string2 = cursor.getString(cursor.getColumnIndex("app_name"));
        String string3 = cursor.getString(cursor.getColumnIndex("app_version"));
        if (cursor.getInt(cursor.getColumnIndex("chosen")) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (cursor.getInt(cursor.getColumnIndex("allowed")) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i = cursor.getInt(cursor.getColumnIndex("notification_count"));
        long j = cursor.getLong(cursor.getColumnIndex("last_notified_time"));
        if (cursor.getInt(cursor.getColumnIndex("is_system_app")) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        a from = a.from(cursor.getInt(cursor.getColumnIndex("muted_on")));
        if (cursor.getInt(cursor.getColumnIndex("is_sms_app")) == 1) {
            z4 = true;
        }
        return new b(string, string2, string3, z, z2, i, j, z3, from, z4);
    }

    public static Set<String> a(ContentResolver contentResolver) {
        Set<String> hashSet = new HashSet();
        String str = "is_system_app != ?";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, b, "is_system_app != ?", new String[]{"1"}, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashSet.add(a(query).a);
                } finally {
                    query.close();
                }
            }
        }
        return hashSet;
    }

    public static b a(String str, ContentResolver contentResolver) {
        b bVar = null;
        if (str != null) {
            String str2 = "package_name = ?";
            ContentResolver contentResolver2 = contentResolver;
            Cursor query = contentResolver2.query(a, b, "package_name = ?", new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        bVar = a(query);
                    }
                    query.close();
                } catch (Throwable th) {
                    query.close();
                }
            }
        }
        return bVar;
    }

    public static CursorLoader a(Context context) {
        String str = "app_name ASC";
        return new CursorLoader(context, a, b, null, null, "app_name ASC");
    }

    public static CursorLoader b(Context context) {
        return new CursorLoader(context, a, new String[]{"package_name"}, null, null, null);
    }

    public static Set<String> b(Cursor cursor) {
        Set<String> hashSet = new HashSet(cursor.getCount());
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            hashSet.add(cursor.getString(cursor.getColumnIndex("package_name")));
        }
        return hashSet;
    }

    public static CursorLoader a(Context context, String str) {
        String[] strArr = new String[]{str};
        return new CursorLoader(context, a, b, "app_name LIKE ?", strArr, "app_name ASC");
    }

    public static CursorLoader c(Context context) {
        Calendar instance = Calendar.getInstance();
        instance.add(2, -1);
        String str = "last_notified_time >= " + instance.getTime().getTime() + " AND " + "allowed" + " = ? OR " + "is_system_app" + " = ?";
        String[] strArr = new String[]{"1", "1"};
        return new CursorLoader(context, a, b, str, strArr, "app_name ASC");
    }

    public static synchronized boolean a(ContentResolver contentResolver, b bVar) {
        boolean z;
        int i = false;
        synchronized (af.class) {
            if (contentResolver == null) {
                throw new IllegalArgumentException("Cannot insert record with null content resolver");
            }
            b a = a(bVar.a, contentResolver);
            if (a == null) {
                f.d("PebbleAndroidAppModel", "Inserting notification record: " + bVar.toString());
                contentResolver.insert(a, a(bVar));
                z = true;
            } else if (!(com.getpebble.android.common.b.b.a.a(a.c, bVar.c) && com.getpebble.android.common.b.b.a.a(a.b, bVar.b) && a.j == bVar.j)) {
                String str = "package_name = ?";
                String[] strArr = new String[]{bVar.a};
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_name", bVar.b);
                contentValues.put("app_version", bVar.c);
                String str2 = "is_sms_app";
                if (bVar.j) {
                    i = 1;
                }
                contentValues.put(str2, Integer.valueOf(i));
                contentResolver.update(a, contentValues, "package_name = ?", strArr);
                z = true;
            }
        }
        return z;
    }

    public static synchronized void a(ContentResolver contentResolver, String str) {
        synchronized (af.class) {
            if (contentResolver == null) {
                throw new IllegalArgumentException("Cannot insert record with null content resolver");
            }
            String[] strArr = new String[]{str, "0"};
            contentResolver.delete(a, "package_name = ? AND is_system_app = ?", strArr);
        }
    }

    public static void a(String str, boolean z, ContentResolver contentResolver) {
        int i = 1;
        if (!z) {
            a(str, a.NEVER, contentResolver);
        }
        String str2 = "package_name = ?";
        String[] strArr = new String[]{str};
        ContentValues contentValues = new ContentValues();
        String str3 = "chosen";
        if (!z) {
            i = 0;
        }
        contentValues.put(str3, Integer.valueOf(i));
        contentResolver.update(a, contentValues, "package_name = ?", strArr);
    }

    public static boolean a() {
        b bVar = null;
        String str = "package_name = ?";
        Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(a, b, "package_name = ?", new String[]{"pbl_phone_calls"}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    bVar = a(query);
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        if (bVar == null) {
            return false;
        }
        return bVar.d;
    }

    public static void b(String str, boolean z, ContentResolver contentResolver) {
        int i = 1;
        String str2 = "package_name = ?";
        String[] strArr = new String[]{str};
        ContentValues contentValues = new ContentValues();
        String str3 = "allowed";
        if (!z) {
            i = 0;
        }
        contentValues.put(str3, Integer.valueOf(i));
        contentResolver.update(a, contentValues, "package_name = ?", strArr);
    }

    public static void a(String str, long j, ContentResolver contentResolver) {
        String str2 = "package_name = ?";
        String[] strArr = new String[]{str};
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_notified_time", Long.valueOf(j));
        contentResolver.update(a, contentValues, "package_name = ?", strArr);
    }

    public static void a(SQLiteDatabase sQLiteDatabase, Context context, boolean z, boolean z2) {
        ContentValues a = a(new b("pbl_phone_calls", context.getResources().getString(R.string.my_pebble_phone_notifications_title), "0", true, true, 0, System.currentTimeMillis(), true, a.NEVER, false));
        if (!z) {
            a.remove("muted_on");
        }
        if (!z2) {
            a.remove("is_sms_app");
        }
        sQLiteDatabase.insertOrThrow("android_apps", null, a);
    }

    public static void a(String str, a aVar, ContentResolver contentResolver) {
        if (aVar.equals(a.WEEKENDS) || aVar.equals(a.WEEKDAYS)) {
            a(str, true, contentResolver);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("muted_on", Integer.valueOf(aVar.getId()));
        String str2 = "package_name = ? ";
        contentResolver.update(a, contentValues, "package_name = ? ", new String[]{str});
    }

    public void updateLocalizedInfos() {
        Throwable e;
        f.d("PebbleAndroidAppModel", "updateLocalizedInfos:");
        Context K = com.getpebble.android.common.a.K();
        ContentResolver contentResolver = K.getContentResolver();
        Cursor query = contentResolver.query(a, new String[]{ai.COLUMN_ID, "package_name"}, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (query != null) {
            while (query.moveToNext()) {
                CharSequence string;
                long j = query.getLong(0);
                String string2 = query.getString(1);
                if ("pbl_phone_calls".equals(string2)) {
                    string = K.getString(R.string.my_pebble_phone_notifications_title);
                } else {
                    PackageManager packageManager = com.getpebble.android.common.a.K().getPackageManager();
                    while (packageManager != null) {
                        try {
                            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(string2, 128);
                            if (applicationInfo != null) {
                                string = packageManager.getApplicationLabel(applicationInfo);
                            }
                            string = null;
                        } catch (Throwable e2) {
                            f.a("PebbleAndroidAppModel", "updateLocalizedInfos: error ", e2);
                            string = null;
                        } catch (RuntimeException e3) {
                            if (e3.getCause() instanceof DeadObjectException) {
                                packageManager = com.getpebble.android.common.a.K().getPackageManager();
                                if (packageManager == null) {
                                    f.b("PebbleAndroidAppModel", "updateLocalizedInfos: PackageManager is null (during DeadObjectException retry)");
                                    string = null;
                                    break;
                                }
                            }
                        } catch (Throwable th) {
                            query.close();
                        }
                    }
                    string = null;
                }
                if (TextUtils.isEmpty(string)) {
                    f.b("PebbleAndroidAppModel", "updateLocalizedInfos: no name for app " + string2);
                } else {
                    arrayList.add(ContentProviderOperation.newUpdate(a).withValue("app_name", string).withSelection("_id=?", new String[]{String.valueOf(j)}).build());
                }
            }
            query.close();
        }
        try {
            contentResolver.applyBatch("com.getpebble.android.basalt.internal.provider", arrayList);
            return;
        } catch (OperationApplicationException e4) {
            e = e4;
        } catch (RemoteException e5) {
            e = e5;
        }
        f.a("PebbleAndroidAppModel", "updateLocalizedInfos: error ", e);
    }

    public static Set<String> b(ContentResolver contentResolver) {
        Set<String> hashSet = new HashSet();
        String str = "is_sms_app = 1";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, new String[]{"package_name"}, "is_sms_app = 1", null, null);
        if (query == null) {
            f.b("PebbleAndroidAppModel", "getSmsPackages: cursor is null!");
            return hashSet;
        }
        while (query.moveToNext()) {
            try {
                hashSet.add(query.getString(0));
            } finally {
                query.close();
            }
        }
        return hashSet;
    }
}
