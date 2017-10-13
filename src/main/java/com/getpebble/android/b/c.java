package com.getpebble.android.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.h.d;
import com.getpebble.android.bluetooth.h.h;
import com.getpebble.android.common.b.a.f;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public abstract class c extends BroadcastReceiver implements com.getpebble.android.b.b.a, com.getpebble.android.bluetooth.c.a.a, com.getpebble.android.bluetooth.h.b, d {
    public static final long[] a = new long[]{1000, 2000, 4000, 8000, 32000, 64000, 128000, 256000, 512000, 900000};
    private static final long k = TimeUnit.MINUTES.toMillis(1);
    private static final SimpleDateFormat l = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);
    protected final Map<PebbleDevice, b> b = new HashMap();
    protected final Handler c;
    protected final Handler d;
    protected final Context e;
    protected final com.getpebble.android.bluetooth.h.a f;
    protected final h g;
    protected boolean h;
    protected boolean i;
    private final String j;
    private final com.getpebble.android.bluetooth.h.c m;
    private PendingIntent n;
    private final com.getpebble.android.bluetooth.c.a o;
    private long p;
    private final String q;
    private final c r;
    private Runnable s = new Runnable(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public void run() {
            f.d(this.a.j, "sBackoffRunnable firing");
            this.a.g();
            this.a.c(false);
        }
    };

    protected enum a {
        DISCONNECTED,
        CONNECTING,
        BACKOFF,
        LINK_ESTABLISHED,
        HANDSHAKE_INITIATED,
        HANDSHAKE_FAILED,
        CONNECTED,
        CONNECTED_PRF,
        DISCONNECTING
    }

    protected abstract class b {
        public PebbleDevice a;
        public a b = a.DISCONNECTED;
        public int c;
        final /* synthetic */ c d;
        private a e = a.DISCONNECT;
        private d f = d.DISCONNECTED;
        private d g = d.DISCONNECTED;
        private int h;
        private long i;
        private boolean j = false;
        private long k;

        protected b(c cVar, PebbleDevice pebbleDevice) {
            this.d = cVar;
            this.a = pebbleDevice;
        }

        a a() {
            if (this.d.h) {
                return this.e;
            }
            f.d(this.d.j, "bluetooth disabled; discon forcing temp goal = DISCONNECT for " + this.a);
            return a.DISCONNECT;
        }

        protected void a(a aVar) {
            f.d(this.d.j, "setting private state for " + this.a + " to " + aVar.name());
            this.b = aVar;
            b();
        }

        private void b() {
            if ((this.b == a.CONNECTED || this.b == a.CONNECTED_PRF) && a() == a.CONNECT) {
                this.f = d.CONNECTED;
            } else if (this.b == a.CONNECTING || (a() == a.CONNECT && this.b == a.DISCONNECTED)) {
                this.f = d.CONNECTING;
            } else if (this.b == a.DISCONNECTED) {
                this.f = d.DISCONNECTED;
            }
            if (this.f != this.g) {
                this.g = this.f;
                f.d(this.d.j, "setting public status device = " + this.a + " status = " + this.g);
                this.d.r.a(this.a, this.g);
            }
        }

        public void a(a aVar) {
            f.d(this.d.j, "setting private goal for " + this.a + " to " + aVar.name());
            this.e = aVar;
            this.d.r.a(this.a, aVar);
        }

        public String toString() {
            return this.a + " goal = " + this.e.name() + " state = " + this.b.name();
        }
    }

    public interface c {
        void a(PebbleDevice pebbleDevice, a aVar);

        void a(PebbleDevice pebbleDevice, d dVar);
    }

    protected abstract void a(a aVar);

    protected abstract void a(b bVar);

    protected abstract void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.g.a aVar, boolean z);

    protected abstract void a(PebbleDevice pebbleDevice, String str);

    protected abstract void b();

    protected abstract b d(PebbleDevice pebbleDevice);

    protected abstract String h(PebbleDevice pebbleDevice);

    protected c(Looper looper, Context context, com.getpebble.android.bluetooth.h.c cVar, com.getpebble.android.bluetooth.h.a aVar, h hVar, c cVar2, String str) {
        this.j = "ConnectionStateManager/" + str;
        f.d(this.j, "ConnectionStateManager()");
        if (looper == null) {
            throw new IllegalArgumentException("looper cannot be null");
        } else if (cVar == null) {
            throw new IllegalArgumentException("btConnection cannot be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("btAdapter cannot be null");
        } else if (cVar2 == null) {
            throw new IllegalArgumentException("connectionStatusUpdater cannot be null");
        } else {
            this.e = context;
            this.c = new Handler(looper);
            this.d = new Handler(Looper.getMainLooper());
            this.m = cVar;
            this.f = aVar;
            this.g = hVar;
            this.r = cVar2;
            this.e.registerReceiver(this, new IntentFilter("com.getpebble.android.ACTION_BACKOFF_EXPIRED"));
            this.f.a((com.getpebble.android.bluetooth.h.b) this);
            this.m.a(this);
            this.h = this.f.e();
            this.o = c();
            this.q = com.getpebble.android.common.a.K().getPackageName();
            b();
        }
    }

    protected com.getpebble.android.bluetooth.c.a c() {
        return new com.getpebble.android.bluetooth.c.a(this);
    }

    protected Context d() {
        return this.e;
    }

    public synchronized void e(PebbleDevice pebbleDevice) {
        b bVar;
        f.d(this.j, "connectToDevice() = " + pebbleDevice);
        this.i = false;
        b bVar2 = (b) this.b.get(pebbleDevice);
        if (bVar2 == null) {
            f.d(this.j, ".. creating state record for " + pebbleDevice);
            bVar2 = d(pebbleDevice);
            this.b.put(pebbleDevice, bVar2);
            bVar = bVar2;
        } else {
            f.d(this.j, ".. previous state: " + bVar2);
            bVar2.a = pebbleDevice;
            bVar = bVar2;
        }
        for (PebbleDevice pebbleDevice2 : this.b.keySet()) {
            if (!pebbleDevice2.equals(pebbleDevice)) {
                b bVar3 = (b) this.b.get(pebbleDevice2);
                if (!(bVar3 == null || bVar3.e == a.DISCONNECT)) {
                    f.d(this.j, ".. setting other device " + pebbleDevice2 + " goal to DISCONNECT");
                    bVar3.a(a.DISCONNECT);
                }
            }
        }
        bVar.a(a.CONNECT);
        bVar.b();
        bVar.h = 0;
        bVar.c = 0;
        e();
    }

    public synchronized void f(PebbleDevice pebbleDevice) {
        f.d(this.j, "disconnectFromDevice() = " + pebbleDevice);
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.b(this.j, ".. no state record exists for " + pebbleDevice + ", so can't disconnect");
        } else {
            f.d(this.j, ".. previous state: " + bVar);
            bVar.a = pebbleDevice;
            bVar.a(a.DISCONNECT);
            e();
        }
    }

    public synchronized void b(boolean z) {
        c(z);
    }

    protected synchronized void e() {
        c(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void c(boolean r9) {
        /*
        r8 = this;
        r4 = 0;
        r3 = 1;
        monitor-enter(r8);
        r0 = r8.j;	 Catch:{ all -> 0x00f5 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f5 }
        r1.<init>();	 Catch:{ all -> 0x00f5 }
        r2 = "processState() ignoreBackoff = ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x00f5 }
        r1 = r1.append(r9);	 Catch:{ all -> 0x00f5 }
        r1 = r1.toString();	 Catch:{ all -> 0x00f5 }
        com.getpebble.android.common.b.a.f.d(r0, r1);	 Catch:{ all -> 0x00f5 }
        r0 = r8.b;	 Catch:{ all -> 0x00f5 }
        r0 = r0.keySet();	 Catch:{ all -> 0x00f5 }
        r5 = r0.iterator();	 Catch:{ all -> 0x00f5 }
        r2 = r4;
    L_0x0026:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00f5 }
        if (r0 == 0) goto L_0x0074;
    L_0x002c:
        r0 = r5.next();	 Catch:{ all -> 0x00f5 }
        r0 = (com.getpebble.android.bluetooth.PebbleDevice) r0;	 Catch:{ all -> 0x00f5 }
        r1 = r8.b;	 Catch:{ all -> 0x00f5 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x00f5 }
        r1 = (com.getpebble.android.b.c.b) r1;	 Catch:{ all -> 0x00f5 }
        if (r1 == 0) goto L_0x0051;
    L_0x003c:
        r6 = r1.a();	 Catch:{ all -> 0x00f5 }
        r7 = com.getpebble.android.b.a.DISCONNECT;	 Catch:{ all -> 0x00f5 }
        if (r6 != r7) goto L_0x0051;
    L_0x0044:
        r6 = com.getpebble.android.b.c.AnonymousClass2.a;	 Catch:{ all -> 0x00f5 }
        r1 = r1.b;	 Catch:{ all -> 0x00f5 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x00f5 }
        r1 = r6[r1];	 Catch:{ all -> 0x00f5 }
        switch(r1) {
            case 1: goto L_0x0054;
            case 2: goto L_0x0056;
            case 3: goto L_0x005b;
            case 4: goto L_0x0061;
            case 5: goto L_0x0066;
            case 6: goto L_0x0068;
            case 7: goto L_0x006d;
            case 8: goto L_0x006d;
            case 9: goto L_0x0072;
            default: goto L_0x0051;
        };	 Catch:{ all -> 0x00f5 }
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r2 = r0;
        goto L_0x0026;
    L_0x0054:
        r0 = r2;
        goto L_0x0052;
    L_0x0056:
        r8.j(r0);	 Catch:{ all -> 0x00f5 }
        r0 = r3;
        goto L_0x0052;
    L_0x005b:
        r1 = 1;
        r8.a(r0, r1);	 Catch:{ all -> 0x00f5 }
        r0 = r2;
        goto L_0x0052;
    L_0x0061:
        r8.j(r0);	 Catch:{ all -> 0x00f5 }
        r0 = r3;
        goto L_0x0052;
    L_0x0066:
        r0 = r3;
        goto L_0x0052;
    L_0x0068:
        r8.j(r0);	 Catch:{ all -> 0x00f5 }
        r0 = r3;
        goto L_0x0052;
    L_0x006d:
        r8.j(r0);	 Catch:{ all -> 0x00f5 }
        r0 = r3;
        goto L_0x0052;
    L_0x0072:
        r0 = r3;
        goto L_0x0052;
    L_0x0074:
        if (r2 == 0) goto L_0x007f;
    L_0x0076:
        r0 = r8.j;	 Catch:{ all -> 0x00f5 }
        r1 = "waiting for disconnect; exiting state machine";
        com.getpebble.android.common.b.a.f.d(r0, r1);	 Catch:{ all -> 0x00f5 }
    L_0x007d:
        monitor-exit(r8);
        return;
    L_0x007f:
        r0 = r8.b;	 Catch:{ all -> 0x00f5 }
        r0 = r0.keySet();	 Catch:{ all -> 0x00f5 }
        r5 = r0.iterator();	 Catch:{ all -> 0x00f5 }
        r2 = r4;
    L_0x008a:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00f5 }
        if (r0 == 0) goto L_0x0106;
    L_0x0090:
        r0 = r5.next();	 Catch:{ all -> 0x00f5 }
        r0 = (com.getpebble.android.bluetooth.PebbleDevice) r0;	 Catch:{ all -> 0x00f5 }
        r1 = r8.b;	 Catch:{ all -> 0x00f5 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x00f5 }
        r1 = (com.getpebble.android.b.c.b) r1;	 Catch:{ all -> 0x00f5 }
        if (r1 == 0) goto L_0x008a;
    L_0x00a0:
        r4 = r1.a();	 Catch:{ all -> 0x00f5 }
        r6 = com.getpebble.android.b.a.CONNECT;	 Catch:{ all -> 0x00f5 }
        if (r4 != r6) goto L_0x00b5;
    L_0x00a8:
        r4 = com.getpebble.android.b.c.AnonymousClass2.a;	 Catch:{ all -> 0x00f5 }
        r6 = r1.b;	 Catch:{ all -> 0x00f5 }
        r6 = r6.ordinal();	 Catch:{ all -> 0x00f5 }
        r4 = r4[r6];	 Catch:{ all -> 0x00f5 }
        switch(r4) {
            case 1: goto L_0x00b8;
            case 2: goto L_0x00bd;
            case 3: goto L_0x00bf;
            case 4: goto L_0x00f8;
            case 5: goto L_0x00fd;
            case 6: goto L_0x00ff;
            case 7: goto L_0x0104;
            case 8: goto L_0x0104;
            default: goto L_0x00b5;
        };	 Catch:{ all -> 0x00f5 }
    L_0x00b5:
        r0 = r2;
    L_0x00b6:
        r2 = r0;
        goto L_0x008a;
    L_0x00b8:
        r8.i(r0);	 Catch:{ all -> 0x00f5 }
        r0 = r2;
        goto L_0x00b6;
    L_0x00bd:
        r0 = r3;
        goto L_0x00b6;
    L_0x00bf:
        r4 = r8.l(r0);	 Catch:{ all -> 0x00f5 }
        if (r4 != 0) goto L_0x00c7;
    L_0x00c5:
        if (r9 == 0) goto L_0x00de;
    L_0x00c7:
        r4 = 0;
        r8.a(r0, r4);	 Catch:{ all -> 0x00f5 }
        r8.i(r0);	 Catch:{ all -> 0x00f5 }
    L_0x00ce:
        r0 = r1.a;	 Catch:{ all -> 0x00f5 }
        r0 = r0.getTransport();	 Catch:{ all -> 0x00f5 }
        r1 = com.getpebble.android.bluetooth.Transport.CLASSIC;	 Catch:{ all -> 0x00f5 }
        r0 = r0.equals(r1);	 Catch:{ all -> 0x00f5 }
        if (r0 == 0) goto L_0x00b5;
    L_0x00dc:
        r0 = r3;
        goto L_0x00b6;
    L_0x00de:
        r8.k(r0);	 Catch:{ all -> 0x00f5 }
        r0 = r1.a;	 Catch:{ all -> 0x00f5 }
        r0 = r0.getTransport();	 Catch:{ all -> 0x00f5 }
        r4 = com.getpebble.android.bluetooth.Transport.CLASSIC;	 Catch:{ all -> 0x00f5 }
        r0 = r0.equals(r4);	 Catch:{ all -> 0x00f5 }
        if (r0 == 0) goto L_0x00ce;
    L_0x00ef:
        r0 = r8.o;	 Catch:{ all -> 0x00f5 }
        r0.a();	 Catch:{ all -> 0x00f5 }
        goto L_0x00ce;
    L_0x00f5:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00f8:
        r8.g(r0);	 Catch:{ all -> 0x00f5 }
        r0 = r2;
        goto L_0x00b6;
    L_0x00fd:
        r0 = r2;
        goto L_0x00b6;
    L_0x00ff:
        r8.j(r0);	 Catch:{ all -> 0x00f5 }
        r0 = r2;
        goto L_0x00b6;
    L_0x0104:
        r0 = r2;
        goto L_0x00b6;
    L_0x0106:
        if (r2 != 0) goto L_0x007d;
    L_0x0108:
        r0 = r8.o;	 Catch:{ all -> 0x00f5 }
        r0.b();	 Catch:{ all -> 0x00f5 }
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.b.c.c(boolean):void");
    }

    protected final void g(PebbleDevice pebbleDevice) {
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.a(this.j, "initiateHandshake() device state not found! device = " + pebbleDevice);
            return;
        }
        f.d(this.j, "actionInitiateHandshake: " + pebbleDevice);
        bVar.a(a.HANDSHAKE_INITIATED);
        a(bVar);
    }

    private void i(PebbleDevice pebbleDevice) {
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.a(this.j, "internalConnect() device state not found! device = " + pebbleDevice);
            return;
        }
        bVar.c++;
        f.d(this.j, "connect call " + bVar.c + " for " + pebbleDevice);
        this.m.e(pebbleDevice);
        try {
            if (this.m.a(pebbleDevice, h(pebbleDevice))) {
                bVar.a(a.CONNECTING);
                return;
            }
            f.c(this.j, "connect call failed: revert to DISCONNECT");
            if (this.h) {
                bVar.a(a.DISCONNECT);
            }
        } catch (Throwable e) {
            f.b(this.j, "error connecting", e);
            if (this.h) {
                bVar.a(a.DISCONNECT);
            }
        }
    }

    private void j(PebbleDevice pebbleDevice) {
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.a(this.j, "internalDisconnect() device state not found! device = " + pebbleDevice);
            return;
        }
        f.d(this.j, "disconnect call for " + pebbleDevice);
        if (this.m.c(pebbleDevice)) {
            bVar.a(a.DISCONNECTING);
        }
    }

    private void k(PebbleDevice pebbleDevice) {
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.a(this.j, "processBackoff() device state not found! device = " + pebbleDevice);
            return;
        }
        long elapsedRealtime;
        if (!bVar.j) {
            elapsedRealtime = SystemClock.elapsedRealtime();
            f.d(this.j, "actionProcessBackoff init for " + pebbleDevice + " period = " + a[bVar.h] + " ms");
            bVar.i = elapsedRealtime + a[bVar.h];
            bVar.j = true;
            if (pebbleDevice.getTransport().equals(Transport.LE) && bVar.h >= 5) {
                this.m.d(pebbleDevice);
            }
            if (bVar.h < a.length - 1) {
                bVar.h = bVar.h + 1;
            }
        }
        g();
        this.c.postDelayed(this.s, (bVar.i - SystemClock.currentThreadTimeMillis()) + 5);
        AlarmManager alarmManager = (AlarmManager) this.e.getApplicationContext().getSystemService("alarm");
        Intent intent = new Intent("com.getpebble.android.ACTION_BACKOFF_EXPIRED");
        intent.setPackage(this.q);
        this.n = PendingIntent.getBroadcast(this.e, 0, intent, 0);
        elapsedRealtime = bVar.i + 5;
        if (VERSION.SDK_INT < 19) {
            alarmManager.set(2, elapsedRealtime, this.n);
        } else if (bVar.h <= 5) {
            alarmManager.setExact(2, elapsedRealtime, this.n);
        } else {
            long j = a[bVar.h - 1] / 5;
            if (j > 60000) {
                j = 60000;
            }
            alarmManager.setWindow(2, elapsedRealtime, j + elapsedRealtime, this.n);
        }
    }

    public void onReceive(Context context, Intent intent) {
        f.d(this.j, "onReceive alarm callback");
        g();
        c(false);
    }

    private boolean l(PebbleDevice pebbleDevice) {
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.a(this.j, "isBackoffExpired() device state not found! device = " + pebbleDevice);
            return false;
        } else if (bVar.j) {
            return SystemClock.elapsedRealtime() >= bVar.i;
        } else {
            return false;
        }
    }

    private void a(PebbleDevice pebbleDevice, boolean z) {
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.a(this.j, "cancelBackoff() device state not found! device = " + pebbleDevice);
            return;
        }
        f.d(this.j, "actionCancelBackoff for " + pebbleDevice + " setStateDisconnected = " + z);
        if (z) {
            bVar.a(a.DISCONNECTED);
        }
        this.m.e(pebbleDevice);
        g();
        bVar.j = false;
    }

    private void g() {
        this.c.removeCallbacks(this.s);
        if (this.n != null) {
            ((AlarmManager) this.e.getApplicationContext().getSystemService("alarm")).cancel(this.n);
            this.n = null;
        }
    }

    public synchronized void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.g.a aVar) {
        boolean z = false;
        synchronized (this) {
            b bVar = (b) this.b.get(pebbleDevice);
            if (bVar == null) {
                f.a(this.j, "onDeviceConnectionResult() device state not found! device = " + pebbleDevice);
            } else {
                switch (aVar.a) {
                    case SUCCESS:
                        bVar.a(a.LINK_ESTABLISHED);
                        bVar.k = System.currentTimeMillis();
                        break;
                    case NOT_AVAILABLE:
                        bVar.a(a.BACKOFF);
                        break;
                    case TIMEOUT:
                        if (this.h) {
                            bVar.a(a.DISCONNECT);
                            z = true;
                        }
                        bVar.a(a.DISCONNECTED);
                        break;
                    case NOT_BONDED:
                        if (this.h && System.currentTimeMillis() - this.p > k) {
                            bVar.a(a.DISCONNECT);
                            bVar.a(a.DISCONNECTED);
                            z = true;
                            break;
                        }
                        bVar.a(a.BACKOFF);
                        break;
                }
                if (!com.getpebble.android.bluetooth.g.a.a.SUCCESS.equals(aVar.a)) {
                    a(pebbleDevice, aVar, z);
                }
                if (pebbleDevice.getTransport().equals(Transport.LE) && com.getpebble.android.bluetooth.b.d.ADDRESS_CHANGED.equals(aVar.b)) {
                    String str = aVar.c;
                    if (str == null) {
                        f.f(this.j, "onDeviceConnectionResult: newAddress is null for ADDRESS_CHANGED!!");
                    } else if (str.equals(pebbleDevice.getAddress())) {
                        f.f(this.j, "onDeviceConnectionResult: newAddress is equal to existing address for ADDRESS_CHANGED!!");
                    } else {
                        a(pebbleDevice, str);
                        f.d(this.j, "onDeviceConnectionResult: switching devices in connection map before retrying with new address...");
                        bVar.a = new PebbleDevice(pebbleDevice.getName(), str, pebbleDevice.getTransport());
                        bVar.h = 0;
                        this.b.put(bVar.a, bVar);
                        this.b.remove(pebbleDevice);
                    }
                }
                e();
            }
        }
    }

    public void c(PebbleDevice pebbleDevice) {
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.a(this.j, "onDeviceConnectionResult() device state not found! device = " + pebbleDevice);
            return;
        }
        bVar.a(a.LINK_ESTABLISHED);
        bVar.k = System.currentTimeMillis();
        e();
    }

    public synchronized void a(PebbleDevice pebbleDevice) {
        b bVar = (b) this.b.get(pebbleDevice);
        if (bVar == null) {
            f.a(this.j, "deviceDisconnectedCallback() device state not found! device = " + pebbleDevice);
        } else {
            long currentTimeMillis = System.currentTimeMillis() - bVar.k;
            l.setTimeZone(TimeZone.getTimeZone("UTC"));
            f.d(this.j, "onDeviceDisconnected for " + pebbleDevice + " connected for " + l.format(Long.valueOf(currentTimeMillis)));
            bVar.a(a.DISCONNECTED);
            bVar.h = 0;
            bVar.c = 0;
            a(bVar.e);
            e();
        }
    }

    public void b(PebbleDevice pebbleDevice) {
        f.d(this.j, "PBL-37581 onReconnectScanFound (device: " + pebbleDevice.toString() + ")");
        c(true);
    }

    protected long f() {
        return (System.currentTimeMillis() - this.p) / 1000;
    }

    public synchronized void a(boolean z) {
        f.d(this.j, "onAdapterStateChanged() enabled = " + z);
        this.h = z;
        if (z) {
            this.p = System.currentTimeMillis();
        }
        c(true);
    }

    public synchronized void a() {
        c(true);
    }

    public void a(String str) {
        c(true);
    }
}
