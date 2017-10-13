package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class c extends o {
    private final a a;
    private final UUID b;
    private final e c;

    public enum a {
        FETCH((byte) 1),
        UNKNOWN((byte) -1);
        
        private final byte mCmd;

        private a(byte b) {
            this.mCmd = b;
        }

        public byte toByte() {
            return this.mCmd;
        }

        public static a from(byte b) {
            for (a aVar : values()) {
                if (aVar.toByte() == b) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    public c(b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        b.order(ByteOrder.LITTLE_ENDIAN);
        this.a = a.from(b.get());
        this.b = com.getpebble.android.bluetooth.b.b.f(b);
        this.c = com.getpebble.android.bluetooth.b.b.c(b);
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.APP_FETCH;
    }

    protected int b() {
        return 21;
    }

    public a c() {
        return this.a;
    }

    public UUID d() {
        return this.b;
    }

    public e e() {
        return this.c;
    }
}
