package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.b.ab;
import com.google.android.gms.b.am;
import com.google.android.gms.b.cm;
import com.google.android.gms.b.cn;
import com.google.android.gms.b.co;
import com.google.android.gms.b.n;
import com.google.android.gms.b.t;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.a.h;
import com.google.android.gms.common.api.a.i;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class c {
    private static final Set<c> a = Collections.newSetFromMap(new WeakHashMap());

    public interface b {
        void a(int i);

        void a(Bundle bundle);
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    public static final class a {
        private Account a;
        private final Set<Scope> b = new HashSet();
        private final Set<Scope> c = new HashSet();
        private int d;
        private View e;
        private String f;
        private String g;
        private final Map<a<?>, com.google.android.gms.common.internal.l.a> h = new android.support.v4.e.a();
        private final Context i;
        private final Map<a<?>, com.google.android.gms.common.api.a.a> j = new android.support.v4.e.a();
        private ab k;
        private int l = -1;
        private c m;
        private Looper n;
        private com.google.android.gms.common.b o = com.google.android.gms.common.b.a();
        private com.google.android.gms.common.api.a.b<? extends cn, co> p = cm.c;
        private final ArrayList<b> q = new ArrayList();
        private final ArrayList<c> r = new ArrayList();

        public a(Context context) {
            this.i = context;
            this.n = context.getMainLooper();
            this.f = context.getPackageName();
            this.g = context.getClass().getName();
        }

        private static <C extends f, O> C a(com.google.android.gms.common.api.a.b<C, O> bVar, Object obj, Context context, Looper looper, l lVar, b bVar2, c cVar) {
            return bVar.a(context, looper, lVar, obj, bVar2, cVar);
        }

        private static <C extends h, O> e a(i<C, O> iVar, Object obj, Context context, Looper looper, l lVar, b bVar, c cVar) {
            return new e(context, looper, iVar.b(), bVar, cVar, lVar, iVar.b(obj));
        }

        private void a(c cVar) {
            com.google.android.gms.b.i.a(this.k).a(this.l, cVar, this.m);
        }

        private c c() {
            l a = a();
            a aVar = null;
            Map e = a.e();
            Map aVar2 = new android.support.v4.e.a();
            Map aVar3 = new android.support.v4.e.a();
            ArrayList arrayList = new ArrayList();
            a aVar4 = null;
            for (a aVar5 : this.j.keySet()) {
                a aVar52;
                f a2;
                a aVar6;
                Object obj = this.j.get(aVar52);
                int i = 0;
                if (e.get(aVar52) != null) {
                    i = ((com.google.android.gms.common.internal.l.a) e.get(aVar52)).b ? 1 : 2;
                }
                aVar2.put(aVar52, Integer.valueOf(i));
                b nVar = new n(aVar52, i);
                arrayList.add(nVar);
                a aVar7;
                if (aVar52.e()) {
                    i c = aVar52.c();
                    aVar7 = c.a() == 1 ? aVar52 : aVar4;
                    a2 = a(c, obj, this.i, this.n, a, nVar, (c) nVar);
                    aVar6 = aVar7;
                } else {
                    com.google.android.gms.common.api.a.b b = aVar52.b();
                    aVar7 = b.a() == 1 ? aVar52 : aVar4;
                    a2 = a(b, obj, this.i, this.n, a, nVar, (c) nVar);
                    aVar6 = aVar7;
                }
                aVar3.put(aVar52.d(), a2);
                if (!a2.f()) {
                    aVar52 = aVar;
                } else if (aVar != null) {
                    String valueOf = String.valueOf(aVar52.f());
                    String valueOf2 = String.valueOf(aVar.f());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                aVar4 = aVar6;
                aVar = aVar52;
            }
            if (aVar != null) {
                if (aVar4 != null) {
                    valueOf = String.valueOf(aVar.f());
                    valueOf2 = String.valueOf(aVar4.f());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                com.google.android.gms.common.internal.b.a(this.a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar.f());
                com.google.android.gms.common.internal.b.a(this.b.equals(this.c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar.f());
            }
            return new t(this.i, new ReentrantLock(), this.n, a, this.o, this.p, aVar2, this.q, this.r, aVar3, this.l, t.a(aVar3.values(), true), arrayList);
        }

        public a a(Scope scope) {
            com.google.android.gms.common.internal.b.a((Object) scope, (Object) "Scope must not be null");
            this.b.add(scope);
            return this;
        }

        public a a(a<? extends com.google.android.gms.common.api.a.a.c> aVar) {
            com.google.android.gms.common.internal.b.a((Object) aVar, (Object) "Api must not be null");
            this.j.put(aVar, null);
            Collection a = aVar.a().a(null);
            this.c.addAll(a);
            this.b.addAll(a);
            return this;
        }

        public a a(b bVar) {
            com.google.android.gms.common.internal.b.a((Object) bVar, (Object) "Listener must not be null");
            this.q.add(bVar);
            return this;
        }

        public a a(c cVar) {
            com.google.android.gms.common.internal.b.a((Object) cVar, (Object) "Listener must not be null");
            this.r.add(cVar);
            return this;
        }

        public l a() {
            co coVar = co.a;
            if (this.j.containsKey(cm.g)) {
                coVar = (co) this.j.get(cm.g);
            }
            return new l(this.a, this.b, this.h, this.d, this.e, this.f, this.g, coVar);
        }

        public c b() {
            com.google.android.gms.common.internal.b.b(!this.j.isEmpty(), "must call addApi() to add at least one API");
            c c = c();
            synchronized (c.a) {
                c.a.add(c);
            }
            if (this.l >= 0) {
                a(c);
            }
            return c;
        }
    }

    public Looper a() {
        throw new UnsupportedOperationException();
    }

    public <A extends com.google.android.gms.common.api.a.c, R extends f, T extends com.google.android.gms.b.k.a<R, A>> T a(T t) {
        throw new UnsupportedOperationException();
    }

    public <C extends f> C a(d<C> dVar) {
        throw new UnsupportedOperationException();
    }

    public void a(int i) {
        throw new UnsupportedOperationException();
    }

    public void a(am amVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(b bVar);

    public abstract void a(c cVar);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean a(a<?> aVar);

    public <A extends com.google.android.gms.common.api.a.c, T extends com.google.android.gms.b.k.a<? extends f, A>> T b(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void b();

    public void b(am amVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void b(c cVar);

    public abstract ConnectionResult c();

    public abstract void d();

    public abstract boolean e();
}
