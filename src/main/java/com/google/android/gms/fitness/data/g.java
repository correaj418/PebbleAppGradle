package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class g implements Creator<DataType> {
    static void a(DataType dataType, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataType.a(), false);
        b.c(parcel, 2, dataType.b(), false);
        b.a(parcel, 1000, dataType.d());
        b.a(parcel, a);
    }

    public DataType a(Parcel parcel) {
        List list = null;
        int b = a.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    str = a.l(parcel, a);
                    break;
                case 2:
                    list = a.c(parcel, a, Field.CREATOR);
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
            return new DataType(i, str, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataType[] a(int i) {
        return new DataType[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
