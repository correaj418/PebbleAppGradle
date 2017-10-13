package com.getpebble.android.framework.l.a;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.d.b;
import com.getpebble.android.common.model.v;
import com.google.a.f.e;
import java.nio.ByteBuffer;

public class x extends o {
    private b a;
    private b b;
    private e c;
    private String d;
    private String e;
    private byte[] f;
    private boolean[] g = new boolean[64];
    private boolean h = false;
    private e i;
    private String j;
    private e k;

    public class a extends RuntimeException {
        final /* synthetic */ x a;

        public a(x xVar, String str) {
            this.a = xVar;
            super(str);
        }
    }

    public x(com.getpebble.android.bluetooth.g.b bVar) {
        boolean z = true;
        super(bVar);
        ByteBuffer b = bVar.b();
        b.get();
        this.a = a(b);
        if (this.a == null) {
            throw new a(this, "Normal Firmware version is null!");
        }
        this.b = a(b);
        this.c = com.getpebble.android.bluetooth.b.b.c(b);
        this.d = com.getpebble.android.bluetooth.b.b.a(b, 9);
        this.e = com.getpebble.android.bluetooth.b.b.a(b, 12);
        this.f = a(com.getpebble.android.bluetooth.b.b.b(b, 6));
        com.getpebble.android.bluetooth.b.b.c(b);
        com.getpebble.android.bluetooth.b.b.c(b);
        if (com.getpebble.android.framework.o.b.remoteSupportsLanguagePackVersionMessageEntry(this.a.b())) {
            this.j = com.getpebble.android.bluetooth.b.b.a(b, 6);
            this.k = com.getpebble.android.bluetooth.b.b.b(b);
            f.d("PebbleInboundVersionMessage", String.format("Found a Pebble with locale %s and version %d", new Object[]{this.j, Integer.valueOf(this.k.intValue())}));
            this.g = com.getpebble.android.bluetooth.b.b.f(com.getpebble.android.bluetooth.b.b.b(b, 8));
            if (b.hasRemaining()) {
                if (b.get() <= (byte) 0) {
                    z = false;
                }
                this.h = z;
            }
            if (b.hasRemaining()) {
                this.i = com.getpebble.android.bluetooth.b.b.b(b);
                return;
            }
            return;
        }
        f.d("PebbleInboundVersionMessage", "Remote does not support language packs; version: " + this.a.b());
    }

    public static byte[] a(byte[] bArr) {
        int i = 0;
        for (int length = bArr.length - 1; i < length; length--) {
            byte b = bArr[i];
            bArr[i] = bArr[length];
            bArr[length] = b;
            i++;
        }
        return bArr;
    }

    public com.getpebble.android.framework.o.b c() {
        return new com.getpebble.android.framework.o.b(this.g);
    }

    private b a(ByteBuffer byteBuffer) {
        v vVar;
        e c = com.getpebble.android.bluetooth.b.b.c(byteBuffer);
        String a = com.getpebble.android.bluetooth.b.b.a(byteBuffer, 32);
        try {
            vVar = new v(a, c.longValue());
        } catch (Exception e) {
            f.b("PebbleInboundVersionMessage", "error parsing firmware version: " + a + " (" + c.longValue() + ")");
            vVar = null;
        }
        String a2 = com.getpebble.android.bluetooth.b.b.a(byteBuffer, 8);
        boolean e2 = com.getpebble.android.bluetooth.b.b.e(byteBuffer);
        e a3 = com.getpebble.android.bluetooth.b.b.a(byteBuffer);
        e a4 = com.getpebble.android.bluetooth.b.b.a(byteBuffer);
        f.d("PebbleInboundVersionMessage", "fw: " + a + " (" + c + ") hardwarePlatform: " + a3 + " isRecoveryFirmware = " + e2);
        return new b().a(c.longValue()).a(vVar).a(a2).a(e2).a(a3).b(a4);
    }

    public b d() {
        return this.a;
    }

    public b e() {
        return this.b;
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public boolean h() {
        return this.h;
    }

    public int i() {
        return this.i == null ? 0 : this.i.intValue();
    }

    public com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.VERSIONS;
    }

    protected int b() {
        return 126;
    }

    public String k() {
        return this.j;
    }

    public int l() {
        return this.k == null ? 0 : this.k.intValue();
    }
}
