package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Subscription;
import java.util.List;

public class h implements Creator<ListSubscriptionsResult> {
    static void a(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, listSubscriptionsResult.b(), false);
        b.a(parcel, 2, listSubscriptionsResult.a(), i, false);
        b.a(parcel, 1000, listSubscriptionsResult.c());
        b.a(parcel, a);
    }

    public ListSubscriptionsResult a(Parcel parcel) {
        Status status = null;
        int b = a.b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list = a.c(parcel, a, Subscription.CREATOR);
                    break;
                case 2:
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
            return new ListSubscriptionsResult(i, list, status);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ListSubscriptionsResult[] a(int i) {
        return new ListSubscriptionsResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
