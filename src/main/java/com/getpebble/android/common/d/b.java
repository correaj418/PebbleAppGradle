package com.getpebble.android.common.d;

import com.getpebble.android.common.b.b.a;
import com.getpebble.android.common.model.v;
import com.google.a.f.e;

public class b {
    private long a;
    private v b;
    private String c;
    private boolean d;
    private e e;
    private e f;

    public b a(long j) {
        this.a = j;
        return this;
    }

    public b a(v vVar) {
        this.b = vVar;
        return this;
    }

    public b a(String str) {
        this.c = str;
        return this;
    }

    public b a(boolean z) {
        this.d = z;
        return this;
    }

    public b a(e eVar) {
        this.e = eVar;
        return this;
    }

    public b b(e eVar) {
        this.f = eVar;
        return this;
    }

    public long a() {
        return this.a;
    }

    public v b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public e e() {
        return this.e;
    }

    public e f() {
        return this.f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!(bVar.a() == a() && a.a(bVar.b(), b()) && a.a(bVar.c(), c()) && bVar.d() == d() && a.a(bVar.e(), e()) && a.a(bVar.f(), f()))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (71 * (((((((((Long.valueOf(a()).hashCode() + 355) * 71) + b().hashCode()) * 71) + c().hashCode()) * 71) + Boolean.valueOf(d()).hashCode()) * 71) + e().hashCode())) + f().hashCode();
    }
}
