package com.getpebble.android.h;

import java.util.Arrays;

public class b {
    public static <T, U extends T> T[] a(T[] tArr, U[] uArr) {
        Object copyOf = Arrays.copyOf(tArr, tArr.length + uArr.length);
        System.arraycopy(uArr, 0, copyOf, tArr.length, uArr.length);
        return copyOf;
    }
}
