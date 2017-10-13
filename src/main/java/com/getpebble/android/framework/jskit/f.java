package com.getpebble.android.framework.jskit;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.framework.PebbleFrameworkService;
import com.getpebble.android.framework.appmessage.AppMessage;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.framework.jskit.a.a.b;
import com.getpebble.android.framework.jskit.a.a.e;
import com.getpebble.android.framework.timeline.i;
import com.getpebble.android.h.p;
import com.getpebble.jskit.android.impl.b.a;
import com.getpebble.jskit.android.impl.c.a.c;
import com.getpebble.jskit.android.impl.c.a.d;
import com.google.b.g;
import java.util.UUID;

public class f implements a {
    public int a(com.getpebble.jskit.android.impl.c.a.f fVar) {
        com.getpebble.android.common.b.a.f.d("PebbleJavascriptContext", "sendAppMessageToPebble: jsMsgAppMessage = " + fVar);
        if (c()) {
            AppMessage appMessage = (AppMessage) new g().a(AppMessage.class, new b(fVar.a())).c().a(fVar.b(), AppMessage.class);
            int d = appMessage.d();
            com.getpebble.android.common.b.a.f.d("PebbleJavascriptContext", "sendAppMessageToPebble: transactionId = " + d);
            com.getpebble.android.common.b.a.f.e("PebbleJavascriptContext", "sendAppMessageToPebble: run: mAppMessage = " + appMessage + ", success = " + a(appMessage));
            return d;
        }
        com.getpebble.android.common.b.a.f.b("PebbleJavascriptContext", "sendAppMessageToPebble: the app is not connected to the watch, therefore can not send app message to the watch");
        UUID fromString = UUID.fromString(fVar.a().a());
        int a = AppMessage.a(fromString);
        PebbleFrameworkService.a().f(fromString.toString(), new g().a(AppMessage.class, new com.getpebble.android.framework.jskit.a.a.a()).c().b(new AppMessage(a, fromString, AppMessage.a.NACK, null)));
        return a;
    }

    public void a(com.getpebble.jskit.android.impl.c.a.b bVar) {
    }

    public void a(c cVar) {
        if (c()) {
            com.getpebble.android.common.b.a.f.d("PebbleJavascriptContext", "sendNotificationToPebble: ");
            com.getpebble.android.notifications.a.b.a aVar = new com.getpebble.android.notifications.a.b.a();
            aVar.b = cVar.b();
            aVar.d = cVar.c();
            com.getpebble.android.framework.i.b.a(com.getpebble.android.notifications.a.b.a(aVar, com.getpebble.android.notifications.a.b.c.JSKIT, System.currentTimeMillis()));
            return;
        }
        com.getpebble.android.common.b.a.f.b("PebbleJavascriptContext", "sendAppMessageToPebble: the app is not connected to the watch, therefore can not send app message to the watch");
    }

    public void a(d dVar) {
        Toast.makeText(b(), dVar.b(), 0).show();
    }

    public String a(UUID uuid) {
        ak.a r = PebbleApplication.r();
        if (r == null) {
            com.getpebble.android.common.b.a.f.b("PebbleJavascriptContext", "getActiveWatchInfo: deviceRecord is null");
            return "";
        }
        am.c a = am.a(uuid, com.getpebble.android.common.a.K().getContentResolver(), false);
        if (a == null) {
            com.getpebble.android.common.b.a.f.b("PebbleJavascriptContext", "getActiveWatchInfo: couldn't get app record for " + uuid);
        } else {
            am.b.a a2 = a.H.a(r.hwPlatform.getPlatformCode());
            if (!(a2 == null || a2.a == r.hwPlatform.getPlatformCode())) {
                com.getpebble.android.common.b.a.f.d("PebbleJavascriptContext", "getActiveWatchInfo: overriding platform from " + r.getHwPlatform().getPlatformCode() + " to " + a2.a);
                return com.getpebble.android.framework.jskit.a.a.d.a(r, a2.a).a();
            }
        }
        return com.getpebble.android.framework.jskit.a.a.d.a(r).a();
    }

    public String a(String str) {
        return g.a(b()).c(UUID.fromString(str));
    }

    public String b(String str) {
        return g.a(b()).b(UUID.fromString(str));
    }

    public String c(String str) {
        final UUID fromString = UUID.fromString(str);
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ f b;

            public boolean doInBackground() {
                am.c a = am.a(fromString, this.b.b().getContentResolver(), false);
                String str = null;
                if (a == null) {
                    com.getpebble.android.common.b.a.f.b(com.getpebble.android.bluetooth.b.f.TAG, "getTimelineTokenAsync: locker record not found for startGetTimelineTokenRequest uuid = " + fromString);
                } else {
                    str = a.r;
                    if (a.z && str == null) {
                        com.getpebble.android.common.b.a.f.d(com.getpebble.android.bluetooth.b.f.TAG, "getTimelineTokenAsync: No token set for sideloaded app; fetching");
                        str = i.a(fromString);
                    }
                }
                d a2 = PebbleFrameworkService.a();
                String a3 = p.a(new e(fromString.toString(), str));
                if (str != null) {
                    a2.d(fromString.toString(), a3);
                } else {
                    a2.e(fromString.toString(), a3);
                }
                return true;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
        return str;
    }

    public String[] a() {
        String[] strArr = new String[]{PebbleApplication.n().getAddress()};
        com.getpebble.android.common.b.a.f.d("PebbleJavascriptContext", "getPebbleDeviceIdsThatAreReady: pebbleDevice = " + PebbleApplication.n());
        return strArr;
    }

    public void d(String str) {
        e.a().a(str);
    }

    public boolean a(String str, String str2) {
        try {
            UUID fromString = UUID.fromString(str);
            com.getpebble.android.framework.jskit.b.a[] aVarArr = (com.getpebble.android.framework.jskit.b.a[]) p.a(str2, com.getpebble.android.framework.jskit.b.a[].class);
            com.getpebble.android.common.model.d.b[] bVarArr = new com.getpebble.android.common.model.d.b[aVarArr.length];
            for (int i = 0; i < aVarArr.length; i++) {
                bVarArr[i] = new com.getpebble.android.common.model.d.b(aVarArr[i]);
            }
            com.getpebble.android.common.model.d.a(fromString, bVarArr, b().getContentResolver());
            return true;
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a("PebbleJavascriptContext", "reloadGlanceSlices: failed to reload glance slices", e);
            return false;
        }
    }

    public void a(int i, String str, String str2) {
        switch (i) {
            case 2:
                com.getpebble.android.common.b.a.f.e(str, str2);
                return;
            case 3:
                com.getpebble.android.common.b.a.f.d(str, str2);
                return;
            case 4:
                com.getpebble.android.common.b.a.f.c(str, str2);
                return;
            case 5:
                com.getpebble.android.common.b.a.f.d(str, str2);
                return;
            case 6:
                com.getpebble.android.common.b.a.f.a(str, str2);
                return;
            case 7:
                com.getpebble.android.common.b.a.f.f(str, str2);
                return;
            default:
                com.getpebble.android.common.b.a.f.a("PebbleJavascriptContext", "** Unknown log level: " + i + " message: " + str2);
                return;
        }
    }

    private boolean a(AppMessage appMessage) {
        com.getpebble.android.common.b.a.f.d("PebbleJavascriptContext", "sendAppMessageToPebble: message = " + appMessage);
        Bundle bundle = new Bundle();
        bundle.putParcelable(k.b.APP_MESSAGE.toString(), appMessage);
        return com.getpebble.android.framework.b.a.a(new k(com.getpebble.android.bluetooth.g.a.APP_MESSAGE, k.a.PUSH_APP_MESSAGE, bundle));
    }

    private boolean c() {
        return PebbleApplication.n() != null;
    }

    Context b() {
        return com.getpebble.android.common.a.K();
    }
}
