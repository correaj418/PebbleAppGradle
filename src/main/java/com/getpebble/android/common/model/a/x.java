package com.getpebble.android.common.model.a;

import com.getpebble.android.common.framework.b.m.f;
import com.getpebble.android.common.framework.b.m.i;
import com.getpebble.android.common.model.u;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class x extends q {
    @c(a = "dayOfWeek")
    public final u a;
    @c(a = "version")
    public final int b;
    @c(a = "lastProcessedTimestamp")
    public final int d;
    @c(a = "sleepDuration")
    public final int e;
    @c(a = "deepSleepDuration")
    public final int f;
    @c(a = "fallAsleepTime")
    public final int g;
    @c(a = "wakeupTime")
    public final int h;
    @c(a = "typicalSleepDuration")
    public final int i;
    @c(a = "typicalDeepSleepDuration")
    public final int j;
    @c(a = "typicalFallAsleepTime")
    public final int k;
    @c(a = "typicalWakeupTime")
    public final int l;

    public final class a {
        final /* synthetic */ x a;
        private i b;
        private f c;

        public a(x xVar) {
            this.a = xVar;
            this.b = i.a(Integer.valueOf(xVar.i), Integer.valueOf(xVar.j), Integer.valueOf(xVar.k), Integer.valueOf(xVar.l));
            this.c = f.a(xVar.d, xVar.e, xVar.f, xVar.g, xVar.h);
        }

        public a a(i iVar) {
            this.b = iVar;
            return this;
        }

        public a a(f fVar) {
            this.c = fVar;
            return this;
        }

        public x a() {
            return new x(this.a.a, this.c, this.b);
        }
    }

    private enum b {
        INITIAL(1, 15, 40);
        
        private static final b LATEST = null;
        private final int bufferSize;
        private final int healthDataModelVersion;
        private final int structVersion;

        static {
            LATEST = INITIAL;
        }

        private b(int i, int i2, int i3) {
            this.structVersion = i;
            this.healthDataModelVersion = i2;
            this.bufferSize = i3;
        }

        static b from(int i) {
            for (b bVar : values()) {
                if (bVar.healthDataModelVersion == i) {
                    return bVar;
                }
            }
            return LATEST;
        }
    }

    private x(int i, u uVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        super(a(uVar));
        this.a = uVar;
        this.b = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = i6;
        this.i = i7;
        this.j = i8;
        this.k = i9;
        this.l = i10;
    }

    public x(u uVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this(b.LATEST.structVersion, uVar, i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public x(u uVar, f fVar, i iVar) {
        int i;
        int a = fVar.a();
        int b = fVar.b();
        int c = fVar.c();
        int d = fVar.d();
        int e = fVar.e();
        int intValue = iVar.a() == null ? 0 : iVar.a().intValue();
        int intValue2 = iVar.b() == null ? 0 : iVar.b().intValue();
        int intValue3 = iVar.c() == null ? 0 : iVar.c().intValue();
        if (iVar.d() == null) {
            i = 0;
        } else {
            i = iVar.d().intValue();
        }
        this(uVar, a, b, c, d, e, intValue, intValue2, intValue3, i);
    }

    public static p a(u uVar) {
        return p.from(uVar.blobDbKeyName, com.getpebble.android.common.model.a.p.a.SLEEP_DATA);
    }

    public byte[] toBytes() {
        ByteBuffer allocate = ByteBuffer.allocate(b.from(this.b).bufferSize);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(this.b);
        allocate.putInt(this.d);
        allocate.putInt(this.e);
        allocate.putInt(this.f);
        allocate.putInt(this.g);
        allocate.putInt(this.h);
        allocate.putInt(this.i);
        allocate.putInt(this.j);
        allocate.putInt(this.k);
        allocate.putInt(this.l);
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
        x xVar = (x) obj;
        if (this.b != xVar.b || this.d != xVar.d || this.e != xVar.e || this.f != xVar.f || this.g != xVar.g || this.h != xVar.h || this.i != xVar.i || this.j != xVar.j || this.k != xVar.k || this.l != xVar.l) {
            return false;
        }
        if (this.a != xVar.a) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((((((((((((((((super.hashCode() * 31) + this.a.hashCode()) * 31) + this.b) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l;
    }
}
