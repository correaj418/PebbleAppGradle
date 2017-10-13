package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Field extends AbstractSafeParcelable {
    public static final Field A = b("elevation.change");
    public static final Field B = e("elevation.gain");
    public static final Field C = e("elevation.loss");
    public static final Creator<Field> CREATOR = new i();
    public static final Field D = b("floors");
    public static final Field E = e("floor.gain");
    public static final Field F = e("floor.loss");
    public static final Field G = d("exercise");
    public static final Field H = a("repetitions");
    public static final Field I = b("resistance");
    public static final Field J = a("resistance_type");
    public static final Field K = a("num_segments");
    public static final Field L = b("average");
    public static final Field M = b("max");
    public static final Field N = b("min");
    public static final Field O = b("low_latitude");
    public static final Field P = b("low_longitude");
    public static final Field Q = b("high_latitude");
    public static final Field R = b("high_longitude");
    public static final Field S = b("x");
    public static final Field T = b("y");
    public static final Field U = b("z");
    public static final Field a = a("activity");
    public static final Field b = b("confidence");
    public static final Field c = e("activity_confidence");
    public static final Field d = a("steps");
    public static final Field e = a("duration");
    public static final Field f = e("activity_duration");
    public static final Field g = e("activity_duration.ascending");
    public static final Field h = e("activity_duration.descending");
    public static final Field i = b("bpm");
    public static final Field j = b(WeatherLocationsModel.LATITUDE);
    public static final Field k = b(WeatherLocationsModel.LONGITUDE);
    public static final Field l = b("accuracy");
    public static final Field m = c("altitude");
    public static final Field n = b("distance");
    public static final Field o = b("height");
    public static final Field p = b("weight");
    public static final Field q = b("circumference");
    public static final Field r = b("percentage");
    public static final Field s = b("speed");
    public static final Field t = b("rpm");
    public static final Field u = a("revolutions");
    public static final Field v = b("calories");
    public static final Field w = b("watts");
    public static final Field x = a("meal_type");
    public static final Field y = d("food_item");
    public static final Field z = e("nutrients");
    private final int V;
    private final String W;
    private final int X;
    private final Boolean Y;

    Field(int i, String str, int i2, Boolean bool) {
        this.V = i;
        this.W = (String) b.a((Object) str);
        this.X = i2;
        this.Y = bool;
    }

    private Field(String str, int i) {
        this(2, str, i, null);
    }

    private Field(String str, int i, Boolean bool) {
        this(2, str, i, bool);
    }

    private static Field a(String str) {
        return new Field(str, 1);
    }

    private boolean a(Field field) {
        return this.W.equals(field.W) && this.X == field.X;
    }

    private static Field b(String str) {
        return new Field(str, 2);
    }

    private static Field c(String str) {
        return new Field(str, 2, Boolean.valueOf(true));
    }

    private static Field d(String str) {
        return new Field(str, 3);
    }

    private static Field e(String str) {
        return new Field(str, 4);
    }

    public String a() {
        return this.W;
    }

    public int b() {
        return this.X;
    }

    public Boolean c() {
        return this.Y;
    }

    int d() {
        return this.V;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Field) && a((Field) obj));
    }

    public int hashCode() {
        return this.W.hashCode();
    }

    public String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[2];
        objArr[0] = this.W;
        objArr[1] = this.X == 1 ? "i" : "f";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        i.a(this, parcel, i);
    }
}
