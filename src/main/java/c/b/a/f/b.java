package c.b.a.f;

import c.b.a.b.u;
import c.b.a.f;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class b {

    private static final class a extends f {
        final int b;
        final d c;
        final d d;

        static a a(DataInput dataInput, String str) {
            return new a(str, (int) b.a(dataInput), d.a(dataInput), d.a(dataInput));
        }

        a(String str, int i, d dVar, d dVar2) {
            super(str);
            this.b = i;
            this.c = dVar;
            this.d = dVar2;
        }

        public String a(long j) {
            return i(j).a();
        }

        public int b(long j) {
            return this.b + i(j).b();
        }

        public int c(long j) {
            return this.b;
        }

        public boolean f() {
            return false;
        }

        public long g(long j) {
            long a;
            long j2;
            int i = this.b;
            d dVar = this.c;
            d dVar2 = this.d;
            try {
                a = dVar.a(j, i, dVar2.b());
                if (j > 0 && a < 0) {
                    a = j;
                }
                j2 = a;
            } catch (IllegalArgumentException e) {
                j2 = j;
            } catch (ArithmeticException e2) {
                j2 = j;
            }
            try {
                a = dVar2.a(j, i, dVar.b());
                if (j <= 0 || a >= 0) {
                    j = a;
                }
                a = j;
            } catch (IllegalArgumentException e3) {
                a = j;
            } catch (ArithmeticException e4) {
                a = j;
            }
            if (j2 > a) {
                return a;
            }
            return j2;
        }

        public long h(long j) {
            long b;
            long j2;
            long j3 = j + 1;
            int i = this.b;
            d dVar = this.c;
            d dVar2 = this.d;
            try {
                b = dVar.b(j3, i, dVar2.b());
                if (j3 < 0 && b > 0) {
                    b = j3;
                }
                j2 = b;
            } catch (IllegalArgumentException e) {
                j2 = j3;
            } catch (ArithmeticException e2) {
                j2 = j3;
            }
            try {
                b = dVar2.b(j3, i, dVar.b());
                if (j3 >= 0 || b <= 0) {
                    j3 = b;
                }
                b = j3;
            } catch (IllegalArgumentException e3) {
                b = j3;
            } catch (ArithmeticException e4) {
                b = j3;
            }
            if (j2 > b) {
                b = j2;
            }
            return b - 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (e().equals(aVar.e()) && this.b == aVar.b && this.c.equals(aVar.c) && this.d.equals(aVar.d)) {
                return true;
            }
            return false;
        }

        private d i(long j) {
            long a;
            int i = this.b;
            d dVar = this.c;
            d dVar2 = this.d;
            try {
                a = dVar.a(j, i, dVar2.b());
            } catch (IllegalArgumentException e) {
                a = j;
            } catch (ArithmeticException e2) {
                a = j;
            }
            try {
                j = dVar2.a(j, i, dVar.b());
            } catch (IllegalArgumentException e3) {
            } catch (ArithmeticException e4) {
            }
            if (a > j) {
                return dVar;
            }
            return dVar2;
        }
    }

    private static final class b {
        final char a;
        final int b;
        final int c;
        final int d;
        final boolean e;
        final int f;

        static b a(DataInput dataInput) {
            return new b((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) b.a(dataInput));
        }

        b(char c, int i, int i2, int i3, boolean z, int i4) {
            if (c == 'u' || c == 'w' || c == 's') {
                this.a = c;
                this.b = i;
                this.c = i2;
                this.d = i3;
                this.e = z;
                this.f = i4;
                return;
            }
            throw new IllegalArgumentException("Unknown mode: " + c);
        }

        public long a(long j, int i, int i2) {
            if (this.a == 'w') {
                i += i2;
            } else if (this.a != 's') {
                i = 0;
            }
            long j2 = ((long) i) + j;
            c.b.a.a N = u.N();
            long a = a(N, N.e().a(N.e().b(N.C().b(j2, this.b), 0), this.f));
            if (this.d != 0) {
                a = d(N, a);
                if (a <= j2) {
                    a = d(N, a(N, N.C().b(N.E().a(a, 1), this.b)));
                }
            } else if (a <= j2) {
                a = a(N, N.E().a(a, 1));
            }
            return a - ((long) i);
        }

        public long b(long j, int i, int i2) {
            if (this.a == 'w') {
                i += i2;
            } else if (this.a != 's') {
                i = 0;
            }
            long j2 = ((long) i) + j;
            c.b.a.a N = u.N();
            long b = b(N, N.e().a(N.e().b(N.C().b(j2, this.b), 0), this.f));
            if (this.d != 0) {
                b = d(N, b);
                if (b >= j2) {
                    b = d(N, b(N, N.C().b(N.E().a(b, -1), this.b)));
                }
            } else if (b >= j2) {
                b = b(N, N.E().a(b, -1));
            }
            return b - ((long) i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f) {
                return true;
            }
            return false;
        }

        private long a(c.b.a.a aVar, long j) {
            try {
                return c(aVar, j);
            } catch (IllegalArgumentException e) {
                if (this.b == 2 && this.c == 29) {
                    while (!aVar.E().b(j)) {
                        j = aVar.E().a(j, 1);
                    }
                    return c(aVar, j);
                }
                throw e;
            }
        }

        private long b(c.b.a.a aVar, long j) {
            try {
                return c(aVar, j);
            } catch (IllegalArgumentException e) {
                if (this.b == 2 && this.c == 29) {
                    while (!aVar.E().b(j)) {
                        j = aVar.E().a(j, -1);
                    }
                    return c(aVar, j);
                }
                throw e;
            }
        }

        private long c(c.b.a.a aVar, long j) {
            if (this.c >= 0) {
                return aVar.u().b(j, this.c);
            }
            return aVar.u().a(aVar.C().a(aVar.u().b(j, 1), 1), this.c);
        }

        private long d(c.b.a.a aVar, long j) {
            int a = this.d - aVar.t().a(j);
            if (a == 0) {
                return j;
            }
            if (this.e) {
                if (a < 0) {
                    a += 7;
                }
            } else if (a > 0) {
                a -= 7;
            }
            return aVar.t().a(j, a);
        }
    }

    private static final class c extends f {
        private final long[] b;
        private final int[] c;
        private final int[] d;
        private final String[] e;
        private final a f;

        static c a(DataInput dataInput, String str) {
            int i;
            int readUnsignedShort = dataInput.readUnsignedShort();
            String[] strArr = new String[readUnsignedShort];
            for (i = 0; i < readUnsignedShort; i++) {
                strArr[i] = dataInput.readUTF();
            }
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            String[] strArr2 = new String[readInt];
            for (i = 0; i < readInt; i++) {
                int readUnsignedByte;
                jArr[i] = b.a(dataInput);
                iArr[i] = (int) b.a(dataInput);
                iArr2[i] = (int) b.a(dataInput);
                if (readUnsignedShort < 256) {
                    try {
                        readUnsignedByte = dataInput.readUnsignedByte();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new IOException("Invalid encoding");
                    }
                }
                readUnsignedByte = dataInput.readUnsignedShort();
                strArr2[i] = strArr[readUnsignedByte];
            }
            a aVar = null;
            if (dataInput.readBoolean()) {
                aVar = a.a(dataInput, str);
            }
            return new c(str, jArr, iArr, iArr2, strArr2, aVar);
        }

        private c(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, a aVar) {
            super(str);
            this.b = jArr;
            this.c = iArr;
            this.d = iArr2;
            this.e = strArr;
            this.f = aVar;
        }

        public String a(long j) {
            long[] jArr = this.b;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.e[binarySearch];
            }
            binarySearch ^= -1;
            if (binarySearch < jArr.length) {
                if (binarySearch > 0) {
                    return this.e[binarySearch - 1];
                }
                return "UTC";
            } else if (this.f == null) {
                return this.e[binarySearch - 1];
            } else {
                return this.f.a(j);
            }
        }

        public int b(long j) {
            long[] jArr = this.b;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.c[binarySearch];
            }
            binarySearch ^= -1;
            if (binarySearch < jArr.length) {
                if (binarySearch > 0) {
                    return this.c[binarySearch - 1];
                }
                return 0;
            } else if (this.f == null) {
                return this.c[binarySearch - 1];
            } else {
                return this.f.b(j);
            }
        }

        public int c(long j) {
            long[] jArr = this.b;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.d[binarySearch];
            }
            binarySearch ^= -1;
            if (binarySearch < jArr.length) {
                if (binarySearch > 0) {
                    return this.d[binarySearch - 1];
                }
                return 0;
            } else if (this.f == null) {
                return this.d[binarySearch - 1];
            } else {
                return this.f.c(j);
            }
        }

        public boolean f() {
            return false;
        }

        public long g(long j) {
            long[] jArr = this.b;
            int binarySearch = Arrays.binarySearch(jArr, j);
            binarySearch = binarySearch >= 0 ? binarySearch + 1 : binarySearch ^ -1;
            if (binarySearch < jArr.length) {
                return jArr[binarySearch];
            }
            if (this.f == null) {
                return j;
            }
            long j2 = jArr[jArr.length - 1];
            if (j < j2) {
                j = j2;
            }
            return this.f.g(j);
        }

        public long h(long j) {
            long[] jArr = this.b;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch < 0) {
                int i = binarySearch ^ -1;
                long h;
                if (i >= jArr.length) {
                    if (this.f != null) {
                        h = this.f.h(j);
                        if (h < j) {
                            return h;
                        }
                    }
                    h = jArr[i - 1];
                    if (h > Long.MIN_VALUE) {
                        return h - 1;
                    }
                    return j;
                } else if (i <= 0) {
                    return j;
                } else {
                    h = jArr[i - 1];
                    if (h > Long.MIN_VALUE) {
                        return h - 1;
                    }
                    return j;
                }
            } else if (j > Long.MIN_VALUE) {
                return j - 1;
            } else {
                return j;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (e().equals(cVar.e()) && Arrays.equals(this.b, cVar.b) && Arrays.equals(this.e, cVar.e) && Arrays.equals(this.c, cVar.c) && Arrays.equals(this.d, cVar.d)) {
                if (this.f == null) {
                    if (cVar.f == null) {
                        return true;
                    }
                } else if (this.f.equals(cVar.f)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class d {
        final b a;
        final String b;
        final int c;

        static d a(DataInput dataInput) {
            return new d(b.a(dataInput), dataInput.readUTF(), (int) b.a(dataInput));
        }

        d(b bVar, String str, int i) {
            this.a = bVar;
            this.b = str;
            this.c = i;
        }

        public long a(long j, int i, int i2) {
            return this.a.a(j, i, i2);
        }

        public long b(long j, int i, int i2) {
            return this.a.b(j, i, i2);
        }

        public String a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.c == dVar.c && this.b.equals(dVar.b) && this.a.equals(dVar.a)) {
                return true;
            }
            return false;
        }
    }

    public static f a(InputStream inputStream, String str) {
        if (inputStream instanceof DataInput) {
            return a((DataInput) inputStream, str);
        }
        return a(new DataInputStream(inputStream), str);
    }

    public static f a(DataInput dataInput, String str) {
        switch (dataInput.readUnsignedByte()) {
            case 67:
                return a.b(c.a(dataInput, str));
            case 70:
                f dVar = new d(str, dataInput.readUTF(), (int) a(dataInput), (int) a(dataInput));
                if (dVar.equals(f.a)) {
                    return f.a;
                }
                return dVar;
            case 80:
                return c.a(dataInput, str);
            default:
                throw new IOException("Invalid encoding");
        }
    }

    static long a(DataInput dataInput) {
        int readUnsignedByte = dataInput.readUnsignedByte();
        switch (readUnsignedByte >> 6) {
            case 1:
                return ((long) (((((readUnsignedByte << 26) >> 2) | (dataInput.readUnsignedByte() << 16)) | (dataInput.readUnsignedByte() << 8)) | dataInput.readUnsignedByte())) * 60000;
            case 2:
                return ((((((((long) readUnsignedByte) << 58) >> 26) | ((long) (dataInput.readUnsignedByte() << 24))) | ((long) (dataInput.readUnsignedByte() << 16))) | ((long) (dataInput.readUnsignedByte() << 8))) | ((long) dataInput.readUnsignedByte())) * 1000;
            case 3:
                return dataInput.readLong();
            default:
                return ((long) ((readUnsignedByte << 26) >> 26)) * 1800000;
        }
    }
}
