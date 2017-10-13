package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LocationRequest extends AbstractSafeParcelable {
    public static final j CREATOR = new j();
    int a;
    long b;
    long c;
    boolean d;
    long e;
    int f;
    float g;
    long h;
    private final int i;

    public LocationRequest() {
        this.i = 1;
        this.a = 102;
        this.b = 3600000;
        this.c = 600000;
        this.d = false;
        this.e = Long.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0.0f;
        this.h = 0;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.i = i;
        this.a = i2;
        this.b = j;
        this.c = j2;
        this.d = z;
        this.e = j3;
        this.f = i3;
        this.g = f;
        this.h = j4;
    }

    public static String b(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    private static void c(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    private static void d(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    int a() {
        return this.i;
    }

    public LocationRequest a(int i) {
        c(i);
        this.a = i;
        return this;
    }

    public LocationRequest a(long j) {
        d(j);
        this.b = j;
        if (!this.d) {
            this.c = (long) (((double) this.b) / 6.0d);
        }
        return this;
    }

    public LocationRequest b(long j) {
        d(j);
        this.d = true;
        this.c = j;
        return this;
    }

    public LocationRequest c(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.e = Long.MAX_VALUE;
        } else {
            this.e = elapsedRealtime + j;
        }
        if (this.e < 0) {
            this.e = 0;
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.a == locationRequest.a && this.b == locationRequest.b && this.c == locationRequest.c && this.d == locationRequest.d && this.e == locationRequest.e && this.f == locationRequest.f && this.g == locationRequest.g;
    }

    public int hashCode() {
        return ab.a(Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f), Float.valueOf(this.g));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(b(this.a));
        if (this.a != 105) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.b).append("ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.c).append("ms");
        if (this.h > this.b) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.h).append("ms");
        }
        if (this.e != Long.MAX_VALUE) {
            long elapsedRealtime = this.e - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime).append("ms");
        }
        if (this.f != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.f);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.a(this, parcel, i);
    }
}
