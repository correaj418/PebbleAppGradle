package com.google.a.b;

import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

class p<E> extends aq<E> {
    private final aq<E> c;

    public /* synthetic */ Iterator descendingIterator() {
        return c();
    }

    public /* synthetic */ NavigableSet descendingSet() {
        return b();
    }

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    p(aq<E> aqVar) {
        super(bg.a(aqVar.comparator()).a());
        this.c = aqVar;
    }

    public boolean contains(@Nullable Object obj) {
        return this.c.contains(obj);
    }

    public int size() {
        return this.c.size();
    }

    public ce<E> j_() {
        return this.c.c();
    }

    aq<E> a(E e, boolean z) {
        return this.c.d(e, z).b();
    }

    aq<E> a(E e, boolean z, E e2, boolean z2) {
        return this.c.b(e2, z2, e, z).b();
    }

    aq<E> b(E e, boolean z) {
        return this.c.c((Object) e, z).b();
    }

    public aq<E> b() {
        return this.c;
    }

    public ce<E> c() {
        return this.c.j_();
    }

    aq<E> d() {
        throw new AssertionError("should never be called");
    }

    public E lower(E e) {
        return this.c.higher(e);
    }

    public E floor(E e) {
        return this.c.ceiling(e);
    }

    public E ceiling(E e) {
        return this.c.floor(e);
    }

    public E higher(E e) {
        return this.c.lower(e);
    }

    int a(@Nullable Object obj) {
        int a = this.c.a(obj);
        return a == -1 ? a : (size() - 1) - a;
    }

    boolean e() {
        return this.c.e();
    }
}
