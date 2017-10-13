package b;

import java.io.Serializable;
import java.util.Arrays;

public class d implements Serializable, Comparable<d> {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final d b = a(new byte[0]);
    final byte[] c;
    transient int d;
    transient String e;

    public /* synthetic */ int compareTo(Object obj) {
        return a((d) obj);
    }

    d(byte[] bArr) {
        this.c = bArr;
    }

    public static d a(byte... bArr) {
        if (bArr != null) {
            return new d((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static d a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        d dVar = new d(str.getBytes(n.a));
        dVar.e = str;
        return dVar;
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        str = new String(this.c, n.a);
        this.e = str;
        return str;
    }

    public String b() {
        int i = 0;
        char[] cArr = new char[(this.c.length * 2)];
        byte[] bArr = this.c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public d a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.c.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.c.length) {
                return this;
            } else {
                Object obj = new byte[i3];
                System.arraycopy(this.c, i, obj, 0, i3);
                this(obj);
                return this;
            }
        }
    }

    public byte a(int i) {
        return this.c[i];
    }

    public int c() {
        return this.c.length;
    }

    public byte[] d() {
        return (byte[]) this.c.clone();
    }

    void a(a aVar) {
        aVar.b(this.c, 0, this.c.length);
    }

    public boolean a(int i, d dVar, int i2, int i3) {
        return dVar.a(i2, this.c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && n.a(this.c, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof d) && ((d) obj).c() == this.c.length && ((d) obj).a(0, this.c, 0, this.c.length);
        return z;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.c);
        this.d = i;
        return i;
    }

    public int a(d dVar) {
        int c = c();
        int c2 = dVar.c();
        int min = Math.min(c, c2);
        int i = 0;
        while (i < min) {
            int a = a(i) & 255;
            int a2 = dVar.a(i) & 255;
            if (a == a2) {
                i++;
            } else if (a < a2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (c == c2) {
            return 0;
        }
        if (c >= c2) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String a = a();
        int a2 = a(a, 64);
        if (a2 != -1) {
            String replace = a.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            return a2 < a.length() ? "[size=" + this.c.length + " text=" + replace + "…]" : "[text=" + replace + "]";
        } else if (this.c.length <= 64) {
            return "[hex=" + b() + "]";
        } else {
            return "[size=" + this.c.length + " hex=" + a(0, 64).b() + "…]";
        }
    }

    static int a(String str, int i) {
        int i2 = 0;
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
