package com.getpebble.android.main.sections.mypebble.d.a;

import com.getpebble.android.common.model.a.o.b;
import com.getpebble.android.main.sections.mypebble.d.a.l.a;
import com.google.b.a.c;
import com.google.b.f;
import com.google.b.w;

public abstract class p {
    @c(a = "start")
    public abstract long a();

    @c(a = "end")
    public abstract long b();

    @c(a = "label")
    public abstract String c();

    @c(a = "shortLabel")
    public abstract String d();

    @c(a = "minutesInZone1")
    public abstract Integer e();

    @c(a = "minutesInZone2")
    public abstract Integer f();

    @c(a = "minutesInZone3")
    public abstract Integer g();

    public static p a(long j, long j2, String str, String str2, b bVar) {
        return new l(j, j2, str, str2, Integer.valueOf(bVar.a()), Integer.valueOf(bVar.b()), Integer.valueOf(bVar.c()));
    }

    public static w<p> a(f fVar) {
        return new a(fVar);
    }
}
