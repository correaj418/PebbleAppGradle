package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SessionDataSet extends AbstractSafeParcelable {
    public static final Creator<SessionDataSet> CREATOR = new p();
    final int a;
    private final Session b;
    private final DataSet c;

    SessionDataSet(int i, Session session, DataSet dataSet) {
        this.a = i;
        this.b = session;
        this.c = dataSet;
    }

    private boolean a(SessionDataSet sessionDataSet) {
        return ab.a(this.b, sessionDataSet.b) && ab.a(this.c, sessionDataSet.c);
    }

    public Session a() {
        return this.b;
    }

    public DataSet b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionDataSet) && a((SessionDataSet) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.c);
    }

    public String toString() {
        return ab.a((Object) this).a("session", this.b).a("dataSet", this.c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        p.a(this, parcel, i);
    }
}
