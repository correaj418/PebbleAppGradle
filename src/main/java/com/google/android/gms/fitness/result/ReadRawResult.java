package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;

public class ReadRawResult extends AbstractSafeParcelable implements f {
    public static final Creator<ReadRawResult> CREATOR = new i();
    private final int a;
    private final DataHolder b;
    private final List<DataHolder> c;

    ReadRawResult(int i, DataHolder dataHolder, List<DataHolder> list) {
        List singletonList;
        this.a = i;
        this.b = dataHolder;
        if (list == null) {
            singletonList = Collections.singletonList(dataHolder);
        }
        this.c = singletonList;
    }

    public Status a() {
        return new Status(this.b.e());
    }

    int b() {
        return this.a;
    }

    DataHolder c() {
        return this.b;
    }

    public List<DataHolder> d() {
        return this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        i.a(this, parcel, i);
    }
}
