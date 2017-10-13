package c.b.a.b;

import c.b.a.d;
import c.b.a.d.m;
import c.b.a.g;

final class i extends m {
    private final c b;

    i(c cVar, g gVar) {
        super(d.o(), gVar);
        this.b = cVar;
    }

    public int a(long j) {
        return this.b.f(j);
    }

    public g e() {
        return this.b.y();
    }

    public long d(long j) {
        return super.d(j + 259200000) - 259200000;
    }

    public long e(long j) {
        return super.e(j + 259200000) - 259200000;
    }

    public long i(long j) {
        return super.i(259200000 + j);
    }

    public int g() {
        return 1;
    }

    public int h() {
        return 53;
    }

    public int c(long j) {
        return this.b.b(this.b.e(j));
    }

    protected int d(long j, int i) {
        return i > 52 ? c(j) : 52;
    }
}
