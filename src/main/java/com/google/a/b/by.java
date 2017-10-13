package com.google.a.b;

import com.google.a.a.h;
import java.util.Comparator;
import java.util.SortedSet;

final class by {
    public static boolean a(Comparator<?> comparator, Iterable<?> iterable) {
        Object a;
        h.a((Object) comparator);
        h.a((Object) iterable);
        if (iterable instanceof SortedSet) {
            a = a((SortedSet) iterable);
        } else if (!(iterable instanceof bx)) {
            return false;
        } else {
            a = ((bx) iterable).comparator();
        }
        return comparator.equals(a);
    }

    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            return bg.b();
        }
        return comparator;
    }
}
