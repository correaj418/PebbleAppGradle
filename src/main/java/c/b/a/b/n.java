package c.b.a.b;

import c.b.a.d.e;
import c.b.a.e.j;
import c.b.a.f;
import c.b.a.g;
import c.b.a.i;
import c.b.a.k;
import c.b.a.m;
import c.b.a.s;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public final class n extends a {
    static final k a = new k(-12219292800000L);
    private static final ConcurrentHashMap<m, n> b = new ConcurrentHashMap();
    private w c;
    private t d;
    private k e;
    private long f;
    private long g;

    private class a extends c.b.a.d.b {
        final c.b.a.c a;
        final c.b.a.c b;
        final long c;
        final boolean d;
        protected g e;
        protected g f;
        final /* synthetic */ n g;

        a(n nVar, c.b.a.c cVar, c.b.a.c cVar2, long j) {
            this(nVar, cVar, cVar2, j, false);
        }

        a(n nVar, c.b.a.c cVar, c.b.a.c cVar2, long j, boolean z) {
            this(nVar, cVar, cVar2, null, j, z);
        }

        a(n nVar, c.b.a.c cVar, c.b.a.c cVar2, g gVar, long j, boolean z) {
            this.g = nVar;
            super(cVar2.a());
            this.a = cVar;
            this.b = cVar2;
            this.c = j;
            this.d = z;
            this.e = cVar2.d();
            if (gVar == null) {
                gVar = cVar2.e();
                if (gVar == null) {
                    gVar = cVar.e();
                }
            }
            this.f = gVar;
        }

        public int a(long j) {
            if (j >= this.c) {
                return this.b.a(j);
            }
            return this.a.a(j);
        }

        public String a(long j, Locale locale) {
            if (j >= this.c) {
                return this.b.a(j, locale);
            }
            return this.a.a(j, locale);
        }

        public String a(int i, Locale locale) {
            return this.b.a(i, locale);
        }

        public String b(long j, Locale locale) {
            if (j >= this.c) {
                return this.b.b(j, locale);
            }
            return this.a.b(j, locale);
        }

        public String b(int i, Locale locale) {
            return this.b.b(i, locale);
        }

        public long a(long j, int i) {
            return this.b.a(j, i);
        }

        public long a(long j, long j2) {
            return this.b.a(j, j2);
        }

        public long b(long j, int i) {
            long b;
            if (j >= this.c) {
                b = this.b.b(j, i);
                if (b < this.c) {
                    if (this.g.g + b < this.c) {
                        b = k(b);
                    }
                    if (a(b) != i) {
                        throw new i(this.b.a(), Integer.valueOf(i), null, null);
                    }
                }
            }
            b = this.a.b(j, i);
            if (b >= this.c) {
                if (b - this.g.g >= this.c) {
                    b = j(b);
                }
                if (a(b) != i) {
                    throw new i(this.a.a(), Integer.valueOf(i), null, null);
                }
            }
            return b;
        }

        public long a(long j, String str, Locale locale) {
            long a;
            if (j >= this.c) {
                a = this.b.a(j, str, locale);
                if (a >= this.c || this.g.g + a >= this.c) {
                    return a;
                }
                return k(a);
            }
            a = this.a.a(j, str, locale);
            if (a < this.c || a - this.g.g < this.c) {
                return a;
            }
            return j(a);
        }

        public g d() {
            return this.e;
        }

        public g e() {
            return this.f;
        }

        public boolean b(long j) {
            if (j >= this.c) {
                return this.b.b(j);
            }
            return this.a.b(j);
        }

        public g f() {
            return this.b.f();
        }

        public int g() {
            return this.a.g();
        }

        public int h() {
            return this.b.h();
        }

        public int c(long j) {
            if (j >= this.c) {
                return this.b.c(j);
            }
            int c = this.a.c(j);
            if (this.a.b(j, c) >= this.c) {
                return this.a.a(this.a.a(this.c, -1));
            }
            return c;
        }

        public long d(long j) {
            if (j < this.c) {
                return this.a.d(j);
            }
            long d = this.b.d(j);
            if (d >= this.c || this.g.g + d >= this.c) {
                return d;
            }
            return k(d);
        }

        public long e(long j) {
            if (j >= this.c) {
                return this.b.e(j);
            }
            long e = this.a.e(j);
            if (e < this.c || e - this.g.g < this.c) {
                return e;
            }
            return j(e);
        }

        public int a(Locale locale) {
            return Math.max(this.a.a(locale), this.b.a(locale));
        }

        protected long j(long j) {
            if (this.d) {
                return this.g.c(j);
            }
            return this.g.a(j);
        }

        protected long k(long j) {
            if (this.d) {
                return this.g.d(j);
            }
            return this.g.b(j);
        }
    }

    private final class b extends a {
        final /* synthetic */ n h;

        b(n nVar, c.b.a.c cVar, c.b.a.c cVar2, long j) {
            this(nVar, cVar, cVar2, null, j, false);
        }

        b(n nVar, c.b.a.c cVar, c.b.a.c cVar2, g gVar, long j) {
            this(nVar, cVar, cVar2, gVar, j, false);
        }

        b(n nVar, c.b.a.c cVar, c.b.a.c cVar2, g gVar, g gVar2, long j) {
            this(nVar, cVar, cVar2, gVar, j, false);
            this.f = gVar2;
        }

        b(n nVar, c.b.a.c cVar, c.b.a.c cVar2, g gVar, long j, boolean z) {
            this.h = nVar;
            super(nVar, cVar, cVar2, j, z);
            if (gVar == null) {
                gVar = new c(this.e, this);
            }
            this.e = gVar;
        }

        public long a(long j, int i) {
            long a;
            if (j >= this.c) {
                a = this.b.a(j, i);
                if (a >= this.c || this.h.g + a >= this.c) {
                    return a;
                }
                if (this.d) {
                    if (this.h.d.z().a(a) <= 0) {
                        a = this.h.d.z().a(a, -1);
                    }
                } else if (this.h.d.E().a(a) <= 0) {
                    a = this.h.d.E().a(a, -1);
                }
                return k(a);
            }
            a = this.a.a(j, i);
            if (a < this.c || a - this.h.g < this.c) {
                return a;
            }
            return j(a);
        }

        public long a(long j, long j2) {
            long a;
            if (j >= this.c) {
                a = this.b.a(j, j2);
                if (a >= this.c || this.h.g + a >= this.c) {
                    return a;
                }
                if (this.d) {
                    if (this.h.d.z().a(a) <= 0) {
                        a = this.h.d.z().a(a, -1);
                    }
                } else if (this.h.d.E().a(a) <= 0) {
                    a = this.h.d.E().a(a, -1);
                }
                return k(a);
            }
            a = this.a.a(j, j2);
            if (a < this.c || a - this.h.g < this.c) {
                return a;
            }
            return j(a);
        }

        public int c(long j) {
            if (j >= this.c) {
                return this.b.c(j);
            }
            return this.a.c(j);
        }
    }

    private static class c extends e {
        private final b a;

        c(g gVar, b bVar) {
            super(gVar, gVar.a());
            this.a = bVar;
        }

        public long a(long j, int i) {
            return this.a.a(j, i);
        }

        public long a(long j, long j2) {
            return this.a.a(j, j2);
        }
    }

    private static long a(long j, c.b.a.a aVar, c.b.a.a aVar2) {
        return aVar2.a(aVar.E().a(j), aVar.C().a(j), aVar.u().a(j), aVar.e().a(j));
    }

    private static long b(long j, c.b.a.a aVar, c.b.a.a aVar2) {
        return aVar2.e().b(aVar2.t().b(aVar2.x().b(aVar2.z().b(0, aVar.z().a(j)), aVar.x().a(j)), aVar.t().a(j)), aVar.e().a(j));
    }

    public static n a(f fVar, s sVar) {
        return a(fVar, sVar, 4);
    }

    public static n a(f fVar, s sVar, int i) {
        s sVar2;
        f a = c.b.a.e.a(fVar);
        if (sVar == null) {
            sVar2 = a;
        } else {
            k r_ = sVar.r_();
            if (new m(r_.c(), t.b(a)).d() <= 0) {
                throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
            }
            Object obj = r_;
        }
        m mVar = new m(a, sVar2, i);
        n nVar = (n) b.get(mVar);
        if (nVar != null) {
            return nVar;
        }
        n nVar2;
        if (a == f.a) {
            nVar2 = new n(w.a(a, i), t.a(a, i), sVar2);
        } else {
            c.b.a.a a2 = a(f.a, sVar2, i);
            nVar2 = new n(y.a(a2, a), a2.c, a2.d, a2.e);
        }
        nVar = (n) b.putIfAbsent(mVar, nVar2);
        if (nVar != null) {
            return nVar;
        }
        return nVar2;
    }

    public static n a(f fVar, long j, int i) {
        s sVar;
        if (j == a.c()) {
            sVar = null;
        } else {
            sVar = new k(j);
        }
        return a(fVar, sVar, i);
    }

    private n(w wVar, t tVar, k kVar) {
        super(null, new Object[]{wVar, tVar, kVar});
    }

    private n(c.b.a.a aVar, w wVar, t tVar, k kVar) {
        super(aVar, new Object[]{wVar, tVar, kVar});
    }

    public f a() {
        c.b.a.a L = L();
        if (L != null) {
            return L.a();
        }
        return f.a;
    }

    public c.b.a.a b() {
        return a(f.a);
    }

    public c.b.a.a a(f fVar) {
        if (fVar == null) {
            fVar = f.a();
        }
        return fVar == a() ? this : a(fVar, this.e, N());
    }

    public long a(int i, int i2, int i3, int i4) {
        c.b.a.a L = L();
        if (L != null) {
            return L.a(i, i2, i3, i4);
        }
        long a = this.d.a(i, i2, i3, i4);
        if (a >= this.f) {
            return a;
        }
        a = this.c.a(i, i2, i3, i4);
        if (a < this.f) {
            return a;
        }
        throw new IllegalArgumentException("Specified date does not exist");
    }

    public long a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        c.b.a.a L = L();
        if (L != null) {
            return L.a(i, i2, i3, i4, i5, i6, i7);
        }
        long a;
        try {
            a = this.d.a(i, i2, i3, i4, i5, i6, i7);
        } catch (i e) {
            i iVar = e;
            if (i2 == 2 && i3 == 29) {
                a = this.d.a(i, i2, 28, i4, i5, i6, i7);
                if (a >= this.f) {
                    throw iVar;
                }
            }
            throw iVar;
        }
        if (a >= this.f) {
            return a;
        }
        a = this.c.a(i, i2, i3, i4, i5, i6, i7);
        if (a < this.f) {
            return a;
        }
        throw new IllegalArgumentException("Specified date does not exist");
    }

    public int N() {
        return this.d.N();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f == nVar.f && N() == nVar.N() && a().equals(nVar.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((("GJ".hashCode() * 11) + a().hashCode()) + N()) + this.e.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("GJChronology");
        stringBuffer.append('[');
        stringBuffer.append(a().e());
        if (this.f != a.c()) {
            c.b.a.e.b b;
            stringBuffer.append(",cutover=");
            if (b().v().i(this.f) == 0) {
                b = j.b();
            } else {
                b = j.c();
            }
            b.a(b()).a(stringBuffer, this.f);
        }
        if (N() != 4) {
            stringBuffer.append(",mdfw=");
            stringBuffer.append(N());
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    protected void a(c.b.a.b.a.a aVar) {
        Object[] objArr = (Object[]) M();
        w wVar = (w) objArr[0];
        c.b.a.a aVar2 = (t) objArr[1];
        k kVar = (k) objArr[2];
        this.f = kVar.c();
        this.c = wVar;
        this.d = aVar2;
        this.e = kVar;
        if (L() == null) {
            if (wVar.N() != aVar2.N()) {
                throw new IllegalArgumentException();
            }
            this.g = this.f - a(this.f);
            aVar.a(aVar2);
            if (aVar2.e().a(this.f) == 0) {
                aVar.m = new a(this, wVar.d(), aVar.m, this.f);
                aVar.n = new a(this, wVar.e(), aVar.n, this.f);
                aVar.o = new a(this, wVar.g(), aVar.o, this.f);
                aVar.p = new a(this, wVar.h(), aVar.p, this.f);
                aVar.q = new a(this, wVar.j(), aVar.q, this.f);
                aVar.r = new a(this, wVar.k(), aVar.r, this.f);
                aVar.s = new a(this, wVar.m(), aVar.s, this.f);
                aVar.u = new a(this, wVar.p(), aVar.u, this.f);
                aVar.t = new a(this, wVar.n(), aVar.t, this.f);
                aVar.v = new a(this, wVar.q(), aVar.v, this.f);
                aVar.w = new a(this, wVar.r(), aVar.w, this.f);
            }
            aVar.I = new a(this, wVar.K(), aVar.I, this.f);
            aVar.E = new b(this, wVar.E(), aVar.E, this.f);
            aVar.j = aVar.E.d();
            aVar.F = new b(this, wVar.F(), aVar.F, aVar.j, this.f);
            aVar.H = new b(this, wVar.I(), aVar.H, this.f);
            aVar.k = aVar.H.d();
            aVar.G = new b(this, wVar.G(), aVar.G, aVar.j, aVar.k, this.f);
            aVar.D = new b(this, wVar.C(), aVar.D, null, aVar.j, this.f);
            aVar.i = aVar.D.d();
            aVar.B = new b(this, wVar.z(), aVar.B, null, this.f, true);
            aVar.h = aVar.B.d();
            aVar.C = new b(this, wVar.A(), aVar.C, aVar.h, aVar.k, this.f);
            aVar.z = new a(this, wVar.v(), aVar.z, aVar.j, aVar2.E().e(this.f), false);
            aVar.A = new a(this, wVar.x(), aVar.A, aVar.h, aVar2.z().e(this.f), true);
            c.b.a.c aVar3 = new a(this, wVar.u(), aVar.y, this.f);
            aVar3.f = aVar.i;
            aVar.y = aVar3;
        }
    }

    long a(long j) {
        return a(j, this.c, this.d);
    }

    long b(long j) {
        return a(j, this.d, this.c);
    }

    long c(long j) {
        return b(j, this.c, this.d);
    }

    long d(long j) {
        return b(j, this.d, this.c);
    }
}
