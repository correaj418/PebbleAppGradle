package c.b.a.b;

import c.b.a.a;
import c.b.a.b;
import c.b.a.c;
import c.b.a.d;
import c.b.a.d.g;
import c.b.a.d.k;
import c.b.a.d.o;
import c.b.a.d.r;
import c.b.a.d.t;
import c.b.a.f;
import c.b.a.h;
import java.util.concurrent.ConcurrentHashMap;

public final class l extends a {
    private static final c a = new h("BE");
    private static final ConcurrentHashMap<f, l> b = new ConcurrentHashMap();
    private static final l c = b(f.a);

    public static l b(f fVar) {
        if (fVar == null) {
            fVar = f.a();
        }
        l lVar = (l) b.get(fVar);
        if (lVar != null) {
            return lVar;
        }
        a lVar2 = new l(n.a(fVar, null), null);
        l lVar3 = new l(x.a(lVar2, new b(1, 1, 1, 0, 0, 0, 0, lVar2), null), "");
        lVar = (l) b.putIfAbsent(fVar, lVar3);
        return lVar != null ? lVar : lVar3;
    }

    private l(a aVar, Object obj) {
        super(aVar, obj);
    }

    public a b() {
        return c;
    }

    public a a(f fVar) {
        if (fVar == null) {
            fVar = f.a();
        }
        return fVar == a() ? this : b(fVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        return a().equals(((l) obj).a());
    }

    public int hashCode() {
        return ("Buddhist".hashCode() * 11) + a().hashCode();
    }

    public String toString() {
        String str = "BuddhistChronology";
        f a = a();
        if (a != null) {
            return str + '[' + a.e() + ']';
        }
        return str;
    }

    protected void a(a.a aVar) {
        if (M() == null) {
            aVar.l = t.a(h.l());
            aVar.E = new k(new r(this, aVar.E), 543);
            c cVar = aVar.F;
            aVar.F = new c.b.a.d.f(aVar.E, aVar.l, d.t());
            aVar.B = new k(new r(this, aVar.B), 543);
            aVar.H = new g(new k(aVar.F, 99), aVar.l, d.v(), 100);
            aVar.k = aVar.H.d();
            aVar.G = new k(new o((g) aVar.H), d.u(), 1);
            aVar.C = new k(new o(aVar.B, aVar.k, d.q(), 100), d.q(), 1);
            aVar.I = a;
        }
    }
}
