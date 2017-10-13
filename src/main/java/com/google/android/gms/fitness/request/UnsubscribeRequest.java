package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class UnsubscribeRequest extends AbstractSafeParcelable {
    public static final Creator<UnsubscribeRequest> CREATOR = new h();
    private final int a;
    private final DataType b;
    private final DataSource c;
    private final by d;

    UnsubscribeRequest(int i, DataType dataType, DataSource dataSource, IBinder iBinder) {
        this.a = i;
        this.b = dataType;
        this.c = dataSource;
        this.d = a.a(iBinder);
    }

    private boolean a(UnsubscribeRequest unsubscribeRequest) {
        return ab.a(this.c, unsubscribeRequest.c) && ab.a(this.b, unsubscribeRequest.b);
    }

    int a() {
        return this.a;
    }

    public DataType b() {
        return this.b;
    }

    public DataSource c() {
        return this.c;
    }

    public IBinder d() {
        return this.d == null ? null : this.d.asBinder();
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof UnsubscribeRequest) && a((UnsubscribeRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.c, this.b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.a(this, parcel, i);
    }
}
