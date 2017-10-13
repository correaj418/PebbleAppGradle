package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LocationSettingsResult extends AbstractSafeParcelable implements f {
    public static final Creator<LocationSettingsResult> CREATOR = new u();
    private final int a;
    private final Status b;
    private final LocationSettingsStates c;

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.a = i;
        this.b = status;
        this.c = locationSettingsStates;
    }

    public Status a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public LocationSettingsStates c() {
        return this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        u.a(this, parcel, i);
    }
}
