package com.google.android.gms.b;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.b.k.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.e;

public class q implements u {
    private final v a;
    private boolean b = false;

    public q(v vVar) {
        this.a = vVar;
    }

    private <A extends c> void c(a<? extends f, A> aVar) {
        this.a.g.i.a((a) aVar);
        c b = this.a.g.b(aVar.b());
        if (b.b() || !this.a.b.containsKey(aVar.b())) {
            if (b instanceof e) {
                b = ((e) b).k();
            }
            aVar.a(b);
            return;
        }
        aVar.a(new Status(17));
    }

    public <A extends c, R extends f, T extends a<R, A>> T a(T t) {
        return b(t);
    }

    public void a() {
    }

    public void a(int i) {
        this.a.a(null);
        this.a.h.a(i, this.b);
    }

    public void a(Bundle bundle) {
    }

    public void a(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, int i) {
    }

    public <A extends c, T extends a<? extends f, A>> T b(T t) {
        try {
            c(t);
        } catch (DeadObjectException e) {
            this.a.a(new a(this, this) {
                final /* synthetic */ q a;

                public void a() {
                    this.a.a(1);
                }
            });
        }
        return t;
    }

    public boolean b() {
        if (this.b) {
            return false;
        }
        if (this.a.g.j()) {
            this.b = true;
            for (am a : this.a.g.h) {
                a.a();
            }
            return false;
        }
        this.a.a(null);
        return true;
    }

    public void c() {
        if (this.b) {
            this.b = false;
            this.a.a(new a(this, this) {
                final /* synthetic */ q a;

                public void a() {
                    this.a.a.h.a(null);
                }
            });
        }
    }

    void d() {
        if (this.b) {
            this.b = false;
            this.a.g.i.a();
            b();
        }
    }
}
