package com.google.a.b;

import com.google.a.a.h;
import java.util.Iterator;

final class bw<E> extends am<E> {
    final transient E a;
    private transient int b;

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    bw(E e) {
        this.a = h.a((Object) e);
    }

    bw(E e, int i) {
        this.a = e;
        this.b = i;
    }

    public int size() {
        return 1;
    }

    public boolean contains(Object obj) {
        return this.a.equals(obj);
    }

    public ce<E> j_() {
        return at.a(this.a);
    }

    boolean e() {
        return false;
    }

    int a(Object[] objArr, int i) {
        objArr[i] = this.a;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        i = this.a.hashCode();
        this.b = i;
        return i;
    }

    boolean g_() {
        return this.b != 0;
    }

    public String toString() {
        String obj = this.a.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }
}
