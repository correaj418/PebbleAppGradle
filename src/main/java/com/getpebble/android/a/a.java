package com.getpebble.android.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.h.p;
import com.getpebble.android.h.x;
import com.google.b.a.c;
import com.google.b.d.d;
import com.google.b.u;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class a extends ai {
    public static final Uri a = b.a("analytics_events");
    private static final String[] b = new String[]{"collection", "event", "data", "num_upload_attempts", "uuid", "time", "globals"};

    public static class a implements ai.b {
        private static final Type h = new com.google.b.c.a<Map<String, Object>>() {
        }.getType();
        @c(a = "collection")
        public final String a;
        @c(a = "event")
        public final String b;
        @c(a = "data")
        public final Map<String, Object> c;
        public final transient int d;
        @c(a = "uuid")
        public final UUID e;
        @c(a = "time")
        public final long f;
        @c(a = "globals")
        public final Map<String, Object> g;

        public a(String str, String str2, Map<String, Object> map, long j, Map<String, Object> map2) {
            this(str, str2, map, 0, null, j, map2);
        }

        public a(String str, String str2, Map<String, Object> map, int i, String str3, long j, Map<String, Object> map2) {
            this.a = str;
            this.b = str2;
            if (map == null) {
                map = new HashMap();
            }
            this.c = map;
            this.d = i;
            this.e = str3 == null ? UUID.randomUUID() : UUID.fromString(str3);
            this.f = j;
            this.g = map2;
        }

        private static a b(Cursor cursor) {
            return new a(cursor.getString(cursor.getColumnIndex("collection")), cursor.getString(cursor.getColumnIndex("event")), a(cursor.getString(cursor.getColumnIndex("data"))), cursor.getInt(cursor.getColumnIndex("num_upload_attempts")), cursor.getString(cursor.getColumnIndex("uuid")), cursor.getLong(cursor.getColumnIndex("time")), a(cursor.getString(cursor.getColumnIndex("globals"))));
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("collection", this.a);
            contentValues.put("event", this.b);
            contentValues.put("data", a(this.c));
            contentValues.put("num_upload_attempts", Integer.valueOf(this.d));
            contentValues.put("uuid", this.e.toString());
            contentValues.put("time", Long.valueOf(this.f));
            contentValues.put("globals", a(this.g));
            return contentValues;
        }

        private static String a(Map<String, Object> map) {
            return p.a(map);
        }

        private static Map<String, Object> a(String str) {
            return (Map) p.a(str, h);
        }

        public String toString() {
            return "Record{collectionName='" + this.a + '\'' + ", eventType='" + this.b + '\'' + ", data=" + this.c + ", numUploadAttempts=" + this.d + ", uuid=" + this.e + ", timeSeconds=" + this.f + ", globals='" + this.g + "'" + '}';
        }
    }

    public a() {
        super("analytics_events");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "collection"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "event"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "data"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "num_upload_attempts"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "uuid"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "time"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "globals"));
    }

    public static int a() {
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - TimeUnit.DAYS.toSeconds(3);
        String[] strArr = new String[]{String.valueOf(toSeconds)};
        return com.getpebble.android.common.a.K().getContentResolver().delete(a, "time < ?", strArr);
    }

    public static List<a> a(int i, int i2) {
        Cursor query;
        Throwable e;
        String string;
        List<a> arrayList = new ArrayList();
        try {
            query = com.getpebble.android.common.a.K().getContentResolver().query(a, b, null, null, "num_upload_attempts DESC LIMIT " + i + " OFFSET " + i2);
            try {
                Set hashSet = new HashSet();
                while (query.moveToNext()) {
                    try {
                        arrayList.add(a.b(query));
                    } catch (d e2) {
                        e = e2;
                        string = query.getString(query.getColumnIndex("uuid"));
                        f.f("AnalyticsEventModel", "Error loading analytic event from database! Deleting; uuid = " + string + " type = '" + query.getString(query.getColumnIndex("event")) + "' data = '" + query.getString(query.getColumnIndex("data")) + "' globals = '" + query.getString(query.getColumnIndex("globals")) + "'", e);
                        if (string == null) {
                            hashSet.add(string);
                        }
                    } catch (u e3) {
                        e = e3;
                        string = query.getString(query.getColumnIndex("uuid"));
                        f.f("AnalyticsEventModel", "Error loading analytic event from database! Deleting; uuid = " + string + " type = '" + query.getString(query.getColumnIndex("event")) + "' data = '" + query.getString(query.getColumnIndex("data")) + "' globals = '" + query.getString(query.getColumnIndex("globals")) + "'", e);
                        if (string == null) {
                            hashSet.add(string);
                        }
                    } catch (IllegalArgumentException e4) {
                        e = e4;
                        string = query.getString(query.getColumnIndex("uuid"));
                        f.f("AnalyticsEventModel", "Error loading analytic event from database! Deleting; uuid = " + string + " type = '" + query.getString(query.getColumnIndex("event")) + "' data = '" + query.getString(query.getColumnIndex("data")) + "' globals = '" + query.getString(query.getColumnIndex("globals")) + "'", e);
                        if (string == null) {
                            hashSet.add(string);
                        }
                    }
                }
                b(hashSet);
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (Throwable th) {
                e = th;
            }
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public static void a(Set<UUID> set) {
        com.getpebble.android.common.a.K().getContentResolver().update(x.a(a, "num_upload_attempts"), null, "uuid" + x.a(set.size()), x.a((Collection) set));
    }

    public static void b(Set<String> set) {
        if (!set.isEmpty()) {
            com.getpebble.android.common.a.K().getContentResolver().delete(a, "uuid" + x.a(set.size()), x.a((Collection) set));
        }
    }
}
