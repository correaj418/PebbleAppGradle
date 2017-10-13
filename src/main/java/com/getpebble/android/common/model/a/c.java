package com.getpebble.android.common.model.a;

abstract class c extends w {
    private final short a;
    private final short b;
    private final short c;
    private final short d;
    private final short e;
    private final short f;

    c(short s, short s2, short s3, short s4, short s5, short s6) {
        this.a = s;
        this.b = s2;
        this.c = s3;
        this.d = s4;
        this.e = s5;
        this.f = s6;
    }

    @com.google.b.a.c(a = "resting_hr")
    public short a() {
        return this.a;
    }

    @com.google.b.a.c(a = "elevated_hr")
    public short b() {
        return this.b;
    }

    @com.google.b.a.c(a = "max_hr")
    public short c() {
        return this.c;
    }

    @com.google.b.a.c(a = "zone1_threshold")
    public short d() {
        return this.d;
    }

    @com.google.b.a.c(a = "zone2_threshold")
    public short e() {
        return this.e;
    }

    @com.google.b.a.c(a = "zone3_threshold")
    public short f() {
        return this.f;
    }

    public String toString() {
        return "PebbleUserHeartRatePreferences{restingHeartRate=" + this.a + ", elevatedHeartRate=" + this.b + ", maxHeartRate=" + this.c + ", thresholdZone1=" + this.d + ", thresholdZone2=" + this.e + ", thresholdZone3=" + this.f + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (this.a == wVar.a() && this.b == wVar.b() && this.c == wVar.c() && this.d == wVar.d() && this.e == wVar.e() && this.f == wVar.f()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f;
    }
}
