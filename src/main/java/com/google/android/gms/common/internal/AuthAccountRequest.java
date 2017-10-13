package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR = new h();
    final int a;
    final IBinder b;
    final Scope[] c;
    Integer d;
    Integer e;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.a = i;
        this.b = iBinder;
        this.c = scopeArr;
        this.d = num;
        this.e = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.a(this, parcel, i);
    }
}
