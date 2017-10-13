package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class l implements Creator<LocationRequestInternal> {
    static void a(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, locationRequestInternal.b, i, false);
        b.a(parcel, 4, locationRequestInternal.c);
        b.c(parcel, 5, locationRequestInternal.d, false);
        b.a(parcel, 6, locationRequestInternal.e, false);
        b.a(parcel, 7, locationRequestInternal.f);
        b.a(parcel, 1000, locationRequestInternal.a());
        b.a(parcel, a);
    }

    public LocationRequestInternal a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = a.b(parcel);
        boolean z2 = true;
        List list = LocationRequestInternal.a;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    locationRequest = (LocationRequest) a.a(parcel, a, LocationRequest.CREATOR);
                    break;
                case 4:
                    z2 = a.c(parcel, a);
                    break;
                case 5:
                    list = a.c(parcel, a, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str = a.l(parcel, a);
                    break;
                case 7:
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
            return new LocationRequestInternal(i, locationRequest, z2, list, str, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public LocationRequestInternal[] a(int i) {
        return new LocationRequestInternal[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
