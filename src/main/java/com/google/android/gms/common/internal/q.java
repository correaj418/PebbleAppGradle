package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class q implements Callback {
    final ArrayList<b> a = new ArrayList();
    private final a b;
    private final ArrayList<b> c = new ArrayList();
    private final ArrayList<c> d = new ArrayList();
    private volatile boolean e = false;
    private final AtomicInteger f = new AtomicInteger(0);
    private boolean g = false;
    private final Handler h;
    private final Object i = new Object();

    public interface a {
        boolean b();

        Bundle s();
    }

    public q(Looper looper, a aVar) {
        this.b = aVar;
        this.h = new Handler(looper, this);
    }

    public void a() {
        this.e = false;
        this.f.incrementAndGet();
    }

    public void a(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.h.getLooper()) {
            z = true;
        }
        b.a(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.h.removeMessages(1);
        synchronized (this.i) {
            this.g = true;
            ArrayList arrayList = new ArrayList(this.c);
            int i2 = this.f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!this.e || this.f.get() != i2) {
                    break;
                } else if (this.c.contains(bVar)) {
                    bVar.a(i);
                }
            }
            this.a.clear();
            this.g = false;
        }
    }

    public void a(Bundle bundle) {
        boolean z = true;
        b.a(Looper.myLooper() == this.h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.i) {
            b.a(!this.g);
            this.h.removeMessages(1);
            this.g = true;
            if (this.a.size() != 0) {
                z = false;
            }
            b.a(z);
            ArrayList arrayList = new ArrayList(this.c);
            int i = this.f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!this.e || !this.b.b() || this.f.get() != i) {
                    break;
                } else if (!this.a.contains(bVar)) {
                    bVar.a(bundle);
                }
            }
            this.a.clear();
            this.g = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r2 = r5.h;
        r2 = r2.getLooper();
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r2 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.b.a(r0, r2);
        r0 = r5.h;
        r0.removeMessages(r1);
        r1 = r5.i;
        monitor-enter(r1);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0054 }
        r2 = r5.d;	 Catch:{ all -> 0x0054 }
        r0.<init>(r2);	 Catch:{ all -> 0x0054 }
        r2 = r5.f;	 Catch:{ all -> 0x0054 }
        r2 = r2.get();	 Catch:{ all -> 0x0054 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0054 }
    L_0x002c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0032:
        r0 = r3.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.google.android.gms.common.api.c.c) r0;	 Catch:{ all -> 0x0054 }
        r4 = r5.e;	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r4 = r5.f;	 Catch:{ all -> 0x0054 }
        r4 = r4.get();	 Catch:{ all -> 0x0054 }
        if (r4 == r2) goto L_0x0048;
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x000e;
    L_0x0048:
        r4 = r5.d;	 Catch:{ all -> 0x0054 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x002c;
    L_0x0050:
        r0.a(r6);	 Catch:{ all -> 0x0054 }
        goto L_0x002c;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.q.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public void a(b bVar) {
        b.a((Object) bVar);
        synchronized (this.i) {
            if (this.c.contains(bVar)) {
                String valueOf = String.valueOf(bVar);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.c.add(bVar);
            }
        }
        if (this.b.b()) {
            this.h.sendMessage(this.h.obtainMessage(1, bVar));
        }
    }

    public void a(c cVar) {
        b.a((Object) cVar);
        synchronized (this.i) {
            if (this.d.contains(cVar)) {
                String valueOf = String.valueOf(cVar);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.d.add(cVar);
            }
        }
    }

    public void b() {
        this.e = true;
    }

    public void b(b bVar) {
        b.a((Object) bVar);
        synchronized (this.i) {
            if (!this.c.remove(bVar)) {
                String valueOf = String.valueOf(bVar);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found").toString());
            } else if (this.g) {
                this.a.add(bVar);
            }
        }
    }

    public void b(c cVar) {
        b.a((Object) cVar);
        synchronized (this.i) {
            if (!this.d.remove(cVar)) {
                String valueOf = String.valueOf(cVar);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            b bVar = (b) message.obj;
            synchronized (this.i) {
                if (this.e && this.b.b() && this.c.contains(bVar)) {
                    bVar.a(this.b.s());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
