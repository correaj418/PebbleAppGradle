package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bi;
import com.google.android.gms.b.bi.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataType;

public class DailyTotalRequest extends AbstractSafeParcelable {
    public static final Creator<DailyTotalRequest> CREATOR = new j();
    private final int a;
    private final bi b;
    private DataType c;

    DailyTotalRequest(int i, IBinder iBinder, DataType dataType) {
        this.a = i;
        this.b = a.a(iBinder);
        this.c = dataType;
    }

    int a() {
        return this.a;
    }

    public DataType b() {
        return this.c;
    }

    public IBinder c() {
        return this.b.asBinder();
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", new Object[]{this.c.c()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.a(this, parcel, i);
    }
}
