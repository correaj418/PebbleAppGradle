package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.b.au;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint extends AbstractSafeParcelable {
    public static final Creator<DataPoint> CREATOR = new d();
    private final int a;
    private final DataSource b;
    private long c;
    private long d;
    private final Value[] e;
    private DataSource f;
    private long g;
    private long h;

    DataPoint(int i, DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3, long j4) {
        this.a = i;
        this.b = dataSource;
        this.f = dataSource2;
        this.c = j;
        this.d = j2;
        this.e = valueArr;
        this.g = j3;
        this.h = j4;
    }

    private DataPoint(DataSource dataSource) {
        this.a = 4;
        this.b = (DataSource) b.a((Object) dataSource, (Object) "Data source cannot be null");
        List<Field> b = dataSource.a().b();
        this.e = new Value[b.size()];
        int i = 0;
        for (Field b2 : b) {
            this.e[i] = new Value(b2.b());
            i++;
        }
    }

    public DataPoint(DataSource dataSource, DataSource dataSource2, RawDataPoint rawDataPoint) {
        this(4, dataSource, a(Long.valueOf(rawDataPoint.b), 0), a(Long.valueOf(rawDataPoint.c), 0), rawDataPoint.d, dataSource2, a(Long.valueOf(rawDataPoint.g), 0), a(Long.valueOf(rawDataPoint.h), 0));
    }

    DataPoint(List<DataSource> list, RawDataPoint rawDataPoint) {
        this(a((List) list, rawDataPoint.e), a((List) list, rawDataPoint.f), rawDataPoint);
    }

    private static long a(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    public static DataPoint a(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    private static DataSource a(List<DataSource> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (DataSource) list.get(i);
    }

    private boolean a(DataPoint dataPoint) {
        return ab.a(this.b, dataPoint.b) && this.c == dataPoint.c && this.d == dataPoint.d && Arrays.equals(this.e, dataPoint.e) && ab.a(d(), dataPoint.d());
    }

    private boolean k() {
        return b() == DataType.l;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.c, TimeUnit.NANOSECONDS);
    }

    public DataPoint a(long j, long j2, TimeUnit timeUnit) {
        this.d = timeUnit.toNanos(j);
        this.c = timeUnit.toNanos(j2);
        return this;
    }

    public DataPoint a(long j, TimeUnit timeUnit) {
        this.c = timeUnit.toNanos(j);
        if (k() && au.a(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.c = au.a(this.c, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public Value a(Field field) {
        return this.e[b().a(field)];
    }

    public Value[] a() {
        return this.e;
    }

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(this.d, TimeUnit.NANOSECONDS);
    }

    public DataType b() {
        return this.b.a();
    }

    public long c(TimeUnit timeUnit) {
        return timeUnit.convert(this.c, TimeUnit.NANOSECONDS);
    }

    public DataSource c() {
        return this.b;
    }

    public DataSource d() {
        return this.f != null ? this.f : this.b;
    }

    public long e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataPoint) && a((DataPoint) obj));
    }

    public long f() {
        return this.h;
    }

    public void g() {
        b.b(b().a().equals(c().a().a()), "Conflicting data types found %s vs %s", b(), b());
        b.b(this.c > 0, "Data point does not have the timestamp set: %s", this);
        b.b(this.d <= this.c, "Data point with start time greater than end time found: %s", this);
    }

    public int h() {
        return this.a;
    }

    public int hashCode() {
        return ab.a(this.b, Long.valueOf(this.c), Long.valueOf(this.d));
    }

    public long i() {
        return this.c;
    }

    public long j() {
        return this.d;
    }

    public String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.e);
        objArr[1] = Long.valueOf(this.d);
        objArr[2] = Long.valueOf(this.c);
        objArr[3] = Long.valueOf(this.g);
        objArr[4] = Long.valueOf(this.h);
        objArr[5] = this.b.h();
        objArr[6] = this.f != null ? this.f.h() : "N/A";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
