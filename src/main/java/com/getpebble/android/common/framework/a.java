package com.getpebble.android.common.framework;

import android.os.Handler;
import android.os.HandlerThread;

public class a {
    private static HandlerThread a = new HandlerThread("cache-thread");
    private static Handler b = new Handler(a.getLooper());

    static {
        a.start();
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (a.class) {
            b.removeCallbacks(runnable);
            b.post(runnable);
        }
    }
}
