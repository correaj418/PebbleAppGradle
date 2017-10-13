package com.getpebble.android.framework.b;

import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.e.a.e;
import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.h.h;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.b.r;
import java.nio.ByteBuffer;

public class b {
    private h a;
    private PebbleDevice b;

    public b(h hVar, PebbleDevice pebbleDevice) {
        if (hVar == null) {
            throw new IllegalArgumentException("'deviceMessageSender' cannot be null!");
        } else if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        } else {
            this.a = hVar;
            this.b = pebbleDevice;
        }
    }

    private h b() {
        return this.a;
    }

    public PebbleDevice a() {
        return this.b;
    }

    public boolean a(r rVar) {
        return a(com.getpebble.android.bluetooth.g.b.a(ByteBuffer.wrap(rVar.c_())));
    }

    protected boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        if (b(bVar)) {
            return b().a(a(), bVar);
        }
        return false;
    }

    public void a(e eVar) {
        b().a(a(), eVar);
    }

    public static boolean b(com.getpebble.android.bluetooth.g.b bVar) {
        int c = bVar.c() + 4;
        a fromCode = a.fromCode(bVar.a());
        if (c <= r.a(fromCode, r.g())) {
            return true;
        }
        f.f("MessageSender", "Message is to large (" + c + " bytes / " + fromCode + ")");
        return false;
    }
}
