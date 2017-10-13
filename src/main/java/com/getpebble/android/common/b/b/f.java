package com.getpebble.android.common.b.b;

import java.io.EOFException;
import java.io.InputStream;

public class f {

    public static class a {
        int a = 0;
        private final int b;
        private final InputStream c;

        public a(int i, InputStream inputStream) {
            this.b = i;
            this.c = inputStream;
        }

        public int a(byte[] bArr) {
            int i = this.b - this.a;
            if (i < 1) {
                return -1;
            }
            int min = Math.min(bArr.length, i);
            i = this.c.read(bArr, 0, min);
            if (i == -1) {
                throw new EOFException("Hit end of file when reading " + min + " bytes at position " + this.a);
            }
            this.a += i;
            return i;
        }
    }
}
