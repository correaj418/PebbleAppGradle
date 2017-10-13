package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class c implements Creator<CheckServerAuthResult> {
    static void a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, checkServerAuthResult.a);
        b.a(parcel, 2, checkServerAuthResult.b);
        b.c(parcel, 3, checkServerAuthResult.c, false);
        b.a(parcel, a);
    }

    public CheckServerAuthResult a(Parcel parcel) {
        boolean z = false;
        int b = a.b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i = a.f(parcel, a);
                    break;
                case 2:
                    z = a.c(parcel, a);
                    break;
                case 3:
                    list = a.c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public CheckServerAuthResult[] a(int i) {
        return new CheckServerAuthResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
