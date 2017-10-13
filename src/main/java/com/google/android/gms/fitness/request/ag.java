package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ag implements Creator<SessionRegistrationRequest> {
    static void a(SessionRegistrationRequest sessionRegistrationRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, sessionRegistrationRequest.a(), i, false);
        b.a(parcel, 2, sessionRegistrationRequest.b(), false);
        b.a(parcel, 4, sessionRegistrationRequest.c());
        b.a(parcel, 1000, sessionRegistrationRequest.d());
        b.a(parcel, a);
    }

    public SessionRegistrationRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int i = 0;
        int b = a.b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            PendingIntent pendingIntent2;
            IBinder iBinder2;
            int a = a.a(parcel);
            int i4;
            switch (a.a(a)) {
                case 1:
                    i3 = i2;
                    IBinder iBinder3 = iBinder;
                    pendingIntent2 = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    a = i;
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    pendingIntent2 = pendingIntent;
                    i3 = i2;
                    i4 = i;
                    iBinder2 = a.m(parcel, a);
                    a = i4;
                    break;
                case 4:
                    a = a.f(parcel, a);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i3 = i2;
                    break;
                case 1000:
                    i4 = i;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i3 = a.f(parcel, a);
                    a = i4;
                    break;
                default:
                    a.b(parcel, a);
                    a = i;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i3 = i2;
                    break;
            }
            i2 = i3;
            pendingIntent = pendingIntent2;
            iBinder = iBinder2;
            i = a;
        }
        if (parcel.dataPosition() == b) {
            return new SessionRegistrationRequest(i2, pendingIntent, iBinder, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SessionRegistrationRequest[] a(int i) {
        return new SessionRegistrationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
