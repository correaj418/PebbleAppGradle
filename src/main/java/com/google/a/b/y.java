package com.google.a.b;

import java.util.Collection;

public abstract class y<K, V> extends af<K, V> implements i<K, V> {
    public abstract y<V, K> b();

    public /* synthetic */ z d() {
        return i_();
    }

    public /* synthetic */ Collection values() {
        return i_();
    }

    public static <K, V> y<K, V> h_() {
        return bk.b;
    }

    public static <K, V> y<K, V> a(K k, V v) {
        return new bu(k, v);
    }

    y() {
    }

    public am<V> i_() {
        return b().i();
    }
}
