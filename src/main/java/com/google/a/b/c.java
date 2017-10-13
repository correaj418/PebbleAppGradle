package com.google.a.b;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

abstract class c<K, V> extends d<K, V> implements av<K, V> {
    abstract List<V> a();

    public /* synthetic */ Collection b(Object obj) {
        return a(obj);
    }

    /* synthetic */ Collection c() {
        return a();
    }

    protected c(Map<K, Collection<V>> map) {
        super(map);
    }

    public List<V> a(@Nullable K k) {
        return (List) super.b((Object) k);
    }

    public boolean a(@Nullable K k, @Nullable V v) {
        return super.a((Object) k, (Object) v);
    }

    public Map<K, Collection<V>> b() {
        return super.b();
    }

    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
