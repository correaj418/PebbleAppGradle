package com.getpebble.android.bluetooth.i;

import com.getpebble.android.bluetooth.b.b;
import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class a {
    static final e a = e.a(65261);
    static final e b = e.a(48879);
    static final e c = e.a(1);
    private final int d;
    private byte[] e;
    private final e f;

    a(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        e b = b.b(byteBuffer);
        if (b.equals(a)) {
            this.f = b.b(byteBuffer);
            b = b.b(byteBuffer);
            if (b.intValue() < 1) {
                throw new IllegalArgumentException("Invalid length: " + b);
            }
            this.d = b.intValue() + 2;
            return;
        }
        throw new IllegalArgumentException("Invalid packet header for QEMU: " + b);
    }

    int a() {
        return this.d;
    }

    void a(byte[] bArr) {
        if (bArr.length != this.d) {
            throw new IllegalArgumentException("Incorrect number of bytes: " + bArr.length);
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        this.e = new byte[(this.d - 2)];
        wrap.get(this.e);
        e b = b.b(wrap);
        if (!b.equals(b)) {
            throw new IllegalArgumentException("Invalid packet footer for QEMU: " + b);
        }
    }

    boolean b() {
        return this.f.equals(c);
    }

    byte[] c() {
        return this.e;
    }
}
