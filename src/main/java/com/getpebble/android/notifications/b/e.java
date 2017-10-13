package com.getpebble.android.notifications.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.b.b.d;
import com.getpebble.android.common.b.b.d.a;
import com.getpebble.android.notifications.PblNotificationService;
import java.util.List;

public class e {
    private static int a = 0;
    private static int b = 0;

    static void a(Context context) {
        SharedPreferences a = c.a(context);
        Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        intent.setFlags(335544320);
        context.startActivity(intent);
        Editor edit = a.edit();
        edit.putBoolean("nag_enable_service", true);
        edit.apply();
    }

    static boolean b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        return string != null && string.contains(context.getPackageName());
    }

    public static void a(Context context, boolean z) {
        if (z) {
            List<RunningServiceInfo> runningServices = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null) {
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (PblNotificationService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                        b = runningServiceInfo.crashCount;
                    }
                }
            }
        }
        a = b;
        a(false);
    }

    static void c(Context context) {
        if (b(context)) {
            d.a(a.FRAMEWORK);
            a(d(context));
        }
    }

    private static void a(boolean z) {
        if (PebbleApplication.y().a(c.a.NOTIFICATION_LISTENER_CRASHED, false) != z) {
            f.b("NotificationServiceUtil", "reportResult: marking crashed = " + z);
            PebbleApplication.y().b(c.a.NOTIFICATION_LISTENER_CRASHED, z);
            if (!z) {
            }
        }
    }

    private static boolean d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        List<RunningServiceInfo> runningServices = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices != null) {
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if (PblNotificationService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                    b = runningServiceInfo.crashCount;
                    f.c("NotificationServiceUtil", "crash count = " + b + " known good crash count = " + a);
                    return runningServiceInfo.crashCount > a;
                }
            }
        }
        return true;
    }
}
