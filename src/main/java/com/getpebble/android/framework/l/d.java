package com.getpebble.android.framework.l;

public class d {

    public enum a {
        IS_VISIBLE((byte) 0),
        IS_FLOATING((byte) 1),
        IS_ALL_DAY((byte) 2),
        FROM_WATCH((byte) 3),
        FROM_ANCS((byte) 4),
        PERSIST_QUICK_VIEW((byte) 5);
        
        public static final byte MAX_NUMBER_OF_FLAGS = (byte) 8;
        public final byte bitIndex;

        private a(byte b) {
            this.bitIndex = b;
        }
    }
}
