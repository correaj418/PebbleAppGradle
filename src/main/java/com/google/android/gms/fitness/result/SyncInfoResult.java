package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SyncInfoResult extends AbstractSafeParcelable implements f {
    public static final Creator<SyncInfoResult> CREATOR = new l();
    private final int a;
    private final Status b;
    private final long c;

    SyncInfoResult(int i, Status status, long j) {
        this.a = i;
        this.b = status;
        this.c = j;
    }

    private boolean a(SyncInfoResult syncInfoResult) {
        return this.b.equals(syncInfoResult.b) && ab.a(Long.valueOf(this.c), Long.valueOf(syncInfoResult.c));
    }

    public Status a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SyncInfoResult) && a((SyncInfoResult) obj));
    }

    public int hashCode() {
        return ab.a(this.b, Long.valueOf(this.c));
    }

    public String toString() {
        return ab.a((Object) this).a("status", this.b).a("timestamp", Long.valueOf(this.c)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        l.a(this, parcel, i);
    }
}
