package com.google.a.b;

import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class ah<K, V> extends am<Entry<K, V>> {

    static final class a<K, V> extends ah<K, V> {
        @Weak
        private final transient af<K, V> a;
        private final transient Entry<K, V>[] b;

        public /* synthetic */ Iterator iterator() {
            return j_();
        }

        a(af<K, V> afVar, Entry<K, V>[] entryArr) {
            this.a = afVar;
            this.b = entryArr;
        }

        af<K, V> c() {
            return this.a;
        }

        public ce<Entry<K, V>> j_() {
            return f().j_();
        }

        ad<Entry<K, V>> g() {
            return new bj((z) this, this.b);
        }
    }

    abstract af<K, V> c();

    ah() {
    }

    public int size() {
        return c().size();
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object obj2 = c().get(entry.getKey());
        if (obj2 == null || !obj2.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    boolean e() {
        return c().c();
    }

    boolean g_() {
        return c().k();
    }

    public int hashCode() {
        return c().hashCode();
    }
}
