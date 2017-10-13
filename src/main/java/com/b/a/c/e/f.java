package com.b.a.c.e;

import com.b.a.k;
import com.b.a.m;
import com.b.a.t;
import java.nio.ByteBuffer;

public class f extends t {
    static final /* synthetic */ boolean m = (!f.class.desiredAssertionStatus());
    private byte[] d;
    int l = 2;

    public void a(String str) {
        this.d = ("\r\n--" + str).getBytes();
    }

    public String o() {
        if (this.d == null) {
            return null;
        }
        return new String(this.d, 4, this.d.length - 4);
    }

    public String p() {
        if (m || this.d != null) {
            return new String(this.d, 2, this.d.length - 2);
        }
        throw new AssertionError();
    }

    public String q() {
        if (m || this.d != null) {
            return p() + "--\r\n";
        }
        throw new AssertionError();
    }

    protected void i() {
    }

    protected void g() {
    }

    public void a(m mVar, k kVar) {
        if (this.l > 0) {
            ByteBuffer c = k.c(this.d.length);
            c.put(this.d, 0, this.l);
            c.flip();
            kVar.b(c);
            this.l = 0;
        }
        byte[] bArr = new byte[kVar.d()];
        kVar.a(bArr);
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            if (this.l >= 0) {
                if (bArr[i] == this.d[this.l]) {
                    this.l++;
                    if (this.l == this.d.length) {
                        this.l = -1;
                    }
                } else if (this.l > 0) {
                    i -= this.l;
                    this.l = 0;
                }
            } else if (this.l == -1) {
                if (bArr[i] == (byte) 13) {
                    this.l = -4;
                    int length = (i - i2) - this.d.length;
                    if (!(i2 == 0 && length == 0)) {
                        r4 = k.c(length).put(bArr, i2, length);
                        r4.flip();
                        r5 = new k();
                        r5.a(r4);
                        super.a(this, r5);
                    }
                    i();
                } else if (bArr[i] == (byte) 45) {
                    this.l = -2;
                } else {
                    b(new h("Invalid multipart/form-data. Expected \r or -"));
                    return;
                }
            } else if (this.l == -2) {
                if (bArr[i] == (byte) 45) {
                    this.l = -3;
                } else {
                    b(new h("Invalid multipart/form-data. Expected -"));
                    return;
                }
            } else if (this.l == -3) {
                if (bArr[i] == (byte) 13) {
                    this.l = -4;
                    r4 = k.c(((i - i2) - this.d.length) - 2).put(bArr, i2, ((i - i2) - this.d.length) - 2);
                    r4.flip();
                    r5 = new k();
                    r5.a(r4);
                    super.a(this, r5);
                    g();
                } else {
                    b(new h("Invalid multipart/form-data. Expected \r"));
                    return;
                }
            } else if (this.l == -4) {
                if (bArr[i] == (byte) 10) {
                    i2 = i + 1;
                    this.l = 0;
                } else {
                    b(new h("Invalid multipart/form-data. Expected \n"));
                }
            } else if (m) {
                b(new h("Invalid multipart/form-data. Unknown state?"));
            } else {
                throw new AssertionError();
            }
            i++;
        }
        if (i2 < bArr.length) {
            i = Math.max(this.l, 0);
            c = k.c((bArr.length - i2) - i).put(bArr, i2, (bArr.length - i2) - i);
            c.flip();
            k kVar2 = new k();
            kVar2.a(c);
            super.a(this, kVar2);
        }
    }
}
