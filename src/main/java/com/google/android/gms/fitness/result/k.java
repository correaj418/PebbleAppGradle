package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.List;

public class k implements Creator<SessionStopResult> {
    static void a(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 2, sessionStopResult.a(), i, false);
        b.c(parcel, 3, sessionStopResult.b(), false);
        b.a(parcel, 1000, sessionStopResult.c());
        b.a(parcel, a);
    }

    public SessionStopResult a(Parcel parcel) {
        List list = null;
        int b = a.b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int i2;
            Status status2;
            ArrayList c;
            int a = a.a(parcel);
            List list2;
            switch (a.a(a)) {
                case 2:
                    i2 = i;
                    Status status3 = (Status) a.a(parcel, a, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 3:
                    c = a.c(parcel, a, Session.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = a.f(parcel, a);
                    list2 = list3;
                    break;
                default:
                    a.b(parcel, a);
                    c = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = c;
        }
        if (parcel.dataPosition() == b) {
            return new SessionStopResult(i, status, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SessionStopResult[] a(int i) {
        return new SessionStopResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
