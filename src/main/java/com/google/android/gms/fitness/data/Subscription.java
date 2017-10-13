package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class Subscription extends AbstractSafeParcelable {
    public static final Creator<Subscription> CREATOR = new q();
    private final int a;
    private final DataSource b;
    private final DataType c;
    private final long d;
    private final int e;

    Subscription(int i, DataSource dataSource, DataType dataType, long j, int i2) {
        this.a = i;
        this.b = dataSource;
        this.c = dataType;
        this.d = j;
        this.e = i2;
    }

    private boolean a(Subscription subscription) {
        return ab.a(this.b, subscription.b) && ab.a(this.c, subscription.c) && this.d == subscription.d && this.e == subscription.e;
    }

    public DataSource a() {
        return this.b;
    }

    public DataType b() {
        return this.c;
    }

    public int c() {
        return this.e;
    }

    public long d() {
        return this.d;
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Subscription) && a((Subscription) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.b, Long.valueOf(this.d), Integer.valueOf(this.e));
    }

    public String toString() {
        return ab.a((Object) this).a("dataSource", this.b).a("dataType", this.c).a("samplingIntervalMicros", Long.valueOf(this.d)).a("accuracyMode", Integer.valueOf(this.e)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        q.a(this, parcel, i);
    }
}
