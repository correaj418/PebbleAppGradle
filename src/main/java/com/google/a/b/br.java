package com.google.a.b;

import com.google.a.a.h;
import java.io.Serializable;
import javax.annotation.Nullable;

final class br<T> extends bg<T> implements Serializable {
    final bg<? super T> a;

    br(bg<? super T> bgVar) {
        this.a = (bg) h.a((Object) bgVar);
    }

    public int compare(T t, T t2) {
        return this.a.compare(t2, t);
    }

    public <S extends T> bg<S> a() {
        return this.a;
    }

    public int hashCode() {
        return -this.a.hashCode();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof br)) {
            return false;
        }
        return this.a.equals(((br) obj).a);
    }

    public String toString() {
        return this.a + ".reverse()";
    }
}
