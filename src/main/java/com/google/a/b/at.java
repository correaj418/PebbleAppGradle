package com.google.a.b;

import com.getpebble.android.framework.timeline.e;
import com.google.a.a.g;
import com.google.a.a.h;
import com.google.a.a.i;
import com.google.a.a.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class at {
    static final cf<Object> a = new cf<Object>() {
        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public boolean hasPrevious() {
            return false;
        }

        public Object previous() {
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return 0;
        }

        public int previousIndex() {
            return -1;
        }
    };
    private static final Iterator<Object> b = new Iterator<Object>() {
        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            k.a(false);
        }
    };

    private static class a<E> implements bh<E> {
        private final Iterator<? extends E> a;
        private boolean b;
        private E c;

        public a(Iterator<? extends E> it) {
            this.a = (Iterator) h.a((Object) it);
        }

        public boolean hasNext() {
            return this.b || this.a.hasNext();
        }

        public E next() {
            if (!this.b) {
                return this.a.next();
            }
            E e = this.c;
            this.b = false;
            this.c = null;
            return e;
        }

        public void remove() {
            h.b(!this.b, (Object) "Can't remove after you've peeked at next");
            this.a.remove();
        }

        public E a() {
            if (!this.b) {
                this.c = this.a.next();
                this.b = true;
            }
            return this.c;
        }
    }

    @Deprecated
    public static <T> ce<T> a() {
        return b();
    }

    static <T> cf<T> b() {
        return a;
    }

    static <T> Iterator<T> c() {
        return b;
    }

    public static <T> ce<T> a(final Iterator<T> it) {
        h.a((Object) it);
        if (it instanceof ce) {
            return (ce) it;
        }
        return new ce<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return it.next();
            }
        };
    }

    public static int b(Iterator<?> it) {
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
        }
        return i;
    }

    public static boolean a(Iterator<?> it, @Nullable Object obj) {
        return c(it, j.a(obj));
    }

    public static boolean a(Iterator<?> it, Collection<?> collection) {
        return a((Iterator) it, j.a((Collection) collection));
    }

    public static <T> boolean a(Iterator<T> it, i<? super T> iVar) {
        h.a((Object) iVar);
        boolean z = false;
        while (it.hasNext()) {
            if (iVar.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!g.a(it.next(), it2.next())) {
                return false;
            }
        }
        if (it2.hasNext()) {
            return false;
        }
        return true;
    }

    public static String c(Iterator<?> it) {
        return l.a.a(new StringBuilder().append('['), (Iterator) it).append(']').toString();
    }

    public static <T> T d(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected one element but was: <" + next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + it.next());
        }
        if (it.hasNext()) {
            stringBuilder.append(", ...");
        }
        stringBuilder.append('>');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        h.a((Object) collection);
        h.a((Object) it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> Iterator<T> b(Iterator<? extends T> it, Iterator<? extends T> it2) {
        h.a((Object) it);
        h.a((Object) it2);
        return e(new n(it, it2));
    }

    public static <T> Iterator<T> e(final Iterator<? extends Iterator<? extends T>> it) {
        h.a((Object) it);
        return new Iterator<T>() {
            Iterator<? extends T> a = at.a();
            Iterator<? extends T> b;

            public boolean hasNext() {
                boolean hasNext;
                while (true) {
                    hasNext = ((Iterator) h.a(this.a)).hasNext();
                    if (hasNext || !it.hasNext()) {
                        return hasNext;
                    }
                    this.a = (Iterator) it.next();
                }
                return hasNext;
            }

            public T next() {
                if (hasNext()) {
                    this.b = this.a;
                    return this.a.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                k.a(this.b != null);
                this.b.remove();
                this.b = null;
            }
        };
    }

    @CheckReturnValue
    public static <T> ce<T> b(final Iterator<T> it, final i<? super T> iVar) {
        h.a((Object) it);
        h.a((Object) iVar);
        return new b<T>() {
            protected T a() {
                while (it.hasNext()) {
                    T next = it.next();
                    if (iVar.apply(next)) {
                        return next;
                    }
                }
                return b();
            }
        };
    }

    @CheckReturnValue
    public static <T> ce<T> a(Iterator<?> it, Class<T> cls) {
        return b((Iterator) it, j.a((Class) cls));
    }

    public static <T> boolean c(Iterator<T> it, i<? super T> iVar) {
        return d(it, iVar) != -1;
    }

    @Nullable
    public static <T> T a(Iterator<? extends T> it, i<? super T> iVar, @Nullable T t) {
        return b(b((Iterator) it, (i) iVar), (Object) t);
    }

    public static <T> int d(Iterator<T> it, i<? super T> iVar) {
        h.a((Object) iVar, (Object) "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (iVar.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <F, T> Iterator<T> a(Iterator<F> it, final com.google.a.a.e<? super F, ? extends T> eVar) {
        h.a((Object) eVar);
        return new cb<F, T>(it) {
            T a(F f) {
                return eVar.apply(f);
            }
        };
    }

    @Nullable
    public static <T> T b(Iterator<? extends T> it, @Nullable T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> T f(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    static void g(Iterator<?> it) {
        h.a((Object) it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> ce<T> a(T... tArr) {
        return a(tArr, 0, tArr.length, 0);
    }

    static <T> cf<T> a(final T[] tArr, final int i, int i2, int i3) {
        h.a(i2 >= 0);
        h.a(i, i + i2, tArr.length);
        h.b(i3, i2);
        if (i2 == 0) {
            return b();
        }
        return new a<T>(i2, i3) {
            protected T a(int i) {
                return tArr[i + i];
            }
        };
    }

    public static <T> ce<T> a(@Nullable final T t) {
        return new ce<T>() {
            boolean a;

            public boolean hasNext() {
                return !this.a;
            }

            public T next() {
                if (this.a) {
                    throw new NoSuchElementException();
                }
                this.a = true;
                return t;
            }
        };
    }

    public static <T> bh<T> h(Iterator<? extends T> it) {
        if (it instanceof a) {
            return (a) it;
        }
        return new a(it);
    }

    static <T> ListIterator<T> i(Iterator<T> it) {
        return (ListIterator) it;
    }
}
