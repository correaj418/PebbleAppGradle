package com.google.a.b;

import com.google.a.a.e;
import com.google.a.a.h;
import com.google.a.a.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class as {
    public static <T> boolean a(Iterable<T> iterable, i<? super T> iVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            return a((List) iterable, (i) h.a((Object) iVar));
        }
        return at.a(iterable.iterator(), (i) iVar);
    }

    private static <T> boolean a(List<T> list, i<? super T> iVar) {
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (i2 < list.size()) {
            Object obj = list.get(i2);
            if (!iVar.apply(obj)) {
                if (i2 > i) {
                    try {
                        list.set(i, obj);
                    } catch (UnsupportedOperationException e) {
                        a(list, iVar, i, i2);
                        return true;
                    }
                }
                i++;
            }
            i2++;
        }
        list.subList(i, list.size()).clear();
        if (i2 != i) {
            z = true;
        }
        return z;
    }

    private static <T> void a(List<T> list, i<? super T> iVar, int i, int i2) {
        int size;
        for (size = list.size() - 1; size > i2; size--) {
            if (iVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (size = i2 - 1; size >= i; size--) {
            list.remove(size);
        }
    }

    public static String a(Iterable<?> iterable) {
        return at.c(iterable.iterator());
    }

    public static <T> T b(Iterable<T> iterable) {
        return at.d(iterable.iterator());
    }

    static <T> T[] a(Iterable<? extends T> iterable, T[] tArr) {
        return e(iterable).toArray(tArr);
    }

    static Object[] c(Iterable<?> iterable) {
        return e(iterable).toArray();
    }

    private static <E> Collection<E> e(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : aw.a(iterable.iterator());
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(l.a((Iterable) iterable));
        }
        return at.a((Collection) collection, ((Iterable) h.a((Object) iterable)).iterator());
    }

    @CheckReturnValue
    public static <T> Iterable<T> b(final Iterable<T> iterable, final i<? super T> iVar) {
        h.a((Object) iterable);
        h.a((Object) iVar);
        return new r<T>() {
            public Iterator<T> iterator() {
                return at.b(iterable.iterator(), iVar);
            }
        };
    }

    @CheckReturnValue
    public static <T> Iterable<T> a(final Iterable<?> iterable, final Class<T> cls) {
        h.a((Object) iterable);
        h.a((Object) cls);
        return new r<T>() {
            public Iterator<T> iterator() {
                return at.a(iterable.iterator(), cls);
            }
        };
    }

    @Nullable
    public static <T> T a(Iterable<? extends T> iterable, i<? super T> iVar, @Nullable T t) {
        return at.a(iterable.iterator(), iVar, t);
    }

    public static <T> int c(Iterable<T> iterable, i<? super T> iVar) {
        return at.d(iterable.iterator(), iVar);
    }

    @CheckReturnValue
    public static <F, T> Iterable<T> a(final Iterable<F> iterable, final e<? super F, ? extends T> eVar) {
        h.a((Object) iterable);
        h.a((Object) eVar);
        return new r<T>() {
            public Iterator<T> iterator() {
                return at.a(iterable.iterator(), eVar);
            }
        };
    }

    @Nullable
    public static <T> T a(Iterable<? extends T> iterable, @Nullable T t) {
        return at.b(iterable.iterator(), (Object) t);
    }

    public static <T> T d(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return at.f(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return a(list);
        }
        throw new NoSuchElementException();
    }

    private static <T> T a(List<T> list) {
        return list.get(list.size() - 1);
    }
}
