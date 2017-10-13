package com.getpebble.android.framework.l.a;

import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.bluetooth.g.b;
import com.getpebble.android.framework.l.b.ao;
import com.getpebble.android.framework.timeline.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import java.util.UUID;

public class w extends o {
    private final UUID a;
    private final int b;
    private final Map<String, String> c;

    a a() {
        return a.TIMELINE_ACTIONS;
    }

    protected int b() {
        return f();
    }

    public w(b bVar, h hVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        b.order(ByteOrder.LITTLE_ENDIAN);
        byte b2 = b.get();
        if (b2 != (byte) 2) {
            throw new IllegalArgumentException("Invalid command byte: " + b2);
        }
        this.a = com.getpebble.android.bluetooth.b.b.f(b);
        this.b = b.get();
        this.c = new ao(hVar).a(b, com.getpebble.android.common.framework.install.app.b.a.BASALT);
    }

    public w(b bVar) {
        super(bVar);
        ByteBuffer b = bVar.b();
        b.order(ByteOrder.LITTLE_ENDIAN);
        byte b2 = b.get();
        if (b2 != (byte) 2) {
            throw new IllegalArgumentException("Invalid command byte: " + b2);
        }
        this.a = com.getpebble.android.bluetooth.b.b.f(b);
        this.b = b.get();
        this.c = null;
    }

    public UUID c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public Map<String, String> e() {
        return this.c;
    }

    static int f() {
        return 18;
    }
}
