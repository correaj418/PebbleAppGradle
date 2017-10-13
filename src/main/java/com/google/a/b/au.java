package com.google.a.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public final class au<E> extends e<E> {
    public /* bridge */ /* synthetic */ int a(Object obj, int i) {
        return super.a(obj, i);
    }

    public /* bridge */ /* synthetic */ Set a() {
        return super.a();
    }

    public /* bridge */ /* synthetic */ boolean a(Object obj, int i, int i2) {
        return super.a(obj, i, i2);
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public /* bridge */ /* synthetic */ int b(Object obj, int i) {
        return super.b(obj, i);
    }

    public /* bridge */ /* synthetic */ int c(Object obj, int i) {
        return super.c(obj, i);
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E> au<E> a(int i) {
        return new au(i);
    }

    public static <E> au<E> a(Iterable<? extends E> iterable) {
        Collection a = a(bd.a((Iterable) iterable));
        as.a(a, (Iterable) iterable);
        return a;
    }

    private au() {
        super(new LinkedHashMap());
    }

    private au(int i) {
        super(ay.c(i));
    }
}
