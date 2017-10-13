package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Subscription;

public class f implements Creator<SubscribeRequest> {
    static void a(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, subscribeRequest.a(), i, false);
        b.a(parcel, 2, subscribeRequest.b());
        b.a(parcel, 3, subscribeRequest.c(), false);
        b.a(parcel, 1000, subscribeRequest.d());
        b.a(parcel, a);
    }

    public SubscribeRequest a(Parcel parcel) {
        IBinder iBinder = null;
        boolean z = false;
        int b = a.b(parcel);
        Subscription subscription = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int i2;
            Subscription subscription2;
            IBinder iBinder2;
            boolean z2;
            int a = a.a(parcel);
            IBinder iBinder3;
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    boolean z3 = z;
                    subscription2 = (Subscription) a.a(parcel, a, Subscription.CREATOR);
                    iBinder2 = iBinder;
                    z2 = z3;
                    break;
                case 2:
                    subscription2 = subscription;
                    i2 = i;
                    iBinder3 = iBinder;
                    z2 = a.c(parcel, a);
                    iBinder2 = iBinder3;
                    break;
                case 3:
                    iBinder2 = a.m(parcel, a);
                    z2 = z;
                    subscription2 = subscription;
                    i2 = i;
                    break;
                case 1000:
                    iBinder3 = iBinder;
                    z2 = z;
                    subscription2 = subscription;
                    i2 = a.f(parcel, a);
                    iBinder2 = iBinder3;
                    break;
                default:
                    a.b(parcel, a);
                    iBinder2 = iBinder;
                    z2 = z;
                    subscription2 = subscription;
                    i2 = i;
                    break;
            }
            i = i2;
            subscription = subscription2;
            z = z2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == b) {
            return new SubscribeRequest(i, subscription, z, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SubscribeRequest[] a(int i) {
        return new SubscribeRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
