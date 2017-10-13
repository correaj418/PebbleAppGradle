package com.getpebble.android.framework.health.d;

import com.google.b.a.c;

public class b {
    @c(a = "restingHeartRate")
    public double a;
    @c(a = "elevatedHeartRate")
    public double b;
    @c(a = "maximumHeartRate")
    public double c;
    @c(a = "zone1Threshold")
    public double d;
    @c(a = "zone2Threshold")
    public double e;
    @c(a = "zone3Threshold")
    public double f;

    public String toString() {
        return "HeartRateInformation{restingHeartRate=" + this.a + ", elevatedHeartRate=" + this.b + ", maximumHeartRate=" + this.c + ", zone1Threshold=" + this.d + ", zone2Threshold=" + this.e + ", zone3Threshold=" + this.f + '}';
    }
}
