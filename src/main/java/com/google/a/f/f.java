package com.google.a.f;

import com.google.a.a.h;
import javax.annotation.CheckReturnValue;

public final class f {
    static int a(int i) {
        return Integer.MIN_VALUE ^ i;
    }

    @CheckReturnValue
    public static int a(int i, int i2) {
        return a.a(a(i), a(i2));
    }

    @CheckReturnValue
    public static long b(int i) {
        return ((long) i) & 4294967295L;
    }

    @CheckReturnValue
    public static int b(int i, int i2) {
        return (int) (b(i) / b(i2));
    }

    public static int a(String str, int i) {
        h.a((Object) str);
        long parseLong = Long.parseLong(str, i);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    @CheckReturnValue
    public static String c(int i, int i2) {
        return Long.toString(((long) i) & 4294967295L, i2);
    }
}
