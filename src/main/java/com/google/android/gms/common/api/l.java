package com.google.android.gms.common.api;

import android.support.v4.e.a;
import com.google.android.gms.b.h;
import com.google.android.gms.common.ConnectionResult;

public class l implements f {
    private final Status a;
    private final a<h<?>, ConnectionResult> b;

    public l(Status status, a<h<?>, ConnectionResult> aVar) {
        this.a = status;
        this.b = aVar;
    }

    public Status a() {
        return this.a;
    }
}
