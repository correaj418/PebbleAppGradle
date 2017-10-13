package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.Subscription;

public class SubscribeRequest extends AbstractSafeParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new f();
    private final int a;
    private Subscription b;
    private final boolean c;
    private final by d;

    SubscribeRequest(int i, Subscription subscription, boolean z, IBinder iBinder) {
        this.a = i;
        this.b = subscription;
        this.c = z;
        this.d = a.a(iBinder);
    }

    public Subscription a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public IBinder c() {
        return this.d == null ? null : this.d.asBinder();
    }

    int d() {
        return this.a;
    }

    public String toString() {
        return ab.a((Object) this).a("subscription", this.b).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel, i);
    }
}
