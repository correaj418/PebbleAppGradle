package com.b.b.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class a implements Cloneable {
    private int A;
    private byte[] B;
    private int C;
    private int D;
    private int E;
    private boolean F;
    private int G;
    private int H;
    private short[] I;
    private byte[] J;
    private byte[] K;
    private byte[] L;
    private byte[] M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    public int a;
    public int b;
    b c;
    b d;
    int[] e;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private int[] j;
    private int[] k;
    private int[] l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public a a() {
        try {
            a aVar = (a) clone();
            this.B = new byte[256];
            this.I = null;
            this.J = null;
            this.K = null;
            this.L = null;
            this.e = null;
            return aVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.O;
    }

    public b e() {
        return this.c;
    }

    public a(ByteBuffer byteBuffer) {
        this(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public a(byte[] bArr, int i, int i2) {
        this.i = 1;
        this.B = new byte[256];
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = 0;
        this.M = null;
        this.R = Integer.MAX_VALUE;
        this.M = bArr;
        this.N = i;
        this.O = i2;
        f();
    }

    public void f() {
        this.P = 0;
        this.f = 0;
        this.j = null;
        this.k = null;
        o();
    }

    public synchronized b g() {
        b bVar = null;
        synchronized (this) {
            while (!k() && this.f == 0) {
                switch (l()) {
                    case 0:
                        break;
                    case 33:
                        switch (l()) {
                            case 249:
                                n();
                                break;
                            case 255:
                                m();
                                String str = "";
                                for (int i = 0; i < 11; i++) {
                                    str = str + ((char) this.B[i]);
                                }
                                if (!str.equals("NETSCAPE2.0")) {
                                    t();
                                    break;
                                }
                                r();
                                break;
                            default:
                                t();
                                break;
                        }
                    case 44:
                        bVar = p();
                        this.c = bVar;
                        break;
                    case 59:
                        this.f = -1;
                        break;
                    default:
                        this.f = 1;
                        break;
                }
            }
            this.f = 1;
        }
        return bVar;
    }

    public int h() {
        return this.f;
    }

    private Bitmap i() {
        int i;
        int i2 = 0;
        if (this.E == 2) {
            if (this.e == null) {
                this.e = new int[(this.a * this.b)];
            }
            if (this.F) {
                i = 0;
            } else {
                i = this.o;
            }
            Arrays.fill(this.e, i);
        } else if (this.e == null) {
            this.e = new int[(this.a * this.b)];
            if (this.d != null) {
                this.d.a.getPixels(this.e, 0, this.a, 0, 0, this.a, this.b);
            } else {
                Arrays.fill(this.e, 0);
            }
        } else if (this.E == 3) {
            if (this.d != null) {
                this.d.a.getPixels(this.e, 0, this.a, 0, 0, this.a, this.b);
            } else {
                Arrays.fill(this.e, 0);
            }
        }
        int i3 = 8;
        int i4 = 1;
        i = 0;
        while (i2 < this.w) {
            int i5;
            if (this.r) {
                if (i >= this.w) {
                    i4++;
                    switch (i4) {
                        case 2:
                            i = 4;
                            break;
                        case 3:
                            i = 2;
                            i3 = 4;
                            break;
                        case 4:
                            i = 1;
                            i3 = 2;
                            break;
                    }
                }
                int i6 = i;
                i += i3;
                i5 = i6;
            } else {
                i5 = i2;
            }
            i5 += this.u;
            if (i5 < this.b) {
                int i7 = this.a * i5;
                int i8 = i7 + this.t;
                i5 = this.v + i8;
                if (this.a + i7 < i5) {
                    i5 = this.a + i7;
                }
                i7 = this.v * i2;
                int i9 = i8;
                while (i9 < i5 && i7 < this.R) {
                    i8 = i7 + 1;
                    i7 = this.L[i7] & 255;
                    if (!this.F || i7 != this.H) {
                        this.e[i9] = this.l[i7];
                    }
                    i9++;
                    i7 = i8;
                }
            }
            i2++;
        }
        return Bitmap.createBitmap(this.e, this.a, this.b, Config.ARGB_4444);
    }

    private void j() {
        int i;
        int i2 = this.v * this.w;
        if (this.L == null || this.L.length < i2) {
            this.L = new byte[i2];
        }
        if (this.I == null) {
            this.I = new short[4096];
        }
        if (this.J == null) {
            this.J = new byte[4096];
        }
        if (this.K == null) {
            this.K = new byte[4097];
        }
        int l = l();
        int i3 = 1 << l;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = l + 1;
        int i7 = (1 << i6) - 1;
        for (i = 0; i < i3; i++) {
            this.I[i] = (short) 0;
            this.J[i] = (byte) i;
        }
        i = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = -1;
        int i15 = 0;
        while (i12 < i2) {
            int i16;
            int i17;
            if (i9 == 0) {
                if (i13 >= i6) {
                    i16 = i11 & i7;
                    i11 >>= i6;
                    i13 -= i6;
                    if (i16 <= i5 && i16 != i4) {
                        if (i16 != i3) {
                            if (i14 != -1) {
                                int i18;
                                if (i16 == i5) {
                                    i18 = i9 + 1;
                                    this.K[i9] = (byte) i10;
                                    i10 = i14;
                                } else {
                                    i18 = i9;
                                    i10 = i16;
                                }
                                while (i10 > i3) {
                                    i9 = i18 + 1;
                                    this.K[i18] = this.J[i10];
                                    i10 = this.I[i10];
                                    i18 = i9;
                                }
                                i10 = this.J[i10] & 255;
                                if (i5 >= 4096) {
                                    break;
                                }
                                i9 = i18 + 1;
                                this.K[i18] = (byte) i10;
                                this.I[i5] = (short) i14;
                                this.J[i5] = (byte) i10;
                                i14 = i5 + 1;
                                if ((i14 & i7) == 0 && i14 < 4096) {
                                    i6++;
                                    i7 += i14;
                                }
                                i17 = i9;
                                i9 = i11;
                                i11 = i16;
                                i16 = i7;
                                i7 = i10;
                                i10 = i13;
                                i13 = i6;
                                i6 = i17;
                            } else {
                                i10 = i9 + 1;
                                this.K[i9] = this.J[i16];
                                i9 = i10;
                                i14 = i16;
                                i10 = i16;
                            }
                        } else {
                            i6 = l + 1;
                            i7 = (1 << i6) - 1;
                            i5 = i3 + 2;
                            i14 = -1;
                        }
                    } else {
                        break;
                    }
                }
                if (i15 == 0) {
                    i15 = m();
                    if (i15 <= 0) {
                        break;
                    }
                    i = 0;
                }
                i11 += (this.B[i] & 255) << i13;
                i13 += 8;
                i++;
                i15--;
            } else {
                i16 = i7;
                i7 = i10;
                i10 = i13;
                i13 = i6;
                i6 = i9;
                i9 = i11;
                i11 = i14;
                i14 = i5;
            }
            i5 = i6 - 1;
            i6 = i8 + 1;
            this.L[i8] = this.K[i5];
            i8 = i6;
            i12++;
            i6 = i13;
            i13 = i10;
            i10 = i7;
            i7 = i16;
            i17 = i11;
            i11 = i9;
            i9 = i5;
            i5 = i14;
            i14 = i17;
        }
        this.R = i8;
    }

    private boolean k() {
        return this.f != 0;
    }

    private int l() {
        if (this.P >= this.O) {
            return 0;
        }
        byte[] bArr = this.M;
        int i = this.N;
        int i2 = this.P;
        this.P = i2 + 1;
        return bArr[i + i2] & 255;
    }

    private int a(byte[] bArr, int i, int i2) {
        if (this.P >= this.O) {
            return -1;
        }
        int min = Math.min(this.O - this.P, i2);
        System.arraycopy(this.M, this.N + this.P, bArr, i, min);
        this.P += min;
        return min;
    }

    private int a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private int m() {
        this.C = l();
        int i = 0;
        if (this.C > 0) {
            while (i < this.C) {
                try {
                    int a = a(this.B, i, this.C - i);
                    if (a == -1) {
                        break;
                    }
                    i += a;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.C) {
                this.f = 1;
            }
        }
        return i;
    }

    private int[] a(int i) {
        int a;
        int i2 = 0;
        int i3 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i3];
        try {
            a = a(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            a = 0;
        }
        if (a < i3) {
            this.f = 1;
        } else {
            iArr = new int[256];
            a = 0;
            while (a < i) {
                i3 = i2 + 1;
                int i4 = bArr[i2] & 255;
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                i2 = i5 + 1;
                i3 = a + 1;
                iArr[a] = (((i4 << 16) | -16777216) | (i6 << 8)) | (bArr[i5] & 255);
                a = i3;
            }
        }
        return iArr;
    }

    private void n() {
        boolean z = true;
        l();
        int l = l();
        this.D = (l & 28) >> 2;
        if (this.D == 0) {
            this.D = 1;
        }
        if ((l & 1) == 0) {
            z = false;
        }
        this.F = z;
        this.G = s() * 10;
        this.H = l();
        l();
    }

    private void o() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) l());
        }
        if (str.startsWith("GIF")) {
            q();
            if (this.g && !k()) {
                this.j = a(this.h);
                this.n = this.j[this.m];
                return;
            }
            return;
        }
        this.f = 1;
    }

    private b p() {
        boolean z;
        this.t = s();
        this.u = s();
        this.v = s();
        this.w = s();
        int l = l();
        this.q = (l & 128) != 0;
        if ((l & 64) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.r = z;
        this.s = 2 << (l & 7);
        if (this.q) {
            this.k = a(this.s);
            this.l = this.k;
        } else {
            this.l = this.j;
            if (this.m == this.H) {
                this.n = 0;
            }
        }
        if (this.l == null) {
            this.f = 1;
        }
        if (k()) {
            return null;
        }
        j();
        t();
        if (k()) {
            return null;
        }
        this.Q++;
        b bVar = new b(i(), this.G);
        a(bVar);
        return bVar;
    }

    private void q() {
        this.a = s();
        this.b = s();
        int l = l();
        this.g = (l & 128) != 0;
        this.h = 2 << (l & 7);
        this.m = l();
        this.p = l();
    }

    private void r() {
        do {
            m();
            if (this.B[0] == (byte) 1) {
                this.i = (this.B[1] & 255) | ((this.B[2] & 255) << 8);
            }
            if (this.C <= 0) {
                return;
            }
        } while (!k());
    }

    private int s() {
        return l() | (l() << 8);
    }

    private void a(b bVar) {
        switch (this.D) {
            case 0:
                this.d = bVar;
                break;
            case 1:
                this.d = bVar;
                break;
            case 2:
                this.d = null;
                break;
            case 3:
                break;
            default:
                Log.w("Ion", "Unknown gif dispose code: " + this.E);
                break;
        }
        this.E = this.D;
        this.x = this.t;
        this.y = this.u;
        this.z = this.v;
        this.A = this.w;
        this.o = this.n;
        this.D = 0;
        this.F = false;
        this.G = 0;
        this.k = null;
        this.R = Integer.MAX_VALUE;
    }

    private void t() {
        do {
            m();
            if (this.C <= 0) {
                return;
            }
        } while (!k());
    }
}
