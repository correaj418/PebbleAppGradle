package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i implements Creator<SignInResponse> {
    static void a(SignInResponse signInResponse, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, signInResponse.a);
        b.a(parcel, 2, signInResponse.a(), i, false);
        b.a(parcel, 3, signInResponse.b(), i, false);
        b.a(parcel, a);
    }

    public SignInResponse a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int b = a.b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int f;
            ResolveAccountResponse resolveAccountResponse2;
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    f = a.f(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                case 2:
                    f = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) a.a(parcel, a, ConnectionResult.CREATOR);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                case 3:
                    resolveAccountResponse2 = (ResolveAccountResponse) a.a(parcel, a, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    f = i;
                    break;
                default:
                    a.b(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    f = i;
                    break;
            }
            i = f;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() == b) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SignInResponse[] a(int i) {
        return new SignInResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
