package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.framework.l.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class j extends o {
    private final a a;
    private final byte[] b = new byte[2];
    private final ByteBuffer c;

    public j(b bVar) {
        super(bVar);
        this.c = bVar.b();
        this.c.order(ByteOrder.LITTLE_ENDIAN);
        this.a = a.from(this.c.get());
        this.c.get(this.b);
    }

    public byte[] e() {
        return this.b;
    }

    public a f() {
        return this.a;
    }

    protected ByteBuffer g() {
        return this.c;
    }

    public static a a(b bVar) {
        ByteBuffer b = bVar.b();
        b.order(ByteOrder.LITTLE_ENDIAN);
        int position = b.position();
        a from = a.from(b.get());
        b.position(position);
        return from;
    }
}
