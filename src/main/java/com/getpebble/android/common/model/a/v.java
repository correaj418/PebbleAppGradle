package com.getpebble.android.common.model.a;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.m.d;
import com.getpebble.android.common.model.u;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class v extends q {
    @c(a = "version")
    public final int a;
    @c(a = "lastProcessedTimestamp")
    public final int b;
    @c(a = "steps")
    public final int d;
    @c(a = "activeKiloCalories")
    public final int e;
    @c(a = "restingKiloCalories")
    public final int f;
    @c(a = "distance")
    public final int g;
    @c(a = "activeSeconds")
    public final int h;

    private enum a {
        INITIAL(1, 15, 28);
        
        private static final a LATEST = null;
        private final int bufferSize;
        private final int healthModelVersion;
        private final int structVersion;

        static {
            LATEST = INITIAL;
        }

        private a(int i, int i2, int i3) {
            this.structVersion = i;
            this.healthModelVersion = i2;
            this.bufferSize = i3;
        }

        static a from(int i) {
            for (a aVar : values()) {
                if (aVar.healthModelVersion == i) {
                    return aVar;
                }
            }
            return LATEST;
        }
    }

    private v(int i, u uVar, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(a(uVar));
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
    }

    public v(u uVar, int i, int i2, int i3, int i4, int i5, int i6) {
        this(a.LATEST.structVersion, uVar, i, i2, i3, i4, i5, i6);
    }

    public v(u uVar, d dVar) {
        this(uVar, dVar.a(), dVar.b(), dVar.c(), dVar.d(), dVar.e(), dVar.f());
    }

    public static p a(u uVar) {
        return p.from(uVar.blobDbKeyName, com.getpebble.android.common.model.a.p.a.MOVEMENT_DATA);
    }

    public byte[] toBytes() {
        ByteBuffer allocate = ByteBuffer.allocate(a.from(this.a).bufferSize);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(this.a);
        allocate.putInt(this.b);
        allocate.putInt(this.d);
        allocate.putInt(this.e);
        allocate.putInt(this.f);
        allocate.putInt(this.g);
        allocate.putInt(this.h);
        byte[] array = allocate.array();
        f.e("MovementDataEntry", "toBytes: " + this + " -> " + com.getpebble.android.bluetooth.b.a.a(array, array.length));
        return array;
    }

    public String toString() {
        return "MovementDataEntry{version=" + this.a + ", lastProcessedTimestamp=" + this.b + ", steps=" + this.d + ", activeKcal=" + this.e + ", restingKcal=" + this.f + ", distance=" + this.g + ", activeSecs=" + this.h + '}';
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.a != vVar.a || this.b != vVar.b || this.d != vVar.d || this.e != vVar.e || this.f != vVar.f || this.g != vVar.g) {
            return false;
        }
        if (this.h != vVar.h) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((((((((super.hashCode() * 31) + this.a) * 31) + this.b) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h;
    }
}
