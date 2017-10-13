package com.google.a.a;

import java.io.Serializable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public abstract class d<T> {

    static final class a extends d<Object> implements Serializable {
        static final a a = new a();

        a() {
        }

        protected boolean b(Object obj, Object obj2) {
            return obj.equals(obj2);
        }
    }

    protected abstract boolean b(T t, T t2);

    protected d() {
    }

    public final boolean a(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return b(t, t2);
    }

    public static d<Object> a() {
        return a.a;
    }
}
