package com.google.android.gms.b;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class o implements aa {
    private final Context a;
    private final t b;
    private final Looper c;
    private final v d;
    private final v e;
    private final Map<d<?>, v> f;
    private final Set<ak> g = Collections.newSetFromMap(new WeakHashMap());
    private final f h;
    private Bundle i;
    private ConnectionResult j = null;
    private ConnectionResult k = null;
    private boolean l = false;
    private final Lock m;
    private int n = 0;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ o a;

        public void run() {
            this.a.m.lock();
            try {
                this.a.h();
            } finally {
                this.a.m.unlock();
            }
        }
    }

    private class a implements com.google.android.gms.b.aa.a {
        final /* synthetic */ o a;

        private a(o oVar) {
            this.a = oVar;
        }

        public void a(int i, boolean z) {
            this.a.m.lock();
            try {
                if (this.a.l || this.a.k == null || !this.a.k.b()) {
                    this.a.l = false;
                    this.a.a(i, z);
                    return;
                }
                this.a.l = true;
                this.a.e.a(i);
                this.a.m.unlock();
            } finally {
                this.a.m.unlock();
            }
        }

        public void a(Bundle bundle) {
            this.a.m.lock();
            try {
                this.a.a(bundle);
                this.a.j = ConnectionResult.a;
                this.a.h();
            } finally {
                this.a.m.unlock();
            }
        }

        public void a(ConnectionResult connectionResult) {
            this.a.m.lock();
            try {
                this.a.j = connectionResult;
                this.a.h();
            } finally {
                this.a.m.unlock();
            }
        }
    }

    private class b implements com.google.android.gms.b.aa.a {
        final /* synthetic */ o a;

        private b(o oVar) {
            this.a = oVar;
        }

        public void a(int i, boolean z) {
            this.a.m.lock();
            try {
                if (this.a.l) {
                    this.a.l = false;
                    this.a.a(i, z);
                    return;
                }
                this.a.l = true;
                this.a.d.a(i);
                this.a.m.unlock();
            } finally {
                this.a.m.unlock();
            }
        }

        public void a(Bundle bundle) {
            this.a.m.lock();
            try {
                this.a.k = ConnectionResult.a;
                this.a.h();
            } finally {
                this.a.m.unlock();
            }
        }

        public void a(ConnectionResult connectionResult) {
            this.a.m.lock();
            try {
                this.a.k = connectionResult;
                this.a.h();
            } finally {
                this.a.m.unlock();
            }
        }
    }

    private o(Context context, t tVar, Lock lock, Looper looper, i iVar, Map<d<?>, f> map, Map<d<?>, f> map2, l lVar, com.google.android.gms.common.api.a.b<? extends cn, co> bVar, f fVar, ArrayList<n> arrayList, ArrayList<n> arrayList2, Map<com.google.android.gms.common.api.a<?>, Integer> map3, Map<com.google.android.gms.common.api.a<?>, Integer> map4) {
        this.a = context;
        this.b = tVar;
        this.m = lock;
        this.c = looper;
        this.h = fVar;
        this.d = new v(context, this.b, lock, looper, iVar, map2, null, map4, null, arrayList2, new a());
        this.e = new v(context, this.b, lock, looper, iVar, map, lVar, map3, bVar, arrayList, new b());
        Map aVar = new android.support.v4.e.a();
        for (d put : map2.keySet()) {
            aVar.put(put, this.d);
        }
        for (d put2 : map.keySet()) {
            aVar.put(put2, this.e);
        }
        this.f = Collections.unmodifiableMap(aVar);
    }

    public static o a(Context context, t tVar, Lock lock, Looper looper, i iVar, Map<d<?>, f> map, l lVar, Map<com.google.android.gms.common.api.a<?>, Integer> map2, com.google.android.gms.common.api.a.b<? extends cn, co> bVar, ArrayList<n> arrayList) {
        f fVar = null;
        Map aVar = new android.support.v4.e.a();
        Map aVar2 = new android.support.v4.e.a();
        for (Entry entry : map.entrySet()) {
            f fVar2 = (f) entry.getValue();
            if (fVar2.f()) {
                fVar = fVar2;
            }
            if (fVar2.d()) {
                aVar.put((d) entry.getKey(), fVar2);
            } else {
                aVar2.put((d) entry.getKey(), fVar2);
            }
        }
        com.google.android.gms.common.internal.b.a(!aVar.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map aVar3 = new android.support.v4.e.a();
        Map aVar4 = new android.support.v4.e.a();
        for (com.google.android.gms.common.api.a aVar5 : map2.keySet()) {
            d d = aVar5.d();
            if (aVar.containsKey(d)) {
                aVar3.put(aVar5, (Integer) map2.get(aVar5));
            } else if (aVar2.containsKey(d)) {
                aVar4.put(aVar5, (Integer) map2.get(aVar5));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (aVar3.containsKey(nVar.a)) {
                arrayList2.add(nVar);
            } else if (aVar4.containsKey(nVar.a)) {
                arrayList3.add(nVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new o(context, tVar, lock, looper, iVar, aVar, aVar2, lVar, bVar, fVar, arrayList2, arrayList3, aVar3, aVar4);
    }

    private void a(int i, boolean z) {
        this.b.a(i, z);
        this.k = null;
        this.j = null;
    }

    private void a(Bundle bundle) {
        if (this.i == null) {
            this.i = bundle;
        } else if (bundle != null) {
            this.i.putAll(bundle);
        }
    }

    private void a(ConnectionResult connectionResult) {
        switch (this.n) {
            case 1:
                break;
            case 2:
                this.b.a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        j();
        this.n = 0;
    }

    private static boolean b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.b();
    }

    private boolean c(com.google.android.gms.b.k.a<? extends com.google.android.gms.common.api.f, ? extends c> aVar) {
        d b = aVar.b();
        com.google.android.gms.common.internal.b.b(this.f.containsKey(b), "GoogleApiClient is not configured to use the API required for this call.");
        return ((v) this.f.get(b)).equals(this.e);
    }

    private void g() {
        this.k = null;
        this.j = null;
        this.d.a();
        this.e.a();
    }

    private void h() {
        if (b(this.j)) {
            if (b(this.k) || k()) {
                i();
            } else if (this.k == null) {
            } else {
                if (this.n == 1) {
                    j();
                    return;
                }
                a(this.k);
                this.d.c();
            }
        } else if (this.j != null && b(this.k)) {
            this.e.c();
            a(this.j);
        } else if (this.j != null && this.k != null) {
            ConnectionResult connectionResult = this.j;
            if (this.e.f < this.d.f) {
                connectionResult = this.k;
            }
            a(connectionResult);
        }
    }

    private void i() {
        switch (this.n) {
            case 1:
                break;
            case 2:
                this.b.a(this.i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        j();
        this.n = 0;
    }

    private void j() {
        for (ak a : this.g) {
            a.a();
        }
        this.g.clear();
    }

    private boolean k() {
        return this.k != null && this.k.c() == 4;
    }

    private PendingIntent l() {
        return this.h == null ? null : PendingIntent.getActivity(this.a, this.b.l(), this.h.g(), 134217728);
    }

    public <A extends c, R extends com.google.android.gms.common.api.f, T extends com.google.android.gms.b.k.a<R, A>> T a(T t) {
        if (!c((com.google.android.gms.b.k.a) t)) {
            return this.d.a((com.google.android.gms.b.k.a) t);
        }
        if (!k()) {
            return this.e.a((com.google.android.gms.b.k.a) t);
        }
        t.a(new Status(4, null, l()));
        return t;
    }

    public void a() {
        this.n = 2;
        this.l = false;
        g();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.e.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.d.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public <A extends c, T extends com.google.android.gms.b.k.a<? extends com.google.android.gms.common.api.f, A>> T b(T t) {
        if (!c((com.google.android.gms.b.k.a) t)) {
            return this.d.b((com.google.android.gms.b.k.a) t);
        }
        if (!k()) {
            return this.e.b((com.google.android.gms.b.k.a) t);
        }
        t.a(new Status(4, null, l()));
        return t;
    }

    public ConnectionResult b() {
        throw new UnsupportedOperationException();
    }

    public void c() {
        this.k = null;
        this.j = null;
        this.n = 0;
        this.d.c();
        this.e.c();
        j();
    }

    public boolean d() {
        boolean z = true;
        this.m.lock();
        try {
            if (!(this.d.d() && (f() || k() || this.n == 1))) {
                z = false;
            }
            this.m.unlock();
            return z;
        } catch (Throwable th) {
            this.m.unlock();
        }
    }

    public void e() {
        this.d.e();
        this.e.e();
    }

    public boolean f() {
        return this.e.d();
    }
}
