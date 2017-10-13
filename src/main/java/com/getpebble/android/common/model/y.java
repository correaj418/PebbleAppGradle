package com.getpebble.android.common.model;

import java.util.EnumSet;

public enum y {
    HEART_RATE_MONITORING;
    
    public static final EnumSet<y> ALL_HARDWARE_CAPABILITIES = null;

    static {
        ALL_HARDWARE_CAPABILITIES = EnumSet.allOf(y.class);
    }
}
