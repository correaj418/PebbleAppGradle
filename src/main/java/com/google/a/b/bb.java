package com.google.a.b;

import com.google.a.a.e;
import com.google.a.a.h;
import com.google.a.a.l;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public final class bb {

    private static class a<K, V> extends c<K, V> {
        transient l<? extends List<V>> a;

        protected /* synthetic */ Collection c() {
            return a();
        }

        a(Map<K, Collection<V>> map, l<? extends List<V>> lVar) {
            super(map);
            this.a = (l) h.a((Object) lVar);
        }

        protected List<V> a() {
            return (List) this.a.a();
        }
    }

    static abstract class b<K, V> extends AbstractCollection<Entry<K, V>> {
        abstract az<K, V> a();

        b() {
        }

        public int size() {
            return a().d();
        }

        public boolean contains(@Nullable Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return a().b(entry.getKey(), entry.getValue());
        }

        public boolean remove(@Nullable Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return a().c(entry.getKey(), entry.getValue());
        }

        public void clear() {
            a().e();
        }
    }

    private static class d<K, V1, V2> extends g<K, V2> {
        final az<K, V1> a;
        final com.google.a.b.ay.c<? super K, ? super V1, V2> b;

        d(az<K, V1> azVar, com.google.a.b.ay.c<? super K, ? super V1, V2> cVar) {
            this.a = (az) h.a((Object) azVar);
            this.b = (com.google.a.b.ay.c) h.a((Object) cVar);
        }

        Collection<V2> b(K k, Collection<V1> collection) {
            e a = ay.a(this.b, (Object) k);
            if (collection instanceof List) {
                return aw.a((List) collection, a);
            }
            return l.a((Collection) collection, a);
        }

        Map<K, Collection<V2>> i() {
            return ay.a(this.a.b(), new com.google.a.b.ay.c<K, Collection<V1>, Collection<V2>>(this) {
                final /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public Collection<V2> a(K k, Collection<V1> collection) {
                    return this.a.b(k, collection);
                }
            });
        }

        public void e() {
            this.a.e();
        }

        Iterator<Entry<K, V2>> h() {
            return at.a(this.a.g().iterator(), ay.a(this.b));
        }

        public Collection<V2> b(K k) {
            return b(k, this.a.b(k));
        }

        public boolean j() {
            return this.a.j();
        }

        public Set<K> l() {
            return this.a.l();
        }

        public boolean a(K k, V2 v2) {
            throw new UnsupportedOperationException();
        }

        public boolean a(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean c(Object obj, Object obj2) {
            return b(obj).remove(obj2);
        }

        public int d() {
            return this.a.d();
        }
    }

    private static final class c<K, V1, V2> extends d<K, V1, V2> implements av<K, V2> {
        public /* synthetic */ Collection b(Object obj) {
            return a(obj);
        }

        /* synthetic */ Collection b(Object obj, Collection collection) {
            return a(obj, collection);
        }

        c(av<K, V1> avVar, com.google.a.b.ay.c<? super K, ? super V1, V2> cVar) {
            super(avVar, cVar);
        }

        List<V2> a(K k, Collection<V1> collection) {
            return aw.a((List) collection, ay.a(this.b, (Object) k));
        }

        public List<V2> a(K k) {
            return a(k, this.a.b(k));
        }
    }

    public static <K, V> av<K, V> a(Map<K, Collection<V>> map, l<? extends List<V>> lVar) {
        return new a(map, lVar);
    }

    public static <K, V1, V2> av<K, V2> a(av<K, V1> avVar, e<? super V1, V2> eVar) {
        h.a((Object) eVar);
        return a((av) avVar, ay.a((e) eVar));
    }

    public static <K, V1, V2> av<K, V2> a(av<K, V1> avVar, com.google.a.b.ay.c<? super K, ? super V1, V2> cVar) {
        return new c(avVar, cVar);
    }

    static boolean a(az<?, ?> azVar, @Nullable Object obj) {
        if (obj == azVar) {
            return true;
        }
        if (!(obj instanceof az)) {
            return false;
        }
        return azVar.b().equals(((az) obj).b());
    }
}
