package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.i;
import com.google.android.gms.location.q;
import com.google.android.gms.location.r;
import java.util.HashMap;
import java.util.Map;

public class j {
    private final o<h> a;
    private final Context b;
    private ContentProviderClient c = null;
    private boolean d = false;
    private Map<i, c> e = new HashMap();
    private Map<Object, a> f = new HashMap();

    private static class a extends com.google.android.gms.location.q.a {
        private Handler a;

        private void a(int i, Object obj) {
            if (this.a == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.a.sendMessage(obtain);
        }

        public void a(LocationAvailability locationAvailability) {
            a(1, locationAvailability);
        }

        public void a(LocationResult locationResult) {
            a(0, locationResult);
        }
    }

    private static class b extends Handler {
        private final i a;

        public b(i iVar) {
            this.a = iVar;
        }

        public b(i iVar, Looper looper) {
            super(looper);
            this.a = iVar;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.a.a(new Location((Location) message.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    private static class c extends com.google.android.gms.location.r.a {
        private Handler a;

        c(i iVar, Looper looper) {
            if (looper == null) {
                com.google.android.gms.common.internal.b.a(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.a = looper == null ? new b(iVar) : new b(iVar, looper);
        }

        public void a() {
            this.a = null;
        }

        public void a(Location location) {
            if (this.a == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.a.sendMessage(obtain);
        }
    }

    public j(Context context, o<h> oVar) {
        this.b = context;
        this.a = oVar;
    }

    private c a(i iVar, Looper looper) {
        c cVar;
        synchronized (this.e) {
            cVar = (c) this.e.get(iVar);
            if (cVar == null) {
                cVar = new c(iVar, looper);
            }
            this.e.put(iVar, cVar);
        }
        return cVar;
    }

    public Location a() {
        this.a.a();
        try {
            return ((h) this.a.c()).b(this.b.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void a(LocationRequest locationRequest, i iVar, Looper looper, f fVar) {
        this.a.a();
        ((h) this.a.c()).a(LocationRequestUpdateData.a(LocationRequestInternal.a(locationRequest), a(iVar, looper), fVar));
    }

    public void a(i iVar, f fVar) {
        this.a.a();
        com.google.android.gms.common.internal.b.a((Object) iVar, (Object) "Invalid null listener");
        synchronized (this.e) {
            r rVar = (c) this.e.remove(iVar);
            if (rVar != null) {
                rVar.a();
                ((h) this.a.c()).a(LocationRequestUpdateData.a(rVar, fVar));
            }
        }
    }

    public void a(boolean z) {
        this.a.a();
        ((h) this.a.c()).a(z);
        this.d = z;
    }

    public void b() {
        try {
            synchronized (this.e) {
                for (r rVar : this.e.values()) {
                    if (rVar != null) {
                        ((h) this.a.c()).a(LocationRequestUpdateData.a(rVar, null));
                    }
                }
                this.e.clear();
            }
            synchronized (this.f) {
                for (q qVar : this.f.values()) {
                    if (qVar != null) {
                        ((h) this.a.c()).a(LocationRequestUpdateData.a(qVar, null));
                    }
                }
                this.f.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void c() {
        if (this.d) {
            try {
                a(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
