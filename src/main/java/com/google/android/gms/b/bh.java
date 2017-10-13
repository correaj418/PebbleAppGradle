package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.l;

public class bh extends ba<bs> {

    static abstract class a<R extends f> extends com.google.android.gms.b.k.a<R, bh> {
        public a(com.google.android.gms.common.api.c cVar) {
            super(com.google.android.gms.fitness.c.g, cVar);
        }
    }

    public static class b extends com.google.android.gms.common.api.a.b<bh, com.google.android.gms.common.api.a.a.b> {
        public bh a(Context context, Looper looper, l lVar, com.google.android.gms.common.api.a.a.b bVar, com.google.android.gms.common.api.c.b bVar2, com.google.android.gms.common.api.c.c cVar) {
            return new bh(context, looper, lVar, bVar2, cVar);
        }

        public /* synthetic */ com.google.android.gms.common.api.a.f a(Context context, Looper looper, l lVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
            return a(context, looper, lVar, (com.google.android.gms.common.api.a.a.b) obj, bVar, cVar);
        }
    }

    static abstract class c extends a<Status> {
        c(com.google.android.gms.common.api.c cVar) {
            super(cVar);
        }

        protected /* synthetic */ f b(Status status) {
            return d(status);
        }

        protected Status d(Status status) {
            com.google.android.gms.common.internal.b.b(!status.f());
            return status;
        }
    }

    public bh(Context context, Looper looper, l lVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
        super(context, looper, 58, bVar, cVar, lVar);
    }

    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    protected bs b(IBinder iBinder) {
        return com.google.android.gms.b.bs.a.a(iBinder);
    }

    protected String i() {
        return "com.google.android.gms.fitness.SessionsApi";
    }

    protected String j() {
        return "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi";
    }
}
