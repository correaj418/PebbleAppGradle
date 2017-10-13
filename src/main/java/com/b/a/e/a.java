package com.b.a.e;

import com.b.a.k;
import java.io.InputStream;

public class a extends InputStream {
    k a;

    public a(k kVar) {
        this.a = kVar;
    }

    public int read() {
        if (this.a.d() <= 0) {
            return -1;
        }
        return this.a.i();
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.a.d() <= 0) {
            return -1;
        }
        int min = Math.min(i2, this.a.d());
        this.a.a(bArr, i, min);
        return min;
    }
}
