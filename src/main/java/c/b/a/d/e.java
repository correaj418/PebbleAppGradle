package c.b.a.d;

import c.b.a.g;
import c.b.a.h;

public class e extends c {
    private final g a;

    public e(g gVar, h hVar) {
        super(hVar);
        if (gVar == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (gVar.b()) {
            this.a = gVar;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public final g f() {
        return this.a;
    }

    public boolean c() {
        return this.a.c();
    }

    public long a(long j, int i) {
        return this.a.a(j, i);
    }

    public long a(long j, long j2) {
        return this.a.a(j, j2);
    }

    public long d() {
        return this.a.d();
    }
}
