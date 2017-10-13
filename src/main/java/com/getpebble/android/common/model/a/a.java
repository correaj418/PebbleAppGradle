package com.getpebble.android.common.model.a;

import com.getpebble.android.common.model.a.o.e;

abstract class a extends e {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private final Integer m;
    private final Integer n;
    private final Short o;
    private final int p;
    private final int q;

    a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, int i9, int i10, int i11, Integer num, Integer num2, Short sh, int i12, int i13) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
        this.i = z;
        this.j = i9;
        this.k = i10;
        this.l = i11;
        this.m = num;
        this.n = num2;
        this.o = sh;
        this.p = i12;
        this.q = i13;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    public Integer m() {
        return this.m;
    }

    public Integer n() {
        return this.n;
    }

    public Short o() {
        return this.o;
    }

    public int p() {
        return this.p;
    }

    public int q() {
        return this.q;
    }

    public String toString() {
        return "Record{id=" + this.a + ", watchId=" + this.b + ", stepCount=" + this.c + ", dateUtcSecs=" + this.d + ", utcToLocalSecs=" + this.e + ", orientation=" + this.f + ", vmc=" + this.g + ", light=" + this.h + ", pluggedIn=" + this.i + ", distanceMm=" + this.j + ", restingGramCalories=" + this.k + ", activeGramCalories=" + this.l + ", heartRate=" + this.m + ", heartRateWeight=" + this.n + ", heartRateZone=" + this.o + ", dateLocalSecs=" + this.p + ", activeMinutes=" + this.q + "}";
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
        r2 = r5 instanceof com.getpebble.android.common.model.a.o.e;
        if (r2 == 0) goto L_0x00c3;
    L_0x0009:
        r5 = (com.getpebble.android.common.model.a.o.e) r5;
        r2 = r4.a;
        r3 = r5.a();
        if (r2 != r3) goto L_0x0099;
    L_0x0013:
        r2 = r4.b;
        r3 = r5.b();
        if (r2 != r3) goto L_0x0099;
    L_0x001b:
        r2 = r4.c;
        r3 = r5.c();
        if (r2 != r3) goto L_0x0099;
    L_0x0023:
        r2 = r4.d;
        r3 = r5.d();
        if (r2 != r3) goto L_0x0099;
    L_0x002b:
        r2 = r4.e;
        r3 = r5.e();
        if (r2 != r3) goto L_0x0099;
    L_0x0033:
        r2 = r4.f;
        r3 = r5.f();
        if (r2 != r3) goto L_0x0099;
    L_0x003b:
        r2 = r4.g;
        r3 = r5.g();
        if (r2 != r3) goto L_0x0099;
    L_0x0043:
        r2 = r4.h;
        r3 = r5.h();
        if (r2 != r3) goto L_0x0099;
    L_0x004b:
        r2 = r4.i;
        r3 = r5.i();
        if (r2 != r3) goto L_0x0099;
    L_0x0053:
        r2 = r4.j;
        r3 = r5.j();
        if (r2 != r3) goto L_0x0099;
    L_0x005b:
        r2 = r4.k;
        r3 = r5.k();
        if (r2 != r3) goto L_0x0099;
    L_0x0063:
        r2 = r4.l;
        r3 = r5.l();
        if (r2 != r3) goto L_0x0099;
    L_0x006b:
        r2 = r4.m;
        if (r2 != 0) goto L_0x009c;
    L_0x006f:
        r2 = r5.m();
        if (r2 != 0) goto L_0x0099;
    L_0x0075:
        r2 = r4.n;
        if (r2 != 0) goto L_0x00a9;
    L_0x0079:
        r2 = r5.n();
        if (r2 != 0) goto L_0x0099;
    L_0x007f:
        r2 = r4.o;
        if (r2 != 0) goto L_0x00b6;
    L_0x0083:
        r2 = r5.o();
        if (r2 != 0) goto L_0x0099;
    L_0x0089:
        r2 = r4.p;
        r3 = r5.p();
        if (r2 != r3) goto L_0x0099;
    L_0x0091:
        r2 = r4.q;
        r3 = r5.q();
        if (r2 == r3) goto L_0x0004;
    L_0x0099:
        r0 = r1;
        goto L_0x0004;
    L_0x009c:
        r2 = r4.m;
        r3 = r5.m();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0099;
    L_0x00a8:
        goto L_0x0075;
    L_0x00a9:
        r2 = r4.n;
        r3 = r5.n();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0099;
    L_0x00b5:
        goto L_0x007f;
    L_0x00b6:
        r2 = r4.o;
        r3 = r5.o();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0099;
    L_0x00c2:
        goto L_0x0089;
    L_0x00c3:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.common.model.a.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.n == null ? 0 : this.n.hashCode()) ^ (((this.m == null ? 0 : this.m.hashCode()) ^ (((((((((this.i ? 1231 : 1237) ^ ((((((((((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ this.g) * 1000003) ^ this.h) * 1000003)) * 1000003) ^ this.j) * 1000003) ^ this.k) * 1000003) ^ this.l) * 1000003)) * 1000003)) * 1000003;
        if (this.o != null) {
            i = this.o.hashCode();
        }
        return ((((hashCode ^ i) * 1000003) ^ this.p) * 1000003) ^ this.q;
    }
}
