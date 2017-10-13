package com.b.a.f;

import java.util.ArrayList;

public class h<T> extends ArrayList<T> {
    private Object a;

    public synchronized <V> V a() {
        return this.a;
    }

    public synchronized <V> void a(V v) {
        this.a = v;
    }

    public synchronized <V> void b(V v) {
        if (this.a == null) {
            this.a = v;
        }
    }
}
