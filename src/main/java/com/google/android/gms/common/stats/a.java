package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<ConnectionEvent> {
    static void a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, connectionEvent.a);
        b.a(parcel, 2, connectionEvent.a());
        b.a(parcel, 4, connectionEvent.c(), false);
        b.a(parcel, 5, connectionEvent.d(), false);
        b.a(parcel, 6, connectionEvent.e(), false);
        b.a(parcel, 7, connectionEvent.f(), false);
        b.a(parcel, 8, connectionEvent.g(), false);
        b.a(parcel, 10, connectionEvent.k());
        b.a(parcel, 11, connectionEvent.j());
        b.a(parcel, 12, connectionEvent.b());
        b.a(parcel, 13, connectionEvent.h(), false);
        b.a(parcel, a);
    }

    public ConnectionEvent a(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.h(parcel, a);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, a);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, a);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionEvent[] a(int i) {
        return new ConnectionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
