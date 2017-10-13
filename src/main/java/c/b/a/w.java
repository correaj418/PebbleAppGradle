package c.b.a;

import java.util.SimpleTimeZone;
import java.util.TimeZone;

final class w extends f {
    static final f b = new w();

    public w() {
        super("UTC");
    }

    public String a(long j) {
        return "UTC";
    }

    public int b(long j) {
        return 0;
    }

    public int c(long j) {
        return 0;
    }

    public int e(long j) {
        return 0;
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
        return new SimpleTimeZone(0, e());
    }

    public boolean equals(Object obj) {
        return obj instanceof w;
    }

    public int hashCode() {
        return e().hashCode();
    }
}
