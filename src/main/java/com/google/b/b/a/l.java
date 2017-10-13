package com.google.b.b.a;

import com.google.b.d.c;
import com.google.b.f;
import com.google.b.j;
import com.google.b.k;
import com.google.b.s;
import com.google.b.t;
import com.google.b.w;
import com.google.b.x;
import java.lang.reflect.Type;

public final class l<T> extends w<T> {
    private final t<T> a;
    private final k<T> b;
    private final f c;
    private final com.google.b.c.a<T> d;
    private final x e;
    private final a f = new a();
    private w<T> g;

    private final class a implements j, s {
        final /* synthetic */ l a;

        private a(l lVar) {
            this.a = lVar;
        }

        public <R> R a(com.google.b.l lVar, Type type) {
            return this.a.c.a(lVar, type);
        }
    }

    private static final class b implements x {
        private final com.google.b.c.a<?> a;
        private final boolean b;
        private final Class<?> c;
        private final t<?> d;
        private final k<?> e;

        b(Object obj, com.google.b.c.a<?> aVar, boolean z, Class<?> cls) {
            this.d = obj instanceof t ? (t) obj : null;
            if (obj instanceof k) {
                obj = (k) obj;
            } else {
                obj = null;
            }
            this.e = obj;
            boolean z2 = (this.d == null && this.e == null) ? false : true;
            com.google.b.b.a.a(z2);
            this.a = aVar;
            this.b = z;
            this.c = cls;
        }

        public <T> w<T> a(f fVar, com.google.b.c.a<T> aVar) {
            boolean isAssignableFrom = this.a != null ? this.a.equals(aVar) || (this.b && this.a.getType() == aVar.getRawType()) : this.c.isAssignableFrom(aVar.getRawType());
            return isAssignableFrom ? new l(this.d, this.e, fVar, aVar, this) : null;
        }
    }

    public l(t<T> tVar, k<T> kVar, f fVar, com.google.b.c.a<T> aVar, x xVar) {
        this.a = tVar;
        this.b = kVar;
        this.c = fVar;
        this.d = aVar;
        this.e = xVar;
    }

    public T b(com.google.b.d.a aVar) {
        if (this.b == null) {
            return b().b(aVar);
        }
        com.google.b.l a = com.google.b.b.j.a(aVar);
        if (a.k()) {
            return null;
        }
        return this.b.deserialize(a, this.d.getType(), this.f);
    }

    public void a(c cVar, T t) {
        if (this.a == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.google.b.b.j.a(this.a.a(t, this.d.getType(), this.f), cVar);
        }
    }

    private w<T> b() {
        w<T> wVar = this.g;
        if (wVar != null) {
            return wVar;
        }
        wVar = this.c.a(this.e, this.d);
        this.g = wVar;
        return wVar;
    }

    public static x a(com.google.b.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, false, null);
    }

    public static x b(com.google.b.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }
}
