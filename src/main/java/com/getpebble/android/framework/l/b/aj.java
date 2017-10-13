package com.getpebble.android.framework.l.b;

public enum aj {
    ANCS_DISMISS((byte) 1),
    GENERIC((byte) 2),
    RESPONSE((byte) 3),
    DISMISS((byte) 4),
    HTTP((byte) 5),
    SNOOZE((byte) 6),
    OPEN_WATCH_APP((byte) 7),
    EMPTY((byte) 8),
    REMOVE((byte) 9),
    OPEN_PIN((byte) 10),
    COMPLETE((byte) 16),
    POSTPONE((byte) 17),
    REMOTE_REMOVE((byte) 18),
    UNKNOWN((byte) 0);
    
    final byte mByte;

    private aj(byte b) {
        this.mByte = b;
    }

    public static aj from(byte b) {
        for (aj ajVar : values()) {
            if (ajVar.mByte == b) {
                return ajVar;
            }
        }
        return null;
    }
}
