package com.getpebble.android.main.sections.mypebble.d.a;

import com.google.b.a.c;

abstract class a extends f {
    private final long a;
    private final long b;
    private final int c;
    private final String d;
    private final String e;
    private final Integer f;
    private final Integer g;
    private final Integer h;
    private final Integer i;
    private final Long j;

    a(long j, long j2, int i, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Long l) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = str;
        this.e = str2;
        this.f = num;
        this.g = num2;
        this.h = num3;
        this.i = num4;
        this.j = l;
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

    @c(a = "steps")
    public Integer f() {
        return this.f;
    }

    @c(a = "activeKiloCalories")
    public Integer g() {
        return this.g;
    }

    @c(a = "restingKiloCalories")
    public Integer h() {
        return this.h;
    }

    @c(a = "distance")
    public Integer i() {
        return this.i;
    }

    @c(a = "activeSeconds")
    public Long j() {
        return this.j;
    }

    public String toString() {
        return "APIActivityChunk{startSecs=" + this.a + ", endSecs=" + this.b + ", startTimeZoneOffsetSecs=" + this.c + ", label=" + this.d + ", shortLabel=" + this.e + ", steps=" + this.f + ", activeKcal=" + this.g + ", restingKcal=" + this.h + ", distanceMeters=" + this.i + ", activeTimeSeconds=" + this.j + "}";
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
        r2 = r7 instanceof com.getpebble.android.main.sections.mypebble.d.a.f;
        if (r2 == 0) goto L_0x00cb;
    L_0x0009:
        r7 = (com.getpebble.android.main.sections.mypebble.d.a.f) r7;
        r2 = r6.a;
        r4 = r7.a();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x006d;
    L_0x0015:
        r2 = r6.b;
        r4 = r7.b();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x006d;
    L_0x001f:
        r2 = r6.c;
        r3 = r7.c();
        if (r2 != r3) goto L_0x006d;
    L_0x0027:
        r2 = r6.d;
        if (r2 != 0) goto L_0x006f;
    L_0x002b:
        r2 = r7.d();
        if (r2 != 0) goto L_0x006d;
    L_0x0031:
        r2 = r6.e;
        if (r2 != 0) goto L_0x007c;
    L_0x0035:
        r2 = r7.e();
        if (r2 != 0) goto L_0x006d;
    L_0x003b:
        r2 = r6.f;
        if (r2 != 0) goto L_0x0089;
    L_0x003f:
        r2 = r7.f();
        if (r2 != 0) goto L_0x006d;
    L_0x0045:
        r2 = r6.g;
        if (r2 != 0) goto L_0x0096;
    L_0x0049:
        r2 = r7.g();
        if (r2 != 0) goto L_0x006d;
    L_0x004f:
        r2 = r6.h;
        if (r2 != 0) goto L_0x00a3;
    L_0x0053:
        r2 = r7.h();
        if (r2 != 0) goto L_0x006d;
    L_0x0059:
        r2 = r6.i;
        if (r2 != 0) goto L_0x00b0;
    L_0x005d:
        r2 = r7.i();
        if (r2 != 0) goto L_0x006d;
    L_0x0063:
        r2 = r6.j;
        if (r2 != 0) goto L_0x00bd;
    L_0x0067:
        r2 = r7.j();
        if (r2 == 0) goto L_0x0004;
    L_0x006d:
        r0 = r1;
        goto L_0x0004;
    L_0x006f:
        r2 = r6.d;
        r3 = r7.d();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006d;
    L_0x007b:
        goto L_0x0031;
    L_0x007c:
        r2 = r6.e;
        r3 = r7.e();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006d;
    L_0x0088:
        goto L_0x003b;
    L_0x0089:
        r2 = r6.f;
        r3 = r7.f();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006d;
    L_0x0095:
        goto L_0x0045;
    L_0x0096:
        r2 = r6.g;
        r3 = r7.g();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006d;
    L_0x00a2:
        goto L_0x004f;
    L_0x00a3:
        r2 = r6.h;
        r3 = r7.h();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006d;
    L_0x00af:
        goto L_0x0059;
    L_0x00b0:
        r2 = r6.i;
        r3 = r7.i();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006d;
    L_0x00bc:
        goto L_0x0063;
    L_0x00bd:
        r2 = r6.j;
        r3 = r7.j();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006d;
    L_0x00c9:
        goto L_0x0004;
    L_0x00cb:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.main.sections.mypebble.d.a.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.i == null ? 0 : this.i.hashCode()) ^ (((this.h == null ? 0 : this.h.hashCode()) ^ (((this.g == null ? 0 : this.g.hashCode()) ^ (((this.f == null ? 0 : this.f.hashCode()) ^ (((this.e == null ? 0 : this.e.hashCode()) ^ (((this.d == null ? 0 : this.d.hashCode()) ^ (((((int) (((long) (((int) (((long) 1000003) ^ ((this.a >>> 32) ^ this.a))) * 1000003)) ^ ((this.b >>> 32) ^ this.b))) * 1000003) ^ this.c) * 1000003)) * 1000003)) * 1000003)) * 1000003)) * 1000003)) * 1000003)) * 1000003;
        if (this.j != null) {
            i = this.j.hashCode();
        }
        return hashCode ^ i;
    }
}
