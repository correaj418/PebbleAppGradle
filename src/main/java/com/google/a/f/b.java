package com.google.a.f;

import com.google.a.a.h;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class b {
    private static final byte[] a = a();

    private static byte[] a() {
        int i = 0;
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 0; i2 <= 9; i2++) {
            bArr[i2 + 48] = (byte) i2;
        }
        while (i <= 26) {
            bArr[i + 65] = (byte) (i + 10);
            bArr[i + 97] = (byte) (i + 10);
            i++;
        }
        return bArr;
    }

    private static int a(char c) {
        return c < '' ? a[c] : -1;
    }

    @CheckForNull
    @Nullable
    public static Long a(String str, int i) {
        if (((String) h.a((Object) str)).isEmpty()) {
            return null;
        }
        if (i < 2 || i > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i);
        }
        int i2;
        int i3;
        if (str.charAt(0) == '-') {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 == str.length()) {
            return null;
        }
        int i4 = i3 + 1;
        i3 = a(str.charAt(i3));
        if (i3 < 0 || i3 >= i) {
            return null;
        }
        long j = (long) (-i3);
        long j2 = Long.MIN_VALUE / ((long) i);
        while (i4 < str.length()) {
            int i5 = i4 + 1;
            i4 = a(str.charAt(i4));
            if (i4 < 0 || i4 >= i || j < j2) {
                return null;
            }
            j *= (long) i;
            if (j < ((long) i4) - Long.MIN_VALUE) {
                return null;
            }
            j -= (long) i4;
            i4 = i5;
        }
        if (i2 != 0) {
            return Long.valueOf(j);
        }
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j);
    }
}
