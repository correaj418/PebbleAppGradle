package com.google.a.b;

import com.google.a.a.g;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class f<K, V> implements Entry<K, V> {
    public abstract K getKey();

    public abstract V getValue();

    f() {
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (g.a(getKey(), entry.getKey()) && g.a(getValue(), entry.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        Object key = getKey();
        Object value = getValue();
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i = value.hashCode();
        }
        return i ^ hashCode;
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
