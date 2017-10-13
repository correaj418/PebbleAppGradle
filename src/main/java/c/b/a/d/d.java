package c.b.a.d;

import c.b.a.c;
import c.b.a.g;

public abstract class d extends b {
    private final c a;

    protected d(c cVar, c.b.a.d dVar) {
        super(dVar);
        if (cVar == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (cVar.c()) {
            this.a = cVar;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public final c i() {
        return this.a;
    }

    public int a(long j) {
        return this.a.a(j);
    }

    public long b(long j, int i) {
        return this.a.b(j, i);
    }

    public g d() {
        return this.a.d();
    }

    public g e() {
        return this.a.e();
    }

    public int g() {
        return this.a.g();
    }

    public int h() {
        return this.a.h();
    }

    public long d(long j) {
        return this.a.d(j);
    }
}
