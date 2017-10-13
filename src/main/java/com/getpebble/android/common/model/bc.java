package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.framework.g.e;
import com.getpebble.android.framework.l.b.an;
import com.getpebble.android.framework.l.b.j;
import com.getpebble.android.framework.timeline.e.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class bc extends ai {
    public static final Uri a = b.a("weather_app_forecast");
    public static final String[] b = new String[]{"record_key", "record_hashcode", "pebble_sync_hashcode", "current_temp", "current_weather_type", WeatherLocationsModel.LEGACY_TODAY_HIGH_TEMP, "today_low_temp", "tomorrow_weather_type", "tomorrow_high_temp", "tomorrow_low_temp", "last_update_time_ms", "short_phrase"};

    public static class a implements ai.b, e.b {
        public final UUID a;
        public final Integer b;
        public final Integer c;
        public final Short d;
        public final d e;
        public final Short f;
        public final Short g;
        public final d h;
        public final Short i;
        public final Short j;
        public final String k;
        public final long l;

        public static class a {
            private UUID a;
            private Short b = Short.valueOf(Short.MAX_VALUE);
            private d c = d.UNKNOWN;
            private Short d = Short.valueOf(Short.MAX_VALUE);
            private Short e = Short.valueOf(Short.MAX_VALUE);
            private d f = d.UNKNOWN;
            private Short g = Short.valueOf(Short.MAX_VALUE);
            private Short h = Short.valueOf(Short.MAX_VALUE);
            private String i = "";

            public void a(String str) {
                if (str != null) {
                    this.i = str;
                }
            }

            public void a(UUID uuid) {
                if (this.a == null) {
                    this.a = uuid;
                }
            }

            public void a(Short sh) {
                if (sh != null) {
                    this.b = sh;
                }
            }

            public void a(d dVar) {
                this.c = dVar;
            }

            public void b(Short sh) {
                if (sh != null) {
                    this.d = sh;
                }
            }

            public void c(Short sh) {
                if (sh != null) {
                    this.e = sh;
                }
            }

            public void b(d dVar) {
                this.f = dVar;
            }

            public void d(Short sh) {
                if (sh != null) {
                    this.g = sh;
                }
            }

            public void e(Short sh) {
                if (sh != null) {
                    this.h = sh;
                }
            }

            public a a() {
                if (this.a == null) {
                    throw new IllegalArgumentException("locationUuid cannot be null");
                }
                return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, System.currentTimeMillis());
            }

            public static a a(a aVar) {
                a aVar2 = new a();
                aVar2.a(aVar.a);
                aVar2.a(aVar.d);
                aVar2.a(aVar.e);
                aVar2.b(aVar.f);
                aVar2.c(aVar.g);
                aVar2.b(aVar.h);
                aVar2.d(aVar.i);
                aVar2.e(aVar.j);
                aVar2.a(aVar.k);
                return aVar2;
            }

            public String toString() {
                return "WeatherAppForecastModel.Record.Builder{locationUuid=" + this.a + ", currentTemp=" + this.b + ", currentWeatherType=" + this.c + ", todayHighTemp=" + this.d + ", todayLowTemp=" + this.e + ", tomorrowWeatherType=" + this.f + ", tomorrowHighTemp=" + this.g + ", tomorrowLowTemp=" + this.h + ", shortPhrase='" + this.i + '\'' + '}';
            }
        }

        public a(UUID uuid, Short sh, d dVar, Short sh2, Short sh3, d dVar2, Short sh4, Short sh5, String str, long j) {
            this.c = null;
            this.a = uuid;
            this.d = sh;
            this.e = dVar;
            this.f = sh2;
            this.g = sh3;
            this.h = dVar2;
            this.i = sh4;
            this.j = sh5;
            this.l = j;
            this.k = str;
            this.b = Integer.valueOf(hashCode());
        }

        protected a(UUID uuid, Integer num, Integer num2, Short sh, d dVar, Short sh2, Short sh3, d dVar2, Short sh4, Short sh5, String str, long j) {
            this.a = uuid;
            this.b = num;
            this.c = num2;
            this.d = sh;
            this.e = dVar;
            this.f = sh2;
            this.g = sh3;
            this.h = dVar2;
            this.i = sh4;
            this.j = sh5;
            this.l = j;
            this.k = str;
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues(bc.b.length);
            contentValues.put("record_key", this.a.toString());
            contentValues.put("record_hashcode", this.b);
            contentValues.put("pebble_sync_hashcode", this.c);
            contentValues.put("current_temp", this.d);
            contentValues.put("current_weather_type", Integer.valueOf(this.e.value()));
            contentValues.put(WeatherLocationsModel.LEGACY_TODAY_HIGH_TEMP, this.f);
            contentValues.put("today_low_temp", this.g);
            contentValues.put("tomorrow_weather_type", Integer.valueOf(this.h.value()));
            contentValues.put("tomorrow_high_temp", this.i);
            contentValues.put("tomorrow_low_temp", this.j);
            contentValues.put("last_update_time_ms", Long.valueOf(this.l));
            contentValues.put("short_phrase", this.k);
            return contentValues;
        }

        public boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (!z) {
                f.d("WeatherAppForecastModel", "sync not successful");
                return false;
            } else if (a(contentResolver)) {
                return true;
            } else {
                f.d("WeatherAppForecastModel", "sync not successful, failed to mark record up to date");
                return false;
            }
        }

        private boolean a(ContentResolver contentResolver) {
            ContentValues contentValues = new ContentValues(1);
            String valueOf = (this.b == null ? 1 : 0) != 0 ? "removed" : String.valueOf(this.b);
            if (b(null)) {
                valueOf = "removed";
            }
            contentValues.put("pebble_sync_hashcode", valueOf);
            if (contentResolver.update(bc.a, contentValues, "record_key = ?", new String[]{this.a.toString()}) > 0) {
                return true;
            }
            return false;
        }

        public boolean a(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return (this.l < bc.a() || this.b == null || this.b.equals(this.c)) ? false : true;
        }

        public boolean b(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return this.c != null && this.b == null;
        }

        private static a b(Cursor cursor) {
            Integer num;
            Integer num2;
            UUID fromString = UUID.fromString(cursor.getString(cursor.getColumnIndex("record_key")));
            String string = cursor.getString(cursor.getColumnIndex("record_hashcode"));
            if (string == null || string.equals("removed")) {
                num = null;
            } else {
                num = Integer.decode(string);
            }
            String string2 = cursor.getString(cursor.getColumnIndex("pebble_sync_hashcode"));
            if (string2 == null || string2.equals("removed")) {
                num2 = null;
            } else {
                num2 = Integer.decode(string2);
            }
            return new a(fromString, num, num2, Short.valueOf(cursor.getShort(cursor.getColumnIndex("current_temp"))), d.from(cursor.getInt(cursor.getColumnIndex("current_weather_type"))), Short.valueOf(cursor.getShort(cursor.getColumnIndex(WeatherLocationsModel.LEGACY_TODAY_HIGH_TEMP))), Short.valueOf(cursor.getShort(cursor.getColumnIndex("today_low_temp"))), d.from(cursor.getInt(cursor.getColumnIndex("tomorrow_weather_type"))), Short.valueOf(cursor.getShort(cursor.getColumnIndex("tomorrow_high_temp"))), Short.valueOf(cursor.getShort(cursor.getColumnIndex("tomorrow_low_temp"))), cursor.getString(cursor.getColumnIndex("short_phrase")), cursor.getLong(cursor.getColumnIndex("last_update_time_ms")));
        }

        public byte[] c() {
            return com.getpebble.android.bluetooth.b.b.a(this.a);
        }

        public Integer d() {
            return this.b;
        }

        public byte[] a(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar, z zVar) {
            return new an(this, WeatherLocationsModel.getWeatherLocationRecord(this.a)).a();
        }

        public j.b e() {
            return j.b.WEATHER_APP;
        }

        public String toString() {
            return "Record{recordKey=" + this.a + ", recordHashcode=" + this.b + ", pebbleSyncHashcode=" + this.c + ", currentTemp=" + this.d + ", currentWeatherType=" + this.e + ", todayHighTemp=" + this.f + ", todayLowTemp=" + this.g + ", tomorrowWeatherType=" + this.h + ", tomorrowHighTemp=" + this.i + ", tomorrowLowTemp=" + this.j + ", lastUpdateTimeMs=" + this.l + ", shortPhrase='" + this.k + '\'' + '}';
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
            if (this.l != aVar.l) {
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
            if (this.c != null) {
                if (!this.c.equals(aVar.c)) {
                    return false;
                }
            } else if (aVar.c != null) {
                return false;
            }
            if (this.d != null) {
                if (!this.d.equals(aVar.d)) {
                    return false;
                }
            } else if (aVar.d != null) {
                return false;
            }
            if (this.e != aVar.e) {
                return false;
            }
            if (this.f != null) {
                if (!this.f.equals(aVar.f)) {
                    return false;
                }
            } else if (aVar.f != null) {
                return false;
            }
            if (this.g != null) {
                if (!this.g.equals(aVar.g)) {
                    return false;
                }
            } else if (aVar.g != null) {
                return false;
            }
            if (this.h != aVar.h) {
                return false;
            }
            if (this.i != null) {
                if (!this.i.equals(aVar.i)) {
                    return false;
                }
            } else if (aVar.i != null) {
                return false;
            }
            if (this.j != null) {
                if (!this.j.equals(aVar.j)) {
                    return false;
                }
            } else if (aVar.j != null) {
                return false;
            }
            if (this.k != null) {
                z = this.k.equals(aVar.k);
            } else if (aVar.k != null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            int hashCode;
            int i = 0;
            int hashCode2 = (this.a != null ? this.a.hashCode() : 0) * 31;
            if (this.d != null) {
                hashCode = this.d.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
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
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.g != null) {
                hashCode = this.g.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.h != null) {
                hashCode = this.h.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.i != null) {
                hashCode = this.i.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.j != null) {
                hashCode = this.j.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode = (hashCode + hashCode2) * 31;
            if (this.k != null) {
                i = this.k.hashCode();
            }
            return ((hashCode + i) * 31) + ((int) (this.l ^ (this.l >>> 32)));
        }
    }

    public bc() {
        super("weather_app_forecast", false, false);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "record_key"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "record_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "pebble_sync_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "current_temp"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "current_weather_type"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, WeatherLocationsModel.LEGACY_TODAY_HIGH_TEMP));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "today_low_temp"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "tomorrow_weather_type"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "tomorrow_high_temp"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "tomorrow_low_temp"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.TIMESTAMP, "last_update_time_ms"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "short_phrase"));
    }

    public static Set<e.b> a(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, null, "record_hashcode != pebble_sync_hashcode", null, null);
        if (query == null) {
            f.d("WeatherAppForecastModel", "cursor == null");
            return Collections.EMPTY_SET;
        }
        try {
            Set<e.b> hashSet = new HashSet(query.getCount());
            while (query.moveToNext()) {
                a a = a.b(query);
                if (a.a(null) || a.b(null)) {
                    hashSet.add(a);
                }
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    public static boolean a(ContentResolver contentResolver, a aVar) {
        String str = "record_key = ?";
        String[] strArr = new String[]{aVar.a.toString()};
        Cursor query = contentResolver.query(a, b, str, strArr, null);
        if (query == null) {
            return false;
        }
        try {
            if (query.moveToFirst()) {
                a a = a.b(query);
                if (aVar.f.shortValue() == Short.MAX_VALUE && a.f.shortValue() != Short.MAX_VALUE) {
                    a a2 = a.a(aVar);
                    a2.b(a.f);
                    if (a.f.shortValue() < aVar.d.shortValue()) {
                        a2.d = aVar.d;
                    }
                    aVar = a2.a();
                }
                boolean a3 = a(contentResolver, aVar, str, strArr);
                return a3;
            }
            query.close();
            return b(contentResolver, aVar);
        } finally {
            query.close();
        }
    }

    private static boolean b(ContentResolver contentResolver, a aVar) {
        f.e("WeatherAppForecastModel", "Insert record: " + aVar.a);
        ContentValues a = aVar.a();
        a.put("pebble_sync_hashcode", "removed");
        return contentResolver.insert(a, a) != null;
    }

    private static boolean a(ContentResolver contentResolver, a aVar, String str, String[] strArr) {
        f.e("WeatherAppForecastModel", "Update record: " + aVar.a);
        ContentValues a = aVar.a();
        a.remove("pebble_sync_hashcode");
        return contentResolver.update(a, a, str, strArr) > 0;
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

    public static void b(ContentResolver contentResolver) {
        String[] strArr = new String[]{"removed", "removed"};
        if (contentResolver.delete(a, "pebble_sync_hashcode = ? AND record_hashcode = ?", strArr) > 0) {
            f.d("WeatherAppForecastModel", String.format("deleteStaleRecords(): deleted %d records from the WeatherAppForecastModel", new Object[]{Integer.valueOf(contentResolver.delete(a, "pebble_sync_hashcode = ? AND record_hashcode = ?", strArr))}));
        }
    }

    public static void c(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("record_hashcode", "removed");
        String[] strArr = new String[]{String.valueOf(a())};
        int update = contentResolver.update(a, contentValues, "last_update_time_ms < ?", strArr);
        if (update > 0) {
            f.d("WeatherAppForecastModel", update + " records marked for removal.");
        }
    }

    public static int d(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pebble_sync_hashcode", "removed");
        return contentResolver.update(a, contentValues, null, null);
    }

    private static short a(short s, com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar, com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar2) {
        if (s == Short.MAX_VALUE) {
            return Short.MAX_VALUE;
        }
        return (short) com.getpebble.android.common.model.timeline.weatherchannel.a.a.convertTemp(s, aVar, aVar2);
    }

    public static void a(ContentResolver contentResolver, com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar, com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar2) {
        Cursor query = contentResolver.query(a, b, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    a a = a.b(query);
                    a a2 = a.a(a);
                    a2.a(Short.valueOf(a(a.d.shortValue(), aVar, aVar2)));
                    a2.b(Short.valueOf(a(a.f.shortValue(), aVar, aVar2)));
                    a2.c(Short.valueOf(a(a.g.shortValue(), aVar, aVar2)));
                    a2.d(Short.valueOf(a(a.i.shortValue(), aVar, aVar2)));
                    a2.e(Short.valueOf(a(a.j.shortValue(), aVar, aVar2)));
                    a(contentResolver, a2.a());
                } finally {
                    query.close();
                }
            }
        }
    }
}
