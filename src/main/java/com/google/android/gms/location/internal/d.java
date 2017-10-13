package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<FusedLocationProviderResult> {
    static void a(FusedLocationProviderResult fusedLocationProviderResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, fusedLocationProviderResult.a(), i, false);
        b.a(parcel, 1000, fusedLocationProviderResult.b());
        b.a(parcel, a);
    }

    public FusedLocationProviderResult a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    status = (Status) a.a(parcel, a, Status.CREATOR);
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
            return new FusedLocationProviderResult(i, status);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public FusedLocationProviderResult[] a(int i) {
        return new FusedLocationProviderResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
