package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.Session;

public class SessionStartRequest extends AbstractSafeParcelable {
    public static final Creator<SessionStartRequest> CREATOR = new a();
    private final int a;
    private final Session b;
    private final by c;

    SessionStartRequest(int i, Session session, IBinder iBinder) {
        this.a = i;
        this.b = session;
        this.c = a.a(iBinder);
    }

    private boolean a(SessionStartRequest sessionStartRequest) {
        return ab.a(this.b, sessionStartRequest.b);
    }

    public Session a() {
        return this.b;
    }

    public IBinder b() {
        return this.c == null ? null : this.c.asBinder();
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionStartRequest) && a((SessionStartRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b);
    }

    public String toString() {
        return ab.a((Object) this).a("session", this.b).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
