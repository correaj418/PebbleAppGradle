package com.google.a.b;

import com.google.a.a.g;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

abstract class h<E> extends AbstractCollection<E> implements bc<E> {
    private transient Set<E> a;
    private transient Set<com.google.a.b.bc.a<E>> b;

    class a extends b<E> {
        final /* synthetic */ h a;

        a(h hVar) {
            this.a = hVar;
        }

        bc<E> a() {
            return this.a;
        }
    }

    class b extends c<E> {
        final /* synthetic */ h a;

        b(h hVar) {
            this.a = hVar;
        }

        bc<E> a() {
            return this.a;
        }

        public Iterator<com.google.a.b.bc.a<E>> iterator() {
            return this.a.b();
        }

        public int size() {
            return this.a.c();
        }
    }

    abstract Iterator<com.google.a.b.bc.a<E>> b();

    abstract int c();

    h() {
    }

    public int size() {
        return bd.b((bc) this);
    }

    public boolean isEmpty() {
        return a().isEmpty();
    }

    public boolean contains(@Nullable Object obj) {
        return a(obj) > 0;
    }

    public Iterator<E> iterator() {
        return bd.a((bc) this);
    }

    public int a(@Nullable Object obj) {
        for (com.google.a.b.bc.a aVar : a()) {
            if (g.a(aVar.a(), obj)) {
                return aVar.b();
            }
        }
        return 0;
    }

    public boolean add(@Nullable E e) {
        a(e, 1);
        return true;
    }

    public int a(@Nullable E e, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(@Nullable Object obj) {
        return b(obj, 1) > 0;
    }

    public int b(@Nullable Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public int c(@Nullable E e, int i) {
        return bd.a(this, e, i);
    }

    public boolean a(@Nullable E e, int i, int i2) {
        return bd.a(this, e, i, i2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return bd.a((bc) this, (Collection) collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return bd.b(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return bd.c(this, collection);
    }

    public void clear() {
        at.g(b());
    }

    public Set<E> d() {
        Set<E> set = this.a;
        if (set != null) {
            return set;
        }
        set = e();
        this.a = set;
        return set;
    }

    Set<E> e() {
        return new a(this);
    }

    public Set<com.google.a.b.bc.a<E>> a() {
        Set<com.google.a.b.bc.a<E>> set = this.b;
        if (set != null) {
            return set;
        }
        set = f();
        this.b = set;
        return set;
    }

    Set<com.google.a.b.bc.a<E>> f() {
        return new b(this);
    }

    public boolean equals(@Nullable Object obj) {
        return bd.a((bc) this, obj);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
