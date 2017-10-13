package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.framework.l.b.b;

public abstract class k extends r {
    private final b a;
    private final byte[] e;

    protected abstract void a();

    public k(b bVar, byte[] bArr) {
        super(a.BLOBDB_V2);
        this.a = bVar;
        this.e = bArr;
    }

    public final synchronized byte[] c_() {
        if (!d()) {
            b();
            a();
        }
        return super.c_();
    }

    private void b() {
        a(Byte.valueOf(this.a.toByte()));
        a(this.e);
    }
}
