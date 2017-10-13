package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<AuthAccountRequest> {
    static void a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, authAccountRequest.a);
        b.a(parcel, 2, authAccountRequest.b, false);
        b.a(parcel, 3, authAccountRequest.c, i, false);
        b.a(parcel, 4, authAccountRequest.d, false);
        b.a(parcel, 5, authAccountRequest.e, false);
        b.a(parcel, a);
    }

    public AuthAccountRequest a(Parcel parcel) {
        Integer num = null;
        int b = a.b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i = a.f(parcel, a);
                    break;
                case 2:
                    iBinder = a.m(parcel, a);
                    break;
                case 3:
                    scopeArr = (Scope[]) a.b(parcel, a, Scope.CREATOR);
                    break;
                case 4:
                    num2 = a.g(parcel, a);
                    break;
                case 5:
                    num = a.g(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountRequest[] a(int i) {
        return new AuthAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
