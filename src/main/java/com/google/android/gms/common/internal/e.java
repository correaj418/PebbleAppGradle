package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.h;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;

public class e<T extends IInterface> extends p<T> {
    private final h<T> d;

    public e(Context context, Looper looper, int i, b bVar, c cVar, l lVar, h<T> hVar) {
        super(context, looper, i, lVar, bVar, cVar);
        this.d = hVar;
    }

    protected T a(IBinder iBinder) {
        return this.d.a(iBinder);
    }

    protected void a(int i, T t) {
        this.d.a(i, t);
    }

    protected String i() {
        return this.d.a();
    }

    protected String j() {
        return this.d.b();
    }

    public h<T> k() {
        return this.d;
    }
}
