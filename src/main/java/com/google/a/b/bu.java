package com.google.a.b;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class bu<K, V> extends y<K, V> {
    final transient K b;
    final transient V c;
    transient y<V, K> d;

    bu(K k, V v) {
        k.a((Object) k, (Object) v);
        this.b = k;
        this.c = v;
    }

    private bu(K k, V v, y<V, K> yVar) {
        this.b = k;
        this.c = v;
        this.d = yVar;
    }

    public V get(@Nullable Object obj) {
        return this.b.equals(obj) ? this.c : null;
    }

    public int size() {
        return 1;
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.b.equals(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return this.c.equals(obj);
    }

    boolean c() {
        return false;
    }

    am<Entry<K, V>> h() {
        return am.b(ay.a(this.b, this.c));
    }

    am<K> j() {
        return am.b(this.b);
    }

    public y<V, K> b() {
        y<V, K> yVar = this.d;
        if (yVar != null) {
            return yVar;
        }
        yVar = new bu(this.c, this.b, this);
        this.d = yVar;
        return yVar;
    }
}
