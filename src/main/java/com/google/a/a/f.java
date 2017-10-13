package com.google.a.a;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public class f {
    private final String a;

    public static final class a {
        private final f a;
        private final String b;

        private a(f fVar, String str) {
            this.a = fVar;
            this.b = (String) h.a((Object) str);
        }

        public StringBuilder a(StringBuilder stringBuilder, Map<?, ?> map) {
            return a(stringBuilder, map.entrySet());
        }

        public <A extends Appendable> A a(A a, Iterator<? extends Entry<?, ?>> it) {
            h.a((Object) a);
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                a.append(this.a.a(entry.getKey()));
                a.append(this.b);
                a.append(this.a.a(entry.getValue()));
                while (it.hasNext()) {
                    a.append(this.a.a);
                    entry = (Entry) it.next();
                    a.append(this.a.a(entry.getKey()));
                    a.append(this.b);
                    a.append(this.a.a(entry.getValue()));
                }
            }
            return a;
        }

        public StringBuilder a(StringBuilder stringBuilder, Iterable<? extends Entry<?, ?>> iterable) {
            return a(stringBuilder, iterable.iterator());
        }

        public StringBuilder a(StringBuilder stringBuilder, Iterator<? extends Entry<?, ?>> it) {
            try {
                a((Appendable) stringBuilder, (Iterator) it);
                return stringBuilder;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    @CheckReturnValue
    public static f a(String str) {
        return new f(str);
    }

    @CheckReturnValue
    public static f a(char c) {
        return new f(String.valueOf(c));
    }

    private f(String str) {
        this.a = (String) h.a((Object) str);
    }

    private f(f fVar) {
        this.a = fVar.a;
    }

    public <A extends Appendable> A a(A a, Iterator<?> it) {
        h.a((Object) a);
        if (it.hasNext()) {
            a.append(a(it.next()));
            while (it.hasNext()) {
                a.append(this.a);
                a.append(a(it.next()));
            }
        }
        return a;
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterator<?> it) {
        try {
            a((Appendable) stringBuilder, (Iterator) it);
            return stringBuilder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CheckReturnValue
    public final String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    @CheckReturnValue
    public final String a(Iterator<?> it) {
        return a(new StringBuilder(), (Iterator) it).toString();
    }

    @CheckReturnValue
    public final String a(Object[] objArr) {
        return a(Arrays.asList(objArr));
    }

    @CheckReturnValue
    public final String a(@Nullable Object obj, @Nullable Object obj2, Object... objArr) {
        return a(b(obj, obj2, objArr));
    }

    @CheckReturnValue
    public f b(final String str) {
        h.a((Object) str);
        return new f(this, this) {
            final /* synthetic */ f b;

            CharSequence a(@Nullable Object obj) {
                return obj == null ? str : this.b.a(obj);
            }

            public f b(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    @CheckReturnValue
    public a c(String str) {
        return new a(str);
    }

    CharSequence a(Object obj) {
        h.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    private static Iterable<Object> b(final Object obj, final Object obj2, final Object[] objArr) {
        h.a((Object) objArr);
        return new AbstractList<Object>() {
            public int size() {
                return objArr.length + 2;
            }

            public Object get(int i) {
                switch (i) {
                    case 0:
                        return obj;
                    case 1:
                        return obj2;
                    default:
                        return objArr[i - 2];
                }
            }
        };
    }
}
