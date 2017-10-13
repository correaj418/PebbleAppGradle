package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class c implements Creator<Bucket> {
    static void a(Bucket bucket, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, bucket.g());
        b.a(parcel, 2, bucket.h());
        b.a(parcel, 3, bucket.a(), i, false);
        b.a(parcel, 4, bucket.b());
        b.c(parcel, 5, bucket.c(), false);
        b.a(parcel, 6, bucket.d());
        b.a(parcel, 7, bucket.e());
        b.a(parcel, 1000, bucket.f());
        b.a(parcel, a);
    }

    public Bucket a(Parcel parcel) {
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
                    list = a.c(parcel, a, DataSet.CREATOR);
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
            return new Bucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public Bucket[] a(int i) {
        return new Bucket[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
