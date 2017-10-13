package com.google.android.gms.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class t extends c implements com.google.android.gms.b.aa.a {
    final Queue<com.google.android.gms.b.k.a<?, ?>> a = new LinkedList();
    y b;
    final Map<d<?>, f> c;
    Set<Scope> d = new HashSet();
    final l e;
    final Map<com.google.android.gms.common.api.a<?>, Integer> f;
    final com.google.android.gms.common.api.a.b<? extends cn, co> g;
    Set<am> h = null;
    final an i;
    private final Lock j;
    private final q k;
    private aa l = null;
    private final int m;
    private final Context n;
    private final Looper o;
    private volatile boolean p;
    private long q = 120000;
    private long r = 5000;
    private final a s;
    private final com.google.android.gms.common.b t;
    private final ah u = new ah();
    private final ArrayList<n> v;
    private Integer w = null;
    private final com.google.android.gms.common.internal.q.a x = new com.google.android.gms.common.internal.q.a(this) {
        final /* synthetic */ t a;

        {
            this.a = r1;
        }

        public boolean b() {
            return this.a.e();
        }

        public Bundle s() {
            return null;
        }
    };

    final class a extends Handler {
        final /* synthetic */ t a;

        a(t tVar, Looper looper) {
            this.a = tVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.a.o();
                    return;
                case 2:
                    this.a.n();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    static class b extends com.google.android.gms.b.y.a {
        private WeakReference<t> a;

        b(t tVar) {
            this.a = new WeakReference(tVar);
        }

        public void a() {
            t tVar = (t) this.a.get();
            if (tVar != null) {
                tVar.n();
            }
        }
    }

    public t(Context context, Lock lock, Looper looper, l lVar, com.google.android.gms.common.b bVar, com.google.android.gms.common.api.a.b<? extends cn, co> bVar2, Map<com.google.android.gms.common.api.a<?>, Integer> map, List<com.google.android.gms.common.api.c.b> list, List<c.c> list2, Map<d<?>, f> map2, int i, int i2, ArrayList<n> arrayList) {
        this.n = context;
        this.j = lock;
        this.k = new q(looper, this.x);
        this.o = looper;
        this.s = new a(this, looper);
        this.t = bVar;
        this.m = i;
        if (this.m >= 0) {
            this.w = Integer.valueOf(i2);
        }
        this.f = map;
        this.c = map2;
        this.v = arrayList;
        this.i = new an(this.c);
        for (com.google.android.gms.common.api.c.b a : list) {
            this.k.a(a);
        }
        for (c.c a2 : list2) {
            this.k.a(a2);
        }
        this.e = lVar;
        this.g = bVar2;
    }

    public static int a(Iterable<f> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (f fVar : iterable) {
            if (fVar.d()) {
                i2 = 1;
            }
            i = fVar.f() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    static String b(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void c(int i) {
        if (this.w == null) {
            this.w = Integer.valueOf(i);
        } else if (this.w.intValue() != i) {
            String valueOf = String.valueOf(b(i));
            String valueOf2 = String.valueOf(b(this.w.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.l == null) {
            Object obj = null;
            Object obj2 = null;
            for (f fVar : this.c.values()) {
                if (fVar.d()) {
                    obj2 = 1;
                }
                obj = fVar.f() ? 1 : obj;
            }
            switch (this.w.intValue()) {
                case 1:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj2 != null) {
                        this.l = o.a(this.n, this, this.j, this.o, this.t, this.c, this.e, this.f, this.g, this.v);
                        return;
                    }
                    break;
            }
            this.l = new v(this.n, this, this.j, this.o, this.t, this.c, this.e, this.f, this.g, this.v, this);
        }
    }

    private void m() {
        this.k.b();
        this.l.a();
    }

    private void n() {
        this.j.lock();
        try {
            if (g()) {
                m();
            }
            this.j.unlock();
        } catch (Throwable th) {
            this.j.unlock();
        }
    }

    private void o() {
        this.j.lock();
        try {
            if (i()) {
                m();
            }
            this.j.unlock();
        } catch (Throwable th) {
            this.j.unlock();
        }
    }

    public Looper a() {
        return this.o;
    }

    public <A extends com.google.android.gms.common.api.a.c, R extends com.google.android.gms.common.api.f, T extends com.google.android.gms.b.k.a<R, A>> T a(T t) {
        com.google.android.gms.common.internal.b.b(t.b() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.c.containsKey(t.b());
        String f = t.c() != null ? t.c().f() : "the API";
        com.google.android.gms.common.internal.b.b(containsKey, new StringBuilder(String.valueOf(f).length() + 65).append("GoogleApiClient is not configured to use ").append(f).append(" required for this call.").toString());
        this.j.lock();
        try {
            if (this.l == null) {
                this.a.add(t);
            } else {
                t = this.l.a(t);
                this.j.unlock();
            }
            return t;
        } finally {
            this.j.unlock();
        }
    }

    public <C extends f> C a(d<C> dVar) {
        Object obj = (f) this.c.get(dVar);
        com.google.android.gms.common.internal.b.a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public void a(int i) {
        boolean z = true;
        this.j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            com.google.android.gms.common.internal.b.b(z, "Illegal sign-in mode: " + i);
            c(i);
            m();
        } finally {
            this.j.unlock();
        }
    }

    public void a(int i, boolean z) {
        if (i == 1 && !z) {
            h();
        }
        this.i.b();
        this.k.a(i);
        this.k.a();
        if (i == 2) {
            m();
        }
    }

    public void a(Bundle bundle) {
        while (!this.a.isEmpty()) {
            b((com.google.android.gms.b.k.a) this.a.remove());
        }
        this.k.a(bundle);
    }

    public void a(am amVar) {
        this.j.lock();
        try {
            if (this.h == null) {
                this.h = new HashSet();
            }
            this.h.add(amVar);
        } finally {
            this.j.unlock();
        }
    }

    public void a(ConnectionResult connectionResult) {
        if (!this.t.a(this.n, connectionResult.c())) {
            i();
        }
        if (!g()) {
            this.k.a(connectionResult);
            this.k.a();
        }
    }

    public void a(com.google.android.gms.common.api.c.b bVar) {
        this.k.b(bVar);
    }

    public void a(c.c cVar) {
        this.k.a(cVar);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.n);
        printWriter.append(str).append("mResuming=").print(this.p);
        printWriter.append(" mWorkQueue.size()=").print(this.a.size());
        this.i.a(printWriter);
        if (this.l != null) {
            this.l.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public boolean a(com.google.android.gms.common.api.a<?> aVar) {
        f fVar = (f) this.c.get(aVar.d());
        return fVar != null && fVar.b();
    }

    public <A extends com.google.android.gms.common.api.a.c, T extends com.google.android.gms.b.k.a<? extends com.google.android.gms.common.api.f, A>> T b(T t) {
        com.google.android.gms.common.internal.b.b(t.b() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.c.containsKey(t.b());
        String f = t.c() != null ? t.c().f() : "the API";
        com.google.android.gms.common.internal.b.b(containsKey, new StringBuilder(String.valueOf(f).length() + 65).append("GoogleApiClient is not configured to use ").append(f).append(" required for this call.").toString());
        this.j.lock();
        try {
            if (this.l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (g()) {
                this.a.add(t);
                while (!this.a.isEmpty()) {
                    com.google.android.gms.b.k.a aVar = (com.google.android.gms.b.k.a) this.a.remove();
                    this.i.a(aVar);
                    aVar.a(Status.c);
                }
            } else {
                t = this.l.b(t);
                this.j.unlock();
            }
            return t;
        } finally {
            this.j.unlock();
        }
    }

    <C extends f> C b(d<?> dVar) {
        Object obj = (f) this.c.get(dVar);
        com.google.android.gms.common.internal.b.a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public void b() {
        boolean z = false;
        this.j.lock();
        try {
            if (this.m >= 0) {
                if (this.w != null) {
                    z = true;
                }
                com.google.android.gms.common.internal.b.a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.w == null) {
                this.w = Integer.valueOf(a(this.c.values(), false));
            } else if (this.w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            a(this.w.intValue());
        } finally {
            this.j.unlock();
        }
    }

    public void b(am amVar) {
        this.j.lock();
        try {
            if (this.h == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.h.remove(amVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!j()) {
                this.l.e();
            }
            this.j.unlock();
        } catch (Throwable th) {
            this.j.unlock();
        }
    }

    public void b(c.c cVar) {
        this.k.b(cVar);
    }

    public ConnectionResult c() {
        boolean z = true;
        com.google.android.gms.common.internal.b.a(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.j.lock();
        try {
            if (this.m >= 0) {
                if (this.w == null) {
                    z = false;
                }
                com.google.android.gms.common.internal.b.a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.w == null) {
                this.w = Integer.valueOf(a(this.c.values(), false));
            } else if (this.w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            c(this.w.intValue());
            this.k.b();
            ConnectionResult b = this.l.b();
            return b;
        } finally {
            this.j.unlock();
        }
    }

    public void d() {
        this.j.lock();
        try {
            this.i.a();
            if (this.l != null) {
                this.l.c();
            }
            this.u.a();
            for (com.google.android.gms.b.k.a aVar : this.a) {
                aVar.a(null);
                aVar.g();
            }
            this.a.clear();
            if (this.l != null) {
                i();
                this.k.a();
                this.j.unlock();
            }
        } finally {
            this.j.unlock();
        }
    }

    public boolean e() {
        return this.l != null && this.l.d();
    }

    boolean g() {
        return this.p;
    }

    void h() {
        if (!g()) {
            this.p = true;
            if (this.b == null) {
                this.b = this.t.a(this.n.getApplicationContext(), new b(this));
            }
            this.s.sendMessageDelayed(this.s.obtainMessage(1), this.q);
            this.s.sendMessageDelayed(this.s.obtainMessage(2), this.r);
        }
    }

    boolean i() {
        if (!g()) {
            return false;
        }
        this.p = false;
        this.s.removeMessages(2);
        this.s.removeMessages(1);
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        return true;
    }

    boolean j() {
        boolean z = false;
        this.j.lock();
        try {
            if (this.h != null) {
                if (!this.h.isEmpty()) {
                    z = true;
                }
                this.j.unlock();
            }
            return z;
        } finally {
            this.j.unlock();
        }
    }

    String k() {
        Writer stringWriter = new StringWriter();
        a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int l() {
        return System.identityHashCode(this);
    }
}
