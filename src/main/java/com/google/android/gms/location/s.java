package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class s implements Creator<LocationResult> {
    static void a(LocationResult locationResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, locationResult.a(), false);
        b.a(parcel, 1000, locationResult.b());
        b.a(parcel, a);
    }

    public LocationResult a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        List list = LocationResult.a;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list = a.c(parcel, a, Location.CREATOR);
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
            return new LocationResult(i, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public LocationResult[] a(int i) {
        return new LocationResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
