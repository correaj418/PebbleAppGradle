package com.getpebble.android.framework.o;

import android.graphics.Bitmap;
import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class a {
    public final e a;
    public final e b;
    public final short c;
    public final short d;
    public final short e;
    public final short f;
    public final byte[] g;

    private a(e eVar, e eVar2, short s, short s2, short s3, short s4, byte[] bArr) {
        this.a = eVar;
        this.b = eVar2;
        this.c = s;
        this.d = s2;
        this.e = s3;
        this.f = s4;
        this.g = bArr;
    }

    public static a a(Bitmap bitmap) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i = ((width + 31) / 32) * 4;
        ByteBuffer allocate = ByteBuffer.allocate(i * height);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < i / 4; i3++) {
                int i4 = i3 * 32;
                int i5 = 0;
                int i6 = 0;
                while (i5 < 32 && i4 + i5 < width) {
                    short s;
                    int i7;
                    if ((bitmap.getPixel(i4 + i5, i2) & 16777215) > 1) {
                        s = (short) 1;
                    } else {
                        s = (short) 0;
                    }
                    if (s != (short) 0) {
                        i7 = 1;
                    } else {
                        i7 = 0;
                    }
                    i6 |= i7 << i5;
                    i5++;
                }
                allocate.putInt(i6);
            }
        }
        return new a(e.a(i), e.a(4096), (short) 0, (short) 0, (short) width, (short) height, allocate.array());
    }

    public ByteBuffer a() {
        ByteBuffer allocate = ByteBuffer.allocate(this.g.length + 12);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(this.a.shortValue());
        allocate.putShort(this.b.shortValue());
        allocate.putShort(this.c);
        allocate.putShort(this.d);
        allocate.putShort(this.e);
        allocate.putShort(this.f);
        allocate.put(this.g);
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f != aVar.f) {
            return false;
        }
        if (this.e != aVar.e) {
            return false;
        }
        if (this.c != aVar.c) {
            return false;
        }
        if (this.d != aVar.d) {
            return false;
        }
        if (!Arrays.equals(this.g, aVar.g)) {
            return false;
        }
        if (this.b == null ? aVar.b != null : !this.b.equals(aVar.b)) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(aVar.a)) {
                return true;
            }
        } else if (aVar.a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (this.a != null ? this.a.hashCode() : 0) * 31;
        if (this.b != null) {
            hashCode = this.b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (((((((((hashCode + hashCode2) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        if (this.g != null) {
            i = Arrays.hashCode(this.g);
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PebbleBitmap");
        stringBuilder.append("{height=").append(this.f);
        stringBuilder.append(", width=").append(this.e);
        stringBuilder.append(", y=").append(this.d);
        stringBuilder.append(", x=").append(this.c);
        stringBuilder.append(", flags=").append(this.b);
        stringBuilder.append(", rowLengthBytes=").append(this.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
