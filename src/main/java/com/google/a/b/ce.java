package com.google.a.b;

import java.util.Iterator;

public abstract class ce<E> implements Iterator<E> {
    protected ce() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
