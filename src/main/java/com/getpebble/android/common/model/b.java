package com.getpebble.android.common.model;

import com.getpebble.android.h.p;
import com.google.b.a.c;
import com.google.b.c.a;

public class b<T> {
    @c(a = "hits")
    T[] a;

    public T[] a() {
        return this.a;
    }

    public static b<g> a(String str) {
        return (b) p.a(str, new a<b<g>>() {
        }.getType());
    }

    public static b<f> b(String str) {
        return (b) p.a(str, new a<b<f>>() {
        }.getType());
    }
}
