package com.google.a.b;

import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class aj<K, V> extends z<V> {
    @Weak
    private final af<K, V> a;

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    aj(af<K, V> afVar) {
        this.a = afVar;
    }

    public int size() {
        return this.a.size();
    }

    public ce<V> j_() {
        return new ce<V>(this) {
            final ce<Entry<K, V>> a = this.b.a.g().j_();
            final /* synthetic */ aj b;

            {
                this.b = r2;
            }

            public boolean hasNext() {
                return this.a.hasNext();
            }

            public V next() {
                return ((Entry) this.a.next()).getValue();
            }
        };
    }

    public boolean contains(@Nullable Object obj) {
        return obj != null && at.a(j_(), obj);
    }

    boolean e() {
        return true;
    }

    ad<V> g() {
        final ad f = this.a.g().f();
        return new x<V>(this) {
            final /* synthetic */ aj b;

            public V get(int i) {
                return ((Entry) f.get(i)).getValue();
            }

            z<V> b() {
                return this.b;
            }
        };
    }
}
