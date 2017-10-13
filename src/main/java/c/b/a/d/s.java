package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.g;
import c.b.a.u;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

public final class s extends c implements Serializable {
    private static HashMap<d, s> a;
    private final d b;
    private final g c;

    public static synchronized s a(d dVar, g gVar) {
        s sVar;
        synchronized (s.class) {
            if (a == null) {
                a = new HashMap(7);
                sVar = null;
            } else {
                sVar = (s) a.get(dVar);
                if (!(sVar == null || sVar.d() == gVar)) {
                    sVar = null;
                }
            }
            if (sVar == null) {
                sVar = new s(dVar, gVar);
                a.put(dVar, sVar);
            }
        }
        return sVar;
    }

    private s(d dVar, g gVar) {
        if (dVar == null || gVar == null) {
            throw new IllegalArgumentException();
        }
        this.b = dVar;
        this.c = gVar;
    }

    public d a() {
        return this.b;
    }

    public String b() {
        return this.b.x();
    }

    public boolean c() {
        return false;
    }

    public int a(long j) {
        throw i();
    }

    public String a(long j, Locale locale) {
        throw i();
    }

    public String a(u uVar, Locale locale) {
        throw i();
    }

    public String a(int i, Locale locale) {
        throw i();
    }

    public String b(long j, Locale locale) {
        throw i();
    }

    public String b(u uVar, Locale locale) {
        throw i();
    }

    public String b(int i, Locale locale) {
        throw i();
    }

    public long a(long j, int i) {
        return d().a(j, i);
    }

    public long a(long j, long j2) {
        return d().a(j, j2);
    }

    public long b(long j, int i) {
        throw i();
    }

    public long a(long j, String str, Locale locale) {
        throw i();
    }

    public g d() {
        return this.c;
    }

    public g e() {
        return null;
    }

    public boolean b(long j) {
        throw i();
    }

    public g f() {
        return null;
    }

    public int g() {
        throw i();
    }

    public int h() {
        throw i();
    }

    public int c(long j) {
        throw i();
    }

    public int a(Locale locale) {
        throw i();
    }

    public long d(long j) {
        throw i();
    }

    public long e(long j) {
        throw i();
    }

    public long f(long j) {
        throw i();
    }

    public long g(long j) {
        throw i();
    }

    public long h(long j) {
        throw i();
    }

    public long i(long j) {
        throw i();
    }

    public String toString() {
        return "UnsupportedDateTimeField";
    }

    private UnsupportedOperationException i() {
        return new UnsupportedOperationException(this.b + " field is unsupported");
    }
}
