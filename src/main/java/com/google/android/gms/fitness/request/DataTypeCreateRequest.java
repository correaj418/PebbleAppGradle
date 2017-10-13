package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bl;
import com.google.android.gms.b.bl.a;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.Field;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest extends AbstractSafeParcelable {
    public static final Creator<DataTypeCreateRequest> CREATOR = new p();
    private final int a;
    private final String b;
    private final List<Field> c;
    private final bl d;

    DataTypeCreateRequest(int i, String str, List<Field> list, IBinder iBinder) {
        this.a = i;
        this.b = str;
        this.c = Collections.unmodifiableList(list);
        this.d = a.a(iBinder);
    }

    private boolean a(DataTypeCreateRequest dataTypeCreateRequest) {
        return ab.a(this.b, dataTypeCreateRequest.b) && ab.a(this.c, dataTypeCreateRequest.c);
    }

    public String a() {
        return this.b;
    }

    public List<Field> b() {
        return this.c;
    }

    public IBinder c() {
        return this.d == null ? null : this.d.asBinder();
    }

    int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeCreateRequest) && a((DataTypeCreateRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.c);
    }

    public String toString() {
        return ab.a((Object) this).a("name", this.b).a("fields", this.c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        p.a(this, parcel, i);
    }
}
