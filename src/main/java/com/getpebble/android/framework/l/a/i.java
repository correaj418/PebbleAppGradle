package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.framework.l.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class i extends o {
    private final byte[] a = new byte[2];
    private final a b;

    public i(b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        b.order(ByteOrder.LITTLE_ENDIAN);
        b.get(this.a);
        this.b = a.from(b.get());
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.BLOBDB_V1;
    }

    protected int b() {
        return 1;
    }

    public a c() {
        return this.b;
    }

    public byte[] d() {
        return this.a;
    }
}
