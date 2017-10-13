package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m implements Creator<RawDataPoint> {
    static void a(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, rawDataPoint.b);
        b.a(parcel, 2, rawDataPoint.c);
        b.a(parcel, 3, rawDataPoint.d, i, false);
        b.a(parcel, 4, rawDataPoint.e);
        b.a(parcel, 5, rawDataPoint.f);
        b.a(parcel, 6, rawDataPoint.g);
        b.a(parcel, 7, rawDataPoint.h);
        b.a(parcel, 1000, rawDataPoint.a);
        b.a(parcel, a);
    }

    public RawDataPoint a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    j = a.h(parcel, a);
                    break;
                case 2:
                    j2 = a.h(parcel, a);
                    break;
                case 3:
                    valueArr = (Value[]) a.b(parcel, a, Value.CREATOR);
                    break;
                case 4:
                    i2 = a.f(parcel, a);
                    break;
                case 5:
                    i3 = a.f(parcel, a);
                    break;
                case 6:
                    j3 = a.h(parcel, a);
                    break;
                case 7:
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public RawDataPoint[] a(int i) {
        return new RawDataPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
