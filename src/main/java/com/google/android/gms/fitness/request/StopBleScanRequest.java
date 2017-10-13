package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.request.x.a;

public class StopBleScanRequest extends AbstractSafeParcelable {
    public static final Creator<StopBleScanRequest> CREATOR = new e();
    private final int a;
    private final x b;
    private final by c;

    StopBleScanRequest(int i, IBinder iBinder, IBinder iBinder2) {
        this.a = i;
        this.b = a.a(iBinder);
        this.c = by.a.a(iBinder2);
    }

    int a() {
        return this.a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    public IBinder c() {
        return this.c == null ? null : this.c.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }
}
