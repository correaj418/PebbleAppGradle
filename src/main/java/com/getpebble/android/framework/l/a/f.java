package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import java.nio.ByteBuffer;
import java.util.UUID;

public class f extends o {
    private final a a;
    private final UUID b;

    public enum a {
        RUNNING((byte) 1),
        STOPPED((byte) 2);
        
        byte mCode;

        private a(byte b) {
            this.mCode = b;
        }

        public byte getCode() {
            return this.mCode;
        }

        public static a fromByte(byte b) {
            for (a aVar : values()) {
                if (aVar.getCode() == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public f(b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        this.a = a.fromByte(b.get());
        this.b = com.getpebble.android.bluetooth.b.b.f(b);
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.APP_RUN_STATE;
    }

    protected int b() {
        return 17;
    }

    public a c() {
        return this.a;
    }

    public UUID d() {
        return this.b;
    }
}
