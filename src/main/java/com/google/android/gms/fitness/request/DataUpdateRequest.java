package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSet;

public class DataUpdateRequest extends AbstractSafeParcelable {
    public static final Creator<DataUpdateRequest> CREATOR = new t();
    private final int a;
    private final long b;
    private final long c;
    private final DataSet d;
    private final by e;

    DataUpdateRequest(int i, long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = dataSet;
        this.e = a.a(iBinder);
    }

    private boolean a(DataUpdateRequest dataUpdateRequest) {
        return this.b == dataUpdateRequest.b && this.c == dataUpdateRequest.c && ab.a(this.d, dataUpdateRequest.d);
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public DataSet c() {
        return this.d;
    }

    public IBinder d() {
        return this.e == null ? null : this.e.asBinder();
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataUpdateRequest) && a((DataUpdateRequest) obj));
    }

    public int hashCode() {
        return ab.a(Long.valueOf(this.b), Long.valueOf(this.c), this.d);
    }

    public String toString() {
        return ab.a((Object) this).a("startTimeMillis", Long.valueOf(this.b)).a("endTimeMillis", Long.valueOf(this.c)).a("dataSet", this.d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        t.a(this, parcel, i);
    }
}
