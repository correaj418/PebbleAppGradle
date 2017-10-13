package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import java.io.Serializable;
import java.util.Locale;

public abstract class a implements Serializable {
    public abstract c a();

    protected abstract long b();

    public d d() {
        return a().a();
    }

    public String e() {
        return a().b();
    }

    protected c.b.a.a c() {
        throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
    }

    public int f() {
        return a().a(b());
    }

    public String a(Locale locale) {
        return a().a(b(), locale);
    }

    public String b(Locale locale) {
        return a().b(b(), locale);
    }

    public int g() {
        return a().g();
    }

    public int h() {
        return a().h();
    }

    public int c(Locale locale) {
        return a().a(locale);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (f() == aVar.f() && d().equals(aVar.d()) && h.a(c(), aVar.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((f() * 17) + d().hashCode()) + c().hashCode();
    }

    public String toString() {
        return "Property[" + e() + "]";
    }
}
