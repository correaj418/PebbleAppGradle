package c.b.a.b;

import c.b.a.c;
import c.b.a.d.d;
import c.b.a.d.h;
import c.b.a.g;

final class s extends d {
    private final c a;

    s(c cVar, c cVar2) {
        super(cVar, c.b.a.d.t());
        this.a = cVar2;
    }

    public g e() {
        return this.a.J();
    }

    public int a(long j) {
        int a = i().a(j);
        if (a <= 0) {
            return 1 - a;
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
        h.a((c) this, i, 1, h());
        if (this.a.a(j) <= 0) {
            i = 1 - i;
        }
        return super.b(j, i);
    }

    public int g() {
        return 1;
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
