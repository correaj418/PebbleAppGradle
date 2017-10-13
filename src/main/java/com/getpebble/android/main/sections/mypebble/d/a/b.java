package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.a.c;

abstract class b extends g {
    private final long a;
    private final long b;
    private final int c;
    private final Integer d;
    private final Integer e;

    b(long j, long j2, int i, Integer num, Integer num2) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = num;
        this.e = num2;
    }

    @c(a = "start")
    public long a() {
        return this.a;
    }

    @c(a = "end")
    public long b() {
        return this.b;
    }

    @c(a = "beatsPerMinute")
    public int c() {
        return this.c;
    }

    @c(a = "qualityWeight")
    public Integer d() {
        return this.d;
    }

    @c(a = "vmc")
    public Integer e() {
        return this.e;
    }

    public String toString() {
        return "APIHeartRateChunk{start=" + this.a + ", end=" + this.b + ", beatsPerMinute=" + this.c + ", qualityWeight=" + this.d + ", vmc=" + this.e + "}";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        if (r7 != r6) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r7 instanceof com.getpebble.android.main.sections.mypebble.d.a.g;
        if (r2 == 0) goto L_0x0057;
    L_0x0009:
        r7 = (com.getpebble.android.main.sections.mypebble.d.a.g) r7;
        r2 = r6.a;
        r4 = r7.a();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x003b;
    L_0x0015:
        r2 = r6.b;
        r4 = r7.b();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x003b;
    L_0x001f:
        r2 = r6.c;
        r3 = r7.c();
        if (r2 != r3) goto L_0x003b;
    L_0x0027:
        r2 = r6.d;
        if (r2 != 0) goto L_0x003d;
    L_0x002b:
        r2 = r7.d();
        if (r2 != 0) goto L_0x003b;
    L_0x0031:
        r2 = r6.e;
        if (r2 != 0) goto L_0x004a;
    L_0x0035:
        r2 = r7.e();
        if (r2 == 0) goto L_0x0004;
    L_0x003b:
        r0 = r1;
        goto L_0x0004;
    L_0x003d:
        r2 = r6.d;
        r3 = r7.d();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003b;
    L_0x0049:
        goto L_0x0031;
    L_0x004a:
        r2 = r6.e;
        r3 = r7.e();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003b;
    L_0x0056:
        goto L_0x0004;
    L_0x0057:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.main.sections.mypebble.d.a.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.d == null ? 0 : this.d.hashCode()) ^ (((((int) (((long) (((int) (((long) 1000003) ^ ((this.a >>> 32) ^ this.a))) * 1000003)) ^ ((this.b >>> 32) ^ this.b))) * 1000003) ^ this.c) * 1000003)) * 1000003;
        if (this.e != null) {
            i = this.e.hashCode();
        }
        return hashCode ^ i;
    }
}
