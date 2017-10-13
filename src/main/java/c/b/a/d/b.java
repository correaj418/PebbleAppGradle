package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.g;
import c.b.a.i;
import c.b.a.u;
import java.util.Locale;

public abstract class b extends c {
    private final d a;

    public abstract int a(long j);

    public abstract long b(long j, int i);

    public abstract long d(long j);

    public abstract g d();

    public abstract int h();

    protected b(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        this.a = dVar;
    }

    public final d a() {
        return this.a;
    }

    public final String b() {
        return this.a.x();
    }

    public final boolean c() {
        return true;
    }

    public String a(long j, Locale locale) {
        return a(a(j), locale);
    }

    public String a(u uVar, int i, Locale locale) {
        return a(i, locale);
    }

    public final String a(u uVar, Locale locale) {
        return a(uVar, uVar.a(a()), locale);
    }

    public String a(int i, Locale locale) {
        return Integer.toString(i);
    }

    public String b(long j, Locale locale) {
        return b(a(j), locale);
    }

    public String b(u uVar, int i, Locale locale) {
        return b(i, locale);
    }

    public final String b(u uVar, Locale locale) {
        return b(uVar, uVar.a(a()), locale);
    }

    public String b(int i, Locale locale) {
        return a(i, locale);
    }

    public long a(long j, int i) {
        return d().a(j, i);
    }

    public long a(long j, long j2) {
        return d().a(j, j2);
    }

    public long a(long j, String str, Locale locale) {
        return b(j, a(str, locale));
    }

    protected int a(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new i(a(), str);
        }
    }

    public boolean b(long j) {
        return false;
    }

    public g f() {
        return null;
    }

    public int c(long j) {
        return h();
    }

    public int a(Locale locale) {
        int h = h();
        if (h >= 0) {
            if (h < 10) {
                return 1;
            }
            if (h < 100) {
                return 2;
            }
            if (h < 1000) {
                return 3;
            }
        }
        return Integer.toString(h).length();
    }

    public long e(long j) {
        long d = d(j);
        if (d != j) {
            return a(d, 1);
        }
        return j;
    }

    public long f(long j) {
        long d = d(j);
        long e = e(j);
        return j - d <= e - j ? d : e;
    }

    public long g(long j) {
        long d = d(j);
        long e = e(j);
        return e - j <= j - d ? e : d;
    }

    public long h(long j) {
        long d = d(j);
        long e = e(j);
        long j2 = j - d;
        long j3 = e - j;
        if (j2 < j3) {
            return d;
        }
        if (j3 < j2) {
            return e;
        }
        if ((a(e) & 1) == 0) {
            return e;
        }
        return d;
    }

    public long i(long j) {
        return j - d(j);
    }

    public String toString() {
        return "DateTimeField[" + b() + ']';
    }
}
