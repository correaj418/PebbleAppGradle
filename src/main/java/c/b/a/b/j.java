package c.b.a.b;

import c.b.a.c;
import c.b.a.d;
import c.b.a.d.h;
import c.b.a.d.i;
import c.b.a.g;

final class j extends i {
    private final c a;

    j(c cVar) {
        super(d.p(), cVar.T());
        this.a = cVar;
    }

    public int a(long j) {
        return this.a.e(j);
    }

    public long a(long j, int i) {
        return i == 0 ? j : b(j, a(j) + i);
    }

    public long a(long j, long j2) {
        return a(j, h.a(j2));
    }

    public long b(long j, int i) {
        h.a((c) this, Math.abs(i), this.a.Q(), this.a.R());
        int a = a(j);
        if (a == i) {
            return j;
        }
        int g = this.a.g(j);
        int b = this.a.b(a);
        a = this.a.b(i);
        if (a >= b) {
            a = b;
        }
        b = this.a.f(j);
        if (b <= a) {
            a = b;
        }
        long f = this.a.f(j, i);
        b = a(f);
        if (b < i) {
            f += 604800000;
        } else if (b > i) {
            f -= 604800000;
        }
        return this.a.t().b((((long) (a - this.a.f(f))) * 604800000) + f, g);
    }

    public g e() {
        return null;
    }

    public boolean b(long j) {
        return this.a.b(this.a.e(j)) > 52;
    }

    public g f() {
        return this.a.w();
    }

    public int g() {
        return this.a.Q();
    }

    public int h() {
        return this.a.R();
    }

    public long d(long j) {
        long d = this.a.x().d(j);
        int f = this.a.f(d);
        if (f > 1) {
            return d - (((long) (f - 1)) * 604800000);
        }
        return d;
    }

    public long i(long j) {
        return j - d(j);
    }
}
