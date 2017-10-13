package com.b.a;

import com.b.a.a.a;
import com.b.a.a.f;

public class j implements p {
    static final /* synthetic */ boolean g = (!j.class.desiredAssertionStatus());
    p a;
    boolean b;
    k c = new k();
    f d;
    int e = Integer.MAX_VALUE;
    boolean f;

    public j(p pVar) {
        a(pVar);
    }

    public boolean b() {
        return this.c.e() || this.b;
    }

    public void a(boolean z) {
        this.b = z;
        if (!z) {
            e();
        }
    }

    public void a(p pVar) {
        this.a = pVar;
        this.a.a(new f(this) {
            final /* synthetic */ j a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.e();
            }
        });
    }

    private void e() {
        if (!this.b) {
            if (this.c.e()) {
                this.a.a(this.c);
                if (this.c.d() == 0 && this.f) {
                    this.a.a();
                }
            }
            if (!this.c.e() && this.d != null) {
                this.d.a();
            }
        }
    }

    public void a(k kVar) {
        a(kVar, false);
    }

    protected void a(final k kVar, final boolean z) {
        if (m().b() != Thread.currentThread()) {
            m().b(new Runnable(this) {
                final /* synthetic */ j c;

                public void run() {
                    this.c.a(kVar, z);
                }
            });
            return;
        }
        if (!b()) {
            this.a.a(kVar);
        }
        if (kVar.d() > 0) {
            int min = Math.min(kVar.d(), this.e);
            if (z) {
                min = kVar.d();
            }
            if (min > 0) {
                kVar.a(this.c, min);
            }
        }
    }

    public void a(f fVar) {
        this.d = fVar;
    }

    public f g() {
        return this.d;
    }

    public int c() {
        return this.c.d();
    }

    public int d() {
        return this.e;
    }

    public void a(int i) {
        if (g || i >= 0) {
            this.e = i;
            return;
        }
        throw new AssertionError();
    }

    public boolean i() {
        return this.a.i();
    }

    public void a() {
        if (m().b() != Thread.currentThread()) {
            m().b(new Runnable(this) {
                final /* synthetic */ j a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.a();
                }
            });
        } else if (this.c.e()) {
            this.f = true;
        } else {
            this.a.a();
        }
    }

    public void a(a aVar) {
        this.a.a(aVar);
    }

    public g m() {
        return this.a.m();
    }
}
