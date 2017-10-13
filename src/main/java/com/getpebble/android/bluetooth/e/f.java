package com.getpebble.android.bluetooth.e;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.bluetooth.e.a.e;
import com.getpebble.android.bluetooth.j;
import com.getpebble.android.bluetooth.j.b;

public class f extends j implements a, a {
    private final BluetoothGatt d;
    private final k e;
    private final n f;
    private final Handler g = new Handler(Looper.getMainLooper());
    private final h h;
    private final b i;
    private final a j;
    private final b k;
    private final j l;
    private final m m;
    private e n;

    static f a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.e eVar, k kVar, BluetoothGatt bluetoothGatt, n nVar, h hVar, b bVar, a aVar, b bVar2, j jVar, m mVar) {
        f fVar = new f(pebbleDevice, eVar, kVar, bluetoothGatt, nVar, hVar, bVar, aVar, bVar2, jVar, mVar);
        fVar.g();
        return fVar;
    }

    protected f(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.e eVar, k kVar, BluetoothGatt bluetoothGatt, n nVar, h hVar, b bVar, a aVar, b bVar2, j jVar, m mVar) {
        super(pebbleDevice, eVar);
        this.d = bluetoothGatt;
        this.f = nVar;
        this.e = kVar;
        this.h = hVar;
        this.i = bVar;
        this.j = aVar;
        this.k = bVar2;
        this.l = jVar;
        this.m = mVar;
    }

    protected void g() {
        this.f.a(this);
        this.e.a((a) this);
        if (this.j != null) {
            this.j.a(null);
        }
        if (this.k != null) {
            this.k.a(null);
        }
    }

    protected void b() {
        j();
    }

    private void j() {
        com.getpebble.android.common.b.a.f.d("LeConnectionManager", "closeGatt()");
        this.e.g();
        this.d.disconnect();
    }

    protected void e() {
        com.getpebble.android.common.b.a.f.d("LeConnectionManager", "cleanup()");
        j();
        Boolean b = b.b(this.i.k());
        if (b != null && b.booleanValue()) {
            com.getpebble.android.common.b.a.f.b("LeConnectionManager", "cleanup: device is still connected?");
        }
        if (this.m != null) {
            this.m.a(this.e);
        }
        a(this.g, new Runnable(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d.close();
            }
        });
        super.e();
    }

    protected void a(byte[] bArr) {
        this.e.a(bArr);
    }

    public void c(byte[] bArr) {
        b(bArr);
    }

    public void a_() {
        this.a.f(this.b);
    }

    public void a(d dVar) {
        b();
    }

    public void a(c cVar, d dVar, int i) {
        if (!cVar.equals(c.STATE_CONNECTED)) {
            com.getpebble.android.common.b.a.f.c("LeConnectionManager", "onConnectionStateChange !STATE_CONNECTED: " + cVar);
            e();
        } else if (!dVar.equals(d.GATT_SUCCESS)) {
            com.getpebble.android.common.b.a.f.c("LeConnectionManager", "onConnectionStateChange !GATT_SUCCESS: " + dVar);
            b();
        }
    }

    public void a(int i) {
        com.getpebble.android.common.b.a.f.c("LeConnectionManager", "onServerDisconnected()");
        e();
    }

    public void i() {
    }

    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, d dVar) {
    }

    public void a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        if (this.k != null) {
            this.k.a(bluetoothGattDescriptor);
        }
    }

    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.j != null) {
            this.j.a(bluetoothGattCharacteristic);
        }
        if (this.l != null) {
            this.l.b(bluetoothGattCharacteristic);
        }
    }

    public synchronized void b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.l != null) {
            this.l.a(bluetoothGattCharacteristic);
            if (this.n != null) {
                a(this.n);
            }
        }
    }

    public void b(int i) {
        com.getpebble.android.common.b.a.f.b("LeConnectionManager", "onMtuChanged: not expected here!");
    }

    public synchronized void a(e eVar) {
        if (this.j == null) {
            com.getpebble.android.common.b.a.f.b("LeConnectionManager", "requestInterval: mConnectionParams is null!");
        } else if (this.j.a(eVar)) {
            this.n = null;
        } else {
            com.getpebble.android.common.b.a.f.b("LeConnectionManager", "requestInterval: failed!");
            this.n = eVar;
        }
    }
}
