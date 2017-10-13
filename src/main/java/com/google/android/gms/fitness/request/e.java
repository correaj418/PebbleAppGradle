package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<StopBleScanRequest> {
    static void a(StopBleScanRequest stopBleScanRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, stopBleScanRequest.b(), false);
        b.a(parcel, 2, stopBleScanRequest.c(), false);
        b.a(parcel, 1000, stopBleScanRequest.a());
        b.a(parcel, a);
    }

    public StopBleScanRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    iBinder2 = a.m(parcel, a);
                    break;
                case 2:
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
            return new StopBleScanRequest(i, iBinder2, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public StopBleScanRequest[] a(int i) {
        return new StopBleScanRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
