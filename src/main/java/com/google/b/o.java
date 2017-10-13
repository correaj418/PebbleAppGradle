package com.google.b;

import com.google.b.b.g;
import java.util.Map.Entry;
import java.util.Set;

public final class o extends l {
    private final g<String, l> a = new g();

    public void a(String str, l lVar) {
        if (lVar == null) {
            lVar = n.a;
        }
        this.a.put(str, lVar);
    }

    public void a(String str, String str2) {
        a(str, a((Object) str2));
    }

    public void a(String str, Number number) {
        a(str, a((Object) number));
    }

    private l a(Object obj) {
        return obj == null ? n.a : new r(obj);
    }

    public Set<Entry<String, l>> a() {
        return this.a.entrySet();
    }

    public boolean a(String str) {
        return this.a.containsKey(str);
    }

    public l b(String str) {
        return (l) this.a.get(str);
    }

    public i c(String str) {
        return (i) this.a.get(str);
    }

    public o d(String str) {
        return (o) this.a.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
