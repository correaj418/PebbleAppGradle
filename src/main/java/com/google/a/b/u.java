package com.google.a.b;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class u<E> extends s<E> implements Set<E> {
    protected abstract Set<E> c();

    protected /* synthetic */ Collection a() {
        return c();
    }

    protected /* synthetic */ Object b() {
        return c();
    }

    protected u() {
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || c().equals(obj);
    }

    public int hashCode() {
        return c().hashCode();
    }
}
