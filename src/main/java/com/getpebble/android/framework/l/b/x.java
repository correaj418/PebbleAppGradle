package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;

public class x extends r {
    private a a;
    private byte[] e;
    private String f;
    private String g;

    public enum a {
        UNKNOWN((byte) 0),
        ANSWER((byte) 1),
        HANGUP((byte) 2),
        GET_STATE((byte) 3),
        INCOMING_CALL((byte) 4),
        OUTGOING_CALL((byte) 5),
        MISSED_CALL((byte) 6),
        RING((byte) 7),
        START((byte) 8),
        END((byte) 9);
        
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
            return UNKNOWN;
        }
    }

    public x(a aVar, byte[] bArr) {
        super(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL);
        if (a(aVar)) {
            throw new IllegalArgumentException("Command " + aVar + " requires the caller's name and number.");
        }
        this.a = aVar;
        this.e = bArr;
    }

    public x(a aVar, byte[] bArr, String str, String str2) {
        super(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL);
        this.a = aVar;
        this.e = bArr;
        this.f = str;
        this.g = str2;
    }

    private boolean a(a aVar) {
        return aVar.equals(a.INCOMING_CALL) || aVar.equals(a.MISSED_CALL);
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.a.getCommand()));
            a(this.e);
            if (a(this.a)) {
                a(b.c(this.f, 255));
                a(b.c(this.g, 255));
            }
        }
        return super.c_();
    }
}
