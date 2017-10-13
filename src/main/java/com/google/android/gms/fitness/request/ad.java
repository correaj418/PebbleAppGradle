package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ad implements Creator<SensorUnregistrationRequest> {
    static void a(SensorUnregistrationRequest sensorUnregistrationRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, sensorUnregistrationRequest.d(), false);
        b.a(parcel, 2, sensorUnregistrationRequest.a(), i, false);
        b.a(parcel, 3, sensorUnregistrationRequest.b(), false);
        b.a(parcel, 1000, sensorUnregistrationRequest.c());
        b.a(parcel, a);
    }

    public SensorUnregistrationRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < b) {
            int i2;
            IBinder m;
            IBinder iBinder3;
            PendingIntent pendingIntent2;
            int a = a.a(parcel);
            IBinder iBinder4;
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    PendingIntent pendingIntent3 = pendingIntent;
                    m = a.m(parcel, a);
                    iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 2:
                    m = iBinder2;
                    i2 = i;
                    iBinder4 = iBinder;
                    pendingIntent2 = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    iBinder3 = iBinder4;
                    break;
                case 3:
                    iBinder3 = a.m(parcel, a);
                    pendingIntent2 = pendingIntent;
                    m = iBinder2;
                    i2 = i;
                    break;
                case 1000:
                    iBinder4 = iBinder;
                    pendingIntent2 = pendingIntent;
                    m = iBinder2;
                    i2 = a.f(parcel, a);
                    iBinder3 = iBinder4;
                    break;
                default:
                    a.b(parcel, a);
                    iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent;
                    m = iBinder2;
                    i2 = i;
                    break;
            }
            i = i2;
            iBinder2 = m;
            pendingIntent = pendingIntent2;
            iBinder = iBinder3;
        }
        if (parcel.dataPosition() == b) {
            return new SensorUnregistrationRequest(i, iBinder2, pendingIntent, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SensorUnregistrationRequest[] a(int i) {
        return new SensorUnregistrationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
