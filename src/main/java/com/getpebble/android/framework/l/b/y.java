package com.getpebble.android.framework.l.b;

import com.getpebble.android.PebbleApplication;
import com.google.a.f.e;
import java.util.ArrayList;
import java.util.List;

public class y extends r {
    private static final a a = a.ANDROID;
    private com.getpebble.android.common.d.a e;
    private final List<b> f = new ArrayList();
    private final List<c> g = new ArrayList();

    public enum a {
        UNKNOWN(0),
        IOS(1),
        ANDROID(2),
        OSX(3),
        LINUX(4),
        WINDOWS(5);
        
        private final int id;

        private a(int i) {
            this.id = i;
        }

        public int getId() {
            return this.id;
        }
    }

    public enum b {
        TELEPHONY(16),
        SMS(32),
        GPS(64),
        BTLE(128),
        CAMERA_FRONT(240),
        CAMERA_REAR(256),
        ACCEL(512),
        GYRO(1024),
        COMPASS(2048);
        
        private final int id;

        private b(int i) {
            this.id = i;
        }

        public int getId() {
            return this.id;
        }
    }

    public enum c {
        GEOLOCATION(1),
        GAMMA_RAY(Integer.MIN_VALUE);
        
        private final int id;

        private c(int i) {
            this.id = i;
        }

        public int getId() {
            return this.id;
        }
    }

    public y(com.getpebble.android.common.d.a aVar) {
        super(com.getpebble.android.bluetooth.g.a.PHONE_VERSION);
        this.e = aVar;
    }

    private final e b() {
        int id = 0 | a.getId();
        int i = id;
        for (b id2 : this.f) {
            i = id2.getId() | i;
        }
        return e.a(i);
    }

    private final e h() {
        int i = 0;
        for (c id : this.g) {
            i = id.getId() | i;
        }
        return e.a(i);
    }

    private static byte[] i() {
        boolean[] zArr = new boolean[64];
        zArr[0] = true;
        zArr[1] = true;
        zArr[2] = true;
        zArr[3] = true;
        zArr[5] = true;
        zArr[7] = true;
        zArr[8] = true;
        zArr[11] = PebbleApplication.w().B();
        zArr[12] = false;
        zArr[13] = true;
        zArr[14] = true;
        return com.getpebble.android.bluetooth.b.b.a(zArr);
    }

    public byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) 1));
            a(com.getpebble.android.bluetooth.b.b.a(e.c));
            a(com.getpebble.android.bluetooth.b.b.a(h()));
            a(com.getpebble.android.bluetooth.b.b.a(b()));
            a(Byte.valueOf((byte) 2));
            a(Byte.valueOf((byte) this.e.a()));
            a(Byte.valueOf((byte) this.e.b()));
            a(Byte.valueOf((byte) this.e.c()));
            a(i());
        }
        return super.c_();
    }
}
