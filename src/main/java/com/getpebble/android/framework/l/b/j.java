package com.getpebble.android.framework.l.b;

import com.google.a.f.d;

public class j extends r {
    static final int a = ((r.a(com.getpebble.android.bluetooth.g.a.BLOBDB_V1) - 2) - 255);
    private final byte[] e;
    private final byte f;
    private final byte g;
    private final byte[] h;
    private final byte[] i;

    public enum a {
        INSERT((byte) 1),
        DELETE((byte) 4),
        CLEAR((byte) 5);
        
        private final byte mCmd;

        private a(byte b) {
            this.mCmd = b;
        }

        public byte toByte() {
            return this.mCmd;
        }
    }

    public enum b {
        PINS((byte) 1),
        APPS((byte) 2),
        REMINDERS((byte) 3),
        NOTIFICATIONS((byte) 4),
        WEATHER_APP((byte) 5),
        NOTIF_PREF((byte) 6),
        PREFERENCES((byte) 7),
        CONTACTS((byte) 8),
        WATCH_APPS_DATA((byte) 9),
        HEALTH_STATS((byte) 10),
        APP_GLANCES((byte) 11),
        UNKNOWN((byte) -1);
        
        private final byte id;

        private b(byte b) {
            this.id = b;
        }

        public byte id() {
            return this.id;
        }

        public static b from(byte b) {
            for (b bVar : values()) {
                if (bVar.id() == b) {
                    return bVar;
                }
            }
            return UNKNOWN;
        }
    }

    private j(a aVar, byte[] bArr, b bVar, byte[] bArr2, byte[] bArr3) {
        super(com.getpebble.android.bluetooth.g.a.BLOBDB_V1);
        this.e = bArr;
        this.f = aVar.toByte();
        this.g = bVar.id();
        this.h = bArr2;
        this.i = bArr3;
    }

    public static j a(byte[] bArr, b bVar, byte[] bArr2, byte[] bArr3) {
        return new j(a.INSERT, bArr, bVar, bArr2, bArr3);
    }

    public static j a(byte[] bArr, b bVar, byte[] bArr2) {
        return new j(a.DELETE, bArr, bVar, bArr2, null);
    }

    public static j a(byte[] bArr, b bVar) {
        return new j(a.CLEAR, bArr, bVar, null, null);
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.f));
            if (this.e.length != 2) {
                throw new IllegalArgumentException("Invalid cookie length: " + this.e.length);
            }
            a(this.e);
            a(Byte.valueOf(this.g));
            if (this.f != a.CLEAR.toByte()) {
                if (this.h == null) {
                    throw new IllegalArgumentException(String.format("Cannot create message with null key; command 0x%x, database 0x%x", new Object[]{Byte.valueOf(this.f), Byte.valueOf(this.g)}));
                } else if (this.h.length <= 0 || this.h.length > 255) {
                    throw new IllegalArgumentException(String.format("Invalid key length %d", new Object[]{Integer.valueOf(this.h.length)}));
                } else {
                    a(Byte.valueOf(d.a((long) this.h.length)));
                    a(this.h);
                    if (this.i != null) {
                        if (this.i.length >= a) {
                            throw new IllegalArgumentException(String.format("Invalid value length %d", new Object[]{Integer.valueOf(this.i.length)}));
                        }
                        a(com.getpebble.android.bluetooth.b.b.a(this.i.length));
                        a(this.i);
                    }
                }
            }
        }
        return super.c_();
    }

    public static int b() {
        return a;
    }
}
