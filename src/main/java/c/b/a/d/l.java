package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.g;

public class l extends m {
    private final int b;
    private final g c;

    public l(d dVar, g gVar, g gVar2) {
        super(dVar, gVar);
        if (gVar2.c()) {
            this.b = (int) (gVar2.d() / i());
            if (this.b < 2) {
                throw new IllegalArgumentException("The effective range must be at least 2");
            }
            this.c = gVar2;
            return;
        }
        throw new IllegalArgumentException("Range duration field must be precise");
    }

    public int a(long j) {
        if (j >= 0) {
            return (int) ((j / i()) % ((long) this.b));
        }
        return (this.b - 1) + ((int) (((1 + j) / i()) % ((long) this.b)));
    }

    public long b(long j, int i) {
        h.a((c) this, i, g(), h());
        return (((long) (i - a(j))) * this.a) + j;
    }

    public g e() {
        return this.c;
    }

    public int h() {
        return this.b - 1;
    }
}
