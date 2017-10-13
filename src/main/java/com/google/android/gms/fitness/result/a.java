package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.List;

public class a implements Creator<BleDevicesResult> {
    static void a(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.c(parcel, 1, bleDevicesResult.b(), false);
        b.a(parcel, 2, bleDevicesResult.a(), i, false);
        b.a(parcel, 1000, bleDevicesResult.c());
        b.a(parcel, a);
    }

    public BleDevicesResult a(Parcel parcel) {
        Status status = null;
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, BleDevice.CREATOR);
                    break;
                case 2:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Status.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new BleDevicesResult(i, list, status);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public BleDevicesResult[] a(int i) {
        return new BleDevicesResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
