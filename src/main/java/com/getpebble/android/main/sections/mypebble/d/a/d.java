package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.a.c;

abstract class d extends n {
    private final long a;
    private final long b;
    private final int c;
    private final String d;
    private final String e;
    private final Integer f;
    private final Integer g;

    d(long j, long j2, int i, String str, String str2, Integer num, Integer num2) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = str;
        this.e = str2;
        this.f = num;
        this.g = num2;
    }

    @c(a = "start")
    public long a() {
        return this.a;
    }

    @c(a = "end")
    public long b() {
        return this.b;
    }

    @c(a = "startTimeZoneOffset")
    public int c() {
        return this.c;
    }

    @c(a = "label")
    public String d() {
        return this.d;
    }

    @c(a = "shortLabel")
    public String e() {
        return this.e;
    }

    @c(a = "heartRate")
    public Integer f() {
        return this.f;
    }

    @c(a = "qualityWeight")
    public Integer g() {
        return this.g;
    }

    public String toString() {
        return "ChartsHeartRateChunk{startSecs=" + this.a + ", endSecs=" + this.b + ", startTimeZoneOffsetSecs=" + this.c + ", label=" + this.d + ", shortLabel=" + this.e + ", heartRate=" + this.f + ", qualityWeight=" + this.g + "}";
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
        r2 = r7 instanceof com.getpebble.android.main.sections.mypebble.d.a.n;
        if (r2 == 0) goto L_0x0085;
    L_0x0009:
        r7 = (com.getpebble.android.main.sections.mypebble.d.a.n) r7;
        r2 = r6.a;
        r4 = r7.a();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x004f;
    L_0x0015:
        r2 = r6.b;
        r4 = r7.b();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x004f;
    L_0x001f:
        r2 = r6.c;
        r3 = r7.c();
        if (r2 != r3) goto L_0x004f;
    L_0x0027:
        r2 = r6.d;
        if (r2 != 0) goto L_0x0051;
    L_0x002b:
        r2 = r7.d();
        if (r2 != 0) goto L_0x004f;
    L_0x0031:
        r2 = r6.e;
        if (r2 != 0) goto L_0x005e;
    L_0x0035:
        r2 = r7.e();
        if (r2 != 0) goto L_0x004f;
    L_0x003b:
        r2 = r6.f;
        if (r2 != 0) goto L_0x006b;
    L_0x003f:
        r2 = r7.f();
        if (r2 != 0) goto L_0x004f;
    L_0x0045:
        r2 = r6.g;
        if (r2 != 0) goto L_0x0078;
    L_0x0049:
        r2 = r7.g();
        if (r2 == 0) goto L_0x0004;
    L_0x004f:
        r0 = r1;
        goto L_0x0004;
    L_0x0051:
        r2 = r6.d;
        r3 = r7.d();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004f;
    L_0x005d:
        goto L_0x0031;
    L_0x005e:
        r2 = r6.e;
        r3 = r7.e();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004f;
    L_0x006a:
        goto L_0x003b;
    L_0x006b:
        r2 = r6.f;
        r3 = r7.f();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004f;
    L_0x0077:
        goto L_0x0045;
    L_0x0078:
        r2 = r6.g;
        r3 = r7.g();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004f;
    L_0x0084:
        goto L_0x0004;
    L_0x0085:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.main.sections.mypebble.d.a.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f == null ? 0 : this.f.hashCode()) ^ (((this.e == null ? 0 : this.e.hashCode()) ^ (((this.d == null ? 0 : this.d.hashCode()) ^ (((((int) (((long) (((int) (((long) 1000003) ^ ((this.a >>> 32) ^ this.a))) * 1000003)) ^ ((this.b >>> 32) ^ this.b))) * 1000003) ^ this.c) * 1000003)) * 1000003)) * 1000003)) * 1000003;
        if (this.g != null) {
            i = this.g.hashCode();
        }
        return hashCode ^ i;
    }
}
