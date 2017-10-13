package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<ClientIdentity> {
    static void a(ClientIdentity clientIdentity, Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, clientIdentity.a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, clientIdentity.b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1000, clientIdentity.a());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a);
    }

    public ClientIdentity a(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i = a.f(parcel, a);
                    break;
                case 2:
                    str = a.l(parcel, a);
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
            return new ClientIdentity(i2, i, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ClientIdentity[] a(int i) {
        return new ClientIdentity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
