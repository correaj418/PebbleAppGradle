package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ConnectionEvent extends StatsEvent {
    public static final Creator<ConnectionEvent> CREATOR = new a();
    final int a;
    private final long b;
    private int c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final long j;
    private final long k;
    private long l;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.l = -1;
        this.h = str5;
        this.i = str6;
        this.j = j2;
        this.k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public long a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    public long i() {
        return this.l;
    }

    public long j() {
        return this.k;
    }

    public long k() {
        return this.j;
    }

    public String l() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(c());
        String valueOf3 = String.valueOf(d());
        String valueOf4 = String.valueOf("\t");
        String valueOf5 = String.valueOf(e());
        String valueOf6 = String.valueOf(f());
        String valueOf7 = String.valueOf("\t");
        String str = this.h == null ? "" : this.h;
        String valueOf8 = String.valueOf("\t");
        return new StringBuilder(((((((((String.valueOf(valueOf).length() + 22) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(valueOf7).length()) + String.valueOf(str).length()) + String.valueOf(valueOf8).length()).append(valueOf).append(valueOf2).append("/").append(valueOf3).append(valueOf4).append(valueOf5).append("/").append(valueOf6).append(valueOf7).append(str).append(valueOf8).append(j()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
