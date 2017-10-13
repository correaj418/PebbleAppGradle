package com.b.a.c.e;

import com.b.a.a.a;
import com.b.a.a.d;
import com.b.a.c.n;
import com.b.a.c.q;
import com.b.a.c.u;
import com.b.a.i;
import com.b.a.m;
import com.b.a.t;
import com.b.a.w;
import java.util.regex.Matcher;

public abstract class c extends t implements a, b {
    private String d;
    private n e = new n();
    private a f = new a(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public void a(Exception exception) {
            this.a.a(exception);
        }
    };
    i m;
    Matcher n;
    w.a o = new w.a(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public void a(String str) {
            try {
                if (this.a.d == null) {
                    this.a.d = str;
                    if (!this.a.d.contains("HTTP/")) {
                        this.a.g();
                        this.a.m.a(null);
                    }
                } else if ("\r".equals(str)) {
                    m a = q.a(this.a.m, u.HTTP_1_1, this.a.e, true);
                    this.a.q = q.a(a, this.a.f, this.a.e);
                    if (this.a.q == null) {
                        this.a.q = this.a.a(this.a.e);
                        if (this.a.q == null) {
                            this.a.q = new i(this.a.e.a("Content-Type"));
                        }
                    }
                    this.a.q.a(a, this.a.f);
                    this.a.a();
                } else {
                    this.a.e.b(str);
                }
            } catch (Exception e) {
                this.a.a(e);
            }
        }
    };
    String p;
    com.b.a.c.a.a q;

    protected abstract void a();

    public String e() {
        return this.d;
    }

    public void a(Exception exception) {
        b(exception);
    }

    protected void g() {
        System.out.println("not http!");
    }

    protected com.b.a.c.a.a a(n nVar) {
        return null;
    }

    public String i() {
        return this.p;
    }

    void a(i iVar) {
        this.m = iVar;
        Object wVar = new w();
        this.m.a(wVar);
        wVar.a(this.o);
        this.m.b(new a.a());
    }

    public i c() {
        return this.m;
    }

    public n b() {
        return this.e;
    }

    public void a(d dVar) {
        this.m.a(dVar);
    }

    public d f() {
        return this.m.f();
    }

    public com.b.a.c.a.a o() {
        return this.q;
    }

    public void n_() {
        this.m.n_();
    }

    public void o_() {
        this.m.o_();
    }

    public boolean l() {
        return this.m.l();
    }

    public String toString() {
        if (this.e == null) {
            return super.toString();
        }
        return this.e.e(this.d);
    }
}
