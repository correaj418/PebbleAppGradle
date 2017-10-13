package c.b.a.b;

import c.b.a.c;
import c.b.a.d.d;
import c.b.a.d.h;
import c.b.a.g;

class v extends d {
    static final c a = new v();

    private v() {
        super(t.Z().E(), c.b.a.d.t());
    }

    public g e() {
        return t.Z().J();
    }

    public int a(long j) {
        int a = i().a(j);
        return a < 0 ? -a : a;
    }

    public long a(long j, int i) {
        return i().a(j, i);
    }

    public long a(long j, long j2) {
        return i().a(j, j2);
    }

    public long b(long j, int i) {
        h.a((c) this, i, 0, h());
        if (i().a(j) < 0) {
            i = -i;
        }
        return super.b(j, i);
    }

    public int g() {
        return 0;
    }

    public int h() {
        return i().h();
    }

    public long d(long j) {
        return i().d(j);
    }

    public long e(long j) {
        return i().e(j);
    }

    public long i(long j) {
        return i().i(j);
    }
}
