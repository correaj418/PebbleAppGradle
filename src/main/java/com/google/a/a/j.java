package com.google.a.a;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class j {
    private static final f a = f.a(',');

    private static class a<T> implements i<T>, Serializable {
        private final Collection<?> a;

        private a(Collection<?> collection) {
            this.a = (Collection) h.a((Object) collection);
        }

        public boolean apply(@Nullable T t) {
            boolean z = false;
            try {
                z = this.a.contains(t);
            } catch (NullPointerException e) {
            } catch (ClassCastException e2) {
            }
            return z;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            return this.a.equals(((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.a + ")";
        }
    }

    private static class b implements i<Object>, Serializable {
        private final Class<?> a;

        private b(Class<?> cls) {
            this.a = (Class) h.a((Object) cls);
        }

        public boolean apply(@Nullable Object obj) {
            return this.a.isInstance(obj);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (this.a == ((b) obj).a) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.a.getName() + ")";
        }
    }

    private static class c<T> implements i<T>, Serializable {
        private final T a;

        private c(T t) {
            this.a = t;
        }

        public boolean apply(T t) {
            return this.a.equals(t);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return this.a.equals(((c) obj).a);
        }

        public String toString() {
            return "Predicates.equalTo(" + this.a + ")";
        }
    }

    private static class d<T> implements i<T>, Serializable {
        final i<T> a;

        d(i<T> iVar) {
            this.a = (i) h.a((Object) iVar);
        }

        public boolean apply(@Nullable T t) {
            return !this.a.apply(t);
        }

        public int hashCode() {
            return this.a.hashCode() ^ -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            return this.a.equals(((d) obj).a);
        }

        public String toString() {
            return "Predicates.not(" + this.a + ")";
        }
    }

    enum e implements i<Object> {
        ALWAYS_TRUE {
            public boolean apply(@Nullable Object obj) {
                return true;
            }

            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            public boolean apply(@Nullable Object obj) {
                return false;
            }

            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            public boolean apply(@Nullable Object obj) {
                return obj == null;
            }

            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            public boolean apply(@Nullable Object obj) {
                return obj != null;
            }

            public String toString() {
                return "Predicates.notNull()";
            }
        };

        <T> i<T> withNarrowedType() {
            return this;
        }
    }

    public static <T> i<T> a() {
        return e.IS_NULL.withNarrowedType();
    }

    public static <T> i<T> a(i<T> iVar) {
        return new d(iVar);
    }

    public static <T> i<T> a(@Nullable T t) {
        return t == null ? a() : new c(t);
    }

    public static i<Object> a(Class<?> cls) {
        return new b(cls);
    }

    public static <T> i<T> a(Collection<? extends T> collection) {
        return new a(collection);
    }
}
