package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.bluetooth.g.a;
import com.google.a.f.e;

public class p extends r {
    private final e a;

    public p(e eVar) {
        super(a.HEALTH_SYNC);
        this.a = eVar;
    }

    public byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 1));
            a(b.c(this.a));
        }
        return super.c_();
    }
}
