package com.google.a.b;

import javax.annotation.Nullable;

class ag<K, V> extends aa<K, V> {

    static class a<K, V> extends ag<K, V> {
        private final transient ag<K, V> a;

        a(K k, V v, ag<K, V> agVar) {
            super(k, v);
            this.a = agVar;
        }

        @Nullable
        final ag<K, V> a() {
            return this.a;
        }

        final boolean c() {
            return false;
        }
    }

    static <K, V> ag<K, V>[] a(int i) {
        return new ag[i];
    }

    ag(K k, V v) {
        super(k, v);
        k.a((Object) k, (Object) v);
    }

    @Nullable
    ag<K, V> a() {
        return null;
    }

    @Nullable
    ag<K, V> b() {
        return null;
    }

    boolean c() {
        return true;
    }
}
