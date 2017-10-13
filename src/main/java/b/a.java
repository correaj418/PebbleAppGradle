package b;

import java.io.EOFException;
import java.nio.charset.Charset;

public final class a implements b, c, Cloneable {
    private static final byte[] c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    h a;
    long b;

    public /* synthetic */ b b(d dVar) {
        return a(dVar);
    }

    public /* synthetic */ b b(String str) {
        return a(str);
    }

    public /* synthetic */ Object clone() {
        return m();
    }

    public /* synthetic */ b f(int i) {
        return c(i);
    }

    public /* synthetic */ b g(int i) {
        return a(i);
    }

    public /* synthetic */ b i(long j) {
        return h(j);
    }

    public long a() {
        return this.b;
    }

    public b b() {
        return this;
    }

    public boolean c() {
        return this.b == 0;
    }

    public void a(long j) {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public boolean b(long j) {
        return this.b >= j;
    }

    public long d() {
        long j = this.b;
        if (j == 0) {
            return 0;
        }
        h hVar = this.a.g;
        if (hVar.c >= 8192 || !hVar.e) {
            return j;
        }
        return j - ((long) (hVar.c - hVar.b));
    }

    public byte e() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        h hVar = this.a;
        int i = hVar.b;
        int i2 = hVar.c;
        int i3 = i + 1;
        byte b = hVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = hVar.a();
            i.a(hVar);
        } else {
            hVar.b = i3;
        }
        return b;
    }

    public int f() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        h hVar = this.a;
        int i = hVar.b;
        int i2 = hVar.c;
        if (i2 - i < 4) {
            return ((((e() & 255) << 24) | ((e() & 255) << 16)) | ((e() & 255) << 8)) | (e() & 255);
        }
        byte[] bArr = hVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.b -= 4;
        if (i4 == i2) {
            this.a = hVar.a();
            i.a(hVar);
            return i;
        }
        hVar.b = i4;
        return i;
    }

    public long g() {
        if (this.b < 8) {
            throw new IllegalStateException("size < 8: " + this.b);
        }
        h hVar = this.a;
        int i = hVar.b;
        int i2 = hVar.c;
        if (i2 - i < 8) {
            return ((((long) f()) & 4294967295L) << 32) | (((long) f()) & 4294967295L);
        }
        byte[] bArr = hVar.a;
        int i3 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        i = i3 + 1;
        long j2 = ((((long) bArr[i3]) & 255) << 48) | j;
        int i4 = i + 1;
        i = i4 + 1;
        j2 = (j2 | ((((long) bArr[i]) & 255) << 40)) | ((((long) bArr[i4]) & 255) << 32);
        i4 = i + 1;
        i = i4 + 1;
        j2 = (j2 | ((((long) bArr[i]) & 255) << 24)) | ((((long) bArr[i4]) & 255) << 16);
        i4 = i + 1;
        int i5 = i4 + 1;
        long j3 = (((long) bArr[i4]) & 255) | (j2 | ((((long) bArr[i]) & 255) << 8));
        this.b -= 8;
        if (i5 == i2) {
            this.a = hVar.a();
            i.a(hVar);
            return j3;
        }
        hVar.b = i5;
        return j3;
    }

    public int h() {
        return n.a(f());
    }

    public long i() {
        return n.a(g());
    }

    public d j() {
        return new d(k());
    }

    public d c(long j) {
        return new d(e(j));
    }

    public String d(long j) {
        return a(j, n.a);
    }

    public String a(long j, Charset charset) {
        n.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            h hVar = this.a;
            if (((long) hVar.b) + j > ((long) hVar.c)) {
                return new String(e(j), charset);
            }
            String str = new String(hVar.a, hVar.b, (int) j, charset);
            hVar.b = (int) (((long) hVar.b) + j);
            this.b -= j;
            if (hVar.b != hVar.c) {
                return str;
            }
            this.a = hVar.a();
            i.a(hVar);
            return str;
        }
    }

    public byte[] k() {
        try {
            return e(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] e(long j) {
        n.a(this.b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        a(bArr);
        return bArr;
    }

    public void a(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a = a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        n.a((long) bArr.length, (long) i, (long) i2);
        h hVar = this.a;
        if (hVar == null) {
            return -1;
        }
        int min = Math.min(i2, hVar.c - hVar.b);
        System.arraycopy(hVar.a, hVar.b, bArr, i, min);
        hVar.b += min;
        this.b -= (long) min;
        if (hVar.b != hVar.c) {
            return min;
        }
        this.a = hVar.a();
        i.a(hVar);
        return min;
    }

    public void l() {
        try {
            f(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void f(long j) {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.a.c - this.a.b));
            this.b -= (long) min;
            j -= (long) min;
            h hVar = this.a;
            hVar.b = min + hVar.b;
            if (this.a.b == this.a.c) {
                h hVar2 = this.a;
                this.a = hVar2.a();
                i.a(hVar2);
            }
        }
    }

    public a a(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        dVar.a(this);
        return this;
    }

    public a a(String str) {
        return a(str, 0, str.length());
    }

    public a a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt < '') {
                    int i4;
                    h d = d(1);
                    byte[] bArr = d.a;
                    int i5 = d.c - i;
                    int min = Math.min(i2, 8192 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - d.c;
                    d.c += i4;
                    this.b += (long) i4;
                } else if (charAt < 'ࠀ') {
                    a((charAt >> 6) | 192);
                    a((charAt & 63) | 128);
                    i3 = i + 1;
                } else if (charAt < '?' || charAt > '?') {
                    a((charAt >> 12) | 224);
                    a(((charAt >> 6) & 63) | 128);
                    a((charAt & 63) | 128);
                    i3 = i + 1;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '?' || i3 < 56320 || i3 > 57343) {
                        a(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        a((i3 >> 18) | 240);
                        a(((i3 >> 12) & 63) | 128);
                        a(((i3 >> 6) & 63) | 128);
                        a((i3 & 63) | 128);
                        i3 = i + 2;
                    }
                }
                i = i3;
            }
            return this;
        }
    }

    public a b(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public a b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        n.a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            h d = d(1);
            int min = Math.min(i3 - i, 8192 - d.c);
            System.arraycopy(bArr, i, d.a, d.c, min);
            i += min;
            d.c = min + d.c;
        }
        this.b += (long) i2;
        return this;
    }

    public long a(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = lVar.b(this, 8192);
            if (b == -1) {
                return j;
            }
            j += b;
        }
    }

    public a a(int i) {
        h d = d(1);
        byte[] bArr = d.a;
        int i2 = d.c;
        d.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    public a b(int i) {
        h d = d(4);
        byte[] bArr = d.a;
        int i2 = d.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        d.c = i2;
        this.b += 4;
        return this;
    }

    public a c(int i) {
        return b(n.a(i));
    }

    public a g(long j) {
        h d = d(8);
        byte[] bArr = d.a;
        int i = d.c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 40) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 32) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 24) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 16) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 8) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) (j & 255));
        d.c = i;
        this.b += 8;
        return this;
    }

    public a h(long j) {
        return g(n.a(j));
    }

    h d(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.a == null) {
            this.a = i.a();
            h hVar = this.a;
            h hVar2 = this.a;
            r0 = this.a;
            hVar2.g = r0;
            hVar.f = r0;
            return r0;
        } else {
            r0 = this.a.g;
            if (r0.c + i > 8192 || !r0.e) {
                return r0.a(i.a());
            }
            return r0;
        }
    }

    public void a(a aVar, long j) {
        if (aVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (aVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            n.a(aVar.b, 0, j);
            while (j > 0) {
                h hVar;
                if (j < ((long) (aVar.a.c - aVar.a.b))) {
                    hVar = this.a != null ? this.a.g : null;
                    if (hVar != null && hVar.e) {
                        if ((((long) hVar.c) + j) - ((long) (hVar.d ? 0 : hVar.b)) <= 8192) {
                            aVar.a.a(hVar, (int) j);
                            aVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    aVar.a = aVar.a.a((int) j);
                }
                h hVar2 = aVar.a;
                long j2 = (long) (hVar2.c - hVar2.b);
                aVar.a = hVar2.a();
                if (this.a == null) {
                    this.a = hVar2;
                    hVar2 = this.a;
                    hVar = this.a;
                    h hVar3 = this.a;
                    hVar.g = hVar3;
                    hVar2.f = hVar3;
                } else {
                    this.a.g.a(hVar2).b();
                }
                aVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        }
    }

    public long b(a aVar, long j) {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b == 0) {
            return -1;
        } else {
            if (j > this.b) {
                j = this.b;
            }
            aVar.a(this, j);
            return j;
        }
    }

    public void flush() {
    }

    public void close() {
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.b != aVar.b) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        h hVar = this.a;
        h hVar2 = aVar.a;
        int i = hVar.b;
        int i2 = hVar2.b;
        while (j < this.b) {
            long min = (long) Math.min(hVar.c - i, hVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = hVar.a[i];
                i = i2 + 1;
                if (b != hVar2.a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == hVar.c) {
                hVar = hVar.f;
                i = hVar.b;
            }
            if (i2 == hVar2.c) {
                hVar2 = hVar2.f;
                i2 = hVar2.b;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        h hVar = this.a;
        if (hVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = hVar.b;
            while (i2 < hVar.c) {
                int i3 = hVar.a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            hVar = hVar.f;
        } while (hVar != this.a);
        return i;
    }

    public String toString() {
        return n().toString();
    }

    public a m() {
        a aVar = new a();
        if (this.b == 0) {
            return aVar;
        }
        aVar.a = new h(this.a);
        h hVar = aVar.a;
        h hVar2 = aVar.a;
        h hVar3 = aVar.a;
        hVar2.g = hVar3;
        hVar.f = hVar3;
        for (hVar = this.a.f; hVar != this.a; hVar = hVar.f) {
            aVar.a.g.a(new h(hVar));
        }
        aVar.b = this.b;
        return aVar;
    }

    public d n() {
        if (this.b <= 2147483647L) {
            return e((int) this.b);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    public d e(int i) {
        if (i == 0) {
            return d.b;
        }
        return new j(this, i);
    }
}
