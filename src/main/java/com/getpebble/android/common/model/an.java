package com.getpebble.android.common.model;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ac;
import android.support.v4.app.ac.t;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.h.e;
import com.getpebble.android.h.i;
import com.getpebble.android.notifications.b.f;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class an extends ai {
    public static final String ACTIONS_DUMP = "actions_dump";
    private static final String[] ALL_COLUMNS = new String[]{NOTIFICATION_UUID, ANDROID_PACKAGE_NAME, ANDROID_NOTIFICATION_ID, ANDROID_NOTIFICATION_TAG, ANDROID_NOTIFICATION_KEY, TEXT, TITLE, BODY, GROUP_KEY, IS_SUMMARY, TIMESTAMP_MILLIS, REMOVED_TIMESTAMP_MILLIS, SOURCE, IS_ONGOING, POST_TIME_LOCAL, IS_CLEARABLE, "color", WEAR_INSTALLED, CATEGORY, NUMBER, WHEN, HAS_CONTENT_INTENT, CONTENT_ACTION, PAGES_COUNT, PAGES_DUMP, EXTRAS_DUMP, ACTIONS_DUMP, WEARABLE_ACTIONS_DUMP, SENT_TO_WATCH, DISMISSED_FROM_WATCH, IS_DUP};
    private static final String ANDROID_NOTIFICATION_ID = "android_notification_id";
    private static final String ANDROID_NOTIFICATION_KEY = "key";
    private static final String ANDROID_NOTIFICATION_TAG = "tag";
    private static final String ANDROID_PACKAGE_NAME = "package_name";
    public static final String BODY = "body";
    public static final String CATEGORY = "category";
    public static final String COLOR = "color";
    public static final String CONTENT_ACTION = "content_action";
    public static final String DISMISSED_FROM_WATCH = "dismissed_from_watch";
    public static final String EXTRAS_DUMP = "extras_dump";
    private static final String GROUP_KEY = "group_key";
    public static final String HAS_CONTENT_INTENT = "has_content_intent";
    public static final String IS_CLEARABLE = "is_clearable";
    public static final String IS_DUP = "is_dup";
    public static final String IS_ONGOING = "is_ongoing";
    private static final String IS_SUMMARY = "is_summary";
    public static final long MAX_STORED_NOTIFICATION_AGE_MILLIS = TimeUnit.DAYS.toMillis(1);
    private static final String NOTIFICATION_UUID = "notification_uuid";
    public static final String NUMBER = "number";
    public static final String PAGES_COUNT = "pages_count";
    public static final String PAGES_DUMP = "pages_dump";
    public static final String POST_TIME_LOCAL = "post_time_local";
    private static final String REMOVED_TIMESTAMP_MILLIS = "removed_timestamp_millis";
    public static final String SENT_TO_WATCH = "sent_to_watch";
    public static final String SOURCE = "source";
    public static final String TABLE_NAME = "notifications";
    public static final Uri TABLE_URI = b.a(TABLE_NAME);
    private static final String TAG = "PebbleNotificationModel";
    private static final String TEXT = "text";
    private static final String TIMESTAMP_MILLIS = "timestamp_millis";
    public static final String TITLE = "title";
    public static final String WEARABLE_ACTIONS_DUMP = "wearable_actions_dump";
    public static final String WEAR_INSTALLED = "wear_installed";
    public static final String WHEN = "_when";

    public static class a {
        public final String actionsDump;
        public final int androidNotificationId;
        public final String androidNotificationKey;
        public final String androidNotificationTag;
        public final String androidPackageName;
        public final String body;
        public final String category;
        public final String color;
        public final String contentAction;
        public final boolean dismissedFromWatch;
        public final JSONObject extrasDump;
        public final String groupKey;
        public final boolean hasContentIntent;
        private String humanReadableTimestamp;
        public final boolean isClearable;
        public final boolean isDup;
        public final boolean isOngoing;
        public final boolean isSummary;
        public final UUID notificationUuid;
        public final long number;
        public final long pagesCount;
        public final String pagesDump;
        public final long postTimeLocal;
        public final long removedTimestampMillis;
        public final boolean sentToWatch;
        public final String source;
        public final String text;
        public final long timestampMillis;
        public final String title;
        public final boolean wearInstalled;
        public final String wearableActionsDump;
        public final long when;

        public a(UUID uuid, com.getpebble.android.notifications.a.b bVar) {
            this.notificationUuid = uuid;
            this.androidPackageName = bVar.g();
            this.androidNotificationId = bVar.k();
            this.androidNotificationTag = bVar.l();
            this.androidNotificationKey = bVar.m();
            this.groupKey = bVar.q();
            this.isSummary = bVar.r();
            this.timestampMillis = bVar.c();
            this.removedTimestampMillis = 0;
            this.isOngoing = bVar.o();
            this.postTimeLocal = bVar.d();
            this.isClearable = bVar.w();
            this.sentToWatch = false;
            this.dismissedFromWatch = false;
            this.isDup = bVar.p();
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            if (bVar.i() != null) {
                str = bVar.i().a();
                str2 = bVar.i().b();
                str3 = bVar.i().c();
            }
            if (bVar.e() != null) {
                str4 = bVar.e().name();
            }
            if (bVar.s() != null) {
                str5 = bVar.s().a;
            }
            Notification n = bVar.n();
            int i = 0;
            long j = 0;
            boolean z = false;
            String str6 = null;
            int i2 = 0;
            String str7 = null;
            JSONObject jSONObject = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            if (n != null) {
                t tVar = new t(n);
                List c = tVar.c();
                str9 = f.b(n);
                i = n.number;
                j = n.when;
                boolean z2 = n.contentIntent != null;
                String valueOf = String.valueOf(tVar.d());
                int size = c.size();
                String a = f.a(c);
                JSONObject b = e.b(ac.a(n));
                String a2 = f.a(n);
                String str11 = str9;
                str9 = f.b(tVar.b());
                str8 = a2;
                jSONObject = b;
                str7 = a;
                i2 = size;
                str6 = valueOf;
                z = z2;
                str10 = str11;
            }
            this.text = str;
            this.title = str2;
            this.body = str3;
            this.source = str4;
            this.color = str5;
            this.wearInstalled = f.b();
            this.category = str10;
            this.number = (long) i;
            this.when = j;
            this.hasContentIntent = z;
            this.contentAction = str6;
            this.pagesCount = (long) i2;
            this.pagesDump = str7;
            this.extrasDump = jSONObject;
            this.actionsDump = str8;
            this.wearableActionsDump = str9;
        }

        public a(UUID uuid, String str, int i, String str2, String str3, String str4, String str5, boolean z, long j, long j2, String str6, boolean z2, long j3, boolean z3, String str7, boolean z4, String str8, long j4, long j5, boolean z5, String str9, long j6, String str10, JSONObject jSONObject, String str11, String str12, boolean z6, boolean z7, boolean z8, String str13, String str14) {
            this.notificationUuid = uuid;
            this.androidPackageName = str;
            this.androidNotificationId = i;
            this.androidNotificationTag = str2;
            this.androidNotificationKey = str3;
            this.text = str4;
            this.groupKey = str5;
            this.isSummary = z;
            this.timestampMillis = j;
            this.removedTimestampMillis = j2;
            this.source = str6;
            this.isOngoing = z2;
            this.postTimeLocal = j3;
            this.isClearable = z3;
            this.color = str7;
            this.wearInstalled = z4;
            this.category = str8;
            this.number = j4;
            this.when = j5;
            this.hasContentIntent = z5;
            this.contentAction = str9;
            this.pagesCount = j6;
            this.pagesDump = str10;
            this.extrasDump = jSONObject;
            this.actionsDump = str11;
            this.wearableActionsDump = str12;
            this.sentToWatch = z6;
            this.dismissedFromWatch = z7;
            this.isDup = z8;
            this.title = str13;
            this.body = str14;
        }

        public void populateHumanReadableTimestamp() {
            this.humanReadableTimestamp = DateFormat.getDateTimeInstance().format(new Date(this.timestampMillis));
        }

        public String toString() {
            return "PebbleNotificationRecord{notificationUuid=" + this.notificationUuid + ", androidPackageName='" + this.androidPackageName + '\'' + ", androidNotificationId=" + this.androidNotificationId + ", androidNotificationTag='" + this.androidNotificationTag + '\'' + ", androidNotificationKey='" + this.androidNotificationKey + '\'' + ", text='" + com.getpebble.android.common.b.b.a.a(this.text) + '\'' + ", groupKey='" + this.groupKey + '\'' + ", isSummary=" + this.isSummary + ", timestampMillis=" + this.timestampMillis + ", removedTimestampMillis=" + this.removedTimestampMillis + ", source='" + this.source + '\'' + ", isOngoing=" + this.isOngoing + ", postTimeLocal=" + this.postTimeLocal + ", isClearable=" + this.isClearable + ", color='" + this.color + '\'' + ", wearInstalled=" + this.wearInstalled + ", category='" + this.category + '\'' + ", number=" + this.number + ", when=" + this.when + ", hasContentIntent=" + this.hasContentIntent + ", contentAction='" + this.contentAction + '\'' + ", pagesCount=" + this.pagesCount + ", pagesDump='" + this.pagesDump + '\'' + ", extrasDump='" + f.a(this.extrasDump) + '\'' + ", actionsDump='" + this.actionsDump + '\'' + ", wearableActionsDump='" + this.wearableActionsDump + '\'' + ", sentToWatch='" + this.sentToWatch + '\'' + ", dismissedFromWatch='" + this.dismissedFromWatch + '\'' + ", isDup='" + this.isDup + '\'' + ", title='" + com.getpebble.android.common.b.b.a.a(this.title) + '\'' + ", body='" + com.getpebble.android.common.b.b.a.a(this.body) + '\'' + '}';
        }
    }

    public an() {
        super(TABLE_NAME);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, NOTIFICATION_UUID));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, ANDROID_PACKAGE_NAME));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, ANDROID_NOTIFICATION_ID));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, ANDROID_NOTIFICATION_TAG));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, ANDROID_NOTIFICATION_KEY));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, TEXT));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, TITLE));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, BODY));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, GROUP_KEY));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, IS_SUMMARY));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, TIMESTAMP_MILLIS));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, REMOVED_TIMESTAMP_MILLIS));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, SOURCE));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, IS_ONGOING));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, POST_TIME_LOCAL));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, IS_CLEARABLE));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "color"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, WEAR_INSTALLED));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, CATEGORY));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, NUMBER));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, WHEN));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, HAS_CONTENT_INTENT));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, CONTENT_ACTION));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, PAGES_COUNT));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, PAGES_DUMP));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, EXTRAS_DUMP));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, ACTIONS_DUMP));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, WEARABLE_ACTIONS_DUMP));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, SENT_TO_WATCH));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, DISMISSED_FROM_WATCH));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, IS_DUP));
    }

    public static void catTableToStream(ContentResolver contentResolver, PrintStream printStream) {
        i.b(contentResolver, printStream, TABLE_URI, "timestamp_millis ASC");
    }

    public static int markItemAsDismissed(ContentResolver contentResolver, UUID uuid) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(DISMISSED_FROM_WATCH, Boolean.valueOf(true));
        return contentResolver.update(TABLE_URI, contentValues, "notification_uuid = ? ", new String[]{uuid.toString()});
    }

    public static a parseRecordFrom(com.getpebble.android.notifications.a.b bVar) {
        return new a(bVar.a() == null ? UUID.randomUUID() : bVar.a(), bVar);
    }

    public static int markNotificationAsSent(ContentResolver contentResolver, a aVar) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(SENT_TO_WATCH, Boolean.valueOf(true));
        return contentResolver.update(TABLE_URI, contentValues, "notification_uuid = ? ", new String[]{aVar.notificationUuid.toString()});
    }

    public static void insert(ContentResolver contentResolver, a aVar) {
        int i = 1;
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot insert record with null content resolver");
        }
        int i2;
        com.getpebble.android.common.b.a.f.e(TAG, "Inserting notification record: " + aVar);
        ContentValues contentValues = new ContentValues(ALL_COLUMNS.length);
        contentValues.put(NOTIFICATION_UUID, aVar.notificationUuid.toString());
        contentValues.put(ANDROID_PACKAGE_NAME, aVar.androidPackageName);
        contentValues.put(ANDROID_NOTIFICATION_ID, Integer.valueOf(aVar.androidNotificationId));
        contentValues.put(ANDROID_NOTIFICATION_TAG, aVar.androidNotificationTag);
        contentValues.put(ANDROID_NOTIFICATION_KEY, aVar.androidNotificationKey);
        contentValues.put(TEXT, aVar.text);
        contentValues.put(GROUP_KEY, aVar.groupKey);
        contentValues.put(IS_SUMMARY, Integer.valueOf(aVar.isSummary ? 1 : 0));
        contentValues.put(TIMESTAMP_MILLIS, Long.valueOf(aVar.timestampMillis));
        contentValues.put(REMOVED_TIMESTAMP_MILLIS, Long.valueOf(aVar.removedTimestampMillis));
        contentValues.put(SOURCE, aVar.source);
        String str = IS_ONGOING;
        if (aVar.isOngoing) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        contentValues.put(str, Integer.valueOf(i2));
        contentValues.put(POST_TIME_LOCAL, Long.valueOf(aVar.postTimeLocal));
        str = IS_CLEARABLE;
        if (aVar.isClearable) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        contentValues.put(str, Integer.valueOf(i2));
        contentValues.put("color", aVar.color);
        str = WEAR_INSTALLED;
        if (aVar.wearInstalled) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        contentValues.put(str, Integer.valueOf(i2));
        contentValues.put(CATEGORY, aVar.category);
        contentValues.put(NUMBER, Long.valueOf(aVar.number));
        contentValues.put(WHEN, Long.valueOf(aVar.when));
        str = HAS_CONTENT_INTENT;
        if (aVar.hasContentIntent) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        contentValues.put(str, Integer.valueOf(i2));
        contentValues.put(CONTENT_ACTION, aVar.contentAction);
        contentValues.put(PAGES_COUNT, Long.valueOf(aVar.pagesCount));
        contentValues.put(PAGES_DUMP, aVar.pagesDump);
        contentValues.put(EXTRAS_DUMP, aVar.extrasDump != null ? aVar.extrasDump.toString() : "");
        contentValues.put(ACTIONS_DUMP, aVar.actionsDump);
        contentValues.put(WEARABLE_ACTIONS_DUMP, aVar.wearableActionsDump);
        str = SENT_TO_WATCH;
        if (aVar.sentToWatch) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        contentValues.put(str, Integer.valueOf(i2));
        str = DISMISSED_FROM_WATCH;
        if (aVar.dismissedFromWatch) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        contentValues.put(str, Integer.valueOf(i2));
        String str2 = IS_DUP;
        if (!aVar.isDup) {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        contentValues.put(TITLE, aVar.title);
        contentValues.put(BODY, aVar.body);
        contentResolver.insert(TABLE_URI, contentValues);
    }

    public static a getRecordFromCursor(Cursor cursor) {
        return new a(UUID.fromString(cursor.getString(cursor.getColumnIndex(NOTIFICATION_UUID))), cursor.getString(cursor.getColumnIndex(ANDROID_PACKAGE_NAME)), cursor.getInt(cursor.getColumnIndex(ANDROID_NOTIFICATION_ID)), cursor.getString(cursor.getColumnIndex(ANDROID_NOTIFICATION_TAG)), cursor.getString(cursor.getColumnIndex(ANDROID_NOTIFICATION_KEY)), cursor.getString(cursor.getColumnIndex(TEXT)), cursor.getString(cursor.getColumnIndex(GROUP_KEY)), cursor.getInt(cursor.getColumnIndex(IS_SUMMARY)) > 0, cursor.getLong(cursor.getColumnIndex(TIMESTAMP_MILLIS)), cursor.getLong(cursor.getColumnIndex(REMOVED_TIMESTAMP_MILLIS)), cursor.getString(cursor.getColumnIndex(SOURCE)), cursor.getInt(cursor.getColumnIndex(IS_ONGOING)) > 0, cursor.getLong(cursor.getColumnIndex(POST_TIME_LOCAL)), cursor.getInt(cursor.getColumnIndex(IS_CLEARABLE)) > 0, cursor.getString(cursor.getColumnIndex("color")), cursor.getInt(cursor.getColumnIndex(WEAR_INSTALLED)) > 0, cursor.getString(cursor.getColumnIndex(CATEGORY)), cursor.getLong(cursor.getColumnIndex(NUMBER)), cursor.getLong(cursor.getColumnIndex(WHEN)), cursor.getInt(cursor.getColumnIndex(HAS_CONTENT_INTENT)) > 0, cursor.getString(cursor.getColumnIndex(CONTENT_ACTION)), cursor.getLong(cursor.getColumnIndex(PAGES_COUNT)), cursor.getString(cursor.getColumnIndex(PAGES_DUMP)), getExtrasDump(cursor.getString(cursor.getColumnIndex(EXTRAS_DUMP))), cursor.getString(cursor.getColumnIndex(ACTIONS_DUMP)), cursor.getString(cursor.getColumnIndex(WEARABLE_ACTIONS_DUMP)), cursor.getInt(cursor.getColumnIndex(SENT_TO_WATCH)) > 0, cursor.getInt(cursor.getColumnIndex(DISMISSED_FROM_WATCH)) > 0, cursor.getInt(cursor.getColumnIndex(IS_DUP)) > 0, cursor.getString(cursor.getColumnIndex(TITLE)), cursor.getString(cursor.getColumnIndex(BODY)));
    }

    private static JSONObject getExtrasDump(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    public static a findNotification(UUID uuid, ContentResolver contentResolver) {
        a aVar = null;
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot fetch stored notifications with null content resolver");
        }
        String str = "notification_uuid = ?";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(TABLE_URI, ALL_COLUMNS, "notification_uuid = ?", new String[]{uuid.toString()}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    aVar = getRecordFromCursor(query);
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return aVar;
    }

    public static List<a> findNonRemovedNotifications(String str, int i, String str2, String str3, ContentResolver contentResolver) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot fetch stored notifications with null content resolver");
        }
        List<a> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        stringBuilder.append("package_name = ? AND tag");
        arrayList2.add(str);
        if (str2 == null) {
            stringBuilder.append(" IS NULL ");
        } else {
            stringBuilder.append(" = ? ");
            arrayList2.add(str2);
        }
        stringBuilder.append(" AND key");
        if (str3 == null) {
            stringBuilder.append(" IS NULL ");
        } else {
            stringBuilder.append(" = ? ");
            arrayList2.add(str3);
        }
        stringBuilder.append(" AND android_notification_id = ?");
        arrayList2.add(String.valueOf(i));
        stringBuilder.append(" AND removed_timestamp_millis = 0");
        String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        Cursor query = contentResolver.query(TABLE_URI, ALL_COLUMNS, stringBuilder.toString(), strArr, null);
        if (query == null) {
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                arrayList.add(getRecordFromCursor(query));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public static List<a> findNonRemovedNotifications(String str, ContentResolver contentResolver) {
        List<a> arrayList = new ArrayList();
        String str2 = "package_name = ? AND removed_timestamp_millis = 0";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(TABLE_URI, ALL_COLUMNS, "package_name = ? AND removed_timestamp_millis = 0", new String[]{str}, null);
        if (query == null) {
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                arrayList.add(getRecordFromCursor(query));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public static a findDupNotification(com.getpebble.android.notifications.a.b bVar, com.getpebble.android.common.model.c.a aVar, ContentResolver contentResolver) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot fetch stored notifications with null content resolver");
        }
        String str;
        String str2;
        String str3;
        String str4 = "";
        ArrayList arrayList = new ArrayList();
        if (bVar.g() != null) {
            arrayList.add(bVar.g());
        } else {
            arrayList.add("*");
        }
        if (bVar.i().c() == null) {
            str = "";
        } else {
            str = " AND text = ?";
            arrayList.add(bVar.i().c());
        }
        if (aVar.c) {
            str2 = " AND (removed_timestamp_millis = 0 OR removed_timestamp_millis > ?)";
            long c = bVar.c() - aVar.d;
            com.getpebble.android.common.b.a.f.e(TAG, "querying for records with removedTimestampMillis greater than " + c);
            arrayList.add(String.valueOf(c));
        } else {
            str2 = "";
        }
        if (aVar.b) {
            str3 = " AND _when = ?";
            arrayList.add(String.valueOf(bVar.n().when));
        } else {
            str3 = "";
        }
        str = "timestamp_millis DESC";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(TABLE_URI, ALL_COLUMNS, "package_name = ?" + str + str4 + str2 + str3 + " AND (" + SENT_TO_WATCH + " = 1  OR " + IS_DUP + " = 1)", (String[]) arrayList.toArray(new String[arrayList.size()]), "timestamp_millis DESC");
        if (query == null) {
            return null;
        }
        try {
            if (query.moveToNext()) {
                a recordFromCursor = getRecordFromCursor(query);
                return recordFromCursor;
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    public static a findPreviousNotification(String str, String str2, String str3, ContentResolver contentResolver, boolean z, com.getpebble.android.notifications.a.b bVar) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("Cannot fetch stored notifications with null content resolver");
        }
        String str4;
        String str5 = "";
        str5 = "";
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        } else {
            arrayList.add("*");
        }
        if (str2 == null) {
            str4 = "";
        } else {
            arrayList.add(str2);
            str4 = " AND text = ?";
        }
        if (str3 != null) {
            str5 = " AND key = ?";
            arrayList.add(str3);
        }
        String str6 = "";
        if (z) {
            str6 = " AND (removed_timestamp_millis = 0 OR removed_timestamp_millis > ?)";
            arrayList.add(String.valueOf(bVar.c() - c.b(contentResolver, str).d));
        }
        arrayList.add("1");
        str5 = "timestamp_millis DESC";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(TABLE_URI, ALL_COLUMNS, "package_name = ?" + str4 + str5 + str6 + " AND " + SENT_TO_WATCH + " = ? ", (String[]) arrayList.toArray(new String[arrayList.size()]), "timestamp_millis DESC");
        if (query == null) {
            return null;
        }
        a aVar = null;
        try {
            if (query.moveToFirst()) {
                aVar = getRecordFromCursor(query);
            }
            query.close();
            return aVar;
        } catch (Throwable th) {
            query.close();
        }
    }

    public static void purgeNotificationsForAllPackages(ContentResolver contentResolver) {
        String str = "timestamp_millis < ?";
        String[] strArr = new String[]{String.valueOf(System.currentTimeMillis() - MAX_STORED_NOTIFICATION_AGE_MILLIS)};
        com.getpebble.android.common.b.a.f.d(TAG, "Deleting all records older than " + (System.currentTimeMillis() - MAX_STORED_NOTIFICATION_AGE_MILLIS));
        contentResolver.delete(TABLE_URI, "timestamp_millis < ?", strArr);
    }

    public static void markRemovedNotificationForUuid(ContentResolver contentResolver, UUID uuid, long j) {
        String str = "notification_uuid = ? ";
        String[] strArr = new String[]{uuid.toString()};
        ContentValues contentValues = new ContentValues();
        contentValues.put(REMOVED_TIMESTAMP_MILLIS, Long.valueOf(j));
        contentResolver.update(TABLE_URI, contentValues, "notification_uuid = ? ", strArr);
    }

    public static void markAsDup(ContentResolver contentResolver, UUID uuid) {
        String str = "notification_uuid = ?";
        String[] strArr = new String[]{uuid.toString()};
        ContentValues contentValues = new ContentValues();
        contentValues.put(IS_DUP, Integer.valueOf(1));
        contentResolver.update(TABLE_URI, contentValues, "notification_uuid = ?", strArr);
    }

    public static void deleteNotificationRecord(ContentResolver contentResolver, UUID uuid) {
        String str = "notification_uuid = ?";
        String[] strArr = new String[]{uuid.toString()};
        com.getpebble.android.common.b.a.f.d(TAG, "Deleting record uuid = " + uuid);
        contentResolver.delete(TABLE_URI, "notification_uuid = ?", strArr);
    }
}
