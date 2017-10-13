package c.b.a.d;

import c.b.a.a;
import c.b.a.c;
import c.b.a.d;
import c.b.a.i;

public final class q extends f {
    private final a a;
    private final int b;
    private transient int c;

    public q(a aVar, c cVar) {
        this(aVar, cVar, 0);
    }

    public q(a aVar, c cVar, int i) {
        super(cVar);
        this.a = aVar;
        int g = super.g();
        if (g < i) {
            this.c = g - 1;
        } else if (g == i) {
            this.c = i + 1;
        } else {
            this.c = g;
        }
        this.b = i;
    }

    public int a(long j) {
        int a = super.a(j);
        if (a <= this.b) {
            return a - 1;
        }
        return a;
    }

    public long b(long j, int i) {
        h.a((c) this, i, this.c, h());
        if (i <= this.b) {
            if (i == this.b) {
                throw new i(d.s(), Integer.valueOf(i), null, null);
            }
            i++;
        }
        return super.b(j, i);
    }

    public int g() {
        return this.c;
    }
}
