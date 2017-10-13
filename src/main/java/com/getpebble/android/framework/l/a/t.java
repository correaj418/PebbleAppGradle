package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import com.google.a.f.e;
import java.nio.ByteBuffer;

public class t extends o {
    private a a;
    private e b;

    public enum a {
        ACK((byte) 1),
        NACK((byte) 2);
        
        private byte mId;

        private a(byte b) {
            this.mId = b;
        }

        public byte getId() {
            return this.mId;
        }

        public static a fromId(byte b) {
            for (a aVar : values()) {
                if (aVar.getId() == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public t(b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        this.a = a.fromId(b.get());
        this.b = e.a(b.getInt());
    }

    public a c() {
        return this.a;
    }

    public e d() {
        return this.b;
    }

    public com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.PUT_BYTES;
    }

    protected int b() {
        return 5;
    }
}
