package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.g.a;

public class q extends r {
    private final byte a;
    private final byte[] e;

    public q(int i, byte[] bArr) {
        super(a.LOG_DUMP);
        this.a = (byte) (i & 255);
        this.e = bArr;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 16));
            a(Byte.valueOf(this.a));
            a(this.e);
        }
        return super.c_();
    }
}
