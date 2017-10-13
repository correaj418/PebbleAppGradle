package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o implements Creator<Scope> {
    static void a(Scope scope, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, scope.a);
        b.a(parcel, 2, scope.a(), false);
        b.a(parcel, a);
    }

    public Scope a(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    i = a.f(parcel, a);
                    break;
                case 2:
                    str = a.l(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Scope(i, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public Scope[] a(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
