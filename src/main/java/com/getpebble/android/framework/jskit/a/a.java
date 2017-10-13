package com.getpebble.android.framework.jskit.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.PebbleFrameworkService;
import com.getpebble.android.framework.appmessage.AppMessage;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.framework.g.k.b;
import com.getpebble.android.framework.jskit.c;
import com.getpebble.android.framework.l.a.d;
import com.google.b.g;

public class a {
    public void a(d dVar) {
        AppMessage c = dVar.c();
        if (c == null || c.e() == null) {
            f.b("JsInAppMessageHandler", "sendMessageToJs: missing or malformed appmessage");
        } else {
            e(c);
        }
    }

    private AppMessage b(AppMessage appMessage) {
        if (appMessage.a() != null) {
            return appMessage;
        }
        return new AppMessage(appMessage.c(), AppMessage.a(appMessage.c()), com.getpebble.android.framework.appmessage.AppMessage.a.ACK, null);
    }

    private String c(AppMessage appMessage) {
        return new g().a(AppMessage.class, new com.getpebble.android.framework.jskit.a.a.a()).c().b((Object) appMessage);
    }

    public void a(AppMessage appMessage) {
        d(new AppMessage(appMessage.c(), appMessage.a(), com.getpebble.android.framework.appmessage.AppMessage.a.NACK, appMessage.b()));
    }

    private void d(AppMessage appMessage) {
        AppMessage b = b(appMessage);
        if (b.a() == null) {
            f.b("JsInAppMessageHandler", "sendAckNackToJs: run: can not send ack message to javascript code because uuid is null ");
            return;
        }
        String c = c(b);
        if (TextUtils.isEmpty(c)) {
            f.b("JsInAppMessageHandler", "sendAckNackToJs: could not build the JsonObject to send ACK OR NACK");
            return;
        }
        boolean b2;
        com.getpebble.android.framework.jskit.d a = PebbleFrameworkService.a();
        if (appMessage.e().equals(com.getpebble.android.framework.appmessage.AppMessage.a.ACK)) {
            b2 = a.b(b.a().toString(), c.toString());
        } else {
            b2 = a.f(b.a().toString(), c.toString());
        }
        if (!b2) {
            f.b("JsInAppMessageHandler", "sendAckNackToJs: failed to send " + appMessage.e() + " for UUID " + appMessage.a());
        }
    }

    private void e(AppMessage appMessage) {
        if (appMessage.e().equals(com.getpebble.android.framework.appmessage.AppMessage.a.ACK) || appMessage.e().equals(com.getpebble.android.framework.appmessage.AppMessage.a.NACK)) {
            d(appMessage);
        } else if (c.a(com.getpebble.android.common.a.K()).f(appMessage.a())) {
            String b;
            com.getpebble.android.framework.jskit.d a = PebbleFrameworkService.a();
            try {
                b = new g().a(AppMessage.class, new com.getpebble.android.framework.jskit.a.a.c(a.b(appMessage.a()))).c().b((Object) appMessage);
            } catch (Throwable e) {
                f.a("JsInAppMessageHandler", "handleInboundAppMessage: failed to build jsonObject ", e);
                b = null;
            }
            if (b == null) {
                f.b("JsInAppMessageHandler", "handleInboundAppMessage: could not build the JsonObject to send the appMessage to javascript code");
                return;
            }
            a(appMessage.c(), a.a(appMessage.a().toString(), b) ? com.getpebble.android.framework.appmessage.AppMessage.a.ACK : com.getpebble.android.framework.appmessage.AppMessage.a.NACK);
        }
    }

    private boolean a(byte b, com.getpebble.android.framework.appmessage.AppMessage.a aVar) {
        Parcelable appMessage = new AppMessage(b, null, aVar, null);
        Bundle bundle = new Bundle();
        bundle.putParcelable(b.APP_MESSAGE.toString(), appMessage);
        return com.getpebble.android.framework.b.a.a(new k(com.getpebble.android.bluetooth.g.a.APP_MESSAGE, com.getpebble.android.framework.g.k.a.PUSH_APP_MESSAGE, bundle));
    }
}
