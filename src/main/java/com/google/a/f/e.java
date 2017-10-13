package com.google.a.f;

import com.google.a.a.h;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class e extends Number implements Comparable<e> {
    public static final e a = a(0);
    public static final e b = a(1);
    public static final e c = a(-1);
    private final int d;

    public /* synthetic */ int compareTo(Object obj) {
        return e((e) obj);
    }

    private e(int i) {
        this.d = i & -1;
    }

    public static e a(int i) {
        return new e(i);
    }

    public static e a(long j) {
        boolean z;
        if ((4294967295L & j) == j) {
            z = true;
        } else {
            z = false;
        }
        h.a(z, "value (%s) is outside the range for an unsigned integer value", Long.valueOf(j));
        return a((int) j);
    }

    public static e a(String str) {
        return a(str, 10);
    }

    public static e a(String str, int i) {
        return a(f.a(str, i));
    }

    public e a(e eVar) {
        return a(((e) h.a((Object) eVar)).d + this.d);
    }

    public e b(e eVar) {
        return a(this.d - ((e) h.a((Object) eVar)).d);
    }

    public e c(e eVar) {
        return a(((e) h.a((Object) eVar)).d * this.d);
    }

    public e d(e eVar) {
        return a(f.b(this.d, ((e) h.a((Object) eVar)).d));
    }

    public int intValue() {
        return this.d;
    }

    public long longValue() {
        return f.b(this.d);
    }

    public float floatValue() {
        return (float) longValue();
    }

    public double doubleValue() {
        return (double) longValue();
    }

    public int e(e eVar) {
        h.a((Object) eVar);
        return f.a(this.d, eVar.d);
    }

    public int hashCode() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (this.d == ((e) obj).d) {
            return true;
        }
        return false;
    }

    public String toString() {
        return b(10);
    }

    public String b(int i) {
        return f.c(this.d, i);
    }
}
