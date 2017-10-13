package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class v implements Creator<LocationSettingsStates> {
    static void a(LocationSettingsStates locationSettingsStates, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, locationSettingsStates.b());
        b.a(parcel, 2, locationSettingsStates.d());
        b.a(parcel, 3, locationSettingsStates.f());
        b.a(parcel, 4, locationSettingsStates.c());
        b.a(parcel, 5, locationSettingsStates.e());
        b.a(parcel, 6, locationSettingsStates.g());
        b.a(parcel, 1000, locationSettingsStates.a());
        b.a(parcel, a);
    }

    public LocationSettingsStates a(Parcel parcel) {
        boolean z = false;
        int b = a.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    z6 = a.c(parcel, a);
                    break;
                case 2:
                    z5 = a.c(parcel, a);
                    break;
                case 3:
                    z4 = a.c(parcel, a);
                    break;
                case 4:
                    z3 = a.c(parcel, a);
                    break;
                case 5:
                    z2 = a.c(parcel, a);
                    break;
                case 6:
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
            return new LocationSettingsStates(i, z6, z5, z4, z3, z2, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public LocationSettingsStates[] a(int i) {
        return new LocationSettingsStates[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
