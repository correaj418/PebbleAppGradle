package b;

import java.util.Arrays;

final class j extends d {
    final transient byte[][] f;
    final transient int[] g;

    j(a aVar, int i) {
        int i2 = 0;
        super(null);
        n.a(aVar.b, 0, (long) i);
        h hVar = aVar.a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (hVar.c == hVar.b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += hVar.c - hVar.b;
            i3++;
            hVar = hVar.f;
        }
        this.f = new byte[i3][];
        this.g = new int[(i3 * 2)];
        h hVar2 = aVar.a;
        i4 = 0;
        while (i2 < i) {
            this.f[i4] = hVar2.a;
            int i5 = (hVar2.c - hVar2.b) + i2;
            if (i5 > i) {
                i5 = i;
            }
            this.g[i4] = i5;
            this.g[this.f.length + i4] = hVar2.b;
            hVar2.d = true;
            i4++;
            hVar2 = hVar2.f;
            i2 = i5;
        }
    }

    public String a() {
        return e().a();
    }

    public String b() {
        return e().b();
    }

    public d a(int i, int i2) {
        return e().a(i, i2);
    }

    public byte a(int i) {
        n.a((long) this.g[this.f.length - 1], (long) i, 1);
        int b = b(i);
        return this.f[b][(i - (b == 0 ? 0 : this.g[b - 1])) + this.g[this.f.length + b]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public int c() {
        return this.g[this.f.length - 1];
    }

    public byte[] d() {
        int i = 0;
        Object obj = new byte[this.g[this.f.length - 1]];
        int length = this.f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            System.arraycopy(this.f[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    void a(a aVar) {
        int i = 0;
        int length = this.f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            h hVar = new h(this.f[i], i3, (i3 + i4) - i2);
            if (aVar.a == null) {
                hVar.g = hVar;
                hVar.f = hVar;
                aVar.a = hVar;
            } else {
                aVar.a.g.a(hVar);
            }
            i++;
            i2 = i4;
        }
        aVar.b = ((long) i2) + aVar.b;
    }

    public boolean a(int i, d dVar, int i2, int i3) {
        if (i < 0 || i > c() - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.g[b - 1];
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            if (!dVar.a(i2, this.f[b], (i - i4) + this.g[this.f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.g[b - 1];
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            if (!n.a(this.f[b], (i - i4) + this.g[this.f.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private d e() {
        return new d(d());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof d) && ((d) obj).c() == c() && a(0, (d) obj, 0, c());
        return z;
    }

    public int hashCode() {
        int i = this.d;
        if (i == 0) {
            i = 1;
            int length = this.f.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.f[i2];
                int i4 = this.g[length + i2];
                int i5 = this.g[i2];
                i3 = (i5 - i3) + i4;
                int i6 = i4;
                i4 = i;
                for (i = i6; i < i3; i++) {
                    i4 = (i4 * 31) + bArr[i];
                }
                i2++;
                i3 = i5;
                i = i4;
            }
            this.d = i;
        }
        return i;
    }

    public String toString() {
        return e().toString();
    }
}
