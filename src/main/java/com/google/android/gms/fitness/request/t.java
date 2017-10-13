package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSet;

public class t implements Creator<DataUpdateRequest> {
    static void a(DataUpdateRequest dataUpdateRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataUpdateRequest.a());
        b.a(parcel, 2, dataUpdateRequest.b());
        b.a(parcel, 3, dataUpdateRequest.c(), i, false);
        b.a(parcel, 4, dataUpdateRequest.d(), false);
        b.a(parcel, 1000, dataUpdateRequest.e());
        b.a(parcel, a);
    }

    public DataUpdateRequest a(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        DataSet dataSet = null;
        long j2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    j2 = a.h(parcel, a);
                    break;
                case 2:
                    j = a.h(parcel, a);
                    break;
                case 3:
                    dataSet = (DataSet) a.a(parcel, a, DataSet.CREATOR);
                    break;
                case 4:
                    iBinder = a.m(parcel, a);
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
            return new DataUpdateRequest(i, j2, j, dataSet, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataUpdateRequest[] a(int i) {
        return new DataUpdateRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
