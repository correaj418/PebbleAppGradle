package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ah;
import java.nio.ByteBuffer;

public class u extends o {
    private a a;
    private ByteBuffer b;
    private ah c = null;
    private com.getpebble.android.bluetooth.g.a d;

    public enum a {
        READ_SUCCESS(1),
        WRITE_SUCCESS(3),
        REMOVE_SUCCESS(5),
        ERROR(-1);
        
        private final int id;

        private a(int i) {
            this.id = i;
        }

        public int getId() {
            return this.id;
        }

        public static a fromId(int i) {
            for (a aVar : values()) {
                if (aVar.getId() == i) {
                    return aVar;
                }
            }
            return ERROR;
        }
    }

    public u(b bVar) {
        super(bVar);
        this.d = com.getpebble.android.bluetooth.g.a.fromCode(bVar.a());
        this.b = bVar.b();
        this.a = a.fromId(this.b.get() & 255);
        if (this.a == a.ERROR) {
            f.b("PebbleInboundRegistryMessage", "PebbleInboundRegistryMessage error");
        }
    }

    protected void b(b bVar) {
        com.getpebble.android.bluetooth.g.a fromCode = com.getpebble.android.bluetooth.g.a.fromCode(bVar.a());
        if (!fromCode.equals(com.getpebble.android.bluetooth.g.a.FCT_REG) && !fromCode.equals(com.getpebble.android.bluetooth.g.a.SYS_REG)) {
            throw new IllegalArgumentException("ProtocolMessage's endpointId must be " + com.getpebble.android.bluetooth.g.a.FCT_REG.name() + " or " + com.getpebble.android.bluetooth.g.a.SYS_REG.name());
        }
    }

    public ah c() {
        if (this.c == null) {
            this.c = ah.COLOR_UNKNOWN;
            if (this.a.equals(a.READ_SUCCESS)) {
                int i = this.b.get() & 255;
                f.c("PebbleInboundRegistryMessage", "RegistryColorResponse read OK valueLength = " + i);
                if (i == 4) {
                    i = this.b.getInt();
                    f.c("PebbleInboundRegistryMessage", "PebbleInboundRegistryMessage: " + i);
                    this.c = ah.fromInt(i);
                }
            }
        }
        return this.c;
    }

    public com.getpebble.android.bluetooth.g.a a() {
        return this.d;
    }

    protected int b() {
        return 1;
    }
}
