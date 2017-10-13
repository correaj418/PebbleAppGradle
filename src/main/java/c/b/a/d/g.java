package c.b.a.d;

import c.b.a.c;
import c.b.a.d;

public class g extends d {
    final int a;
    final c.b.a.g b;
    final c.b.a.g c;
    private final int d;
    private final int e;

    public g(c cVar, d dVar, int i) {
        this(cVar, cVar.e(), dVar, i);
    }

    public g(c cVar, c.b.a.g gVar, d dVar, int i) {
        super(cVar, dVar);
        if (i < 2) {
            throw new IllegalArgumentException("The divisor must be at least 2");
        }
        c.b.a.g d = cVar.d();
        if (d == null) {
            this.b = null;
        } else {
            this.b = new p(d, dVar.y(), i);
        }
        this.c = gVar;
        this.a = i;
        int g = cVar.g();
        g = g >= 0 ? g / i : ((g + 1) / i) - 1;
        int h = cVar.h();
        h = h >= 0 ? h / i : ((h + 1) / i) - 1;
        this.d = g;
        this.e = h;
    }

    public c.b.a.g e() {
        if (this.c != null) {
            return this.c;
        }
        return super.e();
    }

    public int a(long j) {
        int a = i().a(j);
        if (a >= 0) {
            return a / this.a;
        }
        return ((a + 1) / this.a) - 1;
    }

    public long a(long j, int i) {
        return i().a(j, this.a * i);
    }

    public long a(long j, long j2) {
        return i().a(j, ((long) this.a) * j2);
    }

    public long b(long j, int i) {
        h.a((c) this, i, this.d, this.e);
        return i().b(j, a(i().a(j)) + (this.a * i));
    }

    public c.b.a.g d() {
        return this.b;
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public long d(long j) {
        c i = i();
        return i.d(i.b(j, a(j) * this.a));
    }

    public long i(long j) {
        return b(j, a(i().i(j)));
    }

    private int a(int i) {
        if (i >= 0) {
            return i % this.a;
        }
        return (this.a - 1) + ((i + 1) % this.a);
    }
}
