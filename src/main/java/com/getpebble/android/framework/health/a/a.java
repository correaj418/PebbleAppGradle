package com.getpebble.android.framework.health.a;

import android.content.Context;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.au;
import com.getpebble.android.framework.health.d.c;
import com.getpebble.android.framework.health.d.c.b;
import com.getpebble.android.h.ac;
import com.getpebble.android.h.l;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class a {
    private final Context a;
    private final c b;
    private final DataSource c;
    private final DataSource d;
    private final DataSource e;
    private final DataSource f;

    public interface a {
        long a();

        String a(Context context);

        long b();

        String c();
    }

    public a(Context context, c cVar) {
        this.b = cVar;
        this.a = context;
        this.c = new com.google.android.gms.fitness.data.DataSource.a().a(context).a(DataType.a).a(0).a(context.getString(R.string.fit_walking_session)).a();
        this.d = new com.google.android.gms.fitness.data.DataSource.a().a(context).a(DataType.c).a(0).a();
        this.e = new com.google.android.gms.fitness.data.DataSource.a().a(context).a(DataType.f).a(0).a(context.getString(R.string.calories)).a();
        this.f = new com.google.android.gms.fitness.data.DataSource.a().a(context).a(DataType.n).a(0).a(context.getString(R.string.distance)).a();
    }

    public void a(c cVar) {
        for (DataSet a : b(cVar)) {
            Status status = (Status) com.google.android.gms.fitness.c.p.a(a(), a).a(30, TimeUnit.SECONDS);
            if (status.a().g() != 0) {
                f.b("FitDataProcessor", "insertActivityRecord: failed with code " + status.a().g() + " and message " + status.c() + " record: " + cVar.toString());
                au.a(com.getpebble.android.common.model.au.a.FIT_DATA_INSERT_FAILED, this.a.getContentResolver());
            }
        }
    }

    public void a(com.getpebble.android.framework.health.d.a aVar) {
        Status status = (Status) com.google.android.gms.fitness.c.n.a(a(), a((a) aVar)).a(30, TimeUnit.SECONDS);
        if (status.a().g() != 0) {
            f.b("FitDataProcessor", "insertActivitySessionRecord: failed with code " + status.a().g() + " and message " + status.c() + " record: " + aVar.toString());
            au.a(com.getpebble.android.common.model.au.a.FIT_SESSION_INSERT_FAILED, this.a.getContentResolver());
        }
    }

    private com.google.android.gms.common.api.c a() {
        com.google.android.gms.common.api.c d = this.b.d();
        if (d != null) {
            return d;
        }
        throw new IllegalStateException("GoogleApiClient is disconnected");
    }

    private List<DataSet> b(c cVar) {
        DataSet a = DataSet.a(this.c);
        DataSet a2 = DataSet.a(this.e);
        DataSet a3 = DataSet.a(this.f);
        long toSeconds = TimeUnit.MINUTES.toSeconds(1);
        long j = cVar.a().b;
        long j2 = j + toSeconds;
        b[] c = cVar.c();
        int length = c.length;
        int i = 0;
        while (i < length) {
            DataPoint a4;
            b bVar = c[i];
            if (bVar.a > 0) {
                a4 = a.a();
                a4.a(j, j2, TimeUnit.SECONDS);
                a4.a(Field.d).a(bVar.a);
                a.a(a4);
            }
            a4 = a2.a();
            a4.a(j, j2, TimeUnit.SECONDS);
            a4.a(Field.v).a((float) l.GRAM_CALORIES.toKiloCalories((long) (bVar.g + bVar.f)));
            DataPoint a5 = a3.a();
            a5.a(j, j2, TimeUnit.SECONDS);
            a5.a(Field.n).a((float) ac.g(bVar.h));
            a2.a(a4);
            a3.a(a5);
            i++;
            j = j2;
            j2 += toSeconds;
        }
        List<DataSet> linkedList = new LinkedList();
        linkedList.add(a2);
        linkedList.add(a3);
        if (!a.e()) {
            linkedList.add(a);
        }
        return linkedList;
    }

    private SessionInsertRequest a(a aVar) {
        DataSet a = DataSet.a(this.d);
        DataPoint a2 = a.a();
        a2.a(aVar.a(), aVar.a() + aVar.b(), TimeUnit.SECONDS);
        a2.a(Field.a).a(aVar.c());
        a.a(a2);
        return new com.google.android.gms.fitness.request.SessionInsertRequest.a().a(new com.google.android.gms.fitness.data.Session.a().a(aVar.a(this.a)).a(aVar.a(), TimeUnit.SECONDS).b(aVar.c()).c(aVar.b(), TimeUnit.SECONDS).b(aVar.a() + aVar.b(), TimeUnit.SECONDS).a()).a(a).a();
    }
}
