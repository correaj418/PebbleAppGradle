package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.b.bj;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest extends AbstractSafeParcelable {
    public static final Creator<DataReadRequest> CREATOR = new m();
    private final int a;
    private final List<DataType> b;
    private final List<DataSource> c;
    private final long d;
    private final long e;
    private final List<DataType> f;
    private final List<DataSource> g;
    private final int h;
    private final long i;
    private final DataSource j;
    private final int k;
    private final boolean l;
    private final boolean m;
    private final bj n;
    private final List<Device> o;

    public static class a {
        private List<DataType> a = new ArrayList();
        private List<DataSource> b = new ArrayList();
        private List<DataType> c = new ArrayList();
        private List<DataSource> d = new ArrayList();
        private DataSource e;
        private long f;
        private long g;
        private int h = 0;
        private long i = 0;
        private int j = 0;
        private boolean k = false;
        private boolean l = false;
        private List<Device> m = new ArrayList();

        public a a(int i) {
            b.b(i > 0, "Invalid limit %d is specified", Integer.valueOf(i));
            this.j = i;
            return this;
        }

        public a a(long j, long j2, TimeUnit timeUnit) {
            this.f = timeUnit.toMillis(j);
            this.g = timeUnit.toMillis(j2);
            return this;
        }

        public a a(DataType dataType) {
            b.a((Object) dataType, (Object) "Attempting to use a null data type");
            b.a(!this.c.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            if (!this.a.contains(dataType)) {
                this.a.add(dataType);
            }
            return this;
        }

        public DataReadRequest a() {
            boolean z = true;
            boolean z2 = (this.b.isEmpty() && this.a.isEmpty() && this.d.isEmpty() && this.c.isEmpty()) ? false : true;
            b.a(z2, (Object) "Must add at least one data source (aggregated or detailed)");
            b.a(this.f > 0, "Invalid start time: %s", Long.valueOf(this.f));
            z2 = this.g > 0 && this.g > this.f;
            b.a(z2, "Invalid end time: %s", Long.valueOf(this.g));
            z2 = this.d.isEmpty() && this.c.isEmpty();
            if (!(z2 && this.h == 0) && (z2 || this.h == 0)) {
                z = false;
            }
            b.a(z, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest();
        }
    }

    DataReadRequest(int i, List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i2, long j3, DataSource dataSource, int i3, boolean z, boolean z2, IBinder iBinder, List<Device> list5) {
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = j;
        this.e = j2;
        this.f = list3;
        this.g = list4;
        this.h = i2;
        this.i = j3;
        this.j = dataSource;
        this.k = i3;
        this.l = z;
        this.m = z2;
        this.n = iBinder == null ? null : com.google.android.gms.b.bj.a.a(iBinder);
        if (list5 == null) {
            list5 = Collections.emptyList();
        }
        this.o = list5;
    }

    private DataReadRequest(a aVar) {
        this(aVar.a, aVar.b, aVar.f, aVar.g, aVar.c, aVar.d, aVar.h, aVar.i, aVar.e, aVar.j, false, aVar.l, null, aVar.m);
    }

    public DataReadRequest(DataReadRequest dataReadRequest, bj bjVar) {
        this(dataReadRequest.b, dataReadRequest.c, dataReadRequest.d, dataReadRequest.e, dataReadRequest.f, dataReadRequest.g, dataReadRequest.h, dataReadRequest.i, dataReadRequest.j, dataReadRequest.k, dataReadRequest.l, dataReadRequest.m, bjVar, dataReadRequest.o);
    }

    public DataReadRequest(List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, bj bjVar, List<Device> list5) {
        this(5, list, list2, j, j2, list3, list4, i, j3, dataSource, i2, z, z2, bjVar == null ? null : bjVar.asBinder(), list5);
    }

    private boolean a(DataReadRequest dataReadRequest) {
        return this.b.equals(dataReadRequest.b) && this.c.equals(dataReadRequest.c) && this.d == dataReadRequest.d && this.e == dataReadRequest.e && this.h == dataReadRequest.h && this.g.equals(dataReadRequest.g) && this.f.equals(dataReadRequest.f) && ab.a(this.j, dataReadRequest.j) && this.i == dataReadRequest.i && this.m == dataReadRequest.m;
    }

    public List<DataType> a() {
        return this.b;
    }

    public List<DataSource> b() {
        return this.c;
    }

    public List<DataType> c() {
        return this.f;
    }

    public List<DataSource> d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadRequest) && a((DataReadRequest) obj));
    }

    public DataSource f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public boolean h() {
        return this.m;
    }

    public int hashCode() {
        return ab.a(Integer.valueOf(this.h), Long.valueOf(this.d), Long.valueOf(this.e));
    }

    public boolean i() {
        return this.l;
    }

    int j() {
        return this.a;
    }

    public long k() {
        return this.e;
    }

    public long l() {
        return this.d;
    }

    public long m() {
        return this.i;
    }

    public IBinder n() {
        return this.n == null ? null : this.n.asBinder();
    }

    public List<Device> o() {
        return this.o;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.b.isEmpty()) {
            for (DataType c : this.b) {
                stringBuilder.append(c.c()).append(" ");
            }
        }
        if (!this.c.isEmpty()) {
            for (DataSource h : this.c) {
                stringBuilder.append(h.h()).append(" ");
            }
        }
        if (this.h != 0) {
            stringBuilder.append("bucket by ").append(Bucket.a(this.h));
            if (this.i > 0) {
                stringBuilder.append(" >").append(this.i).append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.f.isEmpty()) {
            for (DataType c2 : this.f) {
                stringBuilder.append(c2.c()).append(" ");
            }
        }
        if (!this.g.isEmpty()) {
            for (DataSource h2 : this.g) {
                stringBuilder.append(h2.h()).append(" ");
            }
        }
        stringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.d), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.e)}));
        if (this.j != null) {
            stringBuilder.append("activities: ").append(this.j.h());
        }
        if (this.m) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        m.a(this, parcel, i);
    }
}
