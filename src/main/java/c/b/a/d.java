package c.b.a;

import java.io.Serializable;

public abstract class d implements Serializable {
    private static final d a = new a("era", (byte) 1, h.l(), null);
    private static final d b = new a("yearOfEra", (byte) 2, h.j(), h.l());
    private static final d c = new a("centuryOfEra", (byte) 3, h.k(), h.l());
    private static final d d = new a("yearOfCentury", (byte) 4, h.j(), h.k());
    private static final d e = new a("year", (byte) 5, h.j(), null);
    private static final d f = new a("dayOfYear", (byte) 6, h.f(), h.j());
    private static final d g = new a("monthOfYear", (byte) 7, h.i(), h.j());
    private static final d h = new a("dayOfMonth", (byte) 8, h.f(), h.i());
    private static final d i = new a("weekyearOfCentury", (byte) 9, h.h(), h.k());
    private static final d j = new a("weekyear", (byte) 10, h.h(), null);
    private static final d k = new a("weekOfWeekyear", (byte) 11, h.g(), h.h());
    private static final d l = new a("dayOfWeek", (byte) 12, h.f(), h.g());
    private static final d m = new a("halfdayOfDay", (byte) 13, h.e(), h.f());
    private static final d n = new a("hourOfHalfday", (byte) 14, h.d(), h.e());
    private static final d o = new a("clockhourOfHalfday", (byte) 15, h.d(), h.e());
    private static final d p = new a("clockhourOfDay", (byte) 16, h.d(), h.f());
    private static final d q = new a("hourOfDay", (byte) 17, h.d(), h.f());
    private static final d r = new a("minuteOfDay", (byte) 18, h.c(), h.f());
    private static final d s = new a("minuteOfHour", (byte) 19, h.c(), h.d());
    private static final d t = new a("secondOfDay", (byte) 20, h.b(), h.f());
    private static final d u = new a("secondOfMinute", (byte) 21, h.b(), h.c());
    private static final d v = new a("millisOfDay", (byte) 22, h.a(), h.f());
    private static final d w = new a("millisOfSecond", (byte) 23, h.a(), h.b());
    private final String x;

    private static class a extends d {
        private final byte a;
        private final transient h b;
        private final transient h c;

        a(String str, byte b, h hVar, h hVar2) {
            super(str);
            this.a = b;
            this.b = hVar;
            this.c = hVar2;
        }

        public h y() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            if (this.a != ((a) obj).a) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1 << this.a;
        }

        public c a(a aVar) {
            a a = e.a(aVar);
            switch (this.a) {
                case (byte) 1:
                    return a.K();
                case (byte) 2:
                    return a.F();
                case (byte) 3:
                    return a.I();
                case (byte) 4:
                    return a.G();
                case (byte) 5:
                    return a.E();
                case (byte) 6:
                    return a.v();
                case (byte) 7:
                    return a.C();
                case (byte) 8:
                    return a.u();
                case (byte) 9:
                    return a.A();
                case (byte) 10:
                    return a.z();
                case (byte) 11:
                    return a.x();
                case (byte) 12:
                    return a.t();
                case (byte) 13:
                    return a.r();
                case (byte) 14:
                    return a.p();
                case (byte) 15:
                    return a.q();
                case (byte) 16:
                    return a.n();
                case (byte) 17:
                    return a.m();
                case (byte) 18:
                    return a.k();
                case (byte) 19:
                    return a.j();
                case (byte) 20:
                    return a.h();
                case (byte) 21:
                    return a.g();
                case (byte) 22:
                    return a.e();
                case (byte) 23:
                    return a.d();
                default:
                    throw new InternalError();
            }
        }
    }

    public abstract c a(a aVar);

    public abstract h y();

    protected d(String str) {
        this.x = str;
    }

    public static d a() {
        return w;
    }

    public static d b() {
        return v;
    }

    public static d c() {
        return u;
    }

    public static d d() {
        return t;
    }

    public static d e() {
        return s;
    }

    public static d f() {
        return r;
    }

    public static d g() {
        return q;
    }

    public static d h() {
        return p;
    }

    public static d i() {
        return n;
    }

    public static d j() {
        return o;
    }

    public static d k() {
        return m;
    }

    public static d l() {
        return l;
    }

    public static d m() {
        return h;
    }

    public static d n() {
        return f;
    }

    public static d o() {
        return k;
    }

    public static d p() {
        return j;
    }

    public static d q() {
        return i;
    }

    public static d r() {
        return g;
    }

    public static d s() {
        return e;
    }

    public static d t() {
        return b;
    }

    public static d u() {
        return d;
    }

    public static d v() {
        return c;
    }

    public static d w() {
        return a;
    }

    public String x() {
        return this.x;
    }

    public String toString() {
        return x();
    }
}
