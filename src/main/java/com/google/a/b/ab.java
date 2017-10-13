package com.google.a.b;

import com.google.a.a.h;
import java.util.EnumMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class ab<K extends Enum<K>, V> extends b<K, V> {
    private final transient EnumMap<K, V> b;

    static <K extends Enum<K>, V> af<K, V> a(EnumMap<K, V> enumMap) {
        switch (enumMap.size()) {
            case 0:
                return af.e();
            case 1:
                Entry entry = (Entry) as.b(enumMap.entrySet());
                return af.b(entry.getKey(), entry.getValue());
            default:
                return new ab(enumMap);
        }
    }

    private ab(EnumMap<K, V> enumMap) {
        this.b = enumMap;
        h.a(!enumMap.isEmpty());
    }

    ce<K> a() {
        return at.a(this.b.keySet().iterator());
    }

    public int size() {
        return this.b.size();
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.b.containsKey(obj);
    }

    public V get(Object obj) {
        return this.b.get(obj);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ab) {
            obj = ((ab) obj).b;
        }
        return this.b.equals(obj);
    }

    ce<Entry<K, V>> b() {
        return ay.c(this.b.entrySet().iterator());
    }

    boolean c() {
        return false;
    }
}
