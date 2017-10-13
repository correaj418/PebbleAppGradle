package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.l;

public class bb extends ba<bm> {

    public static class a extends b<bb, com.google.android.gms.common.api.a.a.b> {
        public bb a(Context context, Looper looper, l lVar, com.google.android.gms.common.api.a.a.b bVar, c.b bVar2, c.c cVar) {
            return new bb(context, looper, lVar, bVar2, cVar);
        }

        public /* synthetic */ f a(Context context, Looper looper, l lVar, Object obj, c.b bVar, c.c cVar) {
            return a(context, looper, lVar, (com.google.android.gms.common.api.a.a.b) obj, bVar, cVar);
        }
    }

    public bb(Context context, Looper looper, l lVar, c.b bVar, c.c cVar) {
        super(context, looper, 59, bVar, cVar, lVar);
    }

    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    protected bm b(IBinder iBinder) {
        return com.google.android.gms.b.bm.a.a(iBinder);
    }

    protected String i() {
        return "com.google.android.gms.fitness.BleApi";
    }

    protected String j() {
        return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
    }
}
