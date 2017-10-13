package com.google.a.b;

import java.util.Collections;
import java.util.Queue;

class n<T> extends b<T> {
    private final Queue<T> a = aw.b();

    n(T... tArr) {
        Collections.addAll(this.a, tArr);
    }

    public T a() {
        return this.a.isEmpty() ? b() : this.a.remove();
    }
}
