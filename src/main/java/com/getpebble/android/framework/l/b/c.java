package com.getpebble.android.framework.l.b;

import com.getpebble.android.framework.l.a;
import com.getpebble.android.framework.l.b.b;

public class c extends k {
    private final a a;

    public c(byte[] bArr, a aVar) {
        this(b.WRITE_RESPONSE, bArr, aVar);
    }

    c(b bVar, byte[] bArr, a aVar) {
        super(bVar, bArr);
        this.a = aVar;
    }

    protected void a() {
        a(Byte.valueOf(this.a.toByte()));
    }
}
