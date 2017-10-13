package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class UnclaimBleDeviceRequest extends AbstractSafeParcelable {
    public static final Creator<UnclaimBleDeviceRequest> CREATOR = new g();
    private final int a;
    private final String b;
    private final by c;

    UnclaimBleDeviceRequest(int i, String str, IBinder iBinder) {
        this.a = i;
        this.b = str;
        this.c = a.a(iBinder);
    }

    public String a() {
        return this.b;
    }

    public IBinder b() {
        return this.c == null ? null : this.c.asBinder();
    }

    int c() {
        return this.a;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.b});
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}
