package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.google.a.f.d;
import java.util.List;
import java.util.UUID;

public class g extends r {
    private final a a;
    private final List<UUID> e;

    public enum a {
        SEND_ORDER(1);
        
        private final int id;

        private a(int i) {
            this.id = i;
        }

        public byte getId() {
            return (byte) this.id;
        }
    }

    private g(a aVar, List<UUID> list) {
        super(com.getpebble.android.bluetooth.g.a.APP_REORDER);
        this.a = aVar;
        this.e = list;
    }

    public static g a(List<UUID> list) {
        return new g(a.SEND_ORDER, list);
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.a.getId()));
            a(Byte.valueOf(d.a((long) this.e.size())));
            for (UUID a : this.e) {
                a(b.a(a));
            }
        }
        return super.c_();
    }
}
