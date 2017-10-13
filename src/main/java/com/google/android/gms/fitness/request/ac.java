package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class ac implements Creator<SensorRegistrationRequest> {
    static void a(SensorRegistrationRequest sensorRegistrationRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, sensorRegistrationRequest.a(), i, false);
        b.a(parcel, 2, sensorRegistrationRequest.b(), i, false);
        b.a(parcel, 3, sensorRegistrationRequest.l(), false);
        b.a(parcel, 4, sensorRegistrationRequest.a);
        b.a(parcel, 5, sensorRegistrationRequest.b);
        b.a(parcel, 6, sensorRegistrationRequest.e());
        b.a(parcel, 7, sensorRegistrationRequest.f());
        b.a(parcel, 1000, sensorRegistrationRequest.k());
        b.a(parcel, 8, sensorRegistrationRequest.c(), i, false);
        b.a(parcel, 9, sensorRegistrationRequest.d());
        b.a(parcel, 10, sensorRegistrationRequest.h());
        b.c(parcel, 11, sensorRegistrationRequest.g(), false);
        b.a(parcel, 12, sensorRegistrationRequest.i());
        b.a(parcel, 13, sensorRegistrationRequest.j(), false);
        b.a(parcel, a);
    }

    public SensorRegistrationRequest a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        IBinder iBinder2 = null;
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
                    iBinder = a.m(parcel, a);
                    break;
                case 4:
                    i2 = a.f(parcel, a);
                    break;
                case 5:
                    i3 = a.f(parcel, a);
                    break;
                case 6:
                    j = a.h(parcel, a);
                    break;
                case 7:
                    j2 = a.h(parcel, a);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = a.h(parcel, a);
                    break;
                case 10:
                    i4 = a.f(parcel, a);
                    break;
                case 11:
                    list = a.c(parcel, a, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = a.h(parcel, a);
                    break;
                case 13:
                    iBinder2 = a.m(parcel, a);
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
            return new SensorRegistrationRequest(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4, iBinder2);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SensorRegistrationRequest[] a(int i) {
        return new SensorRegistrationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
