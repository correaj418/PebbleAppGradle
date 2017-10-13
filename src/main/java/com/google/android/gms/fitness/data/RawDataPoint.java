package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
public final class RawDataPoint extends AbstractSafeParcelable {
    public static final Creator<RawDataPoint> CREATOR = new m();
    final int a;
    public final long b;
    public final long c;
    public final Value[] d;
    public final int e;
    public final int f;
    public final long g;
    public final long h;

    public RawDataPoint(int i, long j, long j2, Value[] valueArr, int i2, int i3, long j3, long j4) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.e = i2;
        this.f = i3;
        this.g = j3;
        this.h = j4;
        this.d = valueArr;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> list) {
        this.a = 4;
        this.b = dataPoint.a(TimeUnit.NANOSECONDS);
        this.c = dataPoint.b(TimeUnit.NANOSECONDS);
        this.d = dataPoint.a();
        this.e = r.a(dataPoint.c(), list);
        this.f = r.a(dataPoint.d(), list);
        this.g = dataPoint.e();
        this.h = dataPoint.f();
    }

    private boolean a(RawDataPoint rawDataPoint) {
        return this.b == rawDataPoint.b && this.c == rawDataPoint.c && Arrays.equals(this.d, rawDataPoint.d) && this.e == rawDataPoint.e && this.f == rawDataPoint.f && this.g == rawDataPoint.g;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataPoint) && a((RawDataPoint) obj));
    }

    public int hashCode() {
        return ab.a(Long.valueOf(this.b), Long.valueOf(this.c));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.d), Long.valueOf(this.c), Long.valueOf(this.b), Integer.valueOf(this.e), Integer.valueOf(this.f)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        m.a(this, parcel, i);
    }
}
