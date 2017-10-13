package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.g;

public final class u extends d {
    public u(c cVar, d dVar) {
        super(cVar, dVar);
        if (cVar.g() != 0) {
            throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
        }
    }

    public int a(long j) {
        int a = i().a(j);
        if (a == 0) {
            return h();
        }
        return a;
    }

    public long a(long j, int i) {
        return i().a(j, i);
    }

    public long a(long j, long j2) {
        return i().a(j, j2);
    }

    public long b(long j, int i) {
        int h = h();
        h.a((c) this, i, 1, h);
        if (i == h) {
            i = 0;
        }
        return i().b(j, i);
    }

    public boolean b(long j) {
        return i().b(j);
    }

    public g f() {
        return i().f();
    }

    public int g() {
        return 1;
    }

    public int h() {
        return i().h() + 1;
    }

    public int c(long j) {
        return i().c(j) + 1;
    }

    public long d(long j) {
        return i().d(j);
    }

    public long e(long j) {
        return i().e(j);
    }

    public long f(long j) {
        return i().f(j);
    }

    public long g(long j) {
        return i().g(j);
    }

    public long h(long j) {
        return i().h(j);
    }

    public long i(long j) {
        return i().i(j);
    }
}
