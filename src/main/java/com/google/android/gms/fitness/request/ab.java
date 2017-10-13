package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import java.util.List;

public class ab implements Creator<ReadStatsRequest> {
    static void a(ReadStatsRequest readStatsRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, readStatsRequest.b(), false);
        b.c(parcel, 3, readStatsRequest.c(), false);
        b.a(parcel, 1000, readStatsRequest.a());
        b.a(parcel, a);
    }

    public ReadStatsRequest a(Parcel parcel) {
        List list = null;
        int b = a.b(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    iBinder = a.m(parcel, a);
                    break;
                case 3:
                    list = a.c(parcel, a, DataSource.CREATOR);
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
            return new ReadStatsRequest(i, iBinder, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ReadStatsRequest[] a(int i) {
        return new ReadStatsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
