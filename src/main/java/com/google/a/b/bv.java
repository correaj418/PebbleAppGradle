package com.google.a.b;

import com.google.a.a.h;
import java.util.Iterator;
import java.util.List;

final class bv<E> extends ad<E> {
    final transient E a;

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    public /* synthetic */ List subList(int i, int i2) {
        return a(i, i2);
    }

    bv(E e) {
        this.a = h.a((Object) e);
    }

    public E get(int i) {
        h.a(i, 1);
        return this.a;
    }

    public ce<E> j_() {
        return at.a(this.a);
    }

    public int size() {
        return 1;
    }

    public ad<E> a(int i, int i2) {
        h.a(i, i2, 1);
        return i == i2 ? ad.c() : this;
    }

    public String toString() {
        String obj = this.a.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }

    boolean e() {
        return false;
    }
}
