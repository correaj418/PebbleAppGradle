package com.getpebble.android.common.model.a;

import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class j extends q {
    @c(a = "version")
    public final int a;
    @c(a = "dailySteps")
    public final long b;

    private enum a {
        INITIAL(1, 15, 4);
        
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

    private j(int i, long j) {
        super(p.AVERAGE_DAILY_STEPS);
        this.a = i;
        this.b = j;
    }

    public j(long j) {
        this(a.LATEST.structVersion, j);
    }

    public byte[] toBytes() {
        ByteBuffer allocate = ByteBuffer.allocate(a.from(this.a).bufferSize);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt((int) this.b);
        return allocate.array();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.a != jVar.a) {
            return false;
        }
        if (this.b != jVar.b) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.a) * 31) + ((int) (this.b ^ (this.b >>> 32)));
    }
}
