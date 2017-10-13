package com.getpebble.android.h;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.b.b.c.a;
import com.getpebble.android.common.model.af;
import com.getpebble.android.framework.gcm.RegistrationIntentService;
import com.getpebble.android.framework.timeline.TimelineWebSyncService;

public class ad {
    public static void a(Context context) {
        if (context == null) {
            f.b("UpgradeUtil", "context is null");
            return;
        }
        c cVar = new c(context);
        long a = cVar.a(a.INSTALLED_PEBBLE_APP_VERSION, -1);
        long b = (long) b();
        cVar.b(a.INSTALLED_PEBBLE_APP_VERSION, b);
        if (a == -1) {
            f.d("UpgradeUtil", "Not processing upgrades, oldversion is unknown.");
            return;
        }
        f.d("UpgradeUtil", "previousVersion = " + a);
        f.d("UpgradeUtil", "currentVersion = " + b);
        if (a < 740) {
            cVar.b(a.BLOB_DB_LAST_SYNC_ADDRESS, "");
        }
        if (b > a) {
            f.d("UpgradeUtil", "Upgrading; invalidating push token");
            RegistrationIntentService.a(cVar);
        }
        if (a < 721) {
            cVar.b(a.OBFUSCATE_NOTIFICATIONS, true);
        }
        if (a < 754) {
            cVar.b(a.DEFAULT_APPS_ADDED, true);
            cVar.b(a.COMPLETED_FIRST_LOCKER_CLOUD_SYNC, true);
        }
        if (a < 771) {
            new com.getpebble.android.framework.install.a.a(context).c();
            cVar.b(a.BLOB_DB_LAST_SYNC_ADDRESS, "");
        }
        if (a < 775) {
            TimelineWebSyncService.a(context);
        }
        if (a >= 776 && a < 778) {
            cVar.b(a.BLOB_DB_LAST_SYNC_ADDRESS, "");
        }
        if (a < 841) {
            a();
        }
        if (a < 842) {
            c();
        }
    }

    public static void a() {
        for (String b : af.b(com.getpebble.android.common.a.K().getContentResolver())) {
            af.b(b, true, com.getpebble.android.common.a.K().getContentResolver());
        }
    }

    private static void c() {
        for (String a : af.b(com.getpebble.android.common.a.K().getContentResolver())) {
            af.a(a, true, com.getpebble.android.common.a.K().getContentResolver());
        }
    }

    public static int b() {
        return 1404;
    }
}
