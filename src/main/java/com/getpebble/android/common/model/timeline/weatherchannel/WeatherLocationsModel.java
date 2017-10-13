package com.getpebble.android.common.model.timeline.weatherchannel;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.Uri;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.ai.a;
import com.getpebble.android.h.i;
import com.getpebble.android.h.x;
import com.google.a.b.ad;
import com.google.b.o;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WeatherLocationsModel extends ai {
    public static final String ADDED_BY_USER = "added_by_user";
    public static final String[] ALL_COLUMNS = new String[]{LOCATION_UUID, UPDATED_TIMESTAMP, LATITUDE, LONGITUDE, LOCATION_NAME, IS_DYNAMIC, IS_TIMELINE_SOURCE, ADDED_BY_USER};
    public static final String IS_DYNAMIC = "is_dynamic";
    public static final String IS_TIMELINE_SOURCE = "is_timeline_source";
    public static final String LATITUDE = "latitude";
    public static double LATITUDE_INVALID = 91.0d;
    public static final String LEGACY_TODAY_HIGH_TEMP = "today_high_temp";
    public static final String LOCATION_NAME = "location_name";
    public static final String LOCATION_UUID = "location_uuid";
    public static final String LONGITUDE = "longitude";
    public static double LONGITUDE_INVALID = 181.0d;
    public static final String TABLE_NAME = "weather_locations";
    public static final Uri TABLE_URI = b.a(TABLE_NAME);
    private static final String TAG = "WeatherLocationsModel";
    public static final String UPDATED_TIMESTAMP = "updated_timestamp";
    public static final String USER_LOCATION = "user_location";

    public static class Record {
        public static final long INVALID_TIMESTAMP = -1;
        public final boolean addedByUser;
        public final boolean isDynamic;
        public final boolean isTimelineSource;
        public final double latitude;
        public final String locationName;
        public final UUID locationUuid;
        public final double longitude;
        public final long updateTimestampMs;

        public static class Builder {
            public boolean addedByUser = false;
            public boolean isDynamic = false;
            public boolean isTimelineSource = false;
            public double latitude = 0.0d;
            public String locationName = "";
            public UUID locationUuid = UUID.randomUUID();
            public double longitude = 0.0d;
            public long updateTimestampMs = -1;

            public Builder setUpdatedTimestamp(long j) {
                this.updateTimestampMs = j;
                return this;
            }

            public Builder setLatitude(double d) {
                this.latitude = d;
                return this;
            }

            public Builder setLongitude(double d) {
                this.longitude = d;
                return this;
            }

            public Builder setLocationName(String str) {
                this.locationName = str;
                return this;
            }

            public Builder setIsDynamic(boolean z) {
                this.isDynamic = z;
                return this;
            }

            public Builder setIsTimelineSource(boolean z) {
                this.isTimelineSource = z;
                return this;
            }

            public Builder setLocationUuid(UUID uuid) {
                this.locationUuid = uuid;
                return this;
            }

            public Builder setAddedByUser(boolean z) {
                this.addedByUser = z;
                return this;
            }

            public static Builder from(Record record) {
                if (record == null) {
                    return null;
                }
                Builder builder = new Builder();
                builder.locationUuid = record.locationUuid;
                builder.updateTimestampMs = record.updateTimestampMs;
                builder.latitude = record.latitude;
                builder.longitude = record.longitude;
                builder.locationName = record.locationName;
                builder.isDynamic = record.isDynamic;
                builder.isTimelineSource = record.isTimelineSource;
                builder.addedByUser = record.addedByUser;
                return builder;
            }

            Record build() {
                return new Record(this.updateTimestampMs, this.latitude, this.longitude, this.locationName, this.isDynamic, this.isTimelineSource, this.locationUuid, this.addedByUser);
            }
        }

        public Record(long j, double d, double d2, String str, boolean z, boolean z2, UUID uuid, boolean z3) {
            this.locationUuid = uuid;
            this.updateTimestampMs = j;
            this.latitude = d;
            this.longitude = d2;
            this.locationName = str;
            this.isDynamic = z;
            this.isTimelineSource = z2;
            this.addedByUser = z3;
        }

        public String toString() {
            return "Record{locationUuid=" + this.locationUuid + "updatedTimestampMs=" + this.updateTimestampMs + "latitude=" + this.latitude + "longitude=" + this.longitude + "locationName=" + this.locationName + "isDynamic=" + this.isDynamic + "isTimelineSource=" + this.isTimelineSource + "addedByUser=" + this.addedByUser + "}";
        }

        public static Record from(Cursor cursor) {
            boolean z;
            boolean z2;
            boolean z3;
            UUID fromString = UUID.fromString(cursor.getString(cursor.getColumnIndex(WeatherLocationsModel.LOCATION_UUID)));
            long j = cursor.getLong(cursor.getColumnIndex(WeatherLocationsModel.UPDATED_TIMESTAMP));
            double d = cursor.getDouble(cursor.getColumnIndex(WeatherLocationsModel.LATITUDE));
            double d2 = cursor.getDouble(cursor.getColumnIndex(WeatherLocationsModel.LONGITUDE));
            String string = cursor.getString(cursor.getColumnIndex(WeatherLocationsModel.LOCATION_NAME));
            if (cursor.getInt(cursor.getColumnIndex(WeatherLocationsModel.IS_DYNAMIC)) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (cursor.getInt(cursor.getColumnIndex(WeatherLocationsModel.IS_TIMELINE_SOURCE)) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (cursor.getInt(cursor.getColumnIndex(WeatherLocationsModel.ADDED_BY_USER)) > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            return new Record(j, d, d2, string, z, z2, fromString, z3);
        }

        public ContentValues toContentValues() {
            ContentValues contentValues = new ContentValues(WeatherLocationsModel.ALL_COLUMNS.length);
            contentValues.put(WeatherLocationsModel.LOCATION_UUID, this.locationUuid.toString());
            contentValues.put(WeatherLocationsModel.UPDATED_TIMESTAMP, Long.valueOf(this.updateTimestampMs));
            contentValues.put(WeatherLocationsModel.LATITUDE, Double.valueOf(this.latitude));
            contentValues.put(WeatherLocationsModel.LONGITUDE, Double.valueOf(this.longitude));
            contentValues.put(WeatherLocationsModel.LOCATION_NAME, this.locationName);
            contentValues.put(WeatherLocationsModel.IS_DYNAMIC, Boolean.valueOf(this.isDynamic));
            contentValues.put(WeatherLocationsModel.IS_TIMELINE_SOURCE, Boolean.valueOf(this.isTimelineSource));
            contentValues.put(WeatherLocationsModel.ADDED_BY_USER, Boolean.valueOf(this.addedByUser));
            return contentValues;
        }
    }

    public static class UuidJsonObject {
        public String day_after_tomorrow_day;
        public String day_after_tomorrow_night;
        public String today_day;
        public String today_night;
        public String tomorrow_day;
        public String tomorrow_night;
    }

    public WeatherLocationsModel() {
        super(TABLE_NAME);
        addColumn(new a(a.a.STRING, LOCATION_UUID));
        addColumn(new a(a.a.INTEGER, UPDATED_TIMESTAMP));
        addColumn(new a(a.a.INTEGER, LATITUDE));
        addColumn(new a(a.a.INTEGER, LONGITUDE));
        addColumn(new a(a.a.STRING, LOCATION_NAME));
        addColumn(new a(a.a.INTEGER, IS_DYNAMIC));
        addColumn(new a(a.a.INTEGER, IS_TIMELINE_SOURCE));
        addColumn(new a(a.a.INTEGER, ADDED_BY_USER));
        addColumn(new a(a.a.STRING, LEGACY_TODAY_HIGH_TEMP));
    }

    public static Record fromContentValues(ContentValues contentValues) {
        return new Record(contentValues.getAsLong(UPDATED_TIMESTAMP).longValue(), contentValues.getAsDouble(LATITUDE).doubleValue(), contentValues.getAsDouble(LONGITUDE).doubleValue(), contentValues.getAsString(LOCATION_NAME), contentValues.getAsBoolean(IS_DYNAMIC).booleanValue(), contentValues.getAsBoolean(IS_TIMELINE_SOURCE).booleanValue(), UUID.fromString(contentValues.getAsString(LOCATION_UUID)), contentValues.getAsBoolean(ADDED_BY_USER).booleanValue());
    }

    public static boolean update(ContentResolver contentResolver, Builder builder) {
        Record build = builder.build();
        if (contentResolver.update(TABLE_URI, build.toContentValues(), x.b(ad.a(LOCATION_UUID)), new String[]{build.locationUuid.toString()}) > 0) {
            return true;
        }
        return false;
    }

    public static void insert(ContentResolver contentResolver, Builder builder) {
        contentResolver.insert(TABLE_URI, builder.build().toContentValues());
    }

    public static Cursor query(ContentResolver contentResolver, String str, String[] strArr, String str2) {
        return contentResolver.query(TABLE_URI, ALL_COLUMNS, str, strArr, str2);
    }

    public static boolean delete(ContentResolver contentResolver, UUID uuid) {
        if (contentResolver.delete(TABLE_URI, x.b(ad.a(LOCATION_UUID)), new String[]{uuid.toString()}) > 0) {
            return true;
        }
        return false;
    }

    public static void insertDynamicLocation(SQLiteDatabase sQLiteDatabase) {
        Builder builder = new Builder();
        builder.setIsDynamic(true);
        builder.setLocationName(USER_LOCATION);
        builder.setLatitude(LATITUDE_INVALID);
        builder.setLongitude(LONGITUDE_INVALID);
        builder.setUpdatedTimestamp(System.currentTimeMillis());
        builder.setIsTimelineSource(true);
        builder.setAddedByUser(true);
        sQLiteDatabase.insert(TABLE_NAME, null, builder.build().toContentValues());
    }

    public static boolean updateDynamicLocation(ContentResolver contentResolver, ContentValues contentValues) {
        if (contentResolver.update(TABLE_URI, contentValues, x.b(ad.a(IS_DYNAMIC)), new String[]{"1"}) > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateDynamicLocation(ContentResolver contentResolver, Location location) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IS_DYNAMIC, Boolean.valueOf(true));
        contentValues.put(LATITUDE, Double.valueOf(location.getLatitude()));
        contentValues.put(LONGITUDE, Double.valueOf(location.getLongitude()));
        contentValues.put(LOCATION_NAME, USER_LOCATION);
        contentValues.put(UPDATED_TIMESTAMP, Integer.valueOf(0));
        return updateDynamicLocation(contentResolver, contentValues);
    }

    public static Record getDynamicLocationRecord(ContentResolver contentResolver) {
        Record record = null;
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(TABLE_URI, ALL_COLUMNS, x.b(ad.a(IS_DYNAMIC)), new String[]{"1"}, record);
        if (query == null) {
            f.a(TAG, "getDynamicLocationRecord() cursor is null");
        } else {
            try {
                if (query.moveToFirst()) {
                    record = Record.from(query);
                    query.close();
                } else {
                    f.d(TAG, "getDynamicLocationRecord cursor is empty");
                }
            } finally {
                query.close();
            }
        }
        return record;
    }

    public static Location getCurrentLocation(ContentResolver contentResolver) {
        Record dynamicLocationRecord = getDynamicLocationRecord(contentResolver);
        if (dynamicLocationRecord == null) {
            return null;
        }
        Location location = new Location("CurrentLocation");
        location.setLatitude(dynamicLocationRecord.latitude);
        location.setLongitude(dynamicLocationRecord.longitude);
        return location;
    }

    public static boolean containsDupCityName(String str, Record record) {
        String[] strArr = new String[]{str + ",%", record.locationUuid.toString()};
        Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(TABLE_URI, ALL_COLUMNS, "location_name LIKE ? AND location_uuid != ?", strArr, null);
        try {
            if (query.getCount() > 0) {
                return true;
            }
            query.close();
            return false;
        } finally {
            query.close();
        }
    }

    public static boolean updateDynamicAddedByUser(ContentResolver contentResolver, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ADDED_BY_USER, Boolean.valueOf(z));
        return updateDynamicLocation(contentResolver, contentValues);
    }

    public static void updateWeatherTimelineItems(ContentResolver contentResolver) {
        Cursor query = query(contentResolver, null, null, null);
        if (query == null) {
            f.d(TAG, "Bad cursor value - returning.");
            return;
        }
        while (query.moveToNext()) {
            Builder from = Builder.from(Record.from(query));
            from.setUpdatedTimestamp(0);
            update(contentResolver, from);
        }
        query.close();
        PebbleApplication.v().f();
    }

    public static String getTimelineJsonUuids() {
        o oVar = new o();
        oVar.a("today_day", "61b22bc8-1e29-460d-a236-3fe409a43901");
        oVar.a("today_night", "61b22bc8-1e29-460d-a236-3fe409a43902");
        oVar.a("tomorrow_day", "61b22bc8-1e29-460d-a236-3fe409a43903");
        oVar.a("tomorrow_night", "61b22bc8-1e29-460d-a236-3fe409a43904");
        oVar.a("day_after_tomorrow_day", "61b22bc8-1e29-460d-a236-3fe409a43905");
        oVar.a("day_after_tomorrow_night", "61b22bc8-1e29-460d-a236-3fe409a43906");
        return oVar.toString();
    }

    public static void catTableToStream(ContentResolver contentResolver, PrintStream printStream) {
        i.a(contentResolver, printStream, TABLE_URI, "location_name DESC");
    }

    public static Record getWeatherLocationRecord(UUID uuid) {
        Record record = null;
        Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(TABLE_URI, record, x.b(ad.a(LOCATION_UUID)), new String[]{uuid.toString()}, record);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    record = Record.from(query);
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return record;
    }

    public static Record getCurrentLocationRecord() {
        Record record = null;
        Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(TABLE_URI, record, x.b(ad.a(IS_DYNAMIC)), new String[]{String.valueOf(1)}, record);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    record = Record.from(query);
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return record;
    }

    public static List<UUID> getWeatherLocationsList(ContentResolver contentResolver) {
        List<UUID> list = null;
        String[] strArr = new String[]{"-1"};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(TABLE_URI, ALL_COLUMNS, "_id != ?", strArr, null);
        if (query != null) {
            list = new ArrayList();
            while (query.moveToNext()) {
                try {
                    list.add(UUID.fromString(query.getString(query.getColumnIndex(LOCATION_UUID))));
                } finally {
                    query.close();
                }
            }
        }
        return list;
    }
}
