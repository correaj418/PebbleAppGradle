package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.h.x;
import com.getpebble.android.notifications.a.a.e;
import com.google.a.b.ad;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class c extends ai {
    private static final Uri a = b.a("notification_settings");
    private static final String[] b = new String[]{"package_name", "check_when", "check_removed_time", "removed_thres_ms"};

    public static class a {
        public final String a;
        public final boolean b;
        public final boolean c;
        public final long d;

        public a(String str, boolean z, boolean z2, long j) {
            this.a = str;
            this.b = z;
            this.c = z2;
            this.d = j;
        }

        public ContentValues a() {
            int i;
            int i2 = 1;
            ContentValues contentValues = new ContentValues();
            contentValues.put("package_name", this.a);
            String str = "check_when";
            if (this.b) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str, Integer.valueOf(i));
            String str2 = "check_removed_time";
            if (!this.c) {
                i2 = 0;
            }
            contentValues.put(str2, Integer.valueOf(i2));
            contentValues.put("removed_thres_ms", Long.valueOf(this.d));
            return contentValues;
        }

        public static a a(Cursor cursor) {
            boolean z;
            boolean z2 = false;
            String string = cursor.getString(cursor.getColumnIndex("package_name"));
            if (cursor.getInt(cursor.getColumnIndex("check_when")) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (cursor.getInt(cursor.getColumnIndex("check_removed_time")) > 0) {
                z2 = true;
            }
            return new a(string, z, z2, cursor.getLong(cursor.getColumnIndex("removed_thres_ms")));
        }
    }

    public c() {
        super("notification_settings");
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "package_name");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "check_when"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "check_removed_time"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "removed_thres_ms"));
    }

    public static void a(Context context, SQLiteDatabase sQLiteDatabase) {
        try {
            Map a = e.a(e.a(context));
            if (a == null) {
                f.a("AndroidNotificationConfigModel", "Failed to load default notification config (null map)");
                return;
            }
            for (Entry entry : a.entrySet()) {
                e eVar = (e) entry.getValue();
                String str = "notification_settings";
                sQLiteDatabase.insertOrThrow(str, null, new a((String) entry.getKey(), eVar.a, eVar.b, TimeUnit.SECONDS.toMillis(eVar.c)).a());
            }
        } catch (Throwable e) {
            f.a("AndroidNotificationConfigModel", "Failed to load default notification config", e);
        }
    }

    static a a(ContentResolver contentResolver, String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            ContentResolver contentResolver2 = contentResolver;
            Cursor query = contentResolver2.query(a, b, x.b(ad.a((Object) "package_name")), new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        aVar = a.a(query);
                    } else {
                        query.close();
                    }
                } finally {
                    query.close();
                }
            }
        }
        return aVar;
    }

    static a a(ContentResolver contentResolver) {
        return a(contentResolver, "default");
    }

    public static a b(ContentResolver contentResolver, String str) {
        a a = a(contentResolver, str);
        if (a != null) {
            return a;
        }
        a = a(contentResolver);
        if (a != null) {
            return a;
        }
        f.a("AndroidNotificationConfigModel", "No default notification configuration; falling back for package: " + str);
        return new a(str, false, true, TimeUnit.SECONDS.toMillis(15));
    }
}
