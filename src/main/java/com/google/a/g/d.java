package com.google.a.g;

import com.google.a.a.h;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class d<T> {
    d() {
    }

    final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        h.a(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
