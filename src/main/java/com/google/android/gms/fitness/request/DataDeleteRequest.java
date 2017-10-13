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
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

public class DataDeleteRequest extends AbstractSafeParcelable {
    public static final Creator<DataDeleteRequest> CREATOR = new k();
    private final int a;
    private final long b;
    private final long c;
    private final List<DataSource> d;
    private final List<DataType> e;
    private final List<Session> f;
    private final boolean g;
    private final boolean h;
    private final by i;

    DataDeleteRequest(int i, long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, IBinder iBinder) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = Collections.unmodifiableList(list);
        this.e = Collections.unmodifiableList(list2);
        this.f = list3;
        this.g = z;
        this.h = z2;
        this.i = a.a(iBinder);
    }

    private boolean a(DataDeleteRequest dataDeleteRequest) {
        return this.b == dataDeleteRequest.b && this.c == dataDeleteRequest.c && ab.a(this.d, dataDeleteRequest.d) && ab.a(this.e, dataDeleteRequest.e) && ab.a(this.f, dataDeleteRequest.f) && this.g == dataDeleteRequest.g && this.h == dataDeleteRequest.h;
    }

    public List<DataSource> a() {
        return this.d;
    }

    public List<DataType> b() {
        return this.e;
    }

    public List<Session> c() {
        return this.f;
    }

    int d() {
        return this.a;
    }

    public boolean e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataDeleteRequest) && a((DataDeleteRequest) obj));
    }

    public boolean f() {
        return this.h;
    }

    public long g() {
        return this.c;
    }

    public long h() {
        return this.b;
    }

    public int hashCode() {
        return ab.a(Long.valueOf(this.b), Long.valueOf(this.c));
    }

    public IBinder i() {
        return this.i == null ? null : this.i.asBinder();
    }

    public String toString() {
        return ab.a((Object) this).a("startTimeMillis", Long.valueOf(this.b)).a("endTimeMillis", Long.valueOf(this.c)).a("dataSources", this.d).a("dateTypes", this.e).a("sessions", this.f).a("deleteAllData", Boolean.valueOf(this.g)).a("deleteAllSessions", Boolean.valueOf(this.h)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        k.a(this, parcel, i);
    }
}
