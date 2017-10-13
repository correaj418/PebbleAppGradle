package com.getpebble.android.bluetooth.b;

import android.os.Binder;

public class c {
    public static void a(Runnable runnable) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            runnable.run();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
