package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p implements Creator<Status> {
    static void a(Status status, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, status.g());
        b.a(parcel, 2, status.c(), false);
        b.a(parcel, 3, status.b(), i, false);
        b.a(parcel, 1000, status.d());
        b.a(parcel, a);
    }

    public Status a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = a.b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i = a.f(parcel, a);
                    break;
                case 2:
                    str = a.l(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public Status[] a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
