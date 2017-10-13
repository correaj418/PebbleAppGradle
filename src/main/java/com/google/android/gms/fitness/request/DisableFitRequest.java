package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class DisableFitRequest extends AbstractSafeParcelable {
    public static final Creator<DisableFitRequest> CREATOR = new v();
    private final int a;
    private final by b;

    DisableFitRequest(int i, IBinder iBinder) {
        this.a = i;
        this.b = a.a(iBinder);
    }

    int a() {
        return this.a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i) {
        v.a(this, parcel, i);
    }
}
