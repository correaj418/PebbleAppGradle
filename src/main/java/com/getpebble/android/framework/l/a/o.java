package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.framework.l.b.r;

public abstract class o {

    public class a extends RuntimeException {
        final /* synthetic */ o a;

        public a(o oVar, String str) {
            this.a = oVar;
            super(str);
        }
    }

    abstract com.getpebble.android.bluetooth.g.a a();

    protected abstract int b();

    public o(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("'message' cannot be null!");
        }
        b(bVar);
        c(bVar);
    }

    protected void b(b bVar) {
        if (!com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()).equals(a())) {
            throw new IllegalArgumentException("ProtocolMessage's endpointId must be " + a().name());
        }
    }

    protected void c(b bVar) {
        int a = a(j()) - 4;
        if (bVar.c() > a) {
            throw new a(this, "The buffer must be smaller than " + a + " but is " + bVar.c() + " for " + com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()) + " (" + bVar.a() + ")");
        } else if (bVar.c() < b()) {
            throw new a(this, "The buffer must be larger than " + b() + " but is " + bVar.c() + " for " + com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()) + " (" + bVar.a() + ")");
        }
    }

    protected com.getpebble.android.framework.o.b j() {
        return r.g();
    }

    public static int a(com.getpebble.android.framework.o.b bVar) {
        return bVar.support8kAppMessage ? 8222 : 2048;
    }
}
