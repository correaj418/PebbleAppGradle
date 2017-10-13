package com.getpebble.android.framework.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.framework.g.k.b;
import com.getpebble.android.framework.o.c;

public class h extends BroadcastReceiver {
    private static a a = a.IDLE;
    private static byte[] b = null;
    private static com.getpebble.android.b.b.a c;
    private static int d = 9999;

    public enum a {
        IDLE,
        RINGING,
        OFFHOOK
    }

    public h(Context context) {
        context.registerReceiver(this, new IntentFilter("android.intent.action.PHONE_STATE"));
    }

    public static void a(com.getpebble.android.b.b.a aVar) {
        c = aVar;
    }

    private void a(Context context) {
        synchronized ("PhoneReceiver") {
            a aVar = a;
            a = a.IDLE;
            b(context);
            if (a.IDLE.equals(aVar)) {
                f.d("PhoneReceiver", "onIdle(): already idle");
            } else if (b == null) {
                f.b("PhoneReceiver", "onIdle(): cookie is null");
            } else {
                Bundle bundle = new Bundle();
                bundle.putByteArray(b.PHONE_COOKIE.toString(), b);
                k kVar = new k(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL, com.getpebble.android.framework.g.k.a.SEND_PHONE_END_NOTIFICATION, bundle);
                f.d("PhoneReceiver", "Sending call end notification");
                a(kVar);
                b = null;
            }
        }
    }

    private void a(String str, String str2) {
        synchronized ("PhoneReceiver") {
            a aVar = a;
            a = a.RINGING;
            if (a.IDLE.equals(aVar)) {
                b = com.getpebble.android.bluetooth.b.b.a();
                Bundle bundle = new Bundle();
                bundle.putString(b.PHONE_NUMBER.toString(), str);
                bundle.putString(b.PHONE_NAME.toString(), str2);
                bundle.putByteArray(b.PHONE_COOKIE.toString(), b);
                k kVar = new k(com.getpebble.android.bluetooth.g.a.PHONE_CONTROL, com.getpebble.android.framework.g.k.a.SEND_PHONE_INCOMING_CALL_NOTIFICATION, bundle);
                f.e("PhoneReceiver", "Sending incoming call notification");
                PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.LAST_INCOMING_PHONE_NUMBER, str);
                a(kVar);
                return;
            }
            f.d("PhoneReceiver", "onRing(): not idle");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
        r5 = this;
        r1 = "PhoneReceiver";
        monitor-enter(r1);
        r0 = a;	 Catch:{ all -> 0x001f }
        r2 = com.getpebble.android.framework.m.h.a.OFFHOOK;	 Catch:{ all -> 0x001f }
        a = r2;	 Catch:{ all -> 0x001f }
        r2 = com.getpebble.android.framework.m.h.AnonymousClass1.a;	 Catch:{ all -> 0x001f }
        r0 = r0.ordinal();	 Catch:{ all -> 0x001f }
        r0 = r2[r0];	 Catch:{ all -> 0x001f }
        switch(r0) {
            case 1: goto L_0x0016;
            case 2: goto L_0x0014;
            case 3: goto L_0x0022;
            default: goto L_0x0014;
        };	 Catch:{ all -> 0x001f }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
    L_0x0015:
        return;
    L_0x0016:
        r0 = "PhoneReceiver";
        r2 = "onOffHook(): already off hook";
        com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ all -> 0x001f }
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        goto L_0x0015;
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        throw r0;
    L_0x0022:
        r0 = b;	 Catch:{ all -> 0x001f }
        if (r0 != 0) goto L_0x002f;
    L_0x0026:
        r0 = "PhoneReceiver";
        r2 = "onOffHook(): cookie is null (ringing)";
        com.getpebble.android.common.b.a.f.b(r0, r2);	 Catch:{ all -> 0x001f }
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        goto L_0x0015;
    L_0x002f:
        r0 = new android.os.Bundle;	 Catch:{ all -> 0x001f }
        r0.<init>();	 Catch:{ all -> 0x001f }
        r2 = com.getpebble.android.framework.g.k.b.PHONE_COOKIE;	 Catch:{ all -> 0x001f }
        r2 = r2.toString();	 Catch:{ all -> 0x001f }
        r3 = b;	 Catch:{ all -> 0x001f }
        r0.putByteArray(r2, r3);	 Catch:{ all -> 0x001f }
        r2 = new com.getpebble.android.framework.g.k;	 Catch:{ all -> 0x001f }
        r3 = com.getpebble.android.bluetooth.g.a.PHONE_CONTROL;	 Catch:{ all -> 0x001f }
        r4 = com.getpebble.android.framework.g.k.a.SEND_PHONE_START_NOTIFICATION;	 Catch:{ all -> 0x001f }
        r2.<init>(r3, r4, r0);	 Catch:{ all -> 0x001f }
        r0 = "PhoneReceiver";
        r3 = "Sending call started notification";
        com.getpebble.android.common.b.a.f.d(r0, r3);	 Catch:{ all -> 0x001f }
        r5.a(r2);	 Catch:{ all -> 0x001f }
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.m.h.b():void");
    }

    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            f.a("PhoneReceiver", "onReceive: context was null");
        } else if (!a()) {
            f.d("PhoneReceiver", "Call notifications disabled");
        } else if (intent == null || intent.getAction() == null) {
            f.b("PhoneReceiver", "Received a null intent in the Phone broadcast receiver");
        } else if (intent.getAction().equals("android.intent.action.PHONE_STATE")) {
            String stringExtra = intent.getStringExtra("state");
            if (TextUtils.isEmpty(stringExtra)) {
                f.c("PhoneReceiver", "Recieved an empty phone state");
            } else if (stringExtra.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                f.d("PhoneReceiver", "Received 'Idle' event");
                a(context);
            } else if (stringExtra.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                stringExtra = intent.getStringExtra("incoming_number");
                String a = c.a(context, stringExtra);
                f.d("PhoneReceiver", "Received 'Ringing' event callingNumber = " + stringExtra + " callingName = " + a);
                a(stringExtra, a);
            } else if (stringExtra.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                f.d("PhoneReceiver", "Received 'Offhook' event");
                b();
            } else {
                f.d("PhoneReceiver", "Don't know how to handle this telephony intent: " + intent.toUri(1));
            }
        }
    }

    boolean a() {
        return com.getpebble.android.notifications.b.b.a();
    }

    protected void a(k kVar) {
        if (c != null) {
            c.b(true);
        } else {
            f.a("PhoneReceiver", "sendToConnectedDevices() sCsm is null");
        }
        for (com.getpebble.android.framework.b.a a : com.getpebble.android.framework.b.a.b()) {
            a.a(kVar, null);
        }
    }

    private static void b(Context context) {
        if (d != 9999) {
            AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
            f.d("PhoneReceiver", "Restoring ringer mode to " + d);
            audioManager.setRingerMode(d);
            d = 9999;
        }
    }
}
