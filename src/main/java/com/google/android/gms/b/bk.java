package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.result.DataSourcesResult;

public interface bk extends IInterface {

    public static abstract class a extends Binder implements bk {

        private static class a implements bk {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(DataSourcesResult dataSourcesResult) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    if (dataSourcesResult != null) {
                        obtain.writeInt(1);
                        dataSourcesResult.writeToParcel(obtain, 0);
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

        public static bk a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bk)) ? new a(iBinder) : (bk) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    a(parcel.readInt() != 0 ? (DataSourcesResult) DataSourcesResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(DataSourcesResult dataSourcesResult);
}
