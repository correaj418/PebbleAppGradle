package com.getpebble.android.common.model.a;

import com.getpebble.android.common.model.a.o.a;

final class e extends a {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    e(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public String toString() {
        return "ActivitySummary{stepCount=" + this.a + ", restingGramCalories=" + this.b + ", activeGramCalories=" + this.c + ", distanceMm=" + this.d + ", activeMinutes=" + this.e + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.a == aVar.a() && this.b == aVar.b() && this.c == aVar.c() && this.d == aVar.d() && this.e == aVar.e()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e;
    }
}
