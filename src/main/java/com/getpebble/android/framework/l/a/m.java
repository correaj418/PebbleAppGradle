package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class m extends o {
    private final byte a;
    private final byte b;

    public byte c() {
        return this.a;
    }

    public m(b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        b.order(ByteOrder.LITTLE_ENDIAN);
        this.a = b.get();
        this.b = b.get();
    }

    public a a() {
        return a.HEALTH_SYNC;
    }

    protected int b() {
        return 2;
    }

    public boolean d() {
        return this.b == (byte) 1;
    }

    public byte e() {
        return this.b;
    }
}
