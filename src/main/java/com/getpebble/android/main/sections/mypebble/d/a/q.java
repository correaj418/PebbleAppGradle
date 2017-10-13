package com.getpebble.android.main.sections.mypebble.d.a;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.health.d.a;
import com.getpebble.android.h.k;
import com.getpebble.android.h.l;
import com.google.b.a.c;

public class q extends r {
    @c(a = "type")
    private final String d;
    @c(a = "distance")
    private final Integer e;
    @c(a = "calories")
    private final Integer f;
    @c(a = "steps")
    private final Integer g;

    q(long j, int i, long j2, String str, Integer num, Integer num2, Integer num3) {
        super(j, i, j2);
        this.d = str;
        this.e = num;
        this.f = num2;
        this.g = num3;
    }

    public static q a(a aVar) {
        if (aVar.b.equals(a.a.Walk) || aVar.b.equals(a.a.Run)) {
            return new q(aVar.c, aVar.e, aVar.d, aVar.b.jsName, Integer.valueOf((int) k.MILLIMETRES.toMetres(aVar.i)), Integer.valueOf((int) l.GRAM_CALORIES.toKiloCalories(aVar.j + aVar.k)), Integer.valueOf(aVar.h));
        }
        f.f("MovingActivitySession", "from: attemped to get MovingActivitySession from record with activity type " + aVar.b);
        return null;
    }
}
