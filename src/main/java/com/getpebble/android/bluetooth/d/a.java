package com.getpebble.android.bluetooth.d;

import android.content.Context;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.k.d;
import com.getpebble.android.common.b.a.f;

public class a {
    protected d a;
    private final d b;
    private final a c;
    private final com.getpebble.android.bluetooth.j.a d;

    public interface a {
        void a();

        void a(b bVar);

        void b();
    }

    public a(Context context, a aVar, com.getpebble.android.bluetooth.j.a aVar2) {
        this.c = aVar;
        this.d = aVar2;
        this.b = a(context);
        d();
    }

    private void d() {
        if (this.a == null) {
            try {
                this.a = a();
            } catch (Throwable e) {
                f.c("BluetoothDiscoveryManager", "Error creating LE scanner (expected when adapter is down)", e);
            }
        }
    }

    protected d a(Context context) {
        return new d(this, context) {
            final /* synthetic */ a a;

            public void a() {
                this.a.c.a();
            }

            public void a(PebbleDevice pebbleDevice) {
                this.a.c.a(new b(pebbleDevice, null));
            }

            public void b() {
                if (this.a.a == null || !this.a.a.b()) {
                    this.a.c.b();
                } else {
                    f.c("BluetoothDiscoveryManager", "onDiscoveryFinished: classic; LE is still scanning");
                }
            }
        };
    }

    protected d a() {
        f.d("BluetoothDiscoveryManager", "createLeScanner()");
        return d.a(new a(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.c.a();
            }

            public void a(b bVar) {
                this.a.c.a(bVar);
            }

            public void b() {
                if (this.a.d.b()) {
                    f.c("BluetoothDiscoveryManager", "onDiscoveryFinished: LE; classic is still discovering");
                } else {
                    this.a.c.b();
                }
            }
        }, this.d);
    }

    private boolean e() {
        return this.d.b();
    }

    private boolean f() {
        return this.a != null && this.a.b();
    }

    public void b() {
        boolean e = e();
        boolean f = f();
        if (e || f) {
            f.d("BluetoothDiscoveryManager", "dumpState: isStrictlyDiscovering=" + e + " isStrictlyScanning=" + f);
        }
    }

    public boolean a(Transport transport) {
        f.d("BluetoothDiscoveryManager", "startDiscovery: transport = " + transport);
        d();
        c();
        switch (transport) {
            case CLASSIC:
                return this.d.d();
            case LE:
                return this.a != null && this.a.g();
            default:
                throw new IllegalArgumentException("No scan available for transport " + transport);
        }
    }

    public void c() {
        f.d("BluetoothDiscoveryManager", "cancelDiscovery()");
        if (this.d.b()) {
            this.d.a();
        }
        if (this.a != null) {
            this.a.h();
        }
    }
}
