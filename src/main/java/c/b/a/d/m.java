package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.g;

public abstract class m extends b {
    final long a;
    private final g b;

    public m(d dVar, g gVar) {
        super(dVar);
        if (gVar.c()) {
            this.a = gVar.d();
            if (this.a < 1) {
                throw new IllegalArgumentException("The unit milliseconds must be at least 1");
            }
            this.b = gVar;
            return;
        }
        throw new IllegalArgumentException("Unit duration field must be precise");
    }

    public long b(long j, int i) {
        h.a((c) this, i, g(), d(j, i));
        return (((long) (i - a(j))) * this.a) + j;
    }

    public long d(long j) {
        if (j >= 0) {
            return j - (j % this.a);
        }
        long j2 = 1 + j;
        return (j2 - (j2 % this.a)) - this.a;
    }

    public long e(long j) {
        if (j <= 0) {
            return j - (j % this.a);
        }
        long j2 = j - 1;
        return (j2 - (j2 % this.a)) + this.a;
    }

    public long i(long j) {
        if (j >= 0) {
            return j % this.a;
        }
        return (((j + 1) % this.a) + this.a) - 1;
    }

    public g d() {
        return this.b;
    }

    public int g() {
        return 0;
    }

    public final long i() {
        return this.a;
    }

    protected int d(long j, int i) {
        return c(j);
    }
}
