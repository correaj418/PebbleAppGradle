package com.getpebble.android.bluetooth.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.common.b.a.d;
import com.getpebble.android.common.b.a.f;
import java.util.UUID;

public class a {
    private static final UUID a = UUID.fromString("a924496e-cc7c-4dff-8a9f-9a76cc2e9d50");
    private final a b;
    private BluetoothServerSocket c;
    private final Handler d = new Handler(Looper.getMainLooper());

    public interface a {
        void a(String str);
    }

    public a(a aVar) {
        this.b = aVar;
    }

    public synchronized void a() {
        if (this.c != null) {
            f.e("ReconnectionSocketServer", "startListening() but socket is already non-null; no-op");
        } else {
            f.d("ReconnectionSocketServer", "startListening()");
            try {
                this.c = BluetoothAdapter.getDefaultAdapter().listenUsingRfcommWithServiceRecord("PebbleBluetoothServerSocket", a);
                new com.getpebble.android.bluetooth.b.f(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public boolean doInBackground() {
                        try {
                            BluetoothServerSocket a = this.a.c;
                            if (a == null) {
                                f.c("ReconnectionSocketServer", "serverSocket is null before accept() call");
                                return false;
                            }
                            f.d("ReconnectionSocketServer", "Calling serverSocket.accept()...");
                            BluetoothSocket accept = a.accept();
                            f.d("ReconnectionSocketServer", "Client connected! Waiting for lock...");
                            synchronized (this.a) {
                                final BluetoothDevice remoteDevice = accept.getRemoteDevice();
                                this.a.d.postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 b;

                                    public void run() {
                                        this.b.a.b.a(remoteDevice.getAddress());
                                    }
                                }, 500);
                                f.c("ReconnectionSocketServer", "Got connection from client!");
                                accept.close();
                            }
                            f.d("ReconnectionSocketServer", "Finished listening");
                            synchronized (this.a) {
                                try {
                                    this.a.c.close();
                                } catch (Throwable e) {
                                    f.b("ReconnectionSocketServer", "Error closing server socket", e);
                                }
                                this.a.c = null;
                            }
                            return false;
                        } catch (Exception e2) {
                            f.d("ReconnectionSocketServer", "Error waiting to accept server socket" + d.a(e2, 2));
                        }
                    }

                    public void onTaskSuccess() {
                    }

                    public void onTaskFailed() {
                    }
                }.submit();
            } catch (Throwable e) {
                f.b("ReconnectionSocketServer", "Error creating server socket", e);
            }
        }
    }

    public synchronized void b() {
        if (this.c != null) {
            f.d("ReconnectionSocketServer", "stopListening()");
            try {
                this.c.close();
            } catch (Throwable e) {
                f.b("ReconnectionSocketServer", "Error closing server socket", e);
            }
        }
    }
}
