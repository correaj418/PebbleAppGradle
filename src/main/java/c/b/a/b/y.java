package c.b.a.b;

import c.b.a.c;
import c.b.a.f;
import c.b.a.g;
import c.b.a.i;
import c.b.a.j;
import com.getpebble.android.framework.timeline.e;
import java.util.HashMap;
import java.util.Locale;

public final class y extends a {

    static final class a extends c.b.a.d.b {
        final c a;
        final f b;
        final g c;
        final boolean d;
        final g e;
        final g f;

        a(c cVar, f fVar, g gVar, g gVar2, g gVar3) {
            super(cVar.a());
            if (cVar.c()) {
                this.a = cVar;
                this.b = fVar;
                this.c = gVar;
                this.d = y.a(gVar);
                this.e = gVar2;
                this.f = gVar3;
                return;
            }
            throw new IllegalArgumentException();
        }

        public int a(long j) {
            return this.a.a(this.b.f(j));
        }

        public String a(long j, Locale locale) {
            return this.a.a(this.b.f(j), locale);
        }

        public String b(long j, Locale locale) {
            return this.a.b(this.b.f(j), locale);
        }

        public String a(int i, Locale locale) {
            return this.a.a(i, locale);
        }

        public String b(int i, Locale locale) {
            return this.a.b(i, locale);
        }

        public long a(long j, int i) {
            if (this.d) {
                int j2 = j(j);
                return this.a.a(((long) j2) + j, i) - ((long) j2);
            }
            return this.b.a(this.a.a(this.b.f(j), i), false, j);
        }

        public long a(long j, long j2) {
            if (this.d) {
                int j3 = j(j);
                return this.a.a(((long) j3) + j, j2) - ((long) j3);
            }
            return this.b.a(this.a.a(this.b.f(j), j2), false, j);
        }

        public long b(long j, int i) {
            long b = this.a.b(this.b.f(j), i);
            long a = this.b.a(b, false, j);
            if (a(a) == i) {
                return a;
            }
            Throwable jVar = new j(b, this.b.e());
            i iVar = new i(this.a.a(), Integer.valueOf(i), jVar.getMessage());
            iVar.initCause(jVar);
            throw iVar;
        }

        public long a(long j, String str, Locale locale) {
            return this.b.a(this.a.a(this.b.f(j), str, locale), false, j);
        }

        public final g d() {
            return this.c;
        }

        public final g e() {
            return this.e;
        }

        public boolean b(long j) {
            return this.a.b(this.b.f(j));
        }

        public final g f() {
            return this.f;
        }

        public long d(long j) {
            if (this.d) {
                int j2 = j(j);
                return this.a.d(((long) j2) + j) - ((long) j2);
            }
            return this.b.a(this.a.d(this.b.f(j)), false, j);
        }

        public long e(long j) {
            if (this.d) {
                int j2 = j(j);
                return this.a.e(((long) j2) + j) - ((long) j2);
            }
            return this.b.a(this.a.e(this.b.f(j)), false, j);
        }

        public long i(long j) {
            return this.a.i(this.b.f(j));
        }

        public int g() {
            return this.a.g();
        }

        public int h() {
            return this.a.h();
        }

        public int c(long j) {
            return this.a.c(this.b.f(j));
        }

        public int a(Locale locale) {
            return this.a.a(locale);
        }

        private int j(long j) {
            int b = this.b.b(j);
            if (((((long) b) + j) ^ j) >= 0 || (((long) b) ^ j) < 0) {
                return b;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.c.equals(aVar.c) && this.e.equals(aVar.e)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }
    }

    static class b extends c.b.a.d.c {
        final g a;
        final boolean b;
        final f c;

        b(g gVar, f fVar) {
            super(gVar.a());
            if (gVar.b()) {
                this.a = gVar;
                this.b = y.a(gVar);
                this.c = fVar;
                return;
            }
            throw new IllegalArgumentException();
        }

        public boolean c() {
            if (this.b) {
                return this.a.c();
            }
            return this.a.c() && this.c.f();
        }

        public long d() {
            return this.a.d();
        }

        public long a(long j, int i) {
            int a = a(j);
            long a2 = this.a.a(((long) a) + j, i);
            if (!this.b) {
                a = b(a2);
            }
            return a2 - ((long) a);
        }

        public long a(long j, long j2) {
            int a = a(j);
            long a2 = this.a.a(((long) a) + j, j2);
            if (!this.b) {
                a = b(a2);
            }
            return a2 - ((long) a);
        }

        private int a(long j) {
            int b = this.c.b(j);
            if (((((long) b) + j) ^ j) >= 0 || (((long) b) ^ j) < 0) {
                return b;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        private int b(long j) {
            int e = this.c.e(j);
            if (((j - ((long) e)) ^ j) >= 0 || (((long) e) ^ j) >= 0) {
                return e;
            }
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.c.equals(bVar.c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.c.hashCode();
        }
    }

    public static y a(c.b.a.a aVar, f fVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        c.b.a.a b = aVar.b();
        if (b == null) {
            throw new IllegalArgumentException("UTC chronology must not be null");
        } else if (fVar != null) {
            return new y(b, fVar);
        } else {
            throw new IllegalArgumentException("DateTimeZone must not be null");
        }
    }

    static boolean a(g gVar) {
        return gVar != null && gVar.d() < 43200000;
    }

    private y(c.b.a.a aVar, f fVar) {
        super(aVar, fVar);
    }

    public f a() {
        return (f) M();
    }

    public c.b.a.a b() {
        return L();
    }

    public c.b.a.a a(f fVar) {
        if (fVar == null) {
            fVar = f.a();
        }
        if (fVar == M()) {
            return this;
        }
        if (fVar == f.a) {
            return L();
        }
        return new y(L(), fVar);
    }

    public long a(int i, int i2, int i3, int i4) {
        return a(L().a(i, i2, i3, i4));
    }

    public long a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return a(L().a(i, i2, i3, i4, i5, i6, i7));
    }

    private long a(long j) {
        if (j == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        if (j == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        f a = a();
        int e = a.e(j);
        long j2 = j - ((long) e);
        if (j > 604800000 && j2 < 0) {
            return Long.MAX_VALUE;
        }
        if (j < -604800000 && j2 > 0) {
            return Long.MIN_VALUE;
        }
        if (e == a.b(j2)) {
            return j2;
        }
        throw new j(j, a.e());
    }

    protected void a(c.b.a.b.a.a aVar) {
        HashMap hashMap = new HashMap();
        aVar.l = a(aVar.l, hashMap);
        aVar.k = a(aVar.k, hashMap);
        aVar.j = a(aVar.j, hashMap);
        aVar.i = a(aVar.i, hashMap);
        aVar.h = a(aVar.h, hashMap);
        aVar.g = a(aVar.g, hashMap);
        aVar.f = a(aVar.f, hashMap);
        aVar.e = a(aVar.e, hashMap);
        aVar.d = a(aVar.d, hashMap);
        aVar.c = a(aVar.c, hashMap);
        aVar.b = a(aVar.b, hashMap);
        aVar.a = a(aVar.a, hashMap);
        aVar.E = a(aVar.E, hashMap);
        aVar.F = a(aVar.F, hashMap);
        aVar.G = a(aVar.G, hashMap);
        aVar.H = a(aVar.H, hashMap);
        aVar.I = a(aVar.I, hashMap);
        aVar.x = a(aVar.x, hashMap);
        aVar.y = a(aVar.y, hashMap);
        aVar.z = a(aVar.z, hashMap);
        aVar.D = a(aVar.D, hashMap);
        aVar.A = a(aVar.A, hashMap);
        aVar.B = a(aVar.B, hashMap);
        aVar.C = a(aVar.C, hashMap);
        aVar.m = a(aVar.m, hashMap);
        aVar.n = a(aVar.n, hashMap);
        aVar.o = a(aVar.o, hashMap);
        aVar.p = a(aVar.p, hashMap);
        aVar.q = a(aVar.q, hashMap);
        aVar.r = a(aVar.r, hashMap);
        aVar.s = a(aVar.s, hashMap);
        aVar.u = a(aVar.u, hashMap);
        aVar.t = a(aVar.t, hashMap);
        aVar.v = a(aVar.v, hashMap);
        aVar.w = a(aVar.w, hashMap);
    }

    private g a(g gVar, HashMap<Object, Object> hashMap) {
        if (gVar == null || !gVar.b()) {
            return gVar;
        }
        if (hashMap.containsKey(gVar)) {
            return (g) hashMap.get(gVar);
        }
        g bVar = new b(gVar, a());
        hashMap.put(gVar, bVar);
        return bVar;
    }

    private c a(c cVar, HashMap<Object, Object> hashMap) {
        if (cVar == null || !cVar.c()) {
            return cVar;
        }
        if (hashMap.containsKey(cVar)) {
            return (c) hashMap.get(cVar);
        }
        c aVar = new a(cVar, a(), a(cVar.d(), (HashMap) hashMap), a(cVar.e(), (HashMap) hashMap), a(cVar.f(), (HashMap) hashMap));
        hashMap.put(cVar, aVar);
        return aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (L().equals(yVar.L()) && a().equals(yVar.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (326565 + (a().hashCode() * 11)) + (L().hashCode() * 7);
    }

    public String toString() {
        return "ZonedChronology[" + L() + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + a().e() + ']';
    }
}
