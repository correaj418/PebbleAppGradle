package com.getpebble.android.framework.m;

import android.content.Context;
import android.content.IntentFilter;
import com.google.android.gms.gcm.c;

public class g extends c {
    public g(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.c2dm.intent.RECEIVE");
        intentFilter.addAction("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory("com.getpebble.android.gcm");
        context.registerReceiver(this, intentFilter, "com.google.android.c2dm.permission.SEND", null);
    }
}
