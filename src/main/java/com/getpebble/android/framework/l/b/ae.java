package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.framework.timeline.f;
import com.getpebble.android.framework.timeline.h;
import com.google.a.f.d;
import java.nio.ByteBuffer;
import java.util.UUID;

public class ae extends r {
    private final UUID a;
    private final a e;
    private final f f;
    private final h g;
    private final com.getpebble.android.common.framework.install.app.b.a h;

    public enum a {
        ACK((byte) 0),
        NACK((byte) 1);
        
        private final byte id;

        private a(byte b) {
            this.id = b;
        }

        public byte getId() {
            return this.id;
        }
    }

    protected ae(UUID uuid, a aVar, h hVar, f fVar, com.getpebble.android.common.framework.install.app.b.a aVar2) {
        super(com.getpebble.android.bluetooth.g.a.TIMELINE_ACTIONS);
        this.a = uuid;
        this.e = aVar;
        this.g = hVar;
        this.f = fVar;
        this.h = aVar2;
    }

    public static ae a(UUID uuid, a aVar, h hVar, f fVar, com.getpebble.android.common.framework.install.app.b.a aVar2) {
        return new ae(uuid, aVar, hVar, fVar, aVar2);
    }

    public synchronized byte[] c_() {
        byte[] c_;
        int i = 0;
        synchronized (this) {
            if (!d()) {
                a(Byte.valueOf((byte) 17));
                a(b.a(this.a));
                a(Byte.valueOf(this.e.getId()));
                ByteBuffer byteBuffer = null;
                if (this.f != null) {
                    byteBuffer = ByteBuffer.allocate(j.b());
                    i = new ap().serializeAttributes(byteBuffer, this.f.toArray(), this.g, this.h);
                    byteBuffer.flip();
                }
                a(Byte.valueOf(d.a((long) i)));
                if (this.f != null) {
                    b(byteBuffer);
                }
            }
            c_ = super.c_();
        }
        return c_;
    }
}
