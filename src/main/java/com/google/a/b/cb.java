package com.google.a.b;

import com.google.a.a.h;
import java.util.Iterator;

abstract class cb<F, T> implements Iterator<T> {
    final Iterator<? extends F> b;

    abstract T a(F f);

    cb(Iterator<? extends F> it) {
        this.b = (Iterator) h.a((Object) it);
    }

    public final boolean hasNext() {
        return this.b.hasNext();
    }

    public final T next() {
        return a(this.b.next());
    }

    public final void remove() {
        this.b.remove();
    }
}
