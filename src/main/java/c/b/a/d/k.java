package c.b.a.d;

import c.b.a.c;
import c.b.a.d;
import c.b.a.g;

public class k extends d {
    private final int a;
    private final int b;
    private final int c;

    public k(c cVar, int i) {
        this(cVar, cVar == null ? null : cVar.a(), i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public k(c cVar, d dVar, int i) {
        this(cVar, dVar, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public k(c cVar, d dVar, int i, int i2, int i3) {
        super(cVar, dVar);
        if (i == 0) {
            throw new IllegalArgumentException("The offset cannot be zero");
        }
        this.a = i;
        if (i2 < cVar.g() + i) {
            this.b = cVar.g() + i;
        } else {
            this.b = i2;
        }
        if (i3 > cVar.h() + i) {
            this.c = cVar.h() + i;
        } else {
            this.c = i3;
        }
    }

    public int a(long j) {
        return super.a(j) + this.a;
    }

    public long a(long j, int i) {
        long a = super.a(j, i);
        h.a((c) this, a(a), this.b, this.c);
        return a;
    }

    public long a(long j, long j2) {
        long a = super.a(j, j2);
        h.a((c) this, a(a), this.b, this.c);
        return a;
    }

    public long b(long j, int i) {
        h.a((c) this, i, this.b, this.c);
        return super.b(j, i - this.a);
    }

    public boolean b(long j) {
        return i().b(j);
    }

    public g f() {
        return i().f();
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return this.c;
    }

    public long d(long j) {
        return i().d(j);
    }

    public long e(long j) {
        return i().e(j);
    }

    public long f(long j) {
        return i().f(j);
    }

    public long g(long j) {
        return i().g(j);
    }

    public long h(long j) {
        return i().h(j);
    }

    public long i(long j) {
        return i().i(j);
    }
}
