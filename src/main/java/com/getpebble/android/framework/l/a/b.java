package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.framework.l.b.c;
import java.nio.ByteBuffer;

public class b extends j {
    private final com.getpebble.android.framework.l.b.j.b a;
    private final long b;
    private final byte[] c;
    private final byte[] d;

    public b(com.getpebble.android.bluetooth.g.b bVar) {
        super(bVar);
        ByteBuffer g = g();
        this.a = com.getpebble.android.framework.l.b.j.b.from(g.get());
        this.b = com.getpebble.android.bluetooth.b.b.c(g).longValue();
        this.c = new byte[com.getpebble.android.bluetooth.b.b.a(g).shortValue()];
        g.get(this.c, 0, this.c.length);
        this.d = new byte[com.getpebble.android.bluetooth.b.b.b(g).intValue()];
        g.get(this.d, 0, this.d.length);
    }

    a a() {
        return a.BLOBDB_V2;
    }

    protected int b() {
        return 1;
    }

    public c a(com.getpebble.android.framework.l.a aVar) {
        return new c(e(), aVar);
    }

    public com.getpebble.android.framework.l.b.j.b c() {
        return this.a;
    }

    public byte[] d() {
        return this.d;
    }
}
