package com.google.a.d;

import java.math.RoundingMode;

public final class a {
    static final byte[] a = new byte[]{(byte) 9, (byte) 9, (byte) 9, (byte) 8, (byte) 8, (byte) 8, (byte) 7, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 4, (byte) 4, (byte) 4, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    static final int[] b = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    static final int[] c = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    static int[] d = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    private static final int[] e = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[RoundingMode.values().length];

        static {
            try {
                a[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r7, int r8, java.math.RoundingMode r9) {
        /*
        r0 = 1;
        r1 = 0;
        com.google.a.a.h.a(r9);
        if (r8 != 0) goto L_0x000f;
    L_0x0007:
        r0 = new java.lang.ArithmeticException;
        r1 = "/ by zero";
        r0.<init>(r1);
        throw r0;
    L_0x000f:
        r2 = r7 / r8;
        r3 = r8 * r2;
        r3 = r7 - r3;
        if (r3 != 0) goto L_0x0018;
    L_0x0017:
        return r2;
    L_0x0018:
        r4 = r7 ^ r8;
        r4 = r4 >> 31;
        r5 = r4 | 1;
        r4 = com.google.a.d.a.AnonymousClass1.a;
        r6 = r9.ordinal();
        r4 = r4[r6];
        switch(r4) {
            case 1: goto L_0x002f;
            case 2: goto L_0x0034;
            case 3: goto L_0x0041;
            case 4: goto L_0x0035;
            case 5: goto L_0x003d;
            case 6: goto L_0x0045;
            case 7: goto L_0x0045;
            case 8: goto L_0x0045;
            default: goto L_0x0029;
        };
    L_0x0029:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x002f:
        if (r3 != 0) goto L_0x003b;
    L_0x0031:
        com.google.a.d.b.a(r0);
    L_0x0034:
        r0 = r1;
    L_0x0035:
        if (r0 == 0) goto L_0x006d;
    L_0x0037:
        r0 = r2 + r5;
    L_0x0039:
        r2 = r0;
        goto L_0x0017;
    L_0x003b:
        r0 = r1;
        goto L_0x0031;
    L_0x003d:
        if (r5 > 0) goto L_0x0035;
    L_0x003f:
        r0 = r1;
        goto L_0x0035;
    L_0x0041:
        if (r5 < 0) goto L_0x0035;
    L_0x0043:
        r0 = r1;
        goto L_0x0035;
    L_0x0045:
        r3 = java.lang.Math.abs(r3);
        r4 = java.lang.Math.abs(r8);
        r4 = r4 - r3;
        r3 = r3 - r4;
        if (r3 != 0) goto L_0x0069;
    L_0x0051:
        r3 = java.math.RoundingMode.HALF_UP;
        if (r9 == r3) goto L_0x0062;
    L_0x0055:
        r3 = java.math.RoundingMode.HALF_EVEN;
        if (r9 != r3) goto L_0x0065;
    L_0x0059:
        r4 = r0;
    L_0x005a:
        r3 = r2 & 1;
        if (r3 == 0) goto L_0x0067;
    L_0x005e:
        r3 = r0;
    L_0x005f:
        r3 = r3 & r4;
        if (r3 == 0) goto L_0x0063;
    L_0x0062:
        r1 = r0;
    L_0x0063:
        r0 = r1;
        goto L_0x0035;
    L_0x0065:
        r4 = r1;
        goto L_0x005a;
    L_0x0067:
        r3 = r1;
        goto L_0x005f;
    L_0x0069:
        if (r3 > 0) goto L_0x0035;
    L_0x006b:
        r0 = r1;
        goto L_0x0035;
    L_0x006d:
        r0 = r2;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.a(int, int, java.math.RoundingMode):int");
    }
}
