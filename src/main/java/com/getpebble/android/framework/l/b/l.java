package com.getpebble.android.framework.l.b;

import java.nio.ByteBuffer;

public class l extends r {
    private ByteBuffer a;

    public l(short s, ByteBuffer byteBuffer) {
        super(s);
        this.a = byteBuffer;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            b(this.a);
        }
        return super.c_();
    }
}
