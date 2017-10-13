package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface x extends IInterface {

    public static abstract class a extends Binder implements x {

        private static class a implements x {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void a(int i, IBinder iBinder, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsCallbacks");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public IBinder asBinder() {
                return this.a;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
        }

        public static x a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof x)) ? new a(iBinder) : (x) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            int readInt;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                    readInt = parcel.readInt();
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    a(readInt, readStrongBinder, bundle);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    a(readInt, bundle);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i, Bundle bundle);

    void a(int i, IBinder iBinder, Bundle bundle);
}
