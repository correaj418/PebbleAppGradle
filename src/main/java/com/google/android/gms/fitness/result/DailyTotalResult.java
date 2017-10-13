package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSet;

public class DailyTotalResult extends AbstractSafeParcelable implements f {
    public static final Creator<DailyTotalResult> CREATOR = new b();
    private final int a;
    private final Status b;
    private final DataSet c;

    DailyTotalResult(int i, Status status, DataSet dataSet) {
        this.a = i;
        this.b = status;
        this.c = dataSet;
    }

    private boolean a(DailyTotalResult dailyTotalResult) {
        return this.b.equals(dailyTotalResult.b) && ab.a(this.c, dailyTotalResult.c);
    }

    public Status a() {
        return this.b;
    }

    public DataSet b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DailyTotalResult) && a((DailyTotalResult) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.c);
    }

    public String toString() {
        return ab.a((Object) this).a("status", this.b).a("dataPoint", this.c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
