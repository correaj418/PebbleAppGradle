package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k implements Creator<MapValue> {
    static void a(MapValue mapValue, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, mapValue.c());
        b.a(parcel, 2, mapValue.d());
        b.a(parcel, 1000, mapValue.b());
        b.a(parcel, a);
    }

    public MapValue a(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        float f = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i = a.f(parcel, a);
                    break;
                case 2:
                    f = a.j(parcel, a);
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
            return new MapValue(i2, i, f);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public MapValue[] a(int i) {
        return new MapValue[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
