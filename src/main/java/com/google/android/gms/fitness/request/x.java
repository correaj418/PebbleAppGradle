package com.google.android.gms.fitness.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.data.BleDevice;

public interface x extends IInterface {

    public static abstract class a extends Binder implements x {

        private static class a implements x {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    this.a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(BleDevice bleDevice) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    if (bleDevice != null) {
                        obtain.writeInt(1);
                        bleDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

        public static x a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof x)) ? new a(iBinder) : (x) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    a(parcel.readInt() != 0 ? (BleDevice) BleDevice.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    a();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.request.IBleScanCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a();

    void a(BleDevice bleDevice);
}
