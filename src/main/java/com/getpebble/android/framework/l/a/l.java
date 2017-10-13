package com.getpebble.android.framework.l.a;

import com.google.a.f.e;
import java.nio.ByteBuffer;

public class l extends o {
    private b a;
    private byte b;
    private a c;
    private e d;
    private e e;
    private ByteBuffer f;

    public enum a {
        NO_ERROR((byte) 0),
        MALFORMED_REQUEST((byte) 1),
        ALREADY_IN_PROGRESS((byte) 2),
        IMAGE_DOES_NOT_EXIST((byte) 3),
        IMAGE_CORRUPT((byte) 4);
        
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

    public enum b {
        IMAGE_INFO((byte) 1),
        IMAGE_DATA((byte) 2);
        
        private byte mCode;

        private b(byte b) {
            this.mCode = b;
        }

        public byte getCode() {
            return this.mCode;
        }

        public static b fromCode(byte b) {
            for (b bVar : values()) {
                if (bVar.getCode() == b) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public l(com.getpebble.android.bluetooth.g.b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        this.a = b.fromCode(b.get());
        this.b = b.get();
        if (this.a.equals(b.IMAGE_INFO)) {
            this.c = a.fromCode(b.get());
            this.d = com.getpebble.android.bluetooth.b.b.c(b);
        } else if (this.a.equals(b.IMAGE_DATA)) {
            this.e = com.getpebble.android.bluetooth.b.b.c(b);
            this.f = ByteBuffer.allocate(b.remaining());
            this.f.put(b);
            this.f.position(0);
        }
    }

    public b c() {
        return this.a;
    }

    public byte d() {
        return this.b;
    }

    public a e() {
        return this.c;
    }

    public e f() {
        return this.d;
    }

    public e g() {
        return this.e;
    }

    public ByteBuffer h() {
        return this.f;
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.GET_BYTES;
    }

    protected int b() {
        return 7;
    }
}
