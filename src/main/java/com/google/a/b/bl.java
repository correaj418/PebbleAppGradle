package com.google.a.b;

import com.google.a.a.h;
import java.util.ListIterator;

class bl<E> extends ad<E> {
    static final ad<Object> a = new bl(bf.a);
    private final transient int b;
    private final transient int c;
    private final transient Object[] d;

    public /* synthetic */ ListIterator listIterator(int i) {
        return a(i);
    }

    bl(Object[] objArr, int i, int i2) {
        this.b = i;
        this.c = i2;
        this.d = objArr;
    }

    bl(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    public int size() {
        return this.c;
    }

    boolean e() {
        return this.c != this.d.length;
    }

    int a(Object[] objArr, int i) {
        System.arraycopy(this.d, this.b, objArr, i, this.c);
        return this.c + i;
    }

    public E get(int i) {
        h.a(i, this.c);
        return this.d[this.b + i];
    }

    ad<E> b(int i, int i2) {
        return new bl(this.d, this.b + i, i2 - i);
    }

    public cf<E> a(int i) {
        return at.a(this.d, this.b, this.c, i);
    }
}
