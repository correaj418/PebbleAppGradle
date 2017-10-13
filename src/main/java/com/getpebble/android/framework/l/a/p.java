package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;

public class p extends o {
    private a a;

    public enum a {
        UNKNOWN((byte) 0),
        PLAY_PAUSE((byte) 1),
        PAUSE((byte) 2),
        PLAY((byte) 3),
        NEXT_TRACK((byte) 4),
        PREVIOUS_TRACK((byte) 5),
        VOLUME_UP((byte) 6),
        VOLUME_DOWN((byte) 7),
        GET_ALL_INFORMATION((byte) 8);
        
        private byte command;

        private a(byte b) {
            this.command = b;
        }

        public byte getCommand() {
            return this.command;
        }

        public static a fromByte(byte b) {
            for (a aVar : values()) {
                if (aVar.command == b) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    public p(b bVar) {
        super(bVar);
        this.a = a.fromByte(bVar.b().get());
    }

    public a c() {
        return this.a;
    }

    public com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.MUSIC_CONTROL;
    }

    protected int b() {
        return 1;
    }
}
