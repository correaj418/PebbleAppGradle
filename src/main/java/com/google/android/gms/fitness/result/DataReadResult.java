package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.a;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult extends AbstractSafeParcelable implements f {
    public static final Creator<DataReadResult> CREATOR = new c();
    private final int a;
    private final List<DataSet> b;
    private final Status c;
    private final List<Bucket> d;
    private int e;
    private final List<DataSource> f;
    private final List<DataType> g;

    DataReadResult(int i, List<RawDataSet> list, Status status, List<RawBucket> list2, int i2, List<DataSource> list3, List<DataType> list4) {
        this.a = i;
        this.c = status;
        this.e = i2;
        this.f = list3;
        this.g = list4;
        this.b = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            this.b.add(new DataSet(dataSet, list3));
        }
        this.d = new ArrayList(list2.size());
        for (RawBucket bucket : list2) {
            this.d.add(new Bucket(bucket, list3));
        }
    }

    public DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.a = 5;
        this.b = list;
        this.c = status;
        this.d = list2;
        this.e = 1;
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static DataReadResult a(Status status, DataReadRequest dataReadRequest) {
        List arrayList = new ArrayList();
        for (DataSource a : dataReadRequest.b()) {
            arrayList.add(DataSet.a(a));
        }
        for (DataType a2 : dataReadRequest.a()) {
            arrayList.add(DataSet.a(new a().a(a2).a(1).a("Default").a()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void a(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.a(bucket)) {
                for (DataSet a : bucket.c()) {
                    a(a, bucket2.c());
                }
                return;
            }
        }
        this.d.add(bucket);
    }

    private void a(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.b().equals(dataSet.b())) {
                dataSet2.a(dataSet.d());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean b(DataReadResult dataReadResult) {
        return this.c.equals(dataReadResult.c) && ab.a(this.b, dataReadResult.b) && ab.a(this.d, dataReadResult.d);
    }

    public Status a() {
        return this.c;
    }

    public void a(DataReadResult dataReadResult) {
        for (DataSet a : dataReadResult.b()) {
            a(a, this.b);
        }
        for (Bucket a2 : dataReadResult.c()) {
            a(a2, this.d);
        }
    }

    public List<DataSet> b() {
        return this.b;
    }

    public List<Bucket> c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadResult) && b((DataReadResult) obj));
    }

    List<RawBucket> f() {
        List<RawBucket> arrayList = new ArrayList(this.d.size());
        for (Bucket rawBucket : this.d) {
            arrayList.add(new RawBucket(rawBucket, this.f, this.g));
        }
        return arrayList;
    }

    List<RawDataSet> g() {
        List<RawDataSet> arrayList = new ArrayList(this.b.size());
        for (DataSet rawDataSet : this.b) {
            arrayList.add(new RawDataSet(rawDataSet, this.f, this.g));
        }
        return arrayList;
    }

    List<DataSource> h() {
        return this.f;
    }

    public int hashCode() {
        return ab.a(this.c, this.b, this.d);
    }

    List<DataType> i() {
        return this.g;
    }

    public String toString() {
        Object obj;
        ab.a a = ab.a((Object) this).a("status", this.c);
        String str = "dataSets";
        if (this.b.size() > 5) {
            obj = this.b.size() + " data sets";
        } else {
            obj = this.b;
        }
        a = a.a(str, obj);
        str = "buckets";
        if (this.d.size() > 5) {
            obj = this.d.size() + " buckets";
        } else {
            obj = this.d;
        }
        return a.a(str, obj).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel, i);
    }
}
