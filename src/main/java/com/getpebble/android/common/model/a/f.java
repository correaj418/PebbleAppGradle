package com.getpebble.android.common.model.a;

import com.getpebble.android.common.model.a.o.b;

final class f extends b {
    private final int a;
    private final int b;
    private final int c;

    f(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
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

    public String toString() {
        return "CardiacSummary{minutesInZone1=" + this.a + ", minutesInZone2=" + this.b + ", minutesInZone3=" + this.c + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.a == bVar.a() && this.b == bVar.b() && this.c == bVar.c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }
}
