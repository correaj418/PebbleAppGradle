package com.google.a.f;

import com.google.a.a.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public final class c {
    private static final Map<Class<?>, Class<?>> a;
    private static final Map<Class<?>, Class<?>> b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        a(hashMap, hashMap2, Character.TYPE, Character.class);
        a(hashMap, hashMap2, Double.TYPE, Double.class);
        a(hashMap, hashMap2, Float.TYPE, Float.class);
        a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        a(hashMap, hashMap2, Long.TYPE, Long.class);
        a(hashMap, hashMap2, Short.TYPE, Short.class);
        a(hashMap, hashMap2, Void.TYPE, Void.class);
        a = Collections.unmodifiableMap(hashMap);
        b = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static Set<Class<?>> a() {
        return b.keySet();
    }

    public static <T> Class<T> a(Class<T> cls) {
        h.a((Object) cls);
        Class<T> cls2 = (Class) a.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> b(Class<T> cls) {
        h.a((Object) cls);
        Class<T> cls2 = (Class) b.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
