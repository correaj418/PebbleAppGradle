package com.b.b.h;

import android.text.TextUtils;
import com.b.a.b.f;
import com.b.a.c.d;
import com.b.a.c.q;
import com.b.a.m;
import com.b.b.h;
import com.b.b.j;
import com.b.b.u.a;
import com.b.b.y;

public class e extends j {
    public com.b.a.b.e<m> a(j jVar, d dVar, final f<a> fVar) {
        if (dVar.d().getScheme().startsWith("http")) {
            return jVar.e().a(dVar, new com.b.a.c.c.a(this) {
                final /* synthetic */ e b;

                public void a(Exception exception, com.b.a.c.e eVar) {
                    h hVar;
                    d dVar = null;
                    long j = -1;
                    y yVar = y.LOADED_FROM_NETWORK;
                    if (eVar != null) {
                        dVar = eVar.o();
                        hVar = new h(eVar.j(), eVar.l_(), eVar.k());
                        j = (long) q.a(hVar.a());
                        CharSequence a = eVar.k().a("X-Served-From");
                        if (TextUtils.equals(a, "cache")) {
                            yVar = y.LOADED_FROM_CACHE;
                        } else if (TextUtils.equals(a, "conditional-cache")) {
                            yVar = y.LOADED_FROM_CONDITIONAL_CACHE;
                        }
                    } else {
                        hVar = null;
                    }
                    fVar.a(exception, new a(eVar, j, yVar, hVar, dVar));
                }
            });
        }
        return null;
    }
}
