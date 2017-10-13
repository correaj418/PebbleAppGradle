package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.ay;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet extends AbstractSafeParcelable {
    public static final Creator<DataSet> CREATOR = new e();
    private final int a;
    private final DataSource b;
    private final DataType c;
    private final List<DataPoint> d;
    private final List<DataSource> e;
    private boolean f;

    DataSet(int i, DataSource dataSource, DataType dataType, List<RawDataPoint> list, List<DataSource> list2, boolean z) {
        List singletonList;
        this.f = false;
        this.a = i;
        this.b = dataSource;
        this.c = dataSource.a();
        this.f = z;
        this.d = new ArrayList(list.size());
        if (i < 2) {
            singletonList = Collections.singletonList(dataSource);
        }
        this.e = singletonList;
        for (RawDataPoint dataPoint : list) {
            this.d.add(new DataPoint(this.e, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.f = false;
        this.a = 3;
        this.b = (DataSource) b.a((Object) dataSource);
        this.c = dataSource.a();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.e.add(this.b);
    }

    public DataSet(RawDataSet rawDataSet, List<DataSource> list) {
        this.f = false;
        this.a = 3;
        this.b = (DataSource) a(list, rawDataSet.b);
        this.c = this.b.a();
        this.e = list;
        this.f = rawDataSet.e;
        List<RawDataPoint> list2 = rawDataSet.d;
        this.d = new ArrayList(list2.size());
        for (RawDataPoint dataPoint : list2) {
            this.d.add(new DataPoint(this.e, dataPoint));
        }
    }

    public static DataSet a(DataSource dataSource) {
        b.a((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private static <T> T a(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    private boolean a(DataSet dataSet) {
        return ab.a(c(), dataSet.c()) && ab.a(this.b, dataSet.b) && ab.a(this.d, dataSet.d) && this.f == dataSet.f;
    }

    public DataPoint a() {
        return DataPoint.a(this.b);
    }

    List<RawDataPoint> a(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.d.size());
        for (DataPoint rawDataPoint : this.d) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    public void a(DataPoint dataPoint) {
        Object[] objArr = new Object[]{dataPoint.c(), this.b};
        b.b(dataPoint.c().g().equals(this.b.g()), "Conflicting data sources found %s vs %s", objArr);
        dataPoint.g();
        ay.b(dataPoint);
        b(dataPoint);
    }

    public void a(Iterable<DataPoint> iterable) {
        for (DataPoint b : iterable) {
            b(b);
        }
    }

    public DataSource b() {
        return this.b;
    }

    public void b(DataPoint dataPoint) {
        this.d.add(dataPoint);
        DataSource d = dataPoint.d();
        if (d != null && !this.e.contains(d)) {
            this.e.add(d);
        }
    }

    public DataType c() {
        return this.b.a();
    }

    public List<DataPoint> d() {
        return Collections.unmodifiableList(this.d);
    }

    public boolean e() {
        return this.d.isEmpty();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataSet) && a((DataSet) obj));
    }

    public boolean f() {
        return this.f;
    }

    int g() {
        return this.a;
    }

    List<RawDataPoint> h() {
        return a(this.e);
    }

    public int hashCode() {
        return ab.a(this.b);
    }

    List<DataSource> i() {
        return this.e;
    }

    public String toString() {
        List h = h();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.b.h();
        if (this.d.size() >= 10) {
            h = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.d.size()), h.subList(0, 5)});
        }
        objArr[1] = h;
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }
}
