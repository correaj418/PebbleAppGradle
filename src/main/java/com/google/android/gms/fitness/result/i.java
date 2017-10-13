package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public class i implements Creator<ReadRawResult> {
    static void a(ReadRawResult readRawResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, readRawResult.c(), i, false);
        b.c(parcel, 2, readRawResult.d(), false);
        b.a(parcel, 1000, readRawResult.b());
        b.a(parcel, a);
    }

    public ReadRawResult a(Parcel parcel) {
        List list = null;
        int b = a.b(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < b) {
            int i2;
            DataHolder dataHolder2;
            ArrayList c;
            int a = a.a(parcel);
            List list2;
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    DataHolder dataHolder3 = (DataHolder) a.a(parcel, a, DataHolder.CREATOR);
                    list2 = list;
                    dataHolder2 = dataHolder3;
                    break;
                case 2:
                    c = a.c(parcel, a, DataHolder.CREATOR);
                    dataHolder2 = dataHolder;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    dataHolder2 = dataHolder;
                    i2 = a.f(parcel, a);
                    list2 = list3;
                    break;
                default:
                    a.b(parcel, a);
                    c = list;
                    dataHolder2 = dataHolder;
                    i2 = i;
                    break;
            }
            i = i2;
            dataHolder = dataHolder2;
            Object obj = c;
        }
        if (parcel.dataPosition() == b) {
            return new ReadRawResult(i, dataHolder, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ReadRawResult[] a(int i) {
        return new ReadRawResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
