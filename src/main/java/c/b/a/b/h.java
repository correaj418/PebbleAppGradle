package c.b.a.b;

import c.b.a.c;
import c.b.a.d;
import c.b.a.d.b;
import c.b.a.d.t;
import c.b.a.g;
import c.b.a.i;
import java.util.Locale;

final class h extends b {
    private final String a;

    h(String str) {
        super(d.w());
        this.a = str;
    }

    public int a(long j) {
        return 1;
    }

    public long b(long j, int i) {
        c.b.a.d.h.a((c) this, i, 1, 1);
        return j;
    }

    public long a(long j, String str, Locale locale) {
        if (this.a.equals(str) || "1".equals(str)) {
            return j;
        }
        throw new i(d.w(), str);
    }

    public long d(long j) {
        return Long.MIN_VALUE;
    }

    public long e(long j) {
        return Long.MAX_VALUE;
    }

    public long f(long j) {
        return Long.MIN_VALUE;
    }

    public long g(long j) {
        return Long.MIN_VALUE;
    }

    public long h(long j) {
        return Long.MIN_VALUE;
    }

    public g d() {
        return t.a(c.b.a.h.l());
    }

    public g e() {
        return null;
    }

    public int g() {
        return 1;
    }

    public int h() {
        return 1;
    }

    public String a(int i, Locale locale) {
        return this.a;
    }

    public int a(Locale locale) {
        return this.a.length();
    }
}
