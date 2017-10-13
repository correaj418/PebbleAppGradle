package com.google.a.b;

import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.annotation.Nullable;

public final class ay {
    static final com.google.a.a.f.a a = l.a.c("=");

    static class AnonymousClass1 extends cb<K, Entry<K, V>> {
        final /* synthetic */ com.google.a.a.e a;

        /* synthetic */ Object a(Object obj) {
            return b(obj);
        }

        Entry<K, V> b(K k) {
            return ay.a((Object) k, this.a.apply(k));
        }
    }

    public interface c<K, V1, V2> {
        V2 a(@Nullable K k, @Nullable V1 v1);
    }

    private enum a implements com.google.a.a.e<Entry<?, ?>, Object> {
        KEY {
            @Nullable
            public Object apply(Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            @Nullable
            public Object apply(Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    static abstract class b<K, V> extends a<Entry<K, V>> {
        abstract Map<K, V> a();

        b() {
        }

        public int size() {
            return a().size();
        }

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object a = ay.a(a(), key);
            if (!com.google.a.a.g.a(a, entry.getValue())) {
                return false;
            }
            if (a != null || a().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            return a().keySet().remove(((Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.a.a.h.a((Object) collection));
            } catch (UnsupportedOperationException e) {
                return bt.a((Set) this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.a.a.h.a((Object) collection));
            } catch (UnsupportedOperationException e) {
                Collection a = bt.a(collection.size());
                for (Object next : collection) {
                    if (contains(next)) {
                        a.add(((Entry) next).getKey());
                    }
                }
                return a().keySet().retainAll(a);
            }
        }
    }

    static abstract class d<K, V> extends AbstractMap<K, V> {
        abstract Iterator<Entry<K, V>> c();

        d() {
        }

        public Set<Entry<K, V>> entrySet() {
            return new b<K, V>(this) {
                final /* synthetic */ d a;

                {
                    this.a = r1;
                }

                Map<K, V> a() {
                    return this.a;
                }

                public Iterator<Entry<K, V>> iterator() {
                    return this.a.c();
                }
            };
        }

        public void clear() {
            at.g(c());
        }
    }

    static class e<K, V> extends a<K> {
        @Weak
        final Map<K, V> c;

        e(Map<K, V> map) {
            this.c = (Map) com.google.a.a.h.a((Object) map);
        }

        Map<K, V> b() {
            return this.c;
        }

        public Iterator<K> iterator() {
            return ay.a(b().entrySet().iterator());
        }

        public int size() {
            return b().size();
        }

        public boolean isEmpty() {
            return b().isEmpty();
        }

        public boolean contains(Object obj) {
            return b().containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            b().remove(obj);
            return true;
        }

        public void clear() {
            b().clear();
        }
    }

    static class f<K, V> implements ax<K, V> {
        final Map<K, V> a;
        final Map<K, V> b;
        final Map<K, V> c;
        final Map<K, com.google.a.b.ax.a<V>> d;

        f(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, com.google.a.b.ax.a<V>> map4) {
            this.a = ay.c((Map) map);
            this.b = ay.c((Map) map2);
            this.c = ay.c((Map) map3);
            this.d = ay.c((Map) map4);
        }

        public boolean e() {
            return this.a.isEmpty() && this.b.isEmpty() && this.d.isEmpty();
        }

        public Map<K, V> a() {
            return this.a;
        }

        public Map<K, V> b() {
            return this.b;
        }

        public Map<K, V> c() {
            return this.c;
        }

        public Map<K, com.google.a.b.ax.a<V>> d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ax)) {
                return false;
            }
            ax axVar = (ax) obj;
            if (a().equals(axVar.a()) && b().equals(axVar.b()) && c().equals(axVar.c()) && d().equals(axVar.d())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return com.google.a.a.g.a(a(), b(), c(), d());
        }

        public String toString() {
            if (e()) {
                return "equal";
            }
            StringBuilder stringBuilder = new StringBuilder("not equal");
            if (!this.a.isEmpty()) {
                stringBuilder.append(": only on left=").append(this.a);
            }
            if (!this.b.isEmpty()) {
                stringBuilder.append(": only on right=").append(this.b);
            }
            if (!this.d.isEmpty()) {
                stringBuilder.append(": value differences=").append(this.d);
            }
            return stringBuilder.toString();
        }
    }

    static class g<K, V> extends f<K, V> implements ca<K, V> {
        public /* synthetic */ Map a() {
            return h();
        }

        public /* synthetic */ Map b() {
            return i();
        }

        public /* synthetic */ Map c() {
            return g();
        }

        public /* synthetic */ Map d() {
            return f();
        }

        g(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, com.google.a.b.ax.a<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        public SortedMap<K, com.google.a.b.ax.a<V>> f() {
            return (SortedMap) super.d();
        }

        public SortedMap<K, V> g() {
            return (SortedMap) super.c();
        }

        public SortedMap<K, V> h() {
            return (SortedMap) super.a();
        }

        public SortedMap<K, V> i() {
            return (SortedMap) super.b();
        }
    }

    static class h<K, V1, V2> extends d<K, V2> {
        final Map<K, V1> a;
        final c<? super K, ? super V1, V2> b;

        h(Map<K, V1> map, c<? super K, ? super V1, V2> cVar) {
            this.a = (Map) com.google.a.a.h.a((Object) map);
            this.b = (c) com.google.a.a.h.a((Object) cVar);
        }

        public int size() {
            return this.a.size();
        }

        public boolean containsKey(Object obj) {
            return this.a.containsKey(obj);
        }

        public V2 get(Object obj) {
            Object obj2 = this.a.get(obj);
            return (obj2 != null || this.a.containsKey(obj)) ? this.b.a(obj, obj2) : null;
        }

        public V2 remove(Object obj) {
            return this.a.containsKey(obj) ? this.b.a(obj, this.a.remove(obj)) : null;
        }

        public void clear() {
            this.a.clear();
        }

        public Set<K> keySet() {
            return this.a.keySet();
        }

        Iterator<Entry<K, V2>> c() {
            return at.a(this.a.entrySet().iterator(), ay.a(this.b));
        }

        public Collection<V2> values() {
            return new l(this);
        }
    }

    static class j<K, V1, V2> extends h<K, V1, V2> implements SortedMap<K, V2> {
        protected SortedMap<K, V1> b() {
            return (SortedMap) this.a;
        }

        j(SortedMap<K, V1> sortedMap, c<? super K, ? super V1, V2> cVar) {
            super(sortedMap, cVar);
        }

        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        public K firstKey() {
            return b().firstKey();
        }

        public SortedMap<K, V2> headMap(K k) {
            return ay.a(b().headMap(k), this.b);
        }

        public K lastKey() {
            return b().lastKey();
        }

        public SortedMap<K, V2> subMap(K k, K k2) {
            return ay.a(b().subMap(k, k2), this.b);
        }

        public SortedMap<K, V2> tailMap(K k) {
            return ay.a(b().tailMap(k), this.b);
        }
    }

    private static class i<K, V1, V2> extends j<K, V1, V2> implements NavigableMap<K, V2> {
        protected /* synthetic */ SortedMap b() {
            return a();
        }

        public /* synthetic */ SortedMap headMap(Object obj) {
            return a(obj);
        }

        public /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
            return a(obj, obj2);
        }

        public /* synthetic */ SortedMap tailMap(Object obj) {
            return b(obj);
        }

        i(NavigableMap<K, V1> navigableMap, c<? super K, ? super V1, V2> cVar) {
            super(navigableMap, cVar);
        }

        public Entry<K, V2> ceilingEntry(K k) {
            return a(a().ceilingEntry(k));
        }

        public K ceilingKey(K k) {
            return a().ceilingKey(k);
        }

        public NavigableSet<K> descendingKeySet() {
            return a().descendingKeySet();
        }

        public NavigableMap<K, V2> descendingMap() {
            return ay.a(a().descendingMap(), this.b);
        }

        public Entry<K, V2> firstEntry() {
            return a(a().firstEntry());
        }

        public Entry<K, V2> floorEntry(K k) {
            return a(a().floorEntry(k));
        }

        public K floorKey(K k) {
            return a().floorKey(k);
        }

        public NavigableMap<K, V2> a(K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, V2> headMap(K k, boolean z) {
            return ay.a(a().headMap(k, z), this.b);
        }

        public Entry<K, V2> higherEntry(K k) {
            return a(a().higherEntry(k));
        }

        public K higherKey(K k) {
            return a().higherKey(k);
        }

        public Entry<K, V2> lastEntry() {
            return a(a().lastEntry());
        }

        public Entry<K, V2> lowerEntry(K k) {
            return a(a().lowerEntry(k));
        }

        public K lowerKey(K k) {
            return a().lowerKey(k);
        }

        public NavigableSet<K> navigableKeySet() {
            return a().navigableKeySet();
        }

        public Entry<K, V2> pollFirstEntry() {
            return a(a().pollFirstEntry());
        }

        public Entry<K, V2> pollLastEntry() {
            return a(a().pollLastEntry());
        }

        public NavigableMap<K, V2> subMap(K k, boolean z, K k2, boolean z2) {
            return ay.a(a().subMap(k, z, k2, z2), this.b);
        }

        public NavigableMap<K, V2> a(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, V2> b(K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, V2> tailMap(K k, boolean z) {
            return ay.a(a().tailMap(k, z), this.b);
        }

        @Nullable
        private Entry<K, V2> a(@Nullable Entry<K, V1> entry) {
            return entry == null ? null : ay.a(this.b, (Entry) entry);
        }

        protected NavigableMap<K, V1> a() {
            return (NavigableMap) super.b();
        }
    }

    static class k<V> implements com.google.a.b.ax.a<V> {
        private final V a;
        private final V b;

        static <V> com.google.a.b.ax.a<V> a(@Nullable V v, @Nullable V v2) {
            return new k(v, v2);
        }

        private k(@Nullable V v, @Nullable V v2) {
            this.a = v;
            this.b = v2;
        }

        public V a() {
            return this.a;
        }

        public V b() {
            return this.b;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof com.google.a.b.ax.a)) {
                return false;
            }
            com.google.a.b.ax.a aVar = (com.google.a.b.ax.a) obj;
            if (com.google.a.a.g.a(this.a, aVar.a()) && com.google.a.a.g.a(this.b, aVar.b())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return com.google.a.a.g.a(this.a, this.b);
        }

        public String toString() {
            return "(" + this.a + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + this.b + ")";
        }
    }

    static class l<K, V> extends AbstractCollection<V> {
        @Weak
        final Map<K, V> a;

        l(Map<K, V> map) {
            this.a = (Map) com.google.a.a.h.a((Object) map);
        }

        final Map<K, V> a() {
            return this.a;
        }

        public Iterator<V> iterator() {
            return ay.b(a().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException e) {
                for (Entry entry : a().entrySet()) {
                    if (com.google.a.a.g.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.a.a.h.a((Object) collection));
            } catch (UnsupportedOperationException e) {
                Collection a = bt.a();
                for (Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        a.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(a);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.a.a.h.a((Object) collection));
            } catch (UnsupportedOperationException e) {
                Collection a = bt.a();
                for (Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        a.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(a);
            }
        }

        public int size() {
            return a().size();
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        public boolean contains(@Nullable Object obj) {
            return a().containsValue(obj);
        }

        public void clear() {
            a().clear();
        }
    }

    static abstract class m<K, V> extends AbstractMap<K, V> {
        private transient Set<Entry<K, V>> a;
        private transient Set<K> b;
        private transient Collection<V> c;

        abstract Set<Entry<K, V>> a();

        m() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.a;
            if (set != null) {
                return set;
            }
            set = a();
            this.a = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.b;
            if (set != null) {
                return set;
            }
            set = e();
            this.b = set;
            return set;
        }

        Set<K> e() {
            return new e(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.c;
            if (collection != null) {
                return collection;
            }
            collection = f();
            this.c = collection;
            return collection;
        }

        Collection<V> f() {
            return new l(this);
        }
    }

    static <K> com.google.a.a.e<Entry<K, ?>, K> a() {
        return a.KEY;
    }

    static <V> com.google.a.a.e<Entry<?, V>, V> b() {
        return a.VALUE;
    }

    static <K, V> Iterator<K> a(Iterator<Entry<K, V>> it) {
        return at.a((Iterator) it, a());
    }

    static <K, V> Iterator<V> b(Iterator<Entry<K, V>> it) {
        return at.a((Iterator) it, b());
    }

    public static <K, V> HashMap<K, V> c() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> a(int i) {
        return new HashMap(b(i));
    }

    static int b(int i) {
        if (i < 3) {
            k.a(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> LinkedHashMap<K, V> d() {
        return new LinkedHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> c(int i) {
        return new LinkedHashMap(b(i));
    }

    public static <C, K extends C, V> TreeMap<K, V> a(@Nullable Comparator<C> comparator) {
        return new TreeMap(comparator);
    }

    public static <K, V> ax<K, V> a(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        if (map instanceof SortedMap) {
            return a((SortedMap) map, (Map) map2);
        }
        return a(map, map2, com.google.a.a.d.a());
    }

    public static <K, V> ax<K, V> a(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, com.google.a.a.d<? super V> dVar) {
        com.google.a.a.h.a((Object) dVar);
        Map d = d();
        Map linkedHashMap = new LinkedHashMap(map2);
        Map d2 = d();
        Map d3 = d();
        a(map, map2, dVar, d, linkedHashMap, d2, d3);
        return new f(d, linkedHashMap, d2, d3);
    }

    private static <K, V> void a(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, com.google.a.a.d<? super V> dVar, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, com.google.a.b.ax.a<V>> map6) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (map2.containsKey(key)) {
                Object remove = map4.remove(key);
                if (dVar.a(value, remove)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, k.a(value, remove));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    private static <K, V> Map<K, V> c(Map<K, V> map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) map);
        }
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> ca<K, V> a(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        com.google.a.a.h.a((Object) sortedMap);
        com.google.a.a.h.a((Object) map);
        Comparator b = b(sortedMap.comparator());
        Object a = a(b);
        Object a2 = a(b);
        a2.putAll(map);
        Object a3 = a(b);
        Object a4 = a(b);
        a(sortedMap, map, com.google.a.a.d.a(), a, a2, a3, a4);
        return new g(a, a2, a3, a4);
    }

    static <E> Comparator<? super E> b(@Nullable Comparator<? super E> comparator) {
        return comparator != null ? comparator : bg.b();
    }

    public static <K, V> Entry<K, V> a(@Nullable K k, @Nullable V v) {
        return new aa(k, v);
    }

    static <K, V> Entry<K, V> a(final Entry<? extends K, ? extends V> entry) {
        com.google.a.a.h.a((Object) entry);
        return new f<K, V>() {
            public K getKey() {
                return entry.getKey();
            }

            public V getValue() {
                return entry.getValue();
            }
        };
    }

    static <K, V> ce<Entry<K, V>> c(final Iterator<Entry<K, V>> it) {
        return new ce<Entry<K, V>>() {
            public /* synthetic */ Object next() {
                return a();
            }

            public boolean hasNext() {
                return it.hasNext();
            }

            public Entry<K, V> a() {
                return ay.a((Entry) it.next());
            }
        };
    }

    public static <K, V1, V2> Map<K, V2> a(Map<K, V1> map, com.google.a.a.e<? super V1, V2> eVar) {
        return a((Map) map, a((com.google.a.a.e) eVar));
    }

    public static <K, V1, V2> Map<K, V2> a(Map<K, V1> map, c<? super K, ? super V1, V2> cVar) {
        if (map instanceof SortedMap) {
            return a((SortedMap) map, (c) cVar);
        }
        return new h(map, cVar);
    }

    public static <K, V1, V2> SortedMap<K, V2> a(SortedMap<K, V1> sortedMap, c<? super K, ? super V1, V2> cVar) {
        return bi.a((SortedMap) sortedMap, (c) cVar);
    }

    public static <K, V1, V2> NavigableMap<K, V2> a(NavigableMap<K, V1> navigableMap, c<? super K, ? super V1, V2> cVar) {
        return new i(navigableMap, cVar);
    }

    static <K, V1, V2> SortedMap<K, V2> b(SortedMap<K, V1> sortedMap, c<? super K, ? super V1, V2> cVar) {
        return new j(sortedMap, cVar);
    }

    static <K, V1, V2> c<K, V1, V2> a(final com.google.a.a.e<? super V1, V2> eVar) {
        com.google.a.a.h.a((Object) eVar);
        return new c<K, V1, V2>() {
            public V2 a(K k, V1 v1) {
                return eVar.apply(v1);
            }
        };
    }

    static <K, V1, V2> com.google.a.a.e<V1, V2> a(final c<? super K, V1, V2> cVar, final K k) {
        com.google.a.a.h.a((Object) cVar);
        return new com.google.a.a.e<V1, V2>() {
            public V2 apply(@Nullable V1 v1) {
                return cVar.a(k, v1);
            }
        };
    }

    static <V2, K, V1> Entry<K, V2> a(final c<? super K, ? super V1, V2> cVar, final Entry<K, V1> entry) {
        com.google.a.a.h.a((Object) cVar);
        com.google.a.a.h.a((Object) entry);
        return new f<K, V2>() {
            public K getKey() {
                return entry.getKey();
            }

            public V2 getValue() {
                return cVar.a(entry.getKey(), entry.getValue());
            }
        };
    }

    static <K, V1, V2> com.google.a.a.e<Entry<K, V1>, Entry<K, V2>> a(final c<? super K, ? super V1, V2> cVar) {
        com.google.a.a.h.a((Object) cVar);
        return new com.google.a.a.e<Entry<K, V1>, Entry<K, V2>>() {
            public /* synthetic */ Object apply(Object obj) {
                return a((Entry) obj);
            }

            public Entry<K, V2> a(Entry<K, V1> entry) {
                return ay.a(cVar, (Entry) entry);
            }
        };
    }

    static <V> V a(Map<?, V> map, @Nullable Object obj) {
        V v = null;
        com.google.a.a.h.a((Object) map);
        try {
            v = map.get(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean b(Map<?, ?> map, Object obj) {
        boolean z = false;
        com.google.a.a.h.a((Object) map);
        try {
            z = map.containsKey(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static <V> V c(Map<?, V> map, Object obj) {
        V v = null;
        com.google.a.a.h.a((Object) map);
        try {
            v = map.remove(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }

    static String a(Map<?, ?> map) {
        StringBuilder append = l.a(map.size()).append('{');
        a.a(append, (Map) map);
        return append.append('}').toString();
    }

    @Nullable
    static <K> K b(@Nullable Entry<K, ?> entry) {
        return entry == null ? null : entry.getKey();
    }

    @Nullable
    static <V> V c(@Nullable Entry<?, V> entry) {
        return entry == null ? null : entry.getValue();
    }
}
