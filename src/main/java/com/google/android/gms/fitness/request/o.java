package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class o implements Creator<DataSourcesRequest> {
    static void a(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, dataSourcesRequest.a(), false);
        b.a(parcel, 2, dataSourcesRequest.b(), false);
        b.a(parcel, 3, dataSourcesRequest.c());
        b.a(parcel, 4, dataSourcesRequest.d(), false);
        b.a(parcel, 1000, dataSourcesRequest.e());
        b.a(parcel, a);
    }

    public DataSourcesRequest a(Parcel parcel) {
        boolean z = false;
        IBinder iBinder = null;
        int b = a.b(parcel);
        List list = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list2 = a.c(parcel, a, DataType.CREATOR);
                    break;
                case 2:
                    list = a.s(parcel, a);
                    break;
                case 3:
                    z = a.c(parcel, a);
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
            return new DataSourcesRequest(i, list2, list, z, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataSourcesRequest[] a(int i) {
        return new DataSourcesRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
