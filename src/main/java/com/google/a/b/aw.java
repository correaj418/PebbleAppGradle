package com.google.a.b;

import com.google.a.a.e;
import com.google.a.a.g;
import com.google.a.a.h;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class aw {

    private static class a<T> extends AbstractList<List<T>> {
        final List<T> a;
        final int b;

        public /* synthetic */ Object get(int i) {
            return a(i);
        }

        a(List<T> list, int i) {
            this.a = list;
            this.b = i;
        }

        public List<T> a(int i) {
            h.a(i, size());
            int i2 = this.b * i;
            return this.a.subList(i2, Math.min(this.b + i2, this.a.size()));
        }

        public int size() {
            return com.google.a.d.a.a(this.a.size(), this.b, RoundingMode.CEILING);
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }
    }

    private static class b<T> extends a<T> implements RandomAccess {
        b(List<T> list, int i) {
            super(list, i);
        }
    }

    private static class c<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
        final List<F> a;
        final e<? super F, ? extends T> b;

        c(List<F> list, e<? super F, ? extends T> eVar) {
            this.a = (List) h.a((Object) list);
            this.b = (e) h.a((Object) eVar);
        }

        public void clear() {
            this.a.clear();
        }

        public T get(int i) {
            return this.b.apply(this.a.get(i));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            return new cc<F, T>(this, this.a.listIterator(i)) {
                final /* synthetic */ c a;

                T a(F f) {
                    return this.a.b.apply(f);
                }
            };
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public T remove(int i) {
            return this.b.apply(this.a.remove(i));
        }

        public int size() {
            return this.a.size();
        }
    }

    private static class d<F, T> extends AbstractSequentialList<T> implements Serializable {
        final List<F> a;
        final e<? super F, ? extends T> b;

        d(List<F> list, e<? super F, ? extends T> eVar) {
            this.a = (List) h.a((Object) list);
            this.b = (e) h.a((Object) eVar);
        }

        public void clear() {
            this.a.clear();
        }

        public int size() {
            return this.a.size();
        }

        public ListIterator<T> listIterator(int i) {
            return new cc<F, T>(this, this.a.listIterator(i)) {
                final /* synthetic */ d a;

                T a(F f) {
                    return this.a.b.apply(f);
                }
            };
        }
    }

    public static <E> ArrayList<E> a() {
        return new ArrayList();
    }

    public static <E> ArrayList<E> a(Iterable<? extends E> iterable) {
        h.a((Object) iterable);
        return iterable instanceof Collection ? new ArrayList(l.a((Iterable) iterable)) : a(iterable.iterator());
    }

    public static <E> ArrayList<E> a(Iterator<? extends E> it) {
        Collection a = a();
        at.a(a, (Iterator) it);
        return a;
    }

    public static <E> LinkedList<E> b() {
        return new LinkedList();
    }

    @CheckReturnValue
    public static <F, T> List<T> a(List<F> list, e<? super F, ? extends T> eVar) {
        return list instanceof RandomAccess ? new c(list, eVar) : new d(list, eVar);
    }

    public static <T> List<List<T>> a(List<T> list, int i) {
        h.a((Object) list);
        h.a(i > 0);
        return list instanceof RandomAccess ? new b(list, i) : new a(list, i);
    }

    static boolean a(List<?> list, @Nullable Object obj) {
        if (obj == h.a((Object) list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return at.a(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!g.a(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static int b(List<?> list, @Nullable Object obj) {
        if (list instanceof RandomAccess) {
            return d(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (g.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int d(List<?> list, @Nullable Object obj) {
        int i = 0;
        int size = list.size();
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < size) {
                if (obj.equals(list.get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    static int c(List<?> list, @Nullable Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (g.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, @Nullable Object obj) {
        int size;
        if (obj == null) {
            for (size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
        } else {
            for (size = list.size() - 1; size >= 0; size--) {
                if (obj.equals(list.get(size))) {
                    return size;
                }
            }
        }
        return -1;
    }
}
