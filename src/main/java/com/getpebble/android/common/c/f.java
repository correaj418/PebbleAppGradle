package com.getpebble.android.common.c;

import java.lang.reflect.Field;

public class f {
    public static <T> T a(Class<?> cls, Object obj, String str) {
        T t = null;
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            t = declaredField.get(obj);
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        } catch (IllegalAccessException e2) {
            System.out.println(e2);
        }
        return t;
    }
}
