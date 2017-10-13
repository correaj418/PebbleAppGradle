package com.getpebble.android.bluetooth.d;

import android.bluetooth.BluetoothDevice;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.d.a.a;
import com.getpebble.android.bluetooth.d.g.b;
import com.getpebble.android.common.b.a.f;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;

abstract class d {
    protected final a a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private Runnable c = new Runnable(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.f();
        }
    };

    abstract boolean a();

    abstract boolean b();

    abstract boolean c();

    static d a(a aVar, com.getpebble.android.bluetooth.j.a aVar2) {
        if (VERSION.SDK_INT >= 21) {
            return new e(aVar, aVar2);
        }
        return new c(aVar, aVar2);
    }

    protected d(a aVar) {
        this.a = aVar;
    }

    protected void d() {
        this.b.postDelayed(this.c, 30000);
    }

    protected void e() {
        this.b.removeCallbacks(this.c);
    }

    synchronized void f() {
        f.d("LeScanner", "Scan timed out");
        h();
    }

    protected void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (bluetoothDevice.getName() != null) {
            try {
                g gVar = new g(h.a(bArr));
                if (com.getpebble.android.bluetooth.h.d.a().a(bluetoothDevice.getName(), bluetoothDevice.getAddress(), Transport.LE, bluetoothDevice.getBluetoothClass(), bluetoothDevice.getType(), gVar)) {
                    PebbleDevice pebbleDevice = new PebbleDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), Transport.LE, (short) i);
                    f.d("LeScanner", "onLeDeviceFound: " + pebbleDevice);
                    this.a.a(new b(pebbleDevice, gVar));
                    return;
                }
                f.d("LeScanner", "onLeDeviceFound: Not a Pebble: " + bluetoothDevice.getName() + " / " + bluetoothDevice.getAddress());
            } catch (UnsupportedEncodingException e) {
            } catch (BufferUnderflowException e2) {
            } catch (b e3) {
            }
        }
    }

    synchronized boolean g() {
        boolean z;
        if (b()) {
            f.d("LeScanner", "startScan: already scanning!");
            z = false;
        } else {
            f.d("LeScanner", "startScan()");
            z = a();
            if (z) {
                this.a.a();
                d();
            }
        }
        return z;
    }

    synchronized boolean h() {
        boolean c;
        if (b()) {
            f.d("LeScanner", "stopScan()");
            c = c();
            this.a.b();
            e();
        } else {
            f.d("LeScanner", "stopScan: not scanning!");
            c = false;
        }
        return c;
    }
}
