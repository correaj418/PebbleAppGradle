package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Field;
import java.util.List;

public class p implements Creator<DataTypeCreateRequest> {
    static void a(DataTypeCreateRequest dataTypeCreateRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataTypeCreateRequest.a(), false);
        b.c(parcel, 2, dataTypeCreateRequest.b(), false);
        b.a(parcel, 3, dataTypeCreateRequest.c(), false);
        b.a(parcel, 1000, dataTypeCreateRequest.d());
        b.a(parcel, a);
    }

    public DataTypeCreateRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        List list = null;
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
                case 3:
                    iBinder = a.m(parcel, a);
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
            return new DataTypeCreateRequest(i, str, list, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataTypeCreateRequest[] a(int i) {
        return new DataTypeCreateRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
