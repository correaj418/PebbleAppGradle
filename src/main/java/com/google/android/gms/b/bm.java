package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;

public interface bm extends IInterface {

    public static abstract class a extends Binder implements bm {

        private static class a implements bm {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(ClaimBleDeviceRequest claimBleDeviceRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (claimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        claimBleDeviceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (listClaimedBleDevicesRequest != null) {
                        obtain.writeInt(1);
                        listClaimedBleDevicesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(StartBleScanRequest startBleScanRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(StopBleScanRequest stopBleScanRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (stopBleScanRequest != null) {
                        obtain.writeInt(1);
                        stopBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(UnclaimBleDeviceRequest unclaimBleDeviceRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (unclaimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        unclaimBleDeviceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

        public static bm a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bm)) ? new a(iBinder) : (bm) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ListClaimedBleDevicesRequest listClaimedBleDevicesRequest = null;
            switch (i) {
                case 1:
                    StartBleScanRequest startBleScanRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(startBleScanRequest);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    StopBleScanRequest stopBleScanRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        stopBleScanRequest = (StopBleScanRequest) StopBleScanRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(stopBleScanRequest);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    ClaimBleDeviceRequest claimBleDeviceRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        claimBleDeviceRequest = (ClaimBleDeviceRequest) ClaimBleDeviceRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(claimBleDeviceRequest);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    UnclaimBleDeviceRequest unclaimBleDeviceRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        unclaimBleDeviceRequest = (UnclaimBleDeviceRequest) UnclaimBleDeviceRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(unclaimBleDeviceRequest);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        listClaimedBleDevicesRequest = (ListClaimedBleDevicesRequest) ListClaimedBleDevicesRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(listClaimedBleDevicesRequest);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(ClaimBleDeviceRequest claimBleDeviceRequest);

    void a(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest);

    void a(StartBleScanRequest startBleScanRequest);

    void a(StopBleScanRequest stopBleScanRequest);

    void a(UnclaimBleDeviceRequest unclaimBleDeviceRequest);
}
