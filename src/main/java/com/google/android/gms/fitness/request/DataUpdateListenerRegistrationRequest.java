package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class DataUpdateListenerRegistrationRequest extends AbstractSafeParcelable {
    public static final Creator<DataUpdateListenerRegistrationRequest> CREATOR = new r();
    private final int a;
    private DataSource b;
    private DataType c;
    private final PendingIntent d;
    private final by e;

    DataUpdateListenerRegistrationRequest(int i, DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder iBinder) {
        this.a = i;
        this.b = dataSource;
        this.c = dataType;
        this.d = pendingIntent;
        this.e = a.a(iBinder);
    }

    private boolean a(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return ab.a(this.b, dataUpdateListenerRegistrationRequest.b) && ab.a(this.c, dataUpdateListenerRegistrationRequest.c) && ab.a(this.d, dataUpdateListenerRegistrationRequest.d);
    }

    public DataSource a() {
        return this.b;
    }

    public DataType b() {
        return this.c;
    }

    public PendingIntent c() {
        return this.d;
    }

    public IBinder d() {
        return this.e == null ? null : this.e.asBinder();
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataUpdateListenerRegistrationRequest) && a((DataUpdateListenerRegistrationRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.c, this.d);
    }

    public String toString() {
        return ab.a((Object) this).a("dataSource", this.b).a("dataType", this.c).a("pendingIntent", this.d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        r.a(this, parcel, i);
    }
}
