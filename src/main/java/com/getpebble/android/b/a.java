package com.getpebble.android.b;

public enum a {
    DISCONNECT(0),
    CONNECT(1),
    UNKNOWN(100);
    
    private final int mGoal;

    private a(int i) {
        this.mGoal = i;
    }

    public int getIntValue() {
        return this.mGoal;
    }

    public static a fromInt(int i) {
        for (a aVar : values()) {
            if (aVar.getIntValue() == i) {
                return aVar;
            }
        }
        return UNKNOWN;
    }
}
