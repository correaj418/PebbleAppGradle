package com.getpebble.android.framework.m;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.au;
import com.getpebble.android.h.a;

public class b extends BroadcastReceiver {
    @SuppressLint({"InlinedApi"})
    public b(Context context) {
        context.registerReceiver(this, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
    }

    public void onReceive(Context context, Intent intent) {
        boolean booleanValue = a.b(context).booleanValue();
        f.d("IdleModeReceiver", "Received: " + intent.getAction() + " deviceIdle = " + booleanValue);
        au.a(booleanValue ? au.a.ENTERED_IDLE_MODE : au.a.EXITED_IDLE_MODE, context.getContentResolver());
    }
}
