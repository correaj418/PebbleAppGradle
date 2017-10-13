package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import com.google.a.f.e;
import java.nio.ByteBuffer;

public class s extends o {
    private final String a = "PebbleInboundPingMessage";
    private e b;
    private boolean c;

    public s(b bVar) {
        boolean z = true;
        super(bVar);
        ByteBuffer b = bVar.b();
        b.get();
        this.b = e.a(b.getInt());
        if (b.hasRemaining()) {
            if (b.get() != (byte) 1) {
                z = false;
            }
            this.c = z;
            return;
        }
        this.c = false;
    }

    public e c() {
        return this.b;
    }

    public a a() {
        return a.PING;
    }

    protected int b() {
        return 5;
    }

    public boolean d() {
        return this.c;
    }
}
