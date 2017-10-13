package com.getpebble.android.h;

import c.b.a.b;
import c.b.a.f;
import c.b.a.m;
import com.google.a.f.a;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ab {
    public static int a() {
        return a(System.currentTimeMillis());
    }

    public static int a(long j) {
        return a.a(TimeUnit.MILLISECONDS.toSeconds(j));
    }

    public static int b(long j) {
        return a.a(TimeUnit.MILLISECONDS.toMinutes(j));
    }

    public static Calendar a(String str) {
        return new b((Object) str, f.a).m();
    }

    public static long b(String str) {
        return (long) a(a(str).getTime().getTime());
    }

    public static String b() {
        return new b(f.a).toString();
    }

    public static String c(long j) {
        return new b(f.a).a(m.a(new Date(j))).toString();
    }

    public static boolean d(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.get(12) == 0;
    }

    public static b a(long j, TimeZone timeZone) {
        return new b(b(j, timeZone), a(timeZone));
    }

    private static long b(long j, TimeZone timeZone) {
        long toMillis = TimeUnit.SECONDS.toMillis(j);
        return toMillis - ((long) timeZone.getOffset(toMillis));
    }

    public static f a(TimeZone timeZone) {
        return f.a(timeZone.getID());
    }
}
