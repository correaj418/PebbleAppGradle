package com.getpebble.android.bluetooth;

import android.content.Context;
import com.getpebble.android.bluetooth.j.a;
import com.getpebble.android.bluetooth.j.b;
import com.getpebble.android.common.b.a.f;

public abstract class c extends g {
    protected final b a;
    protected final a b;
    protected com.getpebble.android.bluetooth.k.c c;

    protected abstract void c();

    protected abstract void d();

    protected c(PebbleDevice pebbleDevice, b bVar, e eVar, Context context, a aVar) {
        super(pebbleDevice, eVar, context);
        this.a = bVar;
        this.b = aVar;
    }

    protected void a() {
        b();
        super.a();
    }

    protected void a(f fVar) {
        b();
        super.a(fVar);
    }

    protected void b() {
        if (this.c != null) {
            this.c.e();
            this.c = null;
        }
    }

    protected void a(String str) {
        if (this.c != null) {
            this.c.e();
        }
        this.c = new com.getpebble.android.bluetooth.k.c(this, this.f, str) {
            final /* synthetic */ c a;

            public void a() {
                f.d("CreateConnection", "onDeviceBonded / " + this.a.d);
                this.a.c();
            }

            public void b() {
                f.d("CreateConnection", "onDeviceBondingFailed / " + this.a.d);
                this.a.d();
            }

            public void c() {
                f.d("CreateConnection", "onDeviceUnbonded / " + this.a.d);
                this.a.d();
            }

            public void d() {
                f.d("CreateConnection", "Pairing request received; accepting");
                this.a.a.i();
            }
        };
    }
}
