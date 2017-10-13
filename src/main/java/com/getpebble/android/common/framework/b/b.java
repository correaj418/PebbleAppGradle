package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.e;
import com.getpebble.android.common.framework.b.m.h;
import com.google.b.a.c;

abstract class b extends e {
    private final Integer a;
    private final h b;

    b(Integer num, h hVar) {
        if (num == null) {
            throw new NullPointerException("Null restingHeartRate");
        }
        this.a = num;
        this.b = hVar;
    }

    @c(a = "restingHeartRate")
    public Integer a() {
        return this.a;
    }

    @c(a = "scannedRange")
    public h b() {
        return this.b;
    }

    public String toString() {
        return "RestingHeartRate{restingHeartRate=" + this.a + ", scannedRange=" + this.b + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.a.equals(eVar.a())) {
            if (this.b == null) {
                if (eVar.b() == null) {
                    return true;
                }
            } else if (this.b.equals(eVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.b == null ? 0 : this.b.hashCode()) ^ (1000003 * (this.a.hashCode() ^ 1000003));
    }
}
