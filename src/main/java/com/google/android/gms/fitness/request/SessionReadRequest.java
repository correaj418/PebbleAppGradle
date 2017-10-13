package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bw;
import com.google.android.gms.b.bw.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class SessionReadRequest extends AbstractSafeParcelable {
    public static final Creator<SessionReadRequest> CREATOR = new af();
    private final int a;
    private final String b;
    private final String c;
    private final long d;
    private final long e;
    private final List<DataType> f;
    private final List<DataSource> g;
    private boolean h;
    private final boolean i;
    private final List<String> j;
    private final bw k;

    SessionReadRequest(int i, String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, IBinder iBinder) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = j2;
        this.f = list;
        this.g = list2;
        this.h = z;
        this.i = z2;
        this.j = list3;
        this.k = a.a(iBinder);
    }

    private boolean a(SessionReadRequest sessionReadRequest) {
        return ab.a(this.b, sessionReadRequest.b) && this.c.equals(sessionReadRequest.c) && this.d == sessionReadRequest.d && this.e == sessionReadRequest.e && ab.a(this.f, sessionReadRequest.f) && ab.a(this.g, sessionReadRequest.g) && this.h == sessionReadRequest.h && this.j.equals(sessionReadRequest.j) && this.i == sessionReadRequest.i;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public List<DataType> c() {
        return this.f;
    }

    public List<DataSource> d() {
        return this.g;
    }

    public List<String> e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadRequest) && a((SessionReadRequest) obj));
    }

    public boolean f() {
        return this.i;
    }

    public long g() {
        return this.e;
    }

    public long h() {
        return this.d;
    }

    public int hashCode() {
        return ab.a(this.b, this.c, Long.valueOf(this.d), Long.valueOf(this.e));
    }

    public boolean i() {
        return this.h;
    }

    public IBinder j() {
        return this.k == null ? null : this.k.asBinder();
    }

    int k() {
        return this.a;
    }

    public String toString() {
        return ab.a((Object) this).a("sessionName", this.b).a("sessionId", this.c).a("startTimeMillis", Long.valueOf(this.d)).a("endTimeMillis", Long.valueOf(this.e)).a("dataTypes", this.f).a("dataSources", this.g).a("sessionsFromAllApps", Boolean.valueOf(this.h)).a("excludedPackages", this.j).a("useServer", Boolean.valueOf(this.i)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        af.a(this, parcel, i);
    }
}
