package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.List;

public class j implements Creator<SessionReadResult> {
    static void a(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, sessionReadResult.b(), false);
        b.c(parcel, 2, sessionReadResult.c(), false);
        b.a(parcel, 3, sessionReadResult.a(), i, false);
        b.a(parcel, 1000, sessionReadResult.d());
        b.a(parcel, a);
    }

    public SessionReadResult a(Parcel parcel) {
        Status status = null;
        int b = a.b(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list2 = a.c(parcel, a, Session.CREATOR);
                    break;
                case 2:
                    list = a.c(parcel, a, SessionDataSet.CREATOR);
                    break;
                case 3:
                    status = (Status) a.a(parcel, a, Status.CREATOR);
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
            return new SessionReadResult(i, list2, list, status);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SessionReadResult[] a(int i) {
        return new SessionReadResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
