package com.getpebble.android.framework.l.b;

import android.graphics.Bitmap;

public class d extends r {
    private final b a;
    private final a e;
    private String f;
    private Bitmap g;

    public enum a {
        SPORTS((byte) 0),
        GOLF((byte) 1),
        UNKNOWN((byte) -1);
        
        private byte mType;

        private a(byte b) {
            this.mType = b;
        }

        public byte getValue() {
            return this.mType;
        }

        public static a fromByte(byte b) {
            for (a aVar : values()) {
                if (aVar.mType == b) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    public enum b {
        NAME((byte) 0),
        ICON(Byte.MIN_VALUE);
        
        private byte mField;

        private b(byte b) {
            this.mField = b;
        }

        public byte getValue() {
            return this.mField;
        }
    }

    private d(b bVar, a aVar) {
        super(com.getpebble.android.bluetooth.g.a.APP_CUSTOMIZE);
        if (bVar == null) {
            throw new IllegalArgumentException("field cannot be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("appType cannot be null");
        } else if (a.UNKNOWN.equals(aVar)) {
            throw new IllegalArgumentException("appType cannot be UNKNOWN");
        } else {
            this.a = bVar;
            this.e = aVar;
        }
    }

    public static d a(a aVar, String str) {
        if (str == null) {
            throw new IllegalArgumentException("title cannot be null");
        }
        d dVar = new d(b.NAME, aVar);
        dVar.f = str;
        return dVar;
    }

    public static d a(a aVar, Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("icon cannot be null");
        }
        d dVar = new d(b.ICON, aVar);
        dVar.g = bitmap;
        return dVar;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) (this.a.getValue() | this.e.getValue())));
            switch (this.a) {
                case NAME:
                    com.getpebble.android.bluetooth.b.b.a((com.getpebble.android.bluetooth.b.b.a) this, this.f);
                    break;
                case ICON:
                    b(com.getpebble.android.framework.o.a.a(this.g).a());
                    break;
            }
        }
        return super.c_();
    }
}
