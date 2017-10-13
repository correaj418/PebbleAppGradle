package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import java.util.List;

public class m implements Creator<DataReadRequest> {
    static void a(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, dataReadRequest.a(), false);
        b.c(parcel, 2, dataReadRequest.b(), false);
        b.a(parcel, 3, dataReadRequest.l());
        b.a(parcel, 4, dataReadRequest.k());
        b.c(parcel, 5, dataReadRequest.c(), false);
        b.c(parcel, 6, dataReadRequest.d(), false);
        b.a(parcel, 7, dataReadRequest.e());
        b.a(parcel, 1000, dataReadRequest.j());
        b.a(parcel, 8, dataReadRequest.m());
        b.a(parcel, 9, dataReadRequest.f(), i, false);
        b.a(parcel, 10, dataReadRequest.g());
        b.a(parcel, 12, dataReadRequest.i());
        b.a(parcel, 13, dataReadRequest.h());
        b.a(parcel, 14, dataReadRequest.n(), false);
        b.c(parcel, 16, dataReadRequest.o(), false);
        b.a(parcel, a);
    }

    public DataReadRequest a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        long j = 0;
        long j2 = 0;
        List list3 = null;
        List list4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        List list5 = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list = a.c(parcel, a, DataType.CREATOR);
                    break;
                case 2:
                    list2 = a.c(parcel, a, DataSource.CREATOR);
                    break;
                case 3:
                    j = a.h(parcel, a);
                    break;
                case 4:
                    j2 = a.h(parcel, a);
                    break;
                case 5:
                    list3 = a.c(parcel, a, DataType.CREATOR);
                    break;
                case 6:
                    list4 = a.c(parcel, a, DataSource.CREATOR);
                    break;
                case 7:
                    i2 = a.f(parcel, a);
                    break;
                case 8:
                    j3 = a.h(parcel, a);
                    break;
                case 9:
                    dataSource = (DataSource) a.a(parcel, a, DataSource.CREATOR);
                    break;
                case 10:
                    i3 = a.f(parcel, a);
                    break;
                case 12:
                    z = a.c(parcel, a);
                    break;
                case 13:
                    z2 = a.c(parcel, a);
                    break;
                case 14:
                    iBinder = a.m(parcel, a);
                    break;
                case 16:
                    list5 = a.c(parcel, a, Device.CREATOR);
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
            return new DataReadRequest(i, list, list2, j, j2, list3, list4, i2, j3, dataSource, i3, z, z2, iBinder, list5);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataReadRequest[] a(int i) {
        return new DataReadRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
