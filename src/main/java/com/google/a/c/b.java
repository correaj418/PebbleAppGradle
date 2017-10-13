package com.google.a.c;

import com.google.a.a.h;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class b {
    static final byte[] a = new byte[8192];
    private static final OutputStream b = new OutputStream() {
        public void write(int i) {
        }

        public void write(byte[] bArr) {
            h.a((Object) bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            h.a((Object) bArr);
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    };

    private static final class a extends ByteArrayOutputStream {
        private a() {
        }

        void a(byte[] bArr, int i) {
            System.arraycopy(this.buf, 0, bArr, i, this.count);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
        h.a((Object) inputStream);
        h.a((Object) outputStream);
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static byte[] a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    static byte[] a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            int i3 = i - i2;
            int read = inputStream.read(bArr, i3, i2);
            if (read == -1) {
                return Arrays.copyOf(bArr, i3);
            }
            i2 -= read;
        }
        i2 = inputStream.read();
        if (i2 == -1) {
            return bArr;
        }
        OutputStream aVar = new a();
        aVar.write(i2);
        a(inputStream, aVar);
        Object obj = new byte[(bArr.length + aVar.size())];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        aVar.a(obj, bArr.length);
        return obj;
    }
}
