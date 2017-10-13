package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p implements Creator<SessionDataSet> {
    static void a(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, sessionDataSet.a(), i, false);
        b.a(parcel, 2, sessionDataSet.b(), i, false);
        b.a(parcel, 1000, sessionDataSet.a);
        b.a(parcel, a);
    }

    public SessionDataSet a(Parcel parcel) {
        DataSet dataSet = null;
        int b = a.b(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < b) {
            int i2;
            DataSet dataSet2;
            Session session2;
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    Session session3 = (Session) a.a(parcel, a, Session.CREATOR);
                    dataSet2 = dataSet;
                    session2 = session3;
                    break;
                case 2:
                    dataSet2 = (DataSet) a.a(parcel, a, DataSet.CREATOR);
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    session2 = session;
                    i2 = a.f(parcel, a);
                    dataSet2 = dataSet3;
                    break;
                default:
                    a.b(parcel, a);
                    dataSet2 = dataSet;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == b) {
            return new SessionDataSet(i, session, dataSet);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public SessionDataSet[] a(int i) {
        return new SessionDataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
