package com.google.a.g;

import com.google.a.b.bt;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class h {
    private final Set<Type> a = bt.a();

    h() {
    }

    public final void a(Type... typeArr) {
        for (Object obj : typeArr) {
            if (obj != null && this.a.add(obj)) {
                try {
                    if (obj instanceof TypeVariable) {
                        a((TypeVariable) obj);
                    } else if (obj instanceof WildcardType) {
                        a((WildcardType) obj);
                    } else if (obj instanceof ParameterizedType) {
                        a((ParameterizedType) obj);
                    } else if (obj instanceof Class) {
                        a((Class) obj);
                    } else if (obj instanceof GenericArrayType) {
                        a((GenericArrayType) obj);
                    } else {
                        throw new AssertionError("Unknown type: " + obj);
                    }
                } catch (Throwable th) {
                    this.a.remove(obj);
                }
            }
        }
    }

    void a(Class<?> cls) {
    }

    void a(GenericArrayType genericArrayType) {
    }

    void a(ParameterizedType parameterizedType) {
    }

    void a(TypeVariable<?> typeVariable) {
    }

    void a(WildcardType wildcardType) {
    }
}
