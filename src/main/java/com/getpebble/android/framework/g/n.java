package com.getpebble.android.framework.g;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ah;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.v;
import com.getpebble.android.framework.l.a.r;
import com.getpebble.android.framework.l.a.u;
import com.getpebble.android.framework.l.a.x;
import com.google.a.f.e;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class n extends l {
    public static final v a = new v("3.0.0", 0);
    private static final long b = TimeUnit.SECONDS.toMillis(20);
    private final Context c;
    private Handler d;
    private Runnable e = new Runnable(this) {
        final /* synthetic */ n a;

        {
            this.a = r1;
        }

        public void run() {
            f.c("HandshakeEndpointSet", "run: Handshake failed due to timeout");
            this.a.a(d.HANDSHAKE_TIMEOUT);
        }
    };
    private final b f;
    private c g = c.START_WAITING_REQUEST;
    private x h = null;
    private ah i = ah.COLOR_UNKNOWN;
    private UUID j;
    private a k = new a();
    private final w l;
    private final ah m;
    private final ab n;
    private final d o;
    private com.getpebble.android.framework.o.b p;
    private m q;
    private final boolean r;

    public interface b {
        void a(PebbleDevice pebbleDevice, boolean z, boolean z2, d dVar);
    }

    private class a implements a, a, a, a {
        final /* synthetic */ n a;

        private a(n nVar) {
            this.a = nVar;
        }

        public boolean a(r rVar) {
            boolean z;
            synchronized (this.a) {
                if (this.a.g == c.START_WAITING_REQUEST) {
                    f.d("HandshakeEndpointSet", "onReceive: Received phone version response");
                    this.a.n();
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.getpebble.android.framework.l.a.x r8) {
            /*
            r7 = this;
            r1 = r7.a;
            monitor-enter(r1);
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r0 = r0.g;	 Catch:{ all -> 0x003d }
            r2 = com.getpebble.android.framework.g.n.c.VERSION_WAITING;	 Catch:{ all -> 0x003d }
            if (r0 != r2) goto L_0x0164;
        L_0x000d:
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r0.k();	 Catch:{ all -> 0x003d }
            r0 = "HandshakeEndpointSet";
            r2 = "onReceive: Received Pebble version response";
            com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r0.h = r8;	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = r2.h;	 Catch:{ all -> 0x003d }
            r2 = r2.c();	 Catch:{ all -> 0x003d }
            r0.p = r2;	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r0 = r0.q;	 Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0040;
        L_0x0035:
            r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x003d }
            r2 = "onReceive version message: mGetBytesEndpoint was already non-null!";
            r0.<init>(r2);	 Catch:{ all -> 0x003d }
            throw r0;	 Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003d }
            throw r0;
        L_0x0040:
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = new com.getpebble.android.framework.g.m;	 Catch:{ all -> 0x003d }
            r3 = r7.a;	 Catch:{ all -> 0x003d }
            r3 = r3.c;	 Catch:{ all -> 0x003d }
            r4 = r7.a;	 Catch:{ all -> 0x003d }
            r5 = r7.a;	 Catch:{ all -> 0x003d }
            r5 = r5.p;	 Catch:{ all -> 0x003d }
            r6 = 1;
            r2.<init>(r3, r4, r5, r6);	 Catch:{ all -> 0x003d }
            r0.q = r2;	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r0 = r0.h;	 Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x014b;
        L_0x0061:
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r0 = r0.h;	 Catch:{ all -> 0x003d }
            r0 = r0.d();	 Catch:{ all -> 0x003d }
            r0 = r0.e();	 Catch:{ all -> 0x003d }
            r0 = com.getpebble.android.common.model.l.a(r0);	 Catch:{ all -> 0x003d }
            r2 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = r2.h;	 Catch:{ all -> 0x003d }
            r2 = r2.d();	 Catch:{ all -> 0x003d }
            r2 = r2.d();	 Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x00ec;
        L_0x0083:
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r0 = r0.h;	 Catch:{ all -> 0x003d }
            r0 = r0.d();	 Catch:{ all -> 0x003d }
            r0 = r0.b();	 Catch:{ all -> 0x003d }
            r2 = com.getpebble.android.framework.g.n.a;	 Catch:{ all -> 0x003d }
            r0 = r0.compareTo(r2);	 Catch:{ all -> 0x003d }
            if (r0 >= 0) goto L_0x00d9;
        L_0x0099:
            r0 = "HandshakeEndpointSet";
            r2 = "onReceive: PRF installed (<3.0, so not getting core dump)";
            com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = 1;
            r0.a(r2);	 Catch:{ all -> 0x003d }
        L_0x00a6:
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r0 = r0.h;	 Catch:{ all -> 0x003d }
            r0 = r0.d();	 Catch:{ all -> 0x003d }
            r0 = r0.b();	 Catch:{ all -> 0x003d }
            r0 = r0.toString();	 Catch:{ all -> 0x003d }
            r2 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = r2.h;	 Catch:{ all -> 0x003d }
            r2 = r2.d();	 Catch:{ all -> 0x003d }
            r2 = r2.a();	 Catch:{ all -> 0x003d }
            r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x003d }
            r3 = r7.a;	 Catch:{ all -> 0x003d }
            r3 = r3.h;	 Catch:{ all -> 0x003d }
            r3 = r3.g();	 Catch:{ all -> 0x003d }
            com.getpebble.android.common.b.a.a.f.a(r0, r2, r3);	 Catch:{ all -> 0x003d }
            monitor-exit(r1);	 Catch:{ all -> 0x003d }
        L_0x00d8:
            return;
        L_0x00d9:
            r0 = "HandshakeEndpointSet";
            r2 = "onReceive: PRF installed; checking for core dump";
            com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = new com.getpebble.android.framework.g.n$a$1;	 Catch:{ all -> 0x003d }
            r2.<init>(r7);	 Catch:{ all -> 0x003d }
            r3 = 1;
            r0.a(r2, r3);	 Catch:{ all -> 0x003d }
            goto L_0x00a6;
        L_0x00ec:
            r2 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = r2.h;	 Catch:{ all -> 0x003d }
            r2 = r2.d();	 Catch:{ all -> 0x003d }
            r2 = r2.b();	 Catch:{ all -> 0x003d }
            r3 = com.getpebble.android.framework.g.n.a;	 Catch:{ all -> 0x003d }
            r2 = r2.compareTo(r3);	 Catch:{ all -> 0x003d }
            if (r2 >= 0) goto L_0x0111;
        L_0x0102:
            r0 = "HandshakeEndpointSet";
            r2 = "onReceive: Firmware < 3.0 installed; curtail handshake with success (into PRF endpoint set)";
            com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = 1;
            r0.a(r2);	 Catch:{ all -> 0x003d }
            monitor-exit(r1);	 Catch:{ all -> 0x003d }
            goto L_0x00d8;
        L_0x0111:
            r2 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = r2.h;	 Catch:{ all -> 0x003d }
            r2 = r2.e();	 Catch:{ all -> 0x003d }
            r2 = r2.b();	 Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0136;
        L_0x0121:
            r2 = r0.isDevBoard();	 Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0136;
        L_0x0127:
            r0 = "HandshakeEndpointSet";
            r2 = "onReceive: There is no PRF on this device. Curtailing handshake into PRF endpoint set";
            com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = 1;
            r0.a(r2);	 Catch:{ all -> 0x003d }
            monitor-exit(r1);	 Catch:{ all -> 0x003d }
            goto L_0x00d8;
        L_0x0136:
            r2 = com.getpebble.android.common.model.r.PEBBLE_ONE_BIGBOARD_2;	 Catch:{ all -> 0x003d }
            r0 = r2.equals(r0);	 Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0159;
        L_0x013e:
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = new com.getpebble.android.framework.g.n$a$2;	 Catch:{ all -> 0x003d }
            r2.<init>(r7);	 Catch:{ all -> 0x003d }
            r3 = 0;
            r0.a(r2, r3);	 Catch:{ all -> 0x003d }
            monitor-exit(r1);	 Catch:{ all -> 0x003d }
            goto L_0x00d8;
        L_0x014b:
            r0 = "HandshakeEndpointSet";
            r2 = "onReceive: Version message null. Handshake fails";
            com.getpebble.android.common.b.a.f.a(r0, r2);	 Catch:{ all -> 0x003d }
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = com.getpebble.android.bluetooth.b.d.HANDSHAKE_FAILED;	 Catch:{ all -> 0x003d }
            r0.a(r2);	 Catch:{ all -> 0x003d }
        L_0x0159:
            r0 = r7.a;	 Catch:{ all -> 0x003d }
            r2 = new com.getpebble.android.framework.g.n$a$3;	 Catch:{ all -> 0x003d }
            r2.<init>(r7);	 Catch:{ all -> 0x003d }
            r3 = 0;
            r0.a(r2, r3);	 Catch:{ all -> 0x003d }
        L_0x0164:
            monitor-exit(r1);	 Catch:{ all -> 0x003d }
            goto L_0x00d8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.g.n.a.a(com.getpebble.android.framework.l.a.x):void");
        }

        public void a(u uVar) {
            synchronized (this.a) {
                if (this.a.g == c.COLOR_WAITING) {
                    this.a.k();
                    f.d("HandshakeEndpointSet", "Received: color response");
                    this.a.i = uVar.c();
                    if (this.a.i == ah.COLOR_UNKNOWN) {
                        f.b("HandshakeEndpointSet", "onReceive: Either received an unrecognized color, or this isn't a color at all");
                    }
                    if (this.a.p.supportsAppRunStateProtocol) {
                        k kVar = new k(com.getpebble.android.bluetooth.g.a.APP_RUN_STATE, com.getpebble.android.framework.g.k.a.REQUEST_RUNNING_APP);
                        this.a.g = c.RUNNING_APP_WAITING;
                        this.a.o.a(kVar, null);
                    } else {
                        this.a.a(false);
                    }
                }
            }
        }

        public void a(UUID uuid) {
            synchronized (this.a) {
                if (this.a.g == c.RUNNING_APP_WAITING) {
                    this.a.j = uuid;
                    this.a.a(false);
                }
            }
        }
    }

    private enum c {
        START_WAITING_REQUEST,
        VERSION_WAITING,
        COLOR_WAITING,
        RUNNING_APP_WAITING,
        CORE_DUMP_WAITING,
        FINAL_FAILED,
        FINAL_PASSED
    }

    public n(com.getpebble.android.framework.b.a aVar, Context context, b bVar) {
        super(aVar);
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (bVar == null) {
            throw new IllegalArgumentException("'handshakeResult' cannot be null!");
        } else {
            this.d = new Handler(Looper.getMainLooper());
            this.c = context;
            this.f = bVar;
            this.l = new w(this, this.k);
            this.m = new ah(this, this.k);
            this.n = new ab(this, this.k);
            this.o = new d(this.c, this, this.k);
            this.r = aVar.a().getTransport().equals(Transport.QEMU);
        }
    }

    protected void f() {
        j();
        f.c("HandshakeEndpointSet", "onInit: Starting handshake");
        if (this.r) {
            f.c("HandshakeEndpointSet", "QEMU: sending phone version message");
            n();
        }
    }

    private void j() {
        this.d.postDelayed(this.e, b);
    }

    private void k() {
        this.d.removeCallbacks(this.e);
    }

    private void l() {
        this.d.removeCallbacks(this.e);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.getpebble.android.bluetooth.g.b r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        r2 = com.getpebble.android.framework.g.n.AnonymousClass3.a;
        r3 = r5.a();
        r3 = com.getpebble.android.bluetooth.g.a.fromCode(r3);
        r3 = r3.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0018;
            case 2: goto L_0x0026;
            case 3: goto L_0x0034;
            case 4: goto L_0x0034;
            case 5: goto L_0x0042;
            case 6: goto L_0x0050;
            case 7: goto L_0x0063;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r1;
    L_0x0016:
        r1 = r0;
    L_0x0017:
        return r1;
    L_0x0018:
        r0 = "HandshakeEndpointSet";
        r1 = "handleMessage: Got phone version message";
        com.getpebble.android.common.b.a.f.d(r0, r1);
        r0 = r4.l;
        r0 = r0.a(r5);
        goto L_0x0016;
    L_0x0026:
        r0 = "HandshakeEndpointSet";
        r1 = "handleMessage: Got versions message";
        com.getpebble.android.common.b.a.f.d(r0, r1);
        r0 = r4.m;
        r0 = r0.a(r5);
        goto L_0x0016;
    L_0x0034:
        r0 = "HandshakeEndpointSet";
        r1 = "handleMessage: Got registry message";
        com.getpebble.android.common.b.a.f.d(r0, r1);
        r0 = r4.n;
        r0 = r0.a(r5);
        goto L_0x0016;
    L_0x0042:
        r0 = "HandshakeEndpointSet";
        r1 = "handleMessage: Got AppRunState message";
        com.getpebble.android.common.b.a.f.d(r0, r1);
        r0 = r4.o;
        r0 = r0.a(r5);
        goto L_0x0016;
    L_0x0050:
        r0 = r4.q;
        if (r0 != 0) goto L_0x005c;
    L_0x0054:
        r0 = "HandshakeEndpointSet";
        r2 = "handleMessage: mGetBytesEndpoint is null";
        com.getpebble.android.common.b.a.f.f(r0, r2);
        goto L_0x0017;
    L_0x005c:
        r0 = r4.q;
        r0 = r0.a(r5);
        goto L_0x0016;
    L_0x0063:
        r2 = r4.g;
        r3 = com.getpebble.android.framework.g.n.c.RUNNING_APP_WAITING;
        if (r2 != r3) goto L_0x0015;
    L_0x0069:
        r1 = "HandshakeEndpointSet";
        r2 = "handleMessage: Got InvalidEndpoint message while waiting for AppRunState (alpha1b fw bug). Curtailing handshake in PRF endpoint";
        com.getpebble.android.common.b.a.f.d(r1, r2);
        r4.a(r0);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.g.n.a(com.getpebble.android.bluetooth.g.b):boolean");
    }

    public void b() {
        f.d("HandshakeEndpointSet", "onMessageSendSuccess: Message send succeeded.");
    }

    public void a() {
        f.d("HandshakeEndpointSet", "onMessageSendFailed: Message send failed.");
        a(d.HANDSHAKE_FAILED);
    }

    protected synchronized void d() {
        if (!(this.g == c.FINAL_FAILED || this.g == c.FINAL_PASSED)) {
            f.d("HandshakeEndpointSet", "onDestroy: handshake interrupted (at state = " + this.g + ")");
            a(d.HANDSHAKE_INTERRUPTED);
        }
    }

    private synchronized void a(d dVar) {
        this.f.a(e(), false, false, dVar);
        f.d("HandshakeEndpointSet", "completeHandshakeFailure: Signaled completion (failure)");
        this.g = c.FINAL_FAILED;
        l();
    }

    private synchronized void a(boolean z) {
        new af(this).a(new k(com.getpebble.android.bluetooth.g.a.TIME, com.getpebble.android.framework.g.k.a.SEND_SET_TIME_MESSAGE), null);
        if (this.h.h()) {
            f.c("HandshakeEndpointSet", "completeHandshakeSuccess: device isUnfaithful; resetting last sync address");
            PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.BLOB_DB_LAST_SYNC_ADDRESS, "");
        }
        boolean updateDevice = ak.updateDevice(this.c.getContentResolver(), e(), m());
        PebbleApplication.F().e();
        this.g = updateDevice ? c.FINAL_PASSED : c.FINAL_FAILED;
        this.f.a(e(), updateDevice, z, null);
        f.d("HandshakeEndpointSet", "completeHandshakeSuccess: Signaled completion (success)");
        l();
    }

    public x i() {
        return this.h;
    }

    private ContentValues m() {
        ContentValues contentValues = new ContentValues(10);
        contentValues.put(ak.FRIENDLY_NAME, e().getName());
        contentValues.put(ak.ADDRESS, e().getAddress());
        contentValues.put(ak.TRANSPORT, Integer.valueOf(e().getTransport().mCode));
        contentValues.put(ak.HW_REVISION, this.h.f());
        contentValues.put(ak.SERIAL_NUMBER, this.h.g());
        contentValues.put(ak.ISO_LOCALE, this.h.k());
        contentValues.put(ak.LANGUAGE_VERSION, Integer.valueOf(this.h.l()));
        contentValues.put(ak.HEALTH_INSIGHTS_VERSION, Integer.valueOf(this.h.i()));
        if (this.h.d() == null || this.h.d().b() == null) {
            contentValues.put(ak.FW_VERSION, "");
            contentValues.put(ak.FW_TIMESTAMP, Integer.valueOf(0));
        } else {
            contentValues.put(ak.FW_VERSION, this.h.d().b().toString());
            contentValues.put(ak.FW_TIMESTAMP, Long.valueOf(this.h.d().a()));
            e e = this.h.d().e();
            if (e != null) {
                contentValues.put(ak.HW_PLATFORM, Integer.valueOf(e.intValue()));
            }
            contentValues.put(ak.IS_RUNNING_RECOVERY_FW, Boolean.valueOf(this.h.d().d()));
        }
        if (this.h.e() == null || this.h.e().b() == null) {
            contentValues.put(ak.RECOVERY_FW_VERSION, "");
        } else {
            contentValues.put(ak.RECOVERY_FW_VERSION, this.h.e().b().toString());
        }
        contentValues.put(ak.CONNECTION_STATUS, Integer.valueOf(com.getpebble.android.b.d.CONNECTED.getIntValue()));
        contentValues.put(ak.LAST_CONNECTED_TIME, Long.valueOf(System.currentTimeMillis()));
        contentValues.put("color", Integer.valueOf(this.i.getIntValue()));
        if (this.j == null) {
            contentValues.putNull(ak.CURRENT_RUNNING_APP);
        } else {
            contentValues.put(ak.CURRENT_RUNNING_APP, this.j.toString());
        }
        contentValues.put(ak.CAPABILITIES, this.p.serialize());
        return contentValues;
    }

    private synchronized void a(Runnable runnable, boolean z) {
        if (PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DISABLE_AUTO_CORE_DUMP, false)) {
            f.d("HandshakeEndpointSet", "requestCoreDump: not requesting core dump; auto cores are disabled by user");
            runnable.run();
        } else if (!e().getTransport().equals(Transport.LE) || z) {
            if (!z) {
                if (!m.a(this.p)) {
                    f.d("HandshakeEndpointSet", "requestCoreDump: not requesting core dump for this device");
                    runnable.run();
                }
            }
            if (this.q == null) {
                f.f("HandshakeEndpointSet", "requestCoreDump: mGetBytesEndpoint is null");
            } else {
                final long currentTimeMillis = System.currentTimeMillis();
                this.g = c.CORE_DUMP_WAITING;
                final FrameworkState frameworkState = new FrameworkState(false, false, null);
                final boolean z2 = z;
                final Runnable runnable2 = runnable;
                frameworkState.a(new com.getpebble.android.common.model.FrameworkState.b(this) {
                    final /* synthetic */ n e;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void a() {
                        /*
                        r6 = this;
                        r1 = r6.e;
                        monitor-enter(r1);
                        r0 = r6.e;	 Catch:{ all -> 0x0034 }
                        r0 = r0.g;	 Catch:{ all -> 0x0034 }
                        r2 = com.getpebble.android.framework.g.n.c.CORE_DUMP_WAITING;	 Catch:{ all -> 0x0034 }
                        if (r0 == r2) goto L_0x0016;
                    L_0x000d:
                        r0 = "HandshakeEndpointSet";
                        r2 = "Received unexpected core dump state";
                        com.getpebble.android.common.b.a.f.b(r0, r2);	 Catch:{ all -> 0x0034 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
                    L_0x0015:
                        return;
                    L_0x0016:
                        r0 = com.getpebble.android.common.model.FrameworkState.a.GET_BYTES_STATE_CHANGED;	 Catch:{ all -> 0x0034 }
                        r2 = r3;	 Catch:{ all -> 0x0034 }
                        r2 = r2.a();	 Catch:{ all -> 0x0034 }
                        r0 = r0.equals(r2);	 Catch:{ all -> 0x0034 }
                        if (r0 == 0) goto L_0x0088;
                    L_0x0024:
                        r0 = r3;	 Catch:{ all -> 0x0034 }
                        r0 = r0.l();	 Catch:{ all -> 0x0034 }
                        r0 = com.getpebble.android.framework.g.m.a.fromValue(r0);	 Catch:{ all -> 0x0034 }
                        r2 = com.getpebble.android.framework.g.m.a.IN_PROGRESS;	 Catch:{ all -> 0x0034 }
                        if (r0 != r2) goto L_0x0037;
                    L_0x0032:
                        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
                        goto L_0x0015;
                    L_0x0034:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
                        throw r0;
                    L_0x0037:
                        r2 = com.getpebble.android.framework.g.m.a.SUCCESS;	 Catch:{ all -> 0x0034 }
                        if (r0 != r2) goto L_0x0083;
                    L_0x003b:
                        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0034 }
                        r4 = r4;	 Catch:{ all -> 0x0034 }
                        r2 = r2 - r4;
                        r0 = "HandshakeEndpointSet";
                        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0034 }
                        r4.<init>();	 Catch:{ all -> 0x0034 }
                        r5 = "Got a core dump! Handling success - isInPrf = ";
                        r4 = r4.append(r5);	 Catch:{ all -> 0x0034 }
                        r5 = r6;	 Catch:{ all -> 0x0034 }
                        r4 = r4.append(r5);	 Catch:{ all -> 0x0034 }
                        r5 = " (took ";
                        r4 = r4.append(r5);	 Catch:{ all -> 0x0034 }
                        r2 = r4.append(r2);	 Catch:{ all -> 0x0034 }
                        r3 = " ms)";
                        r2 = r2.append(r3);	 Catch:{ all -> 0x0034 }
                        r2 = r2.toString();	 Catch:{ all -> 0x0034 }
                        com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ all -> 0x0034 }
                        r0 = r3;	 Catch:{ all -> 0x0034 }
                        r0 = r0.m();	 Catch:{ all -> 0x0034 }
                        r2 = r6.e;	 Catch:{ all -> 0x0034 }
                        r2 = r2.e();	 Catch:{ all -> 0x0034 }
                        r3 = r6.e;	 Catch:{ all -> 0x0034 }
                        r3 = r3.c;	 Catch:{ all -> 0x0034 }
                        r4 = r6;	 Catch:{ all -> 0x0034 }
                        com.getpebble.android.main.sections.support.a.a(r0, r2, r3, r4);	 Catch:{ all -> 0x0034 }
                    L_0x0083:
                        r0 = r7;	 Catch:{ all -> 0x0034 }
                        r0.run();	 Catch:{ all -> 0x0034 }
                    L_0x0088:
                        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
                        goto L_0x0015;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.g.n.2.a():void");
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putString(com.getpebble.android.framework.g.k.b.FILE_NAME.toString(), "core-dump-unencrypted.bin");
                this.q.a(new k(com.getpebble.android.bluetooth.g.a.GET_BYTES, com.getpebble.android.framework.g.k.a.REQUEST_GET_BYTES, bundle), frameworkState);
            }
        } else {
            f.d("HandshakeEndpointSet", "requestCoreDump: not requesting core dump for BLE device not in prf");
            runnable.run();
        }
    }

    private void n() {
        k();
        this.l.c();
        f.d("HandshakeEndpointSet", "onReceive: Sent phone version response");
        this.m.c();
        f.d("HandshakeEndpointSet", "onReceive: Sent Pebble version request");
        j();
        this.g = c.VERSION_WAITING;
    }
}
