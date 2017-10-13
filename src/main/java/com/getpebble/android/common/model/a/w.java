package com.getpebble.android.common.model.a;

import android.content.ContentResolver;
import com.getpebble.android.common.model.a.i.a;
import com.getpebble.android.common.model.ba;
import com.getpebble.android.common.model.j;
import com.getpebble.android.framework.health.d.b;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import com.google.b.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class w implements j {
    @c(a = "resting_hr")
    public abstract short a();

    @c(a = "elevated_hr")
    public abstract short b();

    @c(a = "max_hr")
    public abstract short c();

    @c(a = "zone1_threshold")
    public abstract short d();

    @c(a = "zone2_threshold")
    public abstract short e();

    @c(a = "zone3_threshold")
    public abstract short f();

    public static w a(b bVar) {
        return new i((short) ((int) bVar.a), (short) ((int) bVar.b), (short) ((int) bVar.c), (short) ((int) bVar.d), (short) ((int) bVar.e), (short) ((int) bVar.f));
    }

    public static w g() {
        return new i((short) 50, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);
    }

    public static com.google.b.w<w> a(f fVar) {
        return new a(fVar);
    }

    public String getKey() {
        return "heartRatePreferences";
    }

    public String toJson() {
        return p.a(this);
    }

    public byte[] toBytes() {
        return ByteBuffer.allocate(6).order(ByteOrder.LITTLE_ENDIAN).put((byte) a()).put((byte) b()).put((byte) c()).put((byte) d()).put((byte) e()).put((byte) f()).array();
    }

    public static w a(ContentResolver contentResolver) {
        return (w) ba.a("heartRatePreferences", g(), contentResolver);
    }
}
