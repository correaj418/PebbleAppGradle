package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.BleDevice;

public class i implements Creator<ClaimBleDeviceRequest> {
    static void a(ClaimBleDeviceRequest claimBleDeviceRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, claimBleDeviceRequest.a(), false);
        b.a(parcel, 2, claimBleDeviceRequest.b(), i, false);
        b.a(parcel, 3, claimBleDeviceRequest.c(), false);
        b.a(parcel, 1000, claimBleDeviceRequest.d());
        b.a(parcel, a);
    }

    public ClaimBleDeviceRequest a(Parcel parcel) {
        IBinder iBinder = null;
        int b = a.b(parcel);
        int i = 0;
        BleDevice bleDevice = null;
        String str = null;
        while (parcel.dataPosition() < b) {
            int i2;
            String l;
            IBinder iBinder2;
            BleDevice bleDevice2;
            int a = a.a(parcel);
            IBinder iBinder3;
            switch (a.a(a)) {
                case 1:
                    i2 = i;
                    BleDevice bleDevice3 = bleDevice;
                    l = a.l(parcel, a);
                    iBinder2 = iBinder;
                    bleDevice2 = bleDevice3;
                    break;
                case 2:
                    l = str;
                    i2 = i;
                    iBinder3 = iBinder;
                    bleDevice2 = (BleDevice) a.a(parcel, a, BleDevice.CREATOR);
                    iBinder2 = iBinder3;
                    break;
                case 3:
                    iBinder2 = a.m(parcel, a);
                    bleDevice2 = bleDevice;
                    l = str;
                    i2 = i;
                    break;
                case 1000:
                    iBinder3 = iBinder;
                    bleDevice2 = bleDevice;
                    l = str;
                    i2 = a.f(parcel, a);
                    iBinder2 = iBinder3;
                    break;
                default:
                    a.b(parcel, a);
                    iBinder2 = iBinder;
                    bleDevice2 = bleDevice;
                    l = str;
                    i2 = i;
                    break;
            }
            i = i2;
            str = l;
            bleDevice = bleDevice2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == b) {
            return new ClaimBleDeviceRequest(i, str, bleDevice, iBinder);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ClaimBleDeviceRequest[] a(int i) {
        return new ClaimBleDeviceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
