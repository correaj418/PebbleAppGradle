package com.google.a.b;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class al<E> extends z<E> implements bc<E> {
    private transient am<com.google.a.b.bc.a<E>> a;

    private final class a extends b<com.google.a.b.bc.a<E>> {
        final /* synthetic */ al a;

        /* synthetic */ Object a(int i) {
            return b(i);
        }

        private a(al alVar) {
            this.a = alVar;
        }

        boolean e() {
            return this.a.e();
        }

        com.google.a.b.bc.a<E> b(int i) {
            return this.a.a(i);
        }

        public int size() {
            return this.a.d().size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof com.google.a.b.bc.a)) {
                return false;
            }
            com.google.a.b.bc.a aVar = (com.google.a.b.bc.a) obj;
            if (aVar.b() > 0 && this.a.a(aVar.a()) == aVar.b()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    abstract com.google.a.b.bc.a<E> a(int i);

    public /* synthetic */ Set a() {
        return c();
    }

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    public static <E> al<E> b() {
        return bn.a;
    }

    public static <E> al<E> a(Iterable<? extends E> iterable) {
        if (iterable instanceof al) {
            al<E> alVar = (al) iterable;
            if (!alVar.e()) {
                return alVar;
            }
        }
        return a((iterable instanceof bc ? bd.b((Iterable) iterable) : au.a((Iterable) iterable)).a());
    }

    static <E> al<E> a(Collection<? extends com.google.a.b.bc.a<? extends E>> collection) {
        if (collection.isEmpty()) {
            return b();
        }
        return new bn(collection);
    }

    al() {
    }

    public ce<E> j_() {
        final Iterator j_ = c().j_();
        return new ce<E>(this) {
            int a;
            E b;
            final /* synthetic */ al d;

            public boolean hasNext() {
                return this.a > 0 || j_.hasNext();
            }

            public E next() {
                if (this.a <= 0) {
                    com.google.a.b.bc.a aVar = (com.google.a.b.bc.a) j_.next();
                    this.b = aVar.a();
                    this.a = aVar.b();
                }
                this.a--;
                return this.b;
            }
        };
    }

    public boolean contains(@Nullable Object obj) {
        return a(obj) > 0;
    }

    @Deprecated
    public final int a(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int b(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int c(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean a(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    int a(Object[] objArr, int i) {
        Iterator it = c().iterator();
        while (it.hasNext()) {
            com.google.a.b.bc.a aVar = (com.google.a.b.bc.a) it.next();
            Arrays.fill(objArr, i, aVar.b() + i, aVar.a());
            i += aVar.b();
        }
        return i;
    }

    public boolean equals(@Nullable Object obj) {
        return bd.a((bc) this, obj);
    }

    public int hashCode() {
        return bt.a(c());
    }

    public String toString() {
        return c().toString();
    }

    public am<com.google.a.b.bc.a<E>> c() {
        am<com.google.a.b.bc.a<E>> amVar = this.a;
        if (amVar != null) {
            return amVar;
        }
        amVar = h();
        this.a = amVar;
        return amVar;
    }

    private final am<com.google.a.b.bc.a<E>> h() {
        return isEmpty() ? am.h() : new a();
    }
}
