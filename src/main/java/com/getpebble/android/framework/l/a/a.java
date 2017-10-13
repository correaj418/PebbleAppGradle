package com.getpebble.android.framework.l.a;

public enum a {
    FIRMWARE_UPDATE_STOPPED((byte) 0),
    FIRMWARE_UPDATE_RUNNING((byte) 1),
    FIRMWARE_UPDATE_CANCELLED((byte) 2),
    UNKNOWN((byte) -1);
    
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
        return UNKNOWN;
    }

    public static a from(v vVar) {
        if (vVar.c() == null || vVar.c() != com.getpebble.android.framework.l.a.v.a.FIRMWARE_UPDATE_START_ACK) {
            throw new IllegalArgumentException("Firmware update start cannot be created for system message of type: " + vVar.c());
        }
        byte[] d = vVar.d();
        if (d == null) {
            throw new IllegalArgumentException("Firmware update response expected non-null type data");
        } else if (d.length == 1) {
            return fromCode(d[0]);
        } else {
            throw new IllegalArgumentException("Firmware update response expected length 1; actual length: " + d.length);
        }
    }
}
