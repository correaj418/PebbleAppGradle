package c.b.a.b;

import c.b.a.d;
import c.b.a.d.m;
import c.b.a.g;
import java.util.Locale;

final class o extends m {
    private final c b;

    o(c cVar, g gVar) {
        super(d.l(), gVar);
        this.b = cVar;
    }

    public int a(long j) {
        return this.b.g(j);
    }

    public String a(int i, Locale locale) {
        return q.a(locale).d(i);
    }

    public String b(int i, Locale locale) {
        return q.a(locale).e(i);
    }

    protected int a(String str, Locale locale) {
        return q.a(locale).c(str);
    }

    public g e() {
        return this.b.w();
    }

    public int g() {
        return 1;
    }

    public int h() {
        return 7;
    }

    public int a(Locale locale) {
        return q.a(locale).c();
    }
}
