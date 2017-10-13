package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.getpebble.android.common.model.ak;
import com.google.android.gms.b.at;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;

public class BleDevice extends AbstractSafeParcelable {
    public static final Creator<BleDevice> CREATOR = new b();
    private final int a;
    private final String b;
    private final String c;
    private final List<String> d;
    private final List<DataType> e;

    BleDevice(int i, String str, String str2, List<String> list, List<DataType> list2) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = Collections.unmodifiableList(list);
        this.e = Collections.unmodifiableList(list2);
    }

    private boolean a(BleDevice bleDevice) {
        return this.c.equals(bleDevice.c) && this.b.equals(bleDevice.b) && at.a(bleDevice.d, this.d) && at.a(this.e, bleDevice.e);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public List<String> c() {
        return this.d;
    }

    public List<DataType> d() {
        return this.e;
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BleDevice) && a((BleDevice) obj));
    }

    public int hashCode() {
        return ab.a(this.c, this.b, this.d, this.e);
    }

    public String toString() {
        return ab.a((Object) this).a("name", this.c).a(ak.ADDRESS, this.b).a("dataTypes", this.e).a("supportedProfiles", this.d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
