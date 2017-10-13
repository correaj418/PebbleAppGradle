package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.i;
import com.google.android.gms.location.k;

public class c implements com.google.android.gms.location.c {

    private static abstract class a extends com.google.android.gms.location.k.a<Status> {
        public a(com.google.android.gms.common.api.c cVar) {
            super(cVar);
        }

        public /* synthetic */ f b(Status status) {
            return d(status);
        }

        public Status d(Status status) {
            return status;
        }
    }

    private static class b extends com.google.android.gms.location.internal.f.a {
        private final com.google.android.gms.b.k.b<Status> a;

        public b(com.google.android.gms.b.k.b<Status> bVar) {
            this.a = bVar;
        }

        public void a(FusedLocationProviderResult fusedLocationProviderResult) {
            this.a.a(fusedLocationProviderResult.a());
        }
    }

    public Location a(com.google.android.gms.common.api.c cVar) {
        try {
            return k.a(cVar).k();
        } catch (Exception e) {
            return null;
        }
    }

    public d<Status> a(com.google.android.gms.common.api.c cVar, LocationRequest locationRequest, i iVar, Looper looper) {
        final LocationRequest locationRequest2 = locationRequest;
        final i iVar2 = iVar;
        final Looper looper2 = looper;
        return cVar.b(new a(this, cVar) {
            final /* synthetic */ c g;

            protected void a(k kVar) {
                kVar.a(locationRequest2, iVar2, looper2, new b(this));
            }

            protected /* synthetic */ void b(com.google.android.gms.common.api.a.c cVar) {
                a((k) cVar);
            }
        });
    }

    public d<Status> a(com.google.android.gms.common.api.c cVar, final i iVar) {
        return cVar.b(new a(this, cVar) {
            final /* synthetic */ c e;

            protected void a(k kVar) {
                kVar.a(iVar, new b(this));
            }

            protected /* synthetic */ void b(com.google.android.gms.common.api.a.c cVar) {
                a((k) cVar);
            }
        });
    }
}
