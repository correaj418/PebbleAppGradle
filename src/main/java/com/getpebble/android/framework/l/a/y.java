package com.getpebble.android.framework.l.a;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.aj;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class y extends o {
    final byte a;
    private final short b;
    private final c c;
    private final UUID d;
    private aj e;

    public enum a {
        SESSION_SETUP((byte) 1),
        DICTATION_RESULT((byte) 2),
        NLP_RESULT((byte) 3),
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

    public enum b {
        DICTATION((byte) 1),
        VOICE_CONTROL((byte) 2),
        NLP((byte) 3),
        UNKNOWN((byte) -1);
        
        private final byte mCmd;

        private b(byte b) {
            this.mCmd = b;
        }

        public byte toByte() {
            return this.mCmd;
        }

        public static b from(byte b) {
            for (b bVar : values()) {
                if (bVar.toByte() == b) {
                    return bVar;
                }
            }
            return UNKNOWN;
        }
    }

    public static class c {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        c(String str, int i, int i2, int i3, int i4) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        static c a(ByteBuffer byteBuffer) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byte[] bArr = new byte[20];
            byteBuffer.get(bArr);
            return new c(new String(bArr).trim(), com.getpebble.android.bluetooth.b.b.c(byteBuffer).intValue(), com.getpebble.android.bluetooth.b.b.b(byteBuffer).intValue(), com.getpebble.android.bluetooth.b.b.a(byteBuffer).intValue(), com.getpebble.android.bluetooth.b.b.b(byteBuffer).intValue());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.b == cVar.b && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e) {
                return this.a.equals(cVar.a);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.VOICE_CONTROL;
    }

    protected int b() {
        return 2;
    }

    public y(com.getpebble.android.bluetooth.g.b bVar) {
        UUID uuid = null;
        super(bVar);
        ByteBuffer b = bVar.b();
        b.order(ByteOrder.LITTLE_ENDIAN);
        a from = a.from(b.get());
        if (from != a.SESSION_SETUP) {
            throw new IllegalArgumentException("Invalid packet ID: " + from);
        }
        try {
            byte[] bArr = new byte[4];
            b.get(bArr);
            this.e = aj.fromFlag(com.getpebble.android.bluetooth.b.b.f(bArr)[0]);
            this.a = b.get();
            this.b = b.getShort();
            int intValue = com.getpebble.android.bluetooth.b.b.a(b).intValue();
            c cVar = null;
            while (true) {
                int i = intValue - 1;
                if (intValue > 0) {
                    byte byteValue = com.getpebble.android.bluetooth.b.b.a(b).byteValue();
                    z from2 = z.from(byteValue);
                    com.getpebble.android.bluetooth.b.b.b(b).intValue();
                    switch (from2) {
                        case SPEEX_INFO:
                            cVar = c.a(b);
                            break;
                        case APP_UUID:
                            uuid = com.getpebble.android.bluetooth.b.b.f(b);
                            break;
                        default:
                            throw new IllegalArgumentException("Cannot handle attribute type: " + from2 + " byte=" + byteValue);
                    }
                    intValue = i;
                } else {
                    if (uuid != null && a(uuid)) {
                        this.e = aj.FIRST_PARTY;
                    }
                    if (cVar == null) {
                        throw new IllegalArgumentException("No audio transfer info found, cannot start setup");
                    }
                    this.c = cVar;
                    if (this.e == aj.THIRD_PARTY && uuid == null) {
                        throw new IllegalArgumentException("App-initiated requests must have an application UUID");
                    }
                    this.d = uuid;
                    return;
                }
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public short c() {
        return this.b;
    }

    public c d() {
        return this.c;
    }

    public UUID e() {
        return this.d;
    }

    public aj f() {
        return this.e;
    }

    public byte g() {
        return this.a;
    }

    private static boolean a(UUID uuid) {
        if (uuid == null) {
            f.a("PebbleInboundVoiceSetupMessage", "Failed to check if request should be processed as first party -- application UUID was null");
            return false;
        }
        String uuid2 = uuid.toString();
        String[] O = PebbleApplication.w().O();
        if (O == null) {
            f.a("PebbleInboundVoiceSetupMessage", "Failed to check if " + uuid2 + " was whitelisted -- whitelisted apps list was null.");
            return false;
        }
        for (String equals : O) {
            if (equals.equals(uuid2)) {
                f.d("PebbleInboundVoiceSetupMessage", "Application with UUID " + uuid2 + " is whitelisted and will be processed as a first party application.");
                return true;
            }
        }
        f.d("PebbleInboundVoiceSetupMessage", "Did not find uuid in list of whitelisted apps.");
        return false;
    }
}
