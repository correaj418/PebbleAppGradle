package com.google.a.b;

import java.util.Collection;
import java.util.Iterator;

public abstract class s<E> extends t implements Collection<E> {
    protected abstract Collection<E> a();

    protected /* synthetic */ Object b() {
        return a();
    }

    protected s() {
    }

    public Iterator<E> iterator() {
        return a().iterator();
    }

    public int size() {
        return a().size();
    }

    public boolean removeAll(Collection<?> collection) {
        return a().removeAll(collection);
    }

    public boolean isEmpty() {
        return a().isEmpty();
    }

    public boolean contains(Object obj) {
        return a().contains(obj);
    }

    public boolean add(E e) {
        return a().add(e);
    }

    public boolean remove(Object obj) {
        return a().remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return a().containsAll(collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return a().addAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return a().retainAll(collection);
    }

    public void clear() {
        a().clear();
    }

    public Object[] toArray() {
        return a().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return a().toArray(tArr);
    }
}
