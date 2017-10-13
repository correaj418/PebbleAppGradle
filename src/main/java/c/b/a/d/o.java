package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.g;

public class o extends d {
    final int a;
    final g b;
    final g c;

    public o(c cVar, g gVar, d dVar, int i) {
        super(cVar, dVar);
        if (i < 2) {
            throw new IllegalArgumentException("The divisor must be at least 2");
        }
        this.c = gVar;
        this.b = cVar.d();
        this.a = i;
    }

    public o(g gVar) {
        this(gVar, gVar.a());
    }

    public o(g gVar, d dVar) {
        this(gVar, gVar.i().d(), dVar);
    }

    public o(g gVar, g gVar2, d dVar) {
        super(gVar.i(), dVar);
        this.a = gVar.a;
        this.b = gVar2;
        this.c = gVar.b;
    }

    public int a(long j) {
        int a = i().a(j);
        if (a >= 0) {
            return a % this.a;
        }
        return ((a + 1) % this.a) + (this.a - 1);
    }

    public long b(long j, int i) {
        h.a((c) this, i, 0, this.a - 1);
        return i().b(j, (a(i().a(j)) * this.a) + i);
    }

    public g d() {
        return this.b;
    }

    public g e() {
        return this.c;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return this.a - 1;
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

    private int a(int i) {
        if (i >= 0) {
            return i / this.a;
        }
        return ((i + 1) / this.a) - 1;
    }
}
