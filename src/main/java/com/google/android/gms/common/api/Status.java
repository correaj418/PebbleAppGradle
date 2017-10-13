package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Status extends AbstractSafeParcelable implements f {
    public static final Creator<Status> CREATOR = new p();
    public static final Status a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    public static final Status f = new Status(17);
    private final int g;
    private final int h;
    private final String i;
    private final PendingIntent j;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.g = i;
        this.h = i2;
        this.i = str;
        this.j = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String h() {
        return this.i != null ? this.i : b.a(this.h);
    }

    public Status a() {
        return this;
    }

    PendingIntent b() {
        return this.j;
    }

    public String c() {
        return this.i;
    }

    int d() {
        return this.g;
    }

    public boolean e() {
        return this.j != null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.g == status.g && this.h == status.h && ab.a(this.i, status.i) && ab.a(this.j, status.j);
    }

    public boolean f() {
        return this.h <= 0;
    }

    public int g() {
        return this.h;
    }

    public int hashCode() {
        return ab.a(Integer.valueOf(this.g), Integer.valueOf(this.h), this.i, this.j);
    }

    public String toString() {
        return ab.a((Object) this).a("statusCode", h()).a("resolution", this.j).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        p.a(this, parcel, i);
    }
}
