package com.b.b;

import com.b.a.a.f;
import com.b.a.c.a.a;
import com.b.a.c.d;
import com.b.a.g;
import com.b.a.k;
import com.b.a.m;
import com.b.a.p;

class w implements a {
    a a;
    v b;

    public w(a aVar, v vVar) {
        this.a = aVar;
        this.b = vVar;
    }

    public void a(d dVar, final p pVar, com.b.a.a.a aVar) {
        final int c = this.a.c();
        this.a.a(dVar, new p(this) {
            int a;
            final /* synthetic */ w d;

            public void a(k kVar) {
                int d = kVar.d();
                pVar.a(kVar);
                this.a = (d - kVar.d()) + this.a;
                this.d.b.a((long) this.a, (long) c);
            }

            public void a(f fVar) {
                pVar.a(fVar);
            }

            public f g() {
                return pVar.g();
            }

            public boolean i() {
                return pVar.i();
            }

            public void a() {
                pVar.a();
            }

            public void a(com.b.a.a.a aVar) {
                pVar.a(aVar);
            }

            public g m() {
                return pVar.m();
            }
        }, aVar);
    }

    public void a(m mVar, com.b.a.a.a aVar) {
        this.a.a(mVar, aVar);
    }

    public String a() {
        return this.a.a();
    }

    public boolean b() {
        return this.a.b();
    }

    public int c() {
        return this.a.c();
    }
}
