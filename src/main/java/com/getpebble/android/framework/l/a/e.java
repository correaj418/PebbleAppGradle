package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;

public class e extends o {
    private final a a;

    public enum a {
        SUCCESS((byte) 1),
        FAILED((byte) 2),
        INVALID((byte) 3),
        RETRY((byte) 4);
        
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

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.APP_REORDER;
    }

    protected int b() {
        return 0;
    }

    public a c() {
        return this.a;
    }

    public e(b bVar) {
        super(bVar);
        this.a = a.fromByte(bVar.b().get());
    }
}
