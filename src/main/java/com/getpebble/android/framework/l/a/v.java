package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import java.nio.ByteBuffer;

public class v extends o {
    private final a a;
    private byte[] b = null;

    public enum a {
        RECONNECT_STOP((byte) 6),
        RECONNECT_START((byte) 7),
        FIRMWARE_UPDATE_START_ACK((byte) 10),
        FIRMWARE_UPDATE_STATUS_RESPONSE((byte) 12);
        
        private byte mCode;

        private a(byte b) {
            this.mCode = b;
        }

        public byte getCode() {
            return this.mCode;
        }

        public static a fromCode(byte b) {
            for (a aVar : values()) {
                if (aVar.getCode() == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public v(b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        if (b.get() != (byte) 0) {
            throw new IllegalArgumentException("Message did not start with expected zero byte.");
        }
        byte b2 = b.get();
        this.a = a.fromCode(b2);
        if (this.a == null) {
            f.b("PebbleInboundSystemMessage", "Received unsupported system message; type: " + b2);
        }
        int remaining = b.remaining();
        if (remaining > 0) {
            byte[] bArr = new byte[remaining];
            b.get(bArr);
            this.b = bArr;
        }
    }

    public a c() {
        return this.a;
    }

    public byte[] d() {
        return this.b;
    }

    public com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.SYSTEM_MESSAGE;
    }

    protected int b() {
        return 2;
    }
}
