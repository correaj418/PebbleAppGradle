package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o implements Creator<Session> {
    static void a(Session session, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, session.g());
        b.a(parcel, 2, session.h());
        b.a(parcel, 3, session.a(), false);
        b.a(parcel, 4, session.b(), false);
        b.a(parcel, 5, session.c(), false);
        b.a(parcel, 7, session.d());
        b.a(parcel, 1000, session.f());
        b.a(parcel, 8, session.e(), i, false);
        b.a(parcel, 9, session.i(), false);
        b.a(parcel, a);
    }

    public Session a(Parcel parcel) {
        long j = 0;
        int i = 0;
        Long l = null;
        int b = a.b(parcel);
        Application application = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
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
                    str3 = a.l(parcel, a);
                    break;
                case 4:
                    str2 = a.l(parcel, a);
                    break;
                case 5:
                    str = a.l(parcel, a);
                    break;
                case 7:
                    i = a.f(parcel, a);
                    break;
                case 8:
                    application = (Application) a.a(parcel, a, Application.CREATOR);
                    break;
                case 9:
                    l = a.i(parcel, a);
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
            return new Session(i2, j2, j, str3, str2, str, i, application, l);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public Session[] a(int i) {
        return new Session[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
