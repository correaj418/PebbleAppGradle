package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.h;
import com.google.b.a.c;

abstract class d extends h {
    private final int a;
    private final int b;

    d(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @c(a = "start")
    public int a() {
        return this.a;
    }

    @c(a = "end")
    public int b() {
        return this.b;
    }

    public String toString() {
        return "TimeRangeWithTimestamps{startSeconds=" + this.a + ", endSeconds=" + this.b + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.a == hVar.a() && this.b == hVar.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b;
    }
}
