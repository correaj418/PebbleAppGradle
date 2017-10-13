package com.google.a.b;

import com.google.a.a.h;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class am<E> extends z<E> implements Set<E> {

    static abstract class b<E> extends am<E> {
        abstract E a(int i);

        b() {
        }

        public /* synthetic */ Iterator iterator() {
            return j_();
        }

        public ce<E> j_() {
            return f().j_();
        }

        ad<E> g() {
            return new x<E>(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                /* synthetic */ z b() {
                    return j();
                }

                public E get(int i) {
                    return this.a.a(i);
                }

                b<E> j() {
                    return this.a;
                }
            };
        }
    }

    public static class a<E> extends a<E> {
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

        public am<E> a() {
            am<E> a = am.b(this.b, this.a);
            this.b = a.size();
            return a;
        }
    }

    public abstract ce<E> j_();

    public /* synthetic */ Iterator iterator() {
        return j_();
    }

    public static <E> am<E> h() {
        return bo.a;
    }

    public static <E> am<E> b(E e) {
        return new bw(e);
    }

    public static <E> am<E> a(E e, E e2) {
        return b(2, e, e2);
    }

    public static <E> am<E> a(E e, E e2, E e3) {
        return b(3, e, e2, e3);
    }

    public static <E> am<E> a(E e, E e2, E e3, E e4) {
        return b(4, e, e2, e3, e4);
    }

    public static <E> am<E> a(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Object obj = new Object[(eArr.length + 6)];
        obj[0] = e;
        obj[1] = e2;
        obj[2] = e3;
        obj[3] = e4;
        obj[4] = e5;
        obj[5] = e6;
        System.arraycopy(eArr, 0, obj, 6, eArr.length);
        return b(obj.length, obj);
    }

    private static <E> am<E> b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return h();
            case 1:
                return b(objArr[0]);
            default:
                int c = c(i);
                Object[] objArr2 = new Object[c];
                int i2 = c - 1;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < i) {
                    Object a = bf.a(objArr[i3], i3);
                    int hashCode = a.hashCode();
                    int a2 = w.a(hashCode);
                    while (true) {
                        int i6 = a2 & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            a2 = i4 + 1;
                            objArr[i4] = a;
                            objArr2[i6] = a;
                            i4 = i5 + hashCode;
                        } else if (obj.equals(a)) {
                            a2 = i4;
                            i4 = i5;
                        } else {
                            a2++;
                        }
                        i3++;
                        i5 = i4;
                        i4 = a2;
                    }
                }
                Arrays.fill(objArr, i4, i, null);
                if (i4 == 1) {
                    return new bw(objArr[0], i5);
                }
                if (c != c(i4)) {
                    return b(i4, objArr);
                }
                if (i4 < objArr.length) {
                    objArr = bf.b(objArr, i4);
                }
                return new bo(objArr, i5, objArr2, i2);
        }
    }

    static int c(int i) {
        if (i < 751619276) {
            int highestOneBit = Integer.highestOneBit(i - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) i)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        h.a(i < 1073741824, (Object) "collection too large");
        return 1073741824;
    }

    public static <E> am<E> a(Collection<? extends E> collection) {
        if ((collection instanceof am) && !(collection instanceof aq)) {
            am<E> amVar = (am) collection;
            if (!amVar.e()) {
                return amVar;
            }
        } else if (collection instanceof EnumSet) {
            return a((EnumSet) collection);
        }
        Object[] toArray = collection.toArray();
        return b(toArray.length, toArray);
    }

    public static <E> am<E> a(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? a((Collection) iterable) : a(iterable.iterator());
    }

    public static <E> am<E> a(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return h();
        }
        Object next = it.next();
        if (it.hasNext()) {
            return new a().c(next).b((Iterator) it).a();
        }
        return b(next);
    }

    public static <E> am<E> a(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return h();
            case 1:
                return b(eArr[0]);
            default:
                return b(eArr.length, (Object[]) eArr.clone());
        }
    }

    private static am a(EnumSet enumSet) {
        return ac.a(EnumSet.copyOf(enumSet));
    }

    am() {
    }

    boolean g_() {
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof am) && g_() && ((am) obj).g_() && hashCode() != obj.hashCode()) {
            return false;
        }
        return bt.a((Set) this, obj);
    }

    public int hashCode() {
        return bt.a((Set) this);
    }

    public static <E> a<E> i() {
        return new a();
    }
}
