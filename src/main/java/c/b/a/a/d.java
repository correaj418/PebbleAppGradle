package c.b.a.a;

import c.b.a.a;
import c.b.a.b.u;
import c.b.a.c.h;
import c.b.a.e;
import c.b.a.f;
import c.b.a.q;
import java.io.Serializable;

public abstract class d extends a implements q, Serializable {
    private volatile long a;
    private volatile a b;

    public d() {
        this(e.a(), u.O());
    }

    public d(f fVar) {
        this(e.a(), u.b(fVar));
    }

    public d(long j) {
        this(j, u.O());
    }

    public d(long j, f fVar) {
        this(j, u.b(fVar));
    }

    public d(long j, a aVar) {
        this.b = b(aVar);
        this.a = a(j, this.b);
        p();
    }

    public d(Object obj, f fVar) {
        h a = c.b.a.c.d.a().a(obj);
        a b = b(a.a(obj, fVar));
        this.b = b;
        this.a = a(a.a(obj, b), b);
        p();
    }

    public d(int i, int i2, int i3, int i4, int i5, int i6, int i7, a aVar) {
        this.b = b(aVar);
        this.a = a(this.b.a(i, i2, i3, i4, i5, i6, i7), this.b);
        p();
    }

    private void p() {
        if (this.a == Long.MIN_VALUE || this.a == Long.MAX_VALUE) {
            this.b = this.b.b();
        }
    }

    protected a b(a aVar) {
        return e.a(aVar);
    }

    protected long a(long j, a aVar) {
        return j;
    }

    public long c() {
        return this.a;
    }

    public a d() {
        return this.b;
    }

    protected void a(long j) {
        this.a = a(j, this.b);
    }

    protected void a(a aVar) {
        this.b = b(aVar);
    }
}
