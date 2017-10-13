package com.google.a.b;

import com.google.a.a.e;
import com.google.a.a.h;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

public abstract class bg<T> implements Comparator<T> {
    public abstract int compare(@Nullable T t, @Nullable T t2);

    public static <C extends Comparable> bg<C> b() {
        return be.a;
    }

    public static <T> bg<T> a(Comparator<T> comparator) {
        return comparator instanceof bg ? (bg) comparator : new m(comparator);
    }

    protected bg() {
    }

    public <S extends T> bg<S> a() {
        return new br(this);
    }

    public <F> bg<F> a(e<F, ? extends T> eVar) {
        return new j(eVar, this);
    }

    <T2 extends T> bg<Entry<T2, ?>> c() {
        return a(ay.a());
    }

    public <E extends T> ad<E> a(Iterable<E> iterable) {
        Object[] c = as.c(iterable);
        for (Object a : c) {
            h.a(a);
        }
        Arrays.sort(c, this);
        return ad.b(c);
    }
}
