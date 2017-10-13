package com.google.a.b;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

final class ac<E extends Enum<E>> extends am<E> {
    private final transient EnumSet<E> a;
    private transient int b;

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    static am a(EnumSet enumSet) {
        switch (enumSet.size()) {
            case 0:
                return am.h();
            case 1:
                return am.b(as.b(enumSet));
            default:
                return new ac(enumSet);
        }
    }

    private ac(EnumSet<E> enumSet) {
        this.a = enumSet;
    }

    boolean e() {
        return false;
    }

    public ce<E> j_() {
        return at.a(this.a.iterator());
    }

    public int size() {
        return this.a.size();
    }

    public boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof ac) {
            collection = ((ac) collection).a;
        }
        return this.a.containsAll(collection);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ac) {
            obj = ((ac) obj).a;
        }
        return this.a.equals(obj);
    }

    boolean g_() {
        return true;
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        i = this.a.hashCode();
        this.b = i;
        return i;
    }

    public String toString() {
        return this.a.toString();
    }
}
