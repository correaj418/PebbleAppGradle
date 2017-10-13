package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.fitness.data.DataSet;

public class b implements Creator<DailyTotalResult> {
    static void a(DailyTotalResult dailyTotalResult, Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, dailyTotalResult.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, dailyTotalResult.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1000, dailyTotalResult.c());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a);
    }

    public DailyTotalResult a(Parcel parcel) {
        DataSet dataSet = null;
        int b = a.b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int i2;
            DataSet dataSet2;
            Status status2;
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) a.a(parcel, a, Status.CREATOR);
                    dataSet2 = dataSet;
                    status2 = status3;
                    break;
                case 2:
                    dataSet2 = (DataSet) a.a(parcel, a, DataSet.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    status2 = status;
                    i2 = a.f(parcel, a);
                    dataSet2 = dataSet3;
                    break;
                default:
                    a.b(parcel, a);
                    dataSet2 = dataSet;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == b) {
            return new DailyTotalResult(i, status, dataSet);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DailyTotalResult[] a(int i) {
        return new DailyTotalResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
