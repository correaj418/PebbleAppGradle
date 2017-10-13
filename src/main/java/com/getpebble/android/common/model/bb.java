package com.getpebble.android.common.model;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.p;
import com.google.a.f.d;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.UUID;

public class bb implements ay {
    @c(a = "locations")
    protected final List<UUID> a;

    protected bb(List<UUID> list) {
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bb)) {
            return false;
        }
        return this.a.equals(((bb) obj).a);
    }

    public byte[] toBytes() {
        int size = this.a.size();
        if (size > 6) {
            f.b("WeatherAppEntry", "toBytes: More than max number of locations! Ignoring excess");
            size = 6;
        }
        ByteBuffer allocate = ByteBuffer.allocate(97);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(d.a((long) size));
        for (int i = 0; i < size; i++) {
            allocate.put(b.a((UUID) this.a.get(i)));
        }
        return allocate.array();
    }

    public String toJson() {
        return p.a(this);
    }

    public int hashCode() {
        return toJson().hashCode();
    }

    public String getKey() {
        return "weatherApp";
    }

    public static synchronized void a(List<UUID> list) {
        synchronized (bb.class) {
            az.a(new bb(list), a.K().getContentResolver());
        }
    }
}
