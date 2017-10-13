package com.getpebble.android.framework.g;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.install.d;
import com.getpebble.android.framework.l.a.t;
import com.getpebble.android.framework.l.b.aa;
import com.getpebble.android.framework.l.b.r;
import com.google.a.b.am;
import com.google.a.f.e;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class z extends ac {
    private final int a;
    private p b;
    private Handler c;
    private Runnable d = new Runnable(this) {
        final /* synthetic */ z a;

        {
            this.a = r1;
        }

        public void run() {
            f.d("PutBytesEndpoint", "timeout Runnable firing...");
            this.a.n = a.TIMEOUT;
            if (this.a.o != c.CANCELLED) {
                f.d("PutBytesEndpoint", "Wait for messages expired, aborting.");
                this.a.m();
                return;
            }
            b c = this.a.e();
            if (c != null) {
                c.a(this.a.n);
            }
            this.a.n();
        }
    };
    private InputStream e;
    private String f;
    private e g;
    private e h;
    private int i;
    private com.getpebble.android.common.framework.install.b j;
    private e k;
    private b l = null;
    private e m;
    private a n;
    private c o = c.IDLE;
    private d p = null;
    private e q = e.a(0);
    private long r;
    private boolean s;
    private c t = null;

    interface b {
        void a(a aVar);

        void a(e eVar);

        void a(e eVar, e eVar2, e eVar3);

        void b(a aVar);

        void b(e eVar);
    }

    public enum a {
        OK,
        CANCELLED,
        INSTALL_FAILED,
        LOAD_FAILED,
        ACK_FAILED,
        INVALID_CRC,
        TIMEOUT,
        UNKNOWN_ERROR
    }

    private enum c {
        IDLE,
        WAITING_FOR_COOKIE,
        SENDING_DATA,
        COMMIT_SENT,
        WAITING_FOR_INSTALL,
        CANCELLED,
        INSTALLING
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        return false;
    }

    public z(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        }
        this.b = pVar;
        this.a = r.a(com.getpebble.android.bluetooth.g.a.PUT_BYTES) - 9;
        this.c = new Handler(Looper.getMainLooper());
    }

    public z a(InputStream inputStream) {
        this.e = inputStream;
        return this;
    }

    public z a(String str) {
        this.f = str;
        return this;
    }

    public z a(int i) {
        this.g = e.a((long) i);
        return this;
    }

    public z a(e eVar) {
        this.h = eVar;
        return this;
    }

    public z b(int i) {
        this.i = i;
        return this;
    }

    public z a(com.getpebble.android.common.framework.install.b bVar) {
        this.j = bVar;
        return this;
    }

    public z b(e eVar) {
        this.k = eVar;
        return this;
    }

    public z a(boolean z) {
        this.s = z;
        return this;
    }

    public synchronized boolean a(b bVar) {
        boolean z = true;
        synchronized (this) {
            if (this.l != bVar) {
                if (this.l != null) {
                    z = false;
                } else {
                    this.l = bVar;
                }
            }
        }
        return z;
    }

    public synchronized boolean b(b bVar) {
        boolean z = false;
        synchronized (this) {
            if (this.l != null) {
                if (this.l == bVar) {
                    this.l = null;
                    n();
                    z = true;
                }
            }
        }
        return z;
    }

    private p d() {
        return this.b;
    }

    private b e() {
        return this.l;
    }

    protected void c() {
        this.c.postDelayed(this.d, 60000);
    }

    private void f() {
        this.c.removeCallbacks(this.d);
    }

    public void c(int i) {
        f.d("PutBytesEndpoint", "startTransfer at offset " + i);
        if (!this.s && i > 0) {
            f.f("PutBytesEndpoint", "Starting at positive non-zero offset (" + i + ") but resumed updates are not supported");
        }
        this.p = new d();
        if (i > 0) {
            try {
                d(i);
            } catch (Throwable e) {
                f.d("PutBytesEndpoint", "startTransfer: exception reading " + i + " bytes from stream", e);
                this.n = a.UNKNOWN_ERROR;
                m();
                return;
            }
        }
        this.q = e.a;
        e(i);
    }

    private void d(int i) {
        f.d("PutBytesEndpoint", "skipToOffset: " + i);
        com.getpebble.android.common.b.b.f.a aVar = new com.getpebble.android.common.b.b.f.a(i, this.e);
        byte[] bArr = new byte[8];
        while (true) {
            int a = aVar.a(bArr);
            if (a > 0) {
                this.p.a(bArr, a);
            } else {
                return;
            }
        }
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.PUT_BYTES);
    }

    private boolean a(com.getpebble.android.bluetooth.g.a aVar) {
        return a().contains(aVar);
    }

    private void h() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.r;
        f.d("PutBytesEndpoint", "Transferring " + this.j + " (" + this.g + " bytes) took " + elapsedRealtime + "ms @ " + ((long) ((this.g.floatValue() / ((float) elapsedRealtime)) * 1000.0f)) + " Bps");
    }

    public boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        boolean z = false;
        f.e("PutBytesEndpoint", "onReceive: Got protocol message while in state: " + this.o);
        if (!a(com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()))) {
            return false;
        }
        f();
        t tVar = new t(bVar);
        if (tVar.c().equals(com.getpebble.android.framework.l.a.t.a.NACK)) {
            f.b("PutBytesEndpoint", "onReceive: Received a put-bytes NACK");
            this.n = i();
            m();
            return true;
        }
        b e = e();
        switch (this.o) {
            case WAITING_FOR_COOKIE:
                this.m = tVar.d();
                this.o = c.SENDING_DATA;
                this.r = SystemClock.elapsedRealtime();
                j();
                break;
            case SENDING_DATA:
                j();
                break;
            case COMMIT_SENT:
                this.o = c.WAITING_FOR_INSTALL;
                this.n = a.OK;
                if (e != null) {
                    h();
                    e.a(this.m);
                    break;
                }
                break;
            case CANCELLED:
                if (e != null) {
                    if (this.t != null && this.t.equals(c.INSTALLING)) {
                        z = true;
                    }
                    if (z) {
                        e.b(this.n);
                    } else {
                        e.a(this.n);
                    }
                }
                n();
                break;
            case INSTALLING:
                if (e != null) {
                    e.b(this.m);
                    break;
                }
                break;
            default:
                f.b("PutBytesEndpoint", "onReceive: Got message in unexpected state: " + this.o + ", failing.");
                this.o = c.IDLE;
                m();
                break;
        }
        return true;
    }

    public boolean c(e eVar) {
        this.o = c.INSTALLING;
        if (d().a(aa.b(eVar))) {
            f.d("PutBytesEndpoint", "install(" + eVar.toString() + ")");
            c();
            return true;
        }
        f.d("PutBytesEndpoint", "install: Failed to send install message");
        return false;
    }

    void b() {
        n();
    }

    private a i() {
        switch (this.o) {
            case WAITING_FOR_COOKIE:
                return a.ACK_FAILED;
            case SENDING_DATA:
                return a.LOAD_FAILED;
            case COMMIT_SENT:
                return a.INVALID_CRC;
            default:
                return a.UNKNOWN_ERROR;
        }
    }

    private void e(int i) {
        r a;
        if (this.s) {
            a = aa.a(this.g, this.j, this.i, this.f, this.k, e.a((long) i));
        } else {
            a = aa.a(this.g, this.j, this.i, this.f, this.k);
        }
        d().a(a);
        c();
        f.d("PutBytesEndpoint", "sendInitMessage: Sending init message for size: " + this.g + ", installType: " + this.j + ", bank: " + this.i + ", name: " + this.f + ", app id: " + this.k);
        this.o = c.WAITING_FOR_COOKIE;
    }

    private void j() {
        byte[] bArr = new byte[this.a];
        try {
            int read = this.e.read(bArr);
            if (read > 0) {
                d().a(aa.a(this.m, e.a(read), bArr));
                this.p.a(bArr, read);
                e a = e.a(read);
                this.q = this.q.a(a);
                b e = e();
                if (e != null) {
                    e.a(a, this.q, this.g);
                }
                c();
            } else if (read >= 0 || this.q.e(this.g) >= 0) {
                k();
                l();
            } else {
                f.d("PutBytesEndpoint", "sendPutMessage: stream is exhausted but the number of bytes sent (" + this.q + " bytes) didn't match the file size (" + this.g + " bytes). We lost " + this.g.b(this.q) + " bytes?");
                this.n = a.UNKNOWN_ERROR;
                m();
            }
        } catch (Throwable e2) {
            f.d("PutBytesEndpoint", "sendPutMessage: exception reading from stream", e2);
            this.n = a.UNKNOWN_ERROR;
            m();
        }
    }

    private void k() {
        if (this.e != null) {
            try {
                this.e.close();
            } catch (IOException e) {
                f.b("PutBytesEndpoint", "closeInputStream: Failed to close put bytes stream");
            }
            this.e = null;
        }
    }

    private void l() {
        f.d("PutBytesEndpoint", "sendCommitMessage()");
        e a = e.a(this.p.a());
        if (a.equals(this.h)) {
            d().a(aa.a(this.m, this.h));
            c();
            this.o = c.COMMIT_SENT;
            return;
        }
        f.a("PutBytesEndpoint", "sendCommitMessage: CRCs do not match: sent=" + a + " expected=" + this.h);
        this.n = a.INVALID_CRC;
        m();
    }

    private void m() {
        f.d("PutBytesEndpoint", "abortTransfer()");
        Object obj = (this.m == null || this.o.equals(c.CANCELLED)) ? null : 1;
        if (obj != null) {
            f.d("PutBytesEndpoint", "abortTransfer: Cancelling");
            this.t = this.o;
            this.o = c.CANCELLED;
            d().a(aa.a(this.m));
            c();
            return;
        }
        f.d("PutBytesEndpoint", "abortTransfer: Cannot cancel gracefully; cleaning up");
        b e = e();
        if (e != null) {
            if (this.o.equals(c.INSTALLING)) {
                e.b(this.n);
            } else {
                e.a(this.n);
            }
        }
        n();
    }

    private void n() {
        f.d("PutBytesEndpoint", "cleanup()");
        f();
        this.o = c.IDLE;
        this.t = null;
        k();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = null;
        this.m = null;
        this.p = null;
        this.q = null;
        this.k = null;
    }
}
