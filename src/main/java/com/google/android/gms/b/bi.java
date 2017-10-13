package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.result.DailyTotalResult;

public interface bi extends IInterface {

    public static abstract class a extends Binder implements bi {

        private static class a implements bi {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(DailyTotalResult dailyTotalResult) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDailyTotalCallback");
                    if (dailyTotalResult != null) {
                        obtain.writeInt(1);
                        dailyTotalResult.writeToParcel(obtain, 0);
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

        public static bi a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bi)) ? new a(iBinder) : (bi) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
                    a(parcel.readInt() != 0 ? (DailyTotalResult) DailyTotalResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IDailyTotalCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(DailyTotalResult dailyTotalResult);
}
