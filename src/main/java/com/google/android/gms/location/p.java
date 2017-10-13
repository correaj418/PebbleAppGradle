package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class p implements Creator<GestureRequest> {
    static void a(GestureRequest gestureRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, gestureRequest.b(), false);
        b.a(parcel, 1000, gestureRequest.a());
        b.a(parcel, a);
    }

    public GestureRequest a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    list = a.s(parcel, a);
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
            return new GestureRequest(i, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public GestureRequest[] a(int i) {
        return new GestureRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
