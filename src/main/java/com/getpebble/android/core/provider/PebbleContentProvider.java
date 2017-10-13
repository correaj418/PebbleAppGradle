package com.getpebble.android.core.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.a.d;
import com.getpebble.android.common.model.a.n;
import com.getpebble.android.common.model.a.o;
import com.getpebble.android.common.model.a.r;
import com.getpebble.android.common.model.a.t;
import com.getpebble.android.common.model.ab;
import com.getpebble.android.common.model.ae;
import com.getpebble.android.common.model.aj;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.al;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.an;
import com.getpebble.android.common.model.aq;
import com.getpebble.android.common.model.ar;
import com.getpebble.android.common.model.as;
import com.getpebble.android.common.model.au;
import com.getpebble.android.common.model.av;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.az;
import com.getpebble.android.common.model.ba;
import com.getpebble.android.common.model.bc;
import com.getpebble.android.common.model.bd;
import com.getpebble.android.common.model.p;
import com.getpebble.android.common.model.q;
import com.getpebble.android.common.model.s;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.google.a.b.af;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class PebbleContentProvider extends ContentProvider {
    public static final Uri a = Uri.parse("content://com.getpebble.android.basalt.internal.provider");
    private static final UriMatcher b = new UriMatcher(-1);
    private static Map<Integer, String> e = af.f().a(Integer.valueOf(29), "minute_samples").a(Integer.valueOf(31), d.a).a(Integer.valueOf(40), "health_stats").a(Integer.valueOf(41), "watches").a();
    private static Map<Integer, String> f = af.f().a(Integer.valueOf(1), "locker_apps").a(Integer.valueOf(2), "boot_config").a(Integer.valueOf(3), ak.TABLE_NAME).a(Integer.valueOf(4), "manifests").a(Integer.valueOf(5), aj.a()).a(Integer.valueOf(6), "preferences").a(Integer.valueOf(7), an.TABLE_NAME).a(Integer.valueOf(8), "android_apps").a(Integer.valueOf(9), "pebble_language_packs").a(Integer.valueOf(11), "timeline_items").a(Integer.valueOf(12), "calendar_events").a(Integer.valueOf(13), "calendars").a(Integer.valueOf(14), "raw_query").a(Integer.valueOf(15), WeatherLocationsModel.TABLE_NAME).a(Integer.valueOf(16), "support_events").a(Integer.valueOf(17), "timeline_mapper").a(Integer.valueOf(18), "analytics_events").a(Integer.valueOf(19), "weather_pin_extra_info").a(Integer.valueOf(20), "pebble_table_sync").a(Integer.valueOf(21), "mobile_alerts").a(Integer.valueOf(22), "watch_settings").a(Integer.valueOf(23), "canned_responses").a(Integer.valueOf(24), "contacts").a(Integer.valueOf(30), "phone_numbers").a(Integer.valueOf(25), "phone_numbers").a(Integer.valueOf(26), "watch_apps_data").a(Integer.valueOf(32), "notification_settings").a(Integer.valueOf(33), "weather_app_forecast").a(Integer.valueOf(36), "app_glances").a(Integer.valueOf(38), "pipeline").a(Integer.valueOf(39), "cohorts_config").a();
    private final HashSet<Uri> c = new HashSet();
    private boolean d = false;
    private SQLiteDatabase g = null;
    private SQLiteDatabase h = null;

    private class a extends SQLiteOpenHelper {
        final /* synthetic */ PebbleContentProvider a;

        public a(PebbleContentProvider pebbleContentProvider, Context context) {
            this.a = pebbleContentProvider;
            super(context, "pebble", null, 45);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            PebbleContentProvider.a(sQLiteDatabase, this.a.getContext());
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            PebbleContentProvider.a(sQLiteDatabase, i, i2, this.a.getContext());
        }
    }

    public class b extends SQLiteOpenHelper {
        final /* synthetic */ PebbleContentProvider a;
        private SharedPreferences b = PebbleApplication.B();
        private n c;

        public b(PebbleContentProvider pebbleContentProvider, Context context) {
            this.a = pebbleContentProvider;
            super(context, "health", null, 17);
            this.c = new n(context);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            PebbleContentProvider.a(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            PebbleContentProvider.a(sQLiteDatabase, this.b, i, i2, this.c);
        }
    }

    private static class c extends RuntimeException {
        public c(int i, int i2, Exception exception) {
            super(String.format("Failed to upgrade database from %d to %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), exception);
        }
    }

    static {
        b.addURI("com.getpebble.android.basalt.internal.provider", "locker_apps", 1);
        b.addURI("com.getpebble.android.basalt.internal.provider", "mobile_alerts", 21);
        b.addURI("com.getpebble.android.basalt.internal.provider", "boot_config", 2);
        b.addURI("com.getpebble.android.basalt.internal.provider", ak.TABLE_NAME, 3);
        b.addURI("com.getpebble.android.basalt.internal.provider", "manifests", 4);
        b.addURI("com.getpebble.android.basalt.internal.provider", aj.a(), 5);
        b.addURI("com.getpebble.android.basalt.internal.provider", "preferences", 6);
        b.addURI("com.getpebble.android.basalt.internal.provider", an.TABLE_NAME, 7);
        b.addURI("com.getpebble.android.basalt.internal.provider", "android_apps", 8);
        b.addURI("com.getpebble.android.basalt.internal.provider", "pebble_language_packs", 9);
        b.addURI("com.getpebble.android.basalt.internal.provider", "timeline_items", 11);
        b.addURI("com.getpebble.android.basalt.internal.provider", "calendar_events", 12);
        b.addURI("com.getpebble.android.basalt.internal.provider", "calendars", 13);
        b.addURI("com.getpebble.android.basalt.internal.provider", "raw_query/*", 14);
        b.addURI("com.getpebble.android.basalt.internal.provider", WeatherLocationsModel.TABLE_NAME, 15);
        b.addURI("com.getpebble.android.basalt.internal.provider", "support_events", 16);
        b.addURI("com.getpebble.android.basalt.internal.provider", "timeline_mapper", 17);
        b.addURI("com.getpebble.android.basalt.internal.provider", "analytics_events", 18);
        b.addURI("com.getpebble.android.basalt.internal.provider", "weather_pin_extra_info", 19);
        b.addURI("com.getpebble.android.basalt.internal.provider", "pebble_table_sync", 20);
        b.addURI("com.getpebble.android.basalt.internal.provider", "watch_settings", 22);
        b.addURI("com.getpebble.android.basalt.internal.provider", "canned_responses", 23);
        b.addURI("com.getpebble.android.basalt.internal.provider", "contacts", 24);
        b.addURI("com.getpebble.android.basalt.internal.provider", "phone_numbers", 25);
        b.addURI("com.getpebble.android.basalt.internal.provider", "phone_numbers/phone_number/*", 30);
        b.addURI("com.getpebble.android.basalt.internal.provider", "watch_apps_data", 26);
        b.addURI("com.getpebble.android.basalt.internal.provider", "minute_samples", 29);
        b.addURI("com.getpebble.android.basalt.internal.provider", d.a, 31);
        b.addURI("com.getpebble.android.basalt.internal.provider", "notification_settings", 32);
        b.addURI("com.getpebble.android.basalt.internal.provider", "weather_app_forecast", 33);
        b.addURI("com.getpebble.android.basalt.internal.provider", "health_stats", 40);
        b.addURI("com.getpebble.android.basalt.internal.provider", "app_glances", 36);
        b.addURI("com.getpebble.android.basalt.internal.provider", "pipeline", 38);
        b.addURI("com.getpebble.android.basalt.internal.provider", "cohorts_config", 39);
        b.addURI("com.getpebble.android.basalt.internal.provider", "watches", 41);
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(new o(17).getCreateTableCommand());
        o.a(sQLiteDatabase, 17);
        sQLiteDatabase.execSQL(new d(17).getCreateTableCommand());
        d.a(sQLiteDatabase, 17);
        sQLiteDatabase.execSQL(new r(17).getCreateTableCommand());
        sQLiteDatabase.execSQL(new t(17).getCreateTableCommand());
        sQLiteDatabase.execSQL(t.a());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(android.database.sqlite.SQLiteDatabase r7, android.content.SharedPreferences r8, int r9, int r10, com.getpebble.android.common.model.a.n r11) {
        /*
        r6 = 9;
        r5 = 4;
        r1 = 0;
        r0 = 1;
        r2 = "PebbleContentProvider";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "processHealthUpgrade: Upgrading health database from version ";
        r3 = r3.append(r4);
        r3 = r3.append(r9);
        r4 = " to ";
        r3 = r3.append(r4);
        r3 = r3.append(r10);
        r4 = ":";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.getpebble.android.common.b.a.f.d(r2, r3);
        if (r9 < r5) goto L_0x004f;
    L_0x002f:
        r2 = r0;
    L_0x0030:
        r3 = 7;
        if (r9 < r3) goto L_0x0051;
    L_0x0033:
        switch(r9) {
            case 1: goto L_0x0053;
            case 2: goto L_0x005b;
            case 3: goto L_0x0070;
            case 4: goto L_0x007d;
            case 5: goto L_0x007d;
            case 6: goto L_0x009c;
            case 7: goto L_0x009f;
            case 8: goto L_0x00b1;
            case 9: goto L_0x00c3;
            case 10: goto L_0x00db;
            case 11: goto L_0x00e7;
            case 12: goto L_0x00fa;
            case 13: goto L_0x0100;
            case 14: goto L_0x0109;
            case 15: goto L_0x011d;
            case 16: goto L_0x013b;
            default: goto L_0x0036;
        };
    L_0x0036:
        r0 = "PebbleContentProvider";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0158 }
        r1.<init>();	 Catch:{ Exception -> 0x0158 }
        r2 = "onUpgrade: **** Unable to upgrade from version ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0158 }
        r1 = r1.append(r9);	 Catch:{ Exception -> 0x0158 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.b.a.f.a(r0, r1);	 Catch:{ Exception -> 0x0158 }
    L_0x004e:
        return;
    L_0x004f:
        r2 = r1;
        goto L_0x0030;
    L_0x0051:
        r0 = r1;
        goto L_0x0033;
    L_0x0053:
        com.getpebble.android.common.model.a.o.a(r7);	 Catch:{ Exception -> 0x0158 }
        r1 = "delete from step_session";
        r7.execSQL(r1);	 Catch:{ Exception -> 0x0158 }
    L_0x005b:
        r1 = "step_session";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x0158 }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x0158 }
        r5 = "device_serial";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x0158 }
        r1 = com.getpebble.android.h.x.a(r1, r3);	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r1);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.o.b(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x0070:
        r1 = new com.getpebble.android.common.model.a.d;	 Catch:{ Exception -> 0x0158 }
        r3 = 4;
        r1.<init>(r3);	 Catch:{ Exception -> 0x0158 }
        r1 = r1.getCreateTableCommand();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r1);	 Catch:{ Exception -> 0x0158 }
    L_0x007d:
        r1 = "drop table sleep_session";
        r7.execSQL(r1);	 Catch:{ Exception -> 0x0158 }
        if (r2 == 0) goto L_0x0087;
    L_0x0084:
        com.getpebble.android.common.model.a.d.a(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x0087:
        com.getpebble.android.common.model.a.l.c(r7);	 Catch:{ Exception -> 0x0158 }
        if (r2 == 0) goto L_0x009c;
    L_0x008c:
        r1 = 5;
        r1 = com.getpebble.android.common.model.a.d.b.from(r1);	 Catch:{ Exception -> 0x0158 }
        r1 = r1.tableName;	 Catch:{ Exception -> 0x0158 }
        r3 = new com.getpebble.android.common.model.a.d;	 Catch:{ Exception -> 0x0158 }
        r4 = 6;
        r3.<init>(r4);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.ai.dropDefaultColumns(r7, r1, r3);	 Catch:{ Exception -> 0x0158 }
    L_0x009c:
        com.getpebble.android.common.model.a.o.c(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x009f:
        r1 = com.getpebble.android.common.model.a.d.a();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r1);	 Catch:{ Exception -> 0x0158 }
        r1 = 8;
        com.getpebble.android.common.model.a.d.a(r7, r1);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.l.d(r7);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.o.d(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x00b1:
        if (r2 == 0) goto L_0x00be;
    L_0x00b3:
        r1 = new com.getpebble.android.common.model.a.d;	 Catch:{ Exception -> 0x0158 }
        r2 = 9;
        r1.<init>(r2);	 Catch:{ Exception -> 0x0158 }
        r2 = 1;
        com.getpebble.android.h.x.a(r7, r1, r2);	 Catch:{ Exception -> 0x0158 }
    L_0x00be:
        if (r0 == 0) goto L_0x00c3;
    L_0x00c0:
        com.getpebble.android.common.model.a.o.e(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x00c3:
        if (r9 != r6) goto L_0x00d3;
    L_0x00c5:
        r0 = com.getpebble.android.common.model.a.d.a();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x0158 }
        r0 = com.getpebble.android.common.model.a.o.a();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x0158 }
    L_0x00d3:
        r0 = 10;
        com.getpebble.android.common.model.a.d.a(r7, r0);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.o.f(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x00db:
        r0 = new com.getpebble.android.common.model.a.s;	 Catch:{ Exception -> 0x0158 }
        r0.<init>();	 Catch:{ Exception -> 0x0158 }
        r0 = r0.getCreateTableCommand();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x0158 }
    L_0x00e7:
        r0 = new com.getpebble.android.common.model.a.u;	 Catch:{ Exception -> 0x0158 }
        r0.<init>();	 Catch:{ Exception -> 0x0158 }
        r0 = r0.getCreateTableCommand();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x0158 }
        r0 = com.getpebble.android.common.model.a.u.a();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x0158 }
    L_0x00fa:
        com.getpebble.android.common.model.a.o.g(r7);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.l.e(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x0100:
        com.getpebble.android.common.model.a.o.h(r7);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.l.a(r7);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.u.a(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x0109:
        r0 = new com.getpebble.android.common.model.a.r;	 Catch:{ Exception -> 0x0158 }
        r1 = 15;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0158 }
        r0 = r0.getCreateTableCommand();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.m.a(r7);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.s.a(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x011d:
        r0 = new com.getpebble.android.common.model.a.t;	 Catch:{ Exception -> 0x0158 }
        r1 = 16;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0158 }
        r0 = r0.getCreateTableCommand();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x0158 }
        r0 = com.getpebble.android.common.model.a.t.a();	 Catch:{ Exception -> 0x0158 }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.o.a(r7, r11);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.l.b(r7);	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.model.a.d.b(r7);	 Catch:{ Exception -> 0x0158 }
    L_0x013b:
        com.getpebble.android.common.model.a.o.i(r7);	 Catch:{ Exception -> 0x0158 }
        r0 = "PebbleContentProvider";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0158 }
        r1.<init>();	 Catch:{ Exception -> 0x0158 }
        r2 = "onUpgrade: Finished upgrading health databases; db version = ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0158 }
        r1 = r1.append(r10);	 Catch:{ Exception -> 0x0158 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0158 }
        com.getpebble.android.common.b.a.f.d(r0, r1);	 Catch:{ Exception -> 0x0158 }
        goto L_0x004e;
    L_0x0158:
        r0 = move-exception;
        r1 = "PebbleContentProvider";
        r2 = "onUpgrade: Failed to upgrade database!";
        com.getpebble.android.common.b.a.f.a(r1, r2, r0);
        r1 = new com.getpebble.android.core.provider.PebbleContentProvider$c;
        r1.<init>(r9, r10, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.core.provider.PebbleContentProvider.a(android.database.sqlite.SQLiteDatabase, android.content.SharedPreferences, int, int, com.getpebble.android.common.model.a.n):void");
    }

    static void a(SQLiteDatabase sQLiteDatabase, Context context) {
        sQLiteDatabase.execSQL(new am().getCreateTableCommand());
        for (am.d toContentValues : am.d.values()) {
            sQLiteDatabase.insert("locker_apps", null, toContentValues.toContentValues(context.getResources()));
        }
        sQLiteDatabase.execSQL(new ak().getCreateTableCommand());
        sQLiteDatabase.execSQL(ak.UNIQUE_SERIAL_INDEX);
        sQLiteDatabase.execSQL(new al().getCreateTableCommand());
        sQLiteDatabase.execSQL(new com.getpebble.android.config.a.a().getCreateTableCommand());
        sQLiteDatabase.execSQL(new as().getCreateTableCommand());
        sQLiteDatabase.execSQL(new an().getCreateTableCommand());
        sQLiteDatabase.execSQL(new ab().getCreateTableCommand());
        sQLiteDatabase.execSQL(new com.getpebble.android.common.model.af().getCreateTableCommand());
        sQLiteDatabase.execSQL(new aw().getCreateTableCommand());
        sQLiteDatabase.execSQL(new com.getpebble.android.common.model.n().getCreateTableCommand());
        sQLiteDatabase.execSQL(new com.getpebble.android.common.model.o().getCreateTableCommand());
        sQLiteDatabase.execSQL(new WeatherLocationsModel().getCreateTableCommand());
        sQLiteDatabase.execSQL(new au().getCreateTableCommand());
        sQLiteDatabase.execSQL(new av().getCreateTableCommand());
        sQLiteDatabase.execSQL(new com.getpebble.android.a.a().getCreateTableCommand());
        sQLiteDatabase.execSQL(new bd().getCreateTableCommand());
        sQLiteDatabase.execSQL(new com.getpebble.android.common.model.t().getCreateTableCommand());
        sQLiteDatabase.execSQL(new ae().getCreateTableCommand());
        sQLiteDatabase.execSQL(new ba().getCreateTableCommand());
        sQLiteDatabase.execSQL(new p().getCreateTableCommand());
        sQLiteDatabase.execSQL(new s().getCreateTableCommand());
        sQLiteDatabase.execSQL(new aq().getCreateTableCommand());
        sQLiteDatabase.execSQL(new az().getCreateTableCommand());
        sQLiteDatabase.execSQL(new com.getpebble.android.common.model.c().getCreateTableCommand());
        sQLiteDatabase.execSQL(new bc().getCreateTableCommand());
        sQLiteDatabase.execSQL(new com.getpebble.android.common.model.d().getCreateTableCommand());
        sQLiteDatabase.execSQL(new ar().getCreateTableCommand());
        sQLiteDatabase.execSQL(new q().getCreateTableCommand());
        p.a(context.getResources(), sQLiteDatabase);
        WeatherLocationsModel.insertDynamicLocation(sQLiteDatabase);
        com.getpebble.android.common.model.af.a(sQLiteDatabase, context, true, true);
        com.getpebble.android.common.model.c.a(context, sQLiteDatabase);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(android.database.sqlite.SQLiteDatabase r7, int r8, int r9, android.content.Context r10) {
        /*
        r6 = 8;
        r0 = 1;
        r1 = 0;
        r2 = "PebbleContentProvider";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "onUpgrade: Upgrading main database from version ";
        r3 = r3.append(r4);
        r3 = r3.append(r8);
        r4 = " to ";
        r3 = r3.append(r4);
        r3 = r3.append(r9);
        r4 = ":";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.getpebble.android.common.b.a.f.d(r2, r3);
        switch(r8) {
            case 1: goto L_0x0048;
            case 2: goto L_0x0058;
            case 3: goto L_0x0061;
            case 4: goto L_0x0073;
            case 5: goto L_0x0085;
            case 6: goto L_0x008c;
            case 7: goto L_0x0098;
            case 8: goto L_0x00bb;
            case 9: goto L_0x00d2;
            case 10: goto L_0x00d5;
            case 11: goto L_0x00d5;
            case 12: goto L_0x00e7;
            case 13: goto L_0x00fe;
            case 14: goto L_0x0101;
            case 15: goto L_0x0138;
            case 16: goto L_0x0143;
            case 17: goto L_0x0146;
            case 18: goto L_0x0149;
            case 19: goto L_0x0172;
            case 20: goto L_0x0175;
            case 21: goto L_0x0181;
            case 22: goto L_0x0199;
            case 23: goto L_0x0199;
            case 24: goto L_0x01ba;
            case 25: goto L_0x01cc;
            case 26: goto L_0x0207;
            case 27: goto L_0x0219;
            case 28: goto L_0x0225;
            case 29: goto L_0x0228;
            case 30: goto L_0x024f;
            case 31: goto L_0x025e;
            case 32: goto L_0x0280;
            case 33: goto L_0x0292;
            case 34: goto L_0x0292;
            case 35: goto L_0x02a8;
            case 36: goto L_0x02f0;
            case 37: goto L_0x02fc;
            case 38: goto L_0x02ff;
            case 39: goto L_0x030f;
            case 40: goto L_0x0321;
            case 41: goto L_0x0339;
            case 42: goto L_0x0343;
            case 43: goto L_0x0353;
            case 44: goto L_0x0365;
            default: goto L_0x002f;
        };
    L_0x002f:
        r0 = "PebbleContentProvider";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x038f }
        r1.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = "onUpgrade: **** Unable to upgrade from version ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x038f }
        r1 = r1.append(r8);	 Catch:{ Exception -> 0x038f }
        r1 = r1.toString();	 Catch:{ Exception -> 0x038f }
        com.getpebble.android.common.b.a.f.a(r0, r1);	 Catch:{ Exception -> 0x038f }
    L_0x0047:
        return;
    L_0x0048:
        r2 = "locker_apps";
        r3 = 0;
        r4 = com.getpebble.android.common.model.am.d.MISSED_CALLS;	 Catch:{ Exception -> 0x038f }
        r5 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        r4 = r4.toContentValues(r5);	 Catch:{ Exception -> 0x038f }
        r7.insert(r2, r3, r4);	 Catch:{ Exception -> 0x038f }
    L_0x0058:
        r2 = com.getpebble.android.common.model.am.d.TICTOC;	 Catch:{ Exception -> 0x038f }
        r3 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        com.getpebble.android.common.model.am.a(r7, r2, r3);	 Catch:{ Exception -> 0x038f }
    L_0x0061:
        r2 = "weather_locations";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x038f }
        r5 = "today_high_temp";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0073:
        r2 = "timeline_items";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.INTEGER;	 Catch:{ Exception -> 0x038f }
        r5 = "is_removed_by_user";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0085:
        r2 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        com.getpebble.android.common.model.am.a(r7, r2);	 Catch:{ Exception -> 0x038f }
    L_0x008c:
        r2 = new com.getpebble.android.a.a;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0098:
        r2 = "DROP TABLE notifications";
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = new com.getpebble.android.common.model.an;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "timeline_items";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x038f }
        r5 = "status";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x00bb:
        if (r8 >= r6) goto L_0x039d;
    L_0x00bd:
        r2 = r0;
    L_0x00be:
        if (r2 != 0) goto L_0x00d2;
    L_0x00c0:
        r2 = "notifications";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.INTEGER;	 Catch:{ Exception -> 0x038f }
        r5 = "is_dup";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x00d2:
        com.getpebble.android.common.model.n.a(r7);	 Catch:{ Exception -> 0x038f }
    L_0x00d5:
        r2 = "calendar_events";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x038f }
        r5 = "ownerAccount";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x00e7:
        r2 = "android_apps";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.INTEGER;	 Catch:{ Exception -> 0x038f }
        r5 = "is_system_app";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = 0;
        r3 = 0;
        com.getpebble.android.common.model.af.a(r7, r10, r2, r3);	 Catch:{ Exception -> 0x038f }
    L_0x00fe:
        com.getpebble.android.common.model.al.a(r7);	 Catch:{ Exception -> 0x038f }
    L_0x0101:
        r2 = new com.getpebble.android.common.model.t;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "android_apps";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.INTEGER;	 Catch:{ Exception -> 0x038f }
        r5 = "muted_on";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x038f }
        r4.<init>();	 Catch:{ Exception -> 0x038f }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x038f }
        r5 = com.getpebble.android.common.model.af.a.NEVER;	 Catch:{ Exception -> 0x038f }
        r5 = r5.getId();	 Catch:{ Exception -> 0x038f }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x038f }
        r4 = r4.toString();	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3, r4);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0138:
        r2 = "locker_apps";
        r3 = "resource_map_json";
        r2 = com.getpebble.android.h.x.b(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0143:
        com.getpebble.android.common.model.am.a(r7, r10);	 Catch:{ Exception -> 0x038f }
    L_0x0146:
        com.getpebble.android.common.model.am.b(r7, r10);	 Catch:{ Exception -> 0x038f }
    L_0x0149:
        if (r8 >= r6) goto L_0x03a0;
    L_0x014b:
        r2 = r0;
    L_0x014c:
        if (r2 != 0) goto L_0x0172;
    L_0x014e:
        r2 = "notifications";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x038f }
        r5 = "title";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "notifications";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x038f }
        r5 = "body";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0172:
        com.getpebble.android.common.model.n.b(r7);	 Catch:{ Exception -> 0x038f }
    L_0x0175:
        r2 = new com.getpebble.android.common.model.ae;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0181:
        r2 = 7;
        if (r8 >= r2) goto L_0x03a3;
    L_0x0184:
        r2 = r0;
    L_0x0185:
        if (r2 != 0) goto L_0x0199;
    L_0x0187:
        r2 = "analytics_events";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x038f }
        r5 = "globals";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0199:
        r2 = "DROP TABLE IF EXISTS watch_settings";
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = new com.getpebble.android.common.model.ba;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "locker_apps";
        r3 = 0;
        r4 = com.getpebble.android.common.model.am.d.HEALTH;	 Catch:{ Exception -> 0x038f }
        r5 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        r4 = r4.toContentValues(r5);	 Catch:{ Exception -> 0x038f }
        r7.insert(r2, r3, r4);	 Catch:{ Exception -> 0x038f }
    L_0x01ba:
        r2 = "devices";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.INTEGER;	 Catch:{ Exception -> 0x038f }
        r5 = "health_insights_version";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x01cc:
        r2 = new com.getpebble.android.common.model.p;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        com.getpebble.android.common.model.p.a(r2, r7);	 Catch:{ Exception -> 0x038f }
        r2 = new com.getpebble.android.common.model.s;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = new com.getpebble.android.common.model.aq;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "locker_apps";
        r3 = 0;
        r4 = com.getpebble.android.common.model.am.d.SMS;	 Catch:{ Exception -> 0x038f }
        r5 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        r4 = r4.toContentValues(r5);	 Catch:{ Exception -> 0x038f }
        r7.insert(r2, r3, r4);	 Catch:{ Exception -> 0x038f }
    L_0x0207:
        r2 = "contacts";
        r2 = com.getpebble.android.h.x.a(r2);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "phone_numbers";
        r2 = com.getpebble.android.h.x.a(r2);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0219:
        r2 = new com.getpebble.android.common.model.az;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0225:
        com.getpebble.android.common.model.ak.addTransportColumn(r7);	 Catch:{ Exception -> 0x038f }
    L_0x0228:
        r2 = "mobile_alerts";
        r3 = new com.getpebble.android.common.model.ae;	 Catch:{ Exception -> 0x038f }
        r3.<init>();	 Catch:{ Exception -> 0x038f }
        r3 = r3.getColumnSet();	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r7, r2, r3);	 Catch:{ Exception -> 0x038f }
        if (r2 != 0) goto L_0x024f;
    L_0x0239:
        r2 = "mobile_alerts";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x038f }
        r4 = 0;
        r5 = "title";
        r3[r4] = r5;	 Catch:{ Exception -> 0x038f }
        r4 = 1;
        r5 = "description";
        r3[r4] = r5;	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x024f:
        r2 = new com.getpebble.android.common.model.c;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        com.getpebble.android.common.model.c.a(r10, r7);	 Catch:{ Exception -> 0x038f }
    L_0x025e:
        r2 = "UPDATE weather_locations SET updated_timestamp=0";
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "DROP TABLE IF EXISTS weather_forecast";
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = new com.getpebble.android.common.model.bd;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = new com.getpebble.android.common.model.bc;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = r2.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0280:
        r2 = "devices";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x038f }
        r5 = "extra_ui_status";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x0292:
        com.getpebble.android.common.model.ak.deleteAllLeDevices(r7);	 Catch:{ Exception -> 0x038f }
        r2 = "DELETE FROM devices WHERE rowid IN (SELECT a.rowid FROM devices a WHERE exists  (SELECT b.rowid FROM devices b WHERE a.serial_number = b.serial_number AND a.rowid > b.rowid  ) );";
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = new com.getpebble.android.common.model.ak;	 Catch:{ Exception -> 0x038f }
        r2.<init>();	 Catch:{ Exception -> 0x038f }
        r3 = 0;
        com.getpebble.android.h.x.a(r7, r2, r3);	 Catch:{ Exception -> 0x038f }
        r2 = " CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_device ON devices(serial_number);";
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
    L_0x02a8:
        r2 = "calendar_events";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.STRING;	 Catch:{ Exception -> 0x038f }
        r5 = "customAppUri";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "calendars";
        r3 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r4 = com.getpebble.android.common.model.ai.a.a.INTEGER;	 Catch:{ Exception -> 0x038f }
        r5 = "calendar_access_level";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.h.x.a(r2, r3);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r2);	 Catch:{ Exception -> 0x038f }
        r2 = "locker_apps";
        r3 = 0;
        r4 = com.getpebble.android.common.model.am.d.REMINDERS;	 Catch:{ Exception -> 0x038f }
        r5 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        r4 = r4.toContentValues(r5);	 Catch:{ Exception -> 0x038f }
        r7.insert(r2, r3, r4);	 Catch:{ Exception -> 0x038f }
        r2 = 24;
        if (r8 >= r2) goto L_0x03a6;
    L_0x02e0:
        if (r0 != 0) goto L_0x02f0;
    L_0x02e2:
        r0 = "watch_settings";
        r1 = new com.getpebble.android.common.model.ba;	 Catch:{ Exception -> 0x038f }
        r1.<init>();	 Catch:{ Exception -> 0x038f }
        r1 = r1.getColumnSet();	 Catch:{ Exception -> 0x038f }
        com.getpebble.android.h.x.a(r7, r0, r1);	 Catch:{ Exception -> 0x038f }
    L_0x02f0:
        r0 = new com.getpebble.android.common.model.d;	 Catch:{ Exception -> 0x038f }
        r0.<init>();	 Catch:{ Exception -> 0x038f }
        r0 = r0.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x038f }
    L_0x02fc:
        com.getpebble.android.common.model.am.a(r7);	 Catch:{ Exception -> 0x038f }
    L_0x02ff:
        r0 = "locker_apps";
        r1 = 0;
        r2 = com.getpebble.android.common.model.am.d.SETTINGS;	 Catch:{ Exception -> 0x038f }
        r3 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        r2 = r2.toContentValues(r3);	 Catch:{ Exception -> 0x038f }
        r7.insert(r0, r1, r2);	 Catch:{ Exception -> 0x038f }
    L_0x030f:
        r0 = "timeline_items";
        r1 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.common.model.ai.a.a.INTEGER;	 Catch:{ Exception -> 0x038f }
        r3 = "persist_quick_view";
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x038f }
        r0 = com.getpebble.android.h.x.a(r0, r1);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x038f }
    L_0x0321:
        r0 = new com.getpebble.android.common.model.ar;	 Catch:{ Exception -> 0x038f }
        r0.<init>();	 Catch:{ Exception -> 0x038f }
        r0 = r0.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x038f }
        r0 = new com.getpebble.android.common.model.q;	 Catch:{ Exception -> 0x038f }
        r0.<init>();	 Catch:{ Exception -> 0x038f }
        r0 = r0.getCreateTableCommand();	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x038f }
    L_0x0339:
        r0 = "DELETE FROM devices WHERE rowid IN (SELECT a.rowid FROM devices a WHERE exists  (SELECT b.rowid FROM devices b WHERE a.serial_number = b.serial_number AND a.rowid > b.rowid  ) );";
        r7.execSQL(r0);	 Catch:{ Exception -> 0x038f }
        r0 = " CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_device ON devices(serial_number);";
        r7.execSQL(r0);	 Catch:{ Exception -> 0x038f }
    L_0x0343:
        r0 = "locker_apps";
        r1 = 0;
        r2 = com.getpebble.android.common.model.am.d.WORKOUT;	 Catch:{ Exception -> 0x038f }
        r3 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        r2 = r2.toContentValues(r3);	 Catch:{ Exception -> 0x038f }
        r7.insert(r0, r1, r2);	 Catch:{ Exception -> 0x038f }
    L_0x0353:
        r0 = "android_apps";
        r1 = new com.getpebble.android.common.model.ai$a;	 Catch:{ Exception -> 0x038f }
        r2 = com.getpebble.android.common.model.ai.a.a.INTEGER;	 Catch:{ Exception -> 0x038f }
        r3 = "is_sms_app";
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x038f }
        r0 = com.getpebble.android.h.x.a(r0, r1);	 Catch:{ Exception -> 0x038f }
        r7.execSQL(r0);	 Catch:{ Exception -> 0x038f }
    L_0x0365:
        r0 = "locker_apps";
        r1 = 0;
        r2 = com.getpebble.android.common.model.am.d.KICKSTART;	 Catch:{ Exception -> 0x038f }
        r3 = r10.getResources();	 Catch:{ Exception -> 0x038f }
        r2 = r2.toContentValues(r3);	 Catch:{ Exception -> 0x038f }
        r7.insert(r0, r1, r2);	 Catch:{ Exception -> 0x038f }
        r0 = "PebbleContentProvider";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x038f }
        r1.<init>();	 Catch:{ Exception -> 0x038f }
        r2 = "onUpgrade: Finished upgrading; db version = ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x038f }
        r1 = r1.append(r9);	 Catch:{ Exception -> 0x038f }
        r1 = r1.toString();	 Catch:{ Exception -> 0x038f }
        com.getpebble.android.common.b.a.f.d(r0, r1);	 Catch:{ Exception -> 0x038f }
        goto L_0x0047;
    L_0x038f:
        r0 = move-exception;
        r1 = "PebbleContentProvider";
        r2 = "onUpgrade: Failed to upgrade database!";
        com.getpebble.android.common.b.a.f.a(r1, r2, r0);
        r1 = new com.getpebble.android.core.provider.PebbleContentProvider$c;
        r1.<init>(r8, r9, r0);
        throw r1;
    L_0x039d:
        r2 = r1;
        goto L_0x00be;
    L_0x03a0:
        r2 = r1;
        goto L_0x014c;
    L_0x03a3:
        r2 = r1;
        goto L_0x0185;
    L_0x03a6:
        r0 = r1;
        goto L_0x02e0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.core.provider.PebbleContentProvider.a(android.database.sqlite.SQLiteDatabase, int, int, android.content.Context):void");
    }

    public boolean onCreate() {
        f.d("PebbleContentProvider", "onCreate()");
        return true;
    }

    private SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized ("m") {
            if (this.g == null) {
                f.d("PebbleContentProvider", "getMainDatabase: creating...");
                this.g = new a(this, getContext()).getWritableDatabase();
            }
            sQLiteDatabase = this.g;
        }
        return sQLiteDatabase;
    }

    private SQLiteDatabase b() {
        SQLiteDatabase sQLiteDatabase;
        synchronized ("h") {
            if (this.h == null) {
                f.d("PebbleContentProvider", "getHealthDatabase: creating...");
                this.h = new b(this, getContext()).getWritableDatabase();
            }
            sQLiteDatabase = this.h;
        }
        return sQLiteDatabase;
    }

    public String getType(Uri uri) {
        b.match(uri);
        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (b.match(uri) == 30) {
            return a(uri, strArr, str, strArr2, str2);
        }
        SQLiteDatabase a = a(uri);
        String b = b(uri, strArr, str, strArr2, str2);
        if (b != null) {
            f.d("PebbleContentProvider", "query: Executing custom raw query: " + b);
            return a.rawQuery(b, null);
        }
        String b2 = b(uri);
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(b2);
        Cursor query = sQLiteQueryBuilder.query(a, strArr, str, strArr2, null, null, str2);
        if (query == null) {
            return query;
        }
        Context context = getContext();
        if (context == null) {
            return query;
        }
        query.setNotificationUri(context.getContentResolver(), uri);
        return query;
    }

    private Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor rawQuery;
        String decode = Uri.decode(uri.getLastPathSegment());
        SQLiteDatabase a = a(uri);
        try {
            rawQuery = a.rawQuery("SELECT * FROM phone_numbers WHERE PHONE_NUMBERS_EQUAL(number , '" + decode + "');", null);
        } catch (SQLiteException e) {
            rawQuery = a.query(b(uri), null, "number=?", new String[]{decode}, null, null, null);
        }
        if (rawQuery != null) {
            Context context = getContext();
            if (context != null) {
                rawQuery.setNotificationUri(context.getContentResolver(), uri);
            }
        }
        return rawQuery;
    }

    private String b(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        switch (b.match(uri)) {
            case 14:
                return Uri.decode(uri.getLastPathSegment());
            default:
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return a(uri, contentValues, true);
    }

    private Uri a(Uri uri, ContentValues contentValues, boolean z) {
        if (uri.equals(au.a)) {
            au.a(a(), contentValues);
            return null;
        }
        SQLiteDatabase a = a(uri);
        String b = b(uri);
        String queryParameter = uri.getQueryParameter("insert-with-on-conflict");
        Uri withAppendedId = ContentUris.withAppendedId(a, a.insertWithOnConflict(b, null, contentValues, queryParameter == null ? 0 : Integer.valueOf(queryParameter).intValue()));
        c(uri);
        return withAppendedId;
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int length = contentValuesArr.length;
        int i = length;
        for (ContentValues a : contentValuesArr) {
            try {
                a(uri, a, false);
            } catch (Throwable e) {
                i--;
                f.a("PebbleContentProvider", "bulkInsert: Failed to insert!", e);
            }
        }
        c(uri);
        return i;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (b.match(uri) == 30) {
            return a(uri, str, strArr);
        }
        int delete = a(uri).delete(b(uri), str, strArr);
        c(uri);
        return delete;
    }

    private int a(Uri uri, String str, String[] strArr) {
        int i = 0;
        try {
            a().execSQL("DELETE FROM phone_numbers WHERE PHONE_NUMBERS_EQUAL(number , '" + Uri.decode(uri.getLastPathSegment()) + "');");
        } catch (SQLiteException e) {
            i = a().delete(b(uri), "number=?", new String[]{r1});
        }
        c(uri);
        return i;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String b = b(uri);
        SQLiteDatabase a = a(uri);
        String queryParameter = uri.getQueryParameter("increment-column");
        if (queryParameter != null) {
            return a(b, a, queryParameter, str, strArr);
        }
        int update = a.update(b, contentValues, str, strArr);
        c(uri);
        return update;
    }

    private int a(String str, SQLiteDatabase sQLiteDatabase, String str2, String str3, String[] strArr) {
        sQLiteDatabase.execSQL("update " + str + " set " + str2 + " = (" + str2 + " + 1) where " + str3, strArr);
        return 0;
    }

    public SQLiteDatabase a(Uri uri) {
        int match = b.match(uri);
        if (e.containsKey(Integer.valueOf(match))) {
            return b();
        }
        if (f.containsKey(Integer.valueOf(match))) {
            return a();
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public static String b(Uri uri) {
        int match = b.match(uri);
        if (f.containsKey(Integer.valueOf(match))) {
            return (String) f.get(Integer.valueOf(match));
        }
        if (e.containsKey(Integer.valueOf(match))) {
            return (String) e.get(Integer.valueOf(match));
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        ContentProviderResult[] applyBatch;
        synchronized ("b") {
            this.d = true;
            try {
                applyBatch = super.applyBatch(arrayList);
                this.d = true;
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                }
                this.c.clear();
            } finally {
                applyBatch = null;
                this.d = false;
            }
        }
        return applyBatch;
    }

    private void c(Uri uri) {
        synchronized ("b") {
            if (this.d) {
                this.c.add(uri);
            } else {
                getContext().getContentResolver().notifyChange(uri, null);
            }
        }
    }
}
