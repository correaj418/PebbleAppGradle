package com.google.a.b;

import javax.annotation.Nullable;

final class w {
    private static int a = 1073741824;

    static int a(int i) {
        return 461845907 * Integer.rotateLeft(-862048943 * i, 15);
    }

    static int a(@Nullable Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }

    static int a(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (((double) highestOneBit) * d))) {
            return highestOneBit;
        }
        highestOneBit <<= 1;
        if (highestOneBit > 0) {
            return highestOneBit;
        }
        return a;
    }

    static boolean a(int i, int i2, double d) {
        return ((double) i) > ((double) i2) * d && i2 < a;
    }
}
