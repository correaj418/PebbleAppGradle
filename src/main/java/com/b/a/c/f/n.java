package com.b.a.c.f;

import java.util.Arrays;

final class n {
    private int a;
    private int b;
    private int c;
    private final int[] d = new int[10];

    n() {
    }

    public void a() {
        this.c = 0;
        this.b = 0;
        this.a = 0;
        Arrays.fill(this.d, 0);
    }

    public n a(int i, int i2, int i3) {
        if (i < this.d.length) {
            int i4 = 1 << i;
            this.a |= i4;
            if ((i2 & 1) != 0) {
                this.b |= i4;
            } else {
                this.b &= i4 ^ -1;
            }
            if ((i2 & 2) != 0) {
                this.c = i4 | this.c;
            } else {
                this.c = (i4 ^ -1) & this.c;
            }
            this.d[i] = i3;
        }
        return this;
    }

    boolean a(int i) {
        if (((1 << i) & this.a) != 0) {
            return true;
        }
        return false;
    }

    int b(int i) {
        return this.d[i];
    }

    int c(int i) {
        int i2 = 0;
        if (f(i)) {
            i2 = 2;
        }
        if (e(i)) {
            return i2 | 1;
        }
        return i2;
    }

    int b() {
        return Integer.bitCount(this.a);
    }

    int c() {
        return (2 & this.a) != 0 ? this.d[1] : -1;
    }

    public int d(int i) {
        return (128 & this.a) != 0 ? this.d[7] : i;
    }

    boolean e(int i) {
        if (((1 << i) & this.b) != 0) {
            return true;
        }
        return false;
    }

    boolean f(int i) {
        if (((1 << i) & this.c) != 0) {
            return true;
        }
        return false;
    }

    public void a(n nVar) {
        for (int i = 0; i < 10; i++) {
            if (nVar.a(i)) {
                a(i, nVar.c(i), nVar.b(i));
            }
        }
    }
}
