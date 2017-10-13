package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SessionUnregistrationRequest extends AbstractSafeParcelable {
    public static final Creator<SessionUnregistrationRequest> CREATOR = new c();
    private final int a;
    private final PendingIntent b;
    private final by c;

    SessionUnregistrationRequest(int i, PendingIntent pendingIntent, IBinder iBinder) {
        this.a = i;
        this.b = pendingIntent;
        this.c = a.a(iBinder);
    }

    private boolean a(SessionUnregistrationRequest sessionUnregistrationRequest) {
        return ab.a(this.b, sessionUnregistrationRequest.b);
    }

    public PendingIntent a() {
        return this.b;
    }

    public IBinder b() {
        return this.c == null ? null : this.c.asBinder();
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionUnregistrationRequest) && a((SessionUnregistrationRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b);
    }

    public String toString() {
        return ab.a((Object) this).a("pendingIntent", this.b).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel, i);
    }
}
