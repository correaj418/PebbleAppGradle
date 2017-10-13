package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult extends AbstractSafeParcelable implements f {
    public static final Creator<BleDevicesResult> CREATOR = new a();
    private final int a;
    private final List<BleDevice> b;
    private final Status c;

    BleDevicesResult(int i, List<BleDevice> list, Status status) {
        this.a = i;
        this.b = Collections.unmodifiableList(list);
        this.c = status;
    }

    private boolean a(BleDevicesResult bleDevicesResult) {
        return this.c.equals(bleDevicesResult.c) && ab.a(this.b, bleDevicesResult.b);
    }

    public Status a() {
        return this.c;
    }

    public List<BleDevice> b() {
        return this.b;
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BleDevicesResult) && a((BleDevicesResult) obj));
    }

    public int hashCode() {
        return ab.a(this.c, this.b);
    }

    public String toString() {
        return ab.a((Object) this).a("status", this.c).a("bleDevices", this.b).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
