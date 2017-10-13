package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import java.util.UUID;

public class h extends r {
    private final UUID a;
    private final a e;

    public enum a {
        START_APP(1),
        STOP_APP(2),
        FETCH_RUNNING_APP(3);
        
        private final int id;

        private a(int i) {
            this.id = i;
        }

        public byte getId() {
            return (byte) this.id;
        }
    }

    private h(a aVar, UUID uuid) {
        super(com.getpebble.android.bluetooth.g.a.APP_RUN_STATE);
        this.a = uuid;
        this.e = aVar;
    }

    public static h a(UUID uuid) {
        return new h(a.START_APP, uuid);
    }

    public static h b(UUID uuid) {
        return new h(a.STOP_APP, uuid);
    }

    public static h b() {
        return new h(a.FETCH_RUNNING_APP, null);
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.e.getId()));
            if (this.e.equals(a.START_APP) || this.e.equals(a.STOP_APP)) {
                a(b.a(this.a));
            }
        }
        return super.c_();
    }
}
