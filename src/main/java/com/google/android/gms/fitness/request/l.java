package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSet;

public class l implements Creator<DataInsertRequest> {
    static void a(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataInsertRequest.a(), i, false);
        b.a(parcel, 2, dataInsertRequest.b(), false);
        b.a(parcel, 4, dataInsertRequest.c());
        b.a(parcel, 1000, dataInsertRequest.d());
        b.a(parcel, a);
    }

    public DataInsertRequest a(Parcel parcel) {
        IBinder iBinder = null;
        boolean z = false;
        int b = a.b(parcel);
        DataSet dataSet = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int i2;
            DataSet dataSet2;
            boolean z2;
            IBinder iBinder2;
            int a = a.a(parcel);
            boolean z3;
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    dataSet2 = (DataSet) a.a(parcel, a, DataSet.CREATOR);
                    z2 = z;
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    dataSet2 = dataSet;
                    i2 = i;
                    z3 = z;
                    iBinder2 = a.m(parcel, a);
                    z2 = z3;
                    break;
                case 4:
                    z2 = a.c(parcel, a);
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = i;
                    break;
                case 1000:
                    z3 = z;
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = a.f(parcel, a);
                    z2 = z3;
                    break;
                default:
                    a.b(parcel, a);
                    z2 = z;
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = i;
                    break;
            }
            i = i2;
            dataSet = dataSet2;
            iBinder = iBinder2;
            z = z2;
        }
        if (parcel.dataPosition() == b) {
            return new DataInsertRequest(i, dataSet, iBinder, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataInsertRequest[] a(int i) {
        return new DataInsertRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
