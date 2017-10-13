package com.getpebble.android.framework.health;

import com.getpebble.android.common.model.j;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class b implements j {
    @c(a = "unitsDistance")
    public boolean a = true;

    public b(boolean z) {
        this.a = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.a != ((b) obj).a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a ? 1 : 0;
    }

    public String getKey() {
        return "unitsDistance";
    }

    public String toJson() {
        return p.a(this);
    }

    public byte[] toBytes() {
        int i = 1;
        ByteBuffer order = ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN);
        if (!this.a) {
            i = 0;
        }
        return order.put((byte) i).array();
    }
}
