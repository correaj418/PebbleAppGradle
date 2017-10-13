package com.google.a.f;

import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class a {
    public static int a(long j) {
        int i = (int) j;
        if (((long) i) == j) {
            return i;
        }
        throw new IllegalArgumentException("Out of range: " + j);
    }

    public static int b(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    @CheckForNull
    @Nullable
    public static Integer a(String str) {
        return a(str, 10);
    }

    @CheckForNull
    @Nullable
    public static Integer a(String str, int i) {
        Long a = b.a(str, i);
        if (a == null || a.longValue() != ((long) a.intValue())) {
            return null;
        }
        return Integer.valueOf(a.intValue());
    }
}
