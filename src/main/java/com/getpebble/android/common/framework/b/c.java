package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.f;

abstract class c extends f {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    c(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    @com.google.b.a.c(a = "lastProcessedAt")
    public int a() {
        return this.a;
    }

    @com.google.b.a.c(a = "sleepDuration")
    public int b() {
        return this.b;
    }

    @com.google.b.a.c(a = "deepSleepDuration")
    public int c() {
        return this.c;
    }

    @com.google.b.a.c(a = "fallAsleepTime")
    public int d() {
        return this.d;
    }

    @com.google.b.a.c(a = "wakeUpTime")
    public int e() {
        return this.e;
    }

    public String toString() {
        return "SleepDataDaySummary{lastProcessedAt=" + this.a + ", sleepDuration=" + this.b + ", deepSleepDuration=" + this.c + ", fallAsleepTime=" + this.d + ", wakeUpTime=" + this.e + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.a == fVar.a() && this.b == fVar.b() && this.c == fVar.c() && this.d == fVar.d() && this.e == fVar.e()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e;
    }
}
