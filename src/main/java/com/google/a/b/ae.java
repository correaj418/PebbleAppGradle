package com.google.a.b;

import java.util.Collection;
import java.util.Map.Entry;
import javax.annotation.Nullable;

public class ae<K, V> extends ak<K, V> implements av<K, V> {

    public static final class a<K, V> extends com.google.a.b.ak.a<K, V> {
        public /* synthetic */ com.google.a.b.ak.a b(Object obj, Object obj2) {
            return a(obj, obj2);
        }

        public /* synthetic */ ak b() {
            return a();
        }

        public a<K, V> a(K k, V v) {
            super.b(k, v);
            return this;
        }

        public ae<K, V> a() {
            return (ae) super.b();
        }
    }

    public /* synthetic */ Collection b(Object obj) {
        return a(obj);
    }

    public /* synthetic */ z c(Object obj) {
        return a(obj);
    }

    public static <K, V> ae<K, V> a() {
        return q.a;
    }

    public static <K, V> ae<K, V> d(K k, V v) {
        a c = c();
        c.a(k, v);
        return c.a();
    }

    public static <K, V> a<K, V> c() {
        return new a();
    }

    public static <K, V> ae<K, V> a(az<? extends K, ? extends V> azVar) {
        if (azVar.j()) {
            return a();
        }
        if (azVar instanceof ae) {
            ae<K, V> aeVar = (ae) azVar;
            if (!aeVar.m()) {
                return aeVar;
            }
        }
        com.google.a.b.af.a aVar = new com.google.a.b.af.a(azVar.b().size());
        int i = 0;
        for (Entry entry : azVar.b().entrySet()) {
            int i2;
            ad a = ad.a((Collection) entry.getValue());
            if (a.isEmpty()) {
                i2 = i;
            } else {
                aVar.a(entry.getKey(), a);
                i2 = a.size() + i;
            }
            i = i2;
        }
        return new ae(aVar.a(), i);
    }

    ae(af<K, ad<V>> afVar, int i) {
        super(afVar, i);
    }

    public ad<V> a(@Nullable K k) {
        ad<V> adVar = (ad) this.b.get(k);
        return adVar == null ? ad.c() : adVar;
    }
}
