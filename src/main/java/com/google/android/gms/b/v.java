package com.google.android.gms.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class v implements aa {
    final Map<d<?>, f> a;
    final Map<d<?>, ConnectionResult> b = new HashMap();
    final l c;
    final Map<com.google.android.gms.common.api.a<?>, Integer> d;
    final com.google.android.gms.common.api.a.b<? extends cn, co> e;
    int f;
    final t g;
    final com.google.android.gms.b.aa.a h;
    private final Lock i;
    private final Condition j;
    private final Context k;
    private final i l;
    private final b m;
    private volatile u n;
    private ConnectionResult o = null;

    static abstract class a {
        private final u a;

        protected a(u uVar) {
            this.a = uVar;
        }

        protected abstract void a();

        public final void a(v vVar) {
            vVar.i.lock();
            try {
                if (vVar.n == this.a) {
                    a();
                    vVar.i.unlock();
                }
            } finally {
                vVar.i.unlock();
            }
        }
    }

    final class b extends Handler {
        final /* synthetic */ v a;

        b(v vVar, Looper looper) {
            this.a = vVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((a) message.obj).a(this.a);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public v(Context context, t tVar, Lock lock, Looper looper, i iVar, Map<d<?>, f> map, l lVar, Map<com.google.android.gms.common.api.a<?>, Integer> map2, com.google.android.gms.common.api.a.b<? extends cn, co> bVar, ArrayList<n> arrayList, com.google.android.gms.b.aa.a aVar) {
        this.k = context;
        this.i = lock;
        this.l = iVar;
        this.a = map;
        this.c = lVar;
        this.d = map2;
        this.e = bVar;
        this.g = tVar;
        this.h = aVar;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((n) it.next()).a(this);
        }
        this.m = new b(this, looper);
        this.j = lock.newCondition();
        this.n = new s(this);
    }

    public <A extends c, R extends com.google.android.gms.common.api.f, T extends com.google.android.gms.b.k.a<R, A>> T a(T t) {
        t.j();
        return this.n.a((com.google.android.gms.b.k.a) t);
    }

    public void a() {
        this.n.c();
    }

    public void a(int i) {
        this.i.lock();
        try {
            this.n.a(i);
        } finally {
            this.i.unlock();
        }
    }

    public void a(Bundle bundle) {
        this.i.lock();
        try {
            this.n.a(bundle);
        } finally {
            this.i.unlock();
        }
    }

    void a(a aVar) {
        this.m.sendMessage(this.m.obtainMessage(1, aVar));
    }

    void a(ConnectionResult connectionResult) {
        this.i.lock();
        try {
            this.o = connectionResult;
            this.n = new s(this);
            this.n.a();
            this.j.signalAll();
        } finally {
            this.i.unlock();
        }
    }

    public void a(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, int i) {
        this.i.lock();
        try {
            this.n.a(connectionResult, aVar, i);
        } finally {
            this.i.unlock();
        }
    }

    void a(RuntimeException runtimeException) {
        this.m.sendMessage(this.m.obtainMessage(2, runtimeException));
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        for (com.google.android.gms.common.api.a aVar : this.d.keySet()) {
            printWriter.append(str).append(aVar.f()).println(":");
            ((f) this.a.get(aVar.d())).a(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public <A extends c, T extends com.google.android.gms.b.k.a<? extends com.google.android.gms.common.api.f, A>> T b(T t) {
        t.j();
        return this.n.b(t);
    }

    public ConnectionResult b() {
        a();
        while (i()) {
            try {
                this.j.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return d() ? ConnectionResult.a : this.o != null ? this.o : new ConnectionResult(13, null);
    }

    public void c() {
        if (this.n.b()) {
            this.b.clear();
        }
    }

    public boolean d() {
        return this.n instanceof q;
    }

    public void e() {
        if (d()) {
            ((q) this.n).d();
        }
    }

    void f() {
        this.i.lock();
        try {
            this.n = new r(this, this.c, this.d, this.l, this.e, this.i, this.k);
            this.n.a();
            this.j.signalAll();
        } finally {
            this.i.unlock();
        }
    }

    void g() {
        this.i.lock();
        try {
            this.g.i();
            this.n = new q(this);
            this.n.a();
            this.j.signalAll();
        } finally {
            this.i.unlock();
        }
    }

    void h() {
        for (f a : this.a.values()) {
            a.a();
        }
    }

    public boolean i() {
        return this.n instanceof r;
    }
}
