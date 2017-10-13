package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<SignInRequest> {
    static void a(SignInRequest signInRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, signInRequest.a);
        b.a(parcel, 2, signInRequest.a(), i, false);
        b.a(parcel, a);
    }

    public SignInRequest a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i = a.f(parcel, a);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) a.a(parcel, a, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SignInRequest[] a(int i) {
        return new SignInRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
