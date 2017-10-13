package com.google.a.g;

import com.google.a.a.h;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class c {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        h.a((Object) invocationHandler);
        h.a(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
