package com.google.a.b;

import com.google.a.a.h;
import java.io.Serializable;

final class be extends bg<Comparable> implements Serializable {
    static final be a = new be();

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Comparable) obj, (Comparable) obj2);
    }

    public int a(Comparable comparable, Comparable comparable2) {
        h.a((Object) comparable);
        h.a((Object) comparable2);
        return comparable.compareTo(comparable2);
    }

    public <S extends Comparable> bg<S> a() {
        return bq.a;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private be() {
    }
}
