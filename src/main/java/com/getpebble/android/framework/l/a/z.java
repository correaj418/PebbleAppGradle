package com.getpebble.android.framework.l.a;

public enum z {
    INVALID((byte) 0),
    SPEEX_INFO((byte) 1),
    TRANSCRIPTION((byte) 2),
    APP_UUID((byte) 3),
    REMINDER((byte) 4),
    DATE((byte) 5);
    
    private final byte mByte;

    private z(byte b) {
        this.mByte = b;
    }

    public static z from(byte b) {
        for (z zVar : values()) {
            if (b == zVar.mByte) {
                return zVar;
            }
        }
        return INVALID;
    }

    public byte toByte() {
        return this.mByte;
    }
}
