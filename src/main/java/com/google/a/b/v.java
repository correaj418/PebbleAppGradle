package com.google.a.b;

import com.google.a.a.g;
import com.google.a.a.h;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

public final class v<K, V> extends d<K, V> implements i<K, V>, Serializable {
    private transient a<K, V>[] a;
    private transient a<K, V>[] b;
    private transient a<K, V> c;
    private transient a<K, V> d;
    private transient int e;
    private transient int f;
    private transient int g;
    private transient i<V, K> h;

    abstract class c<T> implements Iterator<T> {
        a<K, V> b = this.e.c;
        a<K, V> c = null;
        int d = this.e.g;
        final /* synthetic */ v e;

        abstract T b(a<K, V> aVar);

        c(v vVar) {
            this.e = vVar;
        }

        public boolean hasNext() {
            if (this.e.g == this.d) {
                return this.b != null;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public T next() {
            if (hasNext()) {
                a aVar = this.b;
                this.b = aVar.e;
                this.c = aVar;
                return b(aVar);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.e.g != this.d) {
                throw new ConcurrentModificationException();
            }
            k.a(this.c != null);
            this.e.a(this.c);
            this.d = this.e.g;
            this.c = null;
        }
    }

    private static final class a<K, V> extends aa<K, V> {
        final int a;
        final int b;
        @Nullable
        a<K, V> c;
        @Nullable
        a<K, V> d;
        @Nullable
        a<K, V> e;
        @Nullable
        a<K, V> f;

        a(K k, int i, V v, int i2) {
            super(k, v);
            this.a = i;
            this.b = i2;
        }
    }

    private final class b extends AbstractMap<V, K> implements i<V, K>, Serializable {
        final /* synthetic */ v a;

        private final class a extends e<V, K> {
            final /* synthetic */ b a;

            a(b bVar) {
                this.a = bVar;
                super(bVar);
            }

            public boolean remove(@Nullable Object obj) {
                a b = this.a.a.b(obj, w.a(obj));
                if (b == null) {
                    return false;
                }
                this.a.a.a(b);
                return true;
            }

            public Iterator<V> iterator() {
                return new c<V>(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r2;
                        v vVar = r2.a.a;
                    }

                    V b(a<K, V> aVar) {
                        return aVar.h;
                    }
                };
            }
        }

        private b(v vVar) {
            this.a = vVar;
        }

        public /* synthetic */ Collection values() {
            return b();
        }

        i<K, V> a() {
            return this.a;
        }

        public int size() {
            return this.a.e;
        }

        public void clear() {
            a().clear();
        }

        public boolean containsKey(@Nullable Object obj) {
            return a().containsValue(obj);
        }

        public K get(@Nullable Object obj) {
            return ay.b(this.a.b(obj, w.a(obj)));
        }

        public K put(@Nullable V v, @Nullable K k) {
            return this.a.b((Object) v, (Object) k, false);
        }

        public K remove(@Nullable Object obj) {
            a b = this.a.b(obj, w.a(obj));
            if (b == null) {
                return null;
            }
            this.a.a(b);
            b.f = null;
            b.e = null;
            return b.g;
        }

        public Set<V> keySet() {
            return new a(this);
        }

        public Set<K> b() {
            return a().keySet();
        }

        public Set<Entry<V, K>> entrySet() {
            return new b<V, K>(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                Map<V, K> a() {
                    return this.a;
                }

                public Iterator<Entry<V, K>> iterator() {
                    return new c<Entry<V, K>>(this) {
                        final /* synthetic */ AnonymousClass1 a;

                        class a extends f<V, K> {
                            a<K, V> a;
                            final /* synthetic */ AnonymousClass1 b;

                            a(AnonymousClass1 anonymousClass1, a<K, V> aVar) {
                                this.b = anonymousClass1;
                                this.a = aVar;
                            }

                            public V getKey() {
                                return this.a.h;
                            }

                            public K getValue() {
                                return this.a.g;
                            }

                            public K setValue(K k) {
                                K k2 = this.a.g;
                                int a = w.a((Object) k);
                                if (a == this.a.a && g.a(k, k2)) {
                                    return k;
                                }
                                h.a(this.b.a.a.a.a((Object) k, a) == null, "value already present: %s", k);
                                this.b.a.a.a.a(this.a);
                                a aVar = new a(k, a, this.a.h, this.a.b);
                                this.a = aVar;
                                this.b.a.a.a.a(aVar, null);
                                this.b.d = this.b.a.a.a.g;
                                return k2;
                            }
                        }

                        {
                            this.a = r2;
                            v vVar = r2.a.a;
                        }

                        /* synthetic */ Object b(a aVar) {
                            return a(aVar);
                        }

                        Entry<V, K> a(a<K, V> aVar) {
                            return new a(this, aVar);
                        }
                    };
                }
            };
        }
    }

    private final class d extends e<K, V> {
        final /* synthetic */ v a;

        d(v vVar) {
            this.a = vVar;
            super(vVar);
        }

        public Iterator<K> iterator() {
            return new c<K>(this) {
                final /* synthetic */ d a;

                {
                    this.a = r2;
                    v vVar = r2.a;
                }

                K b(a<K, V> aVar) {
                    return aVar.g;
                }
            };
        }

        public boolean remove(@Nullable Object obj) {
            a a = this.a.a(obj, w.a(obj));
            if (a == null) {
                return false;
            }
            this.a.a(a);
            a.f = null;
            a.e = null;
            return true;
        }
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* synthetic */ Collection values() {
        return b();
    }

    public static <K, V> v<K, V> a() {
        return a(16);
    }

    public static <K, V> v<K, V> a(int i) {
        return new v(i);
    }

    private v(int i) {
        b(i);
    }

    private void b(int i) {
        k.a(i, "expectedSize");
        int a = w.a(i, 1.0d);
        this.a = c(a);
        this.b = c(a);
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = a - 1;
        this.g = 0;
    }

    private void a(a<K, V> aVar) {
        a<K, V> aVar2;
        a aVar3 = null;
        int i = aVar.a & this.f;
        a aVar4 = null;
        for (aVar2 = this.a[i]; aVar2 != aVar; aVar2 = aVar2.c) {
            a<K, V> aVar5 = aVar2;
        }
        if (aVar4 == null) {
            this.a[i] = aVar.c;
        } else {
            aVar4.c = aVar.c;
        }
        int i2 = this.f & aVar.b;
        for (aVar2 = this.b[i2]; aVar2 != aVar; aVar2 = aVar2.d) {
            a<K, V> aVar6 = aVar2;
        }
        if (aVar3 == null) {
            this.b[i2] = aVar.d;
        } else {
            aVar3.d = aVar.d;
        }
        if (aVar.f == null) {
            this.c = aVar.e;
        } else {
            aVar.f.e = aVar.e;
        }
        if (aVar.e == null) {
            this.d = aVar.f;
        } else {
            aVar.e.f = aVar.f;
        }
        this.e--;
        this.g++;
    }

    private void a(a<K, V> aVar, @Nullable a<K, V> aVar2) {
        int i = aVar.a & this.f;
        aVar.c = this.a[i];
        this.a[i] = aVar;
        i = aVar.b & this.f;
        aVar.d = this.b[i];
        this.b[i] = aVar;
        if (aVar2 == null) {
            aVar.f = this.d;
            aVar.e = null;
            if (this.d == null) {
                this.c = aVar;
            } else {
                this.d.e = aVar;
            }
            this.d = aVar;
        } else {
            aVar.f = aVar2.f;
            if (aVar.f == null) {
                this.c = aVar;
            } else {
                aVar.f.e = aVar;
            }
            aVar.e = aVar2.e;
            if (aVar.e == null) {
                this.d = aVar;
            } else {
                aVar.e.f = aVar;
            }
        }
        this.e++;
        this.g++;
    }

    private a<K, V> a(@Nullable Object obj, int i) {
        a<K, V> aVar = this.a[this.f & i];
        while (aVar != null) {
            if (i == aVar.a && g.a(obj, aVar.g)) {
                return aVar;
            }
            aVar = aVar.c;
        }
        return null;
    }

    private a<K, V> b(@Nullable Object obj, int i) {
        a<K, V> aVar = this.b[this.f & i];
        while (aVar != null) {
            if (i == aVar.b && g.a(obj, aVar.h)) {
                return aVar;
            }
            aVar = aVar.d;
        }
        return null;
    }

    public boolean containsKey(@Nullable Object obj) {
        return a(obj, w.a(obj)) != null;
    }

    public boolean containsValue(@Nullable Object obj) {
        return b(obj, w.a(obj)) != null;
    }

    @Nullable
    public V get(@Nullable Object obj) {
        return ay.c(a(obj, w.a(obj)));
    }

    public V put(@Nullable K k, @Nullable V v) {
        return a((Object) k, (Object) v, false);
    }

    private V a(@Nullable K k, @Nullable V v, boolean z) {
        int a = w.a((Object) k);
        int a2 = w.a((Object) v);
        a a3 = a((Object) k, a);
        if (a3 != null && a2 == a3.b && g.a(v, a3.h)) {
            return v;
        }
        a b = b(v, a2);
        if (b != null) {
            if (z) {
                a(b);
            } else {
                throw new IllegalArgumentException("value already present: " + v);
            }
        }
        b = new a(k, a, v, a2);
        if (a3 != null) {
            a(a3);
            a(b, a3);
            a3.f = null;
            a3.e = null;
            e();
            return a3.h;
        }
        a(b, null);
        e();
        return null;
    }

    @Nullable
    private K b(@Nullable V v, @Nullable K k, boolean z) {
        int a = w.a((Object) v);
        int a2 = w.a((Object) k);
        Entry b = b(v, a);
        if (b != null && a2 == b.a && g.a(k, b.g)) {
            return k;
        }
        a a3 = a((Object) k, a2);
        if (a3 != null) {
            if (z) {
                a(a3);
            } else {
                throw new IllegalArgumentException("value already present: " + k);
            }
        }
        if (b != null) {
            a((a) b);
        }
        a(new a(k, a2, v, a), a3);
        if (a3 != null) {
            a3.f = null;
            a3.e = null;
        }
        e();
        return ay.b(b);
    }

    private void e() {
        a[] aVarArr = this.a;
        if (w.a(this.e, aVarArr.length, 1.0d)) {
            int length = aVarArr.length * 2;
            this.a = c(length);
            this.b = c(length);
            this.f = length - 1;
            this.e = 0;
            for (a aVar = this.c; aVar != null; aVar = aVar.e) {
                a(aVar, aVar);
            }
            this.g++;
        }
    }

    private a<K, V>[] c(int i) {
        return new a[i];
    }

    public V remove(@Nullable Object obj) {
        a a = a(obj, w.a(obj));
        if (a == null) {
            return null;
        }
        a(a);
        a.f = null;
        a.e = null;
        return a.h;
    }

    public void clear() {
        this.e = 0;
        Arrays.fill(this.a, null);
        Arrays.fill(this.b, null);
        this.c = null;
        this.d = null;
        this.g++;
    }

    public int size() {
        return this.e;
    }

    public Set<K> keySet() {
        return new d(this);
    }

    public Set<V> b() {
        return d().keySet();
    }

    Iterator<Entry<K, V>> c() {
        return new c<Entry<K, V>>(this) {
            final /* synthetic */ v a;

            class a extends f<K, V> {
                a<K, V> a;
                final /* synthetic */ AnonymousClass1 b;

                a(AnonymousClass1 anonymousClass1, a<K, V> aVar) {
                    this.b = anonymousClass1;
                    this.a = aVar;
                }

                public K getKey() {
                    return this.a.g;
                }

                public V getValue() {
                    return this.a.h;
                }

                public V setValue(V v) {
                    V v2 = this.a.h;
                    int a = w.a((Object) v);
                    if (a == this.a.b && g.a(v, v2)) {
                        return v;
                    }
                    h.a(this.b.a.b(v, a) == null, "value already present: %s", v);
                    this.b.a.a(this.a);
                    a aVar = new a(this.a.g, this.a.a, v, a);
                    this.b.a.a(aVar, this.a);
                    this.a.f = null;
                    this.a.e = null;
                    this.b.d = this.b.a.g;
                    if (this.b.c == this.a) {
                        this.b.c = aVar;
                    }
                    this.a = aVar;
                    return v2;
                }
            }

            {
                this.a = r1;
            }

            /* synthetic */ Object b(a aVar) {
                return a(aVar);
            }

            Entry<K, V> a(a<K, V> aVar) {
                return new a(this, aVar);
            }
        };
    }

    public i<V, K> d() {
        if (this.h != null) {
            return this.h;
        }
        i<V, K> bVar = new b();
        this.h = bVar;
        return bVar;
    }
}
