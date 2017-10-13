package com.google.b.b.a;

import com.google.b.a.b;
import com.google.b.b.c;
import com.google.b.c.a;
import com.google.b.f;
import com.google.b.k;
import com.google.b.t;
import com.google.b.w;
import com.google.b.x;

public final class d implements x {
    private final c a;

    public d(c cVar) {
        this.a = cVar;
    }

    public <T> w<T> a(f fVar, a<T> aVar) {
        b bVar = (b) aVar.getRawType().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return a(this.a, fVar, aVar, bVar);
    }

    w<?> a(c cVar, f fVar, a<?> aVar, b bVar) {
        w<?> wVar;
        Object a = cVar.a(a.get(bVar.a())).a();
        if (a instanceof w) {
            wVar = (w) a;
        } else if (a instanceof x) {
            wVar = ((x) a).a(fVar, aVar);
        } else if ((a instanceof t) || (a instanceof k)) {
            k kVar;
            t tVar = a instanceof t ? (t) a : null;
            if (a instanceof k) {
                kVar = (k) a;
            } else {
                kVar = null;
            }
            wVar = new l(tVar, kVar, fVar, aVar, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (wVar != null) {
            return wVar.a();
        }
        return wVar;
    }
}
