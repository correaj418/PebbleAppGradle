package com.getpebble.android.main.sections.mypebble.e;

import android.database.Cursor;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.framework.timeline.e;

public class a {
    public final String a;
    public final double b;
    public final double c;
    public final String d;
    public final String e;

    public a(Cursor cursor) {
        this.a = cursor.getString(cursor.getColumnIndex("name"));
        this.b = cursor.getDouble(cursor.getColumnIndex(WeatherLocationsModel.LATITUDE));
        this.c = cursor.getDouble(cursor.getColumnIndex(WeatherLocationsModel.LONGITUDE));
        this.d = cursor.getString(cursor.getColumnIndex("state"));
        this.e = cursor.getString(cursor.getColumnIndex("country"));
    }

    public String toString() {
        String str = this.a;
        if (!this.d.equals("")) {
            str = str + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + this.d;
        }
        if (this.e.equals("")) {
            return str;
        }
        return str + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + this.e;
    }

    public String a() {
        return "GeoModel{name='" + this.a + '\'' + ", latitude=" + this.b + ", longitude=" + this.c + ", state='" + this.d + '\'' + ", country='" + this.e + '\'' + '}';
    }
}
