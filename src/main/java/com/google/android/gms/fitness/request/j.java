package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;

public class j implements Creator<DailyTotalRequest> {
    static void a(DailyTotalRequest dailyTotalRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dailyTotalRequest.c(), false);
        b.a(parcel, 2, dailyTotalRequest.b(), i, false);
        b.a(parcel, 1000, dailyTotalRequest.a());
        b.a(parcel, a);
    }

    public DailyTotalRequest a(Parcel parcel) {
        DataType dataType = null;
        int b = a.b(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    iBinder = a.m(parcel, a);
                    break;
                case 2:
                    dataType = (DataType) a.a(parcel, a, DataType.CREATOR);
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
            return new DailyTotalRequest(i, iBinder, dataType);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DailyTotalRequest[] a(int i) {
        return new DailyTotalRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
