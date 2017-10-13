package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new f();
    final int a;
    private final Account b;
    private final Scope[] c;
    private final String d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.a = i;
        this.b = account;
        this.c = scopeArr;
        this.d = str;
    }

    public Account a() {
        return this.b;
    }

    public Scope[] b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel, i);
    }
}
