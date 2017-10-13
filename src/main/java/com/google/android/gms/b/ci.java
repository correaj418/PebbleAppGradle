package com.google.android.gms.b;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.fitness.h;
import com.google.android.gms.fitness.request.SessionInsertRequest;

public class ci implements h {
    public d<Status> a(c cVar, final SessionInsertRequest sessionInsertRequest) {
        return cVar.a(new c(this, cVar) {
            final /* synthetic */ ci e;

            protected void a(bh bhVar) {
                ((bs) bhVar.t()).a(new SessionInsertRequest(sessionInsertRequest, new cj(this)));
            }

            protected /* synthetic */ void b(a.c cVar) {
                a((bh) cVar);
            }
        });
    }
}
