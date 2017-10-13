package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.i.b;
import com.google.android.gms.common.internal.q.a;
import java.util.Set;

public abstract class p<T extends IInterface> extends i<T> implements f, a {
    private final l d;
    private final Set<Scope> e;
    private final Account f;

    class AnonymousClass1 implements b {
        final /* synthetic */ c.b a;

        AnonymousClass1(c.b bVar) {
            this.a = bVar;
        }

        public void a(int i) {
            this.a.a(i);
        }

        public void a(Bundle bundle) {
            this.a.a(bundle);
        }
    }

    class AnonymousClass2 implements i.c {
        final /* synthetic */ c.c a;

        AnonymousClass2(c.c cVar) {
            this.a = cVar;
        }

        public void a(ConnectionResult connectionResult) {
            this.a.a(connectionResult);
        }
    }

    protected p(Context context, Looper looper, int i, l lVar, c.b bVar, c.c cVar) {
        this(context, looper, r.a(context), com.google.android.gms.common.b.a(), i, lVar, (c.b) b.a((Object) bVar), (c.c) b.a((Object) cVar));
    }

    protected p(Context context, Looper looper, r rVar, com.google.android.gms.common.b bVar, int i, l lVar, c.b bVar2, c.c cVar) {
        super(context, looper, rVar, bVar, i, a(bVar2), a(cVar), lVar.g());
        this.d = lVar;
        this.f = lVar.a();
        this.e = b(lVar.d());
    }

    private static b a(c.b bVar) {
        return bVar == null ? null : new AnonymousClass1(bVar);
    }

    private static i.c a(c.c cVar) {
        return cVar == null ? null : new AnonymousClass2(cVar);
    }

    private Set<Scope> b(Set<Scope> set) {
        Set<Scope> a = a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    protected Set<Scope> a(Set<Scope> set) {
        return set;
    }

    public final Account o() {
        return this.f;
    }

    protected final Set<Scope> v() {
        return this.e;
    }
}
