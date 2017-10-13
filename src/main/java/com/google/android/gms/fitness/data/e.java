package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public class e implements Creator<DataSet> {
    static void a(DataSet dataSet, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataSet.b(), i, false);
        b.a(parcel, 2, dataSet.c(), i, false);
        b.d(parcel, 3, dataSet.h(), false);
        b.c(parcel, 4, dataSet.i(), false);
        b.a(parcel, 5, dataSet.f());
        b.a(parcel, 1000, dataSet.g());
        b.a(parcel, a);
    }

    public DataSet a(Parcel parcel) {
        boolean z = false;
        List list = null;
        int b = a.b(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    dataSource = (DataSource) a.a(parcel, a, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) a.a(parcel, a, DataType.CREATOR);
                    break;
                case 3:
                    a.a(parcel, a, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    list = a.c(parcel, a, DataSource.CREATOR);
                    break;
                case 5:
                    z = a.c(parcel, a);
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
            return new DataSet(i, dataSource, dataType, arrayList, list, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataSet[] a(int i) {
        return new DataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
