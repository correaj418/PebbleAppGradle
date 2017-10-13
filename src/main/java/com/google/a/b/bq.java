package com.google.a.b;

import com.google.a.a.h;
import java.io.Serializable;

final class bq extends bg<Comparable> implements Serializable {
    static final bq a = new bq();

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Comparable) obj, (Comparable) obj2);
    }

    public int a(Comparable comparable, Comparable comparable2) {
        h.a((Object) comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public <S extends Comparable> bg<S> a() {
        return bg.b();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private bq() {
    }
}
