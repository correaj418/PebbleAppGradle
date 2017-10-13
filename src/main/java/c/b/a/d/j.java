package c.b.a.d;

import c.b.a.g;
import c.b.a.h;
import java.io.Serializable;

public final class j extends g implements Serializable {
    public static final g a = new j();

    public /* synthetic */ int compareTo(Object obj) {
        return a((g) obj);
    }

    private j() {
    }

    public h a() {
        return h.a();
    }

    public boolean b() {
        return true;
    }

    public final boolean c() {
        return true;
    }

    public final long d() {
        return 1;
    }

    public long a(long j, int i) {
        return h.a(j, (long) i);
    }

    public long a(long j, long j2) {
        return h.a(j, j2);
    }

    public int a(g gVar) {
        long d = gVar.d();
        long d2 = d();
        if (d2 == d) {
            return 0;
        }
        if (d2 < d) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof j) && d() == ((j) obj).d()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) d();
    }

    public String toString() {
        return "DurationField[millis]";
    }
}
