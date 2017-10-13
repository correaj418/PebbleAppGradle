package com.google.a.b;

import java.io.Serializable;
import javax.annotation.Nullable;

final class o implements Serializable {
    private int a;

    o(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public int a(int i) {
        int i2 = this.a;
        this.a = i2 + i;
        return i2;
    }

    public int b(int i) {
        int i2 = this.a + i;
        this.a = i2;
        return i2;
    }

    public void c(int i) {
        this.a = i;
    }

    public int d(int i) {
        int i2 = this.a;
        this.a = i;
        return i2;
    }

    public int hashCode() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof o) && ((o) obj).a == this.a;
    }

    public String toString() {
        return Integer.toString(this.a);
    }
}
