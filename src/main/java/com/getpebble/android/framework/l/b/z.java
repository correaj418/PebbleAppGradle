package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.bluetooth.g.a;
import com.google.a.f.e;
import java.nio.ByteOrder;

public class z extends r {
    private final e a;

    public z(e eVar) {
        super(a.PING);
        this.a = eVar;
    }

    public byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 1));
            a(b.a(this.a, ByteOrder.BIG_ENDIAN));
        }
        return super.c_();
    }
}
