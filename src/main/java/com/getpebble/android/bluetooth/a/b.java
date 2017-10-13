package com.getpebble.android.bluetooth.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.bluetooth.c;
import com.getpebble.android.bluetooth.e;
import com.getpebble.android.common.b.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class b extends c {
    static PebbleDevice g;
    private com.getpebble.android.bluetooth.j.c h;
    private boolean i;
    private final com.getpebble.android.bluetooth.d.a j;
    private CountDownLatch k = new CountDownLatch(1);
    private long l = 30000;
    private Handler m = new Handler(Looper.getMainLooper());
    private boolean n = false;
    private InputStream o;
    private OutputStream p;
    private boolean q = false;
    private com.getpebble.android.bluetooth.g.a.a r;
    private d s;
    private Runnable t = new Runnable(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void run() {
            f.c("ClassicDeviceConnector", "Blocking connect timeout");
            this.a.m.postDelayed(this.a.u, 2000);
            this.a.l();
            this.a.r = com.getpebble.android.bluetooth.g.a.a.TIMEOUT;
            this.a.s = d.CONNECT_TIMEOUT_BLOCKING;
        }
    };
    private Runnable u = new Runnable(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void run() {
            f.c("ClassicDeviceConnector", "Blocking connect timeout cleanup timeout");
            this.a.f();
            this.a.r = com.getpebble.android.bluetooth.g.a.a.TIMEOUT;
        }
    };

    class a extends Exception {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }
    }

    private boolean b(boolean r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        r2 = "ClassicDeviceConnector";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "doConnectWithDiagnosisUnpairRetry: firstAttempt = ";
        r3 = r3.append(r4);
        r3 = r3.append(r7);
        r3 = r3.toString();
        com.getpebble.android.common.b.a.f.d(r2, r3);
        r2 = r6.d;
        r2 = r2.getAddress();
        r6.a(r2);
        r2 = r6.a(r7);
        if (r2 != 0) goto L_0x003e;
    L_0x0029:
        r1 = "ClassicDeviceConnector";
        r2 = "Bonding process failed; aborting";
        com.getpebble.android.common.b.a.f.d(r1, r2);
        r1 = com.getpebble.android.bluetooth.h.e.a.PAIRING_FAIL;
        r2 = com.getpebble.android.bluetooth.h.b.a();
        r2 = r2.getContentResolver();
        com.getpebble.android.bluetooth.h.e.a(r1, r2);
    L_0x003d:
        return r0;
    L_0x003e:
        r6.m();	 Catch:{ IOException -> 0x0074 }
        r2 = r6.m;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = r6.t;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r4 = r6.j();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2.postDelayed(r3, r4);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r6.k();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = "ClassicDeviceConnector";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = "Connected; removing timeout";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.common.b.a.f.d(r2, r3);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = r6.m;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = r6.t;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2.removeCallbacks(r3);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = r6.m;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = r6.u;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2.removeCallbacks(r3);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r0 = r6.m;
        r2 = r6.t;
        r0.removeCallbacks(r2);
        r0 = r6.m;
        r2 = r6.u;
        r0.removeCallbacks(r2);
        r0 = r1;
        goto L_0x003d;
    L_0x0074:
        r1 = move-exception;
        r2 = "ClassicDeviceConnector";
        r3 = "Error creating socket";
        com.getpebble.android.common.b.a.f.a(r2, r3, r1);
        r1 = com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE;
        r6.r = r1;
        r1 = com.getpebble.android.bluetooth.b.d.CREATE_SOCKET;
        r6.s = r1;
        goto L_0x003d;
    L_0x0085:
        r1 = move-exception;
        r2 = "ClassicDeviceConnector";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3.<init>();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r4 = "Could not connect to socket";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r4 = 4;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r4 = com.getpebble.android.common.b.a.d.a(r1, r4);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.common.b.a.f.d(r2, r3);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = r6.m;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = r6.t;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2.removeCallbacks(r3);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = r6.m;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = r6.u;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2.removeCallbacks(r3);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r6.a(r1);	 Catch:{ a -> 0x00d4 }
        r1 = r6.n;	 Catch:{ a -> 0x00d4 }
        if (r1 == 0) goto L_0x00bc;	 Catch:{ a -> 0x00d4 }
    L_0x00b8:
        r1 = com.getpebble.android.bluetooth.b.d.CANCELLED;	 Catch:{ a -> 0x00d4 }
        r6.s = r1;	 Catch:{ a -> 0x00d4 }
    L_0x00bc:
        r1 = r6.m;
        r2 = r6.t;
        r1.removeCallbacks(r2);
        r1 = r6.m;
        r2 = r6.u;
        r1.removeCallbacks(r2);
    L_0x00ca:
        r1 = r6.r;
        if (r1 != 0) goto L_0x003d;
    L_0x00ce:
        r1 = com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE;
        r6.r = r1;
        goto L_0x003d;
    L_0x00d4:
        r1 = move-exception;
        r1 = com.getpebble.android.bluetooth.h.e.a.DODGY_PAIRING;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = com.getpebble.android.bluetooth.h.b.a();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = r2.getContentResolver();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.bluetooth.h.e.a(r1, r2);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r6.i;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        if (r1 == 0) goto L_0x0169;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x00e6:
        r1 = r6.d;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = 1;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.bluetooth.h.a.a.a(r1, r2);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        if (r7 == 0) goto L_0x0153;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x00ee:
        r1 = r6.o();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        if (r1 == 0) goto L_0x0153;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x00f4:
        r1 = "ClassicDeviceConnector";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = "BPE: removing bond then retrying";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.common.b.a.f.d(r1, r2);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = com.getpebble.android.bluetooth.h.e.a.DODGY_PAIRING_UNPAIRING;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = com.getpebble.android.bluetooth.h.b.a();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = r2.getContentResolver();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.bluetooth.h.e.a(r1, r2);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r6.a;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r1.j();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        if (r1 == 0) goto L_0x014c;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x0110:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r6.a(r2);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        if (r1 == 0) goto L_0x0130;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x0118:
        r6.l();	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r0 = 0;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r0 = r6.b(r0);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r6.m;
        r2 = r6.t;
        r1.removeCallbacks(r2);
        r1 = r6.m;
        r2 = r6.u;
        r1.removeCallbacks(r2);
        goto L_0x003d;
    L_0x0130:
        r1 = r6.r;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        if (r1 != 0) goto L_0x0138;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x0134:
        r1 = com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r6.r = r1;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x0138:
        r1 = com.getpebble.android.bluetooth.b.d.DODGY_PAIRING;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r6.s = r1;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r6.m;
        r2 = r6.t;
        r1.removeCallbacks(r2);
        r1 = r6.m;
        r2 = r6.u;
        r1.removeCallbacks(r2);
        goto L_0x003d;
    L_0x014c:
        r1 = "ClassicDeviceConnector";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = "removeBond failed; not retrying...";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.common.b.a.f.d(r1, r2);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x0153:
        r1 = com.getpebble.android.bluetooth.b.d.DODGY_PAIRING;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r6.s = r1;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        goto L_0x00bc;
    L_0x0159:
        r0 = move-exception;
        r1 = r6.m;
        r2 = r6.t;
        r1.removeCallbacks(r2);
        r1 = r6.m;
        r2 = r6.u;
        r1.removeCallbacks(r2);
        throw r0;
    L_0x0169:
        r1 = "ClassicDeviceConnector";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = "BPE: let CSM retry once";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.common.b.a.f.d(r1, r2);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r6.d;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = 0;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.bluetooth.h.a.a.a(r1, r2);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r6.d;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        g = r1;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = com.getpebble.android.bluetooth.b.d.DODGY_PAIRING;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r6.s = r1;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        goto L_0x00bc;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
    L_0x0180:
        r1 = move-exception;	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r2 = "ClassicDeviceConnector";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r3 = "Failed to connect to device";	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        com.getpebble.android.common.b.a.f.d(r2, r3, r1);	 Catch:{ IOException -> 0x0085, NullPointerException -> 0x0180, all -> 0x0159 }
        r1 = r6.m;
        r2 = r6.t;
        r1.removeCallbacks(r2);
        r1 = r6.m;
        r2 = r6.u;
        r1.removeCallbacks(r2);
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.bluetooth.a.b.b(boolean):boolean");
    }

    public static b a(PebbleDevice pebbleDevice, e eVar, Context context, com.getpebble.android.bluetooth.j.a aVar, com.getpebble.android.bluetooth.d.a aVar2) {
        return new b(pebbleDevice, aVar.a(pebbleDevice.getAddress()), eVar, context, aVar, aVar2);
    }

    b(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.j.b bVar, e eVar, Context context, com.getpebble.android.bluetooth.j.a aVar, com.getpebble.android.bluetooth.d.a aVar2) {
        super(pebbleDevice, bVar, eVar, context, aVar);
        this.j = aVar2;
    }

    protected void e() {
        l();
    }

    private void l() {
        if (this.h != null) {
            try {
                this.h.a();
            } catch (Throwable e) {
                f.b("ClassicDeviceConnector", "closeSocket: error", e);
            }
        }
    }

    public void f() {
        if (this.n) {
            f.c("ClassicDeviceConnector", "cancel(); already cancelling");
            return;
        }
        f.d("ClassicDeviceConnector", "cancel()");
        this.n = true;
        this.k.countDown();
        l();
    }

    public void g() {
        f.d("ClassicDeviceConnector", "connect()");
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public boolean doInBackground() {
                this.a.i();
                return true;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    protected void i() {
        this.i = this.d.equals(g);
        g = null;
        f.d("ClassicDeviceConnector", "connectInBackground: mThisDeviceHadDodyPairingDuringLastAttempt = " + this.i);
        boolean b = b(true);
        if (this.n) {
            f.d("ClassicDeviceConnector", "Returning failure because cancelled");
            if (this.r == null) {
                this.r = com.getpebble.android.bluetooth.g.a.a.NOT_AVAILABLE;
                this.s = d.CANCELLED;
            }
            b = false;
        }
        if (b) {
            a(a(this.o, this.p));
        } else {
            a(new com.getpebble.android.bluetooth.g.a(this.r, this.s));
        }
    }

    protected com.getpebble.android.bluetooth.f a(InputStream inputStream, OutputStream outputStream) {
        return new a(this.d, inputStream, outputStream, this.h, this.e);
    }

    protected void c() {
        this.q = true;
        this.k.countDown();
    }

    protected void d() {
        this.q = false;
        this.k.countDown();
    }

    private void m() {
        if (this.h != null) {
            f.a("ClassicDeviceConnector", "Existing socket reference was non-null");
            this.h.a();
        }
        this.h = this.a.g();
        if (this.h == null) {
            f.a("ClassicDeviceConnector", "Created null socket (contract violation)");
            throw new IOException("Failed to create IO socket connection!");
        }
    }

    private boolean n() {
        return h() >= 19;
    }

    private boolean o() {
        return true;
    }

    protected int h() {
        return VERSION.SDK_INT;
    }

    private boolean a(boolean z) {
        boolean f;
        if (!z) {
            f.d("ClassicDeviceConnector", "doBondingProcess: resetting countdown latch for 2nd attempt");
            this.k = new CountDownLatch(1);
        }
        try {
            f = this.a.f();
        } catch (com.getpebble.android.bluetooth.j.b.a e) {
            f.d("ClassicDeviceConnector", "Bond init failed once; retry bond init after delay");
            if (a(1000)) {
                try {
                    f = this.a.f();
                } catch (Throwable e2) {
                    f.b("ClassicDeviceConnector", "Bond init failed twice", e2);
                    this.r = com.getpebble.android.bluetooth.g.a.a.NOT_BONDED;
                    this.s = d.BONDING_FAILED_CREATE_BOND;
                    return false;
                }
            }
            f.b("ClassicDeviceConnector", "Interrupted during bond retry delay sleep");
            this.r = com.getpebble.android.bluetooth.g.a.a.NOT_BONDED;
            this.s = d.BONDING_FAILED_CREATE_BOND;
            return false;
        }
        if (this.n) {
            f.d("ClassicDeviceConnector", "doBondingProcess: mIsCancelling; aborting");
            return false;
        }
        if (f) {
            f.d("ClassicDeviceConnector", "Need to wait on the bond!");
            try {
                this.k.await(this.l, TimeUnit.MILLISECONDS);
                f.d("ClassicDeviceConnector", "Bond wait complete");
            } catch (Throwable e3) {
                f.a("ClassicDeviceConnector", "bonding latch interrupted", e3);
            }
            if (!this.q) {
                f.b("ClassicDeviceConnector", "Pairing not finished; abort connection");
                this.r = com.getpebble.android.bluetooth.g.a.a.NOT_BONDED;
                this.s = d.BONDING_FAILED_TIMEOUT;
                return false;
            }
        }
        if (!this.a.h()) {
            f.b("ClassicDeviceConnector", "Device not bonded - this is not expected at this point - wait then retry the check");
            if (!a(1000)) {
                f.b("ClassicDeviceConnector", "Interrupted during bond check retry delay sleep");
                this.r = com.getpebble.android.bluetooth.g.a.a.NOT_BONDED;
                this.s = d.BONDING_FAILED_TIMEOUT;
                return false;
            } else if (!this.a.h()) {
                f.b("ClassicDeviceConnector", "Device not bonded after 2nd check");
                this.r = com.getpebble.android.bluetooth.g.a.a.NOT_BONDED;
                this.s = d.BONDING_FAILED_TIMEOUT;
                return false;
            }
        }
        if (f && n()) {
            f.d("ClassicDeviceConnector", "KitKat post-bond hack sleep...");
            if (a(500)) {
                f.d("ClassicDeviceConnector", "Finished kitkat post-bond delay");
            } else {
                f.c("ClassicDeviceConnector", "Interrupted during post-bond delay");
                return false;
            }
        }
        return true;
    }

    protected boolean a(long j) {
        try {
            Thread.sleep(j);
            return true;
        } catch (Throwable e) {
            f.d("ClassicDeviceConnector", "Sleep was interrupted", e);
            return false;
        }
    }

    protected void a(IOException iOException) {
        try {
            StackTraceElement[] stackTrace = iOException.getStackTrace();
            if (stackTrace[1].getMethodName().equals("waitSocketSignal")) {
                f.d("ClassicDeviceConnector", "> diagnoseConnectionFailure: dodgy pairing");
                throw new a(this);
            } else if (stackTrace[1].getMethodName().equals("readInt")) {
                f.d("ClassicDeviceConnector", "> diagnoseConnectionFailure: device not available");
                this.s = d.NOT_AVAILABLE;
            } else if (stackTrace[0].getMethodName().equals("connectNative")) {
                f.d("ClassicDeviceConnector", "> diagnoseConnectionFailure: device not available (after SDP workaround)");
                this.s = d.NOT_AVAILABLE;
            } else {
                f.d("ClassicDeviceConnector", "> diagnoseConnectionFailure: unknown: -");
                for (int i = 0; i < stackTrace.length; i++) {
                    f.d("ClassicDeviceConnector", "> " + i + ": " + stackTrace[i].getMethodName() + " (" + stackTrace[i].getLineNumber() + ")");
                }
                if (this.s == null) {
                    this.s = d.NOT_AVAILABLE;
                }
            }
        } catch (a e) {
            throw e;
        } catch (Exception e2) {
            f.d("ClassicDeviceConnector", "> diagnoseConnectionFailure failed internally: ", iOException);
        }
    }

    protected long j() {
        return 45000;
    }

    void k() {
        if (this.h != null) {
            this.h.b();
            this.o = this.h.c();
            this.p = this.h.d();
            return;
        }
        f.a("ClassicDeviceConnector", "Failed to create a socket; bluetooth socket is null!");
        throw new IOException("Failed to create a socket; bluetooth socket is null!");
    }
}
