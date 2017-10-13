package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class h extends o {
    private byte a = this.b.get();
    protected ByteBuffer b;
    private short c = this.b.getShort();

    public enum a {
        DATA_PACKET((byte) 2),
        STOP_PACKET((byte) 3),
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

    protected h(b bVar) {
        super(bVar);
        this.b = bVar.b();
        this.b.order(ByteOrder.LITTLE_ENDIAN);
    }

    public short d() {
        return this.c;
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.AUDIO_STREAMING;
    }

    protected int b() {
        return 3;
    }
}
