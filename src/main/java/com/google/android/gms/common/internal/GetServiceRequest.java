package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.u.a;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new o();
    final int a;
    final int b;
    int c;
    String d;
    IBinder e;
    Scope[] f;
    Bundle g;
    Account h;
    long i;

    public GetServiceRequest(int i) {
        this.a = 3;
        this.c = i.b;
        this.b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
        if (i < 2) {
            this.h = a(iBinder);
        } else {
            this.e = iBinder;
            this.h = account;
        }
        this.f = scopeArr;
        this.g = bundle;
        this.i = j;
    }

    private Account a(IBinder iBinder) {
        return iBinder != null ? a.a(a.a(iBinder)) : null;
    }

    public GetServiceRequest a(Account account) {
        this.h = account;
        return this;
    }

    public GetServiceRequest a(Bundle bundle) {
        this.g = bundle;
        return this;
    }

    public GetServiceRequest a(u uVar) {
        if (uVar != null) {
            this.e = uVar.asBinder();
        }
        return this;
    }

    public GetServiceRequest a(String str) {
        this.d = str;
        return this;
    }

    public GetServiceRequest a(Collection<Scope> collection) {
        this.f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        o.a(this, parcel, i);
    }
}
