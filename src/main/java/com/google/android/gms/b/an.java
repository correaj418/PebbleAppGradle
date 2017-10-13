package com.google.android.gms.b;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.n;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class an {
    private static final com.google.android.gms.b.k.a<?, ?>[] b = new com.google.android.gms.b.k.a[0];
    final Set<com.google.android.gms.b.k.a<?, ?>> a;
    private final b c;
    private final Map<d<?>, f> d;

    interface b {
        void a(com.google.android.gms.b.k.a<?, ?> aVar);
    }

    private static class a implements DeathRecipient, b {
        private final WeakReference<com.google.android.gms.b.k.a<?, ?>> a;
        private final WeakReference<n> b;
        private final WeakReference<IBinder> c;

        private a(com.google.android.gms.b.k.a<?, ?> aVar, n nVar, IBinder iBinder) {
            this.b = new WeakReference(nVar);
            this.a = new WeakReference(aVar);
            this.c = new WeakReference(iBinder);
        }

        private void a() {
            com.google.android.gms.b.k.a aVar = (com.google.android.gms.b.k.a) this.a.get();
            n nVar = (n) this.b.get();
            if (!(nVar == null || aVar == null)) {
                nVar.a(aVar.a().intValue());
            }
            IBinder iBinder = (IBinder) this.c.get();
            if (this.c != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void a(com.google.android.gms.b.k.a<?, ?> aVar) {
            a();
        }

        public void binderDied() {
            a();
        }
    }

    public an(d<?> dVar, f fVar) {
        this.a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.c = new b(this) {
            final /* synthetic */ an a;

            {
                this.a = r1;
            }

            public void a(com.google.android.gms.b.k.a<?, ?> aVar) {
                this.a.a.remove(aVar);
                if (aVar.a() != null && null != null) {
                    null.a(aVar.a().intValue());
                }
            }
        };
        this.d = new android.support.v4.e.a();
        this.d.put(dVar, fVar);
    }

    public an(Map<d<?>, f> map) {
        this.a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.c = /* anonymous class already generated */;
        this.d = map;
    }

    private static void a(com.google.android.gms.b.k.a<?, ?> aVar, n nVar, IBinder iBinder) {
        if (aVar.f()) {
            aVar.a(new a(aVar, nVar, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            aVar.a(null);
            aVar.g();
            nVar.a(aVar.a().intValue());
        } else {
            b aVar2 = new a(aVar, nVar, iBinder);
            aVar.a(aVar2);
            try {
                iBinder.linkToDeath(aVar2, 0);
            } catch (RemoteException e) {
                aVar.g();
                nVar.a(aVar.a().intValue());
            }
        }
    }

    public void a() {
        for (com.google.android.gms.b.k.a aVar : (com.google.android.gms.b.k.a[]) this.a.toArray(b)) {
            aVar.a(null);
            if (aVar.a() != null) {
                aVar.d();
                a(aVar, null, ((f) this.d.get(aVar.b())).h());
                this.a.remove(aVar);
            } else if (aVar.h()) {
                this.a.remove(aVar);
            }
        }
    }

    <A extends c> void a(com.google.android.gms.b.k.a<? extends com.google.android.gms.common.api.f, A> aVar) {
        this.a.add(aVar);
        aVar.a(this.c);
    }

    public void a(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.a.size());
    }

    public void b() {
        for (com.google.android.gms.b.k.a c : (com.google.android.gms.b.k.a[]) this.a.toArray(b)) {
            c.c(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean c() {
        for (com.google.android.gms.b.k.a f : (com.google.android.gms.b.k.a[]) this.a.toArray(b)) {
            if (!f.f()) {
                return true;
            }
        }
        return false;
    }
}
