package com.google.android.gms.b;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.fitness.i;
import java.util.Collection;
import java.util.Set;

public abstract class ba<T extends IInterface> extends p<T> {
    protected ba(Context context, Looper looper, int i, b bVar, c cVar, l lVar) {
        super(context, looper, i, lVar, bVar, cVar);
    }

    protected Set<Scope> a(Set<Scope> set) {
        return i.a((Collection) set);
    }

    public boolean d() {
        return !ax.a(n());
    }

    public boolean u() {
        return true;
    }
}
