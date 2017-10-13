package c.b.a.b;

import c.b.a.c;
import c.b.a.d;
import c.b.a.d.h;
import c.b.a.d.i;
import c.b.a.g;

class k extends i {
    protected final c a;

    k(c cVar) {
        super(d.s(), cVar.T());
        this.a = cVar;
    }

    public int a(long j) {
        return this.a.a(j);
    }

    public long a(long j, int i) {
        return i == 0 ? j : b(j, h.a(a(j), i));
    }

    public long a(long j, long j2) {
        return a(j, h.a(j2));
    }

    public long b(long j, int i) {
        h.a((c) this, i, this.a.Q(), this.a.R());
        return this.a.f(j, i);
    }

    public long c(long j, int i) {
        h.a((c) this, i, this.a.Q() - 1, this.a.R() + 1);
        return this.a.f(j, i);
    }

    public g e() {
        return null;
    }

    public boolean b(long j) {
        return this.a.e(a(j));
    }

    public g f() {
        return this.a.s();
    }

    public int g() {
        return this.a.Q();
    }

    public int h() {
        return this.a.R();
    }

    public long d(long j) {
        return this.a.d(a(j));
    }

    public long e(long j) {
        int a = a(j);
        if (j != this.a.d(a)) {
            return this.a.d(a + 1);
        }
        return j;
    }

    public long i(long j) {
        return j - d(j);
    }
}
