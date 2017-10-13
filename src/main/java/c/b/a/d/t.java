package c.b.a.d;

import c.b.a.g;
import c.b.a.h;
import java.io.Serializable;
import java.util.HashMap;

public final class t extends g implements Serializable {
    private static HashMap<h, t> a;
    private final h b;

    public /* synthetic */ int compareTo(Object obj) {
        return a((g) obj);
    }

    public static synchronized t a(h hVar) {
        t tVar;
        synchronized (t.class) {
            if (a == null) {
                a = new HashMap(7);
                tVar = null;
            } else {
                tVar = (t) a.get(hVar);
            }
            if (tVar == null) {
                tVar = new t(hVar);
                a.put(hVar, tVar);
            }
        }
        return tVar;
    }

    private t(h hVar) {
        this.b = hVar;
    }

    public final h a() {
        return this.b;
    }

    public String e() {
        return this.b.m();
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    public long a(long j, int i) {
        throw f();
    }

    public long a(long j, long j2) {
        throw f();
    }

    public long d() {
        return 0;
    }

    public int a(g gVar) {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (tVar.e() != null) {
            return tVar.e().equals(e());
        }
        if (e() != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return "UnsupportedDurationField[" + e() + ']';
    }

    private UnsupportedOperationException f() {
        return new UnsupportedOperationException(this.b + " field is unsupported");
    }
}
