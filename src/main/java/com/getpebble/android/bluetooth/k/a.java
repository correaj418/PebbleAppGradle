package com.getpebble.android.bluetooth.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.getpebble.android.bluetooth.j.a.b;
import com.getpebble.android.common.b.a.f;
import java.lang.ref.WeakReference;

public abstract class a extends BroadcastReceiver {
    private WeakReference<Context> a = null;
    private int b = -1;

    public abstract void a(com.getpebble.android.bluetooth.j.a.a aVar);

    public a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.BLE_STATE_CHANGED");
        context.registerReceiver(this, intentFilter);
        this.a = new WeakReference(context);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            if (intExtra != this.b) {
                this.b = intExtra;
                com.getpebble.android.bluetooth.j.a.a from = com.getpebble.android.bluetooth.j.a.a.from(b.fromCode(intExtra));
                if (from.equals(com.getpebble.android.bluetooth.j.a.a.UNKNOWN)) {
                    f.f("AdapterStateReceiver", "Unexpected AdapterState " + intExtra);
                } else {
                    a(from);
                }
            }
        }
    }
}
