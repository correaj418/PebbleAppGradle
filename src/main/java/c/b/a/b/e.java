package c.b.a.b;

import c.b.a.d;
import c.b.a.d.m;
import c.b.a.g;

final class e extends m {
    private final c b;

    e(c cVar, g gVar) {
        super(d.n(), gVar);
        this.b = cVar;
    }

    public int a(long j) {
        return this.b.d(j);
    }

    public g e() {
        return this.b.D();
    }

    public int g() {
        return 1;
    }

    public int h() {
        return this.b.O();
    }

    public int c(long j) {
        return this.b.a(this.b.a(j));
    }

    protected int d(long j, int i) {
        int O = this.b.O() - 1;
        return (i > O || i < 1) ? c(j) : O;
    }

    public boolean b(long j) {
        return this.b.j(j);
    }
}
