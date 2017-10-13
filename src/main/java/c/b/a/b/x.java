package c.b.a.b;

import c.b.a.d.d;
import c.b.a.d.e;
import c.b.a.d.h;
import c.b.a.e.j;
import c.b.a.f;
import c.b.a.g;
import c.b.a.n;
import c.b.a.q;
import c.b.a.s;
import java.util.HashMap;
import java.util.Locale;

public final class x extends a {
    final c.b.a.b a;
    final c.b.a.b b;
    private transient x c;

    private class a extends d {
        final /* synthetic */ x a;
        private final g b;
        private final g c;
        private final g d;

        a(x xVar, c.b.a.c cVar, g gVar, g gVar2, g gVar3) {
            this.a = xVar;
            super(cVar, cVar.a());
            this.b = gVar;
            this.c = gVar2;
            this.d = gVar3;
        }

        public int a(long j) {
            this.a.a(j, null);
            return i().a(j);
        }

        public String a(long j, Locale locale) {
            this.a.a(j, null);
            return i().a(j, locale);
        }

        public String b(long j, Locale locale) {
            this.a.a(j, null);
            return i().b(j, locale);
        }

        public long a(long j, int i) {
            this.a.a(j, null);
            long a = i().a(j, i);
            this.a.a(a, "resulting");
            return a;
        }

        public long a(long j, long j2) {
            this.a.a(j, null);
            long a = i().a(j, j2);
            this.a.a(a, "resulting");
            return a;
        }

        public long b(long j, int i) {
            this.a.a(j, null);
            long b = i().b(j, i);
            this.a.a(b, "resulting");
            return b;
        }

        public long a(long j, String str, Locale locale) {
            this.a.a(j, null);
            long a = i().a(j, str, locale);
            this.a.a(a, "resulting");
            return a;
        }

        public final g d() {
            return this.b;
        }

        public final g e() {
            return this.c;
        }

        public boolean b(long j) {
            this.a.a(j, null);
            return i().b(j);
        }

        public final g f() {
            return this.d;
        }

        public long d(long j) {
            this.a.a(j, null);
            long d = i().d(j);
            this.a.a(d, "resulting");
            return d;
        }

        public long e(long j) {
            this.a.a(j, null);
            long e = i().e(j);
            this.a.a(e, "resulting");
            return e;
        }

        public long f(long j) {
            this.a.a(j, null);
            long f = i().f(j);
            this.a.a(f, "resulting");
            return f;
        }

        public long g(long j) {
            this.a.a(j, null);
            long g = i().g(j);
            this.a.a(g, "resulting");
            return g;
        }

        public long h(long j) {
            this.a.a(j, null);
            long h = i().h(j);
            this.a.a(h, "resulting");
            return h;
        }

        public long i(long j) {
            this.a.a(j, null);
            long i = i().i(j);
            this.a.a(i, "resulting");
            return i;
        }

        public int c(long j) {
            this.a.a(j, null);
            return i().c(j);
        }

        public int a(Locale locale) {
            return i().a(locale);
        }
    }

    private class b extends e {
        final /* synthetic */ x a;

        b(x xVar, g gVar) {
            this.a = xVar;
            super(gVar, gVar.a());
        }

        public long a(long j, int i) {
            this.a.a(j, null);
            long a = f().a(j, i);
            this.a.a(a, "resulting");
            return a;
        }

        public long a(long j, long j2) {
            this.a.a(j, null);
            long a = f().a(j, j2);
            this.a.a(a, "resulting");
            return a;
        }
    }

    private class c extends IllegalArgumentException {
        final /* synthetic */ x a;
        private final boolean b;

        c(x xVar, String str, boolean z) {
            this.a = xVar;
            super(str);
            this.b = z;
        }

        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer(85);
            stringBuffer.append("The");
            String message = super.getMessage();
            if (message != null) {
                stringBuffer.append(' ');
                stringBuffer.append(message);
            }
            stringBuffer.append(" instant is ");
            c.b.a.e.b a = j.c().a(this.a.L());
            if (this.b) {
                stringBuffer.append("below the supported minimum of ");
                a.a(stringBuffer, this.a.N().c());
            } else {
                stringBuffer.append("above the supported maximum of ");
                a.a(stringBuffer, this.a.O().c());
            }
            stringBuffer.append(" (");
            stringBuffer.append(this.a.L());
            stringBuffer.append(')');
            return stringBuffer.toString();
        }

        public String toString() {
            return "IllegalArgumentException: " + getMessage();
        }
    }

    public static x a(c.b.a.a aVar, q qVar, q qVar2) {
        s sVar = null;
        if (aVar == null) {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        q b = qVar == null ? null : qVar.b();
        if (qVar2 != null) {
            sVar = qVar2.b();
        }
        if (b == null || sVar == null || b.a(sVar)) {
            return new x(aVar, (c.b.a.b) b, (c.b.a.b) sVar);
        }
        throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
    }

    private x(c.b.a.a aVar, c.b.a.b bVar, c.b.a.b bVar2) {
        super(aVar, null);
        this.a = bVar;
        this.b = bVar2;
    }

    public c.b.a.b N() {
        return this.a;
    }

    public c.b.a.b O() {
        return this.b;
    }

    public c.b.a.a b() {
        return a(f.a);
    }

    public c.b.a.a a(f fVar) {
        if (fVar == null) {
            fVar = f.a();
        }
        if (fVar == a()) {
            return this;
        }
        if (fVar == f.a && this.c != null) {
            return this.c;
        }
        q qVar = this.a;
        if (qVar != null) {
            n e = qVar.e();
            e.b(fVar);
            qVar = e.b();
        }
        q qVar2 = this.b;
        if (qVar2 != null) {
            n e2 = qVar2.e();
            e2.b(fVar);
            qVar2 = e2.b();
        }
        c.b.a.a a = a(L().a(fVar), qVar, qVar2);
        if (fVar == f.a) {
            this.c = a;
        }
        return a;
    }

    public long a(int i, int i2, int i3, int i4) {
        long a = L().a(i, i2, i3, i4);
        a(a, "resulting");
        return a;
    }

    public long a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        long a = L().a(i, i2, i3, i4, i5, i6, i7);
        a(a, "resulting");
        return a;
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
        g bVar = new b(this, gVar);
        hashMap.put(gVar, bVar);
        return bVar;
    }

    private c.b.a.c a(c.b.a.c cVar, HashMap<Object, Object> hashMap) {
        if (cVar == null || !cVar.c()) {
            return cVar;
        }
        if (hashMap.containsKey(cVar)) {
            return (c.b.a.c) hashMap.get(cVar);
        }
        c.b.a.c aVar = new a(this, cVar, a(cVar.d(), (HashMap) hashMap), a(cVar.e(), (HashMap) hashMap), a(cVar.f(), (HashMap) hashMap));
        hashMap.put(cVar, aVar);
        return aVar;
    }

    void a(long j, String str) {
        c.b.a.b bVar = this.a;
        if (bVar == null || j >= bVar.c()) {
            bVar = this.b;
            if (bVar != null && j >= bVar.c()) {
                throw new c(this, str, false);
            }
            return;
        }
        throw new c(this, str, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (L().equals(xVar.L()) && h.a(N(), xVar.N()) && h.a(O(), xVar.O())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (N() != null) {
            hashCode = N().hashCode();
        } else {
            hashCode = 0;
        }
        hashCode += 317351877;
        if (O() != null) {
            i = O().hashCode();
        }
        return (hashCode + i) + (L().hashCode() * 7);
    }

    public String toString() {
        return "LimitChronology[" + L().toString() + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + (N() == null ? "NoLimit" : N().toString()) + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + (O() == null ? "NoLimit" : O().toString()) + ']';
    }
}
