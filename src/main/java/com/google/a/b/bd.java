package com.google.a.b;

import com.google.a.a.g;
import com.google.a.a.h;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

public final class bd {
    private static final bg<com.google.a.b.bc.a<?>> a = new bg<com.google.a.b.bc.a<?>>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((com.google.a.b.bc.a) obj, (com.google.a.b.bc.a) obj2);
        }

        public int a(com.google.a.b.bc.a<?> aVar, com.google.a.b.bc.a<?> aVar2) {
            return com.google.a.f.a.a(aVar2.b(), aVar.b());
        }
    };

    static abstract class a<E> implements com.google.a.b.bc.a<E> {
        a() {
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof com.google.a.b.bc.a)) {
                return false;
            }
            com.google.a.b.bc.a aVar = (com.google.a.b.bc.a) obj;
            if (b() == aVar.b() && g.a(a(), aVar.a())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object a = a();
            return (a == null ? 0 : a.hashCode()) ^ b();
        }

        public String toString() {
            String valueOf = String.valueOf(a());
            int b = b();
            return b == 1 ? valueOf : valueOf + " x " + b;
        }
    }

    static abstract class b<E> extends a<E> {
        abstract bc<E> a();

        b() {
        }

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return a().containsAll(collection);
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        public Iterator<E> iterator() {
            return new cb<com.google.a.b.bc.a<E>, E>(this, a().a().iterator()) {
                final /* synthetic */ b a;

                E a(com.google.a.b.bc.a<E> aVar) {
                    return aVar.a();
                }
            };
        }

        public boolean remove(Object obj) {
            return a().b(obj, Integer.MAX_VALUE) > 0;
        }

        public int size() {
            return a().a().size();
        }
    }

    static abstract class c<E> extends a<com.google.a.b.bc.a<E>> {
        abstract bc<E> a();

        c() {
        }

        public boolean contains(@Nullable Object obj) {
            if (!(obj instanceof com.google.a.b.bc.a)) {
                return false;
            }
            com.google.a.b.bc.a aVar = (com.google.a.b.bc.a) obj;
            if (aVar.b() > 0 && a().a(aVar.a()) == aVar.b()) {
                return true;
            }
            return false;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof com.google.a.b.bc.a)) {
                return false;
            }
            com.google.a.b.bc.a aVar = (com.google.a.b.bc.a) obj;
            Object a = aVar.a();
            int b = aVar.b();
            if (b != 0) {
                return a().a(a, b, 0);
            }
            return false;
        }

        public void clear() {
            a().clear();
        }
    }

    static class d<E> extends a<E> implements Serializable {
        @Nullable
        private final E a;
        private final int b;

        d(@Nullable E e, int i) {
            this.a = e;
            this.b = i;
            k.a(i, "count");
        }

        @Nullable
        public final E a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public d<E> c() {
            return null;
        }
    }

    static final class e<E> implements Iterator<E> {
        private final bc<E> a;
        private final Iterator<com.google.a.b.bc.a<E>> b;
        private com.google.a.b.bc.a<E> c;
        private int d;
        private int e;
        private boolean f;

        e(bc<E> bcVar, Iterator<com.google.a.b.bc.a<E>> it) {
            this.a = bcVar;
            this.b = it;
        }

        public boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        public E next() {
            if (hasNext()) {
                if (this.d == 0) {
                    this.c = (com.google.a.b.bc.a) this.b.next();
                    int b = this.c.b();
                    this.d = b;
                    this.e = b;
                }
                this.d--;
                this.f = true;
                return this.c.a();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            k.a(this.f);
            if (this.e == 1) {
                this.b.remove();
            } else {
                this.a.remove(this.c.a());
            }
            this.e--;
            this.f = false;
        }
    }

    static int a(Iterable<?> iterable) {
        if (iterable instanceof bc) {
            return ((bc) iterable).d().size();
        }
        return 11;
    }

    static boolean a(bc<?> bcVar, @Nullable Object obj) {
        if (obj == bcVar) {
            return true;
        }
        if (!(obj instanceof bc)) {
            return false;
        }
        bc bcVar2 = (bc) obj;
        if (bcVar.size() != bcVar2.size() || bcVar.a().size() != bcVar2.a().size()) {
            return false;
        }
        for (com.google.a.b.bc.a aVar : bcVar2.a()) {
            if (bcVar.a(aVar.a()) != aVar.b()) {
                return false;
            }
        }
        return true;
    }

    static <E> boolean a(bc<E> bcVar, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof bc) {
            for (com.google.a.b.bc.a aVar : b((Iterable) collection).a()) {
                bcVar.a(aVar.a(), aVar.b());
            }
        } else {
            at.a((Collection) bcVar, collection.iterator());
        }
        return true;
    }

    static boolean b(bc<?> bcVar, Collection<?> collection) {
        if (collection instanceof bc) {
            collection = ((bc) collection).d();
        }
        return bcVar.d().removeAll(collection);
    }

    static boolean c(bc<?> bcVar, Collection<?> collection) {
        h.a((Object) collection);
        if (collection instanceof bc) {
            collection = ((bc) collection).d();
        }
        return bcVar.d().retainAll(collection);
    }

    static <E> int a(bc<E> bcVar, E e, int i) {
        k.a(i, "count");
        int a = bcVar.a(e);
        int i2 = i - a;
        if (i2 > 0) {
            bcVar.a(e, i2);
        } else if (i2 < 0) {
            bcVar.b(e, -i2);
        }
        return a;
    }

    static <E> boolean a(bc<E> bcVar, E e, int i, int i2) {
        k.a(i, "oldCount");
        k.a(i2, "newCount");
        if (bcVar.a(e) != i) {
            return false;
        }
        bcVar.c(e, i2);
        return true;
    }

    static <E> Iterator<E> a(bc<E> bcVar) {
        return new e(bcVar, bcVar.a().iterator());
    }

    static int b(bc<?> bcVar) {
        long j = 0;
        for (com.google.a.b.bc.a b : bcVar.a()) {
            j = ((long) b.b()) + j;
        }
        return com.google.a.f.a.b(j);
    }

    static <T> bc<T> b(Iterable<T> iterable) {
        return (bc) iterable;
    }
}
