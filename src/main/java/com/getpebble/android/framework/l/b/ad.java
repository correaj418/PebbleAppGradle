package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.google.a.f.e;

public class ad extends r {
    private a a;

    public enum a {
        FIRMWARE_AVAILABLE((byte) 0),
        FIRMWARE_START((byte) 1),
        FIRMWARE_COMPLETE((byte) 2),
        FIRMWARE_FAIL((byte) 3),
        FIRMWARE_UP_TO_DATE((byte) 4),
        FIRMWARE_OUT_OF_DATE((byte) 5),
        FIRMWARE_START_RESPONSE((byte) 10),
        FIRMWARE_STATUS((byte) 11),
        FIRMWARE_UNKNOWN((byte) -1);
        
        private byte command;

        private a(byte b) {
            this.command = b;
        }

        public byte getCommand() {
            return this.command;
        }

        public static a fromByte(byte b) {
            for (a aVar : values()) {
                if (aVar.command == b) {
                    return aVar;
                }
            }
            return FIRMWARE_UNKNOWN;
        }
    }

    public ad(a aVar) {
        super(com.getpebble.android.bluetooth.g.a.SYSTEM_MESSAGE);
        this.a = aVar;
    }

    public ad(int i, int i2) {
        super(com.getpebble.android.bluetooth.g.a.SYSTEM_MESSAGE);
        this.a = a.FIRMWARE_START;
        a(i, i2);
    }

    private synchronized void a(int i, int i2) {
        c_();
        a(b.c(e.a((long) i)));
        a(b.c(e.a((long) i2)));
        super.c_();
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 0));
            a(Byte.valueOf(this.a.getCommand()));
        }
        return super.c_();
    }
}
