package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<ConnectionResult> {
    static void a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, connectionResult.b);
        b.a(parcel, 2, connectionResult.c());
        b.a(parcel, 3, connectionResult.d(), i, false);
        b.a(parcel, 4, connectionResult.e(), false);
        b.a(parcel, a);
    }

    public ConnectionResult a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = a.b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = a.a(parcel);
            String str3;
            switch (a.a(a)) {
                case 1:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = a.f(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = a.f(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) a.a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = a.l(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    a.b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
