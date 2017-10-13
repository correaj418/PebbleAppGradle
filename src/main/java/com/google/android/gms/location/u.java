package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class u implements Creator<LocationSettingsResult> {
    static void a(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, locationSettingsResult.a(), i, false);
        b.a(parcel, 2, locationSettingsResult.c(), i, false);
        b.a(parcel, 1000, locationSettingsResult.b());
        b.a(parcel, a);
    }

    public LocationSettingsResult a(Parcel parcel) {
        LocationSettingsStates locationSettingsStates = null;
        int b = a.b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int i2;
            LocationSettingsStates locationSettingsStates2;
            Status status2;
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) a.a(parcel, a, Status.CREATOR);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status3;
                    break;
                case 2:
                    locationSettingsStates2 = (LocationSettingsStates) a.a(parcel, a, LocationSettingsStates.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates;
                    status2 = status;
                    i2 = a.f(parcel, a);
                    locationSettingsStates2 = locationSettingsStates3;
                    break;
                default:
                    a.b(parcel, a);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            locationSettingsStates = locationSettingsStates2;
        }
        if (parcel.dataPosition() == b) {
            return new LocationSettingsResult(i, status, locationSettingsStates);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsResult[] a(int i) {
        return new LocationSettingsResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
