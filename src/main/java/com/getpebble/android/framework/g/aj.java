package com.getpebble.android.framework.g;

public enum aj {
    FIRST_PARTY(false),
    THIRD_PARTY(true);
    
    public final boolean flag;

    private aj(boolean z) {
        this.flag = z;
    }

    public static aj fromFlag(boolean z) {
        for (aj ajVar : values()) {
            if (ajVar.flag == z) {
                return ajVar;
            }
        }
        return THIRD_PARTY;
    }
}
