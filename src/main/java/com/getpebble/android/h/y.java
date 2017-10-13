package com.getpebble.android.h;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.getpebble.android.common.a;

public class y {
    private static Object a(String str) {
        return a.K().getSystemService(str);
    }

    @TargetApi(21)
    public static boolean a() {
        PowerManager powerManager = (PowerManager) a("power");
        if (VERSION.SDK_INT >= 20) {
            return powerManager.isInteractive();
        }
        return powerManager.isScreenOn();
    }

    public static boolean b() {
        return ((KeyguardManager) a("keyguard")).inKeyguardRestrictedInputMode();
    }
}
