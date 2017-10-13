package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import c.b.a.f;
import com.getpebble.android.common.b.a.d;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.h.x;
import com.google.a.b.ad;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class au extends ai {
    public static final Uri a = b.a("support_events");
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private static final Map<String, com.getpebble.android.common.model.ai.a.a> c = new com.google.a.b.af.a().a("event_type", com.getpebble.android.common.model.ai.a.a.STRING).a("day_timestamp_midnight_utc_ms", com.getpebble.android.common.model.ai.a.a.INTEGER).a("event_count", com.getpebble.android.common.model.ai.a.a.INTEGER).a("elapsed_ms", com.getpebble.android.common.model.ai.a.a.INTEGER).a("longest_elapsed_ms", com.getpebble.android.common.model.ai.a.a.INTEGER).a();
    private static final String[] d = new String[]{"event_type", "day_timestamp_midnight_utc_ms"};

    public enum a {
        DODGY_PAIRING,
        DODGY_PAIRING_UNPAIRING,
        UNEXPECTED_DISCONNECT,
        EXPECTED_DISCONNECT,
        PAIRING_FAIL,
        CONNECT,
        HANDSHAKE_FAIL,
        CALENDAR_SYNC,
        TIMELINE_WEB_SYNC,
        LOCKER_SYNC,
        LANGAUAGE_PACKS_SYNC,
        FW_MANIFEST_SYNC,
        WEATHER_SYNC,
        PUSH_TOKEN_SYNC,
        PHONE_ANALYTICS_EVENTS_SYNC,
        PHONE_ANALYTICS_EVENTS_ADDED,
        PEBBLEKIT_APP_MESSAGE_IN,
        PEBBLEKIT_APP_MESSAGE_OUT,
        BT_MESSAGE_SEND,
        BT_MESSAGE_RECEIVE,
        NO_BT_ADAPTER_ON_START,
        SYSTEM_DB_NOT_FOUND,
        GCM_RECEIVED,
        BLOB_DB_FULL,
        THREAD_COUNT_UI,
        THREAD_COUNT_FRAMEWORK,
        PERMISSION_DENIED,
        ENTERED_IDLE_MODE,
        EXITED_IDLE_MODE,
        FRAMEWORK_RESTARTED,
        FIT_DATA_INSERT_FAILED,
        FIT_SESSION_INSERT_FAILED
    }

    public au() {
        super("support_events");
        for (Entry entry : c.entrySet()) {
            addColumn(new com.getpebble.android.common.model.ai.a((com.getpebble.android.common.model.ai.a.a) entry.getValue(), (String) entry.getKey()));
        }
    }

    public String getCreateTableCommand() {
        return x.a(super.getCreateTableCommand(), ad.a(Arrays.asList(d)));
    }

    private static long c() {
        return new c.b.a.b(f.a).p_().c();
    }

    public static void a(a aVar, ContentResolver contentResolver) {
        a(aVar, contentResolver, -1);
    }

    private static a a(com.getpebble.android.bluetooth.h.e.a aVar) {
        switch (aVar) {
            case NO_BT_ADAPTER_ON_START:
                return a.NO_BT_ADAPTER_ON_START;
            case PAIRING_FAIL:
                return a.PAIRING_FAIL;
            case DODGY_PAIRING:
                return a.DODGY_PAIRING;
            case DODGY_PAIRING_UNPAIRING:
                return a.DODGY_PAIRING_UNPAIRING;
            case BT_MESSAGE_RECEIVE:
                return a.BT_MESSAGE_RECEIVE;
            case BT_MESSAGE_SEND:
                return a.BT_MESSAGE_SEND;
            default:
                return null;
        }
    }

    public static void a(com.getpebble.android.bluetooth.h.e.a aVar, ContentResolver contentResolver) {
        a(a(aVar), contentResolver);
    }

    public static void a(final a aVar, final ContentResolver contentResolver, final long j) {
        d.a(new Runnable() {
            public void run() {
                long a = au.c();
                ContentValues contentValues = new ContentValues(au.c.size());
                contentValues.put("event_type", aVar.name());
                contentValues.put("day_timestamp_midnight_utc_ms", Long.valueOf(a));
                contentValues.put("event_count", Integer.valueOf(1));
                if (j != -1) {
                    contentValues.put("elapsed_ms", Long.valueOf(j));
                    contentValues.put("longest_elapsed_ms", Long.valueOf(j));
                }
                contentResolver.insert(au.a, contentValues);
            }
        });
    }

    public static int a(ContentResolver contentResolver) {
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7);
        String str = "day_timestamp_midnight_utc_ms < ?";
        return contentResolver.delete(a, "day_timestamp_midnight_utc_ms < ?", new String[]{String.valueOf(currentTimeMillis)});
    }

    public static void a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        long insertWithOnConflict;
        try {
            insertWithOnConflict = sQLiteDatabase.insertWithOnConflict("support_events", null, contentValues, 4);
        } catch (SQLException e) {
            insertWithOnConflict = -1;
        }
        if (insertWithOnConflict == -1) {
            String str = "";
            if (contentValues.containsKey("elapsed_ms")) {
                str = ", elapsed_ms = elapsed_ms + " + contentValues.getAsLong("elapsed_ms") + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + "longest_elapsed_ms" + " = MAX(" + "longest_elapsed_ms" + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + contentValues.getAsLong("longest_elapsed_ms") + ")";
            }
            sQLiteDatabase.execSQL("UPDATE support_events SET event_count = event_count + 1 " + str + " WHERE " + "event_type" + " = '" + contentValues.getAsString("event_type") + "' AND " + "day_timestamp_midnight_utc_ms" + " = " + contentValues.getAsLong("day_timestamp_midnight_utc_ms"));
        }
    }

    public static void a(PrintStream printStream, ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, null, null, null, "day_timestamp_midnight_utc_ms ASC, event_type ASC");
        if (query == null) {
            com.getpebble.android.common.b.a.f.b("SupportEvent", "catSupportEventsToStream() cursor is null");
            return;
        }
        while (query.moveToNext()) {
            String string = query.getString(query.getColumnIndex("event_type"));
            long j = query.getLong(query.getColumnIndex("day_timestamp_midnight_utc_ms"));
            long j2 = query.getLong(query.getColumnIndex("event_count"));
            long j3 = query.getLong(query.getColumnIndex("elapsed_ms"));
            long j4 = query.getLong(query.getColumnIndex("longest_elapsed_ms"));
            String str = "";
            if (j3 > 0 && j2 > 0) {
                str = " Mean elapsed = " + (j3 / j2) + " Longest elapsed = " + j4;
            }
            printStream.println("Event = " + string + " Day = " + b.format(new Date(j)) + " Count = " + j2 + str);
        }
        query.close();
    }
}
