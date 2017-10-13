package com.getpebble.android.framework.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.getpebble.android.common.a;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.h.o;

public class f extends BroadcastReceiver {
    private static final String a = f.class.getSimpleName();
    private FrameworkState b = null;

    public f(FrameworkState frameworkState) {
        if (frameworkState == null) {
            throw new IllegalArgumentException("'frameworkState' cannot be null!");
        }
        this.b = frameworkState;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        a.K().registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            com.getpebble.android.common.b.a.f.d(a, "onReceive() intent is null");
        } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            com.getpebble.android.common.b.a.f.d(a, "Network state changed");
            this.b.a(o.a());
        }
    }

    public void a() {
        Context K = a.K();
        if (K != null) {
            K.unregisterReceiver(this);
        }
    }
}
