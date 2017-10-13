package com.getpebble.android.bluetooth;

import com.getpebble.android.common.b.a.f;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public abstract class j extends f {
    private final PipedOutputStream d = f();
    private final PipedInputStream e = a(this.d);

    protected j(PebbleDevice pebbleDevice, e eVar) {
        super(pebbleDevice, eVar);
    }

    protected PipedOutputStream f() {
        return new PipedOutputStream();
    }

    protected PipedInputStream a(PipedOutputStream pipedOutputStream) {
        return new PipedInputStream(pipedOutputStream);
    }

    protected void e() {
        g();
    }

    protected void b(byte[] bArr) {
        try {
            this.d.write(bArr);
            this.d.flush();
        } catch (Throwable e) {
            f.a("PipedConnectionManager", "onDataAvailable", e);
            b();
        }
    }

    protected int a(byte[] bArr, int i, int i2) {
        return this.e.read(bArr, i, i2);
    }

    private void g() {
        try {
            this.d.close();
        } catch (Throwable e) {
            f.a("PipedConnectionManager", "closePipes", e);
        }
    }
}
