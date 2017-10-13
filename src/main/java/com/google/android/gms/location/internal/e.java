package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.b.k.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.f;
import java.util.List;

public class e implements f {

    private static abstract class a extends com.google.android.gms.location.k.a<Status> {
        public a(c cVar) {
            super(cVar);
        }

        public /* synthetic */ com.google.android.gms.common.api.f b(Status status) {
            return d(status);
        }

        public Status d(Status status) {
            return status;
        }
    }

    public d<Status> a(c cVar, final PendingIntent pendingIntent) {
        return cVar.b(new a(this, cVar) {
            final /* synthetic */ e e;

            protected void a(k kVar) {
                kVar.a(pendingIntent, (b) this);
            }

            protected /* synthetic */ void b(com.google.android.gms.common.api.a.c cVar) {
                a((k) cVar);
            }
        });
    }

    public d<Status> a(c cVar, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return cVar.b(new a(this, cVar) {
            final /* synthetic */ e f;

            protected void a(k kVar) {
                kVar.a(geofencingRequest, pendingIntent, this);
            }

            protected /* synthetic */ void b(com.google.android.gms.common.api.a.c cVar) {
                a((k) cVar);
            }
        });
    }

    @Deprecated
    public d<Status> a(c cVar, List<com.google.android.gms.location.d> list, PendingIntent pendingIntent) {
        com.google.android.gms.location.GeofencingRequest.a aVar = new com.google.android.gms.location.GeofencingRequest.a();
        aVar.a((List) list);
        aVar.a(5);
        return a(cVar, aVar.a(), pendingIntent);
    }
}
