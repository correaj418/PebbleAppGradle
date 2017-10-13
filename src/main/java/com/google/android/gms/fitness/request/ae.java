package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class ae implements Creator<SessionInsertRequest> {
    static void a(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, sessionInsertRequest.a(), i, false);
        b.c(parcel, 2, sessionInsertRequest.b(), false);
        b.c(parcel, 3, sessionInsertRequest.c(), false);
        b.a(parcel, 4, sessionInsertRequest.d(), false);
        b.a(parcel, 1000, sessionInsertRequest.e());
        b.a(parcel, a);
    }

    public SessionInsertRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        Session session = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    session = (Session) a.a(parcel, a, Session.CREATOR);
                    break;
                case 2:
                    list2 = a.c(parcel, a, DataSet.CREATOR);
                    break;
                case 3:
                    list = a.c(parcel, a, DataPoint.CREATOR);
                    break;
                case 4:
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
            return new SessionInsertRequest(i, session, list2, list, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SessionInsertRequest[] a(int i) {
        return new SessionInsertRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
