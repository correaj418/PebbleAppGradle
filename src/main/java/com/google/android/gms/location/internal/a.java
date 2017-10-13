package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.p;

public class a extends p<h> {
    protected final o<h> d = new o<h>(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void a() {
            this.a.r();
        }

        public h b() {
            return (h) this.a.t();
        }

        public /* synthetic */ IInterface c() {
            return b();
        }
    };
    private final String e;

    public a(Context context, Looper looper, b bVar, c cVar, String str, l lVar) {
        super(context, looper, 23, lVar, bVar, cVar);
        this.e = str;
    }

    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    protected h b(IBinder iBinder) {
        return com.google.android.gms.location.internal.h.a.a(iBinder);
    }

    protected String i() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String j() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected Bundle q() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.e);
        return bundle;
    }
}
