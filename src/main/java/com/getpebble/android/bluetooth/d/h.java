package com.getpebble.android.bluetooth.d;

import java.nio.ByteBuffer;

public class h {
    public static byte[] a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        while (wrap.hasRemaining()) {
            int i = wrap.get() & 255;
            int i2 = wrap.get() & 255;
            if (i <= 1) {
                return null;
            }
            byte[] bArr2 = new byte[(i - 1)];
            wrap.get(bArr2);
            if (i2 == 255) {
                return bArr2;
            }
        }
        return null;
    }
}
