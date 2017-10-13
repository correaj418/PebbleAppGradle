package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<LocationAvailability> {
    static void a(LocationAvailability locationAvailability, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, locationAvailability.a);
        b.a(parcel, 2, locationAvailability.b);
        b.a(parcel, 3, locationAvailability.c);
        b.a(parcel, 4, locationAvailability.d);
        b.a(parcel, 1000, locationAvailability.b());
        b.a(parcel, a);
    }

    public LocationAvailability a(Parcel parcel) {
        int i = 1;
        int b = a.b(parcel);
        int i2 = 0;
        int i3 = 1000;
        long j = 0;
        int i4 = 1;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i4 = a.f(parcel, a);
                    break;
                case 2:
                    i = a.f(parcel, a);
                    break;
                case 3:
                    j = a.h(parcel, a);
                    break;
                case 4:
                    i3 = a.f(parcel, a);
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
            return new LocationAvailability(i2, i3, i4, i, j);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public LocationAvailability[] a(int i) {
        return new LocationAvailability[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
