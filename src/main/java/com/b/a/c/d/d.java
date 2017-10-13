package com.b.a.c.d;

import com.b.a.k;
import com.b.a.m;
import com.b.a.t;

public class d extends t {
    static final /* synthetic */ boolean g = (!d.class.desiredAssertionStatus());
    long d;
    long e;
    k f = new k();

    public d(long j) {
        this.d = j;
    }

    protected void b(Exception exception) {
        if (exception == null && this.e != this.d) {
            exception = new h("End of data reached before content length was read: " + this.e + "/" + this.d + " Paused: " + l());
        }
        super.b(exception);
    }

    public void a(m mVar, k kVar) {
        if (g || this.e < this.d) {
            kVar.a(this.f, (int) Math.min(this.d - this.e, (long) kVar.d()));
            int d = this.f.d();
            super.a(mVar, this.f);
            this.e = ((long) (d - this.f.d())) + this.e;
            this.f.a(kVar);
            if (this.e == this.d) {
                b(null);
                return;
            }
            return;
        }
        throw new AssertionError();
    }
}
