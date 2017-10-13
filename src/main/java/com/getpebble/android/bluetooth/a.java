package com.getpebble.android.bluetooth;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.common.b.a.f;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    private static final AtomicInteger b = new AtomicInteger(0);
    private static final long c = TimeUnit.SECONDS.toMillis(10);
    private static final long d = TimeUnit.SECONDS.toMillis(2);
    protected long a;
    private final com.getpebble.android.bluetooth.j.a e;
    private final a f;
    private final Handler g = new Handler(Looper.getMainLooper());

    interface b {
        void a(boolean z);
    }

    public enum a {
        ALWAYS_RESET,
        RESET_IF_NOTHING_CONNECTED,
        NOTIFY_USER,
        DO_NOTHING
    }

    a(com.getpebble.android.bluetooth.j.a aVar, a aVar2) {
        this.e = aVar;
        this.f = aVar2;
    }

    void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
        this.a = 0;
        if (elapsedRealtime > c) {
            f.c("BTResetController", "onAdapterOff: too long (" + elapsedRealtime + ") since disable(); ignoring");
            return;
        }
        f.d("BTResetController", "onAdapterOff: posting task to enable adapter in " + d + " ms");
        a(new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void run() {
                f.d("BTResetController", "Turning on adapter after delay...");
                if (!this.a.e.l()) {
                    f.b("BTResetController", "onAdapterOff: failed to enable adapter!");
                }
            }
        }, d);
    }

    protected void a(Runnable runnable, long j) {
        this.g.postDelayed(runnable, j);
    }

    void a(PebbleDevice pebbleDevice, b bVar) {
        int i = b.get();
        f.d("BTResetController", "resetIfOverThreshold: at <" + i + "> points. Max is " + 10);
        if (i >= 10) {
            c();
            switch (this.f) {
                case ALWAYS_RESET:
                    b(bVar);
                    return;
                case RESET_IF_NOTHING_CONNECTED:
                    if (!a(pebbleDevice)) {
                        b(bVar);
                        return;
                    }
                    break;
                case NOTIFY_USER:
                    break;
                case DO_NOTHING:
                    bVar.a(false);
                    return;
                default:
                    f.f("BTResetController", "Unhandled reset request; mode: " + this.f);
                    return;
            }
            a(bVar);
        }
    }

    void b() {
        b.addAndGet(10);
        a(null, new b(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(boolean z) {
                com.getpebble.android.bluetooth.h.a.a.a(this.a.f, z);
            }
        });
    }

    void a(final PebbleDevice pebbleDevice, final d dVar) {
        int andAdd = b.getAndAdd(dVar.resetPoints);
        if (dVar.resetPoints > 0) {
            f.d("BTResetController", "addResetPointsForReason: was: " + andAdd + " added: " + dVar.resetPoints);
        }
        a(pebbleDevice, new b(this) {
            final /* synthetic */ a c;

            public void a(boolean z) {
                com.getpebble.android.bluetooth.h.a.a.a(pebbleDevice, this.c.f, z, dVar);
            }
        });
    }

    void c() {
        f.d("BTResetController", "resetPointCount: was " + b.getAndSet(0));
    }

    private boolean a(PebbleDevice pebbleDevice) {
        for (com.getpebble.android.bluetooth.j.b bVar : this.e.e()) {
            if (bVar != null) {
                Boolean b = com.getpebble.android.bluetooth.j.b.b(bVar.k());
                if (b != null && b.booleanValue()) {
                    boolean z;
                    if (pebbleDevice == null || !bVar.a().equals(pebbleDevice.getAddress())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        f.d("BTResetController", "anyOtherDeviceConnected: " + bVar.b() + " / " + bVar.a() + " is connected, so not resetting adapter");
                        break;
                    }
                    f.d("BTResetController", "anyOtherDeviceConnected: ignoring " + pebbleDevice + " which is marked as connected");
                }
            } else {
                f.b("BTResetController", "anyOtherDeviceConnected: null device!");
            }
        }
        return false;
    }

    private void b(b bVar) {
        f.c("BTResetController", "doReset()");
        if (this.e.k()) {
            this.a = SystemClock.elapsedRealtime();
            bVar.a(true);
            return;
        }
        f.b("BTResetController", "doReset: failed to disable adapter!");
    }

    protected void a(b bVar) {
        com.getpebble.android.bluetooth.h.b.b();
        bVar.a(false);
    }
}
