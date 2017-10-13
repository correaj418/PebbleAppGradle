package com.getpebble.android.h;

public enum k {
    INCHES {
        public long toMillimetres(long j) {
            return Math.round(((double) j) * 25.4d);
        }
    },
    METRES {
        public long toCentimetres(long j) {
            return 100 * j;
        }

        public long toMillimetres(long j) {
            return 1000 * j;
        }
    },
    CENTIMETRES {
        public long toMillimetres(long j) {
            return 10 * j;
        }

        public long toMetres(long j) {
            return j / 100;
        }
    },
    MILLIMETRES {
        public long toMetres(long j) {
            return j / 1000;
        }

        public long toCentimetres(long j) {
            return j / 10;
        }

        public long toInches(long j) {
            return Math.round(((double) j) * 0.0393701d);
        }
    };

    public long toMetres(long j) {
        throw new AbstractMethodError();
    }

    public long toCentimetres(long j) {
        throw new AbstractMethodError();
    }

    public long toMillimetres(long j) {
        throw new AbstractMethodError();
    }

    public long toInches(long j) {
        throw new AbstractMethodError();
    }
}
