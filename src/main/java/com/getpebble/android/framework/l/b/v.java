package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.g.a;
import com.google.a.f.d;

public class v extends r {
    private int a;

    public v(int i) {
        super(a.MUSIC_CONTROL);
        this.a = i;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 18));
            a(Byte.valueOf(d.a((long) this.a)));
        }
        return super.c_();
    }
}
