package com.squareup.wire.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

final class ImmutableList<T> extends AbstractList<T> implements Serializable, RandomAccess {
    private final ArrayList<T> list;

    ImmutableList(List<T> list) {
        this.list = new ArrayList(list);
    }

    public int size() {
        return this.list.size();
    }

    public T get(int i) {
        return this.list.get(i);
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    private Object writeReplace() {
        return Collections.unmodifiableList(this.list);
    }
}
