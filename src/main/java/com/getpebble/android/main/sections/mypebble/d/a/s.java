package com.getpebble.android.main.sections.mypebble.d.a;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.health.d.a;

public class s extends r {
    s(long j, int i, long j2) {
        super(j, i, j2);
    }

    public static s a(a aVar) {
        if (aVar.b.isSleep()) {
            return new s(aVar.c, aVar.e, aVar.d);
        }
        f.f("SleepActivitySession", "from: attempted to get SleepActivitySession from record with activity type " + aVar.b);
        return null;
    }
}
