package com.getpebble.android.common.model.a;

import com.getpebble.android.common.model.a.o.c;
import com.getpebble.android.common.model.a.o.e;

final class g extends c {
    private final e a;
    private final int b;

    g(e eVar, int i) {
        if (eVar == null) {
            throw new NullPointerException("Null record");
        }
        this.a = eVar;
        this.b = i;
    }

    public e a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return "OrderedRecord{record=" + this.a + ", rowId=" + this.b + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.a.equals(cVar.a()) && this.b == cVar.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }
}
