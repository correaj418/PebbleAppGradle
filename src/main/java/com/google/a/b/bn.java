package com.google.a.b;

import com.google.a.a.g;
import com.google.a.a.h;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class bn<E> extends al<E> {
    static final bn<Object> a = new bn(ad.c());
    private final transient d<E>[] b;
    private final transient d<E>[] c;
    private final transient int d;
    private final transient int e;
    private transient am<E> f;

    private final class a extends b<E> {
        final /* synthetic */ bn a;

        private a(bn bnVar) {
            this.a = bnVar;
        }

        E a(int i) {
            return this.a.b[i].a();
        }

        public boolean contains(@Nullable Object obj) {
            return this.a.contains(obj);
        }

        boolean e() {
            return true;
        }

        public int size() {
            return this.a.b.length;
        }
    }

    private static final class b<E> extends d<E> {
        private final d<E> a;

        b(E e, int i, d<E> dVar) {
            super(e, i);
            this.a = dVar;
        }

        public d<E> c() {
            return this.a;
        }
    }

    public /* synthetic */ Set d() {
        return h();
    }

    bn(Collection<? extends com.google.a.b.bc.a<? extends E>> collection) {
        int size = collection.size();
        d[] dVarArr = new d[size];
        if (size == 0) {
            this.b = dVarArr;
            this.c = null;
            this.d = 0;
            this.e = 0;
            this.f = am.h();
            return;
        }
        size = w.a(size, 1.0d);
        int i = size - 1;
        d[] dVarArr2 = new d[size];
        int i2 = 0;
        long j = 0;
        int i3 = 0;
        for (com.google.a.b.bc.a aVar : collection) {
            d dVar;
            Object a = h.a(aVar.a());
            int b = aVar.b();
            int hashCode = a.hashCode();
            int a2 = w.a(hashCode) & i;
            d dVar2 = dVarArr2[a2];
            if (dVar2 == null) {
                Object obj = (!(aVar instanceof d) || (aVar instanceof b)) ? null : 1;
                dVar = obj != null ? (d) aVar : new d(a, b);
            } else {
                dVar = new b(a, b, dVar2);
            }
            int i4 = (hashCode ^ b) + i3;
            int i5 = i2 + 1;
            dVarArr[i2] = dVar;
            dVarArr2[a2] = dVar;
            j = ((long) b) + j;
            i2 = i5;
            i3 = i4;
        }
        this.b = dVarArr;
        this.c = dVarArr2;
        this.d = com.google.a.f.a.b(j);
        this.e = i3;
    }

    boolean e() {
        return false;
    }

    public int a(@Nullable Object obj) {
        d[] dVarArr = this.c;
        if (obj == null || dVarArr == null) {
            return 0;
        }
        for (d dVar = dVarArr[w.a(obj) & (dVarArr.length - 1)]; dVar != null; dVar = dVar.c()) {
            if (g.a(obj, dVar.a())) {
                return dVar.b();
            }
        }
        return 0;
    }

    public int size() {
        return this.d;
    }

    public am<E> h() {
        am<E> amVar = this.f;
        if (amVar != null) {
            return amVar;
        }
        amVar = new a();
        this.f = amVar;
        return amVar;
    }

    com.google.a.b.bc.a<E> a(int i) {
        return this.b[i];
    }

    public int hashCode() {
        return this.e;
    }
}
