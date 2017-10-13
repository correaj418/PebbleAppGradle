package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.z;

public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        private static class a implements e {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public void a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(int i, Account account, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(AuthAccountRequest authAccountRequest, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest != null) {
                        obtain.writeInt(1);
                        authAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(ResolveAccountRequest resolveAccountRequest, z zVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest != null) {
                        obtain.writeInt(1);
                        resolveAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zVar != null ? zVar.asBinder() : null);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(u uVar, int i, boolean z) {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(CheckServerAuthResult checkServerAuthResult) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult != null) {
                        obtain.writeInt(1);
                        checkServerAuthResult.writeToParcel(obtain, 0);
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

            public void a(RecordConsentRequest recordConsentRequest, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (recordConsentRequest != null) {
                        obtain.writeInt(1);
                        recordConsentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(SignInRequest signInRequest, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (signInRequest != null) {
                        obtain.writeInt(1);
                        signInRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
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

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new a(iBinder) : (e) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            SignInRequest signInRequest = null;
            switch (i) {
                case 2:
                    AuthAccountRequest authAccountRequest;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        authAccountRequest = (AuthAccountRequest) AuthAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(authAccountRequest, com.google.android.gms.signin.internal.d.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    CheckServerAuthResult checkServerAuthResult;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        checkServerAuthResult = (CheckServerAuthResult) CheckServerAuthResult.CREATOR.createFromParcel(parcel);
                    }
                    a(checkServerAuthResult);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    ResolveAccountRequest resolveAccountRequest;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        resolveAccountRequest = (ResolveAccountRequest) ResolveAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(resolveAccountRequest, com.google.android.gms.common.internal.z.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    Account account;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(parcel);
                    }
                    a(readInt, account, com.google.android.gms.signin.internal.d.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    u a = com.google.android.gms.common.internal.u.a.a(parcel.readStrongBinder());
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    a(a, readInt2, z);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    RecordConsentRequest recordConsentRequest;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        recordConsentRequest = (RecordConsentRequest) RecordConsentRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(recordConsentRequest, com.google.android.gms.signin.internal.d.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    a(com.google.android.gms.signin.internal.d.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        signInRequest = (SignInRequest) SignInRequest.CREATOR.createFromParcel(parcel);
                    }
                    a(signInRequest, com.google.android.gms.signin.internal.d.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i);

    void a(int i, Account account, d dVar);

    void a(AuthAccountRequest authAccountRequest, d dVar);

    void a(ResolveAccountRequest resolveAccountRequest, z zVar);

    void a(u uVar, int i, boolean z);

    void a(CheckServerAuthResult checkServerAuthResult);

    void a(RecordConsentRequest recordConsentRequest, d dVar);

    void a(SignInRequest signInRequest, d dVar);

    void a(d dVar);

    void a(boolean z);
}
