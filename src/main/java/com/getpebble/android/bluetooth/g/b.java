package com.getpebble.android.bluetooth.g;

import java.nio.ByteBuffer;

public class b {
    private short a = (short) -1;
    private byte[] b;

    public b(short s, byte[] bArr) {
        this.a = s;
        this.b = bArr;
    }

    public static b a(ByteBuffer byteBuffer) {
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        if (s != byteBuffer.remaining()) {
            throw new IllegalArgumentException("Invalid size for message, expected: " + s + ", got: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr, 0, bArr.length);
        return new b(s2, bArr);
    }

    public short a() {
        return this.a;
    }

    public ByteBuffer b() {
        return ByteBuffer.wrap(this.b).asReadOnlyBuffer();
    }

    public int c() {
        return this.b.length;
    }
}
