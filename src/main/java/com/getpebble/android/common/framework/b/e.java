package com.getpebble.android.common.framework.b;

import com.getpebble.android.common.framework.b.m.i;
import com.google.b.a.c;

abstract class e extends i {
    private final Integer a;
    private final Integer b;
    private final Integer c;
    private final Integer d;

    e(Integer num, Integer num2, Integer num3, Integer num4) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
    }

    @c(a = "sleepDuration")
    public Integer a() {
        return this.a;
    }

    @c(a = "deepSleepDuration")
    public Integer b() {
        return this.b;
    }

    @c(a = "fallAsleepTime")
    public Integer c() {
        return this.c;
    }

    @c(a = "wakeUpTime")
    public Integer d() {
        return this.d;
    }

    public String toString() {
        return "TypicalSleep{sleepDuration=" + this.a + ", deepSleepDuration=" + this.b + ", fallAsleepTime=" + this.c + ", wakeUpTime=" + this.d + "}";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r5 != r4) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof com.getpebble.android.common.framework.b.m.i;
        if (r2 == 0) goto L_0x0069;
    L_0x0009:
        r5 = (com.getpebble.android.common.framework.b.m.i) r5;
        r2 = r4.a;
        if (r2 != 0) goto L_0x0035;
    L_0x000f:
        r2 = r5.a();
        if (r2 != 0) goto L_0x0033;
    L_0x0015:
        r2 = r4.b;
        if (r2 != 0) goto L_0x0042;
    L_0x0019:
        r2 = r5.b();
        if (r2 != 0) goto L_0x0033;
    L_0x001f:
        r2 = r4.c;
        if (r2 != 0) goto L_0x004f;
    L_0x0023:
        r2 = r5.c();
        if (r2 != 0) goto L_0x0033;
    L_0x0029:
        r2 = r4.d;
        if (r2 != 0) goto L_0x005c;
    L_0x002d:
        r2 = r5.d();
        if (r2 == 0) goto L_0x0004;
    L_0x0033:
        r0 = r1;
        goto L_0x0004;
    L_0x0035:
        r2 = r4.a;
        r3 = r5.a();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0033;
    L_0x0041:
        goto L_0x0015;
    L_0x0042:
        r2 = r4.b;
        r3 = r5.b();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0033;
    L_0x004e:
        goto L_0x001f;
    L_0x004f:
        r2 = r4.c;
        r3 = r5.c();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0033;
    L_0x005b:
        goto L_0x0029;
    L_0x005c:
        r2 = r4.d;
        r3 = r5.d();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0033;
    L_0x0068:
        goto L_0x0004;
    L_0x0069:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.common.framework.b.e.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) ^ (((this.b == null ? 0 : this.b.hashCode()) ^ (((this.a == null ? 0 : this.a.hashCode()) ^ 1000003) * 1000003)) * 1000003)) * 1000003;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return hashCode ^ i;
    }
}
