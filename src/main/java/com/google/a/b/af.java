package com.google.a.b;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class af<K, V> implements Serializable, Map<K, V> {
    static final Entry<?, ?>[] a = new Entry[0];
    private transient am<Entry<K, V>> b;
    private transient am<K> c;
    private transient z<V> d;

    static abstract class b<K, V> extends af<K, V> {

        class a extends ah<K, V> {
            final /* synthetic */ b a;

            public /* synthetic */ Iterator iterator() {
                return j_();
            }

            a(b bVar) {
                this.a = bVar;
            }

            af<K, V> c() {
                return this.a;
            }

            public ce<Entry<K, V>> j_() {
                return this.a.b();
            }
        }

        abstract ce<Entry<K, V>> b();

        b() {
        }

        public /* synthetic */ Set entrySet() {
            return super.g();
        }

        public /* synthetic */ Set keySet() {
            return super.i();
        }

        public /* synthetic */ Collection values() {
            return super.d();
        }

        am<Entry<K, V>> h() {
            return new a(this);
        }
    }

    public static class a<K, V> {
        Comparator<? super V> a;
        ag<K, V>[] b;
        int c;
        boolean d;

        public a() {
            this(4);
        }

        a(int i) {
            this.b = new ag[i];
            this.c = 0;
            this.d = false;
        }

        private void a(int i) {
            if (i > this.b.length) {
                this.b = (ag[]) bf.b(this.b, com.google.a.b.z.b.a(this.b.length, i));
                this.d = false;
            }
        }

        public a<K, V> a(K k, V v) {
            a(this.c + 1);
            ag c = af.c(k, v);
            ag[] agVarArr = this.b;
            int i = this.c;
            this.c = i + 1;
            agVarArr[i] = c;
            return this;
        }

        public a<K, V> a(Entry<? extends K, ? extends V> entry) {
            return a(entry.getKey(), entry.getValue());
        }

        public a<K, V> a(Map<? extends K, ? extends V> map) {
            return a(map.entrySet());
        }

        public a<K, V> a(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                a(((Collection) iterable).size() + this.c);
            }
            for (Entry a : iterable) {
                a(a);
            }
            return this;
        }

        public af<K, V> a() {
            switch (this.c) {
                case 0:
                    return af.e();
                case 1:
                    return af.b(this.b[0].getKey(), this.b[0].getValue());
                default:
                    if (this.a != null) {
                        if (this.d) {
                            this.b = (ag[]) bf.b(this.b, this.c);
                        }
                        Arrays.sort(this.b, 0, this.c, bg.a(this.a).a(ay.b()));
                    }
                    this.d = this.c == this.b.length;
                    return bm.a(this.c, this.b);
            }
        }
    }

    abstract boolean c();

    public abstract V get(@Nullable Object obj);

    abstract am<Entry<K, V>> h();

    public /* synthetic */ Set entrySet() {
        return g();
    }

    public /* synthetic */ Set keySet() {
        return i();
    }

    public /* synthetic */ Collection values() {
        return d();
    }

    public static <K, V> af<K, V> e() {
        return y.h_();
    }

    public static <K, V> af<K, V> b(K k, V v) {
        return y.a(k, v);
    }

    public static <K, V> af<K, V> a(K k, V v, K k2, V v2, K k3, V v3) {
        return bm.a(c(k, v), c(k2, v2), c(k3, v3));
    }

    public static <K, V> af<K, V> a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return bm.a(c(k, v), c(k2, v2), c(k3, v3), c(k4, v4));
    }

    static <K, V> ag<K, V> c(K k, V v) {
        return new ag(k, v);
    }

    public static <K, V> a<K, V> f() {
        return new a();
    }

    static void a(boolean z, String str, Entry<?, ?> entry, Entry<?, ?> entry2) {
        if (!z) {
            throw new IllegalArgumentException("Multiple entries with same " + str + ": " + entry + " and " + entry2);
        }
    }

    public static <K, V> af<K, V> a(Map<? extends K, ? extends V> map) {
        if ((map instanceof af) && !(map instanceof ao)) {
            af<K, V> afVar = (af) map;
            if (!afVar.c()) {
                return afVar;
            }
        } else if (map instanceof EnumMap) {
            return a((EnumMap) map);
        }
        return a(map.entrySet());
    }

    public static <K, V> af<K, V> a(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        Entry[] entryArr = (Entry[]) as.a((Iterable) iterable, a);
        switch (entryArr.length) {
            case 0:
                return e();
            case 1:
                Entry entry = entryArr[0];
                return b(entry.getKey(), entry.getValue());
            default:
                return bm.a(entryArr);
        }
    }

    private static <K extends Enum<K>, V> af<K, V> a(EnumMap<K, ? extends V> enumMap) {
        EnumMap enumMap2 = new EnumMap(enumMap);
        for (Entry entry : enumMap2.entrySet()) {
            k.a(entry.getKey(), entry.getValue());
        }
        return ab.a(enumMap2);
    }

    af() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@Nullable Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@Nullable Object obj) {
        return d().contains(obj);
    }

    public am<Entry<K, V>> g() {
        am<Entry<K, V>> amVar = this.b;
        if (amVar != null) {
            return amVar;
        }
        amVar = h();
        this.b = amVar;
        return amVar;
    }

    public am<K> i() {
        am<K> amVar = this.c;
        if (amVar != null) {
            return amVar;
        }
        amVar = j();
        this.c = amVar;
        return amVar;
    }

    am<K> j() {
        return isEmpty() ? am.h() : new ai(this);
    }

    ce<K> a() {
        final ce j_ = g().j_();
        return new ce<K>(this) {
            final /* synthetic */ af b;

            public boolean hasNext() {
                return j_.hasNext();
            }

            public K next() {
                return ((Entry) j_.next()).getKey();
            }
        };
    }

    public z<V> d() {
        z<V> zVar = this.d;
        if (zVar != null) {
            return zVar;
        }
        zVar = new aj(this);
        this.d = zVar;
        return zVar;
    }

    public boolean equals(@Nullable Object obj) {
        return ay.d(this, obj);
    }

    public int hashCode() {
        return bt.a(g());
    }

    boolean k() {
        return false;
    }

    public String toString() {
        return ay.a((Map) this);
    }
}
