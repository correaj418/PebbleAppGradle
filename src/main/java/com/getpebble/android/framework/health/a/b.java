package com.getpebble.android.framework.health.a;

import android.util.Pair;
import com.getpebble.android.framework.health.a.d.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class b {
    private static final long a = new GregorianCalendar(2014, 5, 25).getTimeInMillis();

    public static void a(c cVar, a aVar) {
        new d(cVar, new DataReadRequest.a().a(a, System.currentTimeMillis(), TimeUnit.MILLISECONDS).a(DataType.t).a(DataType.u).a(1).a(), aVar).submit();
    }

    public static Pair<Double, Double> a(DataReadResult dataReadResult) {
        double d = 0.0d;
        double d2 = 0.0d;
        for (DataSet d3 : dataReadResult.b()) {
            for (DataPoint dataPoint : d3.d()) {
                for (Field field : dataPoint.b().b()) {
                    if (field.a().equals("height")) {
                        d2 = (double) dataPoint.a(field).d();
                    } else if (field.a().equals("weight")) {
                        d = (double) dataPoint.a(field).d();
                    }
                }
            }
        }
        return (d2 == 0.0d && d == 0.0d) ? null : Pair.create(Double.valueOf(d2), Double.valueOf(d));
    }
}
