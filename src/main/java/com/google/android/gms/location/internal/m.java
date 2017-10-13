package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m implements Creator<LocationRequestUpdateData> {
    static void a(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, locationRequestUpdateData.a);
        b.a(parcel, 2, locationRequestUpdateData.b, i, false);
        b.a(parcel, 3, locationRequestUpdateData.b(), false);
        b.a(parcel, 4, locationRequestUpdateData.d, i, false);
        b.a(parcel, 5, locationRequestUpdateData.c(), false);
        b.a(parcel, 6, locationRequestUpdateData.d(), false);
        b.a(parcel, 1000, locationRequestUpdateData.a());
        b.a(parcel, a);
    }

    public LocationRequestUpdateData a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        int i2 = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = a.f(parcel, a);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) a.a(parcel, a, LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinder3 = a.m(parcel, a);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = a.m(parcel, a);
                    break;
                case 6:
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
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder3, pendingIntent, iBinder2, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public LocationRequestUpdateData[] a(int i) {
        return new LocationRequestUpdateData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
