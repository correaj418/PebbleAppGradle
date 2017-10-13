package com.google.a.b;

import com.google.a.a.h;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class bm<K, V> extends af<K, V> {
    private final transient Entry<K, V>[] b;
    private final transient ag<K, V>[] c;
    private final transient int d;

    static <K, V> bm<K, V> a(Entry<K, V>... entryArr) {
        return a(entryArr.length, entryArr);
    }

    static <K, V> bm<K, V> a(int i, Entry<K, V>[] entryArr) {
        Entry[] entryArr2;
        h.b(i, entryArr.length);
        if (i == entryArr.length) {
            entryArr2 = entryArr;
        } else {
            Object[] a = ag.a(i);
        }
        int a2 = w.a(i, 1.2d);
        ag[] a3 = ag.a(a2);
        int i2 = a2 - 1;
        for (int i3 = 0; i3 < i; i3++) {
            Entry entry = entryArr[i3];
            Object key = entry.getKey();
            Object value = entry.getValue();
            k.a(key, value);
            int a4 = w.a(key.hashCode()) & i2;
            ag agVar = a3[a4];
            if (agVar == null) {
                Object obj = ((entry instanceof ag) && ((ag) entry).c()) ? 1 : null;
                entry = obj != null ? (ag) entry : new ag(key, value);
            } else {
                entry = new a(key, value, agVar);
            }
            a3[a4] = entry;
            entryArr2[i3] = entry;
            a(key, entry, agVar);
        }
        return new bm(entryArr2, a3, i2);
    }

    private bm(Entry<K, V>[] entryArr, ag<K, V>[] agVarArr, int i) {
        this.b = entryArr;
        this.c = agVarArr;
        this.d = i;
    }

    static void a(Object obj, Entry<?, ?> entry, @Nullable ag<?, ?> agVar) {
        while (agVar != null) {
            af.a(!obj.equals(agVar.getKey()), "key", entry, agVar);
            agVar = agVar.a();
        }
    }

    public V get(@Nullable Object obj) {
        return a(obj, this.c, this.d);
    }

    @Nullable
    static <V> V a(@Nullable Object obj, ag<?, V>[] agVarArr, int i) {
        if (obj == null) {
            return null;
        }
        for (ag agVar = agVarArr[w.a(obj.hashCode()) & i]; agVar != null; agVar = agVar.a()) {
            if (obj.equals(agVar.getKey())) {
                return agVar.getValue();
            }
        }
        return null;
    }

    public int size() {
        return this.b.length;
    }

    boolean c() {
        return false;
    }

    am<Entry<K, V>> h() {
        return new a(this, this.b);
    }
}
