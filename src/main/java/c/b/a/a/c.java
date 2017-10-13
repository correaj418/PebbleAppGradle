package c.b.a.a;

import c.b.a.a;
import c.b.a.d;
import c.b.a.d.h;
import c.b.a.u;

public abstract class c implements u, Comparable<u> {
    protected abstract c.b.a.c a(int i, a aVar);

    public /* synthetic */ int compareTo(Object obj) {
        return a((u) obj);
    }

    protected c() {
    }

    public d b(int i) {
        return a(i, c()).a();
    }

    public int a(d dVar) {
        return a(d(dVar));
    }

    public boolean b(d dVar) {
        return c(dVar) != -1;
    }

    public int c(d dVar) {
        int a = a();
        for (int i = 0; i < a; i++) {
            if (b(i) == dVar) {
                return i;
            }
        }
        return -1;
    }

    protected int d(d dVar) {
        int c = c(dVar);
        if (c != -1) {
            return c;
        }
        throw new IllegalArgumentException("Field '" + dVar + "' is not supported");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (a() != uVar.a()) {
            return false;
        }
        int a = a();
        int i = 0;
        while (i < a) {
            if (a(i) != uVar.a(i) || b(i) != uVar.b(i)) {
                return false;
            }
            i++;
        }
        return h.a(c(), uVar.c());
    }

    public int hashCode() {
        int i = 157;
        for (int i2 = 0; i2 < a(); i2++) {
            i = (((i * 23) + a(i2)) * 23) + b(i2).hashCode();
        }
        return c().hashCode() + i;
    }

    public int a(u uVar) {
        if (this == uVar) {
            return 0;
        }
        if (a() != uVar.a()) {
            throw new ClassCastException("ReadablePartial objects must have matching field types");
        }
        int i;
        int a = a();
        for (i = 0; i < a; i++) {
            if (b(i) != uVar.b(i)) {
                throw new ClassCastException("ReadablePartial objects must have matching field types");
            }
        }
        a = a();
        for (i = 0; i < a; i++) {
            if (a(i) > uVar.a(i)) {
                return 1;
            }
            if (a(i) < uVar.a(i)) {
                return -1;
            }
        }
        return 0;
    }
}
