package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bx;
import com.google.android.gms.b.bx.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SessionStopRequest extends AbstractSafeParcelable {
    public static final Creator<SessionStopRequest> CREATOR = new b();
    private final int a;
    private final String b;
    private final String c;
    private final bx d;

    SessionStopRequest(int i, String str, String str2, IBinder iBinder) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = a.a(iBinder);
    }

    private boolean a(SessionStopRequest sessionStopRequest) {
        return ab.a(this.b, sessionStopRequest.b) && ab.a(this.c, sessionStopRequest.c);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public IBinder c() {
        return this.d == null ? null : this.d.asBinder();
    }

    int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionStopRequest) && a((SessionStopRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.c);
    }

    public String toString() {
        return ab.a((Object) this).a("name", this.b).a("identifier", this.c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
