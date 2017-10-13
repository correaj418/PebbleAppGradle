package c.b.a.b;

import c.b.a.d;
import c.b.a.d.j;
import c.b.a.d.k;
import c.b.a.d.l;
import c.b.a.d.n;
import c.b.a.d.o;
import c.b.a.d.u;
import c.b.a.f;
import c.b.a.g;
import c.b.a.h;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels;
import java.util.Locale;

abstract class c extends a {
    private static final g a = j.a;
    private static final g b = new n(h.b(), 1000);
    private static final g c = new n(h.c(), 60000);
    private static final g d = new n(h.d(), 3600000);
    private static final g e = new n(h.e(), 43200000);
    private static final g f = new n(h.f(), 86400000);
    private static final g g = new n(h.g(), 604800000);
    private static final c.b.a.c h = new l(d.a(), a, b);
    private static final c.b.a.c i = new l(d.b(), a, f);
    private static final c.b.a.c j = new l(d.c(), b, c);
    private static final c.b.a.c k = new l(d.d(), b, f);
    private static final c.b.a.c l = new l(d.e(), c, d);
    private static final c.b.a.c m = new l(d.f(), c, f);
    private static final c.b.a.c n = new l(d.g(), d, f);
    private static final c.b.a.c o = new l(d.i(), d, e);
    private static final c.b.a.c p = new u(n, d.h());
    private static final c.b.a.c q = new u(o, d.j());
    private static final c.b.a.c r = new a();
    private final transient b[] s = new b[1024];
    private final int t;

    private static class a extends l {
        a() {
            super(d.k(), c.e, c.f);
        }

        public String a(int i, Locale locale) {
            return q.a(locale).f(i);
        }

        public long a(long j, String str, Locale locale) {
            return b(j, q.a(locale).d(str));
        }

        public int a(Locale locale) {
            return q.a(locale).d();
        }
    }

    private static class b {
        public final int a;
        public final long b;

        b(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    abstract int Q();

    abstract int R();

    abstract long T();

    abstract long U();

    abstract long V();

    abstract long W();

    abstract int a(long j, int i);

    abstract int b(int i, int i2);

    abstract long c(int i, int i2);

    abstract boolean e(int i);

    abstract long f(int i);

    abstract long f(long j, int i);

    c(c.b.a.a aVar, Object obj, int i) {
        super(aVar, obj);
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
        this.t = i;
    }

    public f a() {
        c.b.a.a L = L();
        if (L != null) {
            return L.a();
        }
        return f.a;
    }

    public long a(int i, int i2, int i3, int i4) {
        c.b.a.a L = L();
        if (L != null) {
            return L.a(i, i2, i3, i4);
        }
        c.b.a.d.h.a(d.b(), i4, 0, 86399999);
        return b(i, i2, i3, i4);
    }

    public long a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        c.b.a.a L = L();
        if (L != null) {
            return L.a(i, i2, i3, i4, i5, i6, i7);
        }
        c.b.a.d.h.a(d.g(), i4, 0, 23);
        c.b.a.d.h.a(d.e(), i5, 0, 59);
        c.b.a.d.h.a(d.c(), i6, 0, 59);
        c.b.a.d.h.a(d.a(), i7, 0, 999);
        return b(i, i2, i3, (int) ((long) ((((3600000 * i4) + (WeatherChannelDataModels.MS_TO_MIN_DIVISOR * i5)) + (i6 * 1000)) + i7)));
    }

    private long b(int i, int i2, int i3, int i4) {
        long b;
        long b2 = b(i, i2, i3);
        if (b2 == Long.MIN_VALUE) {
            i4 -= 86400000;
            b = b(i, i2, i3 + 1);
        } else {
            b = b2;
        }
        b2 = ((long) i4) + b;
        if (b2 < 0 && b > 0) {
            return Long.MAX_VALUE;
        }
        if (b2 <= 0 || b >= 0) {
            return b2;
        }
        return Long.MIN_VALUE;
    }

    public int N() {
        return this.t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (N() == cVar.N() && a().equals(cVar.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((getClass().getName().hashCode() * 11) + a().hashCode()) + N();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(60);
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        stringBuilder.append(name);
        stringBuilder.append('[');
        f a = a();
        if (a != null) {
            stringBuilder.append(a.e());
        }
        if (N() != 4) {
            stringBuilder.append(",mdfw=");
            stringBuilder.append(N());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    protected void a(c.b.a.b.a.a aVar) {
        aVar.a = a;
        aVar.b = b;
        aVar.c = c;
        aVar.d = d;
        aVar.e = e;
        aVar.f = f;
        aVar.g = g;
        aVar.m = h;
        aVar.n = i;
        aVar.o = j;
        aVar.p = k;
        aVar.q = l;
        aVar.r = m;
        aVar.s = n;
        aVar.u = o;
        aVar.t = p;
        aVar.v = q;
        aVar.w = r;
        aVar.E = new k(this);
        aVar.F = new s(aVar.E, this);
        aVar.H = new c.b.a.d.g(new k(aVar.F, 99), d.v(), 100);
        aVar.k = aVar.H.d();
        aVar.G = new k(new o((c.b.a.d.g) aVar.H), d.u(), 1);
        aVar.I = new p(this);
        aVar.x = new o(this, aVar.f);
        aVar.y = new d(this, aVar.f);
        aVar.z = new e(this, aVar.f);
        aVar.D = new r(this);
        aVar.B = new j(this);
        aVar.A = new i(this, aVar.g);
        aVar.C = new k(new o(aVar.B, aVar.k, d.q(), 100), d.q(), 1);
        aVar.j = aVar.E.d();
        aVar.i = aVar.D.d();
        aVar.h = aVar.B.d();
    }

    int O() {
        return 366;
    }

    int a(int i) {
        return e(i) ? 366 : 365;
    }

    int b(int i) {
        return (int) ((c(i + 1) - c(i)) / 604800000);
    }

    long c(int i) {
        long d = d(i);
        int g = g(d);
        if (g > 8 - this.t) {
            return d + (((long) (8 - g)) * 86400000);
        }
        return d - (((long) (g - 1)) * 86400000);
    }

    long d(int i) {
        return h(i).b;
    }

    long a(int i, int i2) {
        return d(i) + c(i, i2);
    }

    long a(int i, int i2, int i3) {
        return (d(i) + c(i, i2)) + (((long) (i3 - 1)) * 86400000);
    }

    int a(long j) {
        long j2 = 31536000000L;
        long U = U();
        long W = (j >> 1) + W();
        if (W < 0) {
            W = (W - U) + 1;
        }
        int i = (int) (W / U);
        U = d(i);
        long j3 = j - U;
        if (j3 < 0) {
            return i - 1;
        }
        if (j3 < 31536000000L) {
            return i;
        }
        if (e(i)) {
            j2 = 31622400000L;
        }
        if (j2 + U <= j) {
            return i + 1;
        }
        return i;
    }

    int b(long j) {
        return a(j, a(j));
    }

    int c(long j) {
        int a = a(j);
        return a(j, a, a(j, a));
    }

    int b(long j, int i) {
        return a(j, i, a(j, i));
    }

    int a(long j, int i, int i2) {
        return ((int) ((j - (d(i) + c(i, i2))) / 86400000)) + 1;
    }

    int d(long j) {
        return c(j, a(j));
    }

    int c(long j, int i) {
        return ((int) ((j - d(i)) / 86400000)) + 1;
    }

    int e(long j) {
        int a = a(j);
        int d = d(j, a);
        if (d == 1) {
            return a(604800000 + j);
        }
        if (d > 51) {
            return a(j - 1209600000);
        }
        return a;
    }

    int f(long j) {
        return d(j, a(j));
    }

    int d(long j, int i) {
        long c = c(i);
        if (j < c) {
            return b(i - 1);
        }
        if (j >= c(i + 1)) {
            return 1;
        }
        return ((int) ((j - c) / 604800000)) + 1;
    }

    int g(long j) {
        long j2;
        if (j >= 0) {
            j2 = j / 86400000;
        } else {
            j2 = (j - 86399999) / 86400000;
            if (j2 < -3) {
                return ((int) ((j2 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j2 + 3) % 7)) + 1;
    }

    int h(long j) {
        if (j >= 0) {
            return (int) (j % 86400000);
        }
        return 86399999 + ((int) ((1 + j) % 86400000));
    }

    int P() {
        return 31;
    }

    int i(long j) {
        int a = a(j);
        return b(a, a(j, a));
    }

    int e(long j, int i) {
        return i(j);
    }

    long b(int i, int i2, int i3) {
        c.b.a.d.h.a(d.s(), i, Q() - 1, R() + 1);
        c.b.a.d.h.a(d.r(), i2, 1, g(i));
        c.b.a.d.h.a(d.m(), i3, 1, b(i, i2));
        long a = a(i, i2, i3);
        if (a < 0 && i == R() + 1) {
            return Long.MAX_VALUE;
        }
        if (a <= 0 || i != Q() - 1) {
            return a;
        }
        return Long.MIN_VALUE;
    }

    boolean j(long j) {
        return false;
    }

    int g(int i) {
        return S();
    }

    int S() {
        return 12;
    }

    private b h(int i) {
        b bVar = this.s[i & 1023];
        if (bVar != null && bVar.a == i) {
            return bVar;
        }
        bVar = new b(i, f(i));
        this.s[i & 1023] = bVar;
        return bVar;
    }
}
