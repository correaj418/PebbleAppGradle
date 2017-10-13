package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.a.c;

abstract class e extends p {
    private final long a;
    private final long b;
    private final String c;
    private final String d;
    private final Integer e;
    private final Integer f;
    private final Integer g;

    e(long j, long j2, String str, String str2, Integer num, Integer num2, Integer num3) {
        this.a = j;
        this.b = j2;
        this.c = str;
        this.d = str2;
        this.e = num;
        this.f = num2;
        this.g = num3;
    }

    @c(a = "start")
    public long a() {
        return this.a;
    }

    @c(a = "end")
    public long b() {
        return this.b;
    }

    @c(a = "label")
    public String c() {
        return this.c;
    }

    @c(a = "shortLabel")
    public String d() {
        return this.d;
    }

    @c(a = "minutesInZone1")
    public Integer e() {
        return this.e;
    }

    @c(a = "minutesInZone2")
    public Integer f() {
        return this.f;
    }

    @c(a = "minutesInZone3")
    public Integer g() {
        return this.g;
    }

    public String toString() {
        return "HeartRateZonesChunk{startSecs=" + this.a + ", endSecs=" + this.b + ", label=" + this.c + ", shortLabel=" + this.d + ", minutesInZone1=" + this.e + ", minutesInZone2=" + this.f + ", minutesInZone3=" + this.g + "}";
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
        r2 = r7 instanceof com.getpebble.android.main.sections.mypebble.d.a.p;
        if (r2 == 0) goto L_0x0095;
    L_0x0009:
        r7 = (com.getpebble.android.main.sections.mypebble.d.a.p) r7;
        r2 = r6.a;
        r4 = r7.a();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0051;
    L_0x0015:
        r2 = r6.b;
        r4 = r7.b();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0051;
    L_0x001f:
        r2 = r6.c;
        if (r2 != 0) goto L_0x0053;
    L_0x0023:
        r2 = r7.c();
        if (r2 != 0) goto L_0x0051;
    L_0x0029:
        r2 = r6.d;
        if (r2 != 0) goto L_0x0060;
    L_0x002d:
        r2 = r7.d();
        if (r2 != 0) goto L_0x0051;
    L_0x0033:
        r2 = r6.e;
        if (r2 != 0) goto L_0x006d;
    L_0x0037:
        r2 = r7.e();
        if (r2 != 0) goto L_0x0051;
    L_0x003d:
        r2 = r6.f;
        if (r2 != 0) goto L_0x007a;
    L_0x0041:
        r2 = r7.f();
        if (r2 != 0) goto L_0x0051;
    L_0x0047:
        r2 = r6.g;
        if (r2 != 0) goto L_0x0087;
    L_0x004b:
        r2 = r7.g();
        if (r2 == 0) goto L_0x0004;
    L_0x0051:
        r0 = r1;
        goto L_0x0004;
    L_0x0053:
        r2 = r6.c;
        r3 = r7.c();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0051;
    L_0x005f:
        goto L_0x0029;
    L_0x0060:
        r2 = r6.d;
        r3 = r7.d();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0051;
    L_0x006c:
        goto L_0x0033;
    L_0x006d:
        r2 = r6.e;
        r3 = r7.e();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0051;
    L_0x0079:
        goto L_0x003d;
    L_0x007a:
        r2 = r6.f;
        r3 = r7.f();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0051;
    L_0x0086:
        goto L_0x0047;
    L_0x0087:
        r2 = r6.g;
        r3 = r7.g();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0051;
    L_0x0093:
        goto L_0x0004;
    L_0x0095:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.main.sections.mypebble.d.a.e.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f == null ? 0 : this.f.hashCode()) ^ (((this.e == null ? 0 : this.e.hashCode()) ^ (((this.d == null ? 0 : this.d.hashCode()) ^ (((this.c == null ? 0 : this.c.hashCode()) ^ (((int) (((long) (((int) (((long) 1000003) ^ ((this.a >>> 32) ^ this.a))) * 1000003)) ^ ((this.b >>> 32) ^ this.b))) * 1000003)) * 1000003)) * 1000003)) * 1000003)) * 1000003;
        if (this.g != null) {
            i = this.g.hashCode();
        }
        return hashCode ^ i;
    }
}
