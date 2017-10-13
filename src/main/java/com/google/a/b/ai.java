package com.google.a.b;

import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class ai<K, V> extends b<K> {
    @Weak
    private final af<K, V> a;

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    ai(af<K, V> afVar) {
        this.a = afVar;
    }

    public int size() {
        return this.a.size();
    }

    public ce<K> j_() {
        return this.a.a();
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    K a(int i) {
        return ((Entry) this.a.g().f().get(i)).getKey();
    }

    boolean e() {
        return true;
    }
}
