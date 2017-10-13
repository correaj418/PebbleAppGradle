package c.b.a.b;

import c.b.a.a;
import c.b.a.d;
import c.b.a.d.g;
import c.b.a.d.o;
import c.b.a.f;
import java.util.concurrent.ConcurrentHashMap;

public final class u extends a {
    private static final u a = new u(t.Z());
    private static final ConcurrentHashMap<f, u> b = new ConcurrentHashMap();

    static {
        b.put(f.a, a);
    }

    public static u N() {
        return a;
    }

    public static u O() {
        return b(f.a());
    }

    public static u b(f fVar) {
        if (fVar == null) {
            fVar = f.a();
        }
        u uVar = (u) b.get(fVar);
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(y.a(a, fVar));
        uVar = (u) b.putIfAbsent(fVar, uVar2);
        return uVar != null ? uVar : uVar2;
    }

    private u(a aVar) {
        super(aVar, null);
    }

    public a b() {
        return a;
    }

    public a a(f fVar) {
        if (fVar == null) {
            fVar = f.a();
        }
        return fVar == a() ? this : b(fVar);
    }

    public String toString() {
        String str = "ISOChronology";
        f a = a();
        if (a != null) {
            return str + '[' + a.e() + ']';
        }
        return str;
    }

    protected void a(a.a aVar) {
        if (L().a() == f.a) {
            aVar.H = new g(v.a, d.v(), 100);
            aVar.k = aVar.H.d();
            aVar.G = new o((g) aVar.H, d.u());
            aVar.C = new o((g) aVar.H, aVar.h, d.q());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return a().equals(((u) obj).a());
    }

    public int hashCode() {
        return ("ISO".hashCode() * 11) + a().hashCode();
    }
}
