package c.b.a;

import java.io.Serializable;

public abstract class h implements Serializable {
    static final h a = new a("eras", (byte) 1);
    static final h b = new a("centuries", (byte) 2);
    static final h c = new a("weekyears", (byte) 3);
    static final h d = new a("years", (byte) 4);
    static final h e = new a("months", (byte) 5);
    static final h f = new a("weeks", (byte) 6);
    static final h g = new a("days", (byte) 7);
    static final h h = new a("halfdays", (byte) 8);
    static final h i = new a("hours", (byte) 9);
    static final h j = new a("minutes", (byte) 10);
    static final h k = new a("seconds", (byte) 11);
    static final h l = new a("millis", (byte) 12);
    private final String m;

    private static class a extends h {
        private final byte m;

        a(String str, byte b) {
            super(str);
            this.m = b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            if (this.m != ((a) obj).m) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1 << this.m;
        }

        public g a(a aVar) {
            a a = e.a(aVar);
            switch (this.m) {
                case (byte) 1:
                    return a.J();
                case (byte) 2:
                    return a.H();
                case (byte) 3:
                    return a.y();
                case (byte) 4:
                    return a.D();
                case (byte) 5:
                    return a.B();
                case (byte) 6:
                    return a.w();
                case (byte) 7:
                    return a.s();
                case (byte) 8:
                    return a.o();
                case (byte) 9:
                    return a.l();
                case (byte) 10:
                    return a.i();
                case (byte) 11:
                    return a.f();
                case (byte) 12:
                    return a.c();
                default:
                    throw new InternalError();
            }
        }
    }

    public abstract g a(a aVar);

    protected h(String str) {
        this.m = str;
    }

    public static h a() {
        return l;
    }

    public static h b() {
        return k;
    }

    public static h c() {
        return j;
    }

    public static h d() {
        return i;
    }

    public static h e() {
        return h;
    }

    public static h f() {
        return g;
    }

    public static h g() {
        return f;
    }

    public static h h() {
        return c;
    }

    public static h i() {
        return e;
    }

    public static h j() {
        return d;
    }

    public static h k() {
        return b;
    }

    public static h l() {
        return a;
    }

    public String m() {
        return this.m;
    }

    public String toString() {
        return m();
    }
}
