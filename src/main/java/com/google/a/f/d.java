package com.google.a.f;

import javax.annotation.CheckReturnValue;

public final class d {
    @CheckReturnValue
    public static int a(byte b) {
        return b & 255;
    }

    public static byte a(long j) {
        if ((j >> 8) == 0) {
            return (byte) ((int) j);
        }
        throw new IllegalArgumentException("Out of range: " + j);
    }
}
