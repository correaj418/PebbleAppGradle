package com.google.android.gms.b;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.a.i;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.l;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class x implements Callback {
    private static final Object d = new Object();
    private static x e;
    private long a;
    private long b;
    private long c;
    private final Context f;
    private final com.google.android.gms.common.b g;
    private int h;
    private final SparseArray<c<?>> i;
    private final Map<h<?>, c<?>> j;
    private p k;
    private final Set<h<?>> l;
    private final Handler m;
    private final ReferenceQueue<m<?>> n;
    private final SparseArray<a> o;
    private b p;

    private final class a extends PhantomReference<m<?>> {
        final /* synthetic */ x a;
        private final int b;

        public a(x xVar, m mVar, int i, ReferenceQueue<m<?>> referenceQueue) {
            this.a = xVar;
            super(mVar, referenceQueue);
            this.b = i;
        }

        public void a() {
            this.a.m.sendMessage(this.a.m.obtainMessage(2, this.b, 2));
        }
    }

    private static final class b extends Thread {
        private final ReferenceQueue<m<?>> a;
        private final SparseArray<a> b;
        private final AtomicBoolean c = new AtomicBoolean();

        public b(ReferenceQueue<m<?>> referenceQueue, SparseArray<a> sparseArray) {
            super("GoogleApiCleanup");
            this.a = referenceQueue;
            this.b = sparseArray;
        }

        public void run() {
            this.c.set(true);
            Process.setThreadPriority(10);
            while (this.c.get()) {
                try {
                    a aVar = (a) this.a.remove();
                    this.b.remove(aVar.b);
                    aVar.a();
                } catch (InterruptedException e) {
                } finally {
                    this.c.set(false);
                }
            }
        }
    }

    private class c<O extends com.google.android.gms.common.api.a.a> implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c {
        final /* synthetic */ x a;
        private final Queue<g> b = new LinkedList();
        private final f c;
        private final com.google.android.gms.common.api.a.c d;
        private final h<O> e;
        private final SparseArray<an> f = new SparseArray();
        private final Set<j> g = new HashSet();
        private final SparseArray<Map<Object, com.google.android.gms.b.k.a>> h = new SparseArray();
        private boolean i;
        private ConnectionResult j = null;

        public c(x xVar, m<O> mVar) {
            this.a = xVar;
            this.c = a((m) mVar);
            if (this.c instanceof e) {
                this.d = ((e) this.c).k();
            } else {
                this.d = this.c;
            }
            this.e = mVar.d();
        }

        private f a(m mVar) {
            com.google.android.gms.common.api.a b = mVar.b();
            if (!b.e()) {
                return mVar.b().b().a(mVar.e(), this.a.m.getLooper(), l.a(mVar.e()), mVar.c(), this, this);
            }
            i c = b.c();
            return new e(mVar.e(), this.a.m.getLooper(), c.b(), this, this, l.a(mVar.e()), c.b(mVar.c()));
        }

        private void a(Status status) {
            for (g a : this.b) {
                a.a(status);
            }
            this.b.clear();
        }

        private void b(g gVar) {
            gVar.a(this.f);
            Map map;
            if (gVar.b == 3) {
                try {
                    Map map2;
                    map = (Map) this.h.get(gVar.a);
                    if (map == null) {
                        android.support.v4.e.a aVar = new android.support.v4.e.a(1);
                        this.h.put(gVar.a, aVar);
                        map2 = aVar;
                    } else {
                        map2 = map;
                    }
                    com.google.android.gms.b.k.a aVar2 = ((com.google.android.gms.b.g.a) gVar).c;
                    map2.put(((af) aVar2).a(), aVar2);
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
                }
            } else if (gVar.b == 4) {
                try {
                    map = (Map) this.h.get(gVar.a);
                    af afVar = (af) ((com.google.android.gms.b.g.a) gVar).c;
                    if (map != null) {
                        map.remove(afVar.a());
                    } else {
                        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
                }
            }
            try {
                gVar.a(this.d);
            } catch (DeadObjectException e3) {
                this.c.a();
                a(1);
            }
        }

        private void b(ConnectionResult connectionResult) {
            for (j a : this.g) {
                a.a(this.e, connectionResult);
            }
            this.g.clear();
        }

        private void e() {
            if (this.i) {
                j();
            }
        }

        private void f() {
            if (this.i) {
                this.a.m.removeMessages(9, this.e);
                this.a.m.removeMessages(8, this.e);
                this.i = false;
            }
        }

        private void g() {
            if (this.i) {
                f();
                a(this.a.g.a(this.a.f) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.c.a();
            }
        }

        private void h() {
            this.a.m.removeMessages(10, this.e);
            this.a.m.sendMessageDelayed(this.a.m.obtainMessage(10, this.e), this.a.c);
        }

        private void i() {
            if (this.c.b() && this.h.size() == 0) {
                for (int i = 0; i < this.f.size(); i++) {
                    if (((an) this.f.get(this.f.keyAt(i))).c()) {
                        h();
                        return;
                    }
                }
                this.c.a();
            }
        }

        private void j() {
            if (!this.c.b() && !this.c.c()) {
                if (this.c.e() && this.a.h != 0) {
                    this.a.h = this.a.g.a(this.a.f);
                    if (this.a.h != 0) {
                        a(new ConnectionResult(this.a.h, null));
                        return;
                    }
                }
                this.c.a(new d(this.a, this.c, this.e));
            }
        }

        public void a() {
            while (this.c.b() && !this.b.isEmpty()) {
                b((g) this.b.remove());
            }
        }

        public void a(int i) {
            b();
            this.i = true;
            this.a.m.sendMessageDelayed(Message.obtain(this.a.m, 8, this.e), this.a.a);
            this.a.m.sendMessageDelayed(Message.obtain(this.a.m, 9, this.e), this.a.b);
            this.a.h = -1;
        }

        public void a(int i, boolean z) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.a == i && gVar.b != 1 && gVar.a()) {
                    it.remove();
                }
            }
            ((an) this.f.get(i)).a();
            this.h.delete(i);
            if (!z) {
                this.f.remove(i);
                this.a.o.remove(i);
                if (this.f.size() == 0 && this.b.isEmpty()) {
                    f();
                    this.c.a();
                    this.a.j.remove(this.e);
                    synchronized (x.d) {
                        this.a.l.remove(this.e);
                    }
                }
            }
        }

        public void a(Bundle bundle) {
            b();
            b(ConnectionResult.a);
            f();
            for (int i = 0; i < this.h.size(); i++) {
                for (com.google.android.gms.b.k.a a : ((Map) this.h.get(this.h.keyAt(i))).values()) {
                    try {
                        a.a(this.d);
                    } catch (DeadObjectException e) {
                        this.c.a();
                        a(1);
                    }
                }
            }
            a();
            h();
        }

        public void a(g gVar) {
            if (this.c.b()) {
                b(gVar);
                h();
                return;
            }
            this.b.add(gVar);
            if (this.j == null || !this.j.a()) {
                j();
            } else {
                a(this.j);
            }
        }

        public void a(j jVar) {
            this.g.add(jVar);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.google.android.gms.common.ConnectionResult r6) {
            /*
            r5 = this;
            r5.b();
            r0 = r5.a;
            r1 = -1;
            r0.h = r1;
            r5.b(r6);
            r0 = r5.f;
            r1 = 0;
            r0 = r0.keyAt(r1);
            r1 = r5.b;
            r1 = r1.isEmpty();
            if (r1 == 0) goto L_0x001e;
        L_0x001b:
            r5.j = r6;
        L_0x001d:
            return;
        L_0x001e:
            r1 = com.google.android.gms.b.x.d;
            monitor-enter(r1);
            r2 = r5.a;	 Catch:{ all -> 0x0044 }
            r2 = null;	 Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047;
        L_0x002b:
            r2 = r5.a;	 Catch:{ all -> 0x0044 }
            r2 = r2.l;	 Catch:{ all -> 0x0044 }
            r3 = r5.e;	 Catch:{ all -> 0x0044 }
            r2 = r2.contains(r3);	 Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047;
        L_0x0039:
            r2 = r5.a;	 Catch:{ all -> 0x0044 }
            r2 = null;	 Catch:{ all -> 0x0044 }
            r2.b(r6, r0);	 Catch:{ all -> 0x0044 }
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            goto L_0x001d;
        L_0x0044:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            throw r0;
        L_0x0047:
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            r1 = r5.a;
            r0 = r1.a(r6, r0);
            if (r0 != 0) goto L_0x001d;
        L_0x0050:
            r0 = r6.c();
            r1 = 18;
            if (r0 != r1) goto L_0x005b;
        L_0x0058:
            r0 = 1;
            r5.i = r0;
        L_0x005b:
            r0 = r5.i;
            if (r0 == 0) goto L_0x007d;
        L_0x005f:
            r0 = r5.a;
            r0 = r0.m;
            r1 = r5.a;
            r1 = r1.m;
            r2 = 8;
            r3 = r5.e;
            r1 = android.os.Message.obtain(r1, r2, r3);
            r2 = r5.a;
            r2 = r2.a;
            r0.sendMessageDelayed(r1, r2);
            goto L_0x001d;
        L_0x007d:
            r0 = new com.google.android.gms.common.api.Status;
            r1 = 17;
            r2 = r5.e;
            r2 = r2.b();
            r2 = java.lang.String.valueOf(r2);
            r3 = new java.lang.StringBuilder;
            r4 = java.lang.String.valueOf(r2);
            r4 = r4.length();
            r4 = r4 + 38;
            r3.<init>(r4);
            r4 = "API: ";
            r3 = r3.append(r4);
            r2 = r3.append(r2);
            r3 = " is not available on this device.";
            r2 = r2.append(r3);
            r2 = r2.toString();
            r0.<init>(r1, r2);
            r5.a(r0);
            goto L_0x001d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.x.c.a(com.google.android.gms.common.ConnectionResult):void");
        }

        public void b() {
            this.j = null;
        }

        public void b(int i) {
            this.f.put(i, new an(this.e.a(), this.c));
        }

        ConnectionResult c() {
            return this.j;
        }

        boolean d() {
            return this.c.b();
        }
    }

    private class d implements com.google.android.gms.common.internal.i.f {
        final /* synthetic */ x a;
        private final f b;
        private final h<?> c;

        public d(x xVar, f fVar, h<?> hVar) {
            this.a = xVar;
            this.b = fVar;
            this.c = hVar;
        }

        public void a(ConnectionResult connectionResult) {
            if (connectionResult.b()) {
                this.b.a(null, Collections.emptySet());
            } else {
                ((c) this.a.j.get(this.c)).a(connectionResult);
            }
        }
    }

    public static x a() {
        x xVar;
        synchronized (d) {
            xVar = e;
        }
        return xVar;
    }

    private void a(g gVar) {
        ((c) this.i.get(gVar.a)).a(gVar);
    }

    private void a(m<?> mVar, int i) {
        h d = mVar.d();
        if (!this.j.containsKey(d)) {
            this.j.put(d, new c(this, mVar));
        }
        c cVar = (c) this.j.get(d);
        cVar.b(i);
        this.i.put(i, cVar);
        cVar.j();
        this.o.put(i, new a(this, mVar, i, this.n));
        if (this.p == null || !this.p.c.get()) {
            this.p = new b(this.n, this.o);
            this.p.start();
        }
    }

    private void b(int i, boolean z) {
        c cVar = (c) this.i.get(i);
        if (cVar != null) {
            if (!z) {
                this.i.delete(i);
            }
            cVar.a(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    private void d() {
        for (c cVar : this.j.values()) {
            cVar.b();
            cVar.j();
        }
    }

    public void a(int i, boolean z) {
        this.m.sendMessage(this.m.obtainMessage(7, i, z ? 1 : 2));
    }

    public void a(j jVar) {
        for (h hVar : jVar.b()) {
            c cVar = (c) this.j.get(hVar);
            if (cVar == null) {
                jVar.g();
                return;
            } else if (cVar.d()) {
                jVar.a(hVar, ConnectionResult.a);
            } else if (cVar.c() != null) {
                jVar.a(hVar, cVar.c());
            } else {
                cVar.a(jVar);
            }
        }
    }

    public void a(p pVar) {
        synchronized (d) {
            if (pVar == null) {
                this.k = null;
                this.l.clear();
            }
        }
    }

    boolean a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.a() && !this.g.a(connectionResult.c())) {
            return false;
        }
        this.g.a(this.f, connectionResult, i);
        return true;
    }

    public void b() {
        this.m.sendMessage(this.m.obtainMessage(3));
    }

    public void b(ConnectionResult connectionResult, int i) {
        if (!a(connectionResult, i)) {
            this.m.sendMessage(this.m.obtainMessage(5, i, 0));
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1:
                a((j) message.obj);
                break;
            case 2:
            case 7:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                b(i, z);
                break;
            case 3:
                d();
                break;
            case 4:
                a((g) message.obj);
                break;
            case 5:
                if (this.i.get(message.arg1) != null) {
                    ((c) this.i.get(message.arg1)).a(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                a((m) message.obj, message.arg1);
                break;
            case 8:
                if (this.j.containsKey(message.obj)) {
                    ((c) this.j.get(message.obj)).e();
                    break;
                }
                break;
            case 9:
                if (this.j.containsKey(message.obj)) {
                    ((c) this.j.get(message.obj)).g();
                    break;
                }
                break;
            case 10:
                if (this.j.containsKey(message.obj)) {
                    ((c) this.j.get(message.obj)).i();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
