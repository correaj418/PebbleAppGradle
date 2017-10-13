package com.google.a.b;

import com.google.a.a.h;
import com.google.a.b.bz.a;
import com.google.a.b.bz.b;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

final class bp<E> extends aq<E> {
    private final transient ad<E> c;

    public /* synthetic */ Iterator descendingIterator() {
        return c();
    }

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    bp(ad<E> adVar, Comparator<? super E> comparator) {
        super(comparator);
        this.c = adVar;
    }

    public ce<E> j_() {
        return this.c.j_();
    }

    public ce<E> c() {
        return this.c.h().j_();
    }

    public int size() {
        return this.c.size();
    }

    public boolean contains(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return e(obj) >= 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof bc) {
            collection = ((bc) collection).d();
        }
        if (!by.a(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        bh h = at.h(j_());
        Iterator it = collection.iterator();
        Object next = it.next();
        while (h.hasNext()) {
            try {
                int b = b(h.a(), next);
                if (b < 0) {
                    h.next();
                } else if (b == 0) {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else if (b > 0) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return false;
    }

    private int e(Object obj) {
        return Collections.binarySearch(this.c, obj, j());
    }

    boolean e() {
        return this.c.e();
    }

    int a(Object[] objArr, int i) {
        return this.c.a(objArr, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!by.a(this.a, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            Iterator j_ = j_();
            while (j_.hasNext()) {
                Object next = j_.next();
                Object next2 = it.next();
                if (next2 != null) {
                    if (b(next, next2) != 0) {
                    }
                }
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NoSuchElementException e2) {
            return false;
        }
    }

    public E first() {
        if (!isEmpty()) {
            return this.c.get(0);
        }
        throw new NoSuchElementException();
    }

    public E last() {
        if (!isEmpty()) {
            return this.c.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    public E lower(E e) {
        int e2 = e(e, false) - 1;
        return e2 == -1 ? null : this.c.get(e2);
    }

    public E floor(E e) {
        int e2 = e(e, true) - 1;
        return e2 == -1 ? null : this.c.get(e2);
    }

    public E ceiling(E e) {
        int f = f(e, true);
        return f == size() ? null : this.c.get(f);
    }

    public E higher(E e) {
        int f = f(e, false);
        return f == size() ? null : this.c.get(f);
    }

    aq<E> a(E e, boolean z) {
        return a(0, e(e, z));
    }

    int e(E e, boolean z) {
        return bz.a(this.c, h.a((Object) e), comparator(), z ? b.FIRST_AFTER : b.FIRST_PRESENT, a.NEXT_HIGHER);
    }

    aq<E> a(E e, boolean z, E e2, boolean z2) {
        return b(e, z).a(e2, z2);
    }

    aq<E> b(E e, boolean z) {
        return a(f(e, z), size());
    }

    int f(E e, boolean z) {
        return bz.a(this.c, h.a((Object) e), comparator(), z ? b.FIRST_PRESENT : b.FIRST_AFTER, a.NEXT_HIGHER);
    }

    Comparator<Object> j() {
        return this.a;
    }

    bp<E> a(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new bp(this.c.a(i, i2), this.a);
        }
        return aq.a(this.a);
    }

    int a(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int a = bz.a(this.c, obj, j(), b.ANY_PRESENT, a.INVERTED_INSERTION_INDEX);
            if (a < 0) {
                a = -1;
            }
            return a;
        } catch (ClassCastException e) {
            return -1;
        }
    }

    ad<E> g() {
        return size() <= 1 ? this.c : new an(this, this.c);
    }

    aq<E> d() {
        Comparator a = bg.a(this.a).a();
        return isEmpty() ? aq.a(a) : new bp(this.c.h(), a);
    }
}
