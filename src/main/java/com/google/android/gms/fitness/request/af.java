package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class af implements Creator<SessionReadRequest> {
    static void a(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, sessionReadRequest.a(), false);
        b.a(parcel, 2, sessionReadRequest.b(), false);
        b.a(parcel, 3, sessionReadRequest.h());
        b.a(parcel, 4, sessionReadRequest.g());
        b.c(parcel, 5, sessionReadRequest.c(), false);
        b.c(parcel, 6, sessionReadRequest.d(), false);
        b.a(parcel, 7, sessionReadRequest.i());
        b.a(parcel, 1000, sessionReadRequest.k());
        b.a(parcel, 8, sessionReadRequest.f());
        b.b(parcel, 9, sessionReadRequest.e(), false);
        b.a(parcel, 10, sessionReadRequest.j(), false);
        b.a(parcel, a);
    }

    public SessionReadRequest a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    str = a.l(parcel, a);
                    break;
                case 2:
                    str2 = a.l(parcel, a);
                    break;
                case 3:
                    j = a.h(parcel, a);
                    break;
                case 4:
                    j2 = a.h(parcel, a);
                    break;
                case 5:
                    list = a.c(parcel, a, DataType.CREATOR);
                    break;
                case 6:
                    list2 = a.c(parcel, a, DataSource.CREATOR);
                    break;
                case 7:
                    z = a.c(parcel, a);
                    break;
                case 8:
                    z2 = a.c(parcel, a);
                    break;
                case 9:
                    list3 = a.t(parcel, a);
                    break;
                case 10:
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SessionReadRequest[] a(int i) {
        return new SessionReadRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
