package com.google.a.b;

import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ak<K, V> extends g<K, V> implements Serializable {
    final transient af<K, ? extends z<V>> b;
    final transient int c;

    public static class a<K, V> {
        az<K, V> a;
        Comparator<? super K> b;
        Comparator<? super V> c;

        public a() {
            this(ba.a().b().b());
        }

        a(az<K, V> azVar) {
            this.a = azVar;
        }

        public a<K, V> b(K k, V v) {
            k.a((Object) k, (Object) v);
            this.a.a((Object) k, (Object) v);
            return this;
        }

        public ak<K, V> b() {
            if (this.c != null) {
                for (Collection collection : this.a.b().values()) {
                    Collections.sort((List) collection, this.c);
                }
            }
            if (this.b != null) {
                az b = ba.a().b().b();
                for (Entry entry : bg.a(this.b).c().a(this.a.b().entrySet())) {
                    b.a(entry.getKey(), (Iterable) entry.getValue());
                }
                this.a = b;
            }
            return ak.b(this.a);
        }
    }

    private abstract class c<T> extends ce<T> {
        final Iterator<Entry<K, Collection<V>>> b;
        K c;
        Iterator<V> d;
        final /* synthetic */ ak e;

        abstract T b(K k, V v);

        private c(ak akVar) {
            this.e = akVar;
            this.b = this.e.o().g().j_();
            this.c = null;
            this.d = at.a();
        }

        public boolean hasNext() {
            return this.b.hasNext() || this.d.hasNext();
        }

        public T next() {
            if (!this.d.hasNext()) {
                Entry entry = (Entry) this.b.next();
                this.c = entry.getKey();
                this.d = ((Collection) entry.getValue()).iterator();
            }
            return b(this.c, this.d.next());
        }
    }

    private static class b<K, V> extends z<Entry<K, V>> {
        @Weak
        final ak<K, V> a;

        public /* synthetic */ Iterator iterator() {
            return j_();
        }

        b(ak<K, V> akVar) {
            this.a = akVar;
        }

        public ce<Entry<K, V>> j_() {
            return this.a.r();
        }

        boolean e() {
            return this.a.m();
        }

        public int size() {
            return this.a.d();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.a.b(entry.getKey(), entry.getValue());
        }
    }

    public abstract z<V> c(K k);

    public /* synthetic */ Collection b(Object obj) {
        return c(obj);
    }

    public /* synthetic */ Map b() {
        return o();
    }

    public /* bridge */ /* synthetic */ boolean b(Object obj, Object obj2) {
        return super.b(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* synthetic */ Collection g() {
        return p();
    }

    /* synthetic */ Iterator h() {
        return r();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* synthetic */ Collection k() {
        return q();
    }

    public /* synthetic */ Set l() {
        return n();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ak<K, V> b(az<? extends K, ? extends V> azVar) {
        if (azVar instanceof ak) {
            ak<K, V> akVar = (ak) azVar;
            if (!akVar.m()) {
                return akVar;
            }
        }
        return ae.a((az) azVar);
    }

    ak(af<K, ? extends z<V>> afVar, int i) {
        this.b = afVar;
        this.c = i;
    }

    @Deprecated
    public void e() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean a(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean a(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean c(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    boolean m() {
        return this.b.c();
    }

    public int d() {
        return this.c;
    }

    public am<K> n() {
        return this.b.i();
    }

    public af<K, Collection<V>> o() {
        return this.b;
    }

    Map<K, Collection<V>> i() {
        throw new AssertionError("should never be called");
    }

    public z<Entry<K, V>> p() {
        return (z) super.g();
    }

    z<Entry<K, V>> q() {
        return new b(this);
    }

    ce<Entry<K, V>> r() {
        return new c<Entry<K, V>>(this) {
            final /* synthetic */ ak a;

            {
                this.a = r2;
            }

            /* synthetic */ Object b(Object obj, Object obj2) {
                return a(obj, obj2);
            }

            Entry<K, V> a(K k, V v) {
                return ay.a((Object) k, (Object) v);
            }
        };
    }
}
