package com.b.a.c;

import android.util.Log;
import com.b.a.a.d;
import com.b.a.k;
import com.b.a.m;
import com.b.a.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

abstract class r {
    private static final List<Integer> v = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10)});
    private static final List<Integer> w = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2)});
    d a = new d(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void a(m mVar, k kVar) {
            try {
                this.a.a(kVar.i());
            } catch (Exception e) {
                this.a.a(e);
                e.printStackTrace();
            }
            this.a.a();
        }
    };
    d b = new d(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void a(m mVar, k kVar) {
            this.a.b(kVar.i());
            this.a.a();
        }
    };
    d c = new d(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void a(m mVar, k kVar) {
            byte[] bArr = new byte[this.a.m];
            kVar.a(bArr);
            try {
                this.a.e(bArr);
            } catch (Exception e) {
                this.a.a(e);
                e.printStackTrace();
            }
            this.a.a();
        }
    };
    d d = new d(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void a(m mVar, k kVar) {
            this.a.p = new byte[4];
            kVar.a(this.a.p);
            this.a.h = 4;
            this.a.a();
        }
    };
    d e = new d(this) {
        static final /* synthetic */ boolean a = (!r.class.desiredAssertionStatus());
        final /* synthetic */ r b;

        {
            this.b = r1;
        }

        public void a(m mVar, k kVar) {
            if (a || kVar.d() == this.b.n) {
                this.b.q = new byte[this.b.n];
                kVar.a(this.b.q);
                try {
                    this.b.b();
                } catch (Exception e) {
                    this.b.a(e);
                    e.printStackTrace();
                }
                this.b.h = 0;
                this.b.a();
                return;
            }
            throw new AssertionError();
        }
    };
    private boolean f = true;
    private boolean g = false;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private byte[] p = new byte[0];
    private byte[] q = new byte[0];
    private boolean r = false;
    private ByteArrayOutputStream s = new ByteArrayOutputStream();
    private Inflater t = new Inflater(true);
    private byte[] u = new byte[4096];
    private o x = new o();

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    protected abstract void a(int i, String str);

    protected abstract void a(Exception exception);

    protected abstract void a(String str);

    protected abstract void b(String str);

    protected abstract void b(byte[] bArr);

    protected abstract void c(String str);

    protected abstract void c(byte[] bArr);

    private static byte[] a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length != 0) {
            for (int i2 = 0; i2 < bArr.length - i; i2++) {
                bArr[i + i2] = (byte) (bArr[i + i2] ^ bArr2[i2 % 4]);
            }
        }
        return bArr;
    }

    private byte[] d(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.t.setInput(bArr);
        while (!this.t.needsInput()) {
            byteArrayOutputStream.write(this.u, 0, this.t.inflate(this.u));
        }
        this.t.setInput(new byte[]{(byte) 0, (byte) 0, (byte) -1, (byte) -1});
        while (!this.t.needsInput()) {
            byteArrayOutputStream.write(this.u, 0, this.t.inflate(this.u));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b(boolean z) {
        this.g = z;
    }

    void a() {
        switch (this.h) {
            case 0:
                this.x.a(1, this.a);
                return;
            case 1:
                this.x.a(1, this.b);
                return;
            case 2:
                this.x.a(this.m, this.c);
                return;
            case 3:
                this.x.a(4, this.d);
                return;
            case 4:
                this.x.a(this.n, this.e);
                return;
            default:
                return;
        }
    }

    public r(m mVar) {
        mVar.a(this.x);
        a();
    }

    private void a(byte b) {
        boolean z = (b & 64) == 64;
        int i;
        if ((b & 32) == 32) {
            i = 1;
        } else {
            i = 0;
        }
        int i2;
        if ((b & 16) == 16) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if ((this.g || !z) && r3 == 0 && r0 == 0) {
            this.i = (b & 128) == 128;
            this.l = b & 15;
            this.k = z;
            this.p = new byte[0];
            this.q = new byte[0];
            if (!v.contains(Integer.valueOf(this.l))) {
                throw new a("Bad opcode");
            } else if (w.contains(Integer.valueOf(this.l)) || this.i) {
                this.h = 1;
                return;
            } else {
                throw new a("Expected non-final packet");
            }
        }
        throw new a("RSV not zero");
    }

    private void b(byte b) {
        this.j = (b & 128) == 128;
        this.n = b & 127;
        if (this.n < 0 || this.n > 125) {
            this.m = this.n == 126 ? 2 : 8;
            this.h = 2;
            return;
        }
        this.h = this.j ? 3 : 4;
    }

    private void e(byte[] bArr) {
        this.n = g(bArr);
        this.h = this.j ? 3 : 4;
    }

    public byte[] a(byte[] bArr) {
        return a(2, bArr, -1);
    }

    private byte[] a(int i, byte[] bArr, int i2) {
        return a(i, bArr, i2, 0, bArr.length);
    }

    private byte[] a(int i, byte[] bArr, int i2, int i3, int i4) {
        if (this.r) {
            return null;
        }
        int i5 = i2 > 0 ? 2 : 0;
        int i6 = (i4 + i5) - i3;
        int i7 = i6 <= 125 ? 2 : i6 <= 65535 ? 4 : 10;
        int i8 = i7 + (this.f ? 4 : 0);
        int i9 = this.f ? 128 : 0;
        byte[] bArr2 = new byte[(i6 + i8)];
        bArr2[0] = (byte) (((byte) i) | -128);
        if (i6 <= 125) {
            bArr2[1] = (byte) (i9 | i6);
        } else if (i6 <= 65535) {
            bArr2[1] = (byte) (i9 | 126);
            bArr2[2] = (byte) (i6 / 256);
            bArr2[3] = (byte) (i6 & 255);
        } else {
            bArr2[1] = (byte) (i9 | 127);
            bArr2[2] = (byte) ((int) ((((long) i6) / 72057594037927936L) & 255));
            bArr2[3] = (byte) ((int) ((((long) i6) / 281474976710656L) & 255));
            bArr2[4] = (byte) ((int) ((((long) i6) / 1099511627776L) & 255));
            bArr2[5] = (byte) ((int) ((((long) i6) / 4294967296L) & 255));
            bArr2[6] = (byte) ((int) ((((long) i6) / 16777216) & 255));
            bArr2[7] = (byte) ((int) ((((long) i6) / 65536) & 255));
            bArr2[8] = (byte) ((int) ((((long) i6) / 256) & 255));
            bArr2[9] = (byte) (i6 & 255);
        }
        if (i2 > 0) {
            bArr2[i8] = (byte) ((i2 / 256) & 255);
            bArr2[i8 + 1] = (byte) (i2 & 255);
        }
        System.arraycopy(bArr, i3, bArr2, i8 + i5, i4 - i3);
        if (this.f) {
            byte[] bArr3 = new byte[]{(byte) ((int) Math.floor(Math.random() * 256.0d)), (byte) ((int) Math.floor(Math.random() * 256.0d)), (byte) ((int) Math.floor(Math.random() * 256.0d)), (byte) ((int) Math.floor(Math.random() * 256.0d))};
            System.arraycopy(bArr3, 0, bArr2, i7, bArr3.length);
            a(bArr2, bArr3, i8);
        }
        return bArr2;
    }

    private void b() {
        int i = 0;
        byte[] a = a(this.q, this.p, 0);
        if (this.k) {
            try {
                a = d(a);
            } catch (DataFormatException e) {
                throw new IOException("Invalid deflated data");
            }
        }
        int i2 = this.l;
        if (i2 == 0) {
            if (this.o == 0) {
                throw new a("Mode was not set.");
            }
            this.s.write(a);
            if (this.i) {
                a = this.s.toByteArray();
                if (this.o == 1) {
                    a(f(a));
                } else {
                    b(a);
                }
                c();
            }
        } else if (i2 == 1) {
            if (this.i) {
                a(f(a));
                return;
            }
            this.o = 1;
            this.s.write(a);
        } else if (i2 == 2) {
            if (this.i) {
                b(a);
                return;
            }
            this.o = 2;
            this.s.write(a);
        } else if (i2 == 8) {
            if (a.length >= 2) {
                i = ((a[0] & 255) * 256) + (a[1] & 255);
            }
            a(i, a.length > 2 ? f(a(a, 2)) : null);
        } else if (i2 == 9) {
            if (a.length > 125) {
                throw new a("Ping payload too large");
            }
            String f = f(a);
            c(a(10, a, -1));
            c(f);
        } else if (i2 == 10) {
            b(f(a));
        }
    }

    private void c() {
        this.o = 0;
        this.s.reset();
    }

    private String f(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private int g(byte[] bArr) {
        long a = a(bArr, 0, bArr.length);
        if (a >= 0 && a <= 2147483647L) {
            return (int) a;
        }
        throw new a("Bad integer: " + a);
    }

    private byte[] a(byte[] bArr, int i) {
        Object obj = new byte[(bArr.length - i)];
        System.arraycopy(bArr, i, obj, 0, bArr.length - i);
        return obj;
    }

    protected void finalize() {
        Inflater inflater = this.t;
        if (inflater != null) {
            try {
                inflater.end();
            } catch (Throwable e) {
                Log.e("HybiParser", "inflater.end failed", e);
            }
        }
        super.finalize();
    }

    private static long a(byte[] bArr, int i, int i2) {
        if (bArr.length < i2) {
            throw new IllegalArgumentException("length must be less than or equal to b.length");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j += (long) ((bArr[i3 + i] & 255) << (((i2 - 1) - i3) * 8));
        }
        return j;
    }
}
