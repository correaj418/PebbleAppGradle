package com.getpebble.android.framework.g;

import android.content.Context;
import android.os.SystemClock;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.appmessage.AppMessage;
import com.getpebble.android.framework.l.a.d;
import com.getpebble.android.framework.l.b.r;
import com.google.a.b.am;
import java.util.Set;
import java.util.UUID;

public class b extends ac {
    private final Context a;
    private final p b;
    private final com.getpebble.android.framework.pebblekit.a c;
    private com.getpebble.android.framework.jskit.a.a d;
    private a e;

    private static class a {
        final long a;
        final UUID b;

        a(long j, UUID uuid) {
            this.a = j;
            this.b = uuid;
        }
    }

    public b(Context context, p pVar, com.getpebble.android.framework.pebblekit.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else if (aVar == null) {
            throw new IllegalArgumentException("'pebbleKit' cannot be null!");
        } else {
            this.a = context;
            this.b = pVar;
            this.c = aVar;
            this.d = new com.getpebble.android.framework.jskit.a.a();
        }
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.APP_MESSAGE);
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        if (!b(kVar)) {
            f.d("AppMessageEndpoint", "onRequest: Request is not supported: " + kVar);
            return false;
        } else if (kVar.a() == com.getpebble.android.bluetooth.g.a.APP_MESSAGE) {
            return a(kVar);
        } else {
            return true;
        }
    }

    protected boolean a(k kVar) {
        AppMessage appMessage = (AppMessage) kVar.c(com.getpebble.android.framework.g.k.b.APP_MESSAGE);
        if (appMessage == null) {
            f.a("AppMessageEndpoint", "handleAppMessageRequest: missing appmessage");
            return false;
        } else if (kVar.b() != com.getpebble.android.framework.g.k.a.PUSH_APP_MESSAGE) {
            f.a("AppMessageEndpoint", "handleAppMessageRequest: unsupported action: " + kVar.b());
            return false;
        } else {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            if (r == null) {
                return true;
            }
            if (!r.capabilities.supportsAppRunStateProtocol || !com.getpebble.android.framework.appmessage.AppMessage.a.PUSH.equals(appMessage.e()) || b(appMessage.a()) || a(appMessage.a())) {
                return a(appMessage);
            }
            f.d("AppMessageEndpoint", "handleAppMessageRequest: App (" + appMessage.a() + ") is not running on watch; not sending AppMessage");
            this.c.a(appMessage.c());
            this.d.a(appMessage);
            return true;
        }
    }

    private boolean a(UUID uuid) {
        if (this.e == null || !this.e.b.equals(uuid)) {
            return false;
        }
        if (this.e.a >= SystemClock.uptimeMillis() - 1500) {
            return true;
        }
        return false;
    }

    private static boolean b(UUID uuid) {
        com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
        if (r != null) {
            return uuid.equals(r.currentRunningApp);
        }
        return false;
    }

    protected boolean a(AppMessage appMessage) {
        r fVar = new com.getpebble.android.framework.l.b.f(appMessage);
        try {
            fVar.c_();
            if (fVar == null || !this.b.a(fVar)) {
                f.d("AppMessageEndpoint", "sendAppMessage: appMessage send failed");
                return false;
            }
            f.d("AppMessageEndpoint", "sendAppMessage: outbound>> appmessage command = " + appMessage.e() + " transactionId = " + appMessage.d() + " uuid = " + appMessage.a());
            return true;
        } catch (Throwable e) {
            f.a("AppMessageEndpoint", "sendAppMessage: Failed to create app message; buffer overflow", e);
            this.c.a(appMessage.c());
            this.d.a(appMessage);
            return false;
        }
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        short a = bVar.a();
        if (a == com.getpebble.android.bluetooth.g.a.APP_MESSAGE.getCode()) {
            d dVar = new d(bVar);
            if (dVar.c() != null) {
                UUID a2 = dVar.c().a();
                f.d("AppMessageEndpoint", "onReceive: inbound<< appmessage command = " + dVar.c().e() + " transactionId = " + dVar.c().d() + " uuid = " + a2);
                if (a2 != null && com.getpebble.android.framework.appmessage.AppMessage.a.PUSH.equals(dVar.c().e())) {
                    this.e = new a(SystemClock.uptimeMillis(), a2);
                }
            }
            this.c.a(dVar);
            this.d.a(dVar);
            return true;
        }
        f.d("AppMessageEndpoint", "onReceive: unhandled endpoint: " + a);
        return false;
    }

    void b() {
    }
}
