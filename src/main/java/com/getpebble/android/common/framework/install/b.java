package com.getpebble.android.common.framework.install;

public enum b {
    FIRMWARE((byte) 1),
    RECOVERY((byte) 2),
    SYS_RESOURCES((byte) 3),
    APP_RESOURCES((byte) 4),
    APP((byte) 5),
    FILE((byte) 6),
    WORKER((byte) 7);
    
    private final byte mId;

    private b(byte b) {
        this.mId = b;
    }

    public byte getId() {
        return this.mId;
    }

    public static b fromId(byte b) {
        for (b bVar : values()) {
            if (bVar.getId() == b) {
                return bVar;
            }
        }
        return null;
    }
}
