package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.d;
import com.google.b.a.c;

abstract class a extends d {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    @c(a = "lastProcessedAt")
    public int a() {
        return this.a;
    }

    @c(a = "steps")
    public int b() {
        return this.b;
    }

    @c(a = "activeKiloCalories")
    public int c() {
        return this.c;
    }

    @c(a = "restingKiloCalories")
    public int d() {
        return this.d;
    }

    @c(a = "distance")
    public int e() {
        return this.e;
    }

    @c(a = "activeSeconds")
    public int f() {
        return this.f;
    }

    public String toString() {
        return "MovementDataDaySummary{lastProcessedAt=" + this.a + ", steps=" + this.b + ", activeKiloCalories=" + this.c + ", restingKiloCalories=" + this.d + ", distance=" + this.e + ", activeSeconds=" + this.f + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.a == dVar.a() && this.b == dVar.b() && this.c == dVar.c() && this.d == dVar.d() && this.e == dVar.e() && this.f == dVar.f()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f;
    }
}
