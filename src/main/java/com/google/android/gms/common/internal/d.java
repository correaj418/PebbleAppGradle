package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<ResolveAccountResponse> {
    static void a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, resolveAccountResponse.a);
        b.a(parcel, 2, resolveAccountResponse.b, false);
        b.a(parcel, 3, resolveAccountResponse.b(), i, false);
        b.a(parcel, 4, resolveAccountResponse.c());
        b.a(parcel, 5, resolveAccountResponse.d());
        b.a(parcel, a);
    }

    public ResolveAccountResponse a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = a.b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) a.a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = a.c(parcel, a);
                    break;
                case 5:
                    z = a.c(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountResponse[] a(int i) {
        return new ResolveAccountResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
