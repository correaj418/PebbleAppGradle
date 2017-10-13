package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i implements Creator<Field> {
    static void a(Field field, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, field.a(), false);
        b.a(parcel, 2, field.b());
        b.a(parcel, 3, field.c(), false);
        b.a(parcel, 1000, field.d());
        b.a(parcel, a);
    }

    public Field a(Parcel parcel) {
        Boolean bool = null;
        int i = 0;
        int b = a.b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    str = a.l(parcel, a);
                    break;
                case 2:
                    i = a.f(parcel, a);
                    break;
                case 3:
                    bool = a.d(parcel, a);
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
            return new Field(i2, str, i, bool);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public Field[] a(int i) {
        return new Field[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
