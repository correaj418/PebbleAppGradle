package c.b.a.f;

import c.b.a.f;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public final class d extends f {
    private final String b;
    private final int c;
    private final int d;

    public d(String str, String str2, int i, int i2) {
        super(str);
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    public String a(long j) {
        return this.b;
    }

    public int b(long j) {
        return this.c;
    }

    public int c(long j) {
        return this.d;
    }

    public int e(long j) {
        return this.c;
    }

    public boolean f() {
        return true;
    }

    public long g(long j) {
        return j;
    }

    public long h(long j) {
        return j;
    }

    public TimeZone g() {
        String e = e();
        if (e.length() == 6 && (e.startsWith("+") || e.startsWith("-"))) {
            return TimeZone.getTimeZone("GMT" + e());
        }
        return new SimpleTimeZone(this.c, e());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (e().equals(dVar.e()) && this.d == dVar.d && this.c == dVar.c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (e().hashCode() + (this.d * 37)) + (this.c * 31);
    }
}
