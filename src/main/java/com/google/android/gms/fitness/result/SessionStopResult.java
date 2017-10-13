package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

public class SessionStopResult extends AbstractSafeParcelable implements f {
    public static final Creator<SessionStopResult> CREATOR = new k();
    private final int a;
    private final Status b;
    private final List<Session> c;

    SessionStopResult(int i, Status status, List<Session> list) {
        this.a = i;
        this.b = status;
        this.c = Collections.unmodifiableList(list);
    }

    private boolean a(SessionStopResult sessionStopResult) {
        return this.b.equals(sessionStopResult.b) && ab.a(this.c, sessionStopResult.c);
    }

    public Status a() {
        return this.b;
    }

    public List<Session> b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionStopResult) && a((SessionStopResult) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.c);
    }

    public String toString() {
        return ab.a((Object) this).a("status", this.b).a("sessions", this.c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        k.a(this, parcel, i);
    }
}
