package com.google.a.b;

import com.google.a.a.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

public abstract class ad<E> extends z<E> implements List<E>, RandomAccess {

    public static final class a<E> extends a<E> {
        public /* synthetic */ a a(Object obj) {
            return c(obj);
        }

        public /* synthetic */ com.google.a.b.z.b a(Iterator it) {
            return b(it);
        }

        public /* synthetic */ com.google.a.b.z.b b(Object obj) {
            return c(obj);
        }

        public a() {
            this(4);
        }

        a(int i) {
            super(i);
        }

        public a<E> c(E e) {
            super.a((Object) e);
            return this;
        }

        public a<E> b(Iterator<? extends E> it) {
            super.a(it);
            return this;
        }

        public ad<E> a() {
            return ad.b(this.a, this.b);
        }
    }

    private static class b<E> extends ad<E> {
        private final transient ad<E> a;

        public /* synthetic */ Iterator iterator() {
            return super.j_();
        }

        public /* synthetic */ ListIterator listIterator() {
            return super.d();
        }

        public /* synthetic */ ListIterator listIterator(int i) {
            return super.a(i);
        }

        public /* synthetic */ List subList(int i, int i2) {
            return a(i, i2);
        }

        b(ad<E> adVar) {
            this.a = adVar;
        }

        private int b(int i) {
            return (size() - 1) - i;
        }

        private int c(int i) {
            return size() - i;
        }

        public ad<E> h() {
            return this.a;
        }

        public boolean contains(@Nullable Object obj) {
            return this.a.contains(obj);
        }

        public int indexOf(@Nullable Object obj) {
            int lastIndexOf = this.a.lastIndexOf(obj);
            return lastIndexOf >= 0 ? b(lastIndexOf) : -1;
        }

        public int lastIndexOf(@Nullable Object obj) {
            int indexOf = this.a.indexOf(obj);
            return indexOf >= 0 ? b(indexOf) : -1;
        }

        public ad<E> a(int i, int i2) {
            h.a(i, i2, size());
            return this.a.a(c(i2), c(i)).h();
        }

        public E get(int i) {
            h.a(i, size());
            return this.a.get(b(i));
        }

        public int size() {
            return this.a.size();
        }

        boolean e() {
            return this.a.e();
        }
    }

    class c extends ad<E> {
        final transient int a;
        final transient int b;
        final /* synthetic */ ad c;

        public /* synthetic */ Iterator iterator() {
            return super.j_();
        }

        public /* synthetic */ ListIterator listIterator() {
            return super.d();
        }

        public /* synthetic */ ListIterator listIterator(int i) {
            return super.a(i);
        }

        public /* synthetic */ List subList(int i, int i2) {
            return a(i, i2);
        }

        c(ad adVar, int i, int i2) {
            this.c = adVar;
            this.a = i;
            this.b = i2;
        }

        public int size() {
            return this.b;
        }

        public E get(int i) {
            h.a(i, this.b);
            return this.c.get(this.a + i);
        }

        public ad<E> a(int i, int i2) {
            h.a(i, i2, this.b);
            return this.c.a(this.a + i, this.a + i2);
        }

        boolean e() {
            return true;
        }
    }

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    public /* synthetic */ ListIterator listIterator() {
        return d();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        return a(i);
    }

    public /* synthetic */ List subList(int i, int i2) {
        return a(i, i2);
    }

    public static <E> ad<E> c() {
        return bl.a;
    }

    public static <E> ad<E> a(E e) {
        return new bv(e);
    }

    public static <E> ad<E> a(E e, E e2) {
        return c(e, e2);
    }

    public static <E> ad<E> a(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return c(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> ad<E> a(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E... eArr) {
        Object obj = new Object[(eArr.length + 12)];
        obj[0] = e;
        obj[1] = e2;
        obj[2] = e3;
        obj[3] = e4;
        obj[4] = e5;
        obj[5] = e6;
        obj[6] = e7;
        obj[7] = e8;
        obj[8] = e9;
        obj[9] = e10;
        obj[10] = e11;
        obj[11] = e12;
        System.arraycopy(eArr, 0, obj, 12, eArr.length);
        return c(obj);
    }

    public static <E> ad<E> a(Collection<? extends E> collection) {
        if (!(collection instanceof z)) {
            return c(collection.toArray());
        }
        ad<E> f = ((z) collection).f();
        if (f.e()) {
            return b(f.toArray());
        }
        return f;
    }

    public static <E> ad<E> a(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return c();
            case 1:
                return new bv(eArr[0]);
            default:
                return new bl(bf.a((Object[]) eArr.clone()));
        }
    }

    private static <E> ad<E> c(Object... objArr) {
        return b(bf.a(objArr));
    }

    static <E> ad<E> b(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    static <E> ad<E> b(Object[] objArr, int i) {
        switch (i) {
            case 0:
                return c();
            case 1:
                return new bv(objArr[0]);
            default:
                if (i < objArr.length) {
                    objArr = bf.b(objArr, i);
                }
                return new bl(objArr);
        }
    }

    ad() {
    }

    public ce<E> j_() {
        return d();
    }

    public cf<E> d() {
        return a(0);
    }

    public cf<E> a(int i) {
        return new a<E>(this, size(), i) {
            final /* synthetic */ ad a;

            protected E a(int i) {
                return this.a.get(i);
            }
        };
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? -1 : aw.b(this, obj);
    }

    public int lastIndexOf(@Nullable Object obj) {
        return obj == null ? -1 : aw.c(this, obj);
    }

    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    public ad<E> a(int i, int i2) {
        h.a(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        switch (i3) {
            case 0:
                return c();
            case 1:
                return a(get(i));
            default:
                return b(i, i2);
        }
    }

    ad<E> b(int i, int i2) {
        return new c(this, i, i2 - i);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final ad<E> f() {
        return this;
    }

    int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public ad<E> h() {
        return size() <= 1 ? this : new b(this);
    }

    public boolean equals(@Nullable Object obj) {
        return aw.a((List) this, obj);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    public static <E> a<E> i() {
        return new a();
    }
}
