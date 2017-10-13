package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<AuthAccountResult> {
    static void a(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, authAccountResult.a);
        b.a(parcel, 2, authAccountResult.b());
        b.a(parcel, 3, authAccountResult.c(), i, false);
        b.a(parcel, a);
    }

    public AuthAccountResult a(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                case 3:
                    intent = (Intent) com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountResult[] a(int i) {
        return new AuthAccountResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
