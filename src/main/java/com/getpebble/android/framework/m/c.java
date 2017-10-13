package com.getpebble.android.framework.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.service.LocaleChangedService;

public class c extends BroadcastReceiver {
    public c(Context context) {
        context.registerReceiver(this, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            f.d("LocaleChangedReceiver", "onReceive: intent is null");
        } else if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
            f.d("LocaleChangedReceiver", ":onReceive: Locale changed");
            context.startService(new Intent(context, LocaleChangedService.class));
        }
    }
}
