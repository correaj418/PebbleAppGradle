package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.q;
import com.google.android.gms.location.r;
import com.google.android.gms.location.r.a;

public class LocationRequestUpdateData extends AbstractSafeParcelable {
    public static final m CREATOR = new m();
    int a;
    LocationRequestInternal b;
    r c;
    PendingIntent d;
    q e;
    f f;
    private final int g;

    LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        f fVar = null;
        this.g = i;
        this.a = i2;
        this.b = locationRequestInternal;
        this.c = iBinder == null ? null : a.a(iBinder);
        this.d = pendingIntent;
        this.e = iBinder2 == null ? null : q.a.a(iBinder2);
        if (iBinder3 != null) {
            fVar = f.a.a(iBinder3);
        }
        this.f = fVar;
    }

    public static LocationRequestUpdateData a(LocationRequestInternal locationRequestInternal, r rVar, f fVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, rVar.asBinder(), null, null, fVar != null ? fVar.asBinder() : null);
    }

    public static LocationRequestUpdateData a(q qVar, f fVar) {
        return new LocationRequestUpdateData(1, 2, null, null, null, qVar.asBinder(), fVar != null ? fVar.asBinder() : null);
    }

    public static LocationRequestUpdateData a(r rVar, f fVar) {
        return new LocationRequestUpdateData(1, 2, null, rVar.asBinder(), null, null, fVar != null ? fVar.asBinder() : null);
    }

    int a() {
        return this.g;
    }

    IBinder b() {
        return this.c == null ? null : this.c.asBinder();
    }

    IBinder c() {
        return this.e == null ? null : this.e.asBinder();
    }

    IBinder d() {
        return this.f == null ? null : this.f.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        m.a(this, parcel, i);
    }
}
