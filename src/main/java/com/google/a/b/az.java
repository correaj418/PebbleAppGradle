package com.google.a.b;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public interface az<K, V> {
    boolean a(@Nullable K k, Iterable<? extends V> iterable);

    boolean a(@Nullable K k, @Nullable V v);

    Collection<V> b(@Nullable K k);

    Map<K, Collection<V>> b();

    boolean b(@Nullable Object obj, @Nullable Object obj2);

    boolean c(@Nullable Object obj, @Nullable Object obj2);

    int d();

    void e();

    Collection<Entry<K, V>> g();

    boolean j();

    Set<K> l();
}
