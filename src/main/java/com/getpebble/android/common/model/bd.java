package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels.DailyForecast;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record;
import com.getpebble.android.framework.timeline.e;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class bd extends ai {
    public static final Uri a = b.a("weather_pin_extra_info");
    public static final String[] b = new String[]{"record_key", "record_hashcode", "record_timestamp_ms", "utc_offset", "high_temp", "low_temp", "update_time_ms", "medium_phrase"};

    public static class a implements ai.b {
        public final UUID a;
        public final Integer b;
        public final long c;
        public final int d;
        public final Integer e;
        public final Integer f;
        public final long g;
        public final String h;

        public a(long j, UUID uuid, int i, Integer num, Integer num2, long j2, String str) {
            this.c = j;
            this.a = uuid;
            this.d = i;
            this.e = num;
            this.f = num2;
            this.g = j2;
            this.h = str;
            this.b = Integer.valueOf(hashCode());
        }

        protected a(UUID uuid, Integer num, long j, int i, Integer num2, Integer num3, long j2, String str) {
            this.a = uuid;
            this.b = num;
            this.c = j;
            this.d = i;
            this.e = num2;
            this.f = num3;
            this.g = j2;
            this.h = str;
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues(bd.b.length);
            contentValues.put("record_key", this.a.toString());
            contentValues.put("record_hashcode", this.b);
            contentValues.put("record_timestamp_ms", Long.valueOf(this.c));
            contentValues.put("utc_offset", Integer.valueOf(this.d));
            contentValues.put("high_temp", this.e);
            contentValues.put("low_temp", this.f);
            contentValues.put("update_time_ms", Long.valueOf(this.g));
            contentValues.put("medium_phrase", this.h);
            return contentValues;
        }

        protected static a a(Cursor cursor) {
            Integer num;
            Integer num2;
            Integer num3;
            UUID fromString = UUID.fromString(cursor.getString(cursor.getColumnIndex("record_key")));
            String string = cursor.getString(cursor.getColumnIndex("record_hashcode"));
            if (string == null || string.equals("removed")) {
                num = null;
            } else {
                num = Integer.decode(string);
            }
            long j = cursor.getLong(cursor.getColumnIndex("record_timestamp_ms"));
            int i = cursor.getInt(cursor.getColumnIndex("utc_offset"));
            if (cursor.isNull(cursor.getColumnIndex("high_temp"))) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndex("high_temp")));
            }
            if (cursor.isNull(cursor.getColumnIndex("low_temp"))) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndex("low_temp")));
            }
            return new a(fromString, num, j, i, num2, num3, cursor.getLong(cursor.getColumnIndex("update_time_ms")), cursor.getString(cursor.getColumnIndex("medium_phrase")));
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.c != aVar.c || this.d != aVar.d || this.g != aVar.g) {
                return false;
            }
            if (this.a != null) {
                if (!this.a.equals(aVar.a)) {
                    return false;
                }
            } else if (aVar.a != null) {
                return false;
            }
            if (this.b != null) {
                if (!this.b.equals(aVar.b)) {
                    return false;
                }
            } else if (aVar.b != null) {
                return false;
            }
            if (this.e != null) {
                if (!this.e.equals(aVar.e)) {
                    return false;
                }
            } else if (aVar.e != null) {
                return false;
            }
            if (this.f != null) {
                if (!this.f.equals(aVar.f)) {
                    return false;
                }
            } else if (aVar.f != null) {
                return false;
            }
            if (this.h != null) {
                z = this.h.equals(aVar.h);
            } else if (aVar.h != null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            int hashCode;
            int i = 0;
            int hashCode2 = (((((this.a != null ? this.a.hashCode() : 0) * 31) + ((int) (this.c ^ (this.c >>> 32)))) * 31) + this.d) * 31;
            if (this.e != null) {
                hashCode = this.e.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.f != null) {
                hashCode = this.f.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode = (((hashCode + hashCode2) * 31) + ((int) (this.g ^ (this.g >>> 32)))) * 31;
            if (this.h != null) {
                i = this.h.hashCode();
            }
            return hashCode + i;
        }
    }

    public bd() {
        super("weather_pin_extra_info", false, false);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.BLOB, "record_key"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "record_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "record_timestamp_ms"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "utc_offset"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "high_temp"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "low_temp"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "update_time_ms"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "medium_phrase"));
    }

    public static boolean a(ContentResolver contentResolver, a aVar) {
        String str = "record_key = ? AND record_timestamp_ms = ?";
        String[] strArr = new String[]{aVar.a.toString(), String.valueOf(aVar.c)};
        Cursor query = contentResolver.query(a, b, str, strArr, null);
        if (query == null) {
            return false;
        }
        try {
            if (query.moveToFirst()) {
                a a = a.a(query);
                if (aVar.e == null && a.e != null) {
                    aVar = new a(aVar.c, aVar.a, aVar.d, a.e, aVar.f, aVar.g, aVar.h);
                }
                boolean a2 = a(contentResolver, aVar, str, strArr);
                return a2;
            }
            query.close();
            return b(contentResolver, aVar);
        } finally {
            query.close();
        }
    }

    private static boolean b(ContentResolver contentResolver, a aVar) {
        f.d("WeatherPinExtraInfoModel", "Insert record: " + aVar.a);
        return contentResolver.insert(a, aVar.a()) != null;
    }

    private static boolean a(ContentResolver contentResolver, a aVar, String str, String[] strArr) {
        f.e("WeatherPinExtraInfoModel", "Update record: " + aVar.a);
        return contentResolver.update(a, aVar.a(), str, strArr) > 0;
    }

    public static boolean a(ContentResolver contentResolver, UUID uuid) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("record_hashcode", "removed");
        String[] strArr = new String[]{uuid.toString()};
        if (contentResolver.update(a, contentValues, "record_key = ?", strArr) > 0) {
            return true;
        }
        return false;
    }

    public static long a() {
        return new c.b.a.b(c.b.a.f.a).p_().d(0).c() - TimeUnit.HOURS.toMillis(24);
    }

    public static void a(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("record_hashcode", "removed");
        String[] strArr = new String[]{String.valueOf(a())};
        int update = contentResolver.update(a, contentValues, "record_timestamp_ms < ?", strArr);
        if (update > 0) {
            f.d("WeatherPinExtraInfoModel", update + " records marked for removal.");
        }
    }

    public static void b(ContentResolver contentResolver) {
        String[] strArr = new String[]{"removed", String.valueOf(a())};
        if (contentResolver.delete(a, "record_hashcode = ? AND record_timestamp_ms < ?", strArr) > 0) {
            f.d("WeatherPinExtraInfoModel", String.format("deleteStaleRecords(): deleted %d records from the WeatherForecastModel", new Object[]{Integer.valueOf(contentResolver.delete(a, "record_hashcode = ? AND record_timestamp_ms < ?", strArr))}));
        }
    }

    private static Integer a(Integer num, com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar, com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar2) {
        if (num == null) {
            return null;
        }
        return Integer.valueOf(com.getpebble.android.common.model.timeline.weatherchannel.a.a.convertTemp(num.intValue(), aVar, aVar2));
    }

    public static void a(ContentResolver contentResolver, com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar, com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar2) {
        Cursor query = contentResolver.query(a, b, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    a a = a.a(query);
                    a(contentResolver, new a(a.c, a.a, a.d, a(a.e, aVar, aVar2), a(a.f, aVar, aVar2), System.currentTimeMillis(), a.h));
                } finally {
                    query.close();
                }
            }
        }
    }

    public static c.b.a.b a(String str) {
        return c.b.a.b.a(str).c(c.b.a.f.a).p_().d(0);
    }

    public static a a(ContentResolver contentResolver, UUID uuid, String str) {
        a aVar = null;
        String[] strArr = new String[]{uuid.toString(), String.valueOf(a(str).c())};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, b, "record_key = ? AND record_timestamp_ms = ?", strArr, null);
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
        return aVar;
    }

    public static String a(DailyForecast dailyForecast, com.getpebble.android.framework.q.a.a aVar, boolean z) {
        String str = "—";
        StringBuilder stringBuilder = new StringBuilder();
        c.b.a.b a = a(dailyForecast.fcst_valid_local);
        if (!z) {
            a = a.a(1).d(0);
        }
        long c = a.c();
        Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(a, null, "record_timestamp_ms = ? AND record_hashcode != ?", new String[]{String.valueOf(c), "removed"}, null);
        if (query == null) {
            f.d("WeatherPinExtraInfoModel", "cursor == null");
            return null;
        }
        Object obj = null;
        while (query.moveToNext()) {
            a a2 = a.a(query);
            Record weatherLocationRecord = WeatherLocationsModel.getWeatherLocationRecord(a2.a);
            if (weatherLocationRecord == null) {
                f.d("WeatherPinExtraInfoModel", "Could not get weather for this location. Location may have been removed. locationsRecord == null");
            } else {
                try {
                    if (!weatherLocationRecord.isTimelineSource) {
                        stringBuilder.append(obj != null ? "\n" : "").append("—").append("\n").append(WeatherChannelDataModels.getLocationName(weatherLocationRecord, weatherLocationRecord.latitude, weatherLocationRecord.longitude)).append("\n").append(WeatherChannelDataModels.getTemperaturePhrase(a2.e != null ? String.valueOf(a2.e) : null, String.valueOf(a2.f)));
                        if (a2.h != null) {
                            stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR).append(a2.h);
                        }
                        obj = 1;
                    }
                } finally {
                    query.close();
                }
            }
        }
        return stringBuilder.toString();
    }
}
