package c.b.a.c;

import c.b.a.a;
import c.b.a.b.u;
import c.b.a.e;
import c.b.a.f;
import c.b.a.s;

class o extends a implements h, l {
    static final o a = new o();

    protected o() {
    }

    public a a(Object obj, f fVar) {
        a d = ((s) obj).d();
        if (d == null) {
            return u.b(fVar);
        }
        if (d.a() == fVar) {
            return d;
        }
        d = d.a(fVar);
        if (d == null) {
            return u.b(fVar);
        }
        return d;
    }

    public a b(Object obj, a aVar) {
        if (aVar == null) {
            return e.a(((s) obj).d());
        }
        return aVar;
    }

    public long a(Object obj, a aVar) {
        return ((s) obj).c();
    }

    public Class<?> a() {
        return s.class;
    }
}
