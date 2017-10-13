package com.b.a.b;

public class h implements c {
    public static final a g = new h() {
        {
            f();
        }

        public /* synthetic */ c a(a aVar) {
            return super.b(aVar);
        }
    };
    static final /* synthetic */ boolean h;
    private a a;
    boolean e;
    boolean f;

    static {
        boolean z;
        if (h.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        h = z;
    }

    public /* synthetic */ c a(a aVar) {
        return b(aVar);
    }

    public boolean isDone() {
        return this.e;
    }

    protected void a() {
    }

    protected void d() {
    }

    protected void e() {
    }

    public boolean f() {
        boolean z = true;
        synchronized (this) {
            if (this.f) {
                z = false;
            } else if (!this.e) {
                this.e = true;
                this.a = null;
                e();
                d();
            } else if (h) {
            } else {
                throw new AssertionError();
            }
        }
        return z;
    }

    public boolean b() {
        boolean z = true;
        synchronized (this) {
            if (this.e) {
                z = false;
            } else if (this.f) {
            } else {
                this.f = true;
                a aVar = this.a;
                this.a = null;
                if (aVar != null) {
                    aVar.b();
                }
                a();
                d();
            }
        }
        return z;
    }

    public h b(a aVar) {
        synchronized (this) {
            if (!isDone()) {
                this.a = aVar;
            }
        }
        return this;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this) {
            z = this.f || (this.a != null && this.a.isCancelled());
        }
        return z;
    }

    public a g() {
        b();
        this.e = false;
        this.f = false;
        return this;
    }
}
