package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f implements Creator<RecordConsentRequest> {
    static void a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a = b.a(parcel);
        b.a(parcel, 1, recordConsentRequest.a);
        b.a(parcel, 2, recordConsentRequest.a(), i, false);
        b.a(parcel, 3, recordConsentRequest.b(), i, false);
        b.a(parcel, 4, recordConsentRequest.c(), false);
        b.a(parcel, a);
    }

    public RecordConsentRequest a(Parcel parcel) {
        String str = null;
        int b = a.b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int f;
            String str2;
            int a = a.a(parcel);
            String str3;
            switch (a.a(a)) {
                case 1:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = a.f(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    f = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) a.a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case 3:
                    account2 = account;
                    f = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) a.b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = a.l(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = i;
                    break;
                default:
                    a.b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = i;
                    break;
            }
            i = f;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public RecordConsentRequest[] a(int i) {
        return new RecordConsentRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
