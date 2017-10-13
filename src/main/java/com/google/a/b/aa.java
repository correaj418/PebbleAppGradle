package com.google.a.b;

import java.io.Serializable;
import javax.annotation.Nullable;

class aa<K, V> extends f<K, V> implements Serializable {
    final K g;
    final V h;

    aa(@Nullable K k, @Nullable V v) {
        this.g = k;
        this.h = v;
    }

    @Nullable
    public final K getKey() {
        return this.g;
    }

    @Nullable
    public final V getValue() {
        return this.h;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
