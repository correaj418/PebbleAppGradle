package c.b.a.b;

import c.b.a.c;
import c.b.a.d;
import c.b.a.d.h;
import c.b.a.d.i;

class g extends i {
    private final c a;
    private final int c = this.a.S();
    private final int d;

    g(c cVar, int i) {
        super(d.r(), cVar.V());
        this.a = cVar;
        this.d = i;
    }

    public int a(long j) {
        return this.a.b(j);
    }

    public long a(long j, int i) {
        if (i == 0) {
            return j;
        }
        int i2;
        long h = (long) this.a.h(j);
        int a = this.a.a(j);
        int a2 = this.a.a(j, a);
        int i3 = (a2 - 1) + i;
        if (a2 <= 0 || i3 >= 0) {
            i2 = a;
        } else {
            i2 = a + 1;
            i3 = (i - this.c) + (a2 - 1);
        }
        if (i3 >= 0) {
            i2 += i3 / this.c;
            i3 = (i3 % this.c) + 1;
        } else {
            i2 = (i2 + (i3 / this.c)) - 1;
            i3 = Math.abs(i3) % this.c;
            if (i3 == 0) {
                i3 = this.c;
            }
            i3 = (this.c - i3) + 1;
            if (i3 == 1) {
                i2++;
            }
        }
        a2 = this.a.a(j, a, a2);
        a = this.a.b(i2, i3);
        if (a2 <= a) {
            a = a2;
        }
        return this.a.a(i2, i3, a) + h;
    }

    public long a(long j, long j2) {
        int i = (int) j2;
        if (((long) i) == j2) {
            return a(j, i);
        }
        long j3;
        long h = (long) this.a.h(j);
        int a = this.a.a(j);
        int a2 = this.a.a(j, a);
        long j4 = ((long) (a2 - 1)) + j2;
        if (j4 >= 0) {
            j3 = ((long) a) + (j4 / ((long) this.c));
            j4 = (j4 % ((long) this.c)) + 1;
        } else {
            j3 = (((long) a) + (j4 / ((long) this.c))) - 1;
            i = (int) (Math.abs(j4) % ((long) this.c));
            if (i == 0) {
                i = this.c;
            }
            j4 = (long) ((this.c - i) + 1);
            if (j4 == 1) {
                j3++;
            }
        }
        if (j3 < ((long) this.a.Q()) || j3 > ((long) this.a.R())) {
            throw new IllegalArgumentException("Magnitude of add amount is too large: " + j2);
        }
        int i2 = (int) j3;
        int i3 = (int) j4;
        int a3 = this.a.a(j, a, a2);
        i = this.a.b(i2, i3);
        if (a3 <= i) {
            i = a3;
        }
        return this.a.a(i2, i3, i) + h;
    }

    public long b(long j, int i) {
        h.a((c) this, i, 1, this.c);
        int a = this.a.a(j);
        int b = this.a.b(j, a);
        int b2 = this.a.b(a, i);
        if (b <= b2) {
            b2 = b;
        }
        return this.a.a(a, i, b2) + ((long) this.a.h(j));
    }

    public c.b.a.g e() {
        return this.a.D();
    }

    public boolean b(long j) {
        int a = this.a.a(j);
        if (this.a.e(a) && this.a.a(j, a) == this.d) {
            return true;
        }
        return false;
    }

    public c.b.a.g f() {
        return this.a.s();
    }

    public int g() {
        return 1;
    }

    public int h() {
        return this.c;
    }

    public long d(long j) {
        int a = this.a.a(j);
        return this.a.a(a, this.a.a(j, a));
    }

    public long i(long j) {
        return j - d(j);
    }
}
