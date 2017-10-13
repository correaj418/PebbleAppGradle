package com.getpebble.android.bluetooth.e;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.b.d;
import com.getpebble.android.common.b.a.f;
import com.google.a.b.am;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class k {
    protected static final long a = TimeUnit.SECONDS.toMillis(10);
    private final Runnable A = new Runnable(this) {
        final /* synthetic */ k a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.c();
        }
    };
    protected b b = b.SESSION_CLOSED;
    protected short c;
    protected short d;
    protected Queue<l> e = new LinkedList();
    protected Deque<l> f = new LinkedList();
    protected l g;
    protected boolean h;
    protected l i;
    protected int j;
    protected int k;
    protected int l;
    protected c m = c.ZERO;
    protected boolean n;
    protected l o;
    protected short p = (short) 0;
    protected final Runnable q = new Runnable(this) {
        final /* synthetic */ k a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.f();
        }
    };
    private a r;
    private final PebbleDevice s;
    private final com.getpebble.android.bluetooth.j.b t;
    private final e u;
    private final h v;
    private int w;
    private HandlerThread x;
    private Handler y;
    private int z;

    interface a {
        void a(int i);

        void a(d dVar);

        void a_();

        void c(byte[] bArr);
    }

    protected enum b {
        SESSION_CLOSED(am.b(a.RESET_REQUEST)),
        AWAITING_RESET_COMPLETE(am.b(a.RESET_COMPLETE)),
        AWAITING_RESET_COMPLETE_REQUESTED(am.b(a.RESET_COMPLETE)),
        SESSION_OPEN(am.a(a.DATA, a.ACK, a.RESET_REQUEST));
        
        private final Set<a> mAllowedTypes;

        private b(Set<a> set) {
            this.mAllowedTypes = set;
        }

        boolean typeAllowed(a aVar) {
            return this.mAllowedTypes.contains(aVar);
        }
    }

    enum c {
        ZERO(0, false, false),
        ONE(1, true, true);
        
        final boolean supportsCoalescedAcking;
        final boolean supportsWindowNegotiation;
        final int version;

        private c(int i, boolean z, boolean z2) {
            this.version = i;
            this.supportsWindowNegotiation = z;
            this.supportsCoalescedAcking = z2;
        }

        static c from(int i) {
            for (c cVar : values()) {
                if (cVar.version == i) {
                    return cVar;
                }
            }
            return null;
        }

        static c minSupportedVersion() {
            return ZERO;
        }

        static c maxSupportedVersion() {
            return values()[values().length - 1];
        }
    }

    k(a aVar, PebbleDevice pebbleDevice, int i, com.getpebble.android.bluetooth.j.b bVar, h hVar, e eVar, Context context) {
        this.r = aVar;
        this.t = bVar;
        this.s = pebbleDevice;
        this.w = i;
        this.u = eVar;
        this.u.a(this, context);
        this.v = hVar;
        this.x = new HandlerThread("PPoG_" + this.s.getAddress(), -1);
        this.x.start();
        this.y = new Handler(this.x.getLooper());
    }

    protected void a(Runnable runnable) {
        this.y.post(runnable);
    }

    protected void a(Runnable runnable, long j) {
        this.y.postDelayed(runnable, j);
    }

    void a(final l lVar) {
        a(new Runnable(this) {
            final /* synthetic */ k b;

            public void run() {
                if (this.b.b.typeAllowed(lVar.b())) {
                    switch (lVar.b()) {
                        case RESET_REQUEST:
                            this.b.c(lVar);
                            return;
                        case RESET_COMPLETE:
                            this.b.d(lVar);
                            return;
                        case DATA:
                            this.b.e(lVar);
                            return;
                        case ACK:
                            this.b.f(lVar);
                            return;
                        default:
                            return;
                    }
                }
                f.b("PPoGConnection", "Got unexpected " + lVar.b() + " while in " + this.b.b + " - disconnecting!");
                this.b.r.a(d.PPoGATT_UNEXPECTED_PACKET);
            }
        });
    }

    void a(final int i) {
        a(new Runnable(this) {
            final /* synthetic */ k b;

            public void run() {
                f.d("PPoGConnection", "setMtu: " + i);
                this.b.w = i;
            }
        });
    }

    private void k() {
        this.c = (short) 0;
        this.d = (short) 0;
        this.f.clear();
        this.e.clear();
        this.y.removeCallbacksAndMessages(null);
    }

    private void c(l lVar) {
        if (lVar.c() != (short) 0) {
            f.b("PPoGConnection", "Reset packet SN is not zero!");
            this.r.a(d.PPoGATT_RESET_SN_NOT_ZERO);
            return;
        }
        f.c("PPoGConnection", "Reset request... version = " + lVar.g());
        this.m = c.from(lVar.g());
        if (this.m == null) {
            f.a("PPoGConnection", "onResetRequest: Requested PPoGConnection version " + lVar.g() + " is not supported! Disconnecting..");
            this.r.a(d.PPoGATT_UNSUPPORTED_VERSION);
            return;
        }
        this.b = b.AWAITING_RESET_COMPLETE;
        a(this.q, a);
        k();
        l a = l.a(this.d, this.v.e(), this.v.f(), this.m);
        if (this.n) {
            g(a);
            return;
        }
        f.c("PPoGConnection", "onResetRequest: !mConnectionAllowed; delaying reset complete");
        this.o = a;
    }

    void a() {
        a(new Runnable(this) {
            final /* synthetic */ k a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.n = true;
                if (this.a.o != null) {
                    f.c("PPoGConnection", "allowConnection: sending delayed reset complete");
                    this.a.g(this.a.o);
                    this.a.o = null;
                }
            }
        });
    }

    protected void b() {
        f.b("PPoGConnection", "requestReset()");
        this.b = b.AWAITING_RESET_COMPLETE_REQUESTED;
        k();
        a(this.q, a);
        g(l.a((short) 0, this.m));
    }

    private void d(l lVar) {
        if (lVar.c() != (short) 0) {
            f.b("PPoGConnection", "Reset packet SN is not zero!");
            this.r.a(d.PPoGATT_RESET_SN_NOT_ZERO);
            return;
        }
        if (this.b.equals(b.AWAITING_RESET_COMPLETE_REQUESTED)) {
            g(l.a(lVar.c(), this.v.e(), this.v.f(), this.m));
        }
        this.y.removeCallbacks(this.q);
        this.i = null;
        this.j = 0;
        if (this.m.supportsWindowNegotiation && !lVar.h()) {
            f.c("PPoGConnection", "onResetComplete: reverting mPPoGattVersion to 0, because FW does not support window size in reset complete");
            this.m = c.ZERO;
        }
        this.r.a_();
        this.b = b.SESSION_OPEN;
        if (this.m.supportsWindowNegotiation) {
            this.l = Math.min(this.v.e(), lVar.j());
            this.k = Math.min(this.v.f(), lVar.i());
        } else {
            this.l = 4;
            this.k = 4;
        }
        f.d("PPoGConnection", "onResetComplete: mRxWindow = " + this.l + " mTxWindow = " + this.k);
        d();
    }

    private void e(l lVar) {
        com.getpebble.android.bluetooth.b.a("PPoGConnection", "onData " + lVar);
        if (this.c == lVar.c()) {
            a(lVar.c());
            this.c = b(this.c);
            this.r.c(lVar.e());
        } else if (this.i != null) {
            f.b("PPoGConnection", "unexpected DATA packet with sequence " + lVar.c() + " - ignoring + re-sending " + this.i);
            c();
        } else {
            f.b("PPoGConnection", "unexpected DATA packet with sequence " + lVar.c() + " - ignoring (no previous ACK to resend)");
        }
    }

    protected void a(short s) {
        this.i = l.a(s);
        if (this.m.supportsCoalescedAcking) {
            short s2 = (short) (this.p + 1);
            this.p = s2;
            if (s2 >= this.l / 2) {
                c();
                return;
            } else {
                a(this.A, 200);
                return;
            }
        }
        c();
    }

    protected void c() {
        this.y.removeCallbacks(this.A);
        this.p = (short) 0;
        g(this.i);
    }

    private void f(l lVar) {
        com.getpebble.android.bluetooth.b.a("PPoGConnection", "onAck " + lVar.c());
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            l lVar2 = (l) it.next();
            if (lVar2.c() == lVar.c() && lVar2.d() > 0) {
                f.d("PPoGConnection", "onAck: removing " + lVar + " from (re-)send queue because of ack");
                it.remove();
            }
        }
        if (this.e.contains(lVar)) {
            while (true) {
                lVar2 = (l) this.e.poll();
                if (lVar2.equals(lVar)) {
                    d();
                    e();
                    return;
                }
                int length = lVar2.f().length;
                if (length > this.z) {
                    this.z = length;
                }
            }
        } else {
            f.b("PPoGConnection", "mInflightDataPackets does not contains SN for ACK!" + lVar);
        }
    }

    void a(final byte[] bArr) {
        a(new Runnable(this) {
            final /* synthetic */ k b;

            public void run() {
                for (byte[] b : k.a(bArr, this.b.w - 4)) {
                    this.b.b(b);
                }
            }
        });
    }

    static short b(short s) {
        return (short) ((s + 1) % 32);
    }

    protected void b(byte[] bArr) {
        l lVar = new l(this.d, a.DATA, bArr);
        this.d = b(this.d);
        g(lVar);
    }

    static byte[][] a(byte[] bArr, int i) {
        int length = bArr.length;
        int ceil = (int) Math.ceil((double) (((float) length) / ((float) i)));
        byte[][] bArr2 = new byte[ceil][];
        for (int i2 = 0; i2 < ceil; i2++) {
            int i3 = i2 * i;
            int i4 = (i3 + i) - 1;
            if (i4 >= length) {
                i4 = length - 1;
            }
            i4 = (i4 + 1) - i3;
            bArr2[i2] = new byte[i4];
            System.arraycopy(bArr, i3, bArr2[i2], 0, i4);
        }
        return bArr2;
    }

    private void g(l lVar) {
        if (lVar.b().equals(a.DATA)) {
            this.f.offer(lVar);
        } else {
            com.getpebble.android.bluetooth.b.a("PPoGConnection", "mMetaWaitingToSend " + lVar);
            this.g = lVar;
        }
        d();
    }

    protected boolean b(l lVar) {
        boolean z = false;
        byte[] f = lVar.f();
        if (f.length > this.w) {
            f.a("PPoGConnection", "sendPacket: " + lVar + " is over mtu of " + this.w);
            this.r.a(d.PPoGATT_OVER_MTU);
        } else {
            com.getpebble.android.bluetooth.b.a("PPoGConnection", "sendPacket " + lVar);
            try {
                z = this.u.a(this.t, f);
            } catch (Throwable e) {
                f.b("PPoGConnection", "sendPacket: " + lVar + " failed to send!", e);
                this.r.a(d.PPoGATT_SEND_FAILED);
            }
        }
        return z;
    }

    protected void d() {
        if (!this.f.isEmpty() || this.g != null) {
            l lVar;
            Object obj = this.g != null ? 1 : null;
            if (obj != null) {
                com.getpebble.android.bluetooth.b.a("PPoGConnection", "... sending meta " + this.g);
                lVar = this.g;
            } else if (this.e.size() < this.k) {
                lVar = (l) this.f.peek();
                if (lVar == null) {
                    return;
                }
            } else {
                return;
            }
            if (!this.b.equals(b.SESSION_OPEN) && lVar.b().needsOpenSession) {
                f.c("PPoGConnection", "sendNextDataPacket: !SESSION_OPEN - not sending: " + lVar);
            } else if (b(lVar)) {
                if (obj != null) {
                    this.g = null;
                } else {
                    this.f.poll();
                    this.e.offer(lVar);
                }
                e();
                d();
            } else {
                com.getpebble.android.bluetooth.b.a("PPoGConnection", "sendNextPacket: server busy");
            }
        }
    }

    protected void e() {
        this.y.removeCallbacks(this.q);
        if (!this.e.isEmpty()) {
            a(this.q, a);
        }
    }

    protected void f() {
        int i;
        if (this.b.equals(b.AWAITING_RESET_COMPLETE) || this.b.equals(b.AWAITING_RESET_COMPLETE_REQUESTED)) {
            f.b("PPoGConnection", "timeout during port reset");
            i = this.j + 1;
            this.j = i;
            if (i > 2) {
                f.a("PPoGConnection", "timeout during port reset");
                this.r.a(d.PPoGATT);
                return;
            }
            b();
            return;
        }
        List linkedList = new LinkedList();
        while (true) {
            l lVar = (l) this.e.poll();
            if (lVar == null) {
                break;
            } else if (lVar.a() <= 2) {
                f.b("PPoGConnection", "timed out (retrying...): " + lVar);
                linkedList.add(lVar);
            } else {
                int length = lVar.f().length;
                f.a("PPoGConnection", "timed out (max retries reached): " + lVar + " (max sent size = " + this.z + " / failed size = " + length + ")");
                Boolean b = com.getpebble.android.bluetooth.j.b.b(this.t.k());
                if (!(b == null || b.booleanValue())) {
                    f.b("PPoGConnection", "warning! adapter shows !connected @ packet timeout (PBL-41991)");
                }
                com.getpebble.android.bluetooth.h.a.a.a(h(), this.z, length, b);
                b();
            }
        }
        for (i = linkedList.size() - 1; i >= 0; i--) {
            this.f.offerFirst(linkedList.get(i));
        }
        d();
    }

    void g() {
        a(new Runnable(this) {
            final /* synthetic */ k a;

            {
                this.a = r1;
            }

            public void run() {
                f.d("PPoGConnection", "destroy()");
                this.a.u.a(this.a);
                this.a.y.removeCallbacksAndMessages(null);
                this.a.x.quit();
            }
        });
    }

    PebbleDevice h() {
        return this.s;
    }

    void a(final boolean z) {
        a(new Runnable(this) {
            final /* synthetic */ k b;

            public void run() {
                this.b.h = z;
                if (this.b.h) {
                    this.b.d();
                    return;
                }
                f.b("PPoGConnection", "notifications disabled: disconnecting");
                this.b.r.a(d.PPoGATT);
            }
        });
    }

    void a(a aVar) {
        this.r = aVar;
    }

    void a(final d dVar) {
        a(new Runnable(this) {
            final /* synthetic */ k b;

            public void run() {
                this.b.r.a(dVar);
            }
        });
    }

    com.getpebble.android.bluetooth.j.b i() {
        return this.t;
    }

    void b(final int i) {
        a(new Runnable(this) {
            final /* synthetic */ k b;

            public void run() {
                this.b.r.a(i);
            }
        });
    }

    void j() {
        a(new Runnable(this) {
            final /* synthetic */ k a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d();
            }
        });
    }
}
