package com.getpebble.android.bluetooth.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.e;
import com.getpebble.android.bluetooth.j;
import com.getpebble.android.common.b.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class c extends j {
    private final Socket d;
    private final InputStream e;
    private final OutputStream f;
    private final HandlerThread g = new HandlerThread("socket_input_" + this.b.getAddress());
    private final Handler h;

    public c(PebbleDevice pebbleDevice, e eVar, Socket socket) {
        super(pebbleDevice, eVar);
        this.d = socket;
        this.e = socket.getInputStream();
        this.f = socket.getOutputStream();
        this.g.start();
        this.h = new Handler(this.g.getLooper());
    }

    public void a() {
        a(this.h, new Runnable(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.h();
            }
        });
        super.a();
    }

    protected void b() {
        i();
        g();
        super.e();
    }

    protected void e() {
        i();
        g();
        this.h.removeCallbacksAndMessages(null);
        this.g.quit();
        super.e();
    }

    protected void a(byte[] bArr) {
        this.f.write(new b(bArr).a);
    }

    private void h() {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        while (!this.c) {
            int i = 0;
            do {
                Object obj;
                try {
                    if (!this.c) {
                        int read = this.e.read(allocate.array(), i, allocate.capacity() - i);
                        obj = read > 0 ? 1 : null;
                        if (obj != null) {
                            i += read;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        f.c("QemuConnectionManager", "doSocketInput: mDisconnectRequested requested at header read; returning");
                        return;
                    }
                } catch (IOException e) {
                    e = e;
                } catch (IllegalArgumentException e2) {
                    e = e2;
                } catch (BufferUnderflowException e3) {
                    e = e3;
                }
            } while (i < allocate.capacity());
            allocate.position(0);
            a aVar = new a(allocate);
            byte[] bArr = new byte[aVar.a()];
            i = 0;
            while (!this.c) {
                int read2 = this.e.read(bArr, i, bArr.length - i);
                obj = read2 > 0 ? 1 : null;
                if (obj != null) {
                    i += read2;
                }
                if (obj != null) {
                    if (i >= aVar.a()) {
                    }
                }
                if (obj == null) {
                    f.a("QemuConnectionManager", "doSocketInput: end of input signalled, this will prevent further communications from QEMU");
                    b();
                    return;
                }
                aVar.a(bArr);
                if (aVar.b()) {
                    b(aVar.c());
                } else {
                    f.d("QemuConnectionManager", "Packet for not-pebble-protocol");
                }
            }
            f.c("QemuConnectionManager", "doSocketInput: mDisconnectRequested requested at body read; returning");
            return;
        }
        b();
        return;
        Throwable e4;
        f.a("QemuConnectionManager", "Error reading from socket stream", e4);
        b();
    }

    private void i() {
        f.d("QemuConnectionManager", "closeSocket()");
        try {
            if (this.d != null) {
                this.d.close();
            }
        } catch (Throwable e) {
            f.d("QemuConnectionManager", "Error closing output stream", e);
        }
    }

    protected void g() {
        try {
            this.e.close();
        } catch (Throwable e) {
            f.c("QemuConnectionManager", "closeStreams: error closing input", e);
        }
        try {
            this.f.close();
        } catch (Throwable e2) {
            f.c("QemuConnectionManager", "closeStreams: error closing output", e2);
        }
    }
}
