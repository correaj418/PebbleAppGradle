package com.google.a.b;

import com.google.a.a.h;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

public abstract class aq<E> extends ar<E> implements bx<E>, NavigableSet<E> {
    private static final Comparator<Comparable> c = bg.b();
    private static final bp<Comparable> d = new bp(ad.c(), c);
    final transient Comparator<? super E> a;
    transient aq<E> b;

    abstract int a(@Nullable Object obj);

    abstract aq<E> a(E e, boolean z);

    abstract aq<E> a(E e, boolean z, E e2, boolean z2);

    abstract aq<E> b(E e, boolean z);

    public abstract ce<E> c();

    public abstract ce<E> j_();

    public /* synthetic */ Iterator descendingIterator() {
        return c();
    }

    public /* synthetic */ NavigableSet descendingSet() {
        return b();
    }

    public /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return c(obj, z);
    }

    public /* synthetic */ SortedSet headSet(Object obj) {
        return c(obj);
    }

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    public /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return b(obj, z, obj2, z2);
    }

    public /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return c(obj, obj2);
    }

    public /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return d(obj, z);
    }

    public /* synthetic */ SortedSet tailSet(Object obj) {
        return d(obj);
    }

    static <E> bp<E> a(Comparator<? super E> comparator) {
        if (c.equals(comparator)) {
            return d;
        }
        return new bp(ad.c(), comparator);
    }

    int b(Object obj, Object obj2) {
        return a(this.a, obj, obj2);
    }

    static int a(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    aq(Comparator<? super E> comparator) {
        this.a = comparator;
    }

    public Comparator<? super E> comparator() {
        return this.a;
    }

    public aq<E> c(E e) {
        return c((Object) e, false);
    }

    public aq<E> c(E e, boolean z) {
        return a(h.a((Object) e), z);
    }

    public aq<E> c(E e, E e2) {
        return b(e, true, e2, false);
    }

    public aq<E> b(E e, boolean z, E e2, boolean z2) {
        h.a((Object) e);
        h.a((Object) e2);
        h.a(this.a.compare(e, e2) <= 0);
        return a(e, z, e2, z2);
    }

    public aq<E> d(E e) {
        return d(e, true);
    }

    public aq<E> d(E e, boolean z) {
        return b(h.a((Object) e), z);
    }

    public E lower(E e) {
        return at.b(c((Object) e, false).c(), null);
    }

    public E floor(E e) {
        return at.b(c((Object) e, true).c(), null);
    }

    public E ceiling(E e) {
        return as.a(d(e, true), null);
    }

    public E higher(E e) {
        return as.a(d(e, false), null);
    }

    public E first() {
        return j_().next();
    }

    public E last() {
        return c().next();
    }

    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    public aq<E> b() {
        aq<E> aqVar = this.b;
        if (aqVar != null) {
            return aqVar;
        }
        aqVar = d();
        this.b = aqVar;
        aqVar.b = this;
        return aqVar;
    }

    aq<E> d() {
        return new p(this);
    }
}
