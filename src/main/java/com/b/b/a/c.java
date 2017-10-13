package com.b.b.a;

import android.util.Log;

public class c {
    public static int a(byte[] bArr, int i, int i2) {
        boolean z = true;
        if (bArr == null) {
            return 0;
        }
        int i3;
        int a;
        int i4 = i + i2;
        int i5 = i;
        while (i5 + 3 < i4) {
            i3 = i5 + 1;
            if ((bArr[i5] & 255) == 255) {
                i5 = bArr[i3] & 255;
                if (i5 == 255) {
                    i5 = i3;
                } else {
                    i3++;
                    if (i5 == 216) {
                        i5 = i3;
                    } else if (i5 == 1) {
                        i5 = i3;
                    } else if (i5 != 217) {
                        if (i5 != 218) {
                            a = a(bArr, i3, 2, false);
                            if (a >= 2 && i3 + a <= i4) {
                                if (i5 == 225 && a >= 8 && a(bArr, i3 + 2, 4, false) == 1165519206 && a(bArr, i3 + 6, 2, false) == 0) {
                                    i5 = i3 + 8;
                                    i3 = a - 8;
                                    break;
                                }
                                i5 = i3 + a;
                            } else {
                                Log.e("CameraExif", "Invalid length");
                                return 0;
                            }
                        }
                        i5 = i3;
                        i3 = 0;
                        break;
                    }
                }
            }
            i5 = i3;
            i3 = 0;
        }
        i3 = 0;
        if (i3 <= 8) {
            return 0;
        }
        i4 = a(bArr, i5, 4, false);
        if (i4 == 1229531648 || i4 == 1296891946) {
            if (i4 != 1229531648) {
                z = false;
            }
            a = a(bArr, i5 + 4, 4, z) + 2;
            if (a < 10 || a > i3) {
                Log.e("CameraExif", "Invalid offset");
                return 0;
            }
            i4 = i5 + a;
            i5 = i3 - a;
            i3 = a(bArr, i4 - 2, 2, z);
            a = i4;
            i4 = i5;
            while (true) {
                i5 = i3 - 1;
                if (i3 <= 0 || i4 < 12) {
                    return 0;
                }
                if (a(bArr, a, 2, z) == 274) {
                    break;
                }
                a += 12;
                i4 -= 12;
                i3 = i5;
            }
            switch (a(bArr, a + 8, 2, z)) {
                case 1:
                    return 0;
                case 3:
                    return 180;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    Log.i("CameraExif", "Unsupported orientation");
                    return 0;
            }
        }
        Log.e("CameraExif", "Invalid byte order");
        return 0;
    }

    private static int a(byte[] bArr, int i, int i2, boolean z) {
        int i3 = 1;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (i4 << 8) | (bArr[i] & 255);
            i += i3;
            i2 = i5;
        }
    }
}
