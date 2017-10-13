package com.getpebble.android.bluetooth.e;

public enum c {
    STATE_DISCONNECTED(0),
    STATE_CONNECTING(1),
    STATE_CONNECTED(2),
    STATE_DISCONNECTING(3),
    UNKNOWN(-1);
    
    public final int mCode;

    private c(int i) {
        this.mCode = i;
    }

    public static c fromCode(int i) {
        for (c cVar : values()) {
            if (cVar.mCode == i) {
                return cVar;
            }
        }
        return UNKNOWN;
    }

    public String toString() {
        return name() + " (" + this.mCode + ")";
    }
}
