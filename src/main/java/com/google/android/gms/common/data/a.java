package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<DataHolder> {
    static void a(DataHolder dataHolder, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataHolder.c(), false);
        b.a(parcel, 2, dataHolder.d(), i, false);
        b.a(parcel, 3, dataHolder.e());
        b.a(parcel, 4, dataHolder.f(), false);
        b.a(parcel, 1000, dataHolder.b());
        b.a(parcel, a);
    }

    public DataHolder a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                case 1:
                    strArr = com.google.android.gms.common.internal.safeparcel.a.r(parcel, a);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                case 4:
                    bundle = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.a();
        return dataHolder;
    }

    public DataHolder[] a(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
