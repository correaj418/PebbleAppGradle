package com.b.a;

import com.b.a.a.d;
import com.b.a.g.b;
import com.b.a.q.a;

public class t extends n implements d, b, m, q {
    boolean c;
    private m d;
    private a e;
    private int f;

    public void a(m mVar) {
        if (this.d != null) {
            this.d.a(null);
        }
        this.d = mVar;
        this.d.a(this);
        this.d.b(new com.b.a.a.a(this) {
            final /* synthetic */ t a;

            {
                this.a = r1;
            }

            public void a(Exception exception) {
                this.a.b(exception);
            }
        });
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a(m mVar, k kVar) {
        if (this.c) {
            kVar.m();
            return;
        }
        if (kVar != null) {
            this.f += kVar.d();
        }
        ac.a((m) this, kVar);
        if (kVar != null) {
            this.f -= kVar.d();
        }
        if (this.e != null && kVar != null) {
            this.e.a(this.f);
        }
    }

    public void n_() {
        this.d.n_();
    }

    public void o_() {
        this.d.o_();
    }

    public boolean l() {
        return this.d.l();
    }

    public g m() {
        return this.d.m();
    }

    public void d() {
        this.c = true;
        if (this.d != null) {
            this.d.d();
        }
    }

    public String n() {
        if (this.d == null) {
            return null;
        }
        return this.d.n();
    }
}
