package com.google.android.gms.b;

import android.os.Bundle;
import com.google.android.gms.b.k.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.f;

public interface u {
    <A extends c, R extends f, T extends a<R, A>> T a(T t);

    void a();

    void a(int i);

    void a(Bundle bundle);

    void a(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, int i);

    <A extends c, T extends a<? extends f, A>> T b(T t);

    boolean b();

    void c();
}
