package com.getpebble.android.common.model.a;

import com.getpebble.android.common.model.j;
import com.getpebble.android.h.p;
import com.google.b.a.c;

public abstract class q implements j {
    @c(a = "statistic")
    public final p c;

    protected q(p pVar) {
        this.c = pVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.c.equals(((q) obj).c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toJson() {
        return p.a(this);
    }

    public String getKey() {
        return this.c.blobDbKey;
    }
}
