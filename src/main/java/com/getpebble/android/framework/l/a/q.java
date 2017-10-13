package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import java.nio.ByteBuffer;

public class q extends o {
    private a a;
    private byte[] b = new byte[4];

    public enum a {
        UNKNOWN((byte) 0),
        HANGUP((byte) 2);
        
        private byte action;

        private a(byte b) {
            this.action = b;
        }

        public byte getAction() {
            return this.action;
        }

        public static a fromByte(byte b) {
            for (a aVar : values()) {
                if (aVar.action == b) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    public q(b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        this.a = a.fromByte(b.get());
        b.get(this.b, 0, 4);
    }

    public a c() {
        return this.a;
    }

    public com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.PHONE_CONTROL;
    }

    protected int b() {
        return 5;
    }
}
