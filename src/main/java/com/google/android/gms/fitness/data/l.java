package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class l implements Creator<RawBucket> {
    static void a(RawBucket rawBucket, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, rawBucket.b);
        b.a(parcel, 2, rawBucket.c);
        b.a(parcel, 3, rawBucket.d, i, false);
        b.a(parcel, 4, rawBucket.e);
        b.c(parcel, 5, rawBucket.f, false);
        b.a(parcel, 6, rawBucket.g);
        b.a(parcel, 7, rawBucket.h);
        b.a(parcel, 1000, rawBucket.a);
        b.a(parcel, a);
    }

    public RawBucket a(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int b = a.b(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    j2 = a.h(parcel, a);
                    break;
                case 2:
                    j = a.h(parcel, a);
                    break;
                case 3:
                    session = (Session) a.a(parcel, a, Session.CREATOR);
                    break;
                case 4:
                    i2 = a.f(parcel, a);
                    break;
                case 5:
                    list = a.c(parcel, a, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = a.f(parcel, a);
                    break;
                case 7:
                    z = a.c(parcel, a);
                    break;
                case 1000:
                    i3 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new RawBucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public RawBucket[] a(int i) {
        return new RawBucket[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
