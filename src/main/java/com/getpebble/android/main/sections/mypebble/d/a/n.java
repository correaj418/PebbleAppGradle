package com.getpebble.android.main.sections.mypebble.d.a;

import com.getpebble.android.common.model.a.o.e;
import com.getpebble.android.main.sections.mypebble.d.a.k.a;
import com.google.b.a.c;
import com.google.b.f;
import com.google.b.w;
import java.util.concurrent.TimeUnit;

public abstract class n {
    @c(a = "start")
    public abstract long a();

    @c(a = "end")
    public abstract long b();

    @c(a = "startTimeZoneOffset")
    public abstract int c();

    @c(a = "label")
    public abstract String d();

    @c(a = "shortLabel")
    public abstract String e();

    @c(a = "heartRate")
    public abstract Integer f();

    @c(a = "qualityWeight")
    public abstract Integer g();

    public static n a(e eVar) {
        return new k((long) eVar.d(), ((long) eVar.d()) + TimeUnit.MINUTES.toSeconds(1), eVar.e(), null, null, eVar.m(), eVar.n());
    }

    public static w<n> a(f fVar) {
        return new a(fVar);
    }
}
