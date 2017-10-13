package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;

public class d implements Creator<DataSourceStatsResult> {
    static void a(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataSourceStatsResult.b, i, false);
        b.a(parcel, 2, dataSourceStatsResult.c);
        b.a(parcel, 3, dataSourceStatsResult.d);
        b.a(parcel, 4, dataSourceStatsResult.e);
        b.a(parcel, 5, dataSourceStatsResult.f);
        b.a(parcel, 1000, dataSourceStatsResult.a);
        b.a(parcel, a);
    }

    public DataSourceStatsResult a(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int b = a.b(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
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
                    z = a.c(parcel, a);
                    break;
                case 4:
                    j2 = a.h(parcel, a);
                    break;
                case 5:
                    j = a.h(parcel, a);
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
            return new DataSourceStatsResult(i, dataSource, j3, z, j2, j);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataSourceStatsResult[] a(int i) {
        return new DataSourceStatsResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
