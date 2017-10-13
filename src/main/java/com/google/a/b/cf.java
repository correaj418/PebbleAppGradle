package com.google.a.b;

import java.util.ListIterator;

public abstract class cf<E> extends ce<E> implements ListIterator<E> {
    protected cf() {
    }

    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
