package com.google.a.b;

import java.util.ListIterator;

abstract class cc<F, T> extends cb<F, T> implements ListIterator<T> {
    cc(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> a() {
        return at.i(this.b);
    }

    public final boolean hasPrevious() {
        return a().hasPrevious();
    }

    public final T previous() {
        return a(a().previous());
    }

    public final int nextIndex() {
        return a().nextIndex();
    }

    public final int previousIndex() {
        return a().previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
