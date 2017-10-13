package com.google.android.gms.common.api;

import android.content.Context;
import com.google.android.gms.b.ah;
import com.google.android.gms.b.h;
import com.google.android.gms.b.x;
import com.google.android.gms.common.api.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class m<O extends a> {
    private final Context a;
    private final ah b;
    private final a<O> c;
    private final O d;
    private final h<O> e;
    private final int f;
    private final x g;
    private final AtomicBoolean h;
    private final AtomicInteger i;

    public void a() {
        boolean z = true;
        if (!this.h.getAndSet(true)) {
            this.b.a();
            x xVar = this.g;
            int i = this.f;
            if (this.i.get() <= 0) {
                z = false;
            }
            xVar.a(i, z);
        }
    }

    public a<O> b() {
        return this.c;
    }

    public O c() {
        return this.d;
    }

    public h<O> d() {
        return this.e;
    }

    public Context e() {
        return this.a;
    }
}
