package com.b.a.c;

import com.b.a.a.a;
import com.b.a.a.d;
import com.b.a.c.b.h;
import com.b.a.g;
import com.b.a.i;
import com.b.a.k;
import com.b.a.m;
import com.b.a.p;
import com.b.a.t;
import java.nio.charset.Charset;

abstract class f extends t implements h, e, i {
    static final /* synthetic */ boolean p = (!f.class.desiredAssertionStatus());
    private a d = new a(this) {
        final /* synthetic */ f a;

        {
            this.a = r1;
        }

        public void a(Exception exception) {
            if (exception == null || this.a.k) {
                this.a.b(exception);
            } else {
                this.a.b(new l("connection closed before response completed.", exception));
            }
        }
    };
    private d e;
    private i f;
    private boolean g = true;
    protected n j;
    boolean k = false;
    int l;
    String m;
    String n;
    p o;

    public i e() {
        return this.f;
    }

    public d o() {
        return this.e;
    }

    void a(i iVar) {
        this.f = iVar;
        if (this.f != null) {
            this.f.b(this.d);
        }
    }

    protected void p() {
        com.b.a.c.a.a g = this.e.g();
        if (g != null) {
            g.a(this.e, this, new a(this) {
                final /* synthetic */ f a;

                {
                    this.a = r1;
                }

                public void a(Exception exception) {
                    this.a.a(exception);
                }
            });
        } else {
            a(null);
        }
    }

    protected void a(Exception exception) {
    }

    protected void b() {
    }

    public h b(m mVar) {
        a(mVar);
        return this;
    }

    private void q() {
        this.f.a(new d.a(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void a(m mVar, k kVar) {
                super.a(mVar, kVar);
                this.a.f.d();
            }
        });
    }

    protected void b(Exception exception) {
        super.b(exception);
        q();
        this.f.a(null);
        this.f.a(null);
        this.f.b(null);
        this.k = true;
    }

    public void d() {
        super.d();
        q();
    }

    public f(d dVar) {
        this.e = dVar;
    }

    public n k() {
        return this.j;
    }

    public h a(n nVar) {
        this.j = nVar;
        return this;
    }

    public int j() {
        return this.l;
    }

    public h a(int i) {
        this.l = i;
        return this;
    }

    public h a(String str) {
        this.m = str;
        return this;
    }

    public h b(String str) {
        this.n = str;
        return this;
    }

    public String k_() {
        return this.m;
    }

    public String l_() {
        return this.n;
    }

    public String toString() {
        if (this.j == null) {
            return super.toString();
        }
        return this.j.e(this.m + " " + this.l + " " + this.n);
    }

    private void r() {
        if (this.g) {
            this.g = false;
            if (!p && this.e.e().a("Content-Type") == null) {
                throw new AssertionError();
            } else if (!p && this.e.e().a("Transfer-Encoding") == null && q.a(this.e.e()) == -1) {
                throw new AssertionError();
            }
        }
    }

    public p m_() {
        return this.o;
    }

    public h a(p pVar) {
        this.o = pVar;
        return this;
    }

    public void a(k kVar) {
        r();
        this.o.a(kVar);
    }

    public void a() {
        throw new AssertionError("end called?");
    }

    public void a(com.b.a.a.f fVar) {
        this.o.a(fVar);
    }

    public com.b.a.a.f g() {
        return this.o.g();
    }

    public boolean i() {
        return this.o.i();
    }

    public void a(a aVar) {
        this.o.a(aVar);
    }

    public g m() {
        return this.f.m();
    }

    public String n() {
        s b = s.b(k().a("Content-Type"));
        if (b != null) {
            String a = b.a("charset");
            if (a != null && Charset.isSupported(a)) {
                return a;
            }
        }
        return null;
    }
}
