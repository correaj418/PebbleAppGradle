package com.getpebble.android.framework.n;

import com.getpebble.android.common.model.ay;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a implements ay {
    @c(a = "remindersApp")
    public final a a;

    public enum a {
        DISABLED((byte) 0),
        ENABLED_NOT_CONFIGURED((byte) 1),
        ENABLED_CONFIGURED((byte) 2);
        
        public final byte value;

        private a(byte b) {
            this.value = b;
        }
    }

    public a(a aVar) {
        this.a = aVar;
    }

    public String getKey() {
        return "remindersApp";
    }

    public String toJson() {
        return p.a(this);
    }

    public int hashCode() {
        return toJson().hashCode();
    }

    public byte[] toBytes() {
        return ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN).put(this.a.value).array();
    }
}
