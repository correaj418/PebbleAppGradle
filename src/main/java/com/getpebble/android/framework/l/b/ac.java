package com.getpebble.android.framework.l.b;

public class ac extends r {
    private a a;

    public enum a {
        RESET((byte) 0),
        NEW_CORE_DUMP((byte) 1),
        FACTORY_RESET((byte) -2),
        RESET_INTO_PRF((byte) -1);
        
        private byte command;

        private a(byte b) {
            this.command = b;
        }

        public byte getCommand() {
            return this.command;
        }
    }

    public ac(a aVar) {
        super(com.getpebble.android.bluetooth.g.a.RESET);
        this.a = aVar;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.a.getCommand()));
        }
        return super.c_();
    }
}
