package com.b.b.g;

import com.b.a.b.e;
import com.b.a.b.j;
import com.b.a.d.a;
import com.b.a.d.b;
import com.b.a.k;
import com.b.a.m;
import com.google.b.l;
import com.google.b.p;
import com.google.b.q;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public abstract class c<T extends l> implements a<T> {
    Charset a;
    Class<? extends l> b;

    public c(Class<? extends T> cls) {
        this.b = cls;
    }

    public e<T> a(m mVar) {
        final String n = mVar.n();
        return (e) new b().a(mVar).b(new j<T, k>(this) {
            final /* synthetic */ c b;

            protected void a(k kVar) {
                Reader inputStreamReader;
                q qVar = new q();
                InputStream aVar = new com.b.a.e.a(kVar);
                if (this.b.a != null) {
                    inputStreamReader = new InputStreamReader(aVar, this.b.a);
                } else if (n != null) {
                    inputStreamReader = new InputStreamReader(aVar, n);
                } else {
                    inputStreamReader = new InputStreamReader(aVar);
                }
                l a = qVar.a(new com.google.b.d.a(inputStreamReader));
                if (a.k() || a.j()) {
                    throw new p("unable to parse json");
                } else if (this.b.b.isInstance(a)) {
                    b(null, a);
                } else {
                    throw new ClassCastException(a.getClass().getCanonicalName() + " can not be casted to " + this.b.b.getCanonicalName());
                }
            }
        });
    }

    public Type a() {
        return this.b;
    }
}
