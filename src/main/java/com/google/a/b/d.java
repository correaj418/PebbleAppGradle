package com.google.a.b;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

abstract class d<K, V> extends g<K, V> implements Serializable {
    private transient Map<K, Collection<V>> a;
    private transient int b;

    private abstract class b<T> implements Iterator<T> {
        final Iterator<Entry<K, Collection<V>>> b;
        K c = null;
        Collection<V> d = null;
        Iterator<V> e = at.c();
        final /* synthetic */ d f;

        abstract T b(K k, V v);

        b(d dVar) {
            this.f = dVar;
            this.b = dVar.a.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.b.hasNext() || this.e.hasNext();
        }

        public T next() {
            if (!this.e.hasNext()) {
                Entry entry = (Entry) this.b.next();
                this.c = entry.getKey();
                this.d = (Collection) entry.getValue();
                this.e = this.d.iterator();
            }
            return b(this.c, this.e.next());
        }

        public void remove() {
            this.e.remove();
            if (this.d.isEmpty()) {
                this.b.remove();
            }
            this.f.b = this.f.b - 1;
        }
    }

    private class a extends m<K, Collection<V>> {
        final transient Map<K, Collection<V>> a;
        final /* synthetic */ d b;

        class a extends b<K, Collection<V>> {
            final /* synthetic */ a a;

            a(a aVar) {
                this.a = aVar;
            }

            Map<K, Collection<V>> a() {
                return this.a;
            }

            public Iterator<Entry<K, Collection<V>>> iterator() {
                return new b(this.a);
            }

            public boolean contains(Object obj) {
                return l.a(this.a.a.entrySet(), obj);
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                this.a.b.a(((Entry) obj).getKey());
                return true;
            }
        }

        class b implements Iterator<Entry<K, Collection<V>>> {
            final Iterator<Entry<K, Collection<V>>> a = this.c.a.entrySet().iterator();
            Collection<V> b;
            final /* synthetic */ a c;

            b(a aVar) {
                this.c = aVar;
            }

            public /* synthetic */ Object next() {
                return a();
            }

            public boolean hasNext() {
                return this.a.hasNext();
            }

            public Entry<K, Collection<V>> a() {
                Entry entry = (Entry) this.a.next();
                this.b = (Collection) entry.getValue();
                return this.c.a(entry);
            }

            public void remove() {
                this.a.remove();
                d.b(this.c.b, this.b.size());
                this.b.clear();
            }
        }

        public /* synthetic */ Object get(Object obj) {
            return a(obj);
        }

        public /* synthetic */ Object remove(Object obj) {
            return b(obj);
        }

        a(d dVar, Map<K, Collection<V>> map) {
            this.b = dVar;
            this.a = map;
        }

        protected Set<Entry<K, Collection<V>>> a() {
            return new a(this);
        }

        public boolean containsKey(Object obj) {
            return ay.b(this.a, obj);
        }

        public Collection<V> a(Object obj) {
            Collection collection = (Collection) ay.a(this.a, obj);
            if (collection == null) {
                return null;
            }
            return this.b.a(obj, collection);
        }

        public Set<K> keySet() {
            return this.b.l();
        }

        public int size() {
            return this.a.size();
        }

        public Collection<V> b(Object obj) {
            Collection collection = (Collection) this.a.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> c = this.b.c();
            c.addAll(collection);
            d.b(this.b, collection.size());
            collection.clear();
            return c;
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || this.a.equals(obj);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a.toString();
        }

        public void clear() {
            if (this.a == this.b.a) {
                this.b.e();
            } else {
                at.g(new b(this));
            }
        }

        Entry<K, Collection<V>> a(Entry<K, Collection<V>> entry) {
            Object key = entry.getKey();
            return ay.a(key, this.b.a(key, (Collection) entry.getValue()));
        }
    }

    private class c extends e<K, Collection<V>> {
        final /* synthetic */ d a;

        c(d dVar, Map<K, Collection<V>> map) {
            this.a = dVar;
            super(map);
        }

        public Iterator<K> iterator() {
            final Iterator it = b().entrySet().iterator();
            return new Iterator<K>(this) {
                Entry<K, Collection<V>> a;
                final /* synthetic */ c c;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    this.a = (Entry) it.next();
                    return this.a.getKey();
                }

                public void remove() {
                    k.a(this.a != null);
                    Collection collection = (Collection) this.a.getValue();
                    it.remove();
                    d.b(this.c.a, collection.size());
                    collection.clear();
                }
            };
        }

        public boolean remove(Object obj) {
            int i;
            Collection collection = (Collection) b().remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                d.b(this.a, size);
                i = size;
            } else {
                i = 0;
            }
            return i > 0;
        }

        public void clear() {
            at.g(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return b().keySet().containsAll(collection);
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || b().keySet().equals(obj);
        }

        public int hashCode() {
            return b().keySet().hashCode();
        }
    }

    private class g extends AbstractCollection<V> {
        final K b;
        Collection<V> c;
        final g d;
        final Collection<V> e;
        final /* synthetic */ d f;

        class a implements Iterator<V> {
            final Iterator<V> a;
            final Collection<V> b = this.c.c;
            final /* synthetic */ g c;

            a(g gVar) {
                this.c = gVar;
                this.a = gVar.f.a(gVar.c);
            }

            a(g gVar, Iterator<V> it) {
                this.c = gVar;
                this.a = it;
            }

            void a() {
                this.c.a();
                if (this.c.c != this.b) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                a();
                return this.a.hasNext();
            }

            public V next() {
                a();
                return this.a.next();
            }

            public void remove() {
                this.a.remove();
                this.c.f.b = this.c.f.b - 1;
                this.c.b();
            }

            Iterator<V> b() {
                a();
                return this.a;
            }
        }

        g(d dVar, @Nullable K k, Collection<V> collection, @Nullable g gVar) {
            this.f = dVar;
            this.b = k;
            this.c = collection;
            this.d = gVar;
            this.e = gVar == null ? null : gVar.e();
        }

        void a() {
            if (this.d != null) {
                this.d.a();
                if (this.d.e() != this.e) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.c.isEmpty()) {
                Collection collection = (Collection) this.f.a.get(this.b);
                if (collection != null) {
                    this.c = collection;
                }
            }
        }

        void b() {
            if (this.d != null) {
                this.d.b();
            } else if (this.c.isEmpty()) {
                this.f.a.remove(this.b);
            }
        }

        K c() {
            return this.b;
        }

        void d() {
            if (this.d != null) {
                this.d.d();
            } else {
                this.f.a.put(this.b, this.c);
            }
        }

        public int size() {
            a();
            return this.c.size();
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            a();
            return this.c.equals(obj);
        }

        public int hashCode() {
            a();
            return this.c.hashCode();
        }

        public String toString() {
            a();
            return this.c.toString();
        }

        Collection<V> e() {
            return this.c;
        }

        public Iterator<V> iterator() {
            a();
            return new a(this);
        }

        public boolean add(V v) {
            a();
            boolean isEmpty = this.c.isEmpty();
            boolean add = this.c.add(v);
            if (add) {
                this.f.b = this.f.b + 1;
                if (isEmpty) {
                    d();
                }
            }
            return add;
        }

        g f() {
            return this.d;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.c.addAll(collection);
            if (!addAll) {
                return addAll;
            }
            d.a(this.f, this.c.size() - size);
            if (size != 0) {
                return addAll;
            }
            d();
            return addAll;
        }

        public boolean contains(Object obj) {
            a();
            return this.c.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            a();
            return this.c.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.c.clear();
                d.b(this.f, size);
                b();
            }
        }

        public boolean remove(Object obj) {
            a();
            boolean remove = this.c.remove(obj);
            if (remove) {
                this.f.b = this.f.b - 1;
                b();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.c.removeAll(collection);
            if (!removeAll) {
                return removeAll;
            }
            d.a(this.f, this.c.size() - size);
            b();
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            com.google.a.a.h.a((Object) collection);
            int size = size();
            boolean retainAll = this.c.retainAll(collection);
            if (retainAll) {
                d.a(this.f, this.c.size() - size);
                b();
            }
            return retainAll;
        }
    }

    private class h extends g implements List<V> {
        final /* synthetic */ d g;

        private class a extends com.google.a.b.d$g.a implements ListIterator<V> {
            final /* synthetic */ h d;

            a(h hVar) {
                this.d = hVar;
                super(hVar);
            }

            public a(h hVar, int i) {
                this.d = hVar;
                super(hVar, hVar.g().listIterator(i));
            }

            private ListIterator<V> c() {
                return (ListIterator) b();
            }

            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            public V previous() {
                return c().previous();
            }

            public int nextIndex() {
                return c().nextIndex();
            }

            public int previousIndex() {
                return c().previousIndex();
            }

            public void set(V v) {
                c().set(v);
            }

            public void add(V v) {
                boolean isEmpty = this.d.isEmpty();
                c().add(v);
                this.d.g.b = this.d.g.b + 1;
                if (isEmpty) {
                    this.d.d();
                }
            }
        }

        h(d dVar, @Nullable K k, List<V> list, @Nullable g gVar) {
            this.g = dVar;
            super(dVar, k, list, gVar);
        }

        List<V> g() {
            return (List) e();
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i, collection);
            if (!addAll) {
                return addAll;
            }
            d.a(this.g, e().size() - size);
            if (size != 0) {
                return addAll;
            }
            d();
            return addAll;
        }

        public V get(int i) {
            a();
            return g().get(i);
        }

        public V set(int i, V v) {
            a();
            return g().set(i, v);
        }

        public void add(int i, V v) {
            a();
            boolean isEmpty = e().isEmpty();
            g().add(i, v);
            this.g.b = this.g.b + 1;
            if (isEmpty) {
                d();
            }
        }

        public V remove(int i) {
            a();
            V remove = g().remove(i);
            this.g.b = this.g.b - 1;
            b();
            return remove;
        }

        public int indexOf(Object obj) {
            a();
            return g().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            a();
            return g().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            a();
            return new a(this);
        }

        public ListIterator<V> listIterator(int i) {
            a();
            return new a(this, i);
        }

        public List<V> subList(int i, int i2) {
            g f;
            a();
            d dVar = this.g;
            Object c = c();
            List subList = g().subList(i, i2);
            if (f() != null) {
                f = f();
            }
            return dVar.a(c, subList, f);
        }
    }

    private class d extends h implements RandomAccess {
        final /* synthetic */ d a;

        d(d dVar, @Nullable K k, List<V> list, @Nullable g gVar) {
            this.a = dVar;
            super(dVar, k, list, gVar);
        }
    }

    private class e extends a implements SortedMap<K, Collection<V>> {
        SortedSet<K> c;
        final /* synthetic */ d d;

        /* synthetic */ Set e() {
            return d();
        }

        public /* synthetic */ Set keySet() {
            return c();
        }

        e(d dVar, SortedMap<K, Collection<V>> sortedMap) {
            this.d = dVar;
            super(dVar, sortedMap);
        }

        SortedMap<K, Collection<V>> b() {
            return (SortedMap) this.a;
        }

        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        public K firstKey() {
            return b().firstKey();
        }

        public K lastKey() {
            return b().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new e(this.d, b().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new e(this.d, b().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new e(this.d, b().tailMap(k));
        }

        public SortedSet<K> c() {
            SortedSet<K> sortedSet = this.c;
            if (sortedSet != null) {
                return sortedSet;
            }
            sortedSet = d();
            this.c = sortedSet;
            return sortedSet;
        }

        SortedSet<K> d() {
            return new f(this.d, b());
        }
    }

    private class f extends c implements SortedSet<K> {
        final /* synthetic */ d b;

        f(d dVar, SortedMap<K, Collection<V>> sortedMap) {
            this.b = dVar;
            super(dVar, sortedMap);
        }

        SortedMap<K, Collection<V>> a() {
            return (SortedMap) super.b();
        }

        public Comparator<? super K> comparator() {
            return a().comparator();
        }

        public K first() {
            return a().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new f(this.b, a().headMap(k));
        }

        public K last() {
            return a().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new f(this.b, a().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new f(this.b, a().tailMap(k));
        }
    }

    private class i extends g implements Set<V> {
        final /* synthetic */ d a;

        i(d dVar, @Nullable K k, Set<V> set) {
            this.a = dVar;
            super(dVar, k, set, null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a = bt.a((Set) this.c, (Collection) collection);
            if (!a) {
                return a;
            }
            d.a(this.a, this.c.size() - size);
            b();
            return a;
        }
    }

    private class j extends g implements SortedSet<V> {
        final /* synthetic */ d a;

        j(d dVar, @Nullable K k, SortedSet<V> sortedSet, @Nullable g gVar) {
            this.a = dVar;
            super(dVar, k, sortedSet, gVar);
        }

        SortedSet<V> g() {
            return (SortedSet) e();
        }

        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        public V first() {
            a();
            return g().first();
        }

        public V last() {
            a();
            return g().last();
        }

        public SortedSet<V> headSet(V v) {
            g f;
            a();
            d dVar = this.a;
            Object c = c();
            SortedSet headSet = g().headSet(v);
            if (f() != null) {
                f = f();
            }
            return new j(dVar, c, headSet, f);
        }

        public SortedSet<V> subSet(V v, V v2) {
            g f;
            a();
            d dVar = this.a;
            Object c = c();
            SortedSet subSet = g().subSet(v, v2);
            if (f() != null) {
                f = f();
            }
            return new j(dVar, c, subSet, f);
        }

        public SortedSet<V> tailSet(V v) {
            g f;
            a();
            d dVar = this.a;
            Object c = c();
            SortedSet tailSet = g().tailSet(v);
            if (f() != null) {
                f = f();
            }
            return new j(dVar, c, tailSet, f);
        }
    }

    abstract Collection<V> c();

    static /* synthetic */ int a(d dVar, int i) {
        int i2 = dVar.b + i;
        dVar.b = i2;
        return i2;
    }

    static /* synthetic */ int b(d dVar, int i) {
        int i2 = dVar.b - i;
        dVar.b = i2;
        return i2;
    }

    protected d(Map<K, Collection<V>> map) {
        com.google.a.a.h.a(map.isEmpty());
        this.a = map;
    }

    Collection<V> c(@Nullable K k) {
        return c();
    }

    public int d() {
        return this.b;
    }

    public boolean a(@Nullable K k, @Nullable V v) {
        Collection collection = (Collection) this.a.get(k);
        if (collection == null) {
            collection = c((Object) k);
            if (collection.add(v)) {
                this.b++;
                this.a.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.b++;
            return true;
        }
    }

    public void e() {
        for (Collection clear : this.a.values()) {
            clear.clear();
        }
        this.a.clear();
        this.b = 0;
    }

    public Collection<V> b(@Nullable K k) {
        Collection collection = (Collection) this.a.get(k);
        if (collection == null) {
            collection = c((Object) k);
        }
        return a((Object) k, collection);
    }

    Collection<V> a(@Nullable K k, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new j(this, k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new i(this, k, (Set) collection);
        }
        if (collection instanceof List) {
            return a(k, (List) collection, null);
        }
        return new g(this, k, collection, null);
    }

    private List<V> a(@Nullable K k, List<V> list, @Nullable g gVar) {
        return list instanceof RandomAccess ? new d(this, k, list, gVar) : new h(this, k, list, gVar);
    }

    private Iterator<V> a(Collection<V> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    Set<K> f() {
        return this.a instanceof SortedMap ? new f(this, (SortedMap) this.a) : new c(this, this.a);
    }

    private int a(Object obj) {
        Collection collection = (Collection) ay.c(this.a, obj);
        int i = 0;
        if (collection != null) {
            i = collection.size();
            collection.clear();
            this.b -= i;
        }
        return i;
    }

    public Collection<Entry<K, V>> g() {
        return super.g();
    }

    Iterator<Entry<K, V>> h() {
        return new b<Entry<K, V>>(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            /* synthetic */ Object b(Object obj, Object obj2) {
                return a(obj, obj2);
            }

            Entry<K, V> a(K k, V v) {
                return ay.a((Object) k, (Object) v);
            }
        };
    }

    Map<K, Collection<V>> i() {
        return this.a instanceof SortedMap ? new e(this, (SortedMap) this.a) : new a(this, this.a);
    }
}
