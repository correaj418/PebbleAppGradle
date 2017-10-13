package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class aa implements Creator<ReadRawRequest> {
    static void a(ReadRawRequest readRawRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, readRawRequest.c(), false);
        b.c(parcel, 3, readRawRequest.a(), false);
        b.a(parcel, 4, readRawRequest.e());
        b.a(parcel, 5, readRawRequest.d());
        b.a(parcel, 1000, readRawRequest.b());
        b.a(parcel, a);
    }

    public ReadRawRequest a(Parcel parcel) {
        List list = null;
        boolean z = false;
        int b = a.b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    iBinder = a.m(parcel, a);
                    break;
                case 3:
                    list = a.c(parcel, a, DataSourceQueryParams.CREATOR);
                    break;
                case 4:
                    z2 = a.c(parcel, a);
                    break;
                case 5:
                    z = a.c(parcel, a);
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
            return new ReadRawRequest(i, iBinder, list, z2, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ReadRawRequest[] a(int i) {
        return new ReadRawRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
