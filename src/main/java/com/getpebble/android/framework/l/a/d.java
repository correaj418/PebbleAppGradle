package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.framework.appmessage.AppMessage;
import com.getpebble.android.framework.appmessage.AppMessage.a;
import com.getpebble.android.framework.appmessage.c;
import java.nio.ByteBuffer;
import java.util.UUID;

public class d extends o {
    private AppMessage a;

    public d(b bVar) {
        UUID uuid;
        c cVar = null;
        super(bVar);
        ByteBuffer b = bVar.b();
        a fromByte = a.fromByte(b.get());
        byte b2 = b.get();
        if (fromByte == a.ACK || fromByte == a.NACK) {
            uuid = null;
        } else {
            uuid = com.getpebble.android.bluetooth.b.b.f(b);
            cVar = com.getpebble.android.framework.appmessage.a.a(b);
        }
        this.a = new AppMessage(b2, uuid, fromByte, cVar);
    }

    public AppMessage c() {
        return this.a;
    }

    com.getpebble.android.bluetooth.g.a a() {
        return com.getpebble.android.bluetooth.g.a.APP_MESSAGE;
    }

    protected int b() {
        return 2;
    }
}
