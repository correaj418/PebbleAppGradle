package com.getpebble.android.main.sections.mypebble.d.a;

import com.getpebble.android.common.model.a.o.a;
import com.getpebble.android.common.model.a.o.e;
import com.getpebble.android.h.k;
import com.getpebble.android.h.l;
import com.google.b.a.c;
import com.google.b.f;
import com.google.b.w;
import java.util.concurrent.TimeUnit;

public abstract class m {
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

    @c(a = "calories")
    public abstract Integer g();

    @c(a = "distance")
    public abstract Integer h();

    @c(a = "activeTime")
    public abstract Long i();

    public static m a(e eVar) {
        return new j((long) eVar.d(), ((long) eVar.d()) + TimeUnit.MINUTES.toSeconds(1), eVar.e(), null, null, Integer.valueOf(eVar.c()), Integer.valueOf((int) l.GRAM_CALORIES.toKiloCalories((long) (eVar.k() + eVar.l()))), Integer.valueOf((int) k.MILLIMETRES.toMetres((long) eVar.j())), Long.valueOf(TimeUnit.MINUTES.toSeconds((long) eVar.q())));
    }

    public static m a(long j, long j2, a aVar, String str, String str2) {
        return new j(j, j2, 0, str, str2, Integer.valueOf(aVar.a()), Integer.valueOf((int) l.GRAM_CALORIES.toKiloCalories((long) (aVar.b() + aVar.c()))), Integer.valueOf((int) k.MILLIMETRES.toMetres((long) aVar.d())), Long.valueOf(TimeUnit.MINUTES.toSeconds((long) aVar.e())));
    }

    public static w<m> a(f fVar) {
        return new j.a(fVar);
    }
}
