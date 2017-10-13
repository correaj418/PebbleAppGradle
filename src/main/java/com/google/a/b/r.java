package com.google.a.b;

import com.google.a.a.h;
import com.google.a.a.i;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;

public abstract class r<E> implements Iterable<E> {
    private final Iterable<E> a;

    protected r() {
        this.a = this;
    }

    r(Iterable<E> iterable) {
        this.a = (Iterable) h.a((Object) iterable);
    }

    @CheckReturnValue
    public static <E> r<E> a(final Iterable<E> iterable) {
        return iterable instanceof r ? (r) iterable : new r<E>(iterable) {
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    @CheckReturnValue
    public String toString() {
        return as.a(this.a);
    }

    @CheckReturnValue
    public final r<E> a(i<? super E> iVar) {
        return a(as.b(this.a, iVar));
    }

    @CheckReturnValue
    public final am<E> a() {
        return am.a(this.a);
    }
}
