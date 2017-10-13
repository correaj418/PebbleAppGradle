package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.j;
import com.google.android.gms.fitness.data.j.a;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.ClientIdentity;
import java.util.Collections;
import java.util.List;

public class SensorRegistrationRequest extends AbstractSafeParcelable {
    public static final Creator<SensorRegistrationRequest> CREATOR = new ac();
    int a;
    int b;
    private final int c;
    private DataSource d;
    private DataType e;
    private j f;
    private final long g;
    private final long h;
    private final PendingIntent i;
    private final long j;
    private final int k;
    private final List<LocationRequest> l;
    private final long m;
    private final List<ClientIdentity> n;
    private final by o;

    SensorRegistrationRequest(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4, IBinder iBinder2) {
        this.c = i;
        this.d = dataSource;
        this.e = dataType;
        this.f = iBinder == null ? null : a.a(iBinder);
        if (j == 0) {
            j = (long) i2;
        }
        this.g = j;
        this.j = j3;
        if (j2 == 0) {
            j2 = (long) i3;
        }
        this.h = j2;
        this.l = list;
        this.i = pendingIntent;
        this.k = i4;
        this.n = Collections.emptyList();
        this.m = j4;
        this.o = by.a.a(iBinder2);
    }

    private boolean a(SensorRegistrationRequest sensorRegistrationRequest) {
        return ab.a(this.d, sensorRegistrationRequest.d) && ab.a(this.e, sensorRegistrationRequest.e) && this.g == sensorRegistrationRequest.g && this.j == sensorRegistrationRequest.j && this.h == sensorRegistrationRequest.h && this.k == sensorRegistrationRequest.k && ab.a(this.l, sensorRegistrationRequest.l);
    }

    public DataSource a() {
        return this.d;
    }

    public DataType b() {
        return this.e;
    }

    public PendingIntent c() {
        return this.i;
    }

    public long d() {
        return this.j;
    }

    public long e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRegistrationRequest) && a((SensorRegistrationRequest) obj));
    }

    public long f() {
        return this.h;
    }

    public List<LocationRequest> g() {
        return this.l;
    }

    public int h() {
        return this.k;
    }

    public int hashCode() {
        return ab.a(this.d, this.e, this.f, Long.valueOf(this.g), Long.valueOf(this.j), Long.valueOf(this.h), Integer.valueOf(this.k), this.l);
    }

    public long i() {
        return this.m;
    }

    public IBinder j() {
        return this.o == null ? null : this.o.asBinder();
    }

    int k() {
        return this.c;
    }

    IBinder l() {
        return this.f == null ? null : this.f.asBinder();
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.e, this.d, Long.valueOf(this.g), Long.valueOf(this.j), Long.valueOf(this.h)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        ac.a(this, parcel, i);
    }
}
