package com.google.android.gms.b;

import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.google.android.gms.b.f.b;

public class av {
    public static final b A = e("food_item");
    public static final b B = g("nutrients");
    public static final b C = c("elevation.change");
    public static final b D = g("elevation.gain");
    public static final b E = g("elevation.loss");
    public static final b F = c("floors");
    public static final b G = g("floor.gain");
    public static final b H = g("floor.loss");
    public static final b I = e("exercise");
    public static final b J = a("repetitions");
    public static final b K = c("resistance");
    public static final b L = a("resistance_type");
    public static final b M = a("num_segments");
    public static final b N = c("average");
    public static final b O = c("max");
    public static final b P = c("min");
    public static final b Q = c("low_latitude");
    public static final b R = c("low_longitude");
    public static final b S = c("high_latitude");
    public static final b T = c("high_longitude");
    public static final b U = c("x");
    public static final b V = c("y");
    public static final b W = c("z");
    public static final b X = h("timestamps");
    public static final b Y = i("sensor_values");
    public static final b Z = a("sensor_type");
    public static final b a = a("activity");
    public static final b aa = e("identifier");
    public static final b ab = f("name");
    public static final b ac = f("description");
    public static final b ad = b("active_time");
    public static final b b = c("confidence");
    public static final b c = g("activity_confidence");
    public static final b d = a("steps");
    public static final b e = a("duration");
    public static final b f = g("activity_duration");
    public static final b g = g("activity_duration.ascending");
    public static final b h = g("activity_duration.descending");
    public static final b i = c("bpm");
    public static final b j = c(WeatherLocationsModel.LATITUDE);
    public static final b k = c(WeatherLocationsModel.LONGITUDE);
    public static final b l = c("accuracy");
    public static final b m = d("altitude");
    public static final b n = c("distance");
    public static final b o = j("google.android.fitness.GoalV2");
    public static final b p = c("progress");
    public static final b q = c("height");
    public static final b r = c("weight");
    public static final b s = c("circumference");
    public static final b t = c("percentage");
    public static final b u = c("speed");
    public static final b v = c("rpm");
    public static final b w = a("revolutions");
    public static final b x = c("calories");
    public static final b y = c("watts");
    public static final b z = a("meal_type");

    private static b a(String str) {
        return a(str, 1);
    }

    public static b a(String str, int i) {
        return a(str, i, null);
    }

    private static b a(String str, int i, Boolean bool) {
        b bVar = new b();
        bVar.b = str;
        bVar.c = Integer.valueOf(i);
        if (bool != null) {
            bVar.d = bool;
        }
        return bVar;
    }

    private static b b(String str) {
        return a(str, 1, Boolean.valueOf(true));
    }

    private static b c(String str) {
        return a(str, 2);
    }

    private static b d(String str) {
        return a(str, 2, Boolean.valueOf(true));
    }

    private static b e(String str) {
        return a(str, 3);
    }

    private static b f(String str) {
        return a(str, 3, Boolean.valueOf(true));
    }

    private static b g(String str) {
        return a(str, 4);
    }

    private static b h(String str) {
        return a(str, 5);
    }

    private static b i(String str) {
        return a(str, 6);
    }

    private static b j(String str) {
        return a(str, 7);
    }
}
