package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<ResolveAccountRequest> {
    static void a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, resolveAccountRequest.a);
        b.a(parcel, 2, resolveAccountRequest.a(), i, false);
        b.a(parcel, 3, resolveAccountRequest.b());
        b.a(parcel, 4, resolveAccountRequest.c(), i, false);
        b.a(parcel, a);
    }

    public ResolveAccountRequest a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = a.b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int f;
            GoogleSignInAccount googleSignInAccount2;
            int a = a.a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (a.a(a)) {
                case 1:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    f = a.f(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 2:
                    f = i2;
                    int i4 = i;
                    account2 = (Account) a.a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case 3:
                    account2 = account;
                    f = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = a.f(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 4:
                    googleSignInAccount2 = (GoogleSignInAccount) a.a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    f = i2;
                    break;
                default:
                    a.b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    f = i2;
                    break;
            }
            i2 = f;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountRequest[] a(int i) {
        return new ResolveAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
