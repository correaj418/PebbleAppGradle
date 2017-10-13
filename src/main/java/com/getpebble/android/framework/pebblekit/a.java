package com.getpebble.android.framework.pebblekit;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.au;
import com.getpebble.android.framework.analytics.WatchAnalytics;
import com.getpebble.android.framework.appmessage.AppMessage;
import com.getpebble.android.framework.appmessage.b;
import com.getpebble.android.framework.d.c;
import com.getpebble.android.framework.d.d;
import com.getpebble.android.framework.health.HealthDataReceiver;
import com.getpebble.android.framework.l.a.k;
import com.getpebble.android.framework.l.a.k.g;
import com.google.a.f.e;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;

public class a implements com.getpebble.android.framework.e.f.a {
    private static final UUID a = new UUID(0, 0);
    private static a b;
    private final Context c;
    private List<com.getpebble.android.common.model.ak.a> d;

    public void e_() {
        c();
    }

    a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        f.d("PebbleKit", "PebbleKit()");
        this.c = context;
        this.d = new ArrayList();
        PebbleApplication.a((com.getpebble.android.framework.e.f.a) this);
    }

    protected com.getpebble.android.common.model.ak.a b() {
        return PebbleApplication.r();
    }

    private void c() {
        com.getpebble.android.common.model.ak.a b = b();
        if (!(b == null || this.d.contains(b))) {
            f.d("PebbleKit", "Broadcasting CONNECTED Intent for " + b.pebbleDevice);
            Intent intent = new Intent("com.getpebble.action.PEBBLE_CONNECTED");
            intent.putExtra(ak.ADDRESS, b.pebbleDevice.getAddress());
            this.c.sendBroadcast(intent);
        }
        for (com.getpebble.android.common.model.ak.a aVar : this.d) {
            if (!aVar.equals(b)) {
                f.d("PebbleKit", "Broadcasting DISCONNECTED Intent for " + aVar.pebbleDevice);
                Intent intent2 = new Intent("com.getpebble.action.PEBBLE_DISCONNECTED");
                intent2.putExtra(ak.ADDRESS, aVar.pebbleDevice.getAddress());
                this.c.sendBroadcast(intent2);
            }
        }
        this.d.clear();
        if (b != null) {
            this.d.add(b);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context);
            }
            aVar = b;
        }
        return aVar;
    }

    public void a(c cVar) {
        try {
            Intent intent = new Intent("com.getpebble.action.dl.RECEIVE_DATA_NEW");
            intent.putExtra("pbl_data_id", cVar.d());
            intent.putExtra("pbl_data_type", cVar.c().k().getCode());
            switch (cVar.c().k()) {
                case BYTE_ARRAY:
                    intent.putExtra("pbl_data_object", Base64.encodeToString(((com.getpebble.android.framework.l.a.k.a) cVar.e()).b(), 2));
                    break;
                case UNSIGNED_INTEGER:
                    intent.putExtra("pbl_data_object", Long.valueOf(((g) cVar.e()).b().longValue()));
                    break;
                case SIGNED_INTEGER:
                    intent.putExtra("pbl_data_object", ((k.f) cVar.e()).b());
                    break;
                default:
                    f.b("PebbleKit", "Unknown data type: " + cVar.c().k());
                    return;
            }
            intent.putExtra("uuid", cVar.c().f());
            intent.putExtra("data_log_uuid", cVar.c().e());
            intent.putExtra("data_log_timestamp", Long.valueOf(cVar.c().g().longValue()));
            intent.putExtra("data_log_tag", Long.valueOf(cVar.c().h().longValue()));
            if (a.equals(cVar.c().f())) {
                e h = cVar.c().h();
                if (WatchAnalytics.b.contains(h)) {
                    f.e("PebbleKit", "Watch analytics; not broadcasting Intent - forwarding to WatchAnalytics (tag: " + h + ")");
                    intent.setClass(this.c, WatchAnalytics.class);
                    this.c.startService(intent);
                    return;
                } else if (HealthDataReceiver.f.contains(h)) {
                    f.e("PebbleKit", "Health Data; not broadcasting Intent - forwarding to HealthDataReceiver (tag: " + h + ")");
                    intent.setClass(this.c, HealthDataReceiver.class);
                    this.c.startService(intent);
                    return;
                } else {
                    return;
                }
            }
            f.d("PebbleKit", "broadcastDataloggingItem: broadcasting " + cVar.d());
            this.c.sendBroadcast(intent);
        } catch (Throwable e) {
            f.b("PebbleKit", "Error sending datalogging data item", e);
        }
    }

    public void a(d dVar) {
        try {
            Intent intent = new Intent("com.getpebble.action.dl.FINISH_SESSION_NEW");
            intent.putExtra("uuid", dVar.f());
            intent.putExtra("data_log_timestamp", Long.valueOf(dVar.g().longValue()));
            intent.putExtra("data_log_tag", Long.valueOf(dVar.h().longValue()));
            intent.putExtra("data_log_uuid", dVar.e());
            this.c.sendBroadcast(intent);
        } catch (Throwable e) {
            f.b("PebbleKit", "Error sending datalogging session closure message", e);
        }
    }

    public boolean a(com.getpebble.android.framework.l.a.d dVar) {
        AppMessage c = dVar.c();
        if (c == null || c.e() == null) {
            f.b("PebbleKit", "missing or malformed appmessage");
            return false;
        }
        Intent intent;
        com.getpebble.android.framework.appmessage.AppMessage.a e = c.e();
        if (e == com.getpebble.android.framework.appmessage.AppMessage.a.PUSH) {
            intent = new Intent("com.getpebble.action.app.RECEIVE");
            try {
                String a = new b(c.b()).a();
                intent.putExtra("uuid", c.a());
                intent.putExtra("msg_data", a);
                au.a(com.getpebble.android.common.model.au.a.PEBBLEKIT_APP_MESSAGE_OUT, this.c.getContentResolver());
            } catch (JSONException e2) {
                f.d("PebbleKit", "Could not marshal response from watch");
                return false;
            }
        } else if (e == com.getpebble.android.framework.appmessage.AppMessage.a.ACK) {
            intent = new Intent("com.getpebble.action.app.RECEIVE_ACK");
        } else if (e == com.getpebble.android.framework.appmessage.AppMessage.a.NACK) {
            intent = new Intent("com.getpebble.action.app.RECEIVE_NACK");
        } else {
            f.a("PebbleKit", "received unsupported AppMessage command:" + e);
            return false;
        }
        a(intent, c.c());
        return true;
    }

    public void a(byte b) {
        a(new Intent("com.getpebble.action.app.RECEIVE_NACK"), b);
    }

    private void a(Intent intent, byte b) {
        intent.putExtra("transaction_id", b & 255);
        f.d("PebbleKit", "About to broadcast AppMessage: " + intent.toString());
        this.c.sendBroadcast(intent);
    }
}
