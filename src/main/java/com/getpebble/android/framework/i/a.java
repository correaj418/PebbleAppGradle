package com.getpebble.android.framework.i;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.notifications.a.b.c;

public class a {
    private Context a;
    private boolean b = false;
    private FrameworkState c;

    public enum a {
        EMAIL,
        SMS,
        PHONE_CALL
    }

    public class b extends f {
        final /* synthetic */ a a;

        public b(a aVar) {
            this.a = aVar;
        }

        public boolean doInBackground() {
            this.a.a(true);
            String string = this.a.a().getString(R.string.notification_demo_phone_sender);
            String string2 = this.a.a().getString(R.string.notification_demo_phone_name);
            byte[] a = com.getpebble.android.bluetooth.b.b.a();
            Bundle bundle = new Bundle();
            bundle.putString(com.getpebble.android.framework.g.k.b.PHONE_NUMBER.toString(), string);
            bundle.putString(com.getpebble.android.framework.g.k.b.PHONE_NAME.toString(), string2);
            bundle.putByteArray(com.getpebble.android.framework.g.k.b.PHONE_COOKIE.toString(), a);
            this.a.a(new k(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL, com.getpebble.android.framework.g.k.a.SEND_PHONE_INCOMING_CALL_NOTIFICATION, bundle));
            k kVar = new k(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL, com.getpebble.android.framework.g.k.a.SEND_PHONE_RING_NOTIFICATION, bundle);
            this.a.a(kVar);
            for (int i = 0; i < 3; i++) {
                SystemClock.sleep(2000);
                this.a.a(kVar);
            }
            SystemClock.sleep(1000);
            this.a.a(new k(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL, com.getpebble.android.framework.g.k.a.SEND_PHONE_START_NOTIFICATION, bundle));
            SystemClock.sleep(1000);
            this.a.a(new k(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL, com.getpebble.android.framework.g.k.a.SEND_PHONE_END_NOTIFICATION, bundle));
            this.a.a(false);
            return true;
        }

        public void onTaskSuccess() {
            this.a.c.c(true);
        }

        public void onTaskFailed() {
            this.a.c.c(false);
        }
    }

    public a(Context context, FrameworkState frameworkState) {
        if (context == null) {
            throw new IllegalArgumentException("'Context' cannot be null!");
        } else if (frameworkState == null) {
            throw new IllegalArgumentException("'frameworkState' cannot be null!");
        } else {
            this.a = context;
            this.c = frameworkState;
        }
    }

    private boolean a(k kVar) {
        PebbleDevice n = PebbleApplication.n();
        if (n == null) {
            com.getpebble.android.common.b.a.f.a("NotificationSender", "Could not send request, connected device was null!");
            return false;
        }
        com.getpebble.android.common.b.a.f.d("NotificationSender", "Sending test notification to " + n.getName());
        return com.getpebble.android.framework.b.a.c(n).a(kVar, null);
    }

    public void a(a aVar) {
        switch (aVar) {
            case EMAIL:
                b();
                return;
            case SMS:
                c();
                return;
            case PHONE_CALL:
                d();
                return;
            default:
                return;
        }
    }

    private Context a() {
        return this.a;
    }

    private void b() {
        String string = a().getString(R.string.notification_demo_email_sender);
        String string2 = a().getString(R.string.notification_demo_email_body);
        String string3 = a().getString(R.string.notification_demo_email_subject);
        com.getpebble.android.notifications.a.b.a aVar = new com.getpebble.android.notifications.a.b.a();
        aVar.b = string;
        aVar.d = string3 + "\n" + string2;
        b.a(com.getpebble.android.notifications.a.b.a(aVar, c.DEMO, System.currentTimeMillis()));
    }

    private void c() {
        String string = a().getString(R.string.notification_demo_phone_sender);
        String string2 = a().getString(R.string.notification_demo_sms_body);
        com.getpebble.android.notifications.a.b.a aVar = new com.getpebble.android.notifications.a.b.a();
        aVar.b = string;
        aVar.d = string2;
        b.a(com.getpebble.android.notifications.a.b.a(aVar, c.DEMO, System.currentTimeMillis()));
    }

    private synchronized void d() {
        if (!this.b) {
            new b(this).submit();
        }
    }

    private synchronized void a(boolean z) {
        this.b = z;
    }
}
