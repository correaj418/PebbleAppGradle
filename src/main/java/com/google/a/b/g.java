package com.google.a.b;

import com.google.a.a.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

abstract class g<K, V> implements az<K, V> {
    private transient Collection<Entry<K, V>> a;
    private transient Set<K> b;
    private transient Map<K, Collection<V>> c;

    private class a extends b<K, V> {
        final /* synthetic */ g a;

        private a(g gVar) {
            this.a = gVar;
        }

        az<K, V> a() {
            return this.a;
        }

        public Iterator<Entry<K, V>> iterator() {
            return this.a.h();
        }
    }

    private class b extends a implements Set<Entry<K, V>> {
        final /* synthetic */ g b;

        private b(g gVar) {
            this.b = gVar;
            super();
        }

        public int hashCode() {
            return bt.a((Set) this);
        }

        public boolean equals(@Nullable Object obj) {
            return bt.a((Set) this, obj);
        }
    }

    abstract Iterator<Entry<K, V>> h();

    abstract Map<K, Collection<V>> i();

    g() {
    }

    public boolean j() {
        return d() == 0;
    }

    public boolean b(@Nullable Object obj, @Nullable Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean c(@Nullable Object obj, @Nullable Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public boolean a(@Nullable K k, @Nullable V v) {
        return b(k).add(v);
    }

    public boolean a(@Nullable K k, Iterable<? extends V> iterable) {
        h.a((Object) iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty() || !b(k).addAll(collection)) {
                return false;
            }
            return true;
        }
        Iterator it = iterable.iterator();
        if (it.hasNext() && at.a(b(k), it)) {
            return true;
        }
        return false;
    }

    public Collection<Entry<K, V>> g() {
        Collection<Entry<K, V>> collection = this.a;
        if (collection != null) {
            return collection;
        }
        collection = k();
        this.a = collection;
        return collection;
    }

    Collection<Entry<K, V>> k() {
        if (this instanceof bs) {
            return new b();
        }
        return new a();
    }

    public Set<K> l() {
        Set<K> set = this.b;
        if (set != null) {
            return set;
        }
        set = f();
        this.b = set;
        return set;
    }

    Set<K> f() {
        return new e(b());
    }

    public Map<K, Collection<V>> b() {
        Map<K, Collection<V>> map = this.c;
        if (map != null) {
            return map;
        }
        map = i();
        this.c = map;
        return map;
    }

    public boolean equals(@Nullable Object obj) {
        return bb.a((az) this, obj);
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString();
    }
}
