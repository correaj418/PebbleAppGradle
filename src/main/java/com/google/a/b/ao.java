package com.google.a.b;

import com.google.a.a.h;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

public final class ao<K, V> extends ap<K, V> implements NavigableMap<K, V> {
    private static final Comparator<Comparable> b = bg.b();
    private static final ao<Comparable, Object> c = new ao(aq.a(bg.b()), ad.c());
    private final transient bp<K> d;
    private final transient ad<V> e;
    private transient ao<K, V> f;

    class a extends ah<K, V> {
        final /* synthetic */ ao a;

        public /* synthetic */ Iterator iterator() {
            return j_();
        }

        a(ao aoVar) {
            this.a = aoVar;
        }

        public ce<Entry<K, V>> j_() {
            return f().j_();
        }

        ad<Entry<K, V>> g() {
            return new x<Entry<K, V>>(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public /* synthetic */ Object get(int i) {
                    return b(i);
                }

                public Entry<K, V> b(int i) {
                    return ay.a(this.a.a.d.f().get(i), this.a.a.e.get(i));
                }

                z<Entry<K, V>> b() {
                    return this.a;
                }
            };
        }

        af<K, V> c() {
            return this.a;
        }
    }

    public /* synthetic */ NavigableSet descendingKeySet() {
        return o();
    }

    public /* synthetic */ NavigableMap descendingMap() {
        return m();
    }

    public /* synthetic */ Set entrySet() {
        return g();
    }

    public /* synthetic */ NavigableMap headMap(Object obj, boolean z) {
        return a(obj, z);
    }

    public /* synthetic */ SortedMap headMap(Object obj) {
        return a(obj);
    }

    public /* synthetic */ am i() {
        return l();
    }

    public /* synthetic */ Set keySet() {
        return l();
    }

    public /* synthetic */ NavigableSet navigableKeySet() {
        return n();
    }

    public /* synthetic */ NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return a(obj, z, obj2, z2);
    }

    public /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return a(obj, obj2);
    }

    public /* synthetic */ NavigableMap tailMap(Object obj, boolean z) {
        return b(obj, z);
    }

    public /* synthetic */ SortedMap tailMap(Object obj) {
        return b(obj);
    }

    public /* synthetic */ Collection values() {
        return d();
    }

    static <K, V> ao<K, V> a(Comparator<? super K> comparator) {
        if (bg.b().equals(comparator)) {
            return b();
        }
        return new ao(aq.a((Comparator) comparator), ad.c());
    }

    public static <K, V> ao<K, V> b() {
        return c;
    }

    ao(bp<K> bpVar, ad<V> adVar) {
        this(bpVar, adVar, null);
    }

    ao(bp<K> bpVar, ad<V> adVar, ao<K, V> aoVar) {
        this.d = bpVar;
        this.e = adVar;
        this.f = aoVar;
    }

    public int size() {
        return this.e.size();
    }

    public V get(@Nullable Object obj) {
        int a = this.d.a(obj);
        return a == -1 ? null : this.e.get(a);
    }

    boolean c() {
        return this.d.e() || this.e.e();
    }

    public am<Entry<K, V>> g() {
        return super.g();
    }

    am<Entry<K, V>> h() {
        return isEmpty() ? am.h() : new a(this);
    }

    public aq<K> l() {
        return this.d;
    }

    public z<V> d() {
        return this.e;
    }

    public Comparator<? super K> comparator() {
        return l().comparator();
    }

    public K firstKey() {
        return l().first();
    }

    public K lastKey() {
        return l().last();
    }

    private ao<K, V> a(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i == i2) {
            return a(comparator());
        }
        return new ao(this.d.a(i, i2), this.e.a(i, i2));
    }

    public ao<K, V> a(K k) {
        return a((Object) k, false);
    }

    public ao<K, V> a(K k, boolean z) {
        return a(0, this.d.e(h.a((Object) k), z));
    }

    public ao<K, V> a(K k, K k2) {
        return a(k, true, k2, false);
    }

    public ao<K, V> a(K k, boolean z, K k2, boolean z2) {
        h.a((Object) k);
        h.a((Object) k2);
        h.a(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return a((Object) k2, z2).b(k, z);
    }

    public ao<K, V> b(K k) {
        return b(k, true);
    }

    public ao<K, V> b(K k, boolean z) {
        return a(this.d.f(h.a((Object) k), z), size());
    }

    public Entry<K, V> lowerEntry(K k) {
        return a((Object) k, false).lastEntry();
    }

    public K lowerKey(K k) {
        return ay.b(lowerEntry(k));
    }

    public Entry<K, V> floorEntry(K k) {
        return a((Object) k, true).lastEntry();
    }

    public K floorKey(K k) {
        return ay.b(floorEntry(k));
    }

    public Entry<K, V> ceilingEntry(K k) {
        return b(k, true).firstEntry();
    }

    public K ceilingKey(K k) {
        return ay.b(ceilingEntry(k));
    }

    public Entry<K, V> higherEntry(K k) {
        return b(k, false).firstEntry();
    }

    public K higherKey(K k) {
        return ay.b(higherEntry(k));
    }

    public Entry<K, V> firstEntry() {
        return isEmpty() ? null : (Entry) g().f().get(0);
    }

    public Entry<K, V> lastEntry() {
        return isEmpty() ? null : (Entry) g().f().get(size() - 1);
    }

    @Deprecated
    public final Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public ao<K, V> m() {
        ao<K, V> aoVar = this.f;
        if (aoVar != null) {
            return aoVar;
        }
        if (isEmpty()) {
            return a(bg.a(comparator()).a());
        }
        return new ao((bp) this.d.b(), this.e.h(), this);
    }

    public aq<K> n() {
        return this.d;
    }

    public aq<K> o() {
        return this.d.b();
    }
}
