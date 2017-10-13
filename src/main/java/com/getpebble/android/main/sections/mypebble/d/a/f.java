package com.getpebble.android.main.sections.mypebble.d.a;

import com.getpebble.android.common.model.a.o.e;
import com.getpebble.android.h.k;
import com.getpebble.android.h.l;
import com.getpebble.android.main.sections.mypebble.d.a.h.a;
import com.google.b.a.c;
import com.google.b.w;
import java.util.concurrent.TimeUnit;

public abstract class f {
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

    @c(a = "steps")
    public abstract Integer f();

    @c(a = "activeKiloCalories")
    public abstract Integer g();

    @c(a = "restingKiloCalories")
    public abstract Integer h();

    @c(a = "distance")
    public abstract Integer i();

    @c(a = "activeSeconds")
    public abstract Long j();

    public static f a(e eVar) {
        return new h((long) eVar.d(), ((long) eVar.d()) + TimeUnit.MINUTES.toSeconds(1), eVar.e(), null, null, Integer.valueOf(eVar.c()), Integer.valueOf((int) l.GRAM_CALORIES.toKiloCalories((long) (eVar.k() + eVar.l()))), Integer.valueOf((int) l.GRAM_CALORIES.toKiloCalories((long) (eVar.k() + eVar.k()))), Integer.valueOf((int) k.MILLIMETRES.toMetres((long) eVar.j())), Long.valueOf(TimeUnit.MINUTES.toSeconds((long) eVar.q())));
    }

    public static w<f> a(com.google.b.f fVar) {
        return new a(fVar);
    }
}
