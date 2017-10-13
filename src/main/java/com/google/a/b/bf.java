package com.google.a.b;

public final class bf {
    static final Object[] a = new Object[0];

    public static <T> T[] a(T[] tArr, int i) {
        return bi.a((Object[]) tArr, i);
    }

    static <T> T[] b(T[] tArr, int i) {
        Object a = a((Object[]) tArr, i);
        System.arraycopy(tArr, 0, a, 0, Math.min(tArr.length, i));
        return a;
    }

    static Object[] a(Object... objArr) {
        return c(objArr, objArr.length);
    }

    static Object[] c(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    static Object a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }
}
