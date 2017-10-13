package com.google.a.b;

import java.util.Comparator;
import javax.annotation.Nullable;

final class an<E> extends bj<E> implements bx<E> {
    /* synthetic */ z b() {
        return j();
    }

    an(aq<E> aqVar, ad<E> adVar) {
        super((z) aqVar, (ad) adVar);
    }

    aq<E> j() {
        return (aq) super.b();
    }

    public Comparator<? super E> comparator() {
        return j().comparator();
    }

    public int indexOf(@Nullable Object obj) {
        int a = j().a(obj);
        return (a < 0 || !get(a).equals(obj)) ? -1 : a;
    }

    public int lastIndexOf(@Nullable Object obj) {
        return indexOf(obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    ad<E> b(int i, int i2) {
        return new bp(super.b(i, i2), comparator()).f();
    }
}
