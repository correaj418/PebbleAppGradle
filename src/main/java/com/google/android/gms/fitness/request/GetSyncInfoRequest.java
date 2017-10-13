package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bz;
import com.google.android.gms.b.bz.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetSyncInfoRequest extends AbstractSafeParcelable {
    public static final Creator<GetSyncInfoRequest> CREATOR = new w();
    private final int a;
    private final bz b;

    GetSyncInfoRequest(int i, IBinder iBinder) {
        this.a = i;
        this.b = a.a(iBinder);
    }

    int a() {
        return this.a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    public String toString() {
        return String.format("GetSyncInfoRequest {%d, %s, %s}", new Object[]{Integer.valueOf(this.a), this.b});
    }

    public void writeToParcel(Parcel parcel, int i) {
        w.a(this, parcel, i);
    }
}
