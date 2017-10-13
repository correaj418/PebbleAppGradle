package com.google.a.b;

import java.util.Map;

public interface ax<K, V> {

    public interface a<V> {
        V a();

        V b();
    }

    Map<K, V> a();

    Map<K, V> b();

    Map<K, V> c();

    Map<K, a<V>> d();
}
