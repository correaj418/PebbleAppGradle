package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class t implements Creator<LocationSettingsRequest> {
    static void a(LocationSettingsRequest locationSettingsRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, locationSettingsRequest.b(), false);
        b.a(parcel, 2, locationSettingsRequest.c());
        b.a(parcel, 3, locationSettingsRequest.d());
        b.a(parcel, 1000, locationSettingsRequest.a());
        b.a(parcel, a);
    }

    public LocationSettingsRequest a(Parcel parcel) {
        boolean z = false;
        int b = a.b(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list = a.c(parcel, a, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = a.c(parcel, a);
                    break;
                case 3:
                    z = a.c(parcel, a);
                    break;
                case 1000:
                    i = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LocationSettingsRequest(i, list, z2, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsRequest[] a(int i) {
        return new LocationSettingsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
