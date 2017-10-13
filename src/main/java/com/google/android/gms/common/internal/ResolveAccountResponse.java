package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.u.a;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new d();
    final int a;
    IBinder b;
    private ConnectionResult c;
    private boolean d;
    private boolean e;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.a = i;
        this.b = iBinder;
        this.c = connectionResult;
        this.d = z;
        this.e = z2;
    }

    public u a() {
        return a.a(this.b);
    }

    public ConnectionResult b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.c.equals(resolveAccountResponse.c) && a().equals(resolveAccountResponse.a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
