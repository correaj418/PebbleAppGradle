package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q implements Creator<Subscription> {
    static void a(Subscription subscription, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, subscription.a(), i, false);
        b.a(parcel, 2, subscription.b(), i, false);
        b.a(parcel, 3, subscription.d());
        b.a(parcel, 4, subscription.c());
        b.a(parcel, 1000, subscription.e());
        b.a(parcel, a);
    }

    public Subscription a(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int b = a.b(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
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
                    j = a.h(parcel, a);
                    break;
                case 4:
                    i = a.f(parcel, a);
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
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public Subscription[] a(int i) {
        return new Subscription[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
