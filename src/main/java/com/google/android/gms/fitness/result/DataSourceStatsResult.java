package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceStatsResult extends AbstractSafeParcelable {
    public static final Creator<DataSourceStatsResult> CREATOR = new d();
    final int a;
    public final DataSource b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;

    DataSourceStatsResult(int i, DataSource dataSource, long j, boolean z, long j2, long j3) {
        this.a = i;
        this.b = dataSource;
        this.c = j;
        this.d = z;
        this.e = j2;
        this.f = j3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
