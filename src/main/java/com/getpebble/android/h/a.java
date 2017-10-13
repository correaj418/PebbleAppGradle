package com.getpebble.android.h;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.getpebble.android.common.b.a.f;

public class a {
    public static Boolean a(Context context) {
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        if (powerManager != null) {
            return Boolean.valueOf(powerManager.isIgnoringBatteryOptimizations("com.getpebble.android.basalt"));
        }
        f.f("AndroidUtil", "pm is null");
        return null;
    }

    public static Boolean b(Context context) {
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        if (powerManager != null) {
            return Boolean.valueOf(powerManager.isDeviceIdleMode());
        }
        f.f("AndroidUtil", "pm is null");
        return null;
    }
}
