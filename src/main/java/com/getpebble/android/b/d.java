package com.getpebble.android.b;

public enum d {
    UNKNOWN(0),
    DISCONNECTED(10),
    CONNECTING(20),
    CONNECTED(30);
    
    private final int mStatus;

    private d(int i) {
        this.mStatus = i;
    }

    public int getIntValue() {
        return this.mStatus;
    }

    public static d fromInt(int i) {
        for (d dVar : values()) {
            if (dVar.getIntValue() == i) {
                return dVar;
            }
        }
        return UNKNOWN;
    }
}
