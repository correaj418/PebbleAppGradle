package com.getpebble.android.bluetooth.b;

public class a {
    private static final byte[] a = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};

    public static String a(byte[] bArr) {
        return a(bArr, 0);
    }

    public static String a(byte[] bArr, int i) {
        if (i == 0) {
            i = bArr.length;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 == 1) {
                stringBuilder.append(String.format("\n%04d | ", new Object[]{Integer.valueOf(i3 * 24)}));
            }
            int i5 = bArr[i4] & 255;
            stringBuilder.append("0x");
            stringBuilder.append((char) a[(i5 >> 4) & 15]).append((char) a[i5 & 15]);
            if (i2 % 4 == 0 && i2 % 8 != 0) {
                stringBuilder.append("  ");
            } else if (i2 % 8 == 0) {
                stringBuilder.append("   ");
            } else {
                stringBuilder.append(" ");
            }
            if (i2 == 23) {
                i3++;
                i2 = 0;
            } else {
                i2++;
            }
        }
        return stringBuilder.toString();
    }
}
