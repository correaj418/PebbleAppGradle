package c.b.a.d;

import c.b.a.h;

public class n extends c {
    private final long a;

    public n(h hVar, long j) {
        super(hVar);
        this.a = j;
    }

    public final boolean c() {
        return true;
    }

    public final long d() {
        return this.a;
    }

    public long a(long j, int i) {
        return h.a(j, ((long) i) * this.a);
    }

    public long a(long j, long j2) {
        return h.a(j, h.b(j2, this.a));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (a() == nVar.a() && this.a == nVar.a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        return ((int) (j ^ (j >>> 32))) + a().hashCode();
    }
}
