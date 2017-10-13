package com.b.a.c.f;

import java.util.Locale;

final class g {
    public static final c a = c.a(":status");
    public static final c b = c.a(":method");
    public static final c c = c.a(":path");
    public static final c d = c.a(":scheme");
    public static final c e = c.a(":authority");
    public static final c f = c.a(":host");
    public static final c g = c.a(":version");
    public final c h;
    public final c i;
    final int j;

    public g(String str, String str2) {
        this(c.a(str), c.a(str2));
    }

    public g(c cVar, String str) {
        this(cVar, c.a(str));
    }

    public g(c cVar, c cVar2) {
        this.h = cVar;
        this.i = cVar2;
        this.j = (cVar.d() + 32) + cVar2.d();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.h.equals(gVar.h) && this.i.equals(gVar.i)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.h.hashCode() + 527) * 31) + this.i.hashCode();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%s: %s", new Object[]{this.h.a(), this.i.a()});
    }
}
