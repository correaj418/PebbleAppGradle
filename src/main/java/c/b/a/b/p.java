package c.b.a.b;

import c.b.a.c;
import c.b.a.d;
import c.b.a.d.b;
import c.b.a.d.h;
import c.b.a.d.t;
import c.b.a.g;
import java.util.Locale;

final class p extends b {
    private final c a;

    p(c cVar) {
        super(d.w());
        this.a = cVar;
    }

    public int a(long j) {
        if (this.a.a(j) <= 0) {
            return 0;
        }
        return 1;
    }

    public String a(int i, Locale locale) {
        return q.a(locale).a(i);
    }

    public long b(long j, int i) {
        h.a((c) this, i, 0, 1);
        if (a(j) == i) {
            return j;
        }
        return this.a.f(j, -this.a.a(j));
    }

    public long a(long j, String str, Locale locale) {
        return b(j, q.a(locale).a(str));
    }

    public long d(long j) {
        if (a(j) == 1) {
            return this.a.f(0, 1);
        }
        return Long.MIN_VALUE;
    }

    public long e(long j) {
        if (a(j) == 0) {
            return this.a.f(0, 1);
        }
        return Long.MAX_VALUE;
    }

    public long f(long j) {
        return d(j);
    }

    public long g(long j) {
        return d(j);
    }

    public long h(long j) {
        return d(j);
    }

    public g d() {
        return t.a(c.b.a.h.l());
    }

    public g e() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return 1;
    }

    public int a(Locale locale) {
        return q.a(locale).a();
    }
}
