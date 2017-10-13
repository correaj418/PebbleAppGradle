package com.getpebble.android.framework.l;

public class b {

    public enum a {
        WRITE((byte) 8),
        WRITEBACK((byte) 9),
        DATABASE_UNLOCKED((byte) 10),
        DIRTY_DATABASES_RESPONSE((byte) (b.DIRTY_DATABASES.toByte() | -128)),
        START_SYNC_RESPONSE((byte) (b.START_SYNC.toByte() | -128)),
        UNKNOWN((byte) -1);
        
        private final byte mCommand;

        private a(byte b) {
            this.mCommand = b;
        }

        public byte toByte() {
            return this.mCommand;
        }

        public static a from(byte b) {
            for (a aVar : values()) {
                if (aVar.toByte() == b) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    public enum b {
        DIRTY_DATABASES((byte) 6),
        START_SYNC((byte) 7),
        WRITE_RESPONSE((byte) (a.WRITE.toByte() | -128)),
        WRITEBACK_RESPONSE((byte) (a.WRITEBACK.toByte() | -128)),
        DATABASE_UNLOCKED_RESPONSE((byte) (a.DATABASE_UNLOCKED.toByte() | -128)),
        UNKNOWN((byte) -1);
        
        private final byte mCommand;

        private b(byte b) {
            this.mCommand = b;
        }

        public byte toByte() {
            return this.mCommand;
        }

        public static b from(byte b) {
            for (b bVar : values()) {
                if (bVar.toByte() == b) {
                    return bVar;
                }
            }
            return UNKNOWN;
        }
    }
}
