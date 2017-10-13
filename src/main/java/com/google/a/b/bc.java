package com.google.a.b;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

public interface bc<E> extends Collection<E> {

    public interface a<E> {
        E a();

        int b();
    }

    int a(@Nullable Object obj);

    int a(@Nullable E e, int i);

    Set<a<E>> a();

    boolean a(E e, int i, int i2);

    int b(@Nullable Object obj, int i);

    int c(E e, int i);

    boolean contains(@Nullable Object obj);

    boolean containsAll(Collection<?> collection);

    Set<E> d();

    boolean remove(@Nullable Object obj);
}
