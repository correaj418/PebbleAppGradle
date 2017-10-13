package com.google.a.b;

import java.util.Comparator;

interface bx<T> extends Iterable<T> {
    Comparator<? super T> comparator();
}
