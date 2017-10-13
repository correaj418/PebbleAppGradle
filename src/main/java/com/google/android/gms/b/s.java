package com.google.android.gms.b;

import android.os.Bundle;
import com.google.android.gms.b.k.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.f;
import java.util.Collections;

public class s implements u {
    private final v a;

    public s(v vVar) {
        this.a = vVar;
    }

    public <A extends c, R extends f, T extends a<R, A>> T a(T t) {
        this.a.g.a.add(t);
        return t;
    }

    public void a() {
        this.a.h();
        this.a.g.d = Collections.emptySet();
    }

    public void a(int i) {
    }

    public void a(Bundle bundle) {
    }

    public void a(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, int i) {
    }

    public <A extends c, T extends a<? extends f, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public boolean b() {
        return true;
    }

    public void c() {
        this.a.f();
    }
}
