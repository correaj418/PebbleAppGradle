package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<Device> {
    static void a(Device device, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, device.a(), false);
        b.a(parcel, 2, device.b(), false);
        b.a(parcel, 3, device.c(), false);
        b.a(parcel, 4, device.h(), false);
        b.a(parcel, 5, device.e());
        b.a(parcel, 6, device.f());
        b.a(parcel, 1000, device.i());
        b.a(parcel, a);
    }

    public Device a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = a.b(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = a.a(parcel);
            switch (a.a(a)) {
                case 1:
                    str4 = a.l(parcel, a);
                    break;
                case 2:
                    str3 = a.l(parcel, a);
                    break;
                case 3:
                    str2 = a.l(parcel, a);
                    break;
                case 4:
                    str = a.l(parcel, a);
                    break;
                case 5:
                    i2 = a.f(parcel, a);
                    break;
                case 6:
                    i = a.f(parcel, a);
                    break;
                case 1000:
                    i3 = a.f(parcel, a);
                    break;
                default:
                    a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Device(i3, str4, str3, str2, str, i2, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public Device[] a(int i) {
        return new Device[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
