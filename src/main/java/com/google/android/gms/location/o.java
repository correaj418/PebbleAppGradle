package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class o implements Creator<GeofencingRequest> {
    static void a(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, geofencingRequest.b(), false);
        b.a(parcel, 2, geofencingRequest.c());
        b.a(parcel, 1000, geofencingRequest.a());
        b.a(parcel, a);
    }

    public GeofencingRequest a(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list = a.c(parcel, a, ParcelableGeofence.CREATOR);
                    break;
                case 2:
                    i = a.f(parcel, a);
                    break;
                case 1000:
                    i2 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GeofencingRequest(i2, list, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public GeofencingRequest[] a(int i) {
        return new GeofencingRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
