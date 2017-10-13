package com.google.a.b;

import com.getpebble.android.framework.timeline.e;
import com.google.a.a.f;
import com.google.a.a.h;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class l {
    static final f a = f.a(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR).b("null");

    static class a<F, T> extends AbstractCollection<T> {
        final Collection<F> a;
        final com.google.a.a.e<? super F, ? extends T> b;

        a(Collection<F> collection, com.google.a.a.e<? super F, ? extends T> eVar) {
            this.a = (Collection) h.a((Object) collection);
            this.b = (com.google.a.a.e) h.a((Object) eVar);
        }

        public void clear() {
            this.a.clear();
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public Iterator<T> iterator() {
            return at.a(this.a.iterator(), this.b);
        }

        public int size() {
            return this.a.size();
        }
    }

    static boolean a(Collection<?> collection, @Nullable Object obj) {
        boolean z = false;
        h.a((Object) collection);
        try {
            z = collection.contains(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    public static <F, T> Collection<T> a(Collection<F> collection, com.google.a.a.e<? super F, T> eVar) {
        return new a(collection, eVar);
    }

    static StringBuilder a(int i) {
        k.a(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }

    static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
