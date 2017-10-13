package com.google.a.b;

import com.google.a.a.h;
import com.google.a.a.i;
import com.google.a.a.j;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

public final class bt {

    static abstract class a<E> extends AbstractSet<E> {
        a() {
        }

        public boolean removeAll(Collection<?> collection) {
            return bt.a((Set) this, (Collection) collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) h.a((Object) collection));
        }
    }

    public static abstract class b<E> extends AbstractSet<E> {
        private b() {
        }
    }

    public static <E> HashSet<E> a() {
        return new HashSet();
    }

    public static <E> HashSet<E> a(E... eArr) {
        Object a = a(eArr.length);
        Collections.addAll(a, eArr);
        return a;
    }

    public static <E> HashSet<E> a(int i) {
        return new HashSet(ay.b(i));
    }

    public static <E> b<E> a(final Set<? extends E> set, final Set<? extends E> set2) {
        h.a((Object) set, (Object) "set1");
        h.a((Object) set2, (Object) "set2");
        final Set c = c(set2, set);
        return new b<E>() {
            public int size() {
                return set.size() + c.size();
            }

            public boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            public Iterator<E> iterator() {
                return at.a(at.b(set.iterator(), c.iterator()));
            }

            public boolean contains(Object obj) {
                return set.contains(obj) || set2.contains(obj);
            }
        };
    }

    public static <E> b<E> b(final Set<E> set, final Set<?> set2) {
        h.a((Object) set, (Object) "set1");
        h.a((Object) set2, (Object) "set2");
        final i a = j.a((Collection) set2);
        return new b<E>() {
            public Iterator<E> iterator() {
                return at.b(set.iterator(), a);
            }

            public int size() {
                return at.b(iterator());
            }

            public boolean isEmpty() {
                return !iterator().hasNext();
            }

            public boolean contains(Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }
        };
    }

    public static <E> b<E> c(final Set<E> set, final Set<?> set2) {
        h.a((Object) set, (Object) "set1");
        h.a((Object) set2, (Object) "set2");
        final i a = j.a(j.a((Collection) set2));
        return new b<E>() {
            public Iterator<E> iterator() {
                return at.b(set.iterator(), a);
            }

            public int size() {
                return at.b(iterator());
            }

            public boolean isEmpty() {
                return set2.containsAll(set);
            }

            public boolean contains(Object obj) {
                return set.contains(obj) && !set2.contains(obj);
            }
        };
    }

    static int a(Set<?> set) {
        int i = 0;
        for (Object next : set) {
            int hashCode;
            if (next != null) {
                hashCode = next.hashCode();
            } else {
                hashCode = 0;
            }
            i = ((i + hashCode) ^ -1) ^ -1;
        }
        return i;
    }

    static boolean a(Set<?> set, @Nullable Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    static boolean a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean a(Set<?> set, Collection<?> collection) {
        h.a((Object) collection);
        if (collection instanceof bc) {
            Collection d = ((bc) collection).d();
        }
        if (!(d instanceof Set) || d.size() <= set.size()) {
            return a((Set) set, d.iterator());
        }
        return at.a(set.iterator(), d);
    }
}
