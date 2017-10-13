package com.getpebble.android.bluetooth.e;

import com.google.a.f.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class l {
    private final short a;
    private final a b;
    private final byte[] c;
    private int d = 0;

    enum a {
        DATA(0, true),
        ACK(1, true),
        RESET_REQUEST(2, false),
        RESET_COMPLETE(3, false);
        
        private static final int PACKET_TYPE_MASK = 7;
        private int mBits;
        public boolean needsOpenSession;

        private a(int i, boolean z) {
            this.mBits = i;
            this.needsOpenSession = z;
        }

        static a fromInt(int i) {
            int i2 = i & 7;
            for (a aVar : values()) {
                if (aVar.mBits == i2) {
                    return aVar;
                }
            }
            throw new IllegalArgumentException("Invalid packet type bits: " + i);
        }
    }

    static l a(short s) {
        return new l(s, a.ACK, null);
    }

    static l a(short s, c cVar) {
        return new l(s, a.RESET_REQUEST, new byte[]{d.a((long) cVar.version)});
    }

    static l a(short s, int i, int i2, c cVar) {
        return new l(s, a.RESET_COMPLETE, !cVar.supportsWindowNegotiation ? new byte[0] : new byte[]{d.a((long) i), d.a((long) i2)});
    }

    l(short s, a aVar, byte[] bArr) {
        if (s < (short) 0 || s > (short) 31) {
            throw new IllegalArgumentException("Invalid sequence value: " + s);
        } else if (!aVar.equals(a.ACK) && bArr == null) {
            throw new IllegalArgumentException("data cannot be null for " + aVar);
        } else if (!aVar.equals(a.ACK) || bArr == null) {
            int length;
            this.a = s;
            this.b = aVar;
            if (bArr != null) {
                length = bArr.length + 1;
            } else {
                length = 1;
            }
            this.c = new byte[length];
            ByteBuffer wrap = ByteBuffer.wrap(this.c);
            wrap.put((byte) (aVar.mBits | ((s << 3) & 248)));
            if (bArr != null) {
                wrap.put(bArr);
            }
        } else {
            throw new IllegalArgumentException("data cannot be set for " + aVar);
        }
    }

    l(byte[] bArr) {
        this.c = bArr;
        if (bArr.length < 1) {
            throw new IllegalArgumentException("bytes length cannot be < 1");
        }
        byte b = this.c[0];
        this.a = (short) ((b & 248) >> 3);
        if (this.a < (short) 0 || this.a > (short) 31) {
            throw new IllegalArgumentException("Invalid sequence value: " + this.a);
        }
        this.b = a.fromInt(b);
        switch (this.b) {
            case DATA:
            case RESET_REQUEST:
            case RESET_COMPLETE:
                return;
            default:
                if (bArr.length > 1) {
                    throw new IllegalArgumentException("payload is not allowed for type " + this.b);
                }
                return;
        }
    }

    int a() {
        int i = this.d + 1;
        this.d = i;
        return i;
    }

    a b() {
        return this.b;
    }

    short c() {
        return this.a;
    }

    int d() {
        return this.d;
    }

    byte[] e() {
        if (this.b.equals(a.DATA)) {
            return Arrays.copyOfRange(this.c, 1, this.c.length);
        }
        throw new IllegalStateException("No payload for packet of type " + this.b + "!");
    }

    byte[] f() {
        return this.c;
    }

    int g() {
        if (this.b.equals(a.RESET_REQUEST)) {
            return d.a(this.c[1]);
        }
        throw new IllegalStateException("No PPoGConnection version for packet of type " + this.b + "!");
    }

    boolean h() {
        if (this.b.equals(a.RESET_COMPLETE)) {
            return this.c.length >= 3;
        } else {
            throw new IllegalStateException("hasWindowSizes() not applicable for " + this.b + "!");
        }
    }

    int i() {
        if (this.b.equals(a.RESET_COMPLETE)) {
            return d.a(this.c[1]);
        }
        throw new IllegalStateException("No max RX window for packet of type " + this.b + "!");
    }

    int j() {
        if (this.b.equals(a.RESET_COMPLETE)) {
            return d.a(this.c[2]);
        }
        throw new IllegalStateException("No max TX window for packet of type " + this.b + "!");
    }

    public String toString() {
        return "PPoGPacket: sequence = " + this.a + " / type = " + this.b + k();
    }

    private String k() {
        if (this.b.equals(a.DATA)) {
            return " payload size = " + e().length;
        }
        return "";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.a != ((l) obj).a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a;
    }
}
