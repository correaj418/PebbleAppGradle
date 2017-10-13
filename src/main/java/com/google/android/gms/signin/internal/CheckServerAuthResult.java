package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class CheckServerAuthResult extends AbstractSafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR = new c();
    final int a;
    final boolean b;
    final List<Scope> c;

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.a = i;
        this.b = z;
        this.c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel, i);
    }
}
