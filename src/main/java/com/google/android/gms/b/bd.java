package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.l;

public class bd extends ba<bo> {

    static abstract class a<R extends f> extends com.google.android.gms.b.k.a<R, bd> {
        public a(com.google.android.gms.common.api.c cVar) {
            super(com.google.android.gms.fitness.c.c, cVar);
        }
    }

    public static class b extends com.google.android.gms.common.api.a.b<bd, com.google.android.gms.common.api.a.a.b> {
        public bd a(Context context, Looper looper, l lVar, com.google.android.gms.common.api.a.a.b bVar, com.google.android.gms.common.api.c.b bVar2, com.google.android.gms.common.api.c.c cVar) {
            return new bd(context, looper, lVar, bVar2, cVar);
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

    public bd(Context context, Looper looper, l lVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
        super(context, looper, 57, bVar, cVar, lVar);
    }

    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    protected bo b(IBinder iBinder) {
        return com.google.android.gms.b.bo.a.a(iBinder);
    }

    protected String i() {
        return "com.google.android.gms.fitness.HistoryApi";
    }

    protected String j() {
        return "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi";
    }
}
