package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;

public class z implements Creator<ListSubscriptionsRequest> {
    static void a(ListSubscriptionsRequest listSubscriptionsRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, listSubscriptionsRequest.a(), i, false);
        b.a(parcel, 2, listSubscriptionsRequest.b(), false);
        b.a(parcel, 1000, listSubscriptionsRequest.c());
        b.a(parcel, a);
    }

    public ListSubscriptionsRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < b) {
            int i2;
            IBinder iBinder2;
            DataType dataType2;
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    DataType dataType3 = (DataType) a.a(parcel, a, DataType.CREATOR);
                    iBinder2 = iBinder;
                    dataType2 = dataType3;
                    break;
                case 2:
                    iBinder2 = a.m(parcel, a);
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    dataType2 = dataType;
                    i2 = a.f(parcel, a);
                    iBinder2 = iBinder3;
                    break;
                default:
                    a.b(parcel, a);
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == b) {
            return new ListSubscriptionsRequest(i, dataType, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ListSubscriptionsRequest[] a(int i) {
        return new ListSubscriptionsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
