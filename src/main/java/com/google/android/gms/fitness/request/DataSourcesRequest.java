package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bk;
import com.google.android.gms.b.bk.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class DataSourcesRequest extends AbstractSafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR = new o();
    private final int a;
    private final List<DataType> b;
    private final List<Integer> c;
    private final boolean d;
    private final bk e;

    DataSourcesRequest(int i, List<DataType> list, List<Integer> list2, boolean z, IBinder iBinder) {
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = z;
        this.e = a.a(iBinder);
    }

    public List<DataType> a() {
        return this.b;
    }

    public List<Integer> b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public IBinder d() {
        return this.e == null ? null : this.e.asBinder();
    }

    int e() {
        return this.a;
    }

    public String toString() {
        ab.a a = ab.a((Object) this).a("dataTypes", this.b).a("sourceTypes", this.c);
        if (this.d) {
            a.a("includeDbOnlySources", "true");
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        o.a(this, parcel, i);
    }
}
