package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class FusedLocationProviderResult extends AbstractSafeParcelable implements f {
    public static final Creator<FusedLocationProviderResult> CREATOR = new d();
    public static final FusedLocationProviderResult a = new FusedLocationProviderResult(Status.a);
    private final int b;
    private final Status c;

    FusedLocationProviderResult(int i, Status status) {
        this.b = i;
        this.c = status;
    }

    public FusedLocationProviderResult(Status status) {
        this(1, status);
    }

    public Status a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
