package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.l;

public class be extends ba<bp> {

    public static class a extends b<be, com.google.android.gms.common.api.a.a.b> {
        public be a(Context context, Looper looper, l lVar, com.google.android.gms.common.api.a.a.b bVar, c.b bVar2, c.c cVar) {
            return new be(context, looper, lVar, bVar2, cVar);
        }

        public /* synthetic */ f a(Context context, Looper looper, l lVar, Object obj, c.b bVar, c.c cVar) {
            return a(context, looper, lVar, (com.google.android.gms.common.api.a.a.b) obj, bVar, cVar);
        }
    }

    public be(Context context, Looper looper, l lVar, c.b bVar, c.c cVar) {
        super(context, looper, 61, bVar, cVar, lVar);
    }

    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    protected bp b(IBinder iBinder) {
        return com.google.android.gms.b.bp.a.a(iBinder);
    }

    protected String i() {
        return "com.google.android.gms.fitness.InternalApi";
    }

    protected String j() {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }
}
