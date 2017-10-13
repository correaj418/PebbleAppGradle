package com.getpebble.android.framework.install;

import b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class d {
    private int a;
    private final a b;
    private boolean c;
    private boolean d;

    public d() {
        this(false);
    }

    public d(boolean z) {
        this.d = false;
        this.a = -1;
        this.b = new a();
        this.c = false;
        this.d = z;
    }

    public d a(byte[] bArr, int i) {
        if (this.c) {
            throw new IllegalStateException("Cannot addBytes once CRC is finalized.");
        }
        b(bArr, i);
        b();
        return this;
    }

    public int a() {
        if (this.c) {
            return this.a;
        }
        if (this.b.a() > 0 && this.b.a() < 4) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(this.d ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            for (long a = this.b.a(); a < 4; a++) {
                allocate.put((byte) 0);
            }
            allocate.put(this.b.k());
            a(allocate.getInt(0));
        }
        this.c = true;
        return this.a;
    }

    private void b(byte[] bArr, int i) {
        this.b.b(bArr, 0, i);
    }

    private void b() {
        while (this.b.b(4)) {
            a(this.b.h());
        }
    }

    private int a(int i) {
        this.a ^= i;
        for (int i2 = 0; i2 < 32; i2++) {
            if ((this.a & Integer.MIN_VALUE) != 0) {
                this.a = (this.a << 1) ^ 79764919;
            } else {
                this.a <<= 1;
            }
        }
        return this.a;
    }
}
