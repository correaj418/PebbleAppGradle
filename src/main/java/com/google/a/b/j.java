package com.google.a.b;

import com.google.a.a.e;
import com.google.a.a.g;
import com.google.a.a.h;
import java.io.Serializable;
import javax.annotation.Nullable;

final class j<F, T> extends bg<F> implements Serializable {
    final e<F, ? extends T> a;
    final bg<T> b;

    j(e<F, ? extends T> eVar, bg<T> bgVar) {
        this.a = (e) h.a((Object) eVar);
        this.b = (bg) h.a((Object) bgVar);
    }

    public int compare(F f, F f2) {
        return this.b.compare(this.a.apply(f), this.a.apply(f2));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.a.equals(jVar.a) && this.b.equals(jVar.b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return g.a(this.a, this.b);
    }

    public String toString() {
        return this.b + ".onResultOf(" + this.a + ")";
    }
}
