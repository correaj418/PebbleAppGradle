package com.b.b.a;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

public class i<K, V> extends h<K, V, SoftReference<V>> {
    protected /* synthetic */ Reference a(Object obj) {
        return c(obj);
    }

    protected SoftReference<V> c(V v) {
        return new SoftReference(v);
    }
}
