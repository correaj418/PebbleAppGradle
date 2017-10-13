package com.b.b.g;

import com.b.a.b.e;
import com.b.a.b.j;
import com.b.a.d.a;
import com.b.a.d.b;
import com.b.a.k;
import com.b.a.m;
import com.google.b.f;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class d<T> implements a<T> {
    f a;
    Type b;

    public d(f fVar, Class<T> cls) {
        this.a = fVar;
        this.b = cls;
    }

    public e<T> a(m mVar) {
        return (e) new b().a(mVar).b(new j<T, k>(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            protected void a(k kVar) {
                b(this.a.a.a(new com.google.b.d.a(new InputStreamReader(new com.b.a.e.a(kVar))), this.a.b));
            }
        });
    }

    public Type a() {
        return this.b;
    }
}
