package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.framework.l.a.h;
import com.google.a.f.e;
import java.nio.ByteOrder;

public class i extends r {
    private short a;

    public i(short s) {
        super(a.AUDIO_STREAMING);
        this.a = s;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(h.a.STOP_PACKET.toByte()));
            a(b.b(e.a((long) this.a), ByteOrder.LITTLE_ENDIAN));
        }
        return super.c_();
    }
}
