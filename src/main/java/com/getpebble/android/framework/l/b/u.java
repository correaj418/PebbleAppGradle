package com.getpebble.android.framework.l.b;

import com.getpebble.android.notifications.b.c.c;

public class u extends r {
    private c a;
    private long e;
    private int f;
    private b g;
    private a h;

    public enum a {
        UNKNOWN((byte) 0),
        OFF((byte) 1),
        ON((byte) 2),
        ALL((byte) 3);
        
        private byte mMode;

        private a(byte b) {
            this.mMode = b;
        }

        public byte getMode() {
            return this.mMode;
        }
    }

    public enum b {
        UNKNOWN((byte) 0),
        OFF((byte) 1),
        ON((byte) 2);
        
        private byte mMode;

        private b(byte b) {
            this.mMode = b;
        }

        public byte getMode() {
            return this.mMode;
        }
    }

    public u(c cVar, long j, int i, b bVar, a aVar) {
        super(com.getpebble.android.bluetooth.g.a.MUSIC_CONTROL);
        this.a = cVar;
        this.e = j;
        this.f = i;
        this.g = bVar;
        this.h = aVar;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 17));
            a(Byte.valueOf(this.a.getState()));
            a(com.getpebble.android.bluetooth.b.b.c((int) this.e));
            a(com.getpebble.android.bluetooth.b.b.c(this.f));
            a(Byte.valueOf(this.g.getMode()));
            a(Byte.valueOf(this.h.getMode()));
        }
        return super.c_();
    }
}
