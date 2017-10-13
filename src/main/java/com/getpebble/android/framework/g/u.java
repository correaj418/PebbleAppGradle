package com.getpebble.android.framework.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.framework.b.a;
import com.getpebble.android.framework.p.f;
import com.getpebble.android.framework.p.o;

public class u extends l {
    protected String a;
    private ak b;

    public u(Context context, a aVar) {
        super(aVar);
        this.a = "NormalEndpointSet";
        this.a = getClass().getSimpleName();
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (aVar == null) {
            throw new IllegalArgumentException("'router' cannot be null!");
        }
    }

    protected void f() {
        Context K = com.getpebble.android.common.a.K();
        a(new ag(this, K));
        a(new t(new c(K), K, this));
        a(new af(this));
        a(new v(K, this));
        ac zVar = new z(this);
        a(zVar);
        a(new q(K, this, zVar));
        a(new m(K, this, false));
        a(new i(K, this));
        a(new b(K, this, com.getpebble.android.framework.pebblekit.a.a(K)));
        a(new s(K, this));
        a(new h(this));
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = new ak(handler);
        a(new ai(this, handler, new o(this, this.b, new f())));
        a(new d(K, this, null));
        a(new x(this));
        a(new a(this, zVar, K.getContentResolver()));
        a(new e(K, this));
        a(new c(this));
        a(new ad(this));
        a(new o(this));
        com.getpebble.android.notifications.b.f.c(K);
    }

    protected void d() {
        super.d();
        this.b.b();
    }
}
