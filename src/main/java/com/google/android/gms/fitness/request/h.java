package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class h implements Creator<UnsubscribeRequest> {
    static void a(UnsubscribeRequest unsubscribeRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, unsubscribeRequest.b(), i, false);
        b.a(parcel, 2, unsubscribeRequest.c(), i, false);
        b.a(parcel, 3, unsubscribeRequest.d(), false);
        b.a(parcel, 1000, unsubscribeRequest.a());
        b.a(parcel, a);
    }

    public UnsubscribeRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        while (parcel.dataPosition() < b) {
            int i2;
            DataType dataType2;
            IBinder iBinder2;
            DataSource dataSource2;
            int a = a.a(parcel);
            IBinder iBinder3;
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    DataSource dataSource3 = dataSource;
                    dataType2 = (DataType) a.a(parcel, a, DataType.CREATOR);
                    iBinder2 = iBinder;
                    dataSource2 = dataSource3;
                    break;
                case 2:
                    dataType2 = dataType;
                    i2 = i;
                    iBinder3 = iBinder;
                    dataSource2 = (DataSource) a.a(parcel, a, DataSource.CREATOR);
                    iBinder2 = iBinder3;
                    break;
                case 3:
                    iBinder2 = a.m(parcel, a);
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case 1000:
                    iBinder3 = iBinder;
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = a.f(parcel, a);
                    iBinder2 = iBinder3;
                    break;
                default:
                    a.b(parcel, a);
                    iBinder2 = iBinder;
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            dataSource = dataSource2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == b) {
            return new UnsubscribeRequest(i, dataType, dataSource, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public UnsubscribeRequest[] a(int i) {
        return new UnsubscribeRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
