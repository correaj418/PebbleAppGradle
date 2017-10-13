package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<DetectedActivity> {
    static void a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, detectedActivity.d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, detectedActivity.e);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1000, detectedActivity.c());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a);
    }

    public DetectedActivity a(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = a.f(parcel, a);
                    break;
                case 2:
                    i = a.f(parcel, a);
                    break;
                case 1000:
                    i3 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DetectedActivity[] a(int i) {
        return new DetectedActivity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
