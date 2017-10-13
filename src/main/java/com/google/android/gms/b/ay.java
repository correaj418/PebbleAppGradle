package com.google.android.gms.b;

import android.util.Log;
import com.google.android.gms.b.az.a;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ay {
    private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{av.m.b, av.A.b})));

    public static String a(DataPoint dataPoint) {
        DataType b = dataPoint.b();
        if (!aw.a(b.a())) {
            return null;
        }
        for (Field field : b.b()) {
            Value a = dataPoint.a(field);
            if (a.a()) {
                double c;
                if (field.b() == 1) {
                    c = (double) a.c();
                } else if (field.b() == 2) {
                    c = (double) a.d();
                } else {
                    continue;
                }
                a a2 = az.a().a(field.a());
                if (a2 != null && !a2.a(c)) {
                    return "Field out of range";
                }
                a a3 = az.a().a(b.a(), field.a());
                if (a3 != null) {
                    long i = dataPoint.i() - dataPoint.j();
                    if (i == 0) {
                        return c == 0.0d ? null : "DataPoint out of range";
                    } else {
                        if (!a3.a(c / ((double) i))) {
                            return "DataPoint out of range";
                        }
                    }
                } else {
                    continue;
                }
            } else if (!a.contains(field.a())) {
                return String.valueOf(field.a()).concat(" not set");
            }
        }
        return null;
    }

    public static void b(DataPoint dataPoint) {
        String a = a(dataPoint);
        if (a != null) {
            String valueOf = String.valueOf(dataPoint);
            Log.w("Fitness", new StringBuilder(String.valueOf(valueOf).length() + 20).append("Invalid data point: ").append(valueOf).toString());
            throw new IllegalArgumentException(a);
        }
    }
}
