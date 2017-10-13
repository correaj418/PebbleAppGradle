package com.getpebble.android.h;

public enum l {
    GRAM_CALORIES {
        public double toKiloCalories(long j) {
            return ((double) j) / 1000.0d;
        }
    },
    KILO_CALORIES {
        public long toGramCalories(int i) {
            return (long) (i * 1000);
        }
    };

    public double toKiloCalories(long j) {
        throw new AbstractMethodError();
    }

    public long toGramCalories(int i) {
        throw new AbstractMethodError();
    }
}
