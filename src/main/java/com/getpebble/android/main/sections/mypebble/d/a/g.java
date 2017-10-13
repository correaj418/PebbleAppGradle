package com.getpebble.android.main.sections.mypebble.d.a;

import com.getpebble.android.common.model.a.o.e;
import com.getpebble.android.main.sections.mypebble.d.a.i.a;
import com.google.b.a.c;
import com.google.b.f;
import com.google.b.w;
import java.util.concurrent.TimeUnit;

public abstract class g {
    @c(a = "start")
    public abstract long a();

    @c(a = "end")
    public abstract long b();

    @c(a = "beatsPerMinute")
    public abstract int c();

    @c(a = "qualityWeight")
    public abstract Integer d();

    @c(a = "vmc")
    public abstract Integer e();

    public static g a(e eVar) {
        return new i((long) eVar.d(), ((long) eVar.d()) + TimeUnit.MINUTES.toSeconds(1), eVar.m() == null ? 0 : eVar.m().intValue(), eVar.n(), Integer.valueOf(eVar.g()));
    }

    public static w<g> a(f fVar) {
        return new a(fVar);
    }
}
