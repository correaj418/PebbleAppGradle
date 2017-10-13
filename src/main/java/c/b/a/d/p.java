package c.b.a.d;

import c.b.a.g;
import c.b.a.h;

public class p extends e {
    private final int a;

    public p(g gVar, h hVar, int i) {
        super(gVar, hVar);
        if (i == 0 || i == 1) {
            throw new IllegalArgumentException("The scalar must not be 0 or 1");
        }
        this.a = i;
    }

    public long a(long j, int i) {
        return f().a(j, ((long) i) * ((long) this.a));
    }

    public long a(long j, long j2) {
        return f().a(j, h.a(j2, this.a));
    }

    public long d() {
        return f().d() * ((long) this.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (f().equals(pVar.f()) && a() == pVar.a() && this.a == pVar.a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = (long) this.a;
        return (((int) (j ^ (j >>> 32))) + a().hashCode()) + f().hashCode();
    }
}
