package com.getpebble.android.bluetooth.a;

import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.e;
import com.getpebble.android.bluetooth.f;
import com.getpebble.android.bluetooth.j.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a extends f {
    private final c d;
    private final OutputStream e;
    private final InputStream f;

    a(PebbleDevice pebbleDevice, InputStream inputStream, OutputStream outputStream, c cVar, e eVar) {
        super(pebbleDevice, eVar);
        this.d = cVar;
        this.e = outputStream;
        this.f = inputStream;
    }

    protected void b() {
        e();
    }

    protected void e() {
        f();
        g();
    }

    protected void a(byte[] bArr) {
        this.e.write(bArr);
    }

    protected int a(byte[] bArr, int i, int i2) {
        return this.f.read(bArr, i, i2);
    }

    private void g() {
        Throwable e;
        com.getpebble.android.common.b.a.f.d("ClassicConnectionManager", "closeSocket()");
        try {
            if (this.d != null) {
                this.d.a();
            }
        } catch (IOException e2) {
            e = e2;
            com.getpebble.android.common.b.a.f.d("ClassicConnectionManager", "Error closing bluetooth socket", e);
        } catch (IllegalStateException e3) {
            e = e3;
            com.getpebble.android.common.b.a.f.d("ClassicConnectionManager", "Error closing bluetooth socket", e);
        }
    }

    protected void f() {
        Throwable e;
        try {
            this.f.close();
        } catch (IOException e2) {
            e = e2;
            com.getpebble.android.common.b.a.f.c("ClassicConnectionManager", "closeStreams: error closing input", e);
            this.e.close();
            return;
        } catch (IllegalStateException e3) {
            e = e3;
            com.getpebble.android.common.b.a.f.c("ClassicConnectionManager", "closeStreams: error closing input", e);
            this.e.close();
            return;
        }
        try {
            this.e.close();
            return;
        } catch (IOException e4) {
            e = e4;
        } catch (IllegalStateException e5) {
            e = e5;
        }
        com.getpebble.android.common.b.a.f.c("ClassicConnectionManager", "closeStreams: error closing output", e);
    }
}
