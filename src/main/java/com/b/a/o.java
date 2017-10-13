package com.b.a;

import com.b.a.a.d;

public class o implements d {
    static final /* synthetic */ boolean d = (!o.class.desiredAssertionStatus());
    d a;
    int b;
    k c = new k();

    public void a(int i, d dVar) {
        if (d || this.a == null) {
            this.b = i;
            this.a = dVar;
            if (d || !this.c.e()) {
                this.c.m();
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private boolean a(m mVar) {
        if (this.b > this.c.d()) {
            return false;
        }
        d dVar = this.a;
        this.a = null;
        dVar.a(mVar, this.c);
        if (d || !this.c.e()) {
            return true;
        }
        throw new AssertionError();
    }

    public void a(m mVar, k kVar) {
        if (d || this.a != null) {
            do {
                kVar.a(this.c, Math.min(kVar.d(), this.b - this.c.d()));
                kVar.d();
                if (!a(mVar)) {
                    break;
                }
            } while (this.a != null);
            kVar.d();
            return;
        }
        throw new AssertionError();
    }
}
