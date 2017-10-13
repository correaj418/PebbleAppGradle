package com.getpebble.android.bluetooth;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.bluetooth.h.c;
import com.getpebble.android.bluetooth.h.e;
import com.getpebble.android.common.b.a.d;
import java.nio.ByteBuffer;

public abstract class f {
    protected final e a;
    protected final PebbleDevice b;
    protected boolean c;
    private final HandlerThread d;
    private final HandlerThread e;
    private Handler f;
    private Handler g;
    private boolean h = false;
    private final boolean i;

    protected abstract int a(byte[] bArr, int i, int i2);

    protected abstract void a(byte[] bArr);

    protected abstract void b();

    protected abstract void e();

    protected f(PebbleDevice pebbleDevice, e eVar) {
        this.b = pebbleDevice;
        this.d = new HandlerThread("input_" + pebbleDevice.getName(), -1);
        this.e = new HandlerThread("output_" + pebbleDevice.getName(), -1);
        this.d.start();
        this.e.start();
        this.f = new Handler(this.d.getLooper());
        this.g = new Handler(this.e.getLooper());
        this.a = eVar;
        this.i = c.a();
    }

    protected void a() {
        a(this.f, new Runnable(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.f();
            }
        });
    }

    protected void a(Handler handler, Runnable runnable) {
        if (handler == null) {
            com.getpebble.android.common.b.a.f.b("ConnectionManager", "runOnHandler: handler is null");
        } else {
            handler.post(runnable);
        }
    }

    void c() {
        this.c = true;
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void run() {
                synchronized (this.a) {
                    if (this.a.f != null) {
                        this.a.f.removeCallbacksAndMessages(null);
                    }
                    this.a.f = null;
                    if (this.a.g == null) {
                        com.getpebble.android.common.b.a.f.d("ConnectionManager", "finishInput: output has also finished! Marking as disconnected");
                        this.a.d();
                    } else {
                        com.getpebble.android.common.b.a.f.d("ConnectionManager", "finishInput: output has not yet finished...");
                    }
                }
            }
        };
        Runnable anonymousClass3 = new Runnable(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void run() {
                synchronized (this.a) {
                    if (this.a.g != null) {
                        this.a.g.removeCallbacksAndMessages(null);
                    }
                    this.a.g = null;
                    if (this.a.f == null) {
                        com.getpebble.android.common.b.a.f.d("ConnectionManager", "finishOutput: input has also finished! Marking as disconnected");
                        this.a.d();
                    } else {
                        com.getpebble.android.common.b.a.f.d("ConnectionManager", "finishOutput: input has not yet finished...");
                    }
                }
            }
        };
        a(this.f, anonymousClass2);
        if (this.g != null) {
            this.g.removeCallbacksAndMessages(null);
            a(this.g, anonymousClass3);
        }
        b();
    }

    protected synchronized void d() {
        com.getpebble.android.common.b.a.f.c("ConnectionManager", "destroyAndReportDisconnection()");
        e();
        if (!this.h) {
            com.getpebble.android.common.b.a.f.d("ConnectionManager", "destroyAndReportDisconnection: reporting disconnection");
            this.a.g(this.b);
        }
        this.h = true;
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d.quit();
                this.a.e.quit();
            }
        });
    }

    public void a(final b bVar) {
        if (this.g == null) {
            com.getpebble.android.common.b.a.f.b("ConnectionManager", "sendMessage: mOutputHandler is null");
            this.a.i(this.b);
            return;
        }
        a(this.g, new Runnable(this) {
            final /* synthetic */ f b;

            public void run() {
                Object obj;
                try {
                    com.getpebble.android.common.b.a.f.d("ConnectionManager", "sendMessage size: " + bVar.c() + " endpoint = " + a.fromCode(bVar.a()) + " (" + bVar.a() + ")");
                    ByteBuffer allocate = ByteBuffer.allocate(bVar.c() + 4);
                    allocate.putShort((short) (bVar.c() & 65535));
                    allocate.putShort((short) (bVar.a() & 65535));
                    allocate.put(bVar.b());
                    if (this.b.i) {
                        com.getpebble.android.common.b.a.f.d("ConnectionManager", "Sending " + com.getpebble.android.bluetooth.b.b.c(allocate.array()));
                    }
                    this.b.a(allocate.array());
                    e.a(e.a.BT_MESSAGE_SEND, com.getpebble.android.bluetooth.h.b.a().getContentResolver());
                    obj = 1;
                } catch (Throwable e) {
                    com.getpebble.android.common.b.a.f.a("ConnectionManager", "Error sending data", e);
                    this.b.c();
                    obj = null;
                } catch (Throwable e2) {
                    com.getpebble.android.common.b.a.f.a("ConnectionManager", "Error sending data", e2);
                    obj = null;
                }
                if (obj != null) {
                    this.b.a.h(this.b.b);
                } else {
                    this.b.a.i(this.b.b);
                }
            }
        });
    }

    private void f() {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        while (!this.c) {
            Object obj;
            int i = 0;
            do {
                if (!this.c) {
                    int a = a(allocate.array(), i, allocate.capacity() - i);
                    obj = a > 0 ? 1 : null;
                    if (obj != null) {
                        i += a;
                    }
                    if (obj == null) {
                        break;
                    }
                } else {
                    com.getpebble.android.common.b.a.f.c("ConnectionManager", "doInput: mDisconnectRequested requested at header read; returning");
                    return;
                }
            } while (i < allocate.capacity());
            if (obj == null) {
                com.getpebble.android.common.b.a.f.a("ConnectionManager", "end of input signalled, this will prevent further communications from the Pebble");
                c();
                return;
            }
            try {
                allocate.position(0);
                short longValue = (short) ((int) com.getpebble.android.bluetooth.b.b.b(allocate).longValue());
                short longValue2 = (short) ((int) com.getpebble.android.bluetooth.b.b.b(allocate).longValue());
                if (longValue < (short) 1) {
                    com.getpebble.android.common.b.a.f.a("ConnectionManager", "body length is invalid for incoming message: " + longValue);
                    c();
                    return;
                }
                byte[] bArr = new byte[longValue];
                i = 0;
                while (!this.c) {
                    int a2 = a(bArr, i, bArr.length - i);
                    obj = a2 > 0 ? 1 : null;
                    if (obj != null) {
                        i += a2;
                    }
                    if (obj != null) {
                        if (r0 >= longValue) {
                        }
                    }
                    if (obj == null) {
                        com.getpebble.android.common.b.a.f.a("ConnectionManager", "end of input signalled, this will prevent further communications from the Pebble");
                        c();
                        return;
                    }
                    if (this.i) {
                        com.getpebble.android.common.b.a.f.d("ConnectionManager", "Received length = " + longValue + " data = " + com.getpebble.android.bluetooth.b.b.c(allocate.array()) + " " + com.getpebble.android.bluetooth.b.b.c(bArr));
                    }
                    b(new b(longValue2, bArr));
                }
                com.getpebble.android.common.b.a.f.c("ConnectionManager", "doInput: mDisconnectRequested requested at body read; returning");
                return;
            } catch (Exception e) {
                com.getpebble.android.common.b.a.f.a("ConnectionManager", "input problem will prevent further communications from the Pebble" + d.a(e, 2));
                c();
                return;
            }
        }
        com.getpebble.android.common.b.a.f.d("ConnectionManager", "doInput() completed!");
    }

    protected void b(b bVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.a.b(this.b, bVar);
        elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime > 100) {
            com.getpebble.android.common.b.a.f.d("ConnectionManager", "bt callbacks for " + a.fromCode(bVar.a()) + " took " + elapsedRealtime + "ms");
        } else if (elapsedRealtime > 40) {
            com.getpebble.android.common.b.a.f.e("ConnectionManager", "bt callbacks for " + a.fromCode(bVar.a()) + " took " + elapsedRealtime + "ms");
        }
        e.a(e.a.BT_MESSAGE_RECEIVE, com.getpebble.android.bluetooth.h.b.a().getContentResolver());
    }
}
