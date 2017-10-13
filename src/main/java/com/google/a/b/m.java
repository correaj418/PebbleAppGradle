package com.google.a.b;

import com.google.a.a.h;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

final class m<T> extends bg<T> implements Serializable {
    final Comparator<T> a;

    m(Comparator<T> comparator) {
        this.a = (Comparator) h.a((Object) comparator);
    }

    public int compare(T t, T t2) {
        return this.a.compare(t, t2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        return this.a.equals(((m) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
