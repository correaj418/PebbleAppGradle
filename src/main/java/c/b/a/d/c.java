package c.b.a.d;

import c.b.a.g;
import c.b.a.h;
import java.io.Serializable;

public abstract class c extends g implements Serializable {
    private final h a;

    public /* synthetic */ int compareTo(Object obj) {
        return a((g) obj);
    }

    protected c(h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        this.a = hVar;
    }

    public final h a() {
        return this.a;
    }

    public final String e() {
        return this.a.m();
    }

    public final boolean b() {
        return true;
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

    public String toString() {
        return "DurationField[" + e() + ']';
    }
}
