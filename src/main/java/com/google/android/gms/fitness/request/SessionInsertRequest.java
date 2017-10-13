package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.b.au;
import com.google.android.gms.b.by;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest extends AbstractSafeParcelable {
    public static final Creator<SessionInsertRequest> CREATOR = new ae();
    private final int a;
    private final Session b;
    private final List<DataSet> c;
    private final List<DataPoint> d;
    private final by e;

    public static class a {
        private Session a;
        private List<DataSet> b = new ArrayList();
        private List<DataPoint> c = new ArrayList();
        private List<DataSource> d = new ArrayList();

        private void a(DataPoint dataPoint) {
            c(dataPoint);
            b(dataPoint);
        }

        private void b() {
            for (DataSet d : this.b) {
                for (DataPoint a : d.d()) {
                    a(a);
                }
            }
            for (DataPoint a2 : this.c) {
                a(a2);
            }
        }

        private void b(DataPoint dataPoint) {
            long a = this.a.a(TimeUnit.NANOSECONDS);
            long b = this.a.b(TimeUnit.NANOSECONDS);
            long b2 = dataPoint.b(TimeUnit.NANOSECONDS);
            long c = dataPoint.c(TimeUnit.NANOSECONDS);
            if (b2 != 0 && c != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (c > b) {
                    c = au.a(c, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = b2 >= a && c <= b;
                b.a(z, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(a), Long.valueOf(b));
                if (c != dataPoint.c(TimeUnit.NANOSECONDS)) {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.c(TimeUnit.NANOSECONDS)), Long.valueOf(c), timeUnit}));
                    dataPoint.a(b2, c, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void c(DataPoint dataPoint) {
            long a = this.a.a(TimeUnit.NANOSECONDS);
            long b = this.a.b(TimeUnit.NANOSECONDS);
            long a2 = dataPoint.a(TimeUnit.NANOSECONDS);
            if (a2 != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (a2 < a || a2 > b) {
                    a2 = au.a(a2, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = a2 >= a && a2 <= b;
                b.a(z, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(a), Long.valueOf(b));
                if (dataPoint.a(TimeUnit.NANOSECONDS) != a2) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.a(TimeUnit.NANOSECONDS)), Long.valueOf(a2), timeUnit}));
                    dataPoint.a(a2, TimeUnit.NANOSECONDS);
                }
            }
        }

        public a a(DataSet dataSet) {
            boolean z = true;
            b.b(dataSet != null, "Must specify a valid data set.");
            DataSource b = dataSet.b();
            b.a(!this.d.contains(b), "Data set for this data source %s is already added.", b);
            if (dataSet.d().isEmpty()) {
                z = false;
            }
            b.b(z, "No data points specified in the input data set.");
            this.d.add(b);
            this.b.add(dataSet);
            return this;
        }

        public a a(Session session) {
            this.a = session;
            return this;
        }

        public SessionInsertRequest a() {
            boolean z = true;
            b.a(this.a != null, (Object) "Must specify a valid session.");
            if (this.a.b(TimeUnit.MILLISECONDS) == 0) {
                z = false;
            }
            b.a(z, (Object) "Must specify a valid end time, cannot insert a continuing session.");
            b();
            return new SessionInsertRequest();
        }
    }

    SessionInsertRequest(int i, Session session, List<DataSet> list, List<DataPoint> list2, IBinder iBinder) {
        this.a = i;
        this.b = session;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = com.google.android.gms.b.by.a.a(iBinder);
    }

    public SessionInsertRequest(Session session, List<DataSet> list, List<DataPoint> list2, by byVar) {
        this.a = 3;
        this.b = session;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = byVar;
    }

    private SessionInsertRequest(a aVar) {
        this(aVar.a, aVar.b, aVar.c, null);
    }

    public SessionInsertRequest(SessionInsertRequest sessionInsertRequest, by byVar) {
        this(sessionInsertRequest.b, sessionInsertRequest.c, sessionInsertRequest.d, byVar);
    }

    private boolean a(SessionInsertRequest sessionInsertRequest) {
        return ab.a(this.b, sessionInsertRequest.b) && ab.a(this.c, sessionInsertRequest.c) && ab.a(this.d, sessionInsertRequest.d);
    }

    public Session a() {
        return this.b;
    }

    public List<DataSet> b() {
        return this.c;
    }

    public List<DataPoint> c() {
        return this.d;
    }

    public IBinder d() {
        return this.e == null ? null : this.e.asBinder();
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionInsertRequest) && a((SessionInsertRequest) obj));
    }

    public int hashCode() {
        return ab.a(this.b, this.c, this.d);
    }

    public String toString() {
        return ab.a((Object) this).a("session", this.b).a("dataSets", this.c).a("aggregateDataPoints", this.d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ae.a(this, parcel, i);
    }
}
