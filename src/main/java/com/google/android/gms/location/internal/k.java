package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.i;
import com.google.android.gms.location.l;

public class k extends a {
    private final j e;

    private static final class a extends com.google.android.gms.location.internal.g.a {
        private com.google.android.gms.b.k.b<Status> a;

        public a(com.google.android.gms.b.k.b<Status> bVar) {
            this.a = bVar;
        }

        public void a(int i, PendingIntent pendingIntent) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        public void a(int i, String[] strArr) {
            if (this.a == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            this.a.a(l.b(l.a(i)));
            this.a = null;
        }

        public void b(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }
    }

    private static final class b extends com.google.android.gms.location.internal.g.a {
        private com.google.android.gms.b.k.b<Status> a;

        public b(com.google.android.gms.b.k.b<Status> bVar) {
            this.a = bVar;
        }

        private void a(int i) {
            if (this.a == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            }
            this.a.a(l.b(l.a(i)));
            this.a = null;
        }

        public void a(int i, PendingIntent pendingIntent) {
            a(i);
        }

        public void a(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        public void b(int i, String[] strArr) {
            a(i);
        }
    }

    public k(Context context, Looper looper, com.google.android.gms.common.api.c.b bVar, c cVar, String str, com.google.android.gms.common.internal.l lVar) {
        super(context, looper, bVar, cVar, str, lVar);
        this.e = new j(context, this.d);
    }

    public void a() {
        synchronized (this.e) {
            if (b()) {
                try {
                    this.e.b();
                    this.e.c();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.a();
        }
    }

    public void a(PendingIntent pendingIntent, com.google.android.gms.b.k.b<Status> bVar) {
        r();
        com.google.android.gms.common.internal.b.a((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        com.google.android.gms.common.internal.b.a((Object) bVar, (Object) "ResultHolder not provided.");
        ((h) t()).a(pendingIntent, new b(bVar), n().getPackageName());
    }

    public void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.b.k.b<Status> bVar) {
        r();
        com.google.android.gms.common.internal.b.a((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        com.google.android.gms.common.internal.b.a((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        com.google.android.gms.common.internal.b.a((Object) bVar, (Object) "ResultHolder not provided.");
        ((h) t()).a(geofencingRequest, pendingIntent, new a(bVar));
    }

    public void a(LocationRequest locationRequest, i iVar, Looper looper, f fVar) {
        synchronized (this.e) {
            this.e.a(locationRequest, iVar, looper, fVar);
        }
    }

    public void a(i iVar, f fVar) {
        this.e.a(iVar, fVar);
    }

    public Location k() {
        return this.e.a();
    }
}
