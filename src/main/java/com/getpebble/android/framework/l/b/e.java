package com.getpebble.android.framework.l.b;

public class e extends r {
    private final a a;
    private final b e;

    private enum a {
        RESULT((byte) 1);
        
        private final byte id;

        private a(byte b) {
            this.id = b;
        }

        public byte getId() {
            return this.id;
        }
    }

    public enum b {
        STARTING((byte) 1),
        BUSY((byte) 2),
        UUID_INVALID((byte) 3),
        NO_DATA((byte) 4);
        
        private final byte id;

        private b(byte b) {
            this.id = b;
        }

        public byte getId() {
            return this.id;
        }
    }

    private e(a aVar, b bVar) {
        super(com.getpebble.android.bluetooth.g.a.APP_FETCH);
        this.a = aVar;
        this.e = bVar;
    }

    public static e a(b bVar) {
        return new e(a.RESULT, bVar);
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.a.getId()));
            a(Byte.valueOf(this.e.getId()));
        }
        return super.c_();
    }
}
