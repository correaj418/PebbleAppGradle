package com.google.android.gms.b;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@TargetApi(9)
public class au {
    private static final List<TimeUnit> a = Arrays.asList(new TimeUnit[]{TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS});

    public static long a(long j, TimeUnit timeUnit, TimeUnit timeUnit2) {
        return timeUnit.convert(timeUnit2.convert(j, timeUnit), timeUnit2);
    }

    public static boolean a(TimeUnit timeUnit) {
        return a(timeUnit, TimeUnit.MILLISECONDS);
    }

    private static boolean a(TimeUnit timeUnit, TimeUnit timeUnit2) {
        return a.indexOf(timeUnit) < a.indexOf(timeUnit2);
    }
}
