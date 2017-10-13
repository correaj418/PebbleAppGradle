package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;

public interface br extends IInterface {

    public static abstract class a extends Binder implements br {

        private static class a implements br {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(DataSourcesRequest dataSourcesRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
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

            public void a(SensorRegistrationRequest sensorRegistrationRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (sensorRegistrationRequest != null) {
                        obtain.writeInt(1);
                        sensorRegistrationRequest.writeToParcel(obtain, 0);
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

            public void a(SensorUnregistrationRequest sensorUnregistrationRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (sensorUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        sensorUnregistrationRequest.writeToParcel(obtain, 0);
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

            public IBinder asBinder() {
                return this.a;
            }
        }

        public static br a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof br)) ? new a(iBinder) : (br) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            SensorUnregistrationRequest sensorUnregistrationRequest = null;
            switch (i) {
                case 1:
                    DataSourcesRequest dataSourcesRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataSourcesRequest);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    SensorRegistrationRequest sensorRegistrationRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        sensorRegistrationRequest = (SensorRegistrationRequest) SensorRegistrationRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(sensorRegistrationRequest);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        sensorUnregistrationRequest = (SensorUnregistrationRequest) SensorUnregistrationRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(sensorUnregistrationRequest);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(DataSourcesRequest dataSourcesRequest);

    void a(SensorRegistrationRequest sensorRegistrationRequest);

    void a(SensorUnregistrationRequest sensorUnregistrationRequest);
}
