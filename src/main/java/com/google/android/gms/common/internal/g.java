package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<ValidateAccountRequest> {
    static void a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, validateAccountRequest.a);
        b.a(parcel, 2, validateAccountRequest.a());
        b.a(parcel, 3, validateAccountRequest.b, false);
        b.a(parcel, 4, validateAccountRequest.b(), i, false);
        b.a(parcel, 5, validateAccountRequest.d(), false);
        b.a(parcel, 6, validateAccountRequest.c(), false);
        b.a(parcel, a);
    }

    public ValidateAccountRequest a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = a.b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = a.f(parcel, a);
                    break;
                case 2:
                    i = a.f(parcel, a);
                    break;
                case 3:
                    iBinder = a.m(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) a.b(parcel, a, Scope.CREATOR);
                    break;
                case 5:
                    bundle = a.n(parcel, a);
                    break;
                case 6:
                    str = a.l(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ValidateAccountRequest[] a(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
