package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerUnregistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.GetSyncInfoRequest;
import com.google.android.gms.fitness.request.ReadRawRequest;
import com.google.android.gms.fitness.request.ReadStatsRequest;

public interface bo extends IInterface {

    public static abstract class a extends Binder implements bo {

        private static class a implements bo {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(DailyTotalRequest dailyTotalRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dailyTotalRequest != null) {
                        obtain.writeInt(1);
                        dailyTotalRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(DataDeleteRequest dataDeleteRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
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

            public void a(DataInsertRequest dataInsertRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
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

            public void a(DataReadRequest dataReadRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
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

            public void a(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataUpdateListenerRegistrationRequest != null) {
                        obtain.writeInt(1);
                        dataUpdateListenerRegistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(DataUpdateListenerUnregistrationRequest dataUpdateListenerUnregistrationRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataUpdateListenerUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        dataUpdateListenerUnregistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(DataUpdateRequest dataUpdateRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataUpdateRequest != null) {
                        obtain.writeInt(1);
                        dataUpdateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(GetSyncInfoRequest getSyncInfoRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (getSyncInfoRequest != null) {
                        obtain.writeInt(1);
                        getSyncInfoRequest.writeToParcel(obtain, 0);
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

            public void a(ReadRawRequest readRawRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (readRawRequest != null) {
                        obtain.writeInt(1);
                        readRawRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ReadStatsRequest readStatsRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (readStatsRequest != null) {
                        obtain.writeInt(1);
                        readStatsRequest.writeToParcel(obtain, 0);
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

            public IBinder asBinder() {
                return this.a;
            }

            public void b(DataInsertRequest dataInsertRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static bo a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bo)) ? new a(iBinder) : (bo) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            DataUpdateListenerUnregistrationRequest dataUpdateListenerUnregistrationRequest = null;
            DataInsertRequest dataInsertRequest;
            switch (i) {
                case 1:
                    DataReadRequest dataReadRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataReadRequest = (DataReadRequest) DataReadRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataReadRequest);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataInsertRequest = (DataInsertRequest) DataInsertRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataInsertRequest);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    DataDeleteRequest dataDeleteRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataDeleteRequest = (DataDeleteRequest) DataDeleteRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataDeleteRequest);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    GetSyncInfoRequest getSyncInfoRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        getSyncInfoRequest = (GetSyncInfoRequest) GetSyncInfoRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(getSyncInfoRequest);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    ReadStatsRequest readStatsRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        readStatsRequest = (ReadStatsRequest) ReadStatsRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(readStatsRequest);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    ReadRawRequest readRawRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        readRawRequest = (ReadRawRequest) ReadRawRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(readRawRequest);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    DailyTotalRequest dailyTotalRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dailyTotalRequest = (DailyTotalRequest) DailyTotalRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dailyTotalRequest);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataInsertRequest = (DataInsertRequest) DataInsertRequest.CREATOR.createFromParcel(parcel);
                    }
                    b(dataInsertRequest);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    DataUpdateRequest dataUpdateRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataUpdateRequest = (DataUpdateRequest) DataUpdateRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataUpdateRequest);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataUpdateListenerRegistrationRequest = (DataUpdateListenerRegistrationRequest) DataUpdateListenerRegistrationRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataUpdateListenerRegistrationRequest);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataUpdateListenerUnregistrationRequest = (DataUpdateListenerUnregistrationRequest) DataUpdateListenerUnregistrationRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(dataUpdateListenerUnregistrationRequest);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(DailyTotalRequest dailyTotalRequest);

    void a(DataDeleteRequest dataDeleteRequest);

    void a(DataInsertRequest dataInsertRequest);

    void a(DataReadRequest dataReadRequest);

    void a(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest);

    void a(DataUpdateListenerUnregistrationRequest dataUpdateListenerUnregistrationRequest);

    void a(DataUpdateRequest dataUpdateRequest);

    void a(GetSyncInfoRequest getSyncInfoRequest);

    void a(ReadRawRequest readRawRequest);

    void a(ReadStatsRequest readStatsRequest);

    void b(DataInsertRequest dataInsertRequest);
}
