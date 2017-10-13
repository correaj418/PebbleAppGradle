package com.getpebble.android.common.model.timeline.weatherchannel;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.aw.c;
import com.getpebble.android.common.model.bd;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.UuidJsonObject;
import com.getpebble.android.framework.q.a.a;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.framework.timeline.e.b;
import com.getpebble.android.framework.timeline.e.d;
import com.getpebble.android.framework.timeline.f;
import com.getpebble.android.framework.timeline.g;
import com.getpebble.android.h.ab;
import com.google.b.q;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class WeatherChannelDataModels {
    public static final String DEGREE_CODE = "°";
    public static final int MS_TO_MIN_DIVISOR = 60000;
    private static final String TAG = "WeatherChannelDataModels";
    private static final String US_COUNTRY_CODE = "US";

    public static class AggregateReport {
        public CurrentConditions currentConditions;
        public DailyForecast[] dailyForecasts;

        public AggregateReport(CurrentConditions currentConditions, DailyForecast[] dailyForecastArr) {
            this.dailyForecasts = dailyForecastArr;
            this.currentConditions = currentConditions;
        }
    }

    public static class CurrentConditions {
        public long expire_time_gmt;
        public int icon_code;
        public TemperatureHolder imperial;
        public TemperatureHolder metric;
        public String phrase_12char;
        public TemperatureHolder uk_hybrid;

        public static class TemperatureHolder {
            public short temp;
        }

        public d getWeatherType() {
            return (d) e.WEATHER_ICON_TYPE_MAP.get(this.icon_code, d.WEATHER_ICON);
        }

        public Short getTemp() {
            if (this.metric != null) {
                return Short.valueOf(this.metric.temp);
            }
            if (this.imperial != null) {
                return Short.valueOf(this.imperial.temp);
            }
            if (this.uk_hybrid != null) {
                return Short.valueOf(this.uk_hybrid.temp);
            }
            return null;
        }
    }

    public static class DailyForecast {
        public DayPartForecast day;
        public String dow;
        public long expire_time_gmt;
        public String fcst_valid_local;
        public String max_temp;
        public String min_temp;
        public String narrative;
        public DayPartForecast night;
        public String sunrise;
        public String sunset;
    }

    public static class DayPartForecast {
        public String day_ind;
        public String daypart_name;
        public String fcst_valid_local;
        public int icon_code;
        public String narrative;
        public String phrase_22char;
        public String phrase_32char;
        public String shortcast;
        public int temp;
        public String temp_phrase;

        public b getWeatherResource() {
            return (b) e.WEATHER_ICON_RESOURCE_MAP.get(this.icon_code, b.WEATHER_ICON);
        }

        public d getWeatherType() {
            return (d) e.WEATHER_ICON_TYPE_MAP.get(this.icon_code, d.WEATHER_ICON);
        }

        public aw.d toTimelineRecord(String str, DailyForecast dailyForecast, Record record, a aVar, String str2) {
            String locationName = WeatherChannelDataModels.getLocationName(record, record.latitude, record.longitude);
            Resources resources = com.getpebble.android.common.a.K().getResources();
            String str3 = this.fcst_valid_local;
            String string = com.getpebble.android.common.a.K().getResources().getString(R.string.weather);
            String string2 = resources.getString(R.string.weather_channel_d);
            String string3 = resources.getString(R.string.weather_channel_n);
            String string4 = resources.getString(R.string.weather_sunrise);
            String string5 = resources.getString(R.string.weather_sunset);
            if (this.day_ind.equals(string2)) {
                if (dailyForecast.sunrise != null) {
                    string2 = dailyForecast.sunrise;
                }
                string4 = string;
                string2 = str3;
            } else {
                if (this.day_ind.equals(string3) && dailyForecast.sunset != null) {
                    string2 = dailyForecast.sunset;
                    string4 = string5;
                }
                string4 = string;
                string2 = str3;
            }
            string = dailyForecast.max_temp;
            if (string == null) {
                bd.a a = bd.a(com.getpebble.android.common.a.K().getContentResolver(), record.locationUuid, dailyForecast.fcst_valid_local);
                if (a.e != null) {
                    string = String.valueOf(a.e);
                }
            }
            string = WeatherChannelDataModels.getTemperaturePhrase(string, dailyForecast.min_temp);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add("");
                arrayList2.add(str2);
            }
            arrayList.add(resources.getString(R.string.weather_timeline_heading));
            arrayList2.add(resources.getString(R.string.weather_timeline_paragraph));
            return new aw.d(new c(UUID.fromString(str), aw.c, aw.b.PIN, 0, WeatherChannelDataModels.dateStringToMillis(string2), new g(g.WEATHER_PIN, new f().add(e.c.TITLE_KEY, string4).add(e.c.SUBTITLE_KEY, string).add(e.c.BODY_KEY, this.narrative).add(e.c.TINY_ICON, getWeatherResource()).add(e.c.LARGE_ICON, getWeatherResource()).add(e.c.LOCATION_NAME, locationName).add(e.c.HEADINGS, arrayList).add(e.c.PARAGRAPHS, arrayList2).add(e.c.LAST_UPDATED, ab.b())).toJson(), com.getpebble.android.framework.timeline.d.getWeatherActions().toJson(), false, true, false, false, false, c.a.EMPTY), System.currentTimeMillis(), System.currentTimeMillis(), aw.e.WEATHER, aw.c);
        }
    }

    private WeatherChannelDataModels() {
    }

    public static String getLocationName(Record record, double d, double d2) {
        String locality;
        Object obj;
        String str = record.locationName;
        String string = com.getpebble.android.common.a.K().getString(R.string.weather_current_location);
        String str2 = "";
        int i;
        if (str.equals(WeatherLocationsModel.USER_LOCATION)) {
            CharSequence charSequence;
            Address locationAddress = getLocationAddress(d, d2);
            if (locationAddress != null) {
                locality = locationAddress.getLocality();
                str = locationAddress.getCountryCode();
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                    obj = locality;
                } else if (str.equals(US_COUNTRY_CODE)) {
                    str = getStateFromAddress(locationAddress);
                    charSequence = locality;
                } else {
                    obj = locality;
                }
            } else {
                str = str2;
                obj = string;
            }
            if (TextUtils.isEmpty(charSequence)) {
                com.getpebble.android.common.b.a.f.d(TAG, "Failed to get valid location from Geocoder; using fallback");
                charSequence = string;
            }
            locality = charSequence;
            obj = str;
            i = 1;
        } else {
            String[] split = str.split(",");
            if (TextUtils.isEmpty(split[0])) {
                com.getpebble.android.common.b.a.f.d(TAG, "Unexpected location name: " + str);
            } else {
                str = split[0];
            }
            if (split.length <= 1) {
                locality = str;
                i = 0;
            } else if (TextUtils.isEmpty(split[1])) {
                com.getpebble.android.common.b.a.f.d(TAG, "Unexpected location name: " + str);
                locality = str;
                i = 0;
            } else {
                obj = split[1].trim();
                locality = str;
                i = 0;
            }
        }
        if ((!WeatherLocationsModel.containsDupCityName(locality, record) && (r0 != 0 || !isCurrentLocationDup(locality))) || locality.equals(string) || TextUtils.isEmpty(obj)) {
            return locality;
        }
        return locality + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + obj;
    }

    private static String getStateFromAddress(Address address) {
        String str = "";
        String addressLine = address.getAddressLine(1);
        if (addressLine == null) {
            return str;
        }
        String[] split = addressLine.split(",");
        if (split.length > 1) {
            return split[1].trim().split(" ")[0];
        }
        return str;
    }

    private static Address getLocationAddress(double d, double d2) {
        Geocoder geocoder = new Geocoder(com.getpebble.android.common.a.K());
        if (Geocoder.isPresent()) {
            try {
                List fromLocation = geocoder.getFromLocation(d, d2, 1);
                if (fromLocation == null) {
                    return null;
                }
                if (fromLocation.size() == 1) {
                    return (Address) fromLocation.get(0);
                }
            } catch (IOException e) {
                Throwable e2 = e;
                com.getpebble.android.common.b.a.f.a(TAG, "Failed to get location with lat: " + d + ", lng: " + d2, e2);
                return null;
            } catch (IllegalArgumentException e3) {
                e2 = e3;
                com.getpebble.android.common.b.a.f.a(TAG, "Failed to get location with lat: " + d + ", lng: " + d2, e2);
                return null;
            }
        }
        return null;
    }

    private static boolean isCurrentLocationDup(String str) {
        Record currentLocationRecord = WeatherLocationsModel.getCurrentLocationRecord();
        if (currentLocationRecord != null) {
            Address locationAddress = getLocationAddress(currentLocationRecord.latitude, currentLocationRecord.longitude);
            if (locationAddress != null && str.equals(locationAddress.getLocality())) {
                return true;
            }
        }
        return false;
    }

    public static long dateStringToMillis(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).parse(str).getTime();
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a(TAG, "dateStringToMillis", e);
            return System.currentTimeMillis();
        }
    }

    public static int dateStringToUtcOffsetMinutes(String str) {
        try {
            return c.b.a.b.a(str).n().a(null) / MS_TO_MIN_DIVISOR;
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a(TAG, "dateStringToUtcOffsetMinutes", e);
            return 0;
        }
    }

    public static String getTemperaturePhrase(String str, String str2) {
        String str3 = "/";
        if (str != null) {
            str3 = str + DEGREE_CODE + str3;
        } else {
            str3 = "-" + str3;
        }
        if (str2 != null) {
            return str3 + str2 + DEGREE_CODE;
        }
        return str3 + "-";
    }

    public static void updateOrInsertWeatherByDay(Record record, DailyForecast dailyForecast, a aVar) {
        if (dailyForecast != null) {
            String str;
            String str2;
            DayPartForecast dayPartForecast = dailyForecast.day;
            DayPartForecast dayPartForecast2 = dailyForecast.night;
            UuidJsonObject uuidJsonObject = (UuidJsonObject) new com.google.b.f().a(new q().a(WeatherLocationsModel.getTimelineJsonUuids()).l(), UuidJsonObject.class);
            ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
            String str3 = "";
            String str4 = "";
            switch (aVar) {
                case TODAY:
                    str4 = uuidJsonObject.today_day;
                    str = uuidJsonObject.today_night;
                    str2 = str4;
                    break;
                case TOMORROW:
                    str4 = uuidJsonObject.tomorrow_day;
                    str = uuidJsonObject.tomorrow_night;
                    str2 = str4;
                    break;
                case DAY_AFTER_TOMORROW:
                    str4 = uuidJsonObject.day_after_tomorrow_day;
                    str = uuidJsonObject.day_after_tomorrow_night;
                    str2 = str4;
                    break;
                default:
                    str = str4;
                    str2 = str3;
                    break;
            }
            String a = bd.a(dailyForecast, aVar, true);
            String a2 = bd.a(dailyForecast, aVar, false);
            if (dayPartForecast != null) {
                aw.a(contentResolver, str2, dayPartForecast.toTimelineRecord(str2, dailyForecast, record, aVar, a));
            } else {
                aw.c(contentResolver, UUID.fromString(str2));
            }
            if (dayPartForecast2 != null) {
                aw.a(contentResolver, str, dayPartForecast2.toTimelineRecord(str, dailyForecast, record, aVar, a2));
            } else {
                aw.c(contentResolver, UUID.fromString(str));
            }
        }
    }
}
