package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class l implements Creator<SyncInfoResult> {
    static void a(SyncInfoResult syncInfoResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, syncInfoResult.a(), i, false);
        b.a(parcel, 2, syncInfoResult.b());
        b.a(parcel, 1000, syncInfoResult.c());
        b.a(parcel, a);
    }

    public SyncInfoResult a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        Status status = null;
        long j = 0;
        while (parcel.dataPosition() < b) {
            Status status2;
            int i2;
            long j2;
            int a = a.a(parcel);
            long j3;
            switch (a.a(a)) {
                case 1:
                    j3 = j;
                    status2 = (Status) a.a(parcel, a, Status.CREATOR);
                    i2 = i;
                    j2 = j3;
                    break;
                case 2:
                    j2 = a.h(parcel, a);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    j3 = j;
                    status2 = status;
                    i2 = a.f(parcel, a);
                    j2 = j3;
                    break;
                default:
                    a.b(parcel, a);
                    j2 = j;
                    status2 = status;
                    i2 = i;
                    break;
            }
            status = status2;
            i = i2;
            j = j2;
        }
        if (parcel.dataPosition() == b) {
            return new SyncInfoResult(i, status, j);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SyncInfoResult[] a(int i) {
        return new SyncInfoResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
