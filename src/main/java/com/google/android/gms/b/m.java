package com.google.android.gms.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class m<R extends f> extends d<R> {
    static final ThreadLocal<Boolean> a = new ThreadLocal<Boolean>() {
        protected Boolean a() {
            return Boolean.valueOf(false);
        }

        protected /* synthetic */ Object initialValue() {
            return a();
        }
    };
    protected final a<R> b;
    protected final WeakReference<c> c;
    private final Object d;
    private final CountDownLatch e;
    private final ArrayList<com.google.android.gms.common.api.d.a> f;
    private g<? super R> g;
    private R h;
    private b i;
    private volatile boolean j;
    private boolean k;
    private boolean l;
    private v m;
    private volatile am<R> n;
    private boolean o;

    public static class a<R extends f> extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            removeMessages(2);
        }

        public void a(g<? super R> gVar, R r) {
            sendMessage(obtainMessage(1, new Pair(gVar, r)));
        }

        protected void b(g<? super R> gVar, R r) {
            try {
                gVar.a(r);
            } catch (RuntimeException e) {
                m.c((f) r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    b((g) pair.first, (f) pair.second);
                    return;
                case 2:
                    ((m) message.obj).c(Status.d);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    return;
            }
        }
    }

    private final class b {
        final /* synthetic */ m a;

        private b(m mVar) {
            this.a = mVar;
        }

        protected void finalize() {
            m.c(this.a.h);
            super.finalize();
        }
    }

    @Deprecated
    m() {
        this.d = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList();
        this.o = false;
        this.b = new a(Looper.getMainLooper());
        this.c = new WeakReference(null);
    }

    protected m(c cVar) {
        this.d = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList();
        this.o = false;
        this.b = new a(cVar != null ? cVar.a() : Looper.getMainLooper());
        this.c = new WeakReference(cVar);
    }

    private void a(R r) {
        this.h = r;
        this.m = null;
        this.e.countDown();
        Status a = this.h.a();
        if (this.k) {
            this.g = null;
        } else if (this.g != null) {
            this.b.a();
            this.b.a(this.g, b());
        } else if (this.h instanceof e) {
            this.i = new b();
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.d.a) it.next()).a(a);
        }
        this.f.clear();
    }

    private R b() {
        R r;
        boolean z = true;
        synchronized (this.d) {
            if (this.j) {
                z = false;
            }
            com.google.android.gms.common.internal.b.a(z, (Object) "Result has already been consumed.");
            com.google.android.gms.common.internal.b.a(f(), (Object) "Result is not ready.");
            r = this.h;
            this.h = null;
            this.g = null;
            this.j = true;
        }
        e();
        return r;
    }

    public static void c(f fVar) {
        if (fVar instanceof e) {
            try {
                ((e) fVar).a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(fVar);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public final R a(long j, TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = j <= 0 || Looper.myLooper() != Looper.getMainLooper();
        com.google.android.gms.common.internal.b.a(z2, (Object) "await must not be called on the UI thread when time is greater than zero.");
        com.google.android.gms.common.internal.b.a(!this.j, (Object) "Result has already been consumed.");
        if (this.n != null) {
            z = false;
        }
        com.google.android.gms.common.internal.b.a(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.e.await(j, timeUnit)) {
                c(Status.d);
            }
        } catch (InterruptedException e) {
            c(Status.b);
        }
        com.google.android.gms.common.internal.b.a(f(), (Object) "Result is not ready.");
        return b();
    }

    public Integer a() {
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.gms.common.api.g<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.d;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.j;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.b.a(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.n;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.b.a(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.i();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.f();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.b;	 Catch:{ all -> 0x0027 }
        r1 = r5.b();	 Catch:{ all -> 0x0027 }
        r0.a(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.g = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.m.a(com.google.android.gms.common.api.g):void");
    }

    protected abstract R b(Status status);

    public final void b(R r) {
        boolean z = true;
        synchronized (this.d) {
            if (this.l || this.k || (f() && k())) {
                c((f) r);
                return;
            }
            com.google.android.gms.common.internal.b.a(!f(), (Object) "Results have already been set");
            if (this.j) {
                z = false;
            }
            com.google.android.gms.common.internal.b.a(z, (Object) "Result has already been consumed");
            a((f) r);
        }
    }

    public final void c(Status status) {
        synchronized (this.d) {
            if (!f()) {
                b(b(status));
                this.l = true;
            }
        }
    }

    protected void e() {
    }

    public final boolean f() {
        return this.e.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
        r2 = this;
        r1 = r2.d;
        monitor-enter(r1);
        r0 = r2.k;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.j;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.m;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.m;	 Catch:{ RemoteException -> 0x002c }
        r0.a();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.h;	 Catch:{ all -> 0x0029 }
        c(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.k = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.e;	 Catch:{ all -> 0x0029 }
        r0 = r2.b(r0);	 Catch:{ all -> 0x0029 }
        r2.a(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.m.g():void");
    }

    public boolean h() {
        boolean i;
        synchronized (this.d) {
            if (((c) this.c.get()) == null || !this.o) {
                g();
            }
            i = i();
        }
        return i;
    }

    public boolean i() {
        boolean z;
        synchronized (this.d) {
            z = this.k;
        }
        return z;
    }

    public void j() {
        boolean z = this.o || ((Boolean) a.get()).booleanValue();
        this.o = z;
    }

    boolean k() {
        return false;
    }
}
