package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.x.a;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest extends AbstractSafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new d();
    private final int a;
    private final List<DataType> b;
    private final x c;
    private final int d;
    private final by e;

    StartBleScanRequest(int i, List<DataType> list, IBinder iBinder, int i2, IBinder iBinder2) {
        this.a = i;
        this.b = list;
        this.c = a.a(iBinder);
        this.d = i2;
        this.e = by.a.a(iBinder2);
    }

    public List<DataType> a() {
        return Collections.unmodifiableList(this.b);
    }

    public int b() {
        return this.d;
    }

    public IBinder c() {
        return this.c.asBinder();
    }

    public IBinder d() {
        return this.e == null ? null : this.e.asBinder();
    }

    int e() {
        return this.a;
    }

    public String toString() {
        return ab.a((Object) this).a("dataTypes", this.b).a("timeoutSecs", Integer.valueOf(this.d)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
