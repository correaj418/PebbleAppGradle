package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class r implements Creator<DataUpdateListenerRegistrationRequest> {
    static void a(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, dataUpdateListenerRegistrationRequest.a(), i, false);
        b.a(parcel, 2, dataUpdateListenerRegistrationRequest.b(), i, false);
        b.a(parcel, 3, dataUpdateListenerRegistrationRequest.c(), i, false);
        b.a(parcel, 4, dataUpdateListenerRegistrationRequest.d(), false);
        b.a(parcel, 1000, dataUpdateListenerRegistrationRequest.e());
        b.a(parcel, a);
    }

    public DataUpdateListenerRegistrationRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        DataType dataType = null;
        DataSource dataSource = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    dataSource = (DataSource) a.a(parcel, a, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) a.a(parcel, a, DataType.CREATOR);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 4:
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
            return new DataUpdateListenerRegistrationRequest(i, dataSource, dataType, pendingIntent, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public DataUpdateListenerRegistrationRequest[] a(int i) {
        return new DataUpdateListenerRegistrationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
