package com.google.android.gms.b;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;

public class n implements b, c {
    public final a<?> a;
    private final int b;
    private v c;

    public n(a<?> aVar, int i) {
        this.a = aVar;
        this.b = i;
    }

    private void a() {
        com.google.android.gms.common.internal.b.a(this.c, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void a(int i) {
        a();
        this.c.a(i);
    }

    public void a(Bundle bundle) {
        a();
        this.c.a(bundle);
    }

    public void a(v vVar) {
        this.c = vVar;
    }

    public void a(ConnectionResult connectionResult) {
        a();
        this.c.a(connectionResult, this.a, this.b);
    }
}
