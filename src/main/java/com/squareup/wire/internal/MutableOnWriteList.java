package com.squareup.wire.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

final class MutableOnWriteList<T> extends AbstractList<T> implements Serializable, RandomAccess {
    private final List<T> immutableList;
    List<T> mutableList;

    MutableOnWriteList(List<T> list) {
        this.immutableList = list;
        this.mutableList = list;
    }

    public T get(int i) {
        return this.mutableList.get(i);
    }

    public int size() {
        return this.mutableList.size();
    }

    public T set(int i, T t) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        return this.mutableList.set(i, t);
    }

    public void add(int i, T t) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        this.mutableList.add(i, t);
    }

    public T remove(int i) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        return this.mutableList.remove(i);
    }

    private Object writeReplace() {
        return new ArrayList(this.mutableList);
    }
}
