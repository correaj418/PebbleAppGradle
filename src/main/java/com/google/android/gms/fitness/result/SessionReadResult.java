package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.Collections;
import java.util.List;

public class SessionReadResult extends AbstractSafeParcelable implements f {
    public static final Creator<SessionReadResult> CREATOR = new j();
    private final int a;
    private final List<Session> b;
    private final List<SessionDataSet> c;
    private final Status d;

    SessionReadResult(int i, List<Session> list, List<SessionDataSet> list2, Status status) {
        this.a = i;
        this.b = list;
        this.c = Collections.unmodifiableList(list2);
        this.d = status;
    }

    private boolean a(SessionReadResult sessionReadResult) {
        return this.d.equals(sessionReadResult.d) && ab.a(this.b, sessionReadResult.b) && ab.a(this.c, sessionReadResult.c);
    }

    public Status a() {
        return this.d;
    }

    public List<Session> b() {
        return this.b;
    }

    public List<SessionDataSet> c() {
        return this.c;
    }

    int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadResult) && a((SessionReadResult) obj));
    }

    public int hashCode() {
        return ab.a(this.d, this.b, this.c);
    }

    public String toString() {
        return ab.a((Object) this).a("status", this.d).a("sessions", this.b).a("sessionDataSets", this.c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.a(this, parcel, i);
    }
}
