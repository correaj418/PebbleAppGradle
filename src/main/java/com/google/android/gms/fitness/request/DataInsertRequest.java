package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.by;
import com.google.android.gms.b.by.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSet;

public class DataInsertRequest extends AbstractSafeParcelable {
    public static final Creator<DataInsertRequest> CREATOR = new l();
    private final int a;
    private final DataSet b;
    private final by c;
    private final boolean d;

    DataInsertRequest(int i, DataSet dataSet, IBinder iBinder, boolean z) {
        this.a = i;
        this.b = dataSet;
        this.c = a.a(iBinder);
        this.d = z;
    }

    public DataInsertRequest(DataSet dataSet, by byVar, boolean z) {
        this.a = 4;
        this.b = dataSet;
        this.c = byVar;
        this.d = z;
    }

    private boolean a(DataInsertRequest dataInsertRequest) {
        return ab.a(this.b, dataInsertRequest.b);
    }

    public DataSet a() {
        return this.b;
    }

    public IBinder b() {
        return this.c == null ? null : this.c.asBinder();
    }

    public boolean c() {
        return this.d;
    }

    int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataInsertRequest) && a((DataInsertRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b);
    }

    public String toString() {
        return ab.a((Object) this).a("dataSet", this.b).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        l.a(this, parcel, i);
    }
}
