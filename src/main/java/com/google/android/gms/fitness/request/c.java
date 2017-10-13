package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<SessionUnregistrationRequest> {
    static void a(SessionUnregistrationRequest sessionUnregistrationRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, sessionUnregistrationRequest.a(), i, false);
        b.a(parcel, 2, sessionUnregistrationRequest.b(), false);
        b.a(parcel, 1000, sessionUnregistrationRequest.c());
        b.a(parcel, a);
    }

    public SessionUnregistrationRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < b) {
            int i2;
            IBinder iBinder2;
            PendingIntent pendingIntent2;
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    PendingIntent pendingIntent3 = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 2:
                    iBinder2 = a.m(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = a.f(parcel, a);
                    iBinder2 = iBinder3;
                    break;
                default:
                    a.b(parcel, a);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
            }
            i = i2;
            pendingIntent = pendingIntent2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == b) {
            return new SessionUnregistrationRequest(i, pendingIntent, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SessionUnregistrationRequest[] a(int i) {
        return new SessionUnregistrationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
