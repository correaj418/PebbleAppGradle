package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

public class c implements Creator<DataReadResult> {
    static void a(DataReadResult dataReadResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.d(parcel, 1, dataReadResult.g(), false);
        b.a(parcel, 2, dataReadResult.a(), i, false);
        b.d(parcel, 3, dataReadResult.f(), false);
        b.a(parcel, 5, dataReadResult.d());
        b.c(parcel, 6, dataReadResult.h(), false);
        b.c(parcel, 7, dataReadResult.i(), false);
        b.a(parcel, 1000, dataReadResult.e());
        b.a(parcel, a);
    }

    public DataReadResult a(Parcel parcel) {
        int i = 0;
        List list = null;
        int b = a.b(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    a.a(parcel, a, arrayList, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) a.a(parcel, a, Status.CREATOR);
                    break;
                case 3:
                    a.a(parcel, a, arrayList2, getClass().getClassLoader());
                    break;
                case 5:
                    i = a.f(parcel, a);
                    break;
                case 6:
                    list2 = a.c(parcel, a, DataSource.CREATOR);
                    break;
                case 7:
                    list = a.c(parcel, a, DataType.CREATOR);
                    break;
                case 1000:
                    i2 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataReadResult[] a(int i) {
        return new DataReadResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
