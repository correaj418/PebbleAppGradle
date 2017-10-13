package com.google.a.b;

import com.google.j2objc.annotations.Weak;
import java.util.ListIterator;

class bj<E> extends x<E> {
    @Weak
    private final z<E> a;
    private final ad<? extends E> b;

    public /* synthetic */ ListIterator listIterator(int i) {
        return a(i);
    }

    bj(z<E> zVar, ad<? extends E> adVar) {
        this.a = zVar;
        this.b = adVar;
    }

    bj(z<E> zVar, Object[] objArr) {
        this((z) zVar, ad.b(objArr));
    }

    z<E> b() {
        return this.a;
    }

    public cf<E> a(int i) {
        return this.b.a(i);
    }

    int a(Object[] objArr, int i) {
        return this.b.a(objArr, i);
    }

    public E get(int i) {
        return this.b.get(i);
    }
}
