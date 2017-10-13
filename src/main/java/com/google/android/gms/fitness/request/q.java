package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q implements Creator<DataTypeReadRequest> {
    static void a(DataTypeReadRequest dataTypeReadRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataTypeReadRequest.a(), false);
        b.a(parcel, 3, dataTypeReadRequest.b(), false);
        b.a(parcel, 1000, dataTypeReadRequest.c());
        b.a(parcel, a);
    }

    public DataTypeReadRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    str = a.l(parcel, a);
                    break;
                case 3:
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
            return new DataTypeReadRequest(i, str, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataTypeReadRequest[] a(int i) {
        return new DataTypeReadRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
