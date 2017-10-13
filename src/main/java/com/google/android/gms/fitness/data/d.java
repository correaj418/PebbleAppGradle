package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<DataPoint> {
    static void a(DataPoint dataPoint, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataPoint.c(), i, false);
        b.a(parcel, 3, dataPoint.i());
        b.a(parcel, 4, dataPoint.j());
        b.a(parcel, 5, dataPoint.a(), i, false);
        b.a(parcel, 6, dataPoint.d(), i, false);
        b.a(parcel, 7, dataPoint.e());
        b.a(parcel, 1000, dataPoint.h());
        b.a(parcel, 8, dataPoint.f());
        b.a(parcel, a);
    }

    public DataPoint a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    dataSource = (DataSource) a.a(parcel, a, DataSource.CREATOR);
                    break;
                case 3:
                    j = a.h(parcel, a);
                    break;
                case 4:
                    j2 = a.h(parcel, a);
                    break;
                case 5:
                    valueArr = (Value[]) a.b(parcel, a, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) a.a(parcel, a, DataSource.CREATOR);
                    break;
                case 7:
                    j3 = a.h(parcel, a);
                    break;
                case 8:
                    j4 = a.h(parcel, a);
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataPoint[] a(int i) {
        return new DataPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
