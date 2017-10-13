package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.g.a;
import com.google.a.f.d;

public class o extends r {
    private final byte a;
    private final byte e;
    private final String f;

    private o(byte b, byte b2, String str) {
        super(a.GET_BYTES);
        this.e = b2;
        this.a = b;
        this.f = str;
    }

    public static o a(byte b) {
        return new o((byte) 0, b, null);
    }

    public static o a(byte b, String str) {
        return new o((byte) 3, b, str);
    }

    public static o b(byte b) {
        return new o((byte) 5, b, null);
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.a));
            a(Byte.valueOf(this.e));
            if (this.a == (byte) 3) {
                a(Byte.valueOf(d.a((long) this.f.length())));
                a(this.f.getBytes());
                a(Byte.valueOf((byte) 0));
            }
        }
        return super.c_();
    }
}
