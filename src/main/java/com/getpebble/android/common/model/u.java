package com.getpebble.android.common.model;

import c.b.a.b;
import c.b.a.f;
import java.util.concurrent.TimeUnit;

public enum u {
    MONDAY(1, "monday"),
    TUESDAY(2, "tuesday"),
    WEDNESDAY(3, "wednesday"),
    THURSDAY(4, "thursday"),
    FRIDAY(5, "friday"),
    SATURDAY(6, "saturday"),
    SUNDAY(7, "sunday");
    
    private static final String TAG = "DayOfWeek";
    public final String blobDbKeyName;
    public final int isoIndex;

    private u(int i, String str) {
        this.isoIndex = i;
        this.blobDbKeyName = str;
    }

    public static u from(int i) {
        for (u uVar : values()) {
            if (uVar.isoIndex == i) {
                return uVar;
            }
        }
        throw new IllegalArgumentException("invalid ISO index: " + i);
    }

    public static u from(b bVar) {
        return from(bVar.k());
    }

    public static u from(long j, int i) {
        return from(new b(TimeUnit.SECONDS.toMillis(j), f.a((int) TimeUnit.SECONDS.toMillis((long) i))));
    }
}
