package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;

public class n implements Creator<DataSourceQueryParams> {
    static void a(DataSourceQueryParams dataSourceQueryParams, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataSourceQueryParams.b, i, false);
        b.a(parcel, 2, dataSourceQueryParams.c);
        b.a(parcel, 3, dataSourceQueryParams.d);
        b.a(parcel, 4, dataSourceQueryParams.e);
        b.a(parcel, 5, dataSourceQueryParams.f);
        b.a(parcel, 6, dataSourceQueryParams.g);
        b.a(parcel, 1000, dataSourceQueryParams.a);
        b.a(parcel, a);
    }

    public DataSourceQueryParams a(Parcel parcel) {
        long j = 0;
        int i = 0;
        int b = a.b(parcel);
        DataSource dataSource = null;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    dataSource = (DataSource) a.a(parcel, a, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = a.h(parcel, a);
                    break;
                case 3:
                    j2 = a.h(parcel, a);
                    break;
                case 4:
                    j = a.h(parcel, a);
                    break;
                case 5:
                    i2 = a.f(parcel, a);
                    break;
                case 6:
                    i = a.f(parcel, a);
                    break;
                case 1000:
                    i3 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DataSourceQueryParams(i3, dataSource, j3, j2, j, i2, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataSourceQueryParams[] a(int i) {
        return new DataSourceQueryParams[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
