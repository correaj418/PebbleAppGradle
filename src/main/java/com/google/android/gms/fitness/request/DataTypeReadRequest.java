package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bl;
import com.google.android.gms.b.bl.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class DataTypeReadRequest extends AbstractSafeParcelable {
    public static final Creator<DataTypeReadRequest> CREATOR = new q();
    private final int a;
    private final String b;
    private final bl c;

    DataTypeReadRequest(int i, String str, IBinder iBinder) {
        this.a = i;
        this.b = str;
        this.c = a.a(iBinder);
    }

    private boolean a(DataTypeReadRequest dataTypeReadRequest) {
        return ab.a(this.b, dataTypeReadRequest.b);
    }

    public String a() {
        return this.b;
    }

    public IBinder b() {
        return this.c.asBinder();
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeReadRequest) && a((DataTypeReadRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b);
    }

    public String toString() {
        return ab.a((Object) this).a("name", this.b).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        q.a(this, parcel, i);
    }
}
