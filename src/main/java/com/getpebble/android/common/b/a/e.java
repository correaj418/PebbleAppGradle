package com.getpebble.android.common.b.a;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.b.b.d;
import com.getpebble.android.common.b.b.d.a;

public class e {
    public static void a(boolean z) {
        d.a(z);
        if (a.FRAMEWORK.equals(d.a(com.getpebble.android.common.a.K()))) {
            new c(com.getpebble.android.common.a.K()).b(c.a.VERBOSE_LOGCAT, z);
        } else {
            PebbleApplication.x().a(z);
        }
    }
}
