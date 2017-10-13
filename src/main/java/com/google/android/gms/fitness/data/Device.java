package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.cb;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Device extends AbstractSafeParcelable {
    public static final Creator<Device> CREATOR = new h();
    private final int a;
    private final String b;
    private final String c;
    private final String d = "";
    private final String e;
    private final int f;
    private final int g;

    Device(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.a = i;
        this.b = (String) b.a((Object) str);
        this.c = (String) b.a((Object) str2);
        this.e = (String) b.a((Object) str4);
        this.f = i2;
        this.g = i3;
    }

    private boolean a(Device device) {
        return ab.a(this.b, device.b) && ab.a(this.c, device.c) && ab.a(this.d, device.d) && ab.a(this.e, device.e) && this.f == device.f && this.g == device.g;
    }

    private boolean j() {
        return f() == 1;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Device) && a((Device) obj));
    }

    public int f() {
        return this.g;
    }

    String g() {
        return String.format("%s:%s:%s", new Object[]{this.b, this.c, this.e});
    }

    public String h() {
        return j() ? this.e : cb.a(this.e);
    }

    public int hashCode() {
        return ab.a(this.b, this.c, this.d, this.e, Integer.valueOf(this.f));
    }

    int i() {
        return this.a;
    }

    public String toString() {
        return String.format("Device{%s:%s:%s:%s}", new Object[]{g(), this.d, Integer.valueOf(this.f), Integer.valueOf(this.g)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.a(this, parcel, i);
    }
}
