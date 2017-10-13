package c.b.a.a;

import c.b.a.d.h;
import c.b.a.e;
import c.b.a.e.j;
import c.b.a.f;
import c.b.a.k;
import c.b.a.n;
import c.b.a.s;
import java.util.Date;
import org.joda.convert.ToString;

public abstract class b implements s {
    public /* synthetic */ int compareTo(Object obj) {
        return b((s) obj);
    }

    protected b() {
    }

    public f n() {
        return d().a();
    }

    public k r_() {
        return new k(c());
    }

    public c.b.a.b b() {
        return new c.b.a.b(c(), n());
    }

    public c.b.a.b a(f fVar) {
        return new c.b.a.b(c(), e.a(d()).a(fVar));
    }

    public n e() {
        return new n(c(), n());
    }

    public Date o() {
        return new Date(c());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (c() == sVar.c() && h.a(d(), sVar.d())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((int) (c() ^ (c() >>> 32))) + d().hashCode();
    }

    public int b(s sVar) {
        if (this == sVar) {
            return 0;
        }
        long c = sVar.c();
        long c2 = c();
        if (c2 == c) {
            return 0;
        }
        if (c2 < c) {
            return -1;
        }
        return 1;
    }

    public boolean b(long j) {
        return c() < j;
    }

    public boolean a(s sVar) {
        return b(e.a(sVar));
    }

    @ToString
    public String toString() {
        return j.c().a((s) this);
    }
}
