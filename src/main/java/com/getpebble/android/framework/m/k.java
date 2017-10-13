package com.getpebble.android.framework.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.b.a;
import java.util.Set;

public class k extends BroadcastReceiver {
    public k(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        context.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            f.b("TimeReceiver", "Received null intent; dropping");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            f.b("TimeReceiver", "Intent has null action");
            return;
        }
        Object obj = (action.equals("android.intent.action.TIME_SET") || action.equals("android.intent.action.TIMEZONE_CHANGED")) ? 1 : null;
        if (obj == null) {
            f.b("TimeReceiver", "Action is not time changed: " + action);
            return;
        }
        f.b("TimeReceiver", "Time changed");
        for (a a : a()) {
            a.a(new com.getpebble.android.framework.g.k(com.getpebble.android.bluetooth.g.a.TIME, com.getpebble.android.framework.g.k.a.SEND_SET_TIME_MESSAGE), null);
        }
    }

    protected Set<a> a() {
        return a.b();
    }
}
