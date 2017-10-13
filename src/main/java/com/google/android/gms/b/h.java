package com.google.android.gms.b;

import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.ab;

public final class h<O extends a> {
    private final com.google.android.gms.common.api.a<O> a;
    private final O b;

    public d<?> a() {
        return this.a.d();
    }

    public String b() {
        return this.a.f();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return ab.a(this.a, hVar.a) && ab.a(this.b, hVar.b);
    }

    public int hashCode() {
        return ab.a(this.a, this.b);
    }
}
