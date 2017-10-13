package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class d implements Creator<StartBleScanRequest> {
    static void a(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, startBleScanRequest.a(), false);
        b.a(parcel, 2, startBleScanRequest.c(), false);
        b.a(parcel, 3, startBleScanRequest.b());
        b.a(parcel, 4, startBleScanRequest.d(), false);
        b.a(parcel, 1000, startBleScanRequest.e());
        b.a(parcel, a);
    }

    public StartBleScanRequest a(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int b = a.b(parcel);
        IBinder iBinder2 = null;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list = a.c(parcel, a, DataType.CREATOR);
                    break;
                case 2:
                    iBinder2 = a.m(parcel, a);
                    break;
                case 3:
                    i = a.f(parcel, a);
                    break;
                case 4:
                    iBinder = a.m(parcel, a);
                    break;
                case 1000:
                    i2 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StartBleScanRequest(i2, list, iBinder2, i, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public StartBleScanRequest[] a(int i) {
        return new StartBleScanRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
