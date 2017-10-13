package com.b.a.c.f;

import com.b.a.f.b;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;

final class c implements Serializable {
    public static final c a = a(new byte[0]);
    private static final char[] c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    final byte[] b;
    private transient int d;
    private transient String e;

    c(byte[] bArr) {
        this.b = bArr;
    }

    public static c a(byte... bArr) {
        if (bArr != null) {
            return new c((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static c a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        c cVar = new c(str.getBytes(b.b));
        cVar.e = str;
        return cVar;
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        str = new String(this.b, b.b);
        this.e = str;
        return str;
    }

    public String b() {
        int i = 0;
        char[] cArr = new char[(this.b.length * 2)];
        byte[] bArr = this.b;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = c[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = c[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public c c() {
        int i = 0;
        while (i < this.b.length) {
            byte b = this.b[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.b.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b + 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i] = (byte) (b2 + 32);
                    }
                }
                return new c(bArr);
            }
        }
        return this;
    }

    public byte a(int i) {
        return this.b[i];
    }

    public int d() {
        return this.b.length;
    }

    public byte[] e() {
        return (byte[]) this.b.clone();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof c) && Arrays.equals(((c) obj).b, this.b));
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.b);
        this.d = i;
        return i;
    }

    public String toString() {
        if (this.b.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.b.length <= 16) {
            return String.format(Locale.ENGLISH, "ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(this.b.length), b()});
        }
        try {
            return String.format(Locale.ENGLISH, "ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(this.b.length), a(MessageDigest.getInstance("MD5").digest(this.b)).b()});
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }
}
