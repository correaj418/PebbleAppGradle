package com.getpebble.android.framework.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.location.PebbleLocationService;

public class a extends BroadcastReceiver {
    public a(Context context) {
        context.registerReceiver(this, new IntentFilter("android.intent.action.AIRPLANE_MODE"));
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra("state")) {
            boolean booleanExtra = intent.getBooleanExtra("state", false);
            f.c("AirplaneModeReceiver", "Airplane mode changed: enabled = " + booleanExtra);
            if (!booleanExtra) {
                f.d("AirplaneModeReceiver", "Requesting location update after exiting airplane mode");
                PebbleLocationService.b();
                f.d("AirplaneModeReceiver", "Requesting sync after exiting airplane mode");
                PebbleApplication.v().a();
                return;
            }
            return;
        }
        f.b("AirplaneModeReceiver", "no state extra");
    }
}
