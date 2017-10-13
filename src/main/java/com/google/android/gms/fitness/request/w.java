package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class w implements Creator<GetSyncInfoRequest> {
    static void a(GetSyncInfoRequest getSyncInfoRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, getSyncInfoRequest.b(), false);
        b.a(parcel, 1000, getSyncInfoRequest.a());
        b.a(parcel, a);
    }

    public GetSyncInfoRequest a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
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
            return new GetSyncInfoRequest(i, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public GetSyncInfoRequest[] a(int i) {
        return new GetSyncInfoRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
