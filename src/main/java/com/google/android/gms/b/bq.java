package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;

public interface bq extends IInterface {

    public static abstract class a extends Binder implements bq {

        private static class a implements bq {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(ListSubscriptionsRequest listSubscriptionsRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (listSubscriptionsRequest != null) {
                        obtain.writeInt(1);
                        listSubscriptionsRequest.writeToParcel(obtain, 0);
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

            public void a(SubscribeRequest subscribeRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (subscribeRequest != null) {
                        obtain.writeInt(1);
                        subscribeRequest.writeToParcel(obtain, 0);
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

            public void a(UnsubscribeRequest unsubscribeRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (unsubscribeRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeRequest.writeToParcel(obtain, 0);
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

            public IBinder asBinder() {
                return this.a;
            }
        }

        public static bq a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bq)) ? new a(iBinder) : (bq) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ListSubscriptionsRequest listSubscriptionsRequest = null;
            switch (i) {
                case 1:
                    SubscribeRequest subscribeRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        subscribeRequest = (SubscribeRequest) SubscribeRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(subscribeRequest);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    UnsubscribeRequest unsubscribeRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        unsubscribeRequest = (UnsubscribeRequest) UnsubscribeRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(unsubscribeRequest);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        listSubscriptionsRequest = (ListSubscriptionsRequest) ListSubscriptionsRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(listSubscriptionsRequest);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(ListSubscriptionsRequest listSubscriptionsRequest);

    void a(SubscribeRequest subscribeRequest);

    void a(UnsubscribeRequest unsubscribeRequest);
}
