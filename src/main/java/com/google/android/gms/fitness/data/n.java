package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class n implements Creator<RawDataSet> {
    static void a(RawDataSet rawDataSet, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, rawDataSet.b);
        b.a(parcel, 2, rawDataSet.c);
        b.c(parcel, 3, rawDataSet.d, false);
        b.a(parcel, 4, rawDataSet.e);
        b.a(parcel, 1000, rawDataSet.a);
        b.a(parcel, a);
    }

    public RawDataSet a(Parcel parcel) {
        boolean z = false;
        int b = a.b(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = a.f(parcel, a);
                    break;
                case 2:
                    i = a.f(parcel, a);
                    break;
                case 3:
                    list = a.c(parcel, a, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = a.c(parcel, a);
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
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public RawDataSet[] a(int i) {
        return new RawDataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
