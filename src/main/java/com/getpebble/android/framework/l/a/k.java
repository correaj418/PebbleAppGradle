package com.getpebble.android.framework.l.a;

import android.content.Context;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class k extends o {
    private b a;
    private com.google.a.f.e b;
    private UUID c;
    private com.google.a.f.e d;
    private com.google.a.f.e e;
    private d f;
    private com.google.a.f.e g;
    private ByteBuffer h;
    private com.google.a.f.e i;
    private com.google.a.f.e j;

    public static abstract class c {
        public abstract byte[] a();
    }

    public static class a extends c {
        private final byte[] a;

        public a(byte[] bArr) {
            this.a = bArr;
        }

        public byte[] a() {
            return this.a;
        }

        public byte[] b() {
            return this.a;
        }
    }

    public enum b {
        OPEN_SESSION((byte) 1),
        DATA((byte) 2),
        CLOSE_SESSION((byte) 3),
        TIMEOUT((byte) 7),
        UNKNOWN((byte) -1);
        
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
            return UNKNOWN;
        }
    }

    public enum d {
        BYTE_ARRAY((byte) 0),
        UNSIGNED_INTEGER((byte) 2),
        SIGNED_INTEGER((byte) 3);
        
        private byte mCode;

        private d(byte b) {
            this.mCode = b;
        }

        public byte getCode() {
            return this.mCode;
        }

        public static d fromCode(byte b) {
            for (d dVar : values()) {
                if (dVar.getCode() == b) {
                    return dVar;
                }
            }
            return null;
        }
    }

    public static class e extends Exception {
    }

    public static class f extends c {
        private final int a;
        private final com.google.a.f.e b;

        public f(int i, com.google.a.f.e eVar) {
            this.a = i;
            this.b = eVar;
        }

        public byte[] a() {
            switch (this.b.intValue()) {
                case 1:
                    return new byte[]{Integer.valueOf(this.a).byteValue()};
                case 2:
                    return com.getpebble.android.bluetooth.b.b.a((short) this.a);
                default:
                    return com.getpebble.android.bluetooth.b.b.b(this.a);
            }
        }

        public int b() {
            return this.a;
        }
    }

    public static class g extends c {
        private final com.google.a.f.e a;
        private final com.google.a.f.e b;

        public g(com.google.a.f.e eVar, com.google.a.f.e eVar2) {
            this.a = eVar;
            this.b = eVar2;
        }

        public byte[] a() {
            switch (this.b.intValue()) {
                case 1:
                    return new byte[]{this.a.byteValue()};
                case 2:
                    return com.getpebble.android.bluetooth.b.b.b(this.a, ByteOrder.BIG_ENDIAN);
                default:
                    return com.getpebble.android.bluetooth.b.b.a(this.a, ByteOrder.BIG_ENDIAN);
            }
        }

        public com.google.a.f.e b() {
            return this.a;
        }
    }

    public k(com.getpebble.android.bluetooth.g.b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        b.order(ByteOrder.LITTLE_ENDIAN);
        byte b2 = b.get();
        this.a = b.fromCode(b2);
        switch (this.a) {
            case OPEN_SESSION:
                this.b = com.getpebble.android.bluetooth.b.b.a(b);
                this.c = com.getpebble.android.bluetooth.b.b.f(b);
                this.d = com.getpebble.android.bluetooth.b.b.c(b);
                this.e = com.getpebble.android.bluetooth.b.b.c(b);
                this.f = d.fromCode(b.get());
                this.g = com.getpebble.android.bluetooth.b.b.b(b);
                return;
            case DATA:
                this.b = com.getpebble.android.bluetooth.b.b.a(b);
                this.i = com.getpebble.android.bluetooth.b.b.c(b);
                b.mark();
                this.j = com.getpebble.android.bluetooth.b.b.c(b);
                this.h = ByteBuffer.allocate(b.remaining());
                this.h.put(b);
                return;
            case CLOSE_SESSION:
                this.b = com.getpebble.android.bluetooth.b.b.a(b);
                return;
            case UNKNOWN:
                com.getpebble.android.common.b.a.f.a("PebbleInboundDataloggingMessage", "Unknown command: " + b2);
                return;
            default:
                return;
        }
    }

    public b c() {
        return this.a;
    }

    public com.google.a.f.e d() {
        return this.b;
    }

    public UUID e() {
        return this.c;
    }

    public com.google.a.f.e f() {
        return this.d;
    }

    public com.google.a.f.e g() {
        return this.e;
    }

    public d h() {
        return this.f;
    }

    public com.google.a.f.e i() {
        return this.g;
    }

    public List<c> a(d dVar, com.google.a.f.e eVar) {
        int i = 0;
        if (b.DATA.equals(this.a)) {
            int capacity = this.h.capacity();
            Context K = com.getpebble.android.common.a.K();
            if (K != null && new com.getpebble.android.common.b.b.c(K).a(com.getpebble.android.common.b.b.c.a.DATALOGGING_DEBUG, false)) {
                com.getpebble.android.common.b.a.f.d("PebbleInboundDataloggingMessage", "Incoming datalogging payload. sessionId = " + this.b + " appUuid = " + this.c + " timestamp = " + this.d + " logTag = " + this.e + " dataType = " + this.f + " itemSize = " + this.g + " payload = " + com.getpebble.android.bluetooth.b.b.c(this.h.array()));
            }
            this.h.position(0);
            this.h.order(ByteOrder.LITTLE_ENDIAN);
            int intValue = capacity / eVar.intValue();
            int intValue2 = capacity % eVar.intValue();
            if (intValue <= 0) {
                com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "Invalid numRecordsStored: " + intValue + " (payloadSize = " + capacity + " itemSize = " + eVar + ")");
                throw new e();
            } else if (intValue2 != 0) {
                com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "Invalid remainder bytes: " + intValue2 + " (payloadSize = " + capacity + " itemSize = " + eVar + ")");
                throw new e();
            } else {
                byte[] array = this.h.array();
                int a = new com.getpebble.android.framework.install.d(false).a(array, array.length).a();
                if (a != this.j.intValue()) {
                    com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "Invalid crc: " + a + " (expected: " + this.j.intValue() + ") for bytes: " + com.getpebble.android.bluetooth.b.b.c(array) + " (payloadSize = " + capacity + " itemSize = " + eVar + ")");
                    i = new com.getpebble.android.framework.install.d(true).a(array, array.length).a();
                    com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "... alt crc calc = " + i);
                    Map hashMap = new HashMap();
                    hashMap.put("receivedCrc", Integer.valueOf(a));
                    hashMap.put("expectedCrc", Integer.valueOf(this.j.intValue()));
                    hashMap.put("altCalcCrc", Integer.valueOf(i));
                    hashMap.put("receivedBytes", com.getpebble.android.bluetooth.b.b.c(array));
                    hashMap.put("payloadSize", Integer.valueOf(capacity));
                    hashMap.put("itemSize", eVar);
                    com.getpebble.android.common.b.a.a.c.c(hashMap);
                    throw new e();
                }
                List<c> linkedList = new LinkedList();
                while (i < intValue) {
                    linkedList.add(a(dVar, eVar, this.h));
                    i++;
                }
                i = this.h.remaining();
                if (i == 0) {
                    return linkedList;
                }
                com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "Remaining bytes not expected: " + i + " (payloadSize = " + capacity + " itemSize = " + eVar + ")");
                throw new e();
            }
        }
        com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "Not a data message!");
        throw new e();
    }

    private static c a(d dVar, com.google.a.f.e eVar, ByteBuffer byteBuffer) {
        switch (dVar) {
            case BYTE_ARRAY:
                byte[] bArr = new byte[eVar.intValue()];
                byteBuffer.get(bArr);
                return new a(bArr);
            case UNSIGNED_INTEGER:
                com.google.a.f.e a;
                switch (eVar.intValue()) {
                    case 1:
                        a = com.getpebble.android.bluetooth.b.b.a(byteBuffer);
                        break;
                    case 2:
                        a = com.getpebble.android.bluetooth.b.b.b(byteBuffer);
                        break;
                    case 4:
                        a = com.getpebble.android.bluetooth.b.b.c(byteBuffer);
                        break;
                    default:
                        com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "Invalid item size: " + eVar);
                        throw new e();
                }
                return new g(a, eVar);
            case SIGNED_INTEGER:
                int i;
                switch (eVar.intValue()) {
                    case 1:
                        i = byteBuffer.get();
                        break;
                    case 2:
                        i = byteBuffer.getShort();
                        break;
                    case 4:
                        i = byteBuffer.getInt();
                        break;
                    default:
                        com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "Invalid item size: " + eVar);
                        throw new e();
                }
                return new f(i, eVar);
            default:
                com.getpebble.android.common.b.a.f.b("PebbleInboundDataloggingMessage", "Invalid data type");
                throw new e();
        }
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.DATA_LOG;
    }

    protected int b() {
        return 1;
    }
}
