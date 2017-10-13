package com.google.a.g;

import com.google.a.a.h;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.Nullable;

public abstract class e<T> extends d<T> {
    final TypeVariable<?> a;

    protected e() {
        Type capture = capture();
        h.a(capture instanceof TypeVariable, "%s should be a type variable.", capture);
        this.a = (TypeVariable) capture;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        return this.a.equals(((e) obj).a);
    }

    public String toString() {
        return this.a.toString();
    }
}
