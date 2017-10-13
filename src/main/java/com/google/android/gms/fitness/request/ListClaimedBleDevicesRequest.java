package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.cl;
import com.google.android.gms.b.cl.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ListClaimedBleDevicesRequest extends AbstractSafeParcelable {
    public static final Creator<ListClaimedBleDevicesRequest> CREATOR = new y();
    private final int a;
    private final cl b;

    ListClaimedBleDevicesRequest(int i, IBinder iBinder) {
        this.a = i;
        this.b = a.a(iBinder);
    }

    int a() {
        return this.a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        y.a(this, parcel, i);
    }
}
