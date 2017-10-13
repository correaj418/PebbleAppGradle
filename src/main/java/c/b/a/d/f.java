package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.g;
import c.b.a.u;
import java.io.Serializable;
import java.util.Locale;

public class f extends c implements Serializable {
    private final c a;
    private final g b;
    private final d c;

    public f(c cVar) {
        this(cVar, null);
    }

    public f(c cVar, d dVar) {
        this(cVar, null, dVar);
    }

    public f(c cVar, g gVar, d dVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        this.a = cVar;
        this.b = gVar;
        if (dVar == null) {
            dVar = cVar.a();
        }
        this.c = dVar;
    }

    public d a() {
        return this.c;
    }

    public String b() {
        return this.c.x();
    }

    public boolean c() {
        return this.a.c();
    }

    public int a(long j) {
        return this.a.a(j);
    }

    public String a(long j, Locale locale) {
        return this.a.a(j, locale);
    }

    public String a(u uVar, Locale locale) {
        return this.a.a(uVar, locale);
    }

    public String a(int i, Locale locale) {
        return this.a.a(i, locale);
    }

    public String b(long j, Locale locale) {
        return this.a.b(j, locale);
    }

    public String b(u uVar, Locale locale) {
        return this.a.b(uVar, locale);
    }

    public String b(int i, Locale locale) {
        return this.a.b(i, locale);
    }

    public long a(long j, int i) {
        return this.a.a(j, i);
    }

    public long a(long j, long j2) {
        return this.a.a(j, j2);
    }

    public long b(long j, int i) {
        return this.a.b(j, i);
    }

    public long a(long j, String str, Locale locale) {
        return this.a.a(j, str, locale);
    }

    public g d() {
        return this.a.d();
    }

    public g e() {
        if (this.b != null) {
            return this.b;
        }
        return this.a.e();
    }

    public boolean b(long j) {
        return this.a.b(j);
    }

    public g f() {
        return this.a.f();
    }

    public int g() {
        return this.a.g();
    }

    public int h() {
        return this.a.h();
    }

    public int c(long j) {
        return this.a.c(j);
    }

    public int a(Locale locale) {
        return this.a.a(locale);
    }

    public long d(long j) {
        return this.a.d(j);
    }

    public long e(long j) {
        return this.a.e(j);
    }

    public long f(long j) {
        return this.a.f(j);
    }

    public long g(long j) {
        return this.a.g(j);
    }

    public long h(long j) {
        return this.a.h(j);
    }

    public long i(long j) {
        return this.a.i(j);
    }

    public String toString() {
        return "DateTimeField[" + b() + ']';
    }
}
