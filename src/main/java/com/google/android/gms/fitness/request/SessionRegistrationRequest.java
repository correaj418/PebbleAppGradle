package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SessionRegistrationRequest extends AbstractSafeParcelable {
    public static final Creator<SessionRegistrationRequest> CREATOR = new ag();
    private final int a;
    private final PendingIntent b;
    private final by c;
    private final int d;

    SessionRegistrationRequest(int i, PendingIntent pendingIntent, IBinder iBinder, int i2) {
        this.a = i;
        this.b = pendingIntent;
        this.c = iBinder == null ? null : a.a(iBinder);
        this.d = i2;
    }

    private boolean a(SessionRegistrationRequest sessionRegistrationRequest) {
        return this.d == sessionRegistrationRequest.d && ab.a(this.b, sessionRegistrationRequest.b);
    }

    public PendingIntent a() {
        return this.b;
    }

    public IBinder b() {
        return this.c == null ? null : this.c.asBinder();
    }

    public int c() {
        return this.d;
    }

    int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionRegistrationRequest) && a((SessionRegistrationRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b, Integer.valueOf(this.d));
    }

    public String toString() {
        return ab.a((Object) this).a("pendingIntent", this.b).a("sessionRegistrationOption", Integer.valueOf(this.d)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ag.a(this, parcel, i);
    }
}
