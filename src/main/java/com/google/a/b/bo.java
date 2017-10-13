package com.google.a.b;

import java.util.Iterator;
import javax.annotation.Nullable;

final class bo<E> extends am<E> {
    static final bo<Object> a = new bo(bf.a, 0, null, 0);
    final transient Object[] b;
    private final transient Object[] c;
    private final transient int d;
    private final transient int e;

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    bo(Object[] objArr, int i, Object[] objArr2, int i2) {
        this.c = objArr;
        this.b = objArr2;
        this.d = i2;
        this.e = i;
    }

    public boolean contains(@Nullable Object obj) {
        Object[] objArr = this.b;
        if (obj == null || objArr == null) {
            return false;
        }
        int a = w.a(obj);
        while (true) {
            a &= this.d;
            Object obj2 = objArr[a];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a++;
        }
    }

    public int size() {
        return this.c.length;
    }

    public ce<E> j_() {
        return at.a(this.c);
    }

    int a(Object[] objArr, int i) {
        System.arraycopy(this.c, 0, objArr, i, this.c.length);
        return this.c.length + i;
    }

    ad<E> g() {
        return this.b == null ? ad.c() : new bj((z) this, this.c);
    }

    boolean e() {
        return false;
    }

    public int hashCode() {
        return this.e;
    }

    boolean g_() {
        return true;
    }
}
