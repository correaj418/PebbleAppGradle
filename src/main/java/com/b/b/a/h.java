package com.b.b.a;

import java.lang.ref.Reference;
import java.util.Hashtable;

public abstract class h<K, V, R extends Reference<V>> {
    Hashtable<K, R> a = new Hashtable();

    protected abstract R a(V v);

    public V a(K k, V v) {
        Reference reference = (Reference) this.a.put(k, a(v));
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public V b(K k) {
        Reference reference = (Reference) this.a.remove(k);
        if (reference == null) {
            return null;
        }
        return reference.get();
    }
}
