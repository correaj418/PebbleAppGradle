package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult extends AbstractSafeParcelable implements f {
    public static final Creator<DataTypeResult> CREATOR = new g();
    private final int a;
    private final Status b;
    private final DataType c;

    DataTypeResult(int i, Status status, DataType dataType) {
        this.a = i;
        this.b = status;
        this.c = dataType;
    }

    private boolean a(DataTypeResult dataTypeResult) {
        return this.b.equals(dataTypeResult.b) && ab.a(this.c, dataTypeResult.c);
    }

    public Status a() {
        return this.b;
    }

    public DataType b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataTypeResult) && a((DataTypeResult) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.c);
    }

    public String toString() {
        return ab.a((Object) this).a("status", this.b).a("dataType", this.c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}
