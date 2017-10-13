package com.getpebble.android.framework.l.b;

import com.getpebble.android.common.framework.install.app.b.a;
import com.getpebble.android.common.model.am.b;
import com.getpebble.android.common.model.am.c;
import com.google.a.f.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ak {
    private final ByteBuffer a = ByteBuffer.allocate(131);

    private ak() {
    }

    public static ak a(c cVar, a aVar) {
        b.a a = cVar.H.a(aVar);
        if (a == null) {
            return null;
        }
        ak akVar = new ak();
        akVar.a.order(ByteOrder.LITTLE_ENDIAN);
        akVar.a.put(com.getpebble.android.bluetooth.b.b.a(cVar.b));
        akVar.a.put(com.getpebble.android.bluetooth.b.b.c(a.b));
        akVar.a.put(com.getpebble.android.bluetooth.b.b.c(cVar.E));
        akVar.a.put(d.a((long) cVar.l.a()));
        akVar.a.put(d.a((long) cVar.l.b()));
        akVar.a.put(d.a((long) a.c.a()));
        akVar.a.put(d.a((long) a.c.b()));
        akVar.a.put((byte) 0);
        akVar.a.put((byte) 0);
        byte[] b = com.getpebble.android.bluetooth.b.b.b(cVar.c, 96);
        akVar.a.put(b);
        int length = 96 - b.length;
        for (int i = 0; i < length; i++) {
            akVar.a.put((byte) 0);
        }
        akVar.a.flip();
        return akVar;
    }

    public byte[] a() {
        return Arrays.copyOf(this.a.array(), this.a.limit());
    }
}
