package com.getpebble.android.bluetooth.i;

import android.content.Context;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.e;
import com.getpebble.android.bluetooth.g;
import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.common.b.a.f;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;

public class d extends g {
    private boolean a;
    private Socket b;

    public d(PebbleDevice pebbleDevice, e eVar, Context context) {
        this(pebbleDevice, eVar, context, false);
    }

    public d(PebbleDevice pebbleDevice, e eVar, Context context, boolean z) {
        super(pebbleDevice, eVar, context);
        this.a = z;
    }

    protected void e() {
        b();
    }

    private void b() {
        if (this.b != null) {
            try {
                this.b.close();
            } catch (Throwable e) {
                f.b("QemuDeviceConnector", "closeSocket: error", e);
            }
        }
    }

    public synchronized void f() {
        b();
    }

    public void g() {
        try {
            final URI uri = new URI("my://" + this.d.getAddress());
            new com.getpebble.android.bluetooth.b.f(this) {
                final /* synthetic */ d b;

                public boolean doInBackground() {
                    try {
                        if (this.b.a) {
                            while (this.b.b == null) {
                                ServerSocket serverSocket = new ServerSocket(uri.getPort());
                                Socket accept = serverSocket.accept();
                                if (accept.getInetAddress().getHostAddress().equals(uri.getHost())) {
                                    this.b.b = accept;
                                }
                                serverSocket.close();
                            }
                        } else {
                            this.b.b = new Socket(uri.getHost(), uri.getPort());
                        }
                        f.d("QemuDeviceConnector", "connect: connected to socket!");
                        this.b.a(new c(this.b.d, this.b.e, this.b.b));
                    } catch (Throwable e) {
                        f.a("QemuDeviceConnector", "Error connecting to " + this.b.d.getAddress(), e);
                        this.b.a(new a(a.a.NOT_AVAILABLE, null));
                    }
                    return true;
                }

                public void onTaskSuccess() {
                }

                public void onTaskFailed() {
                }
            }.submit();
        } catch (Throwable e) {
            throw new IllegalArgumentException("Invalid address: " + this.d.getAddress(), e);
        }
    }
}
