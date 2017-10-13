package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n implements Creator<ParcelableGeofence> {
    static void a(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, parcelableGeofence.f(), false);
        b.a(parcel, 2, parcelableGeofence.g());
        b.a(parcel, 3, parcelableGeofence.b());
        b.a(parcel, 4, parcelableGeofence.c());
        b.a(parcel, 5, parcelableGeofence.d());
        b.a(parcel, 6, parcelableGeofence.e());
        b.a(parcel, 7, parcelableGeofence.h());
        b.a(parcel, 1000, parcelableGeofence.a());
        b.a(parcel, 8, parcelableGeofence.i());
        b.a(parcel, 9, parcelableGeofence.j());
        b.a(parcel, a);
    }

    public ParcelableGeofence a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    str = a.l(parcel, a);
                    break;
                case 2:
                    j = a.h(parcel, a);
                    break;
                case 3:
                    s = a.e(parcel, a);
                    break;
                case 4:
                    d = a.k(parcel, a);
                    break;
                case 5:
                    d2 = a.k(parcel, a);
                    break;
                case 6:
                    f = a.j(parcel, a);
                    break;
                case 7:
                    i2 = a.f(parcel, a);
                    break;
                case 8:
                    i3 = a.f(parcel, a);
                    break;
                case 9:
                    i4 = a.f(parcel, a);
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
            return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ParcelableGeofence[] a(int i) {
        return new ParcelableGeofence[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
