package com.getpebble.android.framework.health.g;

import android.content.Context;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.framework.health.g.a.a;
import com.getpebble.android.h.q;

public class b {
    public static a a() {
        a a = a(PebbleApplication.y().a(c.a.HEIGHT_UNIT, -1));
        if (a == null) {
            return c();
        }
        return a;
    }

    public static com.getpebble.android.framework.health.g.a.b b() {
        com.getpebble.android.framework.health.g.a.b b = b(PebbleApplication.y().a(c.a.WEIGHT_UNIT, -1));
        if (b == null) {
            return d();
        }
        return b;
    }

    public static void a(a aVar) {
        PebbleApplication.y().b(c.a.HEIGHT_UNIT, aVar.preferenceId());
    }

    public static void a(com.getpebble.android.framework.health.g.a.b bVar) {
        PebbleApplication.y().b(c.a.WEIGHT_UNIT, bVar.preferenceId());
    }

    public static a a(int i) {
        for (a aVar : a.values()) {
            if (aVar.preferenceId() == i) {
                return aVar;
            }
        }
        return null;
    }

    public static com.getpebble.android.framework.health.g.a.b b(int i) {
        for (com.getpebble.android.framework.health.g.a.b bVar : com.getpebble.android.framework.health.g.a.b.values()) {
            if (bVar.preferenceId() == i) {
                return bVar;
            }
        }
        return null;
    }

    public static String a(a aVar, int i, Context context) {
        if (aVar == a.INCHES) {
            int fromMillimeters = aVar.fromMillimeters(i);
            return context.getString(aVar.stringFormatterResourceId(), new Object[]{Integer.valueOf(fromMillimeters / 12), Integer.valueOf(fromMillimeters % 12)});
        }
        return context.getString(aVar.stringFormatterResourceId(), new Object[]{Integer.valueOf(aVar.fromMillimeters(i))});
    }

    private static a c() {
        String toUpperCase = q.b().getCountry().toUpperCase();
        return ("US".equals(toUpperCase) || "CA".equals(toUpperCase) || "GB".equals(toUpperCase)) ? a.INCHES : a.CENTIMETERS;
    }

    private static com.getpebble.android.framework.health.g.a.b d() {
        String country = q.b().getCountry();
        return ("US".equals(country) || "CA".equals(country) || "GB".equals(country)) ? com.getpebble.android.framework.health.g.a.b.POUNDS : com.getpebble.android.framework.health.g.a.b.KILOGRAMS;
    }
}
