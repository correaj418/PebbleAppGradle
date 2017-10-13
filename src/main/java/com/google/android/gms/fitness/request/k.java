package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class k implements Creator<DataDeleteRequest> {
    static void a(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataDeleteRequest.h());
        b.a(parcel, 2, dataDeleteRequest.g());
        b.c(parcel, 3, dataDeleteRequest.a(), false);
        b.c(parcel, 4, dataDeleteRequest.b(), false);
        b.c(parcel, 5, dataDeleteRequest.c(), false);
        b.a(parcel, 6, dataDeleteRequest.e());
        b.a(parcel, 7, dataDeleteRequest.f());
        b.a(parcel, 1000, dataDeleteRequest.d());
        b.a(parcel, 8, dataDeleteRequest.i(), false);
        b.a(parcel, a);
    }

    public DataDeleteRequest a(Parcel parcel) {
        long j = 0;
        boolean z = false;
        IBinder iBinder = null;
        int b = a.b(parcel);
        boolean z2 = false;
        List list = null;
        List list2 = null;
        List list3 = null;
        long j2 = 0;
        int i = 0;
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
                    list3 = a.c(parcel, a, DataSource.CREATOR);
                    break;
                case 4:
                    list2 = a.c(parcel, a, DataType.CREATOR);
                    break;
                case 5:
                    list = a.c(parcel, a, Session.CREATOR);
                    break;
                case 6:
                    z2 = a.c(parcel, a);
                    break;
                case 7:
                    z = a.c(parcel, a);
                    break;
                case 8:
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
            return new DataDeleteRequest(i, j2, j, list3, list2, list, z2, z, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataDeleteRequest[] a(int i) {
        return new DataDeleteRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
