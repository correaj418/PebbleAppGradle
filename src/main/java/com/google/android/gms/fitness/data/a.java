package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<Application> {
    static void a(Application application, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, application.a(), false);
        b.a(parcel, 2, application.b(), false);
        b.a(parcel, 3, application.c(), false);
        b.a(parcel, 1000, application.d());
        b.a(parcel, a);
    }

    public Application a(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                case 1:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Application(i, str3, str2, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public Application[] a(int i) {
        return new Application[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
