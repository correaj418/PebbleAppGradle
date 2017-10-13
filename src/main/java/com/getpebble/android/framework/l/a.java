package com.getpebble.android.framework.l;

public enum a {
    SUCCESS((byte) 1),
    FAILURE((byte) 2),
    INVALID_OPERATION((byte) 3),
    INVALID_DB_ID((byte) 4),
    INVALID_DATA((byte) 5),
    KEY_DOES_NOT_EXIST((byte) 6),
    DATABASE_FULL((byte) 7),
    DATA_STALE((byte) 8),
    DB_NOT_SUPPORTED((byte) 9),
    DB_LOCKED((byte) 10),
    TRY_LATER((byte) 11),
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
