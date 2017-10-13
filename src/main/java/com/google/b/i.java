package com.google.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i extends l implements Iterable<l> {
    private final List<l> a = new ArrayList();

    public void a(Boolean bool) {
        this.a.add(bool == null ? n.a : new r(bool));
    }

    public void a(Number number) {
        this.a.add(number == null ? n.a : new r(number));
    }

    public void a(String str) {
        this.a.add(str == null ? n.a : new r(str));
    }

    public void a(l lVar) {
        if (lVar == null) {
            lVar = n.a;
        }
        this.a.add(lVar);
    }

    public int a() {
        return this.a.size();
    }

    public Iterator<l> iterator() {
        return this.a.iterator();
    }

    public l a(int i) {
        return (l) this.a.get(i);
    }

    public Number b() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    public String c() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    public double d() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    public long e() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public int f() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public boolean g() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).g();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
