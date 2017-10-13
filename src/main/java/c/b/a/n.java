package c.b.a;

import c.b.a.a.d;
import java.io.Serializable;

public class n extends d implements o, Serializable, Cloneable {
    private c a;
    private int b;

    public static final class a extends c.b.a.d.a {
        private n a;
        private c b;

        a(n nVar, c cVar) {
            this.a = nVar;
            this.b = cVar;
        }

        public c a() {
            return this.b;
        }

        protected long b() {
            return this.a.c();
        }

        protected a c() {
            return this.a.d();
        }

        public n a(int i) {
            this.a.a(a().b(this.a.c(), i));
            return this.a;
        }
    }

    public n(long j, f fVar) {
        super(j, fVar);
    }

    public n(long j, a aVar) {
        super(j, aVar);
    }

    public void a(long j) {
        switch (this.b) {
            case 1:
                j = this.a.d(j);
                break;
            case 2:
                j = this.a.e(j);
                break;
            case 3:
                j = this.a.f(j);
                break;
            case 4:
                j = this.a.g(j);
                break;
            case 5:
                j = this.a.h(j);
                break;
        }
        super.a(j);
    }

    public void a(a aVar) {
        super.a(aVar);
    }

    public void b(f fVar) {
        f a = e.a(fVar);
        f a2 = e.a(n());
        if (a != a2) {
            long a3 = a2.a(a, c());
            a(d().a(a));
            a(a3);
        }
    }

    public a a(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        }
        c a = dVar.a(d());
        if (a.c()) {
            return new a(this, a);
        }
        throw new IllegalArgumentException("Field '" + dVar + "' is not supported");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Clone error");
        }
    }
}
