package com.getpebble.android.core.sync;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.PeriodicSync;
import android.os.Bundle;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.main.sections.settings.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class d {
    private static final long a = TimeUnit.HOURS.toSeconds(6);
    private static d b = null;
    private WeakReference<Context> c = null;

    private d(Context context) {
        this.c = new WeakReference(context);
    }

    public static d a(Context context) {
        f.d("PebbleSyncManager", "createInstance()");
        if (context == null) {
            throw new IllegalArgumentException("'context' may not be null!");
        }
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    private void a(int i) {
        f.c("PebbleSyncManager", "sync request; action: " + i);
        Account g = PebbleApplication.u().g();
        if (g != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            bundle.putBoolean("expedited", true);
            bundle.putInt("sync_target", i);
            ContentResolver.requestSync(g, "com.getpebble.android.basalt.internal.provider", bundle);
            return;
        }
        f.a(d.class.getSimpleName(), "No user account available!");
    }

    public void a() {
        a(0);
    }

    public void b() {
        a(1);
    }

    public void c() {
        a(3);
    }

    public void d() {
        a(5);
    }

    public void e() {
        a(4);
    }

    public void f() {
        a(6);
    }

    public void g() {
        a(8);
    }

    public void h() {
        a(11);
    }

    public void i() {
        a(13);
    }

    public void j() {
        long a;
        f.c("PebbleSyncManager", "setPeriodicSync()");
        long toMillis = TimeUnit.DAYS.toMillis(1);
        Context context = (Context) this.c.get();
        if (context != null) {
            a = a.a(new c(context));
        } else {
            a = toMillis;
        }
        Account g = PebbleApplication.u().g();
        if (g == null) {
            f.b("PebbleSyncManager", "setPeriodicSync failed, user account is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("sync_target", 0);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("sync_target", 5);
        Bundle bundle3 = new Bundle();
        bundle3.putInt("sync_target", 6);
        Bundle bundle4 = new Bundle();
        bundle4.putInt("sync_target", 12);
        new Bundle().putInt("sync_target", 3);
        Bundle bundle5 = new Bundle();
        bundle5.putInt("sync_target", 15);
        Bundle bundle6 = new Bundle();
        bundle6.putInt("sync_target", 9);
        ContentResolver.addPeriodicSync(g, "com.getpebble.android.basalt.internal.provider", bundle, TimeUnit.MILLISECONDS.toSeconds(a));
        ContentResolver.addPeriodicSync(g, "com.getpebble.android.basalt.internal.provider", bundle2, TimeUnit.MINUTES.toSeconds((long) PebbleApplication.w().I()));
        ContentResolver.addPeriodicSync(g, "com.getpebble.android.basalt.internal.provider", bundle3, TimeUnit.MILLISECONDS.toSeconds(com.getpebble.android.framework.q.a.a()));
        ContentResolver.addPeriodicSync(g, "com.getpebble.android.basalt.internal.provider", bundle5, TimeUnit.MILLISECONDS.toSeconds(a));
        ContentResolver.addPeriodicSync(g, "com.getpebble.android.basalt.internal.provider", bundle4, TimeUnit.MILLISECONDS.toSeconds(a));
        ContentResolver.addPeriodicSync(g, "com.getpebble.android.basalt.internal.provider", bundle6, a);
        ContentResolver.setSyncAutomatically(g, "com.getpebble.android.basalt.internal.provider", true);
        k();
    }

    public void k() {
        f.d("PebbleSyncManager", "dumpPeriodicSyncs()");
        Account g = PebbleApplication.u().g();
        if (g == null) {
            f.b("PebbleSyncManager", "dumpPeriodicSyncs: failed, user account is null");
            return;
        }
        for (PeriodicSync periodicSync : ContentResolver.getPeriodicSyncs(g, "com.getpebble.android.basalt.internal.provider")) {
            f.d("PebbleSyncManager", "> sync period = " + periodicSync.period + " extras = " + a(periodicSync.extras));
        }
    }

    private static String a(Bundle bundle) {
        if (bundle == null) {
            return "<none>";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[size = ").append(bundle.size());
        for (String str : bundle.keySet()) {
            stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR).append(str).append(" = '").append(bundle.get(str)).append("'");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
