package com.google.a.b;

import com.google.a.a.h;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

public abstract class z<E> extends AbstractCollection<E> implements Serializable {
    private transient ad<E> a;

    public static abstract class b<E> {
        public abstract b<E> b(E e);

        static int a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = ((i >> 1) + i) + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        b() {
        }

        public b<E> a(Iterator<? extends E> it) {
            while (it.hasNext()) {
                b(it.next());
            }
            return this;
        }
    }

    static abstract class a<E> extends b<E> {
        Object[] a;
        int b = 0;

        public /* synthetic */ b b(Object obj) {
            return a(obj);
        }

        a(int i) {
            k.a(i, "initialCapacity");
            this.a = new Object[i];
        }

        private void a(int i) {
            if (this.a.length < i) {
                this.a = bf.b(this.a, b.a(this.a.length, i));
            }
        }

        public a<E> a(E e) {
            h.a((Object) e);
            a(this.b + 1);
            Object[] objArr = this.a;
            int i = this.b;
            this.b = i + 1;
            objArr[i] = e;
            return this;
        }
    }

    public abstract boolean contains(@Nullable Object obj);

    abstract boolean e();

    public abstract ce<E> j_();

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    z() {
    }

    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return bf.a;
        }
        Object[] objArr = new Object[size];
        a(objArr, 0);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        h.a((Object) tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = bf.a((Object[]) tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr, 0);
        return tArr;
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ad<E> f() {
        ad<E> adVar = this.a;
        if (adVar != null) {
            return adVar;
        }
        adVar = g();
        this.a = adVar;
        return adVar;
    }

    ad<E> g() {
        switch (size()) {
            case 0:
                return ad.c();
            case 1:
                return ad.a(j_().next());
            default:
                return new bj(this, toArray());
        }
    }

    int a(Object[] objArr, int i) {
        Iterator it = iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            objArr[i] = it.next();
            i = i2;
        }
        return i;
    }
}
