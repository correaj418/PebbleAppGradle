package com.getpebble.android.bluetooth.d;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.getpebble.android.bluetooth.j.a;
import com.getpebble.android.common.b.a.f;

public class c extends d {
    private LeScanCallback b;
    private final a c;

    c(a.a aVar, a aVar2) {
        super(aVar);
        this.c = aVar2;
    }

    protected synchronized boolean a() {
        boolean z;
        this.b = new LeScanCallback(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
                com.getpebble.android.bluetooth.b.c.a(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 d;

                    public void run() {
                        this.d.a.a(bluetoothDevice, i, bArr);
                    }
                });
            }
        };
        if (this.c.a(this.b)) {
            z = true;
        } else {
            f.d("JellybeanLeScanner", "startScan: failed to start");
            z = false;
        }
        return z;
    }

    protected synchronized boolean b() {
        return this.b != null;
    }

    protected synchronized boolean c() {
        this.c.b(this.b);
        this.b = null;
        return true;
    }
}
