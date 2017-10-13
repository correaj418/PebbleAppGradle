package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;

public interface bn extends IInterface {

    public static abstract class a extends Binder implements bn {

        private static class a implements bn {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(DataTypeCreateRequest dataTypeCreateRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (dataTypeCreateRequest != null) {
                        obtain.writeInt(1);
                        dataTypeCreateRequest.writeToParcel(obtain, 0);
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

            public void a(DataTypeReadRequest dataTypeReadRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (dataTypeReadRequest != null) {
                        obtain.writeInt(1);
                        dataTypeReadRequest.writeToParcel(obtain, 0);
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

            public void a(DisableFitRequest disableFitRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (disableFitRequest != null) {
                        obtain.writeInt(1);
                        disableFitRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(22, obtain, obtain2, 0);
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

        public static bn a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bn)) ? new a(iBinder) : (bn) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            DisableFitRequest disableFitRequest = null;
            switch (i) {
                case 1:
                    DataTypeCreateRequest dataTypeCreateRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (parcel.readInt() != 0) {
                        dataTypeCreateRequest = (DataTypeCreateRequest) DataTypeCreateRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataTypeCreateRequest);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    DataTypeReadRequest dataTypeReadRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (parcel.readInt() != 0) {
                        dataTypeReadRequest = (DataTypeReadRequest) DataTypeReadRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataTypeReadRequest);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (parcel.readInt() != 0) {
                        disableFitRequest = (DisableFitRequest) DisableFitRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(disableFitRequest);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(DataTypeCreateRequest dataTypeCreateRequest);

    void a(DataTypeReadRequest dataTypeReadRequest);

    void a(DisableFitRequest disableFitRequest);
}
