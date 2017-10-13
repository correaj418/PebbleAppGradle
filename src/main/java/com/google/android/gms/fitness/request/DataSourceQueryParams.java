package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceQueryParams extends AbstractSafeParcelable {
    public static final Creator<DataSourceQueryParams> CREATOR = new n();
    final int a;
    public final DataSource b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final int g;

    DataSourceQueryParams(int i, DataSource dataSource, long j, long j2, long j3, int i2, int i3) {
        this.a = i;
        this.b = dataSource;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = i2;
        this.g = i3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n.a(this, parcel, i);
    }
}
