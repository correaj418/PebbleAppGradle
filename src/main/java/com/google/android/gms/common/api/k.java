package com.google.android.gms.common.api;

import android.support.v4.e.a;
import com.google.android.gms.b.h;
import com.google.android.gms.common.ConnectionResult;

public class k extends l {
    private final ConnectionResult a;

    public k(Status status, a<h<?>, ConnectionResult> aVar) {
        super(status, aVar);
        this.a = (ConnectionResult) aVar.get(aVar.b(0));
    }
}
