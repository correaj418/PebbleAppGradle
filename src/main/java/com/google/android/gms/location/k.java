package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a.a.b;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.a.g;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.location.internal.c;
import com.google.android.gms.location.internal.e;
import com.google.android.gms.location.internal.p;

public class k {
    public static final com.google.android.gms.common.api.a<b> a = new com.google.android.gms.common.api.a("LocationServices.API", f, e);
    public static final c b = new c();
    public static final f c = new e();
    public static final m d = new p();
    private static final g<com.google.android.gms.location.internal.k> e = new g();
    private static final com.google.android.gms.common.api.a.b<com.google.android.gms.location.internal.k, b> f = new com.google.android.gms.common.api.a.b<com.google.android.gms.location.internal.k, b>() {
        public /* synthetic */ f a(Context context, Looper looper, l lVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
            return a(context, looper, lVar, (b) obj, bVar, cVar);
        }

        public com.google.android.gms.location.internal.k a(Context context, Looper looper, l lVar, b bVar, com.google.android.gms.common.api.c.b bVar2, com.google.android.gms.common.api.c.c cVar) {
            return new com.google.android.gms.location.internal.k(context, looper, bVar2, cVar, "locationServices", lVar);
        }
    };

    public static abstract class a<R extends com.google.android.gms.common.api.f> extends com.google.android.gms.b.k.a<R, com.google.android.gms.location.internal.k> {
        public a(com.google.android.gms.common.api.c cVar) {
            super(k.e, cVar);
        }
    }

    public static com.google.android.gms.location.internal.k a(com.google.android.gms.common.api.c cVar) {
        boolean z = true;
        com.google.android.gms.common.internal.b.b(cVar != null, "GoogleApiClient parameter is required.");
        com.google.android.gms.location.internal.k kVar = (com.google.android.gms.location.internal.k) cVar.a(e);
        if (kVar == null) {
            z = false;
        }
        com.google.android.gms.common.internal.b.a(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return kVar;
    }
}
