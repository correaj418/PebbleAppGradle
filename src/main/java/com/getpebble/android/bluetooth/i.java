package com.getpebble.android.bluetooth;

import android.content.Context;
import com.getpebble.android.bluetooth.e.a.e;
import com.getpebble.android.bluetooth.e.h;
import com.getpebble.android.bluetooth.e.m;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;

public class i {
    protected a a = a.DISCONNECTED;
    protected g b;
    protected f c;
    protected int d;
    private final PebbleDevice e;

    enum a {
        DISCONNECTED,
        CONNECTING,
        CONNECTED
    }

    i(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        }
        this.e = pebbleDevice;
    }

    private synchronized void a(a aVar) {
        if (this.a.equals(aVar)) {
            f.d("DeviceState", "setStatus: no-op for " + aVar + " / " + this.e);
        } else {
            f.d("DeviceState", "setStatus: from " + this.a + " to " + aVar + " / " + this.e);
            this.a = aVar;
        }
    }

    synchronized boolean a(e eVar, Context context, com.getpebble.android.bluetooth.j.a aVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, h hVar, String str) {
        boolean z;
        if (this.a.equals(a.DISCONNECTED)) {
            this.b = b(eVar, context, aVar, aVar2, mVar, hVar, str);
            this.b.g();
            a(a.CONNECTING);
            z = true;
        } else {
            f.b("DeviceState", "... is " + this.a + "; not connecting");
            z = false;
        }
        return z;
    }

    protected g b(e eVar, Context context, com.getpebble.android.bluetooth.j.a aVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, h hVar, String str) {
        f.d("DeviceState", "connect: using transport " + this.e.getTransport() + " / " + this.e + " consecutiveGattErrors = " + this.d);
        return this.e.getTransport().getDeviceConnector(this.e, eVar, context, aVar, aVar2, mVar, this, hVar, str);
    }

    synchronized boolean a() {
        boolean z = false;
        synchronized (this) {
            f.d("DeviceState", "disconnect()");
            switch (this.a) {
                case DISCONNECTED:
                    f.d("DeviceState", "Already disconnected...");
                    break;
                case CONNECTED:
                    this.c.c();
                    z = true;
                    break;
                case CONNECTING:
                    this.b.f();
                    z = true;
                    break;
            }
        }
        return z;
    }

    synchronized boolean a(f fVar) {
        boolean z;
        if (this.a.equals(a.CONNECTING)) {
            this.c = fVar;
            this.b = null;
            fVar.a();
            a(a.CONNECTED);
            z = true;
        } else {
            f.b("DeviceState", "... is " + this.a + "; not marking as connected");
            z = false;
        }
        return z;
    }

    synchronized boolean b() {
        boolean z;
        if (this.a.equals(a.DISCONNECTED)) {
            f.b("DeviceState", "setDisconnected: ... is already disconnected");
            z = false;
        } else {
            a(a.DISCONNECTED);
            this.b = null;
            this.c = null;
            z = true;
        }
        return z;
    }

    synchronized boolean a(b bVar) {
        boolean z;
        if (this.a.equals(a.CONNECTED)) {
            this.c.a(bVar);
            z = true;
        } else {
            f.b("DeviceState", "... is " + this.a + "; not sending message / " + this.e);
            z = false;
        }
        return z;
    }

    void a(e eVar) {
        if (!this.a.equals(a.CONNECTED)) {
            f.b("DeviceState", "... is " + this.a + "; not setting LE interval / " + this.e);
        } else if (this.c instanceof com.getpebble.android.bluetooth.e.f) {
            ((com.getpebble.android.bluetooth.e.f) this.c).a(eVar);
        } else {
            f.e("DeviceState", "requestLeInterval: not setting interval for non-LE device");
        }
    }

    public String toString() {
        return "[DeviceState / " + this.e + " / " + this.a + " / create = " + this.b + " / manage = " + this.c + "]";
    }

    public void a(boolean z) {
        if (z) {
            this.d++;
        } else {
            this.d = 0;
        }
    }

    public boolean c() {
        return this.d > 0;
    }

    public int d() {
        return this.d;
    }
}
