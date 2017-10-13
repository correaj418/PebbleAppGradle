package com.google.android.gms.b;

import android.support.v4.e.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import java.util.Set;

public final class j extends m<l> {
    private int d;
    private boolean e;

    private void a(ConnectionResult connectionResult) {
        a aVar = null;
        for (int i = 0; i < aVar.size(); i++) {
            a((h) aVar.b(i), connectionResult);
        }
    }

    protected l a(Status status) {
        l lVar;
        synchronized (null) {
            try {
                a(new ConnectionResult(8));
                a aVar = null;
                if (aVar.size() != 1) {
                    lVar = new l(status, null);
                }
            } finally {
            }
        }
        return lVar;
    }

    public void a(h<?> hVar, ConnectionResult connectionResult) {
        synchronized (null) {
            a aVar = null;
            try {
                aVar.put(hVar, connectionResult);
                this.d--;
                boolean b = connectionResult.b();
                if (!b) {
                    this.e = b;
                }
                if (this.d == 0) {
                    Status status = this.e ? new Status(13) : Status.a;
                    aVar = null;
                    b(aVar.size() == 1 ? new k(status, null) : new l(status, null));
                }
            } finally {
            }
        }
    }

    protected /* synthetic */ f b(Status status) {
        return a(status);
    }

    public Set<h<?>> b() {
        a aVar = null;
        return aVar.keySet();
    }
}
