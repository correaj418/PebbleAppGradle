package com.getpebble.android.h;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.getpebble.android.common.b.a.f;

public class t<T> extends Handler {
    public t(Looper looper) {
        super(looper);
    }

    public final boolean a(Runnable runnable, T t, long j) {
        if (j >= 0) {
            return postAtTime(runnable, t, SystemClock.uptimeMillis() + j);
        }
        f.f("PebbleHandler", "postDelayed: invalid delay millis " + j);
        return false;
    }
}
