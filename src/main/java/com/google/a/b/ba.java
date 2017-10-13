package com.google.a.b;

import com.google.a.a.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public abstract class ba<K0, V0> {

    public static abstract class c<K0> {
        abstract <K extends K0, V> Map<K, Collection<V>> a();

        c() {
        }

        public b<K0, Object> b() {
            return a(2);
        }

        public b<K0, Object> a(final int i) {
            k.a(i, "expectedValuesPerKey");
            return new b<K0, Object>(this) {
                final /* synthetic */ c b;

                public <K extends K0, V> av<K, V> b() {
                    return bb.a(this.b.a(), new a(i));
                }
            };
        }
    }

    static class AnonymousClass1 extends c<Object> {
        final /* synthetic */ int a;

        <K, V> Map<K, Collection<V>> a() {
            return ay.a(this.a);
        }
    }

    private static final class a<V> implements l<List<V>>, Serializable {
        private final int a;

        public /* synthetic */ Object a() {
            return b();
        }

        a(int i) {
            this.a = k.a(i, "expectedValuesPerKey");
        }

        public List<V> b() {
            return new ArrayList(this.a);
        }
    }

    public static abstract class b<K0, V0> extends ba<K0, V0> {
        public abstract <K extends K0, V extends V0> av<K, V> b();

        b() {
            super();
        }
    }

    private ba() {
    }

    public static c<Object> a() {
        return a(8);
    }

    public static c<Object> a(final int i) {
        k.a(i, "expectedKeys");
        return new c<Object>() {
            <K, V> Map<K, Collection<V>> a() {
                return ay.c(i);
            }
        };
    }
}
