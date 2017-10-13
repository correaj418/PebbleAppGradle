package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import java.util.List;

public class e implements Creator<DataSourcesResult> {
    static void a(DataSourcesResult dataSourcesResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, dataSourcesResult.b(), false);
        b.a(parcel, 2, dataSourcesResult.a(), i, false);
        b.a(parcel, 1000, dataSourcesResult.c());
        b.a(parcel, a);
    }

    public DataSourcesResult a(Parcel parcel) {
        Status status = null;
        int b = a.b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list = a.c(parcel, a, DataSource.CREATOR);
                    break;
                case 2:
                    status = (Status) a.a(parcel, a, Status.CREATOR);
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
            return new DataSourcesResult(i, list, status);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataSourcesResult[] a(int i) {
        return new DataSourcesResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
