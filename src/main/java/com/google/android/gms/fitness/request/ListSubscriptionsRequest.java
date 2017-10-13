package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bt;
import com.google.android.gms.b.bt.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataType;

public class ListSubscriptionsRequest extends AbstractSafeParcelable {
    public static final Creator<ListSubscriptionsRequest> CREATOR = new z();
    private final int a;
    private final DataType b;
    private final bt c;

    ListSubscriptionsRequest(int i, DataType dataType, IBinder iBinder) {
        this.a = i;
        this.b = dataType;
        this.c = a.a(iBinder);
    }

    public DataType a() {
        return this.b;
    }

    public IBinder b() {
        return this.c == null ? null : this.c.asBinder();
    }

    int c() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        z.a(this, parcel, i);
    }
}
