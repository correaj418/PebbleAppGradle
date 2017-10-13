package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.j;
import com.google.android.gms.fitness.data.j.a;

public class SensorUnregistrationRequest extends AbstractSafeParcelable {
    public static final Creator<SensorUnregistrationRequest> CREATOR = new ad();
    private final int a;
    private final j b;
    private final PendingIntent c;
    private final by d;

    SensorUnregistrationRequest(int i, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        this.a = i;
        this.b = iBinder == null ? null : a.a(iBinder);
        this.c = pendingIntent;
        this.d = by.a.a(iBinder2);
    }

    public PendingIntent a() {
        return this.c;
    }

    public IBinder b() {
        return this.d == null ? null : this.d.asBinder();
    }

    int c() {
        return this.a;
    }

    IBinder d() {
        return this.b == null ? null : this.b.asBinder();
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.b});
    }

    public void writeToParcel(Parcel parcel, int i) {
        ad.a(this, parcel, i);
    }
}
